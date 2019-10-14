<%@page import="modelo.Usuario"%>
<%@page import="modelo.Dao_usuario"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actualizacion de Usuarios</title>
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <link rel="stylesheet" href="vistas/css/bootstrap.min.css">
        <link rel="stylesheet" href="vistas/css/estilos_editar_usuario.css">
    </head>
    <body>
       <%@include file="menuser.jsp" %>
	<div class="jumbotron">
            <div class="conatiner">
                <h1 style="color:  white">Actualizacion de Usuario</h1>
                <p class="lead">Esta opcion del sistema le permite Actualizar los datos de los Usuarios.</p>
            </div>		
	</div>
	
	
        <div class="card" style="max-width: 100%;">
        <%
            Usuario usuario = (Usuario)request.getAttribute("txtidusuario");
        %>
            <h3 class="card-header" align = "center" >Actualizacion de Usuarios</h3>
            <form action="Controlador_usuario" method="post">
                <div class="form-group">
                    <div class="row">
                        <div class="col-md-1">
                            <label for="nombre">Nombre:</label>
                        </div>
                        <div class="col-md-5">
                            <input type="text" class="form-control" required name="nombre" id="nombre" 
                            value="<%= usuario.getNombre() %>" aria-describedby="emailHelp" 
                            placeholder="Nuevo nombre del usuario">
                        </div>    
                        <div class="col-md-1">
                            <label for="correo">Correo Electronico:</label>
                        </div>
                        <div class="col-md-5">
                            <input type="Email" class="form-control" required name="correo" id="correo" value="<%= usuario.getCorreo() %>" aria-describedby="emailHelp" placeholder="Nuevo correo" >
                        </div>
                        <div class="col-md-1">
                            <label for="contrasena">Contraseña:</label>
                        </div>
                        <div class="col-md-5">
                            <input type="text" class="form-control" required name="contrasena" id="contrasena" value="<%= usuario.getContraseña() %>" aria-describedby="emailHelp" placeholder="Nueva contraseña">			    
                        </div>
                        <div class="col-md-1">
                            <label for="telefono">Telefono:</label>
                        </div>
                        <div class="col-md-5">
                            <input type="text" class="form-control" required name="telefono" id="telefono" value="<%= usuario.getTelefono() %>" aria-describedby="emailHelp" placeholder="Nuevo telefono">			    
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
                            <label for="tipo">Tipo:</label>
                        </div>
                        <% 
                            String check1="";
                            String check2="";
                            if(usuario.getTipo().equals("administrador")){
                                check1="selected";
                            }
                            
                            if(usuario.getTipo().equals("ganadero")){
                                check2="selected";
                            }
                            
                        %>
                        <div class="col-md-4">
                            <select class="form-control" id="tipo" name="tipo" value="<%= usuario.getTipo() %>">
                                <option name="administrador" <%= check1 %>>administrador</option>                            
                                <option name="ganadero" <%= check2 %>>ganadero</option>
                            </select>
                        </div>

                        <hr>                        		  
                        <input type="hidden" name="txtid" value="<%= usuario.getId_usuario() %>" >
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
