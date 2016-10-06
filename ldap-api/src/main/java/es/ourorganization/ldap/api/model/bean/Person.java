package es.ourorganization.ldap.api.model.bean;

import javax.naming.Name;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.springframework.ldap.odm.annotations.Attribute;
import org.springframework.ldap.odm.annotations.DnAttribute;
import org.springframework.ldap.odm.annotations.Entry;
import org.springframework.ldap.odm.annotations.Id;
import org.springframework.ldap.odm.annotations.Transient;
import org.springframework.ldap.support.LdapNameBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Entry(objectClasses =
	{
			"top", "inetOrgPerson", "person", "organizationalPerson"
	})
public class Person
{
	@Id
	private Name	dn;

	@Attribute(name = "cn")
	@DnAttribute(value = "cn", index = 2)
	private String	fullName;

	@Attribute(name = "sn")
	private String	lastName;
	
//	@Attribute(name = "description")
//	private String	description;
	
	@Transient
	@DnAttribute(value = "ou", index = 1)
	private String	company = "people";
	
	@Transient
	@DnAttribute(value = "ou", index = 0)
	private String	path = "acme";

//	@Attribute(name = "telephoneNumber")
//	private String	phone;

//	private String	userName;

//	private String	pass;

//	private String	firstName;




	//	private ContactInformation	personalContact;
	//
	//	private ContactInformation	professionalContact;



	private String	mail;


	public Person()
	{
		super();

		//		this.personalContact = new ContactInformation();
		//		this.professionalContact = new ContactInformation();
	}


	//	public Person(String userName, String pass, String firstName, String lastName, ContactInformation personalContact, ContactInformation professionalContact, String description)
	public Person(String fullName, String lastName, String email)
//	public Person(String userName, String pass, String firstName, String lastName, String description, String email)
	{
		super();
		this.fullName = fullName;
		this.dn = LdapNameBuilder.newInstance().add("ou", "acme").add("ou", "people").add("cn", fullName).build();
//		this.path = LdapNameBuilder.newInstance().add("ou", "acme").add("ou", "people").build();
		this.lastName = lastName;

		this.mail = email;
	}


	public Name getDn()
	{
		return dn;
	}


	public void setDn(Name dn)
	{
		this.dn = dn;
	}


//	public String getName()
//	{
//		return firstName;
//	}
//
//
//	public void setName(String name)
//	{
//		this.firstName = name;
//	}


	public String getFullName()
	{
		return fullName;
	}


	public void setFullName(String fullName)
	{
		this.fullName = fullName;
	}


//	public Name getPath()
//	{
//		return path;
//	}
//
//	public void setPath(Name path)
//	{
//		this.path = path;
//	}


//	public String getCompany()
//	{
//		return company;
//	}
//
//
//	public void setCompany(String company)
//	{
//		this.company = company;
//	}
//
//
//	public String getPass()
//	{
//		return pass;
//	}
//
//
//	public void setPass(String pass)
//	{
//		this.pass = pass;
//	}


//	public String getUserName()
//	{
//		return userName;
//	}
//
//
//	public void setUserName(String userName)
//	{
//		this.userName = userName;
//	}


//	public String getFirstName()
//	{
//		return firstName;
//	}
//
//
//	public void setFirstName(String firstName)
//	{
//		this.firstName = firstName;
//	}


	public String getLastName()
	{
		return lastName;
	}


	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}


	//	public ContactInformation getPersonalContact()
	//	{
	//		return personalContact;
	//	}
	//
	//
	//	public void setPersonalContact(ContactInformation personalContact)
	//	{
	//		this.personalContact = personalContact;
	//	}
	//
	//
	//	public ContactInformation getProfessionalContact()
	//	{
	//		return professionalContact;
	//	}
	//
	//
	//	public void setProfessionalContact(ContactInformation professionalContact)
	//	{
	//		this.professionalContact = professionalContact;
	//	}

	public String getEmail()
	{
		return mail;
	}


	public void setEmail(String email)
	{
		this.mail = email;
	}


//	public String getDescription()
//	{
//		return description;
//	}
//
//
//	public void setDescription(String description)
//	{
//		this.description = description;
//	}


	public boolean equals(Object obj)
	{
		return EqualsBuilder.reflectionEquals(this, obj);
	}


	public int hashCode()
	{
		return HashCodeBuilder.reflectionHashCode(this);
	}


	//	public String toString()
	//	{
	//		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	//	}
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