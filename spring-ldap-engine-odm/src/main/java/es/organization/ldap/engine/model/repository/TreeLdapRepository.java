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

package es.organization.ldap.engine.model.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.AbstractContextMapper;
import org.springframework.ldap.support.LdapUtils;
import org.springframework.stereotype.Component;

import es.organization.ldap.engine.model.TreeLdap;

import javax.naming.Name;

@Component
public class TreeLdapRepository
{
	@Autowired
	private LdapTemplate ldapTemplate;


	public LdapTemplate getLdapTemplate()
	{
		return ldapTemplate;
	}

	public void setLdapTemplate(LdapTemplate ldapTemplate)
	{
		this.ldapTemplate = ldapTemplate;
	}

/*
  	public TreeLdapRepository(LdapTemplate ldapTemplate)

	{
		this.ldapTemplate = ldapTemplate;
	}
 */
	/**
	 * Obtiene una estructura de arbol LDAP tomando como raiz el nodo pasado como parametro
	 * @param root
	 * @return
	 */
	public TreeLdap getLdapTree(Name root)
	{
		//obtengo la ruta del nodo del que partimos para calcular el arbol
		DirContextOperations context = ldapTemplate.lookupContext(root);
		
		//Obtenemos una estructura de arbol manejable con spring
		return getLdapTree(context);
	}


	/**
	 * Recorre de forma recursiva una estructura LDAP, a partir de la ruta indicada
	 * Creando una estructura de arbol de LDAP que podamos manejar con Spring
	 * @param rootContext
	 * @return una estructura de arbol de LDAP que podamos manejar con Spring que se corresponde con 
	 * el LDAP desde el nodo indicado como parametro
	 */
	private TreeLdap getLdapTree(final DirContextOperations rootContext)
	{
		final TreeLdap ldapTree = new TreeLdap(rootContext);
		
		//Realizar un listado no recursivo de los hijos de la base dada. 
		//El objeto devuelto en cada uni�n se suministra al ContextMapper especificado.
		ldapTemplate.listBindings(rootContext.getDn(), new AbstractContextMapper<Object>()
		{
			@Override
			protected Object doMapFromContext(DirContextOperations ctx)
			{
				//parte del contexto indicado como par�metro
				Name dn = ctx.getDn();
				//Anteponer la ruta proporcionada en el que comienza el nombre especificado si la instancia nombre comienza con la ruta. 
				//El nombre original no se vera afectada.
				dn = LdapUtils.prepend(dn, rootContext.getDn());
				
				//Inicializa una estructura de arbol LDAP tomando como raiz el nodo actual y a partir de el
				//calcula los subarboles en los que se bifurca
				ldapTree.addSubTree(getLdapTree(ldapTemplate.lookupContext(dn)));
				
				return null;
			}
		});

		return ldapTree;
	}
}
