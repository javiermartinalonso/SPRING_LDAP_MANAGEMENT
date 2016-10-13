/*
 * Copyright 2005-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.ldap.samples.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.LinkedList;
import java.util.List;

import javax.naming.Name;

import org.apache.commons.lang.StringUtils;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.ldap.support.LdapUtils;

import es.ourorganization.ldap.web.management.modelo.bean.NodeChildren;
import es.ourorganization.ldap.web.management.modelo.bean.NodeRoot;
import es.ourorganization.ldap.web.management.modelo.bean.NodoLDAP;
import es.ourorganization.ldap.web.management.modelo.bean.SubTypeNode;
import es.ourorganization.ldap.web.management.modelo.bean.TypeNode;

/**
 * Implementacion de un recorrido completo de un arbol LDAP, en este caso el
 * resultado se devuelve en forma de links html a cada nodo Recorre el arbol del
 * Ldap y en rows guarda una lista con los links html a cada nodo.
 * 
 * @author javier.martin
 *
 */
public class NodoLDAPTreeVisitor implements LdapTreeVisitor
{	
//	NodeChildren nodeChildren = new NodeChildren("41", "MINISTERIO", TypeNode.staff, "ministerio", null, null, "#FFFFFF", SubTypeNode.dashed, listNodoLDAP);

	NodeRoot nodeRoot = null;
	
	//0 es el root
	int anteriorProfundidad = 0;
	
	LinkedList<NodeChildren> memento = new LinkedList<NodeChildren>();
	
	// Nodo en estudio
//	NodeChildren nodeChildrenMemento = null;
	
	
//	List<NodoLDAP> listaHijosMemento = null;
		
	
//	private LinkedList<NodoLDAP> listNodoLDAP = new LinkedList<NodoLDAP>();

	public NodoLDAPTreeVisitor(Long id)
	{
		super();
		
		LinkedList<NodoLDAP> listNodoLDAP = new LinkedList<NodoLDAP>();
		
		NodeChildren nodeChildrenMemento = new NodeChildren("", "", TypeNode.CHILDREN, "", null, null, "#FFFFFF", SubTypeNode.dashed, listNodoLDAP);
		
		this.nodeRoot = new NodeRoot(new Long(2), "Organigrama", nodeChildrenMemento);
	}
	
		
	public NodeRoot getNodeRoot()
	{
		return nodeRoot;
	}


	/**
	 * Recorre una estructura de arbol que representa una rama de un LDAP y
	 * rellena una lista donde cada elemento es la representaci�n que hemos
	 * elegido para un nodo del arbol. En este caso presentamos el nodo como un
	 * link html.
	 * 
	 * @param node estructura de arbol que representa una rama de un LDAP, nodo
	 *            del que partimos
	 * @param currentDepth profundidad a partir del nodo actual que vamos a
	 *            recorrer
	 */
	public void visit(DirContextOperations node, int currentDepth)
	{		
		
		

		
		//SI ES el dominio o raiz de LA ORGANIZACION
		//containsValue(objectClassValues, "domain")
		if (currentDepth == 0)
		{
			//OBTENEMOS EL ID DEL NODO
			//POR EJEMPLO dn: ou=Departments,dc=example,dc=com
//			String base = node.getNameInNamespace();
			String base = node.getStringAttribute("dc");
//			node.getStringAttribute("dc")
			
			//El primer hijo del nodeRoot es la organizacion
			NodeChildren organizacion = (NodeChildren) this.nodeRoot.getRoot();
//			NodeChildren organizacion = this.nodeRoot.getNodeChildren();
			organizacion.setId(base);
			organizacion.setTitle(base);
			organizacion.setSubtitle(base);
			
			memento.add(organizacion);
		}
		else
		{
			NodeChildren anteriorNodo = memento.getLast();
			
			String[] objectClassValues = node.getStringAttributes("objectClass");

			NodeChildren nodeChildren = null;
			
			//SI ES UNA UNIDAD ORGANIZACIONAL, UN AREA O DEPARTAMENTO DE LA ORGANIZACION
			//dn: ou=Departments,dc=example,dc=com
			if (containsValue(objectClassValues, "organizationalUnit"))
			{
				nodeChildren = buildNodeChildren(node, "ou", TypeNode.CHILDREN);
			}
			//SI ES UNA PERSONA GENERA UN OBJETO NODE QUE REPRESENTE A UNA PERSONA
			//dn: cn=John Doe,ou=Development,ou=IT,ou=Departments,dc=example,dc=com
			else if (containsValue(objectClassValues, "person") || containsValue(objectClassValues, "organizationalPerson") || containsValue(objectClassValues, "inetOrgPerson"))
			{
				nodeChildren = buildNodeChildren(node, "cn", TypeNode.CHILDREN);
			}
			else if (containsValue(objectClassValues, "groupOfNames"))
			{
				nodeChildren = buildNodeChildren(node, "cn", TypeNode.CHILDREN);
			}
			
			
			
			//si hemos terminado un nivel 
			if (currentDepth < anteriorProfundidad)
			{
				int retrocederNiveles = anteriorProfundidad - currentDepth;
				
				//Retrocedemos los niveles necesarios
				for (int i = 0; i < retrocederNiveles + 1; i++)
				{
					//Subimos al padre
					memento.removeLast();
				}
				
				//Subimos al padre
//				memento.removeLast();
				
				//como ya terminamos con ese nodo, recuperamos el anterior
//				memento.removeLast();
				
				anteriorNodo = memento.getLast();
			}
			//Si estamos en un hijo nuevo
			else if (currentDepth > anteriorProfundidad)
			{				
	
			}
			//si estamos en un hermano nuevo
			else if (currentDepth == anteriorProfundidad)
			{
				//Tengo que posicionarme en el padre y añadirle un hijo nuevo
//				LinkedList<NodeChildren> mementoPadre = (LinkedList<NodeChildren>) memento.clone();
				memento.removeLast();
				
				anteriorNodo = memento.getLast();
			}						

			List<NodoLDAP> listaHijos = anteriorNodo.getChildren();
			
			if (listaHijos == null)
			{
				listaHijos = new LinkedList<NodoLDAP>();
			}
			
			listaHijos.add(nodeChildren);
			
			anteriorNodo.setChildren(listaHijos);
			
			memento.add(nodeChildren);
		}
		
		anteriorProfundidad = currentDepth;
	}


	private NodeChildren buildNodeChildren(DirContextOperations node, String atributo, TypeNode type)
	{
		//OBTENEMOS EL ID DEL NODO
		//POR EJEMPLO dn : cn=Some Person,ou=company1,c=Sweden
		Name dn = node.getDn();
		
//		String area = encodeValue(LdapUtils.getStringValue(dn, atributo));
//		String area = encodeValue(getIDNode(atributo, dn));
		String area = getIDNode(atributo, dn);
	
		NodeChildren nodeChildren = new NodeChildren(area, area, type, encodeValue(area), null, null, "#FFFFFF", SubTypeNode.dashed, null);
		
		return nodeChildren;
	}


	private String getIDNode(String atributo, Name dn)
	{
		return LdapUtils.getValue(dn, dn.size()-1).toString();
//		return LdapUtils.getStringValue(dn.getPrefix(dn.size()), atributo);
	}


	/**
	 * Devuelve un string que representa el link a una vista de detalle del nodo.
	 * @param node
	 * @return
	 */
	protected String getLinkForNode(DirContextOperations node)
	{
		return "#";
	}


//	public List<NodoLDAP> getNodes()
//	{
//		return listNodoLDAP;
//	}

	
	/**
	 * TODO obtener clase abstracta o algo para mantener el principio DRY 
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
}
