package es.organization.ldap.model.bean;

import java.util.List;

public class Organization
{
	private String name;
	private String displayName;
	private String Description;
	private String distinguishedName;
	private String relativeDistinguishedName;

	private List<Organization> listaOrganizaciones;
	private List<Group> groups;
	
	
	//POR LO MENOS DEBERIA TENER EL GRUPO people y system. 
	//Usuarios que existen en la organizacion 
	//y usuario administrador de la organizacion
}
