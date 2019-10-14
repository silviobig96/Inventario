package Controlador;

import modelo.Usuario;
import modelo.Dao_usuario;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;
import modelo.Dao_finca;
import modelo.Finca;


@WebServlet("/Controlador")
public class Controlador_login extends HttpServlet{
    private static final long serialVersionUID = 1L;

    private Dao_usuario dao_usuario=new Dao_usuario();
    private Dao_finca dao_finca=new Dao_finca();
    Usuario u = new Usuario();
    public Controlador_login() {
        // TODO Auto-generated constructor stub
    	 dao_usuario = new Dao_usuario();
         dao_finca= new Dao_finca();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		procesarPeticion(request, response);
	}
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		procesarPeticion(request, response);
		
	}
    
    protected void procesarPeticion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String operacion=request.getParameter("operacion");
		//enviar a la página de login
		if(operacion.equals("Entrar")){
                    HttpSession sesion = request.getSession();
                    String nombre = request.getParameter("usuario");
                    String contraseña = request.getParameter("contrasena");
                  
                     u = dao_usuario.buscarporNombre(nombre);
                     if(u!=null){
                        if(u.getTipo().equals("ganadero") && u.getContraseña().equals(contraseña) && sesion.getAttribute("usuari") == null){
                            sesion.setAttribute("usuari", nombre);
                        //response.sendRedirect("vistas/principal.jsp");
                        ArrayList<Finca> fincas = dao_finca.getListado(nombre);
                        request.setAttribute("fincas", fincas);
                        RequestDispatcher rd=request.getRequestDispatcher("vistas/principal.jsp");
                        rd.forward(request, response);
                    }else if(u.getTipo().equals("administrador") && u.getContraseña().equals(contraseña) && sesion.getAttribute("usuari") == null){
                        sesion.setAttribute("usuari", nombre);
                        RequestDispatcher rd=request.getRequestDispatcher("vistas/Administrador.jsp");
                        rd.forward(request, response);
                        
                    }else
                        response.sendRedirect("vistas/paginamensaje.jsp?mensaje=ERROR nombre de usuario o contraseña incorrecta");
                    }else
                        response.sendRedirect("vistas/paginamensaje.jsp?mensaje=ERROR nombre de usuario o contraseña incorrecta");
                    
                    
                    //response.sendRedirect("vistas/principal.jsp");
                }
                
                if(operacion.equals("olvidocon")){
                    HttpSession session = request.getSession();
                    response.sendRedirect("vistas/olvidocontrasena.jsp");
                    session.invalidate();
                }
                
                if(operacion.equals("finc")){
                    HttpSession session = request.getSession();
                    response.sendRedirect("vistas/gestion.jsp");
                    session.invalidate();
                }
			
	}
    
}
