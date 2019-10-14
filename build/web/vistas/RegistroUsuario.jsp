<!DOCTYPE html>
<html lang="es">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Registro de Usuarios</title>
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <link rel="stylesheet" href="vistas/css/bootstrap.min.css">
    <link rel="stylesheet" href="vistas/css/estilosRegistrarUsuario.css">

</head>
<body>
    <%@include file="menuser.jsp" %>
	<div class="jumbotron">
		<div class="conatiner">
			<h1 style="color:  white">Registro de Usuarios</h1>
			  <p class="lead">Esta opcion del sistema le permite registrar los datos de los usuarios.</p>
		</div>
			
	</div>
	
	
        <div class="card" style="max-width: 100%;">
            <h3 class="card-header" align = "center" >Registro de Usuario</h3>
            <form action="Controlador_usuario" method="post">
            <div class="form-group">
                <div class="row">
                    <div class="col-md-1">
                        <label for="nombre">Nombre:</label>
                    </div>
                    <div class="col-md-5">
                        <input type="text" class="form-control" required name="nombre" id="nombre"  placeholder="Nombre del Usuario">
                    </div>

                    <div class="col-md-1">
                        <label for="correo">Correo Electronico:</label>
                    </div>
                    <div class="col-md-5">
                        <input type="email" class="form-control" required name="correo" id="correo"  placeholder="Correo Electronico" >
                    </div>
                    <div class="col-md-1">
                        <label for="contrasena">Contraseña:</label>
                    </div>
                    <div class="col-md-5">
                        <input type="text" class="form-control" required name="contrasena" id="contrasena"  placeholder="Contraseña">			    
                    </div>
                    <div class="col-md-1">
                        <label for="telefono">Telefono:</label>
                    </div>
                    <div class="col-md-5">
                        <input type="text" class="form-control" required name="telefono" id="telefono"  placeholder="Telefono">			    
                    </div>
                    <div class="col-md-1">
                        <label for="tipo">Decanato al que pertenece:</label>
                    </div>
                    <div class="col-md-5">
                        <select class="form-control" name="tipo" id="tipo">
                            <option name ="administrador" >DCyT</option>                         
                            <option name ="ganadero">Medicina</option>
                        </select>
                    </div>
                    <div class="col-md-1">
                        <label for="tipo">Unidad:</label>
                    </div>
                    <div class="col-md-5">
                        <select class="form-control" name="tipo" id="tipo">
                            <option name ="administrador" >Biblioteca</option>                         
                            <option name ="ganadero">Hemeroteca</option>
                        </select>
                    </div>
                    <div class="col-md-1">
                        <label for="tipo">Tipo Usuario:</label>
                    </div>
                    <div class="col-md-4">
                        <select class="form-control" name="tipo" id="tipo">
                            <option name ="administrador" >Administrador</option>                         
                            <option name ="ganadero">Usuario de unidad</option>
                        </select>
                    </div>
                    <hr>
                </div>
            </div>
                <div class="form-group">
                    <div class="row">
                        <div class="centrar">
                            <button type="submit" name="accion" value="Aceptar" onclick=" alert('Usuario Registrado con exito!')" class="btn btn-primary">Aceptar</button>
                        </div>
                    </div>
                </div>
         

        </form>

</div>
	<%@include file="footer_admin.jsp" %>
	

	<script src="vistas/js/jquery.js" ></script>
	<script src="vistas/js/bootstrap.min.js"></script>
</body>
</html>
