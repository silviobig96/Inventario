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

@WebServlet("/Controlador_Equipos")
public class Controlador_Equipos extends HttpServlet {
    private static final long serialVersionUID = 1L;
    Dao_animal Dao_animal = new Dao_animal();
    Dao_raza dao_raza = new Dao_raza();
    Dao_enfermedad dao_enf = new Dao_enfermedad();
    Dao_finca dao_finca=new Dao_finca();
    Dao_usuario dao_usuario=new Dao_usuario();
    Animal animal = new Animal();
    String listar="vistas/Lista_equipos.jsp";
    String editar="vistas/Editar_equipo.jsp";
    String registrar="vistas/Registro_equipos.jsp";
    String sol_repa="vistas/Solicitud_reparacion.jsp";
    String sol_desin="vistas/Solicitud_desincorporacion.jsp";
    String listar_admin="vistas/Lista_equipos_admin.jsp";
    String registrar_admin="vistas/Registro_equipos_admin.jsp";
    String editar_admin="vistas/Editar_equipo_admin.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String acceso ="";
        String accion = request.getParameter("accion");
        if(accion.equalsIgnoreCase("listar")){
            HttpSession sesion = request.getSession();
            Usuario u=dao_usuario.buscarporNombre((String)sesion.getAttribute("usuari"));
            ArrayList<Animal> vacas = Dao_animal.listar((String)sesion.getAttribute("usuari"));
            request.setAttribute("vacas", vacas);
            acceso=listar;
        }
        
        if(accion.equalsIgnoreCase("registrar")){
            HttpSession sesion = request.getSession();
            Usuario u=dao_usuario.buscarporNombre((String)sesion.getAttribute("usuari"));
            ArrayList<Raza> razas = dao_raza.getListado();
             ArrayList<Enfermedad> enf = dao_enf.getListado();
            ArrayList<Finca> fincas = dao_finca.getListado((String)sesion.getAttribute("usuari"));
            request.setAttribute("razas", razas);
            request.setAttribute("enfermedades", enf);
            request.setAttribute("fincas", fincas);
            request.setAttribute("usuario", u);
            acceso=registrar;
        }
        
        if(accion.equalsIgnoreCase("registrar_admin")){
            HttpSession sesion = request.getSession();
            Usuario u=dao_usuario.buscarporNombre((String)sesion.getAttribute("usuari"));
            ArrayList<Raza> razas = dao_raza.getListado();
             ArrayList<Enfermedad> enf = dao_enf.getListado();
            ArrayList<Finca> fincas = dao_finca.getListado((String)sesion.getAttribute("usuari"));
            request.setAttribute("razas", razas);
            request.setAttribute("enfermedades", enf);
            request.setAttribute("fincas", fincas);
            request.setAttribute("usuario", u);
            acceso=registrar_admin;
        }
        
        if(accion.equalsIgnoreCase("editar")){
            int txtidVaca= Integer.parseInt(request.getParameter("id"));
            System.out.print(txtidVaca);
            Animal a=Dao_animal.list(txtidVaca);
            ArrayList<Raza> razas = dao_raza.getListado();
            ArrayList<Enfermedad> enf = dao_enf.getListado();
            request.setAttribute("razas", razas);
            request.setAttribute("enfermedades", enf);
            request.setAttribute("txtidVaca",a );
            acceso=editar;
        }
        
        if(accion.equalsIgnoreCase("editar_admin")){
            int txtidVaca= Integer.parseInt(request.getParameter("id"));
            System.out.print(txtidVaca);
            Animal a=Dao_animal.list(txtidVaca);
            ArrayList<Raza> razas = dao_raza.getListado();
            ArrayList<Enfermedad> enf = dao_enf.getListado();
            request.setAttribute("razas", razas);
            request.setAttribute("enfermedades", enf);
            request.setAttribute("txtidVaca",a );
            acceso=editar_admin;
        }
        
        if(accion.equalsIgnoreCase("sol_desin")){
            HttpSession sesion = request.getSession();
            ArrayList<Animal> vacas = Dao_animal.listar((String)sesion.getAttribute("usuari"));
            request.setAttribute("vacas", vacas);
            acceso=sol_desin;
        }
        
        if(accion.equalsIgnoreCase("sol_repa")){
            HttpSession sesion = request.getSession();
            //ArrayList<Produccion> prod = dao_produccion.getListado((String)sesion.getAttribute("usuari"));
            //request.setAttribute("prod", prod);
            acceso=sol_repa;
        }
        
        if(accion.equalsIgnoreCase("listar_admin")){
            ArrayList<Animal> vacas;
                vacas = Dao_animal.listar_admin();
            request.setAttribute("vacas", vacas);
            acceso=listar_admin;
        }
        
        if(accion.equalsIgnoreCase("vender")){
            int id= Integer.parseInt(request.getParameter("id"));
            animal.setId_animal(id);
            Dao_animal.vender(id);
            HttpSession sesion = request.getSession();
            ArrayList<Animal> vacas = Dao_animal.listar((String)sesion.getAttribute("usuari"));
            request.setAttribute("vacas", vacas);
            acceso=listar;
        }
        
        if(accion.equalsIgnoreCase("eliminar")){
            int id= Integer.parseInt(request.getParameter("id"));
            animal.setId_animal(id);
            Dao_animal.eliminar(id);
            HttpSession sesion = request.getSession();
            ArrayList<Animal> vacas = Dao_animal.listar((String)sesion.getAttribute("usuari"));
            request.setAttribute("vacas", vacas);
            acceso=listar;
        }
        
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
        }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String acceso ="";
            String accion = request.getParameter("accion");
            if(accion.equalsIgnoreCase("Aceptar")){
                System.err.println("Registrando vaca................");     
                String nombre =request.getParameter("nombre");
                double precio = new Double(request.getParameter("precio")); 
                double promedio= new Double(request.getParameter("promedio"));
                String estado= request.getParameter("estado");
                String raza	 =request.getParameter("raza");
                
                String enfermedad	 =request.getParameter("enfermedad");
                
                
                String nombre_finca =request.getParameter("finca");
                System.out.println(enfermedad);
                Finca finc=dao_finca.buscar_con_nombre(nombre_finca);
                System.err.println(finc.getId_finca());
                animal.setFinca(finc);
                animal.setNombre(nombre);
                animal.setPrecio(precio);
                animal.setPromedio(promedio);
                animal.setEstado(estado);
                animal.set_raza(dao_raza.buscar_por_nombre(raza));
               
                    animal.setEnfermedad(dao_enf.buscar_por_nombre(enfermedad));
               
                Dao_animal.registrarVaca(animal);
                HttpSession sesion = request.getSession();
                ArrayList<Animal> vacas = Dao_animal.listar((String)sesion.getAttribute("usuari"));
                request.setAttribute("vacas", vacas);
                acceso=listar;
            }
            
            if(accion.equalsIgnoreCase("Actualizar")){
                int id= Integer.parseInt(request.getParameter("txtid"));
                String nombre =request.getParameter("nombre");
                double precio = new Double(request.getParameter("precio")); 
                double promedio= new Double(request.getParameter("promedio"));
                String estado= request.getParameter("estado");
                String raza	 =request.getParameter("raza");
                String enfermedad	 =request.getParameter("enfermedad");
                System.out.print(enfermedad);
                animal.setId_animal(id);
                animal.setNombre(nombre);
                animal.setPrecio(precio);
                animal.setPromedio(promedio);
                animal.setEstado(estado);
                animal.set_raza(dao_raza.buscar_por_nombre(raza));             
                animal.setEnfermedad(dao_enf.buscar_por_nombre(enfermedad));
                Dao_animal.editar(animal);
                HttpSession sesion = request.getSession();
                ArrayList<Animal> vacas = Dao_animal.listar((String)sesion.getAttribute("usuari"));
                request.setAttribute("vacas", vacas);
                acceso=listar;
            }
            
            if(accion.equalsIgnoreCase("Buscar")){
                System.err.println("entrando al buscar vaca................");   
                String dato= request.getParameter("txtBuscar");
                System.err.println(dato); 
                HttpSession sesion = request.getSession();
                ArrayList<Animal> vacas = Dao_animal.buscar_en_lista(dato,(String)sesion.getAttribute("usuari"));
                request.setAttribute("vacas", vacas);
                acceso=listar;  
               } 
            RequestDispatcher vista = request.getRequestDispatcher(acceso);
            vista.forward(request, response);
	}
}
