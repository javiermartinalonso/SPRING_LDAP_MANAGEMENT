package es.organization.ldap.engine.model.repository.test;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import es.organization.ldap.model.bean.Person;
import es.organization.ldap.model.repository.PersonRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-config/ldapServer.xml", "classpath:spring-config/ldapContext.xml"})
public class PersonLdapRepositoryTest
{

	@Autowired
	private PersonRepository personRepository;


	@Test
	public void shouldFindUserById()
	{
		final String userId = "u123456789a";
		final List<Person> persons = personRepository.getByUID(userId);
		assertEquals(1, persons.size());
		assertEquals("Javier Martin Alonso", persons.get(0).getName());
	}


	@Test 
	public void shouldFindUsersByGroupId()
	{
		final String groupId = "user";
		final List<Person> persons = personRepository.getByGroupUID(groupId);
		assertEquals(2, persons.size());
	}
	
	@Test 
	public void shouldFindUsersByFilter()
	{
		Map<String, String> filter = new HashMap<String, String>();
		filter.put("cn", "Javier Martin Alonso");
		filter.put("sn", "Martin Alonso");
		
		final List<Person> persons = personRepository.getByFilter(filter);
		assertEquals("Javier Martin Alonso", persons.get(0).getName());
	}
	
	
	@Test
	public void shouldInsert()
	{
		Person person = new Person();
		person.setUserName("persona_uno");
		person.setName("persona_uno");
		person.getProfessionalContact().setEmail("persona_uno");
		
		List<Person> persons = personRepository.getByUID(person.getUserName());
		assertEquals(0, persons.size());
		
		personRepository.insertContact(person);
		
		persons = personRepository.getByUID(person.getUserName());
		assertEquals(1, persons.size());
		
		personRepository.deleteContact(persons.get(0));
		
		persons = personRepository.getByUID(person.getUserName());
		assertEquals(0, persons.size());
	}
	
	@Test
	public void shouldUpdate()
	{		
		Person person = new Person();
		person.setUserName("persona_update");
		person.setName("persona_update");
		person.getProfessionalContact().setEmail("persona_update");
		
		
		List<Person> persons = personRepository.getByUID(person.getUserName());
		assertEquals(0, persons.size());
		
		personRepository.insertContact(person);
		
		persons = personRepository.getByUID(person.getUserName());
		assertEquals(1, persons.size());
		
		person.setName("persona_update2");
		person.getProfessionalContact().setEmail("persona_update2");
		
		personRepository.updateContact(person);
		
		Map<String, String> filter = new HashMap<String, String>();
		filter.put("cn", "persona_update2");
		filter.put("mail", "persona_update2");
		
		persons = personRepository.getByFilter(filter);
		
		assertEquals(1, persons.size());
		
		personRepository.deleteContact(persons.get(0));
		
		persons = personRepository.getByUID(person.getUserName());
		assertEquals(0, persons.size());
		
	}
	
	@Test
	public void shouldDeleteUser()
	{
		Person person = new Person();
		person.setUserName("persona_borrar");
		person.setName("persona_borrar");
		person.getProfessionalContact().setEmail("persona_borrar");
				
		List<Person> persons = personRepository.getByUID(person.getUserName());
		assertEquals(0, persons.size());
		
		personRepository.insertContact(person);
		
		persons = personRepository.getByUID(person.getUserName());
		assertEquals(1, persons.size());
		
		personRepository.deleteContact(persons.get(0));
		
		persons = personRepository.getByUID(person.getUserName());
		assertEquals(0, persons.size());
	}
}