/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Silvio
 */
public class Dao_enfermedad  extends ConexionDao{
     public boolean registrar_enf(Enfermedad enf) {
        String sql= "insert into enfermedad (nombre) values ('"+enf.getNombre()+"')";
        try{
            Connection con = getConectar();
            java.sql.PreparedStatement ps = con.prepareStatement(sql);
            ps.executeUpdate();
        }catch (Exception e)
        {
            System.err.println(" No se puede registrar la enfermedad...............");  
        }
        return false;
    }
    
    public boolean modificar(Enfermedad enf)
    {   
        String sql="UPDATE enfermedad SET nombre='"+enf.getNombre()+"' where id_enf='"+enf.getId_enf()+"'";      
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
    
    public Enfermedad buscar(int id_enf){   
        String sql="select * from enfermedad where id_enf='"+id_enf+"'";
        return buscarinterno(sql);
    }
    
    public Enfermedad buscar_por_nombre(String nombre){   
        String sql="select * from enfermedad where nombre='"+nombre+"'";
        return buscarinterno(sql);
    }
    
    public Enfermedad buscarinterno(String sql)
	{
                    try
                    {
                        Connection con = getConectar();
                        java.sql.PreparedStatement ps = con.prepareStatement(sql);
                        ResultSet rs = ps.executeQuery();
                        if (rs.next())
                        {
                                Enfermedad enf= new Enfermedad();
                                enf.setId_enf(rs.getInt("id_enf"));
                                enf.setNombre(rs.getString("nombre"));
                                return enf;
                        }else
                                return null;
                    }catch(Exception e)
                    {
                            System.err.println("no pude buscar");
                            return null;
                    }
	}
    
    public ArrayList<Enfermedad> getListado()
	{
		ArrayList<Enfermedad> listado=new ArrayList();
                    try {
                        Connection con = getConectar();
                        java.sql.PreparedStatement ps = con.prepareStatement("select * from enfermedad");
                        ResultSet rs = ps.executeQuery();
                        while(rs.next())
                        { 
                               Enfermedad enf= new Enfermedad();
                               enf.setId_enf(rs.getInt("id_enf"));
                               enf.setNombre(rs.getString("nombre"));
                            listado.add(enf);
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(Dao_finca.class.getName()).log(Level.SEVERE, null, ex);
                        return null;
                    }
		return listado;
	}
    
    
}
