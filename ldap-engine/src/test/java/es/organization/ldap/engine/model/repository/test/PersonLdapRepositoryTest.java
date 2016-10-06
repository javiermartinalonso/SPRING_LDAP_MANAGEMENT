package es.organization.ldap.engine.model.repository.test;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import es.organization.ldap.engine.model.repository.PersonLdapRepository;
import es.organization.ldap.model.bean.Person;

@ContextConfiguration(locations =
{
		"/spring-config-test/testContext.xml"
})
public class PersonLdapRepositoryTest extends AbstractJUnit4SpringContextTests
{

	@Autowired
	private PersonLdapRepository personLdapRepository;

	
	public PersonLdapRepository getPersonLdapRepository()
	{
		return personLdapRepository;
	}


	public void setPersonLdapRepository(PersonLdapRepository personLdapRepository)
	{
		this.personLdapRepository = personLdapRepository;
	}


	@Test
	public void shouldInsert()
	{
		Person person = dataFactoryPerson("persona_uno");
		
		System.out.println(person.toString());
		
		List<Person> persons = personLdapRepository.getByUID(person.getFullName());
		System.out.println(persons.toString());
		assertEquals(0, persons.size());

		personLdapRepository.insert(person);

		persons = personLdapRepository.getByUID(person.getFullName());
		assertEquals(1, persons.size());

		personLdapRepository.delete(persons.get(0));

		persons = personLdapRepository.getByUID(person.getFullName());
		System.out.println(persons.toString());
		assertEquals(0, persons.size());
	}


	@Test
	public void shouldUpdate()
	{
		Person person = dataFactoryPerson("persona_update");
				
		List<Person> persons = personLdapRepository.getByUID(person.getFullName());
		System.out.println(persons.toString());
		assertEquals(0, persons.size());

		personLdapRepository.insert(person);

		persons = personLdapRepository.getByUID(person.getFullName());
		System.out.println(persons.toString());
		assertEquals(1, persons.size());

//		person.setName("persona_update2");
//		person.getProfessionalContact().setEmail("persona_update2");
		person.setEmail("persona_update2");		

		personLdapRepository.update(person);

		Map<String, String> filter = new HashMap<String, String>();
//		filter.put("cn", "persona_update2");
		filter.put("mail", "persona_update2");

		persons = personLdapRepository.getByFilter(filter);
		System.out.println(persons.toString());
		assertEquals(1, persons.size());

		personLdapRepository.delete(persons.get(0));

		persons = personLdapRepository.getByUID(person.getFullName());
		System.out.println(persons.toString());
		assertEquals(0, persons.size());

	}

	
	@Test
	public void shouldDelete()
	{
		Person person = dataFactoryPerson("persona_borrar");

		List<Person> persons = personLdapRepository.getByUID(person.getFullName());
		System.out.println(persons.toString());
		assertEquals(0, persons.size());

		personLdapRepository.insert(person);

		persons = personLdapRepository.getByUID(person.getFullName());
		System.out.println(persons.toString());
		assertEquals(1, persons.size());

		personLdapRepository.delete(persons.get(0));

		persons = personLdapRepository.getByUID(person.getFullName());
		System.out.println(persons.toString());
		assertEquals(0, persons.size());
	}


	private Person dataFactoryPerson(String nombre)
	{
		Person person = new Person(nombre, nombre, nombre);
		
		return person;
	}
	
	@Test
	public void shouldGetAllPersonNames()
	{
		//TODO
	}
	
	
	@Test
	public void shouldFindAll()
	{
		//TODO
	}	
	
	@Test
	public void shouldFindUserById()
	{
		final String userId = "John Smith";
		final List<Person> persons = personLdapRepository.getByUID(userId);
		assertEquals(4, persons.size());
		System.out.println(persons.get(0).toString());
		assertEquals("John Smith", persons.get(0).getFullName());
	}


	@Test
	public void shouldFindUsersByGroupId()
	{
		//TODO no funciona
//		final String groupId = "ROLE_USER";
//		final List<Person> persons = personLdapRepository.getByGroupUID(groupId);
//		System.out.println(persons.toString());
//		assertEquals(2, persons.size());
	}


	@Test
	public void shouldFindUsersByFilter()
	{
		Map<String, String> filter = new HashMap<String, String>();
		filter.put("cn", "John Smith");
		filter.put("sn", "Smith");

		final List<Person> persons = personLdapRepository.getByFilter(filter);
		System.out.println(persons.toString());
		assertEquals("John Smith", persons.get(0).getFullName());
	}
}