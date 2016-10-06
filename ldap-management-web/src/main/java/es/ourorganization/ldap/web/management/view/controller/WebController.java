package es.ourorganization.ldap.web.management.view.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import es.ourorganization.ldap.web.management.exception.ManagementLdapException;
import es.ourorganization.ldap.web.management.util.InternationalizationUtil;

/**
 * Controlador principal de las peticiones a informes
 * @author javier.martin
 *
 */
@Controller
@RequestMapping("/")
//OBJETOS QUE MANTENDREMOS EN LA SESIoN DEL USUARIO
@SessionAttributes({"user"})
public class WebController
{	
	//LOGGING
	private static final Logger LOGGER = LoggerFactory.getLogger(WebController.class);

	//RUTAS A VISTAS
	private static final String INDEX = "app.index"; 
	
	/** The internationalization utility. */
	@Autowired
	private InternationalizationUtil internationalizationUtil;

	/**
	 * ZONA DE INYECCION DE SERVICIOS
	 */
	

	//----------------------------------------------------------------------
	//GETTERS Y SETTERS SPRING
    //----------------------------------------------------------------------	
	public InternationalizationUtil getInternationalizationUtil()
	{
		return internationalizationUtil;
	}

	public void setInternationalizationUtil(InternationalizationUtil internationalizationUtil)
	{
		this.internationalizationUtil = internationalizationUtil;
	}
	
	
	//----------------------------------------------------------------------
	//   MAPEO URLs
	//----------------------------------------------------------------------
	/**
	 * Muestra la pantalla de inicio de informes.
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping( value = "/*", method = RequestMethod.GET )
	public ModelAndView index(Model model, HttpServletRequest request)		
	{
		LOGGER.info(getInternationalizationUtil().internationalize("pages.home.title"));
	
		return new ModelAndView(INDEX);
	}


	/**
	 * Muestra la pantalla de inicio de informes.
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping( value = "/organizacion", method = RequestMethod.GET )
	public ModelAndView organizacion(Model model, HttpServletRequest request)		
	{
		LOGGER.info("Muestro la organizacion");
	
		return new ModelAndView("app.organizacion");
	}
		
	
	//----------------------------------------------------------------------
	//   TRATAMIENTO DE EXCEPCIONES EN EL CONTROLADOR
	//----------------------------------------------------------------------
	/**
	 * Metodo tratamiento de excepciones propias del proyecto de informes en el controlador
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(ManagementLdapException.class)
	public ModelAndView handleCustomException(ManagementLdapException ex) 
	{
		ModelAndView model = new ModelAndView("error.error");
		model.addObject("mensajeError", ex.getMessage());
		model.addObject("error", ex.toString());
		
		return model;
	}
	
	
	/**
	 * Metodo tratamiento de excepciones generica en el controlador
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(Exception.class)
	public ModelAndView handleAllException(Exception ex) 
	{
		ModelAndView model = new ModelAndView("error.error");
		model.addObject("mensajeError", ex.getMessage());
		model.addObject("error", ex.toString());
				
		return model;
	}
}
