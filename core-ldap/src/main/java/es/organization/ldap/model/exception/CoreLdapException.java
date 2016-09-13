package es.organization.ldap.model.exception;

public class CoreLdapException extends Exception
{
	private static final long serialVersionUID = -1371650122877685161L;

	//	MENSAJE PERSONALIZADO A PROPAGAR CON LA EXCPECION
	private String mensajeExcepcion = "";

	// 	GETTER Y SETTER
	private String getMensajeExcepcion()
	{
		return CoreLdapException.class.getName() + "[" + mensajeExcepcion + "]";
	}


	private void setMensajeExcepcion(String mensajeExcepcion)
	{
		this.mensajeExcepcion = mensajeExcepcion;
	}

	//	CONSTRUCTORES
	public CoreLdapException(String message)
	{
		super(message);

		setMensajeExcepcion(message);
	}


	public CoreLdapException(Throwable cause)
	{
		super(cause);

		setMensajeExcepcion(cause.toString());
	}


	public CoreLdapException(String message, Throwable cause)
	{
		super(message, cause);

		setMensajeExcepcion(message);
	}

	//	CONVERSION DE LA EXCEPCION A STRING
	public String toString()
	{
		return getMensajeExcepcion();
	}

}
