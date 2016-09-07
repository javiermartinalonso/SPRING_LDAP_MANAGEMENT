package es.ldap.spring.management.modelo.bean;

public enum SubTypeNode
{
	dashed ("dashed");

	private String descripcion;
	
	private SubTypeNode(String descripcion)
	{
		this.descripcion = descripcion;
	}

	public String getDescripcion()
	{
		return descripcion;
	}
}
