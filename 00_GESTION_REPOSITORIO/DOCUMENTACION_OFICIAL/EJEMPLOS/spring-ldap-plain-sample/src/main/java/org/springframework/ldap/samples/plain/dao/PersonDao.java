/*
 * Copyright 2005-2010 the original author or authors.
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
package org.springframework.ldap.samples.plain.dao;

import org.springframework.ldap.samples.plain.domain.Person;

import java.util.List;

/**
 * Data Access Object interface for the Person entity.
 * 
 * @author Mattias Hellborg Arthursson
 * @author Ulrik Sandberg
 */
public interface PersonDao
{
	/**
	 * Da de alta una persona en el LDAP
	 */
	void create(Person person);


	/**
	 * Actualiza una persona existente en el LDAP
	 */
	void update(Person person);


	/**
	 * Borra una persona existente en el LDAP
	 */
	void delete(Person person);


	/**
	 * Obtiene una lista con el nombre de todas las personas existentes en el LDAP
	 */
	List<String> getAllPersonNames();


	/**
	 * Obtiene una lista con todas las personas existentes en el LDAP
	 */
	List<Person> findAll();


	/**
	 * Obtiene una Persona del LDAP con el dn formado por los siguientes parametros
	 */
	Person findByPrimaryKey(String country, String company, String fullname);
}
