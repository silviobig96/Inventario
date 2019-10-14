package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Dao_raza extends ConexionDao{
    
    public boolean registrar_raza(Raza r) {
        String sql= "insert into raza (nombre) values ('"+r.getNombre()+"')";
        try{
            Connection con = getConectar();
            java.sql.PreparedStatement ps = con.prepareStatement(sql);
            ps.executeUpdate();
        }catch (Exception e)
        {
            System.err.println(" No se puede registrar la raza...............");  
        }
        return false;
    }
    
    public boolean modificar(Raza r)
    {   
        String sql="UPDATE raza SET nombre='"+r.getNombre()+"' where id_raza='"+r.getId_raza()+"'";      
        try {                
            Connection con = getConectar();
            java.sql.PreparedStatement ps = con.prepareStatement(sql);
            ps.executeUpdate();
            System.err.println("editando................");
        }catch (SQLException e){
            System.err.println("No se puede editar..............."+e.getErrorCode()); 
        }  
        return false;        
    }
    
    public Raza buscar(int id_raza){   
        String sql="select * from raza where id_raza='"+id_raza+"'";
        return buscarinterno(sql);
    }
    
    public Raza buscar_por_nombre(String nombre){   
        String sql="select * from raza where nombre='"+nombre+"'";
        return buscarinterno(sql);
    }
    
    public Raza buscarinterno(String sql)
	{
                    try
                    {
                        Connection con = getConectar();
                        java.sql.PreparedStatement ps = con.prepareStatement(sql);
                        ResultSet rs = ps.executeQuery();
                        if (rs.next())
                        {
                                Raza r= new Raza();
                                r.setId_raza(rs.getInt("id_raza"));
                                r.setNombre(rs.getString("nombre"));
                                return r;
                        }else
                                return null;
                    }catch(Exception e)
                    {
                            System.err.println("no pude buscar");
                            return null;
                    }
	}
    
    public ArrayList<Raza> getListado()
	{
		ArrayList<Raza> listado=new ArrayList();
                    try {
                        Connection con = getConectar();
                        java.sql.PreparedStatement ps = con.prepareStatement("select * from raza");
                        ResultSet rs = ps.executeQuery();
                        while(rs.next())
                        { 
                               Raza r= new Raza();
                               r.setId_raza(rs.getInt("id_raza"));
                               r.setNombre(rs.getString("nombre"));
                            listado.add(r);
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(Dao_finca.class.getName()).log(Level.SEVERE, null, ex);
                        return null;
                    }
		return listado;
	}
    
}
