/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Controlador_Admin")// es el nombre del paquete
public class Controlador_Admin extends HttpServlet{
    private static final long serialVersionUID = 1L;
    String Salir="index.html";
    String inicio="vistas/Administrador.jsp";
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String acceso ="";
        String accion = request.getParameter("accion");
        if(accion.equalsIgnoreCase("Salir")){
            HttpSession session = request.getSession();
            response.sendRedirect("index.html");
            session.invalidate();
        }
        
        if(accion.equalsIgnoreCase("inicio")){
            acceso=inicio;
            RequestDispatcher vista = request.getRequestDispatcher(acceso);
            vista.forward(request, response);
        }
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    }
}
