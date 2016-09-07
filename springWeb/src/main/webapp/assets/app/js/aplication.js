var userLang = navigator.language || navigator.userLanguage;
var locale = userLang.split('-')[0];
	
console.log(locale);
	
/**
 * configuracion de los datapickers
 */
$(function () 
{                
	$("div[id^='date_']").datepicker(
    {
        //language: 'pt'
        language: locale,
        format: 'dd/mm/yyyy',
        todayHighlight: true,
        //clearBtn: true,
        todayBtn: "linked"
		
    });
});

	
function bloqueaPantalla() 
{
	$.blockUI(
	{
		message : '<div class="row"><div class="col-xs-12"><div id="progreso" class="circuloprogreso" /></div><div class="col-xs-12">Por favor, aguarde.</div></div>',
		overlayCSS : 
		{
			backgroundColor : '#e8e8e8'
		},
		css : 
		{
			color : '#cc092f',
			border : "2px solid #cc092f",
			top : "300px"
		}
	});
}


function desbloqueaPantalla() 
{
	$.unblockUI();
}


// ACTIVAMOS EL ICONO DE CARGANDO CUANDO SE REALIZA UNA PETICION AJAX
// $(document).ajaxStart(bloqueaPantalla()).ajaxStop(desbloqueaPantalla());

// ACTIVAMOS EL ICONO DE CARGANDO CUANDO SE REALIZA UNA PETICION HTTP
$(document).ready(
function() 
{
	// INSERTAMOS ESTA CABECERA EN TODAS LAS PETICIONES AJAX PARA QUE SE
	// PROPAGUE LA COOKIE DE CAS EN LAS REDIRECCIONES
	jQuery.ajaxSetup(
	{
		xhrFields : 
		{
			withCredentials : true
		},
		beforeSend : function() 
		{
			bloqueaPantalla();
		},
		complete : function() 
		{
			desbloqueaPantalla();
		},
		error : function() 
		{
			desbloqueaPantalla();
		},
		success : function() 
		{
			desbloqueaPantalla();
		}
	});

	$(":button, :submit, a, .Blockui")
		.not("[class='dropdown-toggle']")
		.not("[data-toggle='tab']")
		.not("[data-toggle='collapse']")
		.not("[data-block='notBlockui']")
		.not("[block='notBlockui']")
		.not("[class='notBlockui']")
		.not("[class='notBlockui ui-tabs-anchor']")
		.click(
			function() 
			{
				bloqueaPantalla();
			});
});