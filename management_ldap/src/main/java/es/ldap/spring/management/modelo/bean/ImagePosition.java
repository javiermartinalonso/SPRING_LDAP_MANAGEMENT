package es.ldap.spring.management.modelo.bean;

public enum ImagePosition
{
	BELOW ("below"), 
	ABOVE ("above");
	
	private String descripcion;
	
	private ImagePosition(String descripcion)
	{
		this.descripcion = descripcion;
	}

	public String getDescripcion()
	{
		return descripcion;
	}
}
