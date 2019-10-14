package modelo;
import java.sql.*;
import bean.Conexion;

public class ConexionDao {
	
	Connection con;
    
    public ConexionDao()
    {
        super();
        Conexion.establecerPropiedadesConexion("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/", "lab", "root", "1996");
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab","root","1996");
        }catch(Exception e)
            {
               System.err.println("Error"+e);    
            }
    }

   
    
    public Connection getConectar()
    {
        
        return con;
   
           
    }	
       
}
