package Controlador;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Dao_raza;
import modelo.Dao_usuario;
import modelo.Raza;


@WebServlet("/Controlador_unidad")
public class Controlador_unidad extends HttpServlet {
    private static final long serialVersionUID = 1L;
    Dao_raza dao_raza=new Dao_raza();
    String listar="vistas/Lista_unidad.jsp";
    String editar="vistas/Editar_unidad.jsp";
    String registrar="vistas/Registro_unidad.jsp";
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String acceso ="";
        String accion = request.getParameter("accion");
        if(accion.equalsIgnoreCase("listar")){
            ArrayList<Raza> razas = dao_raza.getListado();
            request.setAttribute("razas", razas);
            acceso=listar;
        }
        
        if(accion.equalsIgnoreCase("registrar")){
            acceso=registrar;
        }
        
        if(accion.equalsIgnoreCase("editar")){
            int id_raza= Integer.parseInt(request.getParameter("id"));
            Raza r=dao_raza.buscar(id_raza);
            request.setAttribute("raza",r );
            acceso=editar;
        }
        
        if(accion.equalsIgnoreCase("eliminar")){
            /*String id= request.getParameter("id");
            Usuario usuario = new Usuario();
            usuario.setId_usuario(id);
            Dao_usuario.eliminar(id);
            ArrayList<Usuario> u = Dao_usuario.getListado();
            request.setAttribute("usuario", u);
            acceso=listar;*/
        }               
        
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
        }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String acceso ="";
            String accion = request.getParameter("accion");
            
            if(accion.equalsIgnoreCase("Aceptar")){
                System.err.println("Registrando Raza................");     
                String nombre =request.getParameter("nombre");
                Raza r = new Raza();
                r.setNombre(nombre);
                dao_raza.registrar_raza(r);
                ArrayList<Raza> razas = dao_raza.getListado();
                request.setAttribute("razas", razas);
                acceso=listar;
            }
            
            if(accion.equalsIgnoreCase("Actualizar")){
                System.err.println("Editando Raza................");
                int id=Integer.parseInt(request.getParameter("txtid"));
                String nombre =request.getParameter("nombre");
                Raza r = new Raza();
                r.setId_raza(id);
                r.setNombre(nombre);
                dao_raza.modificar(r);
                ArrayList<Raza> razas = dao_raza.getListado();
                request.setAttribute("razas", razas);
                acceso=listar;
            }
            
            RequestDispatcher vista = request.getRequestDispatcher(acceso);
            vista.forward(request, response);
	}
}
