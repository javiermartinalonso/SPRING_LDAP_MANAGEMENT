## core LDAP

Módulo que expone la funcionalidad de gestión de un LDAP, está desacoplado de la implemenentación exacta que usemos.
Expone métodos a alto nivel para gestionar un LDAP incluye los beans de capa de negocio.

### Users and Groups in LDAP

Users in LDAP are usually represented as `organizationalPerson` or `inetOrgPerson` entries in the LDAP tree.
The attributes in these entries represent the basic information on the users, e.g. (subset of available attributes):

* `cn`: Common Name, or full name of the user
* `sn`: Surname
* `mail`: Email address
* `telephoneNumber`: Phone number
* ...several more attributes are available

Groups in LDAP are typically organized in `groupOfName` or `groupOfUniqueName` entries. These entries have a name,
an optional description, and an attribute containing the distinguished names (i.e. the unique identifiers) of all
members of the group. This attribute is named `member` and `uniqueMember` respectively.

Thus, user administration in LDAP typically involves creating and manipulating `orgalizationalPerson` or `inetOrgPerson`
entries and adding or removing references to these entries in `groupOfName` or `groupOfUniqueName` entries.

This application demonstrates to do this easily and efficiently using Spring LDAP.

Una organizacion puede dividirse en mas organizaciones.

DN: dc=algo,dc=algo,dc=...
	ou=grupos
	ou=people
		uid=user1
		uid=user2
	ou=system
		uid=admin1
		uid=admin2


Una organizacion hoja o final está formada por grupos bien identificados.
organizacion 
	--> domain
	--> extensibleObject
	--> top
	
	--> organization
	--> dcObject
	
	dc: nombre de la organización suele coincidir con el dominio de la organizacion


Los grupos pueden contener mas grupos.
Un grupo hoja o final esta dividido en roles.

grupos 
	--> organizationalUnit
	ou: nombre organizacion

	- Un grupo de personas es un grupo especial que sirve para autenticar 
	a un usuario dentro de un grupo o dentro de una organizacion.
	Es decir el usuario puede existir a nivel de toda la organizacion o bien existirá sólo a nivel de un grupo, 
	como un usuario técnico independiente de la organización
	de este grupo cuelgan objetos persona
		--> organizationalUnit
		ou=people
		
	- Un rol es desempeñado por una o mas personas
	roles 
		--> group
		--> groupOfUniquesNames
		cn: nombre del rol
		uniquemember: cada persona que está autorizada con este rol, dentro de este grupo.
			uid=[identificador de la persona],ou=people,ou=application,ou=applications,dc=acme,dc=spring,dc=ldap,dc=com
		


	
persona
	--> top
	--> person
	--> organizationalPerson
	--> inetOrgPerson
	cn: nombre persona
	sn: apellidos persona
	uid: identificador unico de la persona
	userpassword: password
	givenName: nombre completo
	mail: mail

