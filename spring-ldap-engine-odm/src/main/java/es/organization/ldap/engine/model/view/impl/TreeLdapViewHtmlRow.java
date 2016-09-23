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

package es.organization.ldap.engine.model.view.impl;

import org.springframework.ldap.core.DirContextOperations;

import es.organization.ldap.engine.model.view.TreeLdapView;

import java.util.LinkedList;
import java.util.List;

/**
 * Implementacion de un recorrido completo de un arbol LDAP, en este caso el
 * resultado se devuelve en forma de links html a cada nodo Recorre el arbol del
 * Ldap y en rows guarda una lista con los links html a cada nodo.
 * 
 * @author javier.martin
 *
 */
public class TreeLdapViewHtmlRow implements TreeLdapView
{

	private List<String> rows = new LinkedList<String>();


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
	public void inspect(DirContextOperations node, int currentDepth)
	{
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < currentDepth; i++)
		{
			sb.append("&nbsp;&nbsp;&nbsp;&nbsp;");
		}

		sb.append("<a href='").append(getLinkForNode(node)).append("'>").append(node.getDn()).append("</a>").append("<br>\n");

		rows.add(sb.toString());
	}


	protected String getLinkForNode(DirContextOperations node)
	{
		return "#";
	}


	public List<String> getRows()
	{
		return rows;
	}

}
