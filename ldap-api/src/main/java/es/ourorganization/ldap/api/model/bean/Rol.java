package es.ourorganization.ldap.api.model.bean;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Rol
{
	private String name;
	private List<Person> members;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Person> getMembers() {
		return members;
	}
	public void setMembers(List<Person> members) {
		this.members = members;
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
