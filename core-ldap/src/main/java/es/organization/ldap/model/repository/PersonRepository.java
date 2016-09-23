package es.organization.ldap.model.repository;

import java.util.List;
import java.util.Map;

import es.organization.ldap.model.bean.Person;

public interface PersonRepository
{
	/**
	 * Crea una nueva persona en el LDAP con el del objeto person pasado como parámetro
	 * @param Person person
	 */
	void insert(Person person);
	
	/**
	 * Actualiza los datos de una persona del LDAP cuyo identificador coincida con el del objeto
	 * person pasado como parámetro, actualizando los datos con los del objeto person.
	 * @param Person person
	 */
	void update(Person person);

	/**
	 * Elimina una persona del LDAP cuyo identificador coincida con el del objeto
	 * person pasado como parámetro
	 * @param Person person
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
	 * Obtiene una Persona del LDAP con el dn formado por los siguientes parametros
	 */
	Person findByPrimaryKey(String company, String path, String fullname);
}