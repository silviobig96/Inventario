<%@page import="modelo.Usuario"%>
<%@page import="modelo.Produccion"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Reporte de Solicitudes de Desincorporación / Reparación por mes</title>
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <link rel="stylesheet" href="vistas/css/bootstrap.min.css">
    <link rel="stylesheet" href="vistas/css/estilos_reporte_solicitudes.css">
</head>
<body>
           <%@include file="menuser.jsp" %>
	<div class="jumbotron">
		<div class="container">
			<h1 class="titulo">Reporte de Solicitudes de Desincorporación / Reparación por mes.</h1>
	 	 	<p class="lead">Este reporte le permite ver las Solicitudes de Desincorporacion o Reparacion por mes</p> 
		</div>
	</div>
	<div class="card">
		<form action="Controlador_reportes" method="post">
                <div class="row">
                <div class="col-md-4 text-right">
                    <h5>Seleccione el periodo de tiempo para el reporte.</h5>
                </div>
                </div>
                <div class="row">           
                <div class="col-md-1">      
                    <label for="mes">Mes:</label>
                </div>
                    <div class="col-md-4">
                    <select class="form-control" name="fecha_mes" id="tipo" >
                            <option></option> 
                            <option name ="enero" >Enero</option>                         
                            <option name ="febrero">Febrero</option>
                            <option name ="marzo">Marzo</option>
                            <option name ="abril">Abril</option>
                            <option name ="mayo">Mayo</option>
                            <option name ="junio">Junio</option>
                            <option name ="julio">Julio</option>
                            <option name ="agosto">Agosto</option>
                            <option name ="septiembre">Septiembre</option>
                            <option name ="octubre">Octubre</option>
                            <option name ="noviembre">Noviembre</option>
                            <option name ="diciembre">Diciembre</option>
                    </select>
                    </div>
                
                    <div class="col-md-1">      
                        <label for="mes">Año:</label>
                    </div>
                    <div class="col-md-5">
                    <select class="form-control" name="fecha_ano" id="tipo" >
                        <option></option>
                        <% for(int i=2000;i<2100;i++){%>
                            <option name =<%=i%> ><%=i%></option>
                        <%}%>
                    </select>
                    </div>
                
                    </div>

	     	<div class="row">
                <div class="centrar">
                    <button type="submit" value="reporte_produccion" name="accion" class="btn btn-primary">Consultar</button>
                </div>	
	     	</div>	  
                    <br><br><br>
		</form>
			<br><br>
                        
		<table class="table table-hover">
			<thead>
                <tr class="text-center" >
				  <th scope="col">Decanato</th>
                                  <th scope="col">Unidad</th>
				  <th scope="col">Total de Solicitudes de Desincorporación</th>
				  <th scope="col">Total de Solicitudes de reparación</th>
				</tr>
			</thead>
			<tbody>
                            <%
                                ArrayList listadoprod = (ArrayList)request.getAttribute("prod");
                                if (listadoprod != null)
                                    {
                                     if (listadoprod.size() > 0)
                                     {	 
                                            for (int i = 0; i < listadoprod.size(); i++) 
                                            {
                                                    Produccion p = (Produccion) listadoprod.get(i);     
                             %>
				<tr class="table-primary text-center">
				  <th scope="row"> <%= p.getAnimal().getFinca().getNombre() %></th>
				  <td><%= p.getAnimal().getId_animal() %></td>
				  <td><%= p.getTot_produccion_leche() %></td>
                                  <td><%= p.calc_precio() %></td>
				</tr>
                            <%
                                            }//for
                                      }	//if (listaArticulos.size()>0)
                                    else
                                    {	
                            %>
                                    <!--si no hay mensajes se envía al usuario a la página mensajes.jsp-->
                                    <tr class="table-primary text-center">
				  <th scope="row"></th>
				  <td></td>
				  <td></td><!--cambiar esto por un mensaje-->
				  <td></td>
                                  <td></td>
				</tr>
                            <%
                                    }
                            }	else{
                            %>
                             <tr class="table-primary text-center">
				  <th scope="row"></th>
				  <td></td>
				  <td></td>
				  <td></td>
                                  <td></td>
				</tr>
                            <% }
                            %>
			</tbody>
	   </table> 
	</div>
            <%@include file="footer_admin.jsp" %>
	<script src="vistas/js/jquery.js" ></script>
	<script src="vistas/js/bootstrap.min.js"></script>
</body>
</html>