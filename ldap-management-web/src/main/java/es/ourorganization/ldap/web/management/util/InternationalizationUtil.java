package es.ourorganization.ldap.web.management.util;


import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

/**
 * Clase con utilidades para internacionalizar textos
 * @author javier.martin
 */
@Component
public class InternationalizationUtil 
{

	/** The resource where internationalization codes are. */
	@Autowired
	private MessageSource resource;
	
	
	//Locale definido según el entorno donde se ejecute
	@Value("${app.locale}")
//	private Locale locale = new Locale("es","ES");
	private Locale locale;
	
	// TODO deberiamos modificar igeo.properties, para indicar el idioma del entorno
//	@Autowired
//	private Locale locale;
	
    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
	public MessageSource getResource()
	{
		return resource;
	}

	public void setResource(MessageSource resource)
	{
		this.resource = resource;
	}

	public Locale getLocale()
	{
		return locale;
	}

	public void setLocale(Locale locale)
	{
		this.locale = locale;
	}
	
	
	/**
	 * Internationalizes the messages for the view.
	 *
	 * @param OperationStatusResp the object containing the message to internationalize
	 * @param args the arguments to put inside the text of the message
	 * @return the OperationStatusResp modified
	 */
	public String internationalize(String text, final String... args) 
	{
		text = resource.getMessage(text, args, LocaleContextHolder.getLocale());
		return text;
	}
	

	/**
	 * Internationalizes the messages for the Business logic.
	 *
	 * @param OperationStatusResp the object containing the message to internationalize
	 * @param args the arguments to put inside the text of the message
	 * @return the OperationStatusResp modified
	 */
	public String internationalizeLog(String text, final String... args) 
	{
		text = resource.getMessage(text, args,getLocale());
		return text;
	}
}