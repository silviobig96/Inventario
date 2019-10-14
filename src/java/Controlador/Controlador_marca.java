package Controlador;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Dao_enfermedad;
import modelo.Dao_raza;
import modelo.Enfermedad;
import modelo.Raza;

@WebServlet("/Controlador_marca")
public class Controlador_marca extends HttpServlet {
    private static final long serialVersionUID = 1L;
    Dao_enfermedad dao_enf=new Dao_enfermedad();
    String listar="vistas/Lista_marcas.jsp";
    String editar="vistas/Editar_marca.jsp";
    String registrar="vistas/Registro_marca.jsp";
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String acceso ="";
        String accion = request.getParameter("accion");
        if(accion.equalsIgnoreCase("listar")){
            ArrayList<Enfermedad> enf = dao_enf.getListado();
            request.setAttribute("enfermedades", enf);
            acceso=listar;
        }
        
        if(accion.equalsIgnoreCase("registrar")){
            acceso=registrar;
        }
        
        if(accion.equalsIgnoreCase("editar")){
            int id_enf= Integer.parseInt(request.getParameter("id"));
            Enfermedad enf=dao_enf.buscar(id_enf);
            request.setAttribute("enfermedad",enf );
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
                System.err.println("Registrando enfermedad................");     
                String nombre =request.getParameter("nombre");
                Enfermedad enf = new Enfermedad();
                enf.setNombre(nombre);
                dao_enf.registrar_enf(enf);
                ArrayList<Enfermedad> enfermedad = dao_enf.getListado();
                request.setAttribute("enfermedades", enfermedad);
                acceso=listar;
            }
            
            if(accion.equalsIgnoreCase("Actualizar")){
                System.err.println("Editando Enfermedad................");
                int id=Integer.parseInt(request.getParameter("txtid"));
                String nombre =request.getParameter("nombre");
                Enfermedad enf = new Enfermedad();
                enf.setId_enf(id);
                enf.setNombre(nombre);
               dao_enf.modificar(enf);
                ArrayList<Enfermedad> enfermedad = dao_enf.getListado();
                request.setAttribute("enfermedades", enfermedad);
                acceso=listar;
            }
            
            RequestDispatcher vista = request.getRequestDispatcher(acceso);
            vista.forward(request, response);
	}
}

    
