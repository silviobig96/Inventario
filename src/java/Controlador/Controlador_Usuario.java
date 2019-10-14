/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import modelo.*;

/**
 *
 * @author Enderson
 */
@WebServlet("/Controlador_usuario")
public class Controlador_Usuario extends HttpServlet {
    private static final long serialVersionUID = 1L;
    Dao_usuario Dao_usuario = new Dao_usuario();
    String listar="vistas/UsuariosList.jsp";
    String editar="vistas/EditarUsuario.jsp";
    String registrar="vistas/RegistroUsuario.jsp";
    
    
@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String acceso ="";
        String accion = request.getParameter("accion");
        
        if(accion.equalsIgnoreCase("listar")){
            ArrayList<Usuario> usuario = Dao_usuario.getListado();
            request.setAttribute("usuarios", usuario);
            acceso=listar;
        }
        
        if(accion.equalsIgnoreCase("registrar")){
            acceso=registrar;
        }
        
        if(accion.equalsIgnoreCase("editar")){
            String txt_nombre_usuario= request.getParameter("nombre");
            Usuario u=Dao_usuario.buscarporNombre(txt_nombre_usuario);
            request.setAttribute("txtidusuario",u );
            acceso=editar;
        }
        
        if(accion.equalsIgnoreCase("eliminar")){
            String id= request.getParameter("id");
            Usuario usuario = new Usuario();
            usuario.setId_usuario(id);
            Dao_usuario.eliminar(id);
            ArrayList<Usuario> u = Dao_usuario.getListado();
            request.setAttribute("usuarios", u);
            acceso=listar;
        } 
        
        if(accion.equalsIgnoreCase("reactivar")){
            String id= request.getParameter("id");
            Usuario usuario = new Usuario();
            usuario.setId_usuario(id);
            Dao_usuario.reactivar(id);
            ArrayList<Usuario> u = Dao_usuario.getListado();
            request.setAttribute("usuarios", u);
            acceso=listar;
        }
        
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
        }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String acceso ="";
            String accion = request.getParameter("accion");
            
            if(accion.equalsIgnoreCase("Aceptar")){
                System.err.println("Registrando Usuario................");     
                String nombre =request.getParameter("nombre");
                String correo =  request.getParameter("correo");
                String contraseña= request.getParameter("contrasena");
                String telefono= request.getParameter("telefono");
                String tipo = request.getParameter("tipo");
                Usuario usuario = new Usuario();
                usuario.setNombre(nombre);
                usuario.setCorreo(correo);
                usuario.setContraseña(contraseña);
                usuario.setTelefono(telefono);
                usuario.setTipo(tipo);
                Dao_usuario.registrar(usuario);
                ArrayList<Usuario> u = Dao_usuario.getListado();
                request.setAttribute("usuarios", u);
                acceso=listar;
        }
            
        if(accion.equalsIgnoreCase("Actualizar")){
            System.err.println("Editando Usuario................");
            String id=request.getParameter("txtid");
            String nombre =request.getParameter("nombre");
            String correo =  request.getParameter("correo");
            String contraseña= request.getParameter("contrasena");
            String telefono= request.getParameter("telefono");
            String tipo = request.getParameter("tipo");
            Usuario usuario = new Usuario();
            usuario.setId_usuario(id);
            usuario.setNombre(nombre);
            usuario.setCorreo(correo);
            usuario.setContraseña(contraseña);
            usuario.setTelefono(telefono);
            usuario.setTipo(tipo);
            Dao_usuario.modificar(usuario);
            ArrayList<Usuario> u = Dao_usuario.getListado();
            request.setAttribute("usuarios", u);
            acceso=listar;
        }
            
            RequestDispatcher vista = request.getRequestDispatcher(acceso);
            vista.forward(request, response);
	}
}
