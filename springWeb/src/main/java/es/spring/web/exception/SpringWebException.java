package es.spring.web.exception;

public class SpringWebException extends Exception
{
	private static final long serialVersionUID = -1371650122877685161L;

	//	MENSAJE PERSONALIZADO A PROPAGAR CON LA EXCPECION
	private String mensajeExcepcion = "";

	// 	GETTER Y SETTER
	private String getMensajeExcepcion()
	{
		return SpringWebException.class.getName() + "[" + mensajeExcepcion + "]";
	}


	private void setMensajeExcepcion(String mensajeExcepcion)
	{
		this.mensajeExcepcion = mensajeExcepcion;
	}

	//	CONSTRUCTORES
	public SpringWebException(String message)
	{
		super(message);

		setMensajeExcepcion(message);
	}


	public SpringWebException(Throwable cause)
	{
		super(cause);

		setMensajeExcepcion(cause.toString());
	}


	public SpringWebException(String message, Throwable cause)
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
