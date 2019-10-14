   <header>
       <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
		<div id="encabezado" class="navbar navbar-expand-lg fixed-top  navbar-dark bg-warning">
	      	<div class="container">
	      		<a href="Controlador_principal?accion=inicio" class="navbar-brand"><img src="vistas/Imagenes/casa.png" alt="HTML"></a>
	        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
	          <span class="navbar-toggler-icon"></span>
	        </button>
	        <div class="collapse navbar-collapse" id="navbarResponsive">
	          <ul class="navbar-nav">
                      
	            <li class="nav-item dropdown">
	              <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" id="vacas">Equipos <span class="caret"></span></a>
	              <div class="dropdown-menu" aria-labelledby="vacas">
	                <a class="dropdown-item" href="Controlador_Equipos?accion=registrar">Registrar Equipo</a>
	                <div class="dropdown-divider"></div>
	                <a class="dropdown-item" href="Controlador_Equipos?accion=listar">Listado de Equipos</a>
	              </div>
	            </li>
                    
	            <li class="nav-item dropdown">
	             	<a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" id="produccion">Solicitudes<span class="caret"></span></a>
	             	<div class="dropdown-menu" aria-labelledby="produccion">
		                <a class="dropdown-item" href="Controlador_Equipos?accion=sol_desin">Desincorporación de un Equipo dañado</a>
		                <div class="dropdown-divider"></div>
		                <a class="dropdown-item" href="Controlador_Equipos?accion=sol_repa">Reparacion de Equipo</a> 
		            </div>
	            </li>
             
	          </ul>
                    <%  HttpSession sesion = request.getSession();%>
	          <ul class="nav navbar-nav ml-auto">
	            <li class="nav-item dropdown">
	              <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" id="download"><%=sesion.getAttribute("usuari")%> <span class="caret"></span></a>
	              <div class="dropdown-menu" aria-labelledby="download">
	                <a class="dropdown-item" onclick="return confirm('Desea cerrar su sesion?')" href="Controlador_principal?accion=Salir">Salir</a>
	              </div>
	            </li>
	          </ul>
	        </div>
	      	</div>
	      	</div>
	</header>
