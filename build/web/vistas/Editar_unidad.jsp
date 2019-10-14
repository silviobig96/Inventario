<%@page import="modelo.Raza"%>
<%@page import="modelo.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Finca"%>
<%@page import="modelo.Dao_finca"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actualizacion de Unidad</title>
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <link rel="stylesheet" href="vistas/css/bootstrap.min.css">
        <link rel="stylesheet" href="vistas/css/estilos_editar_unidad.css">
    </head>
    <body>
       <%@include file="menuser.jsp" %>
	<div class="jumbotron">
            <div class="conatiner">
                <h1 style="color:  white">Actualizacion de Unidad</h1>
                <p class="lead">Esta opcion del sistema le permite Actualizar los datos de una Unidad.</p>
            </div>		
	</div>
	
	
        <div class="card" style="max-width: 100%;">
        <%
            Raza raza = (Raza)request.getAttribute("raza");
        %>
            <h3 class="card-header" align = "center" >Actualizacion de Unidad</h3>
            <form action="Controlador_unidad" method="post">
                <div class="form-group">
                    <div class="row">
                        <div class="col-md-1">
                        <label for="tipo">Decanato al que pertenece:</label>
                        </div>
                        <div class="col-md-5">
                            <select class="form-control" name="tipo" id="tipo">
                                <option name ="administrador" >DCyT</option>                         
                                <option name ="ganadero">Medicina</option>
                                <option name ="ganadero">Dac</option>
                            </select>
                        </div>
                        <div class="col-md-1">
                            <label for="nombre">Nombre:</label>
                        </div>
                        <div class="col-md-5">
                            <input type="text" class="form-control" required name="nombre" id="descripcion"  placeholder="Nombre de la Unidad">
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="centrar">
                        <button type="submit" name="accion" value="Actualizar" class="btn btn-primary">Actualizar</button>
                        
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
