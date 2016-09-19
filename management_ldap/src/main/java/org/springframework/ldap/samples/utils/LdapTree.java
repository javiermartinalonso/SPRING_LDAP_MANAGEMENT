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

import java.util.LinkedList;
import java.util.List;

import org.springframework.ldap.core.DirContextOperations;

/**
 * Estructura que representa un arbol LDAP 
 * @author javier.martin
 *
 */
public class LdapTree
{
	//Nodo raiz del arbol LDAP
	private final DirContextOperations	node;

	//Ramas del arbol LDAP
	private List<LdapTree>				subContexts	= new LinkedList<LdapTree>();

	/**Constructor 
	 * Esta clase representa una estructura de un arbol LDAP
	 * @param node nodo inicial del arbol LDAP
	 */
	public LdapTree(DirContextOperations node)
	{
		this.node = node;
	}

	/**
	 * devuelve el nodo del LDAP que es raiz del arbol LDAP
	 * @return
	 */
	public DirContextOperations getNode()
	{
		return node;
	}

	/**
	 * Devuelve las ramas del arbol
	 * @return
	 */
	public List<LdapTree> getSubContexts()
	{
		return subContexts;
	}

	/**
	 * sustituye las ramas del arbol por las ramas pasadas como paramtero
	 * @param subContexts
	 */
	public void setSubContexts(List<LdapTree> subContexts)
	{
		this.subContexts = subContexts;
	}

	/**
	 * aniade una rama nueva al arbol
	 * @param ldapTree
	 */
	public void addSubTree(LdapTree ldapTree)
	{
		subContexts.add(ldapTree);
	}

	/**
	 * Recorre una estructura de arbol que representa un LDAP y rellena una lista donde cada elemento es la representación que hemos
	 * elegido para un nodo del arbol. Podriamos presentar el nodo como un link html, como un objeto rest, etc. 
	 * @param visitor
	 */
	public void traverse(LdapTreeVisitor visitor)
	{
		traverse(visitor, 0);
	}

	
	/**
	 * Recorre una estructura de arbol que representa un LDAP y rellena una
	 * lista donde cada elemento es la representación que hemos elegido para un
	 * nodo del arbol. Podriamos presentar el nodo como un link html, como un
	 * objeto rest, etc.
	 * 
	 * @param visitor Interfaz que define como se van a presentar los datos de
	 *            los nodos que recorramos
	 * @param currentDepth nodo del que partimos del arbol dado para recorrerlo
	 */
	private void traverse(LdapTreeVisitor visitor, int currentDepth)
	{
		//Recoremos el nodo actual y lo presentamos
		visitor.visit(node, currentDepth);
		
		//Recorremos las ramas del arbol
		for (LdapTree subContext : subContexts)
		{
			subContext.traverse(visitor, currentDepth + 1);
		}
	}
}
