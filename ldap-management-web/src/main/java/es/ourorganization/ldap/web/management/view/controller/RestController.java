package es.ourorganization.ldap.web.management.view.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.LinkedList;
import java.util.List;

import javax.naming.Name;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.ldap.samples.utils.HtmlRowLdapTreeVisitor;
import org.springframework.ldap.samples.utils.LdapTree;
import org.springframework.ldap.samples.utils.LdapTreeBuilder;
import org.springframework.ldap.support.LdapUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import es.ourorganization.ldap.web.management.modelo.bean.NodeChildren;
import es.ourorganization.ldap.web.management.modelo.bean.NodeRoot;
import es.ourorganization.ldap.web.management.modelo.bean.NodoLDAP;
import es.ourorganization.ldap.web.management.modelo.bean.SubTypeNode;
import es.ourorganization.ldap.web.management.modelo.bean.TypeNode;
import es.ourorganization.ldap.web.management.util.InternationalizationUtil;

/**
 * Controlador principal de las peticiones a informes
 * 
 * @author javier.martin
 *
 */
@Controller
@RequestMapping("/rest")
public class RestController
{
	//LOGGING
	private static final Logger			LOGGER	= LoggerFactory.getLogger(RestController.class);

	/** The internationalization utility. */
	@Autowired
	private InternationalizationUtil	internationalizationUtil;

	/**
	 * ZONA DE INYECCION DE SERVICIOS
	 */
	@Autowired
	private LdapTreeBuilder				ldapTreeBuilder;


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

		//creamos una estructura de arbol de la conexion que tenemos contra el LDAP, al pasarle un nodo vacio recorre desde la raiz del LDAP.
		LdapTree ldapTree = ldapTreeBuilder.getLdapTree(LdapUtils.emptyLdapName());

		//recorremos el arbol buscando los nodos de personas y monto una lista con los enlaces rest/htmls a la informacion de cada nodo
		HtmlRowLdapTreeVisitor visitor = new PersonLinkHtmlRowLdapTreeVisitor();
		//recorre el arbol LDAP y genera una lista en el objeto de introspeccion del arbol con los nodos en formato de links de html
		ldapTree.traverse(visitor);
		//lista donde cada elemento representa un link a la informacion de una persona definida en el LDAP
		List<String> arbolLDAP = visitor.getRows();
		//		return new ModelAndView("showTree", "rows", visitor.getRows());

		NodoLDAP nodoLDAP1 = new NodoLDAP("2435", "collateral", TypeNode.collateral, "collateral", null, null, null, null);

		NodoLDAP nodoLDAP2 = new NodoLDAP("2436", "staff", TypeNode.staff, "staff", null, null, null, null);
		NodoLDAP nodoLDAP3 = new NodoLDAP("2437", "staffleft", TypeNode.staffleft, "staffleft", "leon.jpg", "below", "#FFFFFF", SubTypeNode.dashed);
		NodoLDAP nodoLDAP4 = new NodoLDAP("2438", "stafftop", TypeNode.stafftop, "stafftop", null, null, null, null);
		NodoLDAP nodoLDAP5 = new NodoLDAP("2439", "subordinate", TypeNode.subordinate, "subordinate", null, null, null, null);
		NodoLDAP nodoLDAP6 = new NodoLDAP("2439", "undefined", TypeNode.undefined, "undefined", null, null, null, null);

		List<NodoLDAP> listNodoLDAP = new LinkedList<NodoLDAP>();
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

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Clase que extiende de HtmlRowLdapTreeVisitor, 
	 * sobreescribiendo la forma en la que generamos los urls de acceso a la información de un nodo.
	 * Generates appropriate links for person leaves in the tree. Recorre el
	 * arbol buscando los nodos de personas y monto una lista con los enlaces
	 * rest/htmls a la informacion de cada nodo
	 * 
	 * @author Mattias Hellborg Arthursson
	 */
	private static final class PersonLinkHtmlRowLdapTreeVisitor extends HtmlRowLdapTreeVisitor
	{
		@Override
		protected String getLinkForNode(DirContextOperations node)
		{
			String[] objectClassValues = node.getStringAttributes("objectClass");

			//SI ES UNA PERSONA GENERA UN STRING CON LA URL RELATIVA PARA EXPLORAR SUS DATOS
			if (containsValue(objectClassValues, "person") || containsValue(objectClassValues, "organizationalPerson") || containsValue(objectClassValues, "inetOrgPerson"))
			{
				//OBTENEMOS EL ID DEL NODO
				//POR EJEMPLO dn : cn=Some Person,ou=company1,c=Sweden
				Name dn = node.getDn();

				String country = encodeValue(LdapUtils.getStringValue(dn, "c"));
				String company = encodeValue(LdapUtils.getStringValue(dn, "ou"));
				String fullName = encodeValue(LdapUtils.getStringValue(dn, "cn"));

				return "showPerson.do?country=" + country + "&company=" + company + "&fullName=" + fullName;
			}
			else
			{
				return super.getLinkForNode(node);
			}
		}


		/**
		 * Devuelve un String correctamente codificado para usar en una url
		 * 
		 * @param value
		 * @return
		 */
		private String encodeValue(String value)
		{
			try
			{
				return URLEncoder.encode(value, "UTF8");
			}
			catch (UnsupportedEncodingException e)
			{
				// Not supposed to happen
				throw new RuntimeException("Unexpected encoding exception", e);
			}
		}


		/**
		 * Comprueba si un String 'value' se encuentra contenido en el array de
		 * strings 'values'
		 * 
		 * @param values
		 * @param value
		 * @return
		 */
		private boolean containsValue(String[] values, String value)
		{
			//para cada elemento del array
			for (String oneValue : values)
			{
				//comprobamos si el valor en curso es igual al valor que buscamos
				if (StringUtils.equals(oneValue, value))
				{
					return true;
				}
			}
			return false;
		}
	}

}
