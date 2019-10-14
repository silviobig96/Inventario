<%@page import="modelo.Usuario"%>
<%@page import="modelo.Animal"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Reporte Vacas de mayor y menor produccion</title>
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <link rel="stylesheet" href="vistas/css/bootstrap.min.css">
    <link rel="stylesheet" href="vistas/css/estilosReportes.css">
</head>
<body>
            <% 
           Usuario u = (Usuario)request.getAttribute("usuario"); 
                if(u.getTipo().equals("administrador")){
           %>
           <%@include file="menuser.jsp" %>
           <% 
                }else{
           %>
           <%@include file="menuNav.jsp" %>
           <% 
                }
           %>
	<div class="jumbotron">
		<div class="container">
			<h1 class="titulo">Vacas de mayor y menor produccion</h1>
	 	 	<p class="lead">Este reporte permite visualizar cuales son las vacas con mayor y menor produccion en litros de leche ademas de imprimir en formato pdf.</p> 
		</div>
	</div>
	<div class="card">
		<form action="Controlador_reportes" method="post">
			 <div class="row">
		 		<div class="centrar">
			     	<button type="submit" value="may_men_vaca" name="accion" class="btn btn-primary">Consultar</button>
	    			<button type="button" class="btn btn-primary">Imprimir</button>
		     	</div>
			 </div> 
                    <br>
                        <br>
		</form>
                        <%
                            Animal animal = (Animal)request.getAttribute("vaca1");
                        %>
                        <br>
                        <br>
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
	</div>
	<% 
            if(u.getTipo().equals("administrador")){
       %>
            <%@include file="footer_admin.jsp" %>
       <% 
            }else{
       %>
            <%@include file="footer.jsp" %>
       <% 
            }
       %>

	<script src="vistas/js/jquery.js" ></script>
	<script src="vistas/js/bootstrap.min.js"></script>
</body>
</html>