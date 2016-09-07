-- CATEGORIAS
INSERT INTO informes.categoria(idcategoria, name, orden, activo, descripcion) VALUES (1, 'Licenciamento', 0, true, 'Expedientes de licenciamiento minero');
INSERT INTO informes.categoria(idcategoria, name, orden, activo, descripcion) VALUES (2, 'Direitos', 1, true, 'derechos mineros');
--INSERT INTO informes.categoria(idcategoria, name, orden, activo, descripcion) VALUES (3, 'Títulos', 2, false, 'Categoría de títulos');
--INSERT INTO informes.categoria(idcategoria, name, orden, activo, descripcion) VALUES (4, 'categoria_4', 3, false, 'categoria_4');

-- INFORMES EXPEDIENTES
INSERT INTO informes.informe(idinforme, nombre, path_informe, descripcion) VALUES (1, 'Lista dos direitos mineiros', '/srv/datos/silcam/reports/licenciamiento/podm','Lista de todos los derechos');
INSERT INTO informes.informe(idinforme, nombre, path_informe, descripcion) VALUES (2, 'Lista dos direitos mineiros para tipos de título', '/srv/datos/silcam/reports/licenciamiento/derechos','Lista de todos los derechos agrupados por tipo de titulo');
INSERT INTO informes.informe(idinforme, nombre, path_informe, descripcion) VALUES (3, 'Lista dos direitos mineiros para recursos minerais', '/srv/datos/silcam/reports/licenciamiento/minerales','Lista de todos los derechos agrupados por recurso mineral');
INSERT INTO informes.informe(idinforme, nombre, path_informe, descripcion) VALUES (17, 'Lista dos direitos mineiros por área', '/srv/datos/silcam/reports/licenciamiento/podm_por_area','Lista de todos los derechos por área');
INSERT INTO informes.informe(idinforme, nombre, path_informe, descripcion) VALUES (18, 'Lista dos expedientes', '/srv/datos/silcam/reports/licenciamiento/expedientes','Lista de todos los expedientes');
INSERT INTO informes.informe(idinforme, nombre, path_informe, descripcion) VALUES (16, 'Lista dos expedientes para tipos de pedido', '/srv/datos/silcam/reports/licenciamiento/tipo_pedido','Lista de expedientes agrupados por tipo de pedido');
INSERT INTO informes.informe(idinforme, nombre, path_informe, descripcion) VALUES (19, 'Lista dos expedientes para tipos de fase', '/srv/datos/silcam/reports/licenciamiento/tipo_fase','Lista de expedientes agrupados por tipo de fase');
-- Informes descartados (ver leeeme)
--INSERT INTO informes.informe(idinforme, nombre, path_informe, descripcion) VALUES (21, 'Lista dos expedientes abertos para tipos de pedido', '/srv/datos/silcam/reports/licenciamiento/tipo_pedido_abertos','Lista de expedientes abertos agrupados por tipo de pedido');
--INSERT INTO informes.informe(idinforme, nombre, path_informe, descripcion) VALUES (22, 'Lista dos expedientes abertos para tipos de fase', '/srv/datos/silcam/reports/licenciamiento/tipo_fase_abertos','Lista de expedientes abertos agrupados por tipo de fase');
INSERT INTO informes.informe(idinforme, nombre, path_informe, descripcion) VALUES (23, 'Lista dos direitos mineiros com coordenadas', '/srv/datos/silcam/reports/licenciamiento/podm_con_coordenadas','Lista de todos los derechos con sus coordenadas');


-- INFORMES DERECHOS MINEROS
INSERT INTO informes.informe(idinforme, nombre, path_informe, descripcion) VALUES (4, 'Lista dos recursos minerais dos títulos', '/srv/datos/silcam/reports/titulos/recursos','Lista de todos los recursos minerales agrupados por titulos');
INSERT INTO informes.informe(idinforme, nombre, path_informe, descripcion) VALUES (5, 'Lista dos recursos minerais dos títulos vigentes', '/srv/datos/silcam/reports/titulos/recursos_vigentes','Lista de todos los recursos minerales agrupados por titulos vigentes');
INSERT INTO informes.informe(idinforme, nombre, path_informe, descripcion) VALUES (6, 'Lista dos recursos minerais dos títulos vigentes para provincia', '/srv/datos/silcam/reports/titulos/recursos_vigentes_provincia','Lista de todos los recursos minerales agrupados por titulos vigentes agrupados por provincia');
INSERT INTO informes.informe(idinforme, nombre, path_informe, descripcion) VALUES (7, 'Lista dos recursos minerais dos títulos para provincia', '/srv/datos/silcam/reports/titulos/recursos_minerales_provincia','Lista de todos los recursos minerales agrupados agrupados por provincia');
INSERT INTO informes.informe(idinforme, nombre, path_informe, descripcion) VALUES (8, 'Lista dos tipos de títulos', '/srv/datos/silcam/reports/titulos/tipo_titulo','Lista de los tipos de derechos');
INSERT INTO informes.informe(idinforme, nombre, path_informe, descripcion) VALUES (9, 'Lista dos tipos de títulos para estado', '/srv/datos/silcam/reports/titulos/tipo_titulo_estado','Lista de los tipos de derechos por estado');
INSERT INTO informes.informe(idinforme, nombre, path_informe, descripcion) VALUES (10, 'Lista dos tipos de títulos dos títulos vigentes', '/srv/datos/silcam/reports/titulos/tipo_titulo_vigentes','Lista de los tipos de derechos vigentes');
INSERT INTO informes.informe(idinforme, nombre, path_informe, descripcion) VALUES (11, 'Lista dos títulos vigentes', '/srv/datos/silcam/reports/titulos/titulos_vigentes','Lista de los derechos vigentes');
INSERT INTO informes.informe(idinforme, nombre, path_informe, descripcion) VALUES (12, 'Lista dos títulos com coordenadas', '/srv/datos/silcam/reports/titulos/titulo_coordenadas','Lista de los derechos (con coordenadas)');
INSERT INTO informes.informe(idinforme, nombre, path_informe, descripcion) VALUES (13, 'Lista dos títulos vigentes com coordenadas', '/srv/datos/silcam/reports/titulos/titulo_coordenadas_vigentes','Lista de los derechos vigentes (con coordenadas)');
INSERT INTO informes.informe(idinforme, nombre, path_informe, descripcion) VALUES (14, 'Lista dos títulos com área', '/srv/datos/silcam/reports/titulos/titulos_area','Lista de los derechos (con area)');
INSERT INTO informes.informe(idinforme, nombre, path_informe, descripcion) VALUES (15, 'Lista dos títulos vigentes com área', '/srv/datos/silcam/reports/titulos/titulos_area_vigente','Lista de los derechos vigentes (con area)');

-- TIPOS PARAMETROS HTML DISPONIBLES
INSERT INTO informes.tipo_widget(idtipo_widget, nombre, descripcion) VALUES (1, 'select', 'Combo para seleccionar valores del filtro');
INSERT INTO informes.tipo_widget(idtipo_widget, nombre, descripcion) VALUES (2, 'input', 'Casilla para meter un valor del filtro');
INSERT INTO informes.tipo_widget(idtipo_widget, nombre, descripcion) VALUES (3, 'date', 'Filtrar por fecha');
INSERT INTO informes.tipo_widget(idtipo_widget, nombre, descripcion) VALUES (4, 'checkbox', 'Checkbox para valores binario');
	
-- PARAMETROS DISPONIBLES
INSERT INTO informes.parametro(idparametro, label, nombre, descripcion, idtipo_widget, url, valor_defecto) VALUES (1, 'PROVÍNCIA', 'provincia', 'filtro por província', 1, 'rest/maestros/select/provincias/pais/7', '');
INSERT INTO informes.parametro(idparametro, label, nombre, descripcion, idtipo_widget, url, valor_defecto) VALUES (2, 'DATA EXPIRAÇÃO DESDE', 'dataExpiracaoDesde', 'Fecha expiraçao desde', 3, '', '');
INSERT INTO informes.parametro(idparametro, label, nombre, descripcion, idtipo_widget, url, valor_defecto) VALUES (3, 'DATA EXPIRAÇÃO ATÉ', 'dataExpiracaoHasta', 'Fecha expiraçao Hasta', 3, '', '');
INSERT INTO informes.parametro(idparametro, label, nombre, descripcion, idtipo_widget, url, valor_defecto) VALUES (4, 'TIPO DE MINERAL', 'mineral', 'filtro por  recurso', 1, 'rest/maestros/select/resourcesmineros', '');
INSERT INTO informes.parametro(idparametro, label, nombre, descripcion, idtipo_widget, url, valor_defecto) VALUES (5, 'MINERAIS DO GRUPO', 'grupo_mineral', 'filtro por tipo grupo recurso', 1, 'rest/maestros/select/tiposgruporecurso', '');
INSERT INTO informes.parametro(idparametro, label, nombre, descripcion, idtipo_widget, url, valor_defecto) VALUES (6, 'ESTADO', 'estado', 'estados derecho minero', 1, 'rest/maestros/select/estadosdireitomineiro', '');
INSERT INTO informes.parametro(idparametro, label, nombre, descripcion, idtipo_widget, url, valor_defecto) VALUES (7, 'MUNICÍPIO', 'municipio', 'Filtro por municipio', 1, '', '');
INSERT INTO informes.parametro(idparametro, label, nombre, descripcion, idtipo_widget, url, valor_defecto) VALUES (8, 'REPRESENTANTE', 'representante', 'filtro por representante', 2, '', 'Representante1');
INSERT INTO informes.parametro(idparametro, label, nombre, descripcion, idtipo_widget, url, valor_defecto) VALUES (9, 'Área >=', 'areaMayorOIgual', 'filtro por área mayor o igual', 2, '', '');
INSERT INTO informes.parametro(idparametro, label, nombre, descripcion, idtipo_widget, url, valor_defecto) VALUES (10, 'Área <=', 'areaMenorOIgual', 'filtro por área menor o igual', 2, '', '');
INSERT INTO informes.parametro(idparametro, label, nombre, descripcion, idtipo_widget, url, valor_defecto) VALUES (11, 'Unidade de superfície', 'unidadSuperficie', 'filtro por unidad de superficie', 1, 'rest/maestros/select/unidadesSuperficie', '');
INSERT INTO informes.parametro(idparametro, label, nombre, descripcion, idtipo_widget, url, valor_defecto) VALUES (12, 'Estado do expediente', 'estadoExpediente', 'filtro por estado de expediente', 1, 'rest/maestros/select/estadosExpedientes', '');
INSERT INTO informes.parametro(idparametro, label, nombre, descripcion, idtipo_widget, url, valor_defecto) VALUES (13, 'Data do pedido desde', 'dataPedidoDesde', 'Fecha de pedido desde', 3, '', '');
INSERT INTO informes.parametro(idparametro, label, nombre, descripcion, idtipo_widget, url, valor_defecto) VALUES (14, 'Data do pedido até', 'dataPedidoHasta', 'Fecha de pedido hasta', 3, '', '');
INSERT INTO informes.parametro(idparametro, label, nombre, descripcion, idtipo_widget, url, valor_defecto) VALUES (15, 'Tipo de pedido', 'tipoPedido', 'Filtro por tipo de pedido', 1, 'rest/maestros/select/tiposPedido', '');
INSERT INTO informes.parametro(idparametro, label, nombre, descripcion, idtipo_widget, url, valor_defecto) VALUES (16, 'Tipo de título', 'tipoTitulo', 'Filtro por tipo de pedido', 1, 'rest/maestros/select/tiposDerechosMineros', '');
INSERT INTO informes.parametro(idparametro, label, nombre, descripcion, idtipo_widget, url, valor_defecto) VALUES (17, 'EXCLUIR LEVANTAMENTO', 'excluirLevantamento','Filtrar los expedientes de Levantamiento',4,'','');
INSERT INTO informes.parametro(idparametro, label, nombre, descripcion, idtipo_widget, url, valor_defecto) VALUES (18, 'DATA OUTORGA DESDE', 'dataOutorgaDesde', 'Fecha Outorga desde', 3, '', '');
INSERT INTO informes.parametro(idparametro, label, nombre, descripcion, idtipo_widget, url, valor_defecto) VALUES (19, 'DATA OUTORGA ATÉ', 'dataOutorgaHasta', 'Fecha Outorga Hasta', 3, '', '');
INSERT INTO informes.parametro(idparametro, label, nombre, descripcion, idtipo_widget, url, valor_defecto) VALUES (20, 'Fase do Expediente', 'faseExpediente', 'Filtro por fase de expediente', 1, 'rest/maestros/select/fasesExpediente', '');

-- RELACION CATEGORIA-INFORME
INSERT INTO informes.categoria_informe(idcategoria, idinforme, orden, activo) VALUES (1, 1, 0, true);
INSERT INTO informes.categoria_informe(idcategoria, idinforme, orden, activo) VALUES (1, 2, 2, true);
INSERT INTO informes.categoria_informe(idcategoria, idinforme, orden, activo) VALUES (1, 3, 3, true); 
INSERT INTO informes.categoria_informe(idcategoria, idinforme, orden, activo) VALUES (1, 17, 4, true);
INSERT INTO informes.categoria_informe(idcategoria, idinforme, orden, activo) VALUES (1, 18, 5, true);
INSERT INTO informes.categoria_informe(idcategoria, idinforme, orden, activo) VALUES (1, 16, 6, true); 
INSERT INTO informes.categoria_informe(idcategoria, idinforme, orden, activo) VALUES (1, 19, 7, true);
--INSERT INTO informes.categoria_informe(idcategoria, idinforme, orden, activo) VALUES (1, 21, 8, true);
--INSERT INTO informes.categoria_informe(idcategoria, idinforme, orden, activo) VALUES (1, 22, 9, true);
INSERT INTO informes.categoria_informe(idcategoria, idinforme, orden, activo) VALUES (1, 23, 1, true);

INSERT INTO informes.categoria_informe(idcategoria, idinforme, orden, activo) VALUES (2, 4, 0, true);
INSERT INTO informes.categoria_informe(idcategoria, idinforme, orden, activo) VALUES (2, 5, 1, true);
INSERT INTO informes.categoria_informe(idcategoria, idinforme, orden, activo) VALUES (2, 6, 2, true);
INSERT INTO informes.categoria_informe(idcategoria, idinforme, orden, activo) VALUES (2, 7, 3, true);
INSERT INTO informes.categoria_informe(idcategoria, idinforme, orden, activo) VALUES (2, 8, 4, true);
INSERT INTO informes.categoria_informe(idcategoria, idinforme, orden, activo) VALUES (2, 9, 5, true);
INSERT INTO informes.categoria_informe(idcategoria, idinforme, orden, activo) VALUES (2, 10, 6, true);
INSERT INTO informes.categoria_informe(idcategoria, idinforme, orden, activo) VALUES (2, 11, 7, true);
INSERT INTO informes.categoria_informe(idcategoria, idinforme, orden, activo) VALUES (2, 12, 8, true);
INSERT INTO informes.categoria_informe(idcategoria, idinforme, orden, activo) VALUES (2, 13, 9, true);
INSERT INTO informes.categoria_informe(idcategoria, idinforme, orden, activo) VALUES (2, 14, 10, true);
INSERT INTO informes.categoria_informe(idcategoria, idinforme, orden, activo) VALUES (2, 15, 11, true);

-- EVENTOS DISPONIBLES
INSERT INTO informes.maestro_evento(idmaestroevento, nombre, descripcion) VALUES (1, '', '');
INSERT INTO informes.maestro_evento(idmaestroevento, nombre, descripcion) VALUES (2, 'onchange', 'onchange');
INSERT INTO informes.maestro_evento(idmaestroevento, nombre, descripcion) VALUES (3, 'onkeypress', 'onkeypress');
INSERT INTO informes.maestro_evento(idmaestroevento, nombre, descripcion) VALUES (4, 'onkeypress="return NumCheck(event, this)" onchange', 'onchange de un rango numerico');



-- FUNCIONES DISPONIBLES
INSERT INTO informes.maestro_funcion(idmaestrofuncion, nombre, descripcion, parametros) VALUES (1, '', '', '');
INSERT INTO informes.maestro_funcion(idmaestrofuncion, nombre, descripcion, parametros) VALUES (2, 'libre', 'definida por el usuario', '');
INSERT INTO informes.maestro_funcion(idmaestrofuncion, nombre, descripcion, parametros) VALUES (3, 'onChangeRecargarSelecHijo', 'onChangeRecargarSelecHijo', 'str_id_select_hijo, str_url_path_relative_rest');
INSERT INTO informes.maestro_funcion(idmaestrofuncion, nombre, descripcion, parametros) VALUES (4, 'onChangeValidarRangoFecha', 'onChangeValidarRangoFecha', 'strIdFechaMinima, strIdFechaMaxima');
INSERT INTO informes.maestro_funcion(idmaestrofuncion, nombre, descripcion, parametros) VALUES (5, 'onChangeValidarRangoNumbers', 'onChangeValidarRangoNumbers', 'strIdNumberMin, strIdNumberMax');
INSERT INTO informes.maestro_funcion(idmaestrofuncion, nombre, descripcion, parametros) VALUES (6, 'return NumCheck', 'onkeypress="return NumCheck(event, this)"', 'event, this');

-- FUNCIONES JAVASCRIPT DISPONIBLES
INSERT INTO informes.implementacion_funcion(idimplementacion_funcion, idmaestrofuncion, parametros, descripcion) VALUES (
1, 
3,
'''municipio'', ''http://silcam.igeo.satec.es:8080/core-services-rest/rest/maestros/select/municipios/provincia/?''', 
'cargo el municipio segun la provincia elegida');

INSERT INTO informes.implementacion_funcion(idimplementacion_funcion, idmaestrofuncion, parametros, descripcion) VALUES (
2,
1, 
'', 
'');

INSERT INTO informes.implementacion_funcion(idimplementacion_funcion, idmaestrofuncion, parametros, descripcion) VALUES (
3,
1, 
'', 
'');

 INSERT INTO informes.implementacion_funcion(idimplementacion_funcion, idmaestrofuncion, parametros, descripcion) VALUES (
4, 
4,
'''dataOutorgaDesde'', ''dataOutorgaHasta''', 
'valida que el rango de fechas sea correcto');

 INSERT INTO informes.implementacion_funcion(idimplementacion_funcion, idmaestrofuncion, parametros, descripcion) VALUES (
5, 
4,
'''dataExpiracaoDesde'', ''dataExpiracaoHasta''', 
'valida que el rango de fechas sea correcto');


 INSERT INTO informes.implementacion_funcion(idimplementacion_funcion, idmaestrofuncion, parametros, descripcion) VALUES (
6, 
5,
'''areaMayorOIgual'', ''areaMenorOIgual''', 
'valida que el rango de areas sea correcto');

 INSERT INTO informes.implementacion_funcion(idimplementacion_funcion, idmaestrofuncion, parametros, descripcion) VALUES (
7, 
6,
'event, this', 
'valida que el campo sea un numerico');


 INSERT INTO informes.implementacion_funcion(idimplementacion_funcion, idmaestrofuncion, parametros, descripcion) VALUES (
8, 
4,
'''dataPedidoDesde'', ''dataPedidoHasta''', 
'valida que el rango de fechas sea correcto');

 -- RELACION DE INFORME_PARAMETRO_EVENTO
-- LISTA DOS DIREITOS MINEIROS: [DATA OUTORGA DESDE, DATA OUTORGA ATÉ, DATA EXPIRAÇÃO DESDE, DATA EXPIRAÇÃO ATÉ, ESTADO, REPRESENTANTE, TIPO DE MINERAL, MINERAIS DO GRUPO, PROVÍNCIA, MUNICÍPIO]
INSERT INTO informes.informe_parametro_evento(idinforme, idparametro, idmaestroevento, idimplementacion_funcion, activo, orden, obligatorio) VALUES (1, 18, 2, 4, true, 0, false); 
INSERT INTO informes.informe_parametro_evento(idinforme, idparametro, idmaestroevento, idimplementacion_funcion, activo, orden, obligatorio) VALUES (1, 19, 2, 4, true, 1, false);
INSERT INTO informes.informe_parametro_evento(idinforme, idparametro, idmaestroevento, idimplementacion_funcion, activo, orden, obligatorio) VALUES (1, 2, 2, 5, true, 2, false);
INSERT INTO informes.informe_parametro_evento(idinforme, idparametro, idmaestroevento, idimplementacion_funcion, activo, orden, obligatorio) VALUES (1, 3, 2, 5, true, 3, false);
INSERT INTO informes.informe_parametro_evento(idinforme, idparametro, idmaestroevento, idimplementacion_funcion, activo, orden, obligatorio) VALUES (1, 6, 1, 3, true, 4, false);
INSERT INTO informes.informe_parametro_evento(idinforme, idparametro, idmaestroevento, idimplementacion_funcion, activo, orden, obligatorio) VALUES (1, 8, 1, 3, true, 5, false);
INSERT INTO informes.informe_parametro_evento(idinforme, idparametro, idmaestroevento, idimplementacion_funcion, activo, orden, obligatorio) VALUES (1, 4, 1, 3, true, 6, false);
INSERT INTO informes.informe_parametro_evento(idinforme, idparametro, idmaestroevento, idimplementacion_funcion, activo, orden, obligatorio) VALUES (1, 5, 1, 3, true, 7, false);
INSERT INTO informes.informe_parametro_evento(idinforme, idparametro, idmaestroevento, idimplementacion_funcion, activo, orden, obligatorio) VALUES (1, 1, 2, 1, true, 8, false);
INSERT INTO informes.informe_parametro_evento(idinforme, idparametro, idmaestroevento, idimplementacion_funcion, activo, orden, obligatorio) VALUES (1, 7, 1, 3, true, 9, false); 

--LISTA DOS DIREITOS MINEIROS COM COORDENADAS:
INSERT INTO informes.informe_parametro_evento(idinforme, idparametro, idmaestroevento, idimplementacion_funcion, activo, orden, obligatorio) VALUES (23, 18, 2, 4, true, 0, false); 
INSERT INTO informes.informe_parametro_evento(idinforme, idparametro, idmaestroevento, idimplementacion_funcion, activo, orden, obligatorio) VALUES (23, 19, 2, 4, true, 1, false);
INSERT INTO informes.informe_parametro_evento(idinforme, idparametro, idmaestroevento, idimplementacion_funcion, activo, orden, obligatorio) VALUES (23, 2, 2, 5, true, 2, false);
INSERT INTO informes.informe_parametro_evento(idinforme, idparametro, idmaestroevento, idimplementacion_funcion, activo, orden, obligatorio) VALUES (23, 3, 2, 5, true, 3, false);
INSERT INTO informes.informe_parametro_evento(idinforme, idparametro, idmaestroevento, idimplementacion_funcion, activo, orden, obligatorio) VALUES (23, 6, 1, 3, true, 4, false);
INSERT INTO informes.informe_parametro_evento(idinforme, idparametro, idmaestroevento, idimplementacion_funcion, activo, orden, obligatorio) VALUES (23, 8, 1, 3, true, 5, false);
INSERT INTO informes.informe_parametro_evento(idinforme, idparametro, idmaestroevento, idimplementacion_funcion, activo, orden, obligatorio) VALUES (23, 4, 1, 3, true, 6, false);
INSERT INTO informes.informe_parametro_evento(idinforme, idparametro, idmaestroevento, idimplementacion_funcion, activo, orden, obligatorio) VALUES (23, 5, 1, 3, true, 7, false);
INSERT INTO informes.informe_parametro_evento(idinforme, idparametro, idmaestroevento, idimplementacion_funcion, activo, orden, obligatorio) VALUES (23, 1, 2, 1, true, 8, false);
INSERT INTO informes.informe_parametro_evento(idinforme, idparametro, idmaestroevento, idimplementacion_funcion, activo, orden, obligatorio) VALUES (23, 7, 1, 3, true, 9, false); 

-- LISTA DOS DIREITOS MINEIROS PARA TIPOS DE TÍTULO: [PROVÍNCIA, TIPO DE MINERAL, MINERAIS DO GRUPO, ESTADO]
INSERT INTO informes.informe_parametro_evento(idinforme, idparametro, idmaestroevento, idimplementacion_funcion, activo, orden, obligatorio) VALUES (2, 1, 1, 1, true, 0, false);
INSERT INTO informes.informe_parametro_evento(idinforme, idparametro, idmaestroevento, idimplementacion_funcion, activo, orden, obligatorio) VALUES (2, 4, 1, 3, true, 1, false);
INSERT INTO informes.informe_parametro_evento(idinforme, idparametro, idmaestroevento, idimplementacion_funcion, activo, orden, obligatorio) VALUES (2, 5, 1, 3, true, 2, false);
INSERT INTO informes.informe_parametro_evento(idinforme, idparametro, idmaestroevento, idimplementacion_funcion, activo, orden, obligatorio) VALUES (2, 6, 1, 3, true, 3, false);

-- LISTA DOS DIREITOS MINEIROS PARA RESCURSOS: MINERAIS [PROVÍNCIA, ESTADO]
INSERT INTO informes.informe_parametro_evento(idinforme, idparametro, idmaestroevento, idimplementacion_funcion, activo, orden, obligatorio) VALUES (3, 1, 1, 1, true, 0, false);
INSERT INTO informes.informe_parametro_evento(idinforme, idparametro, idmaestroevento, idimplementacion_funcion, activo, orden, obligatorio) VALUES (3, 6, 2, 3, true, 1, false);

-- LISTA DOS DIREITOS MINEIROS POR ÁREA: [DATA EXPIRAÇÃO DESDE, DATA EXPIRAÇÃO ATÉ, ESTADO, REPRESENTANTE, TIPO DE MINERAL, MINERAIS DO GRUPO, PROVÍNCIA, MUNICÍPIO, Área >=, Área <=, Unidade de superfície]
INSERT INTO informes.informe_parametro_evento(idinforme, idparametro, idmaestroevento, idimplementacion_funcion, activo, orden, obligatorio) VALUES (17, 2, 2, 5, true, 0, false);
INSERT INTO informes.informe_parametro_evento(idinforme, idparametro, idmaestroevento, idimplementacion_funcion, activo, orden, obligatorio) VALUES (17, 3, 2, 5, true, 1, false);
INSERT INTO informes.informe_parametro_evento(idinforme, idparametro, idmaestroevento, idimplementacion_funcion, activo, orden, obligatorio) VALUES (17, 6, 1, 3, true, 2, false);
INSERT INTO informes.informe_parametro_evento(idinforme, idparametro, idmaestroevento, idimplementacion_funcion, activo, orden, obligatorio) VALUES (17, 8, 1, 3, true, 3, false);
INSERT INTO informes.informe_parametro_evento(idinforme, idparametro, idmaestroevento, idimplementacion_funcion, activo, orden, obligatorio) VALUES (17, 4, 1, 3, true, 4, false);
INSERT INTO informes.informe_parametro_evento(idinforme, idparametro, idmaestroevento, idimplementacion_funcion, activo, orden, obligatorio) VALUES (17, 5, 1, 3, true, 5, false);
INSERT INTO informes.informe_parametro_evento(idinforme, idparametro, idmaestroevento, idimplementacion_funcion, activo, orden, obligatorio) VALUES (17, 1, 2, 1, true, 6, false);
INSERT INTO informes.informe_parametro_evento(idinforme, idparametro, idmaestroevento, idimplementacion_funcion, activo, orden, obligatorio) VALUES (17, 7, 1, 3, true, 7, false);
INSERT INTO informes.informe_parametro_evento(idinforme, idparametro, idmaestroevento, idimplementacion_funcion, activo, orden, obligatorio) VALUES (17, 9, 4, 6, true, 8, false);
INSERT INTO informes.informe_parametro_evento(idinforme, idparametro, idmaestroevento, idimplementacion_funcion, activo, orden, obligatorio) VALUES (17, 10, 4, 6, true, 9, false);
INSERT INTO informes.informe_parametro_evento(idinforme, idparametro, idmaestroevento, idimplementacion_funcion, activo, orden, obligatorio) VALUES (17, 11, 1, 3, true, 10, false);
INSERT INTO informes.informe_parametro_evento(idinforme, idparametro, idmaestroevento, idimplementacion_funcion, activo, orden, obligatorio) VALUES (17, 16, 1, 3, true, 11, false);


-- LISTA DOS EXPEDIENTES PARA TIPOS DE PEDIDO [EXCLUIR LEVANTAMENTO]
INSERT INTO informes.informe_parametro_evento(idinforme, idparametro, idmaestroevento, idimplementacion_funcion, activo, orden, obligatorio) VALUES (16, 17, 1, 3, true, 0, false); 

-- LISTA DOS EXPEDIENTES: [Data do pedido desde, Data do pedido até, Tipo de pedido, Tipo de título, Estado do expediente]
INSERT INTO informes.informe_parametro_evento(idinforme, idparametro, idmaestroevento, idimplementacion_funcion, activo, orden, obligatorio) VALUES (18, 13, 2, 8, true, 0, false);
INSERT INTO informes.informe_parametro_evento(idinforme, idparametro, idmaestroevento, idimplementacion_funcion, activo, orden, obligatorio) VALUES (18, 14, 2, 8, true, 1, false);
INSERT INTO informes.informe_parametro_evento(idinforme, idparametro, idmaestroevento, idimplementacion_funcion, activo, orden, obligatorio) VALUES (18, 15, 1, 3, true, 2, false);
INSERT INTO informes.informe_parametro_evento(idinforme, idparametro, idmaestroevento, idimplementacion_funcion, activo, orden, obligatorio) VALUES (18, 16, 1, 3, true, 3, false);
INSERT INTO informes.informe_parametro_evento(idinforme, idparametro, idmaestroevento, idimplementacion_funcion, activo, orden, obligatorio) VALUES (18, 17, 1, 3, true, 4, false);

-- LISTA DOS EXPEDIENTES PARA TIPOS DE FASE [EXCLUIR LEVANTAMENTO]
INSERT INTO informes.informe_parametro_evento(idinforme, idparametro, idmaestroevento, idimplementacion_funcion, activo, orden, obligatorio) VALUES (19, 17, 1, 3, true, 0, false);

-- LISTA DOS EXPEDIENTES ABERTOS PARA TIPOS DE FASE [EXCLUIR LEVANTAMENTO]
-- INSERT INTO informes.informe_parametro_evento(idinforme, idparametro, idmaestroevento, idimplementacion_funcion, activo, orden, obligatorio) VALUES (21, 17, 1, 3, true, 0, false);

-- LISTA DOS EXPEDIENTES ABERTOS PARA TIPOS DE PEDIDO [EXCLUIR LEVANTAMENTO]
--INSERT INTO informes.informe_parametro_evento(idinforme, idparametro, idmaestroevento, idimplementacion_funcion, activo, orden, obligatorio) VALUES (22, 17, 1, 3, true, 0, false);


-- PERMISOS DISPONIBLES
INSERT INTO informes.permiso(idpermiso, nombre, descripcion, codigo) VALUES (1, 'Repartição Administrativa', 'Repartição Administrativa', 'RSA');
INSERT INTO informes.permiso(idpermiso, nombre, descripcion, codigo) VALUES (2, 'Gabinete do Director', 'Gabinete do Director', 'GD');
INSERT INTO informes.permiso(idpermiso, nombre, descripcion, codigo) VALUES (3, 'Gabinete Jurídico', 'Gabinete Jurídico', 'GJ');
INSERT INTO informes.permiso(idpermiso, nombre, descripcion, codigo) VALUES (4, 'Gabinete do Ministro', 'Gabinete do Ministro', 'GM');

-- PERMISOS RELACIONADOS CON CATEGORIAS
INSERT INTO informes.categoria_permiso(idcategoria, idpermiso) VALUES (1, 1);
INSERT INTO informes.categoria_permiso(idcategoria, idpermiso) VALUES (1, 2);
INSERT INTO informes.categoria_permiso(idcategoria, idpermiso) VALUES (1, 3);
INSERT INTO informes.categoria_permiso(idcategoria, idpermiso) VALUES (1, 4);

INSERT INTO informes.categoria_permiso(idcategoria, idpermiso) VALUES (2, 1);
INSERT INTO informes.categoria_permiso(idcategoria, idpermiso) VALUES (2, 2);
INSERT INTO informes.categoria_permiso(idcategoria, idpermiso) VALUES (2, 3);
INSERT INTO informes.categoria_permiso(idcategoria, idpermiso) VALUES (2, 4);

--INSERT INTO informes.categoria_permiso(idcategoria, idpermiso) VALUES (3, 3);
--INSERT INTO informes.categoria_permiso(idcategoria, idpermiso) VALUES (3, 4);

--INSERT INTO informes.categoria_permiso(idcategoria, idpermiso) VALUES (4, 4);

