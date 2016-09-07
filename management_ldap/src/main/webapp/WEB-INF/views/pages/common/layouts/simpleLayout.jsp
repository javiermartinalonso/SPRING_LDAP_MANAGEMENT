<%@ include file="../components/taglibs.jsp"%>

<!DOCTYPE html>
<html lang="es">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title><tiles:getAsString name="title" /></title>
		<tiles:insertAttribute name="assets" />
	<style>
		body {
			padding-top: 1px; /* 10px to make the container go all the way to the bottom of the topbar */
 		}
    </style>		
	</head>

	<body>
		<div id="container">
			<div class="row border-bottom-cabecera">
				<div class="col-xs-12 breadcrumb">
					<tiles:insertAttribute name="breadcrumb" />
				</div>
				
<!-- 				
				<div class="col-xs-3">
					<div class="info-user">

					</div>
				</div>
-->
						
			
			<div class="row">
				<div class="col-xs-12">
					<div class="contenido">
						<tiles:insertAttribute name="content" />
					</div>
				</div>
			</div>		
			
			<div class="row">
				<footer class="col-xs-12">
					<div class="footer">
						<tiles:insertAttribute name="footer" />
					</div>
				</footer>
			</div>	
		</div>	
		
		
		<script>
			$(document).ready(function(){
				
			});
		</script>
	</body>

</html>