<%@page import="modelo.Produccion"%>
<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="UTF-8">
	<title>Actualizacion de Produccion por Vacas</title>
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <link rel="stylesheet" href="vistas/css/bootstrap.min.css">
    <link rel="stylesheet" href="vistas/css/estilosActualProduc.css">
</head>
<body>
	<%@include file="menuNav.jsp" %>
	<div class="jumbotron">
		<div class="container">
			<h1>Actualizacion de Produccion de Leche Por Vaca</h1>
			  <p class="lead">En esta opcion del sistema le permite  hacer modificaciones en los registros de produccion de cada vaca en una fecha especifica.</p>
		</div>
	</div>
	<div class="card">
		
		<form action="Controlador_produccion" method="post">
                    <%
                        Produccion prod = (Produccion)request.getAttribute("txtidprod");
                    %>
			<div class="form-group">
				<div class="row">
					<div class="col-md-1">
			      		<label for="codigo">Codigo de la Vaca:</label>
					</div>
					<div class="col-md-3">
						<input type="text" value="<%= prod.getAnimal().getId_animal() %>" class="form-control" id="codigo" placeholder="Codigo de la vaca" disabled>
					</div>
				</div>
			</div>
			<hr>
			
				<div class="row">
					<div class="col-md-2">
						<label for="ordeno1">Ordeno 1:</label>
					</div>
					<div class="col-md-6">
						<input type="number"  class="form-control" required name="ordeno1" id="ordeno1" value="<%= prod.getOrdeño1() %>" placeholder="Litros de Leche">
					</div>
				</div>
			
			
				<div class="row">
					<div class="col-md-2">
						<label for="ordeno2">Ordeno 2:</label>
					</div>
					<div class="col-md-6">
						<input type="number"  class="form-control" required name="ordeno2" id="ordeno2" value="<%= prod.getOrdeño2() %>" placeholder="Litros de Leche" >
					</div>
				</div>
                                <input type="hidden" name="txtid" value="<%= prod.getId_produccion() %>" >
				
				<div class="row">
				 	<div class="form-group">
				 		<div class="centrar">
				     	 	<button type="submit" name="accion" value="guardar_cambios" class="btn btn-primary">Guardar Cambios</button>
		    				
				     	</div>
				 	</div>
				 </div>
		</form>
	
	</div>
	<%@include file="footer.jsp" %>
	<script src="vistas/js/jquery.js" ></script>
	<script src="vistas/js/bootstrap.min.js"></script>
</body>
</html>