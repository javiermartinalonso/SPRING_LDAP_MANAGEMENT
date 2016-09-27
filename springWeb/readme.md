## Spring Web

PROYECTO BASE PARA CREAR CUALQUIER APLICACION WEB BASADA EN SPRING-MVC+TILES+JSTL+BOOTSTRAP

SOPORTA INTERNACIONALIZACION I18N

### DEPENDENCIAS
NO DEPENDE DE NINGUN OTRO MODULO

### PENDIENTE:


### REFERENCIAS:



### NOTAS:
SE HA PROBADO EL FUNCIONAMIENTO BAJO UN APACHE TOMCAT 6.0.41

### Running the Example
CONSTRUIR CON:
mvn clean install

en la carpeta ".\springWeb\target" te genera el war "management_ldap.war", que se debe desplegar en la carpeta webapps del servidor tomcat.

Una vez se reealice el deploy, se puede probar la ejecucion en las siguientes urls:

PAGINA INICIAL:
http://localhost:8080/springWeb

ZONA CONTROL DE PETICIONES MVC
http://localhost:8080/springWeb/[CUALQUIER COSA]

TODA LLAMADA A PARTIR DE http://localhost:8080/springWeb/ SE REDIRIGE A LA PANTALLA DE BIENVENIDA

ZONA ADMINISTRATIVA
http://localhost:8080/springWeb/admin-sample`

