package es.organization.ldap.engine.model.repository.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.BasicAttribute;
import javax.naming.directory.BasicAttributes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.core.DistinguishedName;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.filter.AndFilter;
import org.springframework.ldap.filter.EqualsFilter;

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


	/**
	 * Constructor a partir de un LdapTemplate
	 */
	@Autowired
	public PersonLdapRepository(LdapTemplate ldapTemplate)
	{
		this.ldapTemplate = ldapTemplate;
	}


	/**
	 * Devuelve la lista de personas que contiene la persona cuyo id coincide
	 * con el que se pasa como parámetro
	 * 
	 * @param String userId
	 * @return List<Person>
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Person> getByUID(String userId)
	{
		return ldapTemplate.search("", "(uid=" + userId + ")", personMapper());
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

		@SuppressWarnings("unchecked")
		final List<String> userIds = (List<String>) ldapTemplate.search("", "(&(objectClass=group)(cn=" + groupId + "))", groupMapper()).get(0);

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


	/**
	 * Elimina una persona del LDAP cuyo identificador coincida con el del
	 * objeto person pasado como parámetro
	 * 
	 * @param Person person
	 */
	@Override
	public void deletePerson(Person person)
	{
		DistinguishedName newContactDN = new DistinguishedName("ou=people");
		newContactDN.add("uid", person.getUserName());

		LOGGER.info("Borrar Usuario: 'uid= " + person.getUserName() + "'");

		ldapTemplate.unbind(newContactDN);
	}


	/**
	 * Crea una nueva persona en el LDAP con el del objeto person pasado como
	 * parámetro
	 * 
	 * @param Person person
	 */
	@Override
	public void insertPerson(Person person)
	{

		Attributes personAttributes = new BasicAttributes();
		BasicAttribute personBasicAttribute = new BasicAttribute("objectclass");
		personBasicAttribute.add("person");
		personAttributes.put(personBasicAttribute);
		personAttributes.put("uid", person.getUserName());
		personAttributes.put("cn", person.getName());
		personAttributes.put("mail", person.getProfessionalContact().getEmail());

		DistinguishedName newPersonDN = new DistinguishedName("ou=people");
		newPersonDN.add("uid", person.getUserName());

		LOGGER.info("Insertar Usuario: 'uid= " + person.getUserName() + "'\n");

		ldapTemplate.bind(newPersonDN, null, personAttributes);
	}


	/**
	 * Actualiza los datos de una persona del LDAP cuyo identificador coincida
	 * con el del objeto person pasado como parámetro, actualizando los datos
	 * con los del objeto person.
	 * 
	 * @param Person person
	 */
	@Override
	public void updatePerson(Person person)
	{
		Attributes personAttributes = new BasicAttributes();
		BasicAttribute personBasicAttribute = new BasicAttribute("objectclass");
		personBasicAttribute.add("person");
		personAttributes.put(personBasicAttribute);
		personAttributes.put("uid", person.getUserName());
		personAttributes.put("cn", person.getName());
		personAttributes.put("mail", person.getProfessionalContact().getEmail());

		DistinguishedName newPersonDN = new DistinguishedName("ou=people");
		newPersonDN.add("uid", person.getUserName());

		LOGGER.info("Actualizar Usuario: 'uid= " + person.getUserName() + "'\n");

		ldapTemplate.rebind(newPersonDN, null, personAttributes);

	}


	private AttributesMapper personMapper()
	{
		return new AttributesMapper()
		{

			@Override
			public Person mapFromAttributes(final Attributes attributes) throws NamingException
			{
				final Person person = new Person();
				person.setUserName((String) attributes.get("uid").get());
				person.setName((String) attributes.get("cn").get());
				person.getProfessionalContact().setEmail((String) attributes.get("mail").get());
				return person;
			}
		};
	}


	private AttributesMapper groupMapper()
	{
		return new AttributesMapper()
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