<%-- 
    Document   : menuser
    Created on : 13/02/2019, 07:14:52 PM
    Author     : Enderson
--%>

   <header>
       <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
		<div id="encabezado" class="navbar navbar-expand-lg fixed-top  navbar-dark bg-warning">
	      	<div class="container">
                    <a href="Controlador_Admin?accion=inicio" class="navbar-brand"><img src="vistas/Imagenes/casa.png" alt="HTML"></a>
	        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
	          <span class="navbar-toggler-icon"></span>
	        </button>
	        <div class="collapse navbar-collapse" id="navbarResponsive">
	          <ul class="navbar-nav">
	            <li class="nav-item dropdown">
	              <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" id="registro">Registro de Entidades<span class="caret"></span></a>
	              <div class="dropdown-menu" aria-labelledby="registro">
	                <a class="dropdown-item" href="Controlador_usuario?accion=registrar">Registrar Usuario</a>                                       
	                <a class="dropdown-item" href="Controlador_decanato?accion=registrar">Registrar Decanato</a>                                          
	                <a class="dropdown-item" href="Controlador_unidad?accion=registrar">Registrar Unidad</a> 
                        <a class="dropdown-item" href="Controlador_marca?accion=registrar">Registrar Marcas</a> 
                        <a class="dropdown-item" href="Controlador_Equipos?accion=registrar_admin">Registrar Equipos</a> 
	            </li>
                    <li class="nav-item dropdown">
	              <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" id="listados">Listados<span class="caret"></span></a>
	              <div class="dropdown-menu" aria-labelledby="listados">
	                <a class="dropdown-item" href="Controlador_usuario?accion=listar">Listado Usuarios</a>   
                        <a class="dropdown-item" href="Controlador_decanato?accion=listar">Listado Decanatos</a>
                        <a class="dropdown-item" href="Controlador_unidad?accion=listar">Listado Unidades</a>
                        <a class="dropdown-item" href="Controlador_marca?accion=listar">Listado Marcas</a>
                        <a class="dropdown-item" href="Controlador_Equipos?accion=listar_admin">Listado Equipos</a>
	              </div>
	            </li>
	            <li class="nav-item dropdown">
	              <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" id="download">Reportes Estadísticos<span class="caret"></span></a>
	              <div class="dropdown-menu" aria-labelledby="download">
	                <a class="dropdown-item" href="Controlador_reportes?accion=prod_leche">Reporte de Solicitudes de Desincorporación / Reparación por mes</a>
	                <div class="dropdown-divider"></div>
	                <a class="dropdown-item" href="Controlador_reportes?accion=vacas_lista">Cantidad total de equipos</a>
	                <div class="dropdown-divider"></div>
	                <a class="dropdown-item" href="Controlador_reportes?accion=vacas_mayor_menor">Unidades con mayor cantidad de equipos y menor cantidad de equipos</a>
	               
	              </div>
	            </li>
	          </ul>
                    <%  HttpSession sesion = request.getSession();%>
	          <ul class="nav navbar-nav ml-auto">
	            <li class="nav-item dropdown">
	              <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" id="download"><%=sesion.getAttribute("usuari")%> <span class="caret"></span></a>
	              <div class="dropdown-menu" aria-labelledby="download">
	                <a class="dropdown-item" onclick="return confirm('Desea cerrar su sesion?')" href="Controlador_Admin?accion=Salir">Salir</a>
	              </div>
	            </li>
	          </ul>
	        </div>
	      	</div>
	      	</div>
	</header>
