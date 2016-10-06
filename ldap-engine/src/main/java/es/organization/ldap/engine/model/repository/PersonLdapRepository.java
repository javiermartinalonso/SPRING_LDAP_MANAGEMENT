package es.organization.ldap.engine.model.repository;

import static org.springframework.ldap.query.LdapQueryBuilder.query;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.ldap.LdapName;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.filter.AndFilter;
import org.springframework.ldap.filter.EqualsFilter;
import org.springframework.ldap.support.LdapNameBuilder;

import es.organization.ldap.model.bean.Person;
import es.organization.ldap.model.repository.PersonRepository;

public class PersonLdapRepository implements PersonRepository
{
	//LOGGING
	private static final Logger	LOGGER	= LoggerFactory.getLogger(PersonLdapRepository.class);

	/**
	 * Básicamente, se apoya en una clase de plantilla de Spring para realizar
	 * las consultas al servidor ldap y se encarga de mapear el resultado de las
	 * consultas en un objeto de tipo Person (lo que haría un típico Dao).
	 */
	private LdapTemplate		ldapTemplate;

	public LdapTemplate getLdapTemplate()
	{
		return ldapTemplate;
	}
	
	public void setLdapTemplate(LdapTemplate ldapTemplate)
	{
		this.ldapTemplate = ldapTemplate;
	}
	
	/**
	 * Constructor a partir de un LdapTemplate

	@Autowired
	public PersonLdapRepository(LdapTemplate ldapTemplate)
	{
		this.ldapTemplate = ldapTemplate;
	}
	 */

	/**
	 * Crea una nueva persona en el LDAP con el objeto person pasado como parametro
	 * 
	 * @param Person person
	 */
	@Override
	public void insert(Person person)
	{
		LOGGER.info("Insertar Usuario: 'uid= " + person.getFullName() + "'\n");
		
		ldapTemplate.create(person);
	}
	
	
	/**
	 * Actualiza los datos de una persona del LDAP cuyo identificador coincida
	 * con el del objeto person pasado como parámetro, actualizando los datos
	 * con los del objeto person.
	 * 
	 * @param Person person
	 */
	@Override
	public void update(Person person)
	{
		LOGGER.info("Actualizar Usuario: 'uid= " + person.getFullName() + "'\n");

		ldapTemplate.update(person);
	}
	
	
	/**
	 * Elimina una persona del LDAP cuyo identificador coincida con el del
	 * objeto person pasado como parámetro
	 * 
	 * @param Person person
	 */
	@Override
	public void delete(Person person)
	{
		LOGGER.info("Borrar Usuario: 'uid= " + person.getFullName() + "'");

		ldapTemplate.delete(ldapTemplate.findByDn(buildDn(person), Person.class));
//		ldapTemplate.delete(ldapTemplate.findByDn(buildDn(person), Person.class));
		//TODO ver como calcular el DN de una persona realmente
//		ldapTemplate.delete(ldapTemplate.findByDn(person.getDn(), Person.class));
	}
	
	
	/**
	 * Obtiene una lista con el nombre de todas las personas existentes en el LDAP
	 */
	@Override
	public List<String> getAllPersonNames()
	{
		LOGGER.info("Consultando el nombre de todas las personas existentes en el LDAP");
		
		return ldapTemplate.search(query().attributes("cn").where("objectclass").is("person"), 
				new AttributesMapper<String>()
					{
						public String mapFromAttributes(Attributes attrs) throws NamingException
						{
							return attrs.get("cn").get().toString();
						}
					});
	}
	
	


	/**
	 * Obtiene una lista con todas las personas existentes en el LDAP
	 */
	@Override
	public List<Person> findAll()
	{
		LOGGER.info("Obteniendo todos los objetos Person existentes en el LDAP");
		
		return ldapTemplate.findAll(Person.class);
	}

	/**
	 * Obtiene una Persona del LDAP con el dn formado por los siguientes parametros
	 */
//	@Override
//	public Person findByPrimaryKey(String company, String path, String fullname)
//	{
//		LdapName dn = buildDn(fullname);
//		Person person = ldapTemplate.findByDn(dn, Person.class);
//
//		return person;
//	}
	 
	
	/**
	 * Devuelve la lista de personas que contiene la persona cuyo id coincide
	 * con el que se pasa como parámetro
	 * 
	 * @param String userId
	 * @return List<Person>
	 */
	@Override
	public List<Person> getByUID(String userId)
	{
//		return ldapTemplate.search("", "(uid=" + userId + ")", personMapper());
		return ldapTemplate.search("", "(cn=" + userId + ")", personMapper());
		
	}


	/**
	 * Devuelve la lista de personas que contiene el grupo cuyo id se pasa como
	 * parámetro
	 * 
	 * @param String groupId
	 * @return List<Person>
	 */
	@Override
	public List<Person> getByGroupUID(String groupId)
	{
		final List<Person> persons = new ArrayList<Person>();

		final List<String> userIds = (List<String>) ldapTemplate.search("", "(&(objectClass=groupOfNames)(cn=" + groupId + "))", groupMapper()).get(0);

		LOGGER.info("LDAP Persons in  '" + groupId + "'");

		for (String userId : userIds)
		{
			LOGGER.info("Usuario: 'uid= " + userId + "'");
			persons.add(getByUID(userId).get(0));
		}

		return persons;
	}


	/**
	 * Te devuelve una lista de personas del LDAP, donde coincidan con los pares
	 * de atributo/valor pasados como filtro a traves de un Map
	 * 
	 * @param Map<String, String> filter
	 * @return List<Person>
	 */
	@Override
	public List<Person> getByFilter(Map<String, String> filter)
	{
		AndFilter andFilter = new AndFilter();
		andFilter.and(new EqualsFilter("objectclass", "person"));

		// Recorremos los elementos que forman el filtro
		Iterator<String> it = filter.keySet().iterator();

		while (it.hasNext())
		{
			String key = (String) it.next();

			//	andFilter.and(new EqualsFilter("sn", lastName));
			andFilter.and(new EqualsFilter(key, filter.get(key)));
		}

		LOGGER.info("LDAP Query " + andFilter.encode());

		return ldapTemplate.search("", andFilter.encode(), personMapper());
	}




	//TODO esto está mal
	/**
	 * A partir de un objeto Person construye su DN
	 **/
	private LdapName buildDn(Person person)
	{
//		return buildDn(person.getCompany(), person.getPath(), person.getFullName());
		return LdapNameBuilder.newInstance().add("ou", "acme").add("ou", "people").add("cn", person.getFullName()).build();
	}
//TODO esto está mal
	/**
	 * A partir de los atributos sueltos de un objeto Person construye su DN
	 **/
//	private LdapName buildDn(String company, String path, String fullname)
//	{
//		return LdapNameBuilder.newInstance().add("ou", company).add("ou", path).add("cn", fullname).build();
//	}
	
	
	
	
	
	
	/**
	 * 
	 * @return
	 */
	private AttributesMapper<Person> personMapper()
	{
		return new AttributesMapper<Person> ()
		{

			@Override
			public Person mapFromAttributes(final Attributes attributes) throws NamingException
			{
				final Person person = new Person();
				
				//TODO revisar el conjunto de atributos a mapear
				person.setDn(LdapNameBuilder.newInstance().add("ou", "acme").add("ou", "people").add("cn", (String) attributes.get("cn").get()).build());
//				person.setPath(LdapNameBuilder.newInstance().add("ou", "acme").add("ou", "people").build());
				person.setFullName((String) attributes.get("cn").get());
				person.setLastName((String) attributes.get("sn").get());
				person.setEmail((String) attributes.get("mail").get());
				
				return person;
			}
		};
	}

//TODO revisar el conjunto de atributos a mapear
	private Person dataFactoryPerson(String nombre)
	{
		Person person = new Person();
//		person.setCompany("acme");
//		person.setPath("people");
		person.setDn(LdapNameBuilder.newInstance().add("ou", "acme").add("ou", "people").add("cn", nombre).build());
		person.setFullName(nombre);
//		person.setUserName(nombre);
//		person.setName(nombre);
		person.setLastName(nombre);
//		person.getProfessionalContact().setEmail(nombre);
		person.setEmail(nombre);
		return person;
	}
	
	private AttributesMapper<List<String>> groupMapper()
	{
		return new AttributesMapper<List<String>>()
		{

			@Override
			public List<String> mapFromAttributes(final Attributes attributes) throws NamingException
			{
				final List<String> userIds = new ArrayList<String>();
				final NamingEnumeration<?> uniquemembers = attributes.get("uniquemember").getAll();
				while (uniquemembers.hasMore())
				{
					String userId = uniquemembers.next().toString().split(",")[0].split("=")[1];
					userIds.add(userId);
				}
				return userIds;
			}
		};
	}

}