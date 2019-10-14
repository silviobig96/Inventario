package Controlador;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Dao_finca;
import modelo.Dao_usuario;
import modelo.Finca;
import modelo.Usuario;

@WebServlet("/Controlador_principal")// es el nombre del paquete
public class Controlador_principal extends HttpServlet{
    private static final long serialVersionUID = 1L;
    private Dao_finca dao_finca=new Dao_finca();
    private Dao_usuario dao_usuario=new Dao_usuario();
    String Salir="index.html";
    String finc="vistas/informacion_finca.jsp";
    String inicio="vistas/principal.jsp";
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String acceso ="";
        String accion = request.getParameter("accion");
        if(accion.equalsIgnoreCase("Salir")){
            HttpSession session = request.getSession();
            response.sendRedirect("index.html");
            session.invalidate();
        }
        
        if(accion.equalsIgnoreCase("finc")){
            String txtidFinca= request.getParameter("id");
            System.err.print(txtidFinca);
            acceso=finc;
            HttpSession session = request.getSession();
            Usuario u=dao_usuario.buscarporNombre((String)session.getAttribute("usuari"));
            Finca f=dao_finca.buscar(txtidFinca);
            request.setAttribute("usuario", u);
            request.setAttribute("txtidfinca",f );
            RequestDispatcher vista = request.getRequestDispatcher(acceso);
            vista.forward(request, response);
        }
        
        if(accion.equalsIgnoreCase("inicio")){
            HttpSession sesion = request.getSession();
            ArrayList<Finca> fincas = dao_finca.getListado((String)sesion.getAttribute("usuari"));
            request.setAttribute("fincas", fincas);
            acceso=inicio;
            RequestDispatcher vista = request.getRequestDispatcher(acceso);
            vista.forward(request, response);
        }
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    }
}
