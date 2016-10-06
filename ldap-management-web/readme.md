## core LDAP

M�dulo web que gestiona un LDAP. Dibuja graficamente la estructura del LDAP.
Por otro lado expone los formularios para la gesti�n de cada objeto del LDAP.

Debe estar desacoplado de la capa de servicio que es la que acceda al LDAP mediante el m�dulo core-ldap.

### Arrancando el ejemplo
compilar con maven
probado en un apache-tomcat-9.0.0.M10

To run the example, do gradle jettyRun or mvn jetty:run, and then navigate to http://localhost:8080/ldap-management-web/organizacion

###referencias

http://librerias.logicas.org/lib_gg_orgchart

### ejemplos
http://librerias.logicas.org/lib_gg_orgchart/examples/demo-example-1.html
http://librerias.logicas.org/lib_gg_orgchart/examples/demo-example-2.html
http://librerias.logicas.org/lib_gg_orgchart/examples/demo-example-3.html
http://librerias.logicas.org/lib_gg_orgchart/examples/demo-example-4.html
