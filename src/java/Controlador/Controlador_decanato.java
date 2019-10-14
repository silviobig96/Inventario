package Controlador;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.*;

@WebServlet("/Controlador_decanato")
public class Controlador_decanato extends HttpServlet {
    private static final long serialVersionUID = 1L;
    Dao_finca Dao_finca = new Dao_finca();
    Dao_usuario dao_usuario = new Dao_usuario();
    Finca finca = new Finca();
    String listar="vistas/Lista_decanatos.jsp";
    String editar="vistas/Editar_decanato.jsp";
    String registrar="vistas/Registro_decanato.jsp";
    
    
@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String acceso ="";
        String accion = request.getParameter("accion");
        if(accion.equalsIgnoreCase("listar")){
            ArrayList<Finca> fincas = Dao_finca.getLista_total();
            request.setAttribute("fincas", fincas);
            acceso=listar;
        }
        
        if(accion.equalsIgnoreCase("registrar")){
            ArrayList<Usuario> usuarios = dao_usuario.getListado();
            request.setAttribute("usuarios", usuarios);
            acceso=registrar;
        }
        
        if(accion.equalsIgnoreCase("editar")){
            String txtidFinca= request.getParameter("id");
            HttpSession session = request.getSession();
            Usuario u=dao_usuario.buscarporNombre((String)session.getAttribute("usuari"));
            Finca f=Dao_finca.buscar(txtidFinca);
            request.setAttribute("usuario", u);
            request.setAttribute("txtidfinca",f );
            acceso=editar;
        }
        
        if(accion.equalsIgnoreCase("eliminar")){
            String id= request.getParameter("id");
            finca.setId_finca(id);
            Dao_finca.eliminar(id);
            ArrayList<Finca> fincas = Dao_finca.getListado(listar);
            request.setAttribute("fincas", fincas);
            acceso=listar;
        }   
        
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
        }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String acceso ="";
            String accion = request.getParameter("accion");
            
            if(accion.equalsIgnoreCase("Aceptar")){
                System.err.println("Registrando Finca................");     
                String nombre =request.getParameter("nombre");
                String direccion =  request.getParameter("direccion");
                int cant_hect= Integer.parseInt(request.getParameter("cant_hect"));
                String nombre_usuario= request.getParameter("nombre_usuario");
                Finca f=new Finca();
                f.setNombre(nombre);
                f.setDireccion(direccion);
                f.setCant_hect(cant_hect);
                Usuario u=dao_usuario.buscarporNombre(nombre_usuario);
                f.setNombre_usuario(u);
                Dao_finca.registrar(f);
                ArrayList<Finca> fincas = Dao_finca.getLista_total();
                request.setAttribute("fincas", fincas);
                acceso=listar;
            }
            
            if(accion.equalsIgnoreCase("Actualizar")){
                System.err.println("Editando Finca................"); 
                String id= request.getParameter("txtid");
                String nombre =request.getParameter("nombre");
                String direccion =  request.getParameter("direccion");
                int cant_hect= Integer.parseInt(request.getParameter("cant_hect"));
                finca.setId_finca(id);
                finca.setNombre(nombre);
                finca.setDireccion(direccion);
                finca.setCant_hect(cant_hect);
                Dao_finca.modificar(finca);
                ArrayList<Finca> fincas = Dao_finca.getLista_total();
                request.setAttribute("fincas", fincas);
                acceso=listar;
            }
            
            RequestDispatcher vista = request.getRequestDispatcher(acceso);
            vista.forward(request, response);
	}
}