package es.ldap.spring.management.view.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import es.ldap.spring.management.exception.ManagementLdapException;
import es.ldap.spring.management.util.InternationalizationUtil;

/**
 * Controlador principal de las peticiones a zona administrativa
 * @author javier.martin
 *
 */
@Controller
@RequestMapping("/admin")
public class AdminController
{	
	private static final String CONTROLLER_ACCESSO_ADMIN_ZONE = "controller.accesso.adminZone";

	//LOGGING
	private static final Logger LOGGER = LoggerFactory.getLogger(WebController.class);

	//RUTAS A VISTAS
	private static final String ADMIN_ZONE = "security.admin";
	
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
	@RequestMapping(value = "/*")
	public  ModelAndView admin(Model model)
	{
        LOGGER.info(getInternationalizationUtil().internationalize(CONTROLLER_ACCESSO_ADMIN_ZONE));
        
		return new ModelAndView(ADMIN_ZONE);
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
