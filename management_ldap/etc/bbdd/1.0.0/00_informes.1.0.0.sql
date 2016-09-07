/* ---------------------------------------------------- */
/*  Generated by Enterprise Architect Version 12.1 		*/
/*  Created On : 11-abr.-2016 11:15:31 				*/
/*  DBMS       : PostgreSQL 						*/
/* ---------------------------------------------------- */

/* Drop Tables */

DROP TABLE IF EXISTS informes.categoria CASCADE
;

DROP TABLE IF EXISTS informes.categoria_informe CASCADE
;

DROP TABLE IF EXISTS informes.categoria_permiso CASCADE
;

DROP TABLE IF EXISTS informes.implementacion_funcion CASCADE
;

DROP TABLE IF EXISTS informes.informe CASCADE
;

DROP TABLE IF EXISTS informes.informe_parametro_evento CASCADE
;

DROP TABLE IF EXISTS informes.maestro_evento CASCADE
;

DROP TABLE IF EXISTS informes.maestro_funcion CASCADE
;

DROP TABLE IF EXISTS informes.parametro CASCADE
;

DROP TABLE IF EXISTS informes.permiso CASCADE
;

DROP TABLE IF EXISTS informes.tipo_widget CASCADE
;

/* Create Tables */

CREATE TABLE informes.categoria
(
	idcategoria serial NOT NULL,
	name varchar(255) NULL,
	orden integer NOT NULL,
	activo boolean NOT NULL,
	descripcion varchar(255) NULL
)
;

CREATE TABLE informes.categoria_informe
(
	idcategoria serial NOT NULL,
	idinforme serial NOT NULL,
	orden integer NULL,
	activo boolean NOT NULL   DEFAULT true
)
;

CREATE TABLE informes.categoria_permiso
(
	idcategoria serial NOT NULL,
	idpermiso serial NOT NULL
)
;

CREATE TABLE informes.implementacion_funcion
(
	idimplementacion_funcion serial NOT NULL,
	idmaestrofuncion serial NOT NULL,
	parametros text NULL,
	descripcion varchar(250) NULL
)
;

CREATE TABLE informes.informe
(
	idinforme serial NOT NULL,
	descripcion varchar(255) NULL,
	path_informe varchar(255) NOT NULL,
	nombre varchar(255) NOT NULL
)
;

CREATE TABLE informes.informe_parametro_evento
(
	idinforme serial NOT NULL,
	idparametro serial NOT NULL,
	idmaestroevento serial NOT NULL,
	idimplementacion_funcion serial NOT NULL,
	activo boolean NOT NULL   DEFAULT true,
	orden integer NULL,
	obligatorio boolean NOT NULL   DEFAULT false
)
;

CREATE TABLE informes.maestro_evento
(
	idmaestroevento serial NOT NULL,
	nombre varchar(250) NOT NULL,
	descripcion varchar(250) NULL
)
;

CREATE TABLE informes.maestro_funcion
(
	idmaestrofuncion serial NOT NULL,
	nombre varchar(250) NOT NULL,
	descripcion varchar(250) NULL,
	parametros text NULL
)
;

CREATE TABLE informes.parametro
(
	idparametro serial NOT NULL,
	nombre varchar(255) NOT NULL,
	descripcion varchar(255) NULL,
	idtipo_widget serial NOT NULL,
	url varchar(255) NULL,
	valor_defecto text NULL,
	label varchar(250) NULL
)
;

CREATE TABLE informes.permiso
(
	idpermiso serial NOT NULL,
	nombre varchar(50) NOT NULL,
	descripcion text NULL,
	codigo varchar(50) NOT NULL
)
;

CREATE TABLE informes.tipo_widget
(
	idtipo_widget serial NOT NULL,
	nombre varchar(250) NOT NULL,
	descripcion varchar(255) NULL
)
;

/* Create Primary Keys, Indexes, Uniques, Checks */

ALTER TABLE informes.categoria ADD CONSTRAINT PK_idCategoria
	PRIMARY KEY (idcategoria)
;

ALTER TABLE informes.categoria_informe ADD CONSTRAINT PK_categoria_informes
	PRIMARY KEY (idcategoria,idinforme)
;

CREATE INDEX IXFK_categoria_idCategoria ON informes.categoria_informe (idcategoria ASC)
;

CREATE INDEX IXFK_informe_idInforme ON informes.categoria_informe (idinforme ASC)
;

ALTER TABLE informes.categoria_permiso ADD CONSTRAINT PK_categoria_permisos
	PRIMARY KEY (idcategoria,idpermiso)
;

CREATE INDEX IXFK_categoria_permisos_idCategoria ON informes.categoria_permiso (idcategoria ASC)
;

CREATE INDEX IXFK_categoria_permisos_idPermiso ON informes.categoria_permiso (idpermiso ASC)
;

ALTER TABLE informes.implementacion_funcion ADD CONSTRAINT PK_funcion
	PRIMARY KEY (idimplementacion_funcion)
;

CREATE INDEX IXFK_maestro_funcion ON informes.implementacion_funcion (idmaestrofuncion ASC)
;

ALTER TABLE informes.informe ADD CONSTRAINT idInforme
	PRIMARY KEY (idinforme)
;

ALTER TABLE informes.informe_parametro_evento ADD CONSTRAINT PK_informe_parametro
	PRIMARY KEY (idinforme,idparametro,idmaestroevento,idimplementacion_funcion)
;

CREATE INDEX IXFK_informe_parametro_evento_funcion ON informes.informe_parametro_evento (idinforme ASC,idparametro ASC,idmaestroevento ASC,idimplementacion_funcion ASC)
;

ALTER TABLE informes.maestro_evento ADD CONSTRAINT PK_maestroEvento
	PRIMARY KEY (idmaestroevento)
;

ALTER TABLE informes.maestro_funcion ADD CONSTRAINT PK_maestroFuncion
	PRIMARY KEY (idmaestrofuncion)
;

ALTER TABLE informes.parametro ADD CONSTRAINT idparametro
	PRIMARY KEY (idparametro)
;

CREATE INDEX IXFK_tipo_widget_idTipo_widget ON informes.parametro (idtipo_widget ASC)
;

ALTER TABLE informes.permiso ADD CONSTRAINT PK_idPermiso
	PRIMARY KEY (idpermiso)
;

ALTER TABLE informes.tipo_widget ADD CONSTRAINT PK_tipoWidget
	PRIMARY KEY (idtipo_widget)
;

/* Create Foreign Key Constraints */

ALTER TABLE informes.categoria_informe ADD CONSTRAINT FK_categoria_idCategoria
	FOREIGN KEY (idcategoria) REFERENCES informes.categoria (idcategoria) ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE informes.categoria_informe ADD CONSTRAINT FK_informe_idInforme
	FOREIGN KEY (idinforme) REFERENCES informes.informe (idinforme) ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE informes.categoria_permiso ADD CONSTRAINT FK_categoria_permisos_idCategoria
	FOREIGN KEY (idcategoria) REFERENCES informes.categoria (idcategoria) ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE informes.categoria_permiso ADD CONSTRAINT FK_categoria_permisos_idPermiso
	FOREIGN KEY (idpermiso) REFERENCES informes.permiso (idpermiso) ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE informes.implementacion_funcion ADD CONSTRAINT FK_maestro_funcion
	FOREIGN KEY (idmaestrofuncion) REFERENCES informes.maestro_funcion (idmaestrofuncion) ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE informes.informe_parametro_evento ADD CONSTRAINT FK_idimplementacion_funcion
	FOREIGN KEY (idimplementacion_funcion) REFERENCES informes.implementacion_funcion (idimplementacion_funcion) ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE informes.informe_parametro_evento ADD CONSTRAINT FK_informe_idInforme
	FOREIGN KEY (idinforme) REFERENCES informes.informe (idinforme) ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE informes.informe_parametro_evento ADD CONSTRAINT FK_maestro_evento
	FOREIGN KEY (idmaestroevento) REFERENCES informes.maestro_evento (idmaestroevento) ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE informes.informe_parametro_evento ADD CONSTRAINT FK_parametro_idParametro
	FOREIGN KEY (idparametro) REFERENCES informes.parametro (idparametro) ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE informes.parametro ADD CONSTRAINT FK_tipo_widget_idTipo_widget
	FOREIGN KEY (idtipo_widget) REFERENCES informes.tipo_widget (idtipo_widget) ON DELETE No Action ON UPDATE No Action
;
