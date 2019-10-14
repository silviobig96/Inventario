<%@page import="modelo.Produccion"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="UTF-8">
	<title>Solicitud de Reparacion</title>
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <link rel="stylesheet" href="vistas/css/bootstrap.min.css">
    <link rel="stylesheet" href="vistas/css/estilos_solicitud_reparacion.css">
</head>
<body>
	<%@include file="menuNav.jsp" %>
	<div class="jumbotron">
		<div class="container">
			<h1>Solicitud de Reparacion</h1>
			<p class="lead">Esta opcion del sistema le permite realizar una Solicitud de Reparacion para los equipos que esten dañados.</p>  
		</div>
	</div>
	<div class="card">
			<div class="form-group">
                            <form action="Controlador_produccion" method="post">
				<div class="form-group">
				<div class="row">
					<div class="col-md-2">
                                            <label>Seleccione el equipo dañado que desea reparar:</label>
                                        </div>
                                        <div class="col-md-4">
                                            <select class="form-control">

                                                                <option name ="" >Samsung S10</option>

                                            </select>
                                        </div>
				</div>
			</div>
                        <div class="row">
			 	<div class="form-group">
			 		<div class="centrar">
				     	<button type="submit" name="accion" value="Aceptar" onclick=" alert('Produccion Registrada con exito!')" class="btn btn-lg btn-primary">Aceptar</button>
			     	</div>
			 	</div>
			 </div>
                                </form>
			</div>
		
	</div>
	<%@include file="footer.jsp" %>
	<script src="vistas/js/jquery.js" ></script>
	<script src="vistas/js/bootstrap.min.js"></script>
</body>
</html>