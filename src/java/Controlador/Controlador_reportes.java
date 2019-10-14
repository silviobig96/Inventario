package Controlador;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Animal;
import modelo.Dao_animal;
import modelo.Dao_finca;
import modelo.Dao_produccion;
import modelo.Dao_usuario;
import modelo.Finca;
import modelo.Produccion;
import modelo.Usuario;

@WebServlet("/Controlador_reportes")
public class Controlador_reportes extends HttpServlet{
    private static final long serialVersionUID = 1L;
    Dao_animal dao_animal=new Dao_animal();
    Dao_produccion dao_produccion=new Dao_produccion();
    Dao_finca dao_finca=new Dao_finca();
    Dao_usuario dao_usuario=new Dao_usuario();
    String prod_leche="vistas/Reporte_solicitudes.jsp";
    String vacas_lista="vistas/Reporte_cant_equipos.jsp";
    String prom_finca="vistas/Reporte_promedio_ganacia_finca.jsp";
    String prom_vacas="vistas/Reporte_prom_ganancia_vaca.jsp";
    String vacas_mayor_menor="vistas/Reporte_unidades_mayor_menor_equipos.jsp";
    String vacas_enf="vistas/ReporteEnfer.jsp";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String acceso ="";
        String accion = request.getParameter("accion");
        HttpSession sesion = request.getSession();
        Usuario u=dao_usuario.buscarporNombre((String)sesion.getAttribute("usuari"));
        
        if(accion.equalsIgnoreCase("prod_leche")){
            request.setAttribute("usuario", u);
            acceso=prod_leche;
        }
        
        if(accion.equalsIgnoreCase("vacas_lista")){
            ArrayList<Animal> vacas;
            if(u.getTipo().equals("administrador")){
                vacas = dao_animal.listar_admin();
            }else vacas = dao_animal.listar((String)sesion.getAttribute("usuari"));
            request.setAttribute("usuario", u);
            request.setAttribute("vacas", vacas);
            acceso=vacas_lista;
        }
          if(accion.equalsIgnoreCase("vacas_enf")){
            ArrayList<Animal> vacas;
            if(u.getTipo().equals("administrador")){
                vacas = dao_animal.listar_adminEnf();
            }else vacas = dao_animal.listarEnf((String)sesion.getAttribute("usuari"));
            request.setAttribute("usuario", u);
            request.setAttribute("vacas", vacas);
            acceso=vacas_enf;
        }
        
        if(accion.equalsIgnoreCase("prom_finca")){
            ArrayList<Finca> fincas;
            if(u.getTipo().equals("administrador")){
                fincas = dao_finca.getLista_total();
            }else fincas = dao_finca.getListado((String)sesion.getAttribute("usuari"));
            request.setAttribute("usuario", u);
            request.setAttribute("fincas", fincas);
            acceso=prom_finca;
        }
        
        if(accion.equalsIgnoreCase("prom_vacas")){
            ArrayList<Animal> vacas;
            if(u.getTipo().equals("administrador")){
                vacas = dao_animal.listar_admin();
            }else vacas = dao_animal.listar((String)sesion.getAttribute("usuari"));
            request.setAttribute("vacas", vacas);
            request.setAttribute("usuario", u);
            acceso=prom_vacas;
        }
        
        if(accion.equalsIgnoreCase("vacas_mayor_menor")){
            request.setAttribute("usuario", u);
            acceso=vacas_mayor_menor;
        }
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String acceso ="";
        String accion = request.getParameter("accion");
        HttpSession sesion = request.getSession();
        Usuario u=dao_usuario.buscarporNombre((String)sesion.getAttribute("usuari"));
                
        if(accion.equalsIgnoreCase("consultar_prom_finca")){
            System.err.println("entrando al buscar promedio finca................");   
            String nombre_finca= request.getParameter("finca");
            System.err.println(nombre_finca);
            Finca f=dao_finca.lista_promedio_fincas(nombre_finca);
            request.setAttribute("objfinca",f );
            ArrayList<Finca> fincas;
            if(u.getTipo().equals("administrador")){
                fincas = dao_finca.getLista_total();
            }else fincas = dao_finca.getListado((String)sesion.getAttribute("usuari"));
            request.setAttribute("fincas", fincas);
            request.setAttribute("usuario", u);
            acceso=prom_finca;  
        } 
        
        if(accion.equalsIgnoreCase("consultar_prom_vaca")){
            System.err.println("entrando al buscar promedio vaca................");   
            int id_animal= Integer.parseInt(request.getParameter("vaca"));
            System.err.println(id_animal);
            Animal a=dao_animal.lista_promedio_vacas(id_animal);
            request.setAttribute("txtidVaca",a );
            ArrayList<Animal> vacas;
            if(u.getTipo().equals("administrador")){
                vacas = dao_animal.listar_admin();
            }else vacas = dao_animal.listar((String)sesion.getAttribute("usuari"));
            request.setAttribute("vacas", vacas);
            request.setAttribute("usuario", u);
            acceso=prom_vacas;  
        } 
        
        if(accion.equalsIgnoreCase("may_men_vaca")){
            System.err.println("entrando al mayor menor vaca................");   
            Animal a1=null;
            Animal a2=null;
            if(u.getTipo().equals("administrador")){
                a1=dao_animal.menor_vaca_admin();
                a2=dao_animal.mayor_vaca_admin();
            }else {
                a1=dao_animal.menor_vaca((String)sesion.getAttribute("usuari"));
                a2=dao_animal.mayor_vaca((String)sesion.getAttribute("usuari"));
            }
            request.setAttribute("usuario", u);
            request.setAttribute("vaca2",a1 );
            request.setAttribute("vaca1",a2 );
            acceso=vacas_mayor_menor;  
        } 
        
        if(accion.equalsIgnoreCase("reporte_produccion")){
            System.err.println("entrando al reporte de produccion................");   
            String fecha_diario= request.getParameter("fecha_dia");
            String mes= request.getParameter("fecha_mes");
            String año= request.getParameter("fecha_ano");
            ArrayList<Produccion> prod=new ArrayList();
            if(fecha_diario!=null){
                if(u.getTipo().equals("administrador")){
                    prod = dao_produccion.buscar_prod_diaria_admin(fecha_diario);
                }else prod = dao_produccion.buscar_prod_diaria(fecha_diario, (String)sesion.getAttribute("usuari"));
            }
            
            if(mes!=null && año!=null){
                System.out.println("me meti por mes: "+mes+" y año: "+año+"");
                if(u.getTipo().equals("administrador")){
                    prod = dao_produccion.buscar_prod_mensual_admin(mes, año);
                }else prod = dao_produccion.buscar_prod_mensual(mes, año, (String)sesion.getAttribute("usuari"));
            }
            
            if(mes==null && año==null && fecha_diario==null){
                prod=null;
            }
            
            request.setAttribute("usuario", u);
            request.setAttribute("prod", prod);
            acceso=prod_leche;  
        }
        
        if(accion.equalsIgnoreCase("Buscar")){
                System.err.println("entrando al buscar vaca................");   
                String dato= request.getParameter("txtBuscar");
                System.out.println(dato); 
                ArrayList<Animal> vacas;
                if(u.getTipo().equals("administrador")){
                    vacas = dao_animal.buscar_en_lista_admin(dato);
                }else vacas = dao_animal.buscar_en_lista(dato,(String)sesion.getAttribute("usuari"));
                request.setAttribute("vacas", vacas);
                request.setAttribute("usuario", u);
                acceso=vacas_lista;  
        } 
        
            RequestDispatcher vista = request.getRequestDispatcher(acceso);
            vista.forward(request, response);
    }
}
