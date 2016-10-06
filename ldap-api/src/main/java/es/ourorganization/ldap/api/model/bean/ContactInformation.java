package es.ourorganization.ldap.api.model.bean;

import org.springframework.ldap.odm.annotations.Attribute;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ContactInformation
{
	private String	email;
	
	@Attribute(name = "telephoneNumber")
	private String	phone;
	
	private String	mobile;
	
	private String	fax;
	
	private String	website;
	
	private String	building;
	
	private String	room;
	
	private String	address;
	
	private String	city;
	
	private String	state;
	
	private String	Zip;
	
	private String	Country;
	
	private String	userName;

	private String	pass;
	
	private String	firstName;

	private String	lastName;

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getPhone()
	{
		return phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	public String getMobile()
	{
		return mobile;
	}

	public void setMobile(String mobile)
	{
		this.mobile = mobile;
	}

	public String getFax()
	{
		return fax;
	}

	public void setFax(String fax)
	{
		this.fax = fax;
	}

	public String getWebsite()
	{
		return website;
	}

	public void setWebsite(String website)
	{
		this.website = website;
	}

	public String getBuilding()
	{
		return building;
	}

	public void setBuilding(String building)
	{
		this.building = building;
	}

	public String getRoom()
	{
		return room;
	}

	public void setRoom(String room)
	{
		this.room = room;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public String getState()
	{
		return state;
	}

	public void setState(String state)
	{
		this.state = state;
	}

	public String getZip()
	{
		return Zip;
	}

	public void setZip(String zip)
	{
		Zip = zip;
	}

	public String getCountry()
	{
		return Country;
	}

	public void setCountry(String country)
	{
		Country = country;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getPass()
	{
		return pass;
	}

	public void setPass(String pass)
	{
		this.pass = pass;
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
	
	@Override
	public String toString()
	{
		ObjectMapper mapper = new ObjectMapper();
		
		//Object to JSON in String
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
