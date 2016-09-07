package es.ldap.spring.management.view.controller;

import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import es.ldap.spring.management.modelo.bean.NodeChildren;
import es.ldap.spring.management.modelo.bean.NodeRoot;
import es.ldap.spring.management.modelo.bean.NodoLDAP;
import es.ldap.spring.management.modelo.bean.SubTypeNode;
import es.ldap.spring.management.modelo.bean.TypeNode;
import es.ldap.spring.management.util.InternationalizationUtil;

/**
 * Controlador principal de las peticiones a informes
 * @author javier.martin
 *
 */
@Controller
@RequestMapping("/rest")
public class RestController
{	
	//LOGGING
	private static final Logger LOGGER = LoggerFactory.getLogger(RestController.class);
	
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
	 * @return JSON con la info de la organizacion
	 * @throws CoreException
	 */
    @RequestMapping(value = "/organizacion", method = RequestMethod.GET)
	public @ResponseBody NodeRoot getExpedientesByAplicacion()
	{		
		LOGGER.info("Muestro la organizacion");
		
    	NodoLDAP nodoLDAP1 = new NodoLDAP("2435", "collateral", TypeNode.collateral, "collateral", null, null, null, null);
    	
    	
    	NodoLDAP nodoLDAP2 = new NodoLDAP("2436", "staff", TypeNode.staff, "staff", null, null, null, null);
    	NodoLDAP nodoLDAP3 = new NodoLDAP("2437", "staffleft", TypeNode.staffleft, "staffleft", "leon.jpg", "below","#FFFFFF", SubTypeNode.dashed);
    	NodoLDAP nodoLDAP4 = new NodoLDAP("2438", "stafftop", TypeNode.stafftop, "stafftop", null, null, null,  null);
    	NodoLDAP nodoLDAP5 = new NodoLDAP("2439", "subordinate", TypeNode.subordinate, "subordinate", null, null, null, null);
    	NodoLDAP nodoLDAP6 = new NodoLDAP("2439", "undefined", TypeNode.undefined, "undefined", null, null, null, null);
    	
    	List <NodoLDAP> listNodoLDAP = new LinkedList<NodoLDAP>();
    	listNodoLDAP.add(nodoLDAP1);
    	listNodoLDAP.add(nodoLDAP2);
    	listNodoLDAP.add(nodoLDAP3);
    	listNodoLDAP.add(nodoLDAP4);
    	listNodoLDAP.add(nodoLDAP5);
    	listNodoLDAP.add(nodoLDAP6);
    	
    	NodeChildren nodeChildren = new NodeChildren("41", "MINISTERIO", TypeNode.staff, "ministerio", null, null, "#FFFFFF", SubTypeNode.dashed, listNodoLDAP);
    	
    	NodeRoot nodeRoot = new NodeRoot(new Long(2), "Nosotros", nodeChildren);
    	
    	
		
 	

//    	NodoLDAP nodoLDAP1 = new NodoLDAP("140", "Abuela", TypeNode.staff, "subtitle", "http://static.batanga.com/sites/default/files/styles/full/public/universo-observable-en-una-imagen-3.png", "", "", null);
//    	NodoLDAP nodoLDAP2 = new NodoLDAP("139", "Abuelo", TypeNode.staff, "subtitle", "./img/leon.jpg", "below", "", null);
//    	NodoLDAP nodoLDAP3 = new NodoLDAP("108", "Padre", TypeNode.subordinate, "subtitle", "./img/burro.jpg", "above", "", null);
//    	NodoLDAP nodoLDAP4 = new NodoLDAP("109", "Madre", TypeNode.subordinate, "", "./img/raton.jpg", "above", "", null);
//    	
//    	List <NodoLDAP> listNodoLDAP = new LinkedList<NodoLDAP>();
//    	listNodoLDAP.add(nodoLDAP1);
//    	listNodoLDAP.add(nodoLDAP2);
//    	listNodoLDAP.add(nodoLDAP3);
//    	listNodoLDAP.add(nodoLDAP4);
//
//    
//    	NodeChildren nodeChildren = new NodeChildren("107", "Familia", TypeNode.staff, "Familia", "https://image.freepik.com/foto-gratis/hrc-tigre-siberiano-2-jpg_21253111.jpg", "below", "#FFFFFF", SubTypeNode.dashed, listNodoLDAP);
//    	
//    	NodeRoot nodeRoot = new NodeRoot(new Long(2), "Nosotros", nodeChildren);
//    	
//    	"id" : 1,
//    	"title" : "Nosotros",
//    	"root" : {
//    		"id" : "107",
//    		"title" : "Familia",
//    		"children" : [
//    			{ "id" : "140", "title" : "Abuela", "type" : "staff"      , "subtitle": "subtitle", "image" : "morsa.jpg" },
//    			{ "id" : "139", "title" : "Abuelo", "type" : "staff"      , "subtitle": "subtitle", "image" : "leon.jpg", "image_position" : "below" },
//    			{ "id" : "108", "title" : "Padre" , "type" : "subordinate", "subtitle": "subtitle", "image" : "burro.jpg", "image_position" : "above" },
//    			{ "id" : "109", "title" : "Madre" , "type" : "subordinate", "image" : "raton.jpg", "image_position" : "above" }
//    		]
//    	}
		
		return nodeRoot;
		
	}

}