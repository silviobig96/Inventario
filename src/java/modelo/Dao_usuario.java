package modelo;

import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Dao_usuario extends ConexionDao{
    
     public void registrar(Usuario u)
    {
        String sql= "INSERT INTO usuario "+ "(nombre, contrasena, correo,telefono, tipo,estado) "+
		 			"VALUES ("+"'"+u.getNombre()+"', '"+u.getContraseña()+
		 		        "','"+u.getCorreo()+"','"+u.getTelefono()+"','"+u.getTipo()+"', 'activo')";
        try{
            Connection con = getConectar();
            java.sql.PreparedStatement ps = con.prepareStatement(sql);
            ps.executeUpdate();
        }catch (Exception e)
        {
            System.err.println(" No se puede registrar el usuario...............");  
        }
    }
 
    
     
     public boolean modificar(Usuario u)
    {   
        System.out.println(u.getNombre());
        String sql="UPDATE usuario SET nombre='"+u.getNombre()+"',contrasena='"+u.getContraseña()+"', correo='"+
                u.getCorreo()+"',telefono='"+u.getTelefono()+"', tipo='"+u.getTipo()+"' where id_usuario='"+u.getId_usuario()+"'";
               
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
     
    
     //eliminar por el id
         public boolean eliminar(String id)
    {
         
        String sql="update usuario set estado='eliminado' where id_usuario='"+id+"'";
        try {
                Connection con = getConectar();
                Statement st = con.createStatement();
                st.execute(sql);
                if(st!= null){
                    st.close();
                }
                return true;
                
            } catch (SQLException e) {
                System.out.print("no elimino..."+e.getMessage());
                return false;
            }
        
    }
         
    public boolean reactivar(String id)
    {
         
        String sql="update usuario set estado='activo' where id_usuario='"+id+"'";
        try {
                Connection con = getConectar();
                Statement st = con.createStatement();
                st.execute(sql);
                if(st!= null){
                    st.close();
                }
                return true;
                
            } catch (SQLException e) {
                System.out.print("no elimino..."+e.getMessage());
                return false;
            }
        
    }
         
       public boolean eliminar(Usuario u)
    {
        return eliminar(u.getId_usuario());
    }
     
      
      public Usuario buscarporNombre(String nombre)
      {   String sql="select * from usuario"+ " where nombre='"+nombre+"' and estado='activo'";
      return buscarinterno(sql);
      }
      
      
    public  Usuario buscarinterno(String sql){
         
                try
                {
                    Connection con = getConectar();
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery(sql);
                    if (rs!=null){
                        if (rs.next())
                        {
                            Usuario u= new Usuario();
                            u.setId_usuario(rs.getString("id_usuario"));
                            u.setNombre(rs.getString("nombre"));                            
                            u.setContraseña(rs.getString("contrasena"));
                            u.setCorreo(rs.getString("correo"));
                            u.setTelefono(rs.getString("telefono"));
                            u.setTipo(rs.getString("tipo"));
                       
                            return u;
                        }else
                                return null;
                    }else
                        return null;
                        
                }catch(SQLException e)
                {
                    return null;
                }
            }
    //retorna arrylist de la clase del modelo
    public  ArrayList<Usuario> getListado()
	{
		ArrayList<Usuario> listado=new ArrayList();
                    
                    try {
                        Connection con = getConectar();
                        java.sql.PreparedStatement ps = con.prepareStatement("SELECT * FROM usuario order by id_usuario asc");
                        ResultSet rs = ps.executeQuery();
                        while (rs.next())
                        {
                            // crear el objeto
                                Usuario u= new Usuario();
                                u.setId_usuario(rs.getString("id_usuario"));
                                u.setEstado(rs.getString("estado"));
                                u.setNombre(rs.getString("nombre"));
                                u.setCorreo(rs.getString("correo"));
                                u.setContraseña(rs.getString("contrasena"));
                                u.setTelefono(rs.getString("telefono"));
                                u.setTipo(rs.getString("tipo"));
                              
                            // setearlo
                            listado.add(u);
                            // agregarlo al array list
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(Dao_usuario.class.getName()).log(Level.SEVERE, null, ex);
                        return null;
                    }
		return listado;
	}
    /*
    public Usuario bsc(String id) {
		Usuario u = null;
		String tiraSQL = "select * from usuario where id_usuario='silvio96'";
		ResultSet rs=Conexion.consultar(tiraSQL);	
		try {
                    while(rs.next()){
				u= new Usuario();
				u.setId_usuario(rs.getString("id_usuario"));
                                u.setNombre(rs.getString("nombre"));
                                u.setCorreo(rs.getString("correo"));
                                u.setContraseña(rs.getString("contraseña"));
                                u.setTelefono(rs.getString("telefono"));
                                u.setTipo(rs.getString("tipo"));
                    }
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}
    
   */
}


 