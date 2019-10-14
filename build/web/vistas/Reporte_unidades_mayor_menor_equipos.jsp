<%@page import="modelo.Usuario"%>
<%@page import="modelo.Animal"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Reporte Vacas de mayor y menor produccion</title>
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <link rel="stylesheet" href="vistas/css/bootstrap.min.css">
    <link rel="stylesheet" href="vistas/css/estilos_reporte_unidades_mayor_menor_equipos.css">
</head>
<body>
           <%@include file="menuser.jsp" %>
	<div class="jumbotron">
		<div class="container">
			<h1 class="titulo">Unidades con mayor y menor cantidad de equipos</h1>
	 	 	<p class="lead">Este reporte permite visualizar cuales son las Unidades con mayor y menor cantidad de Equipos en su inventario</p> 
		</div>
	</div>
	<div class="card">
                        <%
                            Animal animal = (Animal)request.getAttribute("vaca1");
                        %>
                        <hr>
			<h3>Mayor Produccion</h3>
		<table class="table table-hover">
			<thead>
				<tr class="text-center">
				  <th scope="col">Codigo</th>
				  <th scope="col">Nombre</th>
				  <th scope="col">Promedio en ltrs</th>
				</tr>
			</thead>
			<tbody>
                            <% if(animal!=null){     %>
				<tr class="table-primary text-center">
				  <th scope="row"><%= animal.getId_animal() %></th>
				  <td><%= animal.getNombre() %></td>
				  <td><%= animal.getPromedio() %></td>  
				</tr>
                                <%  }    %>
			</tbody>
	   </table> 
                        <%
                            Animal a2 = (Animal)request.getAttribute("vaca2");
                        %>
	   <h3>Menor Produccion</h3>
		<table class="table table-hover">
			<thead>
				<tr class="text-center">
				  <th scope="col">Codigo</th>
				  <th scope="col">Nombre</th>
				  <th scope="col">Promedio en ltrs</th>
				</tr>
			</thead>
			<tbody>
                            <% if(a2!=null){     %>
				<tr class="table-primary text-center">
				  <th scope="row"><%= a2.getId_animal() %></th>
				  <td><%= a2.getNombre() %></td>
				  <td><%= a2.getPromedio() %></td>  
				</tr>
                                <%  }    %>
			</tbody>
	   </table> 
                <form action="Controlador_reportes" method="post">
                    <div class="row">
		 	<div class="centrar">
			    <button type="submit" value="may_men_vaca" name="accion" class="btn btn-primary">Consultar</button>
		     	</div>
                    </div> 
                    <br>
                    <br>
		</form>
	</div>
            <%@include file="footer_admin.jsp" %>
	<script src="vistas/js/jquery.js" ></script>
	<script src="vistas/js/bootstrap.min.js"></script>
</body>
</html>