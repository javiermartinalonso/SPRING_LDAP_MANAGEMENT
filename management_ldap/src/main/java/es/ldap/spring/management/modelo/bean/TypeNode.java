package es.ldap.spring.management.modelo.bean;

public enum TypeNode
{
	ROOT ("root"), 
	CHILDREN ("children"),
	
	collateral ("collateral"),
	staff ("staff"),
	stafftop ("stafftop"),
	staffleft ("staffleft"),
	subordinate ("subordinate"),
	undefined ("undefined");

	private String descripcion;
	
	private TypeNode(String descripcion)
	{
		this.descripcion = descripcion;
	}

	public String getDescripcion()
	{
		return descripcion;
	}
}
