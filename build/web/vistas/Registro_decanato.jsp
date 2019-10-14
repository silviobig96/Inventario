<%@page import="modelo.Usuario"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Registro de Decanatos</title>
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <link rel="stylesheet" href="vistas/css/bootstrap.min.css">
    <link rel="stylesheet" href="vistas/css/estilos_registro_decanatos.css">

</head>
<body>
    <%@include file="menuser.jsp" %>
	<div class="jumbotron">
		<div class="conatiner">
			<h1 style="color:  white">Registro de Decanatos</h1>
			  <p class="lead">Esta opcion del sistema le permite registrar los datos de los Decanatos de la universidad.</p>
		</div>
			
	</div>
	
	
        <div class="card" style="max-width: 100%;">
            <h3 class="card-header" align = "center" >Registro de Decanato</h3>
            <form action="Controlador_decanato" method="post">
                <br>
            <div class="form-group">
                <div class="row">
                    <div class="col-md-1">
                        <label for="nombre">Nombre:</label>
                    </div>
                    <div class="col-md-5">
                        <input type="text" class="form-control" required name="nombre" id="nombre"  placeholder="Nombre del Decanato">
                    </div>

                    <div class="col-md-1">
                        <label for="direccion">Direccion:</label>
                    </div>
                    <div class="col-md-5">
                        <input type="text" class="form-control" required name="direccion" id="direccion"  placeholder="Direccion del Decanato" >
                    </div>
                </div>
            </div>
         <div class="row">
            <div class="centrar">
                <button type="submit" name="accion" value="Aceptar" onclick=" alert('Decanato Registrado con exito!')" class="btn btn-primary">Aceptar</button>
            </div>
         </div>
                <br>

        </form>

</div>
	<%@include file="footer_admin.jsp" %>
	

	<script src="vistas/js/jquery.js" ></script>
	<script src="vistas/js/bootstrap.min.js"></script>
</body>
</html>
