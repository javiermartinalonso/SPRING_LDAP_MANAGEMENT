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
		Person person = new Person();
		person.setUserName("persona_uno");
		person.setName("persona_uno");
//		person.getProfessionalContact().setEmail("persona_uno");
		person.setEmail("persona_uno");
		System.out.println(person.toString());
		
		List<Person> persons = personLdapRepository.getByUID(person.getUserName());
		System.out.println(persons.toString());
		assertEquals(0, persons.size());

		personLdapRepository.insert(person);

		persons = personLdapRepository.getByUID(person.getUserName());
		assertEquals(1, persons.size());

		personLdapRepository.delete(persons.get(0));

		persons = personLdapRepository.getByUID(person.getUserName());
		System.out.println(persons.toString());
		assertEquals(0, persons.size());
	}


	@Test
	public void shouldUpdate()
	{
		Person person = new Person();
		person.setUserName("persona_update");
		person.setName("persona_update");
//		person.getProfessionalContact().setEmail("persona_update");
		person.setEmail("persona_update");
		
		List<Person> persons = personLdapRepository.getByUID(person.getUserName());
		System.out.println(persons.toString());
		assertEquals(0, persons.size());

		personLdapRepository.insert(person);

		persons = personLdapRepository.getByUID(person.getUserName());
		System.out.println(persons.toString());
		assertEquals(1, persons.size());

		person.setName("persona_update2");
//		person.getProfessionalContact().setEmail("persona_update2");
		person.setEmail("persona_update2");		

		personLdapRepository.update(person);

		Map<String, String> filter = new HashMap<String, String>();
		filter.put("cn", "persona_update2");
		filter.put("mail", "persona_update2");

		persons = personLdapRepository.getByFilter(filter);
		System.out.println(persons.toString());
		assertEquals(1, persons.size());

		personLdapRepository.delete(persons.get(0));

		persons = personLdapRepository.getByUID(person.getUserName());
		System.out.println(persons.toString());
		assertEquals(0, persons.size());

	}


	@Test
	public void shouldDelete()
	{
		Person person = new Person();
		person.setCompany("acme");
		person.setPath("people");
		person.setFullName("persona_borrar");
		person.setUserName("persona_borrar");
		person.setName("persona_borrar");
//		person.getProfessionalContact().setEmail("persona_borrar");
		person.setEmail("persona_borrar");

		List<Person> persons = personLdapRepository.getByUID(person.getUserName());
		System.out.println(persons.toString());
		assertEquals(0, persons.size());

		personLdapRepository.insert(person);

		persons = personLdapRepository.getByUID(person.getUserName());
		System.out.println(persons.toString());
		assertEquals(1, persons.size());

		personLdapRepository.delete(persons.get(0));

		persons = personLdapRepository.getByUID(person.getUserName());
		System.out.println(persons.toString());
		assertEquals(0, persons.size());
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
		final String userId = "u123456789a";
		final List<Person> persons = personLdapRepository.getByUID(userId);
		assertEquals(1, persons.size());
		System.out.println(persons.get(0).toString());
		assertEquals("Javier Martin Alonso", persons.get(0).getName());
	}


	@Test
	public void shouldFindUsersByGroupId()
	{
		final String groupId = "user";
		final List<Person> persons = personLdapRepository.getByGroupUID(groupId);
		System.out.println(persons.toString());
		assertEquals(2, persons.size());
	}


	@Test
	public void shouldFindUsersByFilter()
	{
		Map<String, String> filter = new HashMap<String, String>();
		filter.put("cn", "Javier Martin Alonso");
		filter.put("sn", "Martin Alonso");

		final List<Person> persons = personLdapRepository.getByFilter(filter);
		System.out.println(persons.toString());
		assertEquals("Javier Martin Alonso", persons.get(0).getName());
	}
}