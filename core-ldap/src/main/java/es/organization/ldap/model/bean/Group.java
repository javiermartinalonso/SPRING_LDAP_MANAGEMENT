package es.organization.ldap.model.bean;

import java.util.List;

public class Group
{
	private String name;
	private String displayName;
	private String Description;
	private List<Group> groups;
	private List<Rol> members;
}
