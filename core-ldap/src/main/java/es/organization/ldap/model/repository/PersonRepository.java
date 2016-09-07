package es.organization.ldap.model.repository;

import java.util.List;
import java.util.Map;

import es.organization.ldap.model.bean.Person;

public interface PersonRepository
{
	/**
	 * Devuelve la lista de personas que contiene la persona cuyo id coincide con el que se pasa como parámetro
	 * @param String userId
	 * @return List<Person>
	 */
	List<Person> getByUID(String userId);

	/**
	 * Devuelve la lista de personas que contiene el grupo cuyo id se pasa como parámetro
	 * @param String groupId
	 * @return List<Person>
	 */
	List<Person> getByGroupUID(String groupId);

	/**
	 * Te devuelve una lista de personas del LDAP, donde coincidan con los pares
	 * de atributo/valor pasados como filtro a traves de un Map
	 * @param Map<String, String> filter
	 * @return List<Person>
	 */
	List<Person> getByFilter(Map<String, String> filter);

	/**
	 * Actualiza los datos de una persona del LDAP cuyo identificador coincida con el del objeto
	 * person pasado como parámetro, actualizando los datos con los del objeto person.
	 * @param Person person
	 */
	void updateContact(Person person);

	/**
	 * Crea una nueva persona en el LDAP con el del objeto person pasado como parámetro
	 * @param Person person
	 */
	void insertContact(Person person);

	/**
	 * Elimina una persona del LDAP cuyo identificador coincida con el del objeto
	 * person pasado como parámetro
	 * @param Person person
	 */
	void deleteContact(Person person);
}