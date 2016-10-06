package es.ourorganization.ldap.api.model.bean;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Organization
{
	private String name;
	private String displayName;
	private String Description;
	private String distinguishedName;
	private String relativeDistinguishedName;

	private List<Organization> listaOrganizaciones;
	private List<Group> groups;
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
	public void setDescription(String description) {
		Description = description;
	}
	public String getDistinguishedName() {
		return distinguishedName;
	}
	public void setDistinguishedName(String distinguishedName) {
		this.distinguishedName = distinguishedName;
	}
	public String getRelativeDistinguishedName() {
		return relativeDistinguishedName;
	}
	public void setRelativeDistinguishedName(String relativeDistinguishedName) {
		this.relativeDistinguishedName = relativeDistinguishedName;
	}
	public List<Organization> getListaOrganizaciones() {
		return listaOrganizaciones;
	}
	public void setListaOrganizaciones(List<Organization> listaOrganizaciones) {
		this.listaOrganizaciones = listaOrganizaciones;
	}
	public List<Group> getGroups() {
		return groups;
	}
	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}
	
	
	//POR LO MENOS DEBERIA TENER EL GRUPO people y system. 
	//Usuarios que existen en la organizacion 
	//y usuario administrador de la organizacion
	
	
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
