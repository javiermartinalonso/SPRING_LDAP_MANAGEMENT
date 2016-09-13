package es.organization.ldap.model.bean;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Person
{

	private String				userName;

	private String				pass;

	private String				firstName;

	private String				lastName;

	private ContactInformation	personalContact;

	private ContactInformation	professionalContact;

	private String				description;


	public Person()
	{
		super();

		this.personalContact = new ContactInformation();
		this.professionalContact = new ContactInformation();
		;
	}


	public Person(String userName, String pass, String firstName, String lastName, ContactInformation personalContact, ContactInformation professionalContact, String description)
	{
		super();
		this.userName = userName;
		this.pass = pass;
		this.firstName = firstName;
		this.lastName = lastName;
		this.personalContact = personalContact;
		this.professionalContact = professionalContact;
		this.description = description;
	}


	public String getName()
	{
		return firstName;
	}


	public void setName(String name)
	{
		this.firstName = name;
	}


	public String getPass()
	{
		return pass;
	}


	public void setPass(String pass)
	{
		this.pass = pass;
	}


	public String getUserName()
	{
		return userName;
	}


	public void setUserName(String userName)
	{
		this.userName = userName;
	}


	public String getFirstName()
	{
		return firstName;
	}


	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}


	public String getLastName()
	{
		return lastName;
	}


	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}


	public ContactInformation getPersonalContact()
	{
		return personalContact;
	}


	public void setPersonalContact(ContactInformation personalContact)
	{
		this.personalContact = personalContact;
	}


	public ContactInformation getProfessionalContact()
	{
		return professionalContact;
	}


	public void setProfessionalContact(ContactInformation professionalContact)
	{
		this.professionalContact = professionalContact;
	}


	public String getDescription()
	{
		return description;
	}


	public void setDescription(String description)
	{
		this.description = description;
	}


	@Override
	public String toString()
	{
		ObjectMapper mapper = new ObjectMapper();

		// Object to JSON in String
		try
		{
			return mapper.writeValueAsString(this);
		}
		catch (JsonProcessingException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "";

	}
}