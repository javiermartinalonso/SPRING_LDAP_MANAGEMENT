package es.ourorganization.ldap.web.management.exception;

public class ManagementLdapException extends Exception
{
	private static final long serialVersionUID = -1371650122877685161L;

	//	MENSAJE PERSONALIZADO A PROPAGAR CON LA EXCPECION
	private String mensajeExcepcion = "";

	// 	GETTER Y SETTER
	private String getMensajeExcepcion()
	{
		return ManagementLdapException.class.getName() + "[" + mensajeExcepcion + "]";
	}


	private void setMensajeExcepcion(String mensajeExcepcion)
	{
		this.mensajeExcepcion = mensajeExcepcion;
	}

	//	CONSTRUCTORES
	public ManagementLdapException(String message)
	{
		super(message);

		setMensajeExcepcion(message);
	}


	public ManagementLdapException(Throwable cause)
	{
		super(cause);

		setMensajeExcepcion(cause.toString());
	}


	public ManagementLdapException(String message, Throwable cause)
	{
		super(message, cause);

		setMensajeExcepcion(message);
	}

	public ManagementLdapException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) 
	{
		super(message, cause, enableSuppression, writableStackTrace);
		
		setMensajeExcepcion(message);
	}
	
	//	CONVERSION DE LA EXCEPCION A STRING
	public String toString()
	{
		return getMensajeExcepcion();
	}

}
