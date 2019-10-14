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
import modelo.Animal;
import modelo.Dao_animal;

@WebServlet("/Controlador_ventas")
public class Controlador_ventas extends HttpServlet{
    private static final long serialVersionUID = 1L;
    Dao_animal Dao_animal = new Dao_animal();
    String histventas="vistas/historialVentas.jsp";
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String acceso ="";
        String accion = request.getParameter("accion");
        if(accion.equalsIgnoreCase("histventas")){
            HttpSession sesion = request.getSession();
            ArrayList<Animal> vacas = Dao_animal.listar_vendidas((String)sesion.getAttribute("usuari"));
            request.setAttribute("vacas", vacas);
            acceso=histventas;
        }
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    }
}
