package es.ourorganization.ldap.api.model.bean;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Group
{
	private String name;
	private String displayName;
	private String Description;
	private String father;
	private List<Group> groups;
	private List<Rol> members;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getDescription() {
		return Description;
	}
	public String getFather()
	{
		return father;
	}
	public void setFather(String father)
	{
		this.father = father;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public List<Group> getGroups() {
		return groups;
	}
	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}
	public List<Rol> getMembers() {
		return members;
	}
	public void setMembers(List<Rol> members) {
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
