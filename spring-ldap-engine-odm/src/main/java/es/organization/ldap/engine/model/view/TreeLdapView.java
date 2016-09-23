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

package es.organization.ldap.engine.model.view;

import org.springframework.ldap.core.DirContextOperations;

/**
 * Interfaz que define los metodos para recorrer y presentar la estructura de un arbol LDAP
 * 
 * @author javier.martin
 *
 */
public interface TreeLdapView
{
	/**
	 * Recorre desde el nodo pasado como parametro hasta la profundidad indicada una rama de de un arbol LDAP
	 * @param node ruta del nodo del arbol LDAP del que se parte 
	 * @param currentDepth nivel de profundidad maximo
	 */
	public void inspect(DirContextOperations node, int currentDepth);
}
