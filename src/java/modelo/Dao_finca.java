package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import bean.Conexion;
import java.sql.Connection;

public class Dao_finca extends ConexionDao {
    
    Dao_usuario dao_usuario=new Dao_usuario();
    
     public void registrar(Finca f)
    {
        String sql= "INSERT INTO finca "+ "( nombre, direccion, hectareas, nombre_usuario) "+
		 			"VALUES ('"+f.getNombre()+"','"+f.getDireccion()+"','"+f.getCant_hect()+"','"+
                                        f.getNombre_usuario().getNombre()+"')";
        try{
            Connection con = getConectar();
            java.sql.PreparedStatement ps = con.prepareStatement(sql);
            ps.executeUpdate();
        }catch (Exception e)
        {
            System.err.println(" No se puede registrar la finca...............");  
        }
    }
 
    
     
     public void modificar(Finca f)
    {
        String sql="UPDATE finca SET nombre='"+f.getNombre()+"', direccion='"+f.getDireccion()+"',hectareas='"+f.getCant_hect()+"' where id_finca='"+f.getId_finca()+"' ";
        try {                
            Connection con = getConectar();
            java.sql.PreparedStatement ps = con.prepareStatement(sql);
            ps.executeUpdate();
            System.err.println("editado................");
        }catch (SQLException e){
            System.err.println("No se puede editar..............."+e.getErrorCode()); 
        }  
    }
     
     
     //eliminar por el id
        public boolean eliminar(String id_finca)
    {
        String sql="delete from finca"  +"' where id="+ id_finca;
        
        return Conexion.ejecutar(sql);
    }
        
        
       public boolean eliminar(Finca f)
    {
        return eliminar(f.getId_finca());
    }
     
      
      public Finca buscar(String id_finca)
      {   String sql="select * from finca"+ " where id_finca='"+id_finca+"'";
      return buscarinterno(sql);
      }
      
      public Finca buscar_con_nombre(String nombre)
      {   String sql="select * from finca where nombre='"+nombre+"'";
      return buscarinterno(sql);
      }
      
      
    public Finca buscarinterno(String sql)
	{
                    try
                    {
                        Connection con = getConectar();
                        java.sql.PreparedStatement ps = con.prepareStatement(sql);
                        ResultSet rs = ps.executeQuery();
                        if (rs.next())
                        {
                                Finca f= new Finca();
                                f.setId_finca(rs.getString("id_finca"));
                                f.setNombre(rs.getString("nombre"));
                                f.setDireccion(rs.getString("direccion"));
                                f.setCant_hect(rs.getInt("hectareas"));
                                f.setNombre_usuario(dao_usuario.buscarporNombre(rs.getString("nombre_usuario")));
                                return f;
                        }else
                                return null;
                    }catch(Exception e)
                    {
                            System.err.println("no pude buscar");
                            return null;
                    }
	}
    //retorna arrylist de la clase del modelo
    public ArrayList<Finca> getLista_total()
	{
		ArrayList<Finca> listado=new ArrayList();
                    try {
                        Connection con = getConectar();
                        java.sql.PreparedStatement ps = con.prepareStatement("select * from finca order by id_finca");
                        ResultSet rs = ps.executeQuery();
                        while(rs.next())
                        { 
                            // crear el objeto
                               Finca f= new Finca();
                                f.setId_finca(rs.getString("id_finca"));
                                f.setDireccion(rs.getString("direccion"));
                                f.setNombre(rs.getString("nombre"));
                                f.setCant_hect(rs.getInt("hectareas"));
                                f.setNombre_usuario(dao_usuario.buscarporNombre(rs.getString("nombre_usuario")));
                         
                            // setearlo
                            listado.add(f);
                            // agregarlo al array list
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(Dao_finca.class.getName()).log(Level.SEVERE, null, ex);
                        return null;
                    }
		return listado;
	}
    
    public ArrayList<Finca> getListado(String id_usuario)
	{
		ArrayList<Finca> listado=new ArrayList();
                    try {
                        Connection con = getConectar();
                        java.sql.PreparedStatement ps = con.prepareStatement("select * from finca where nombre_usuario='"+id_usuario +"'");
                        ResultSet rs = ps.executeQuery();
                        while(rs.next())
                        { 
                            // crear el objeto
                               Finca f= new Finca();
                                f.setId_finca(rs.getString("id_finca"));
                                f.setNombre(rs.getString("nombre"));
                                f.setCant_hect(rs.getInt("hectareas"));
                                f.setNombre_usuario(dao_usuario.buscarporNombre(rs.getString("nombre_usuario")));
                         
                            // setearlo
                            listado.add(f);
                            // agregarlo al array list
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(Dao_finca.class.getName()).log(Level.SEVERE, null, ex);
                        return null;
                    }
		return listado;
	}
    
    public Finca lista_promedio_fincas(String nombre) {
         String sql= "SELECT finca.nombre,avg(produccion.total_prod),(avg(produccion.total_prod)*2000) as precio FROM lab.finca,lab.animal,lab.produccion where finca.id_finca=animal.id_finca and animal.id_animal=produccion.id_animal and finca.nombre='"+nombre+"'";
                             Finca f= new Finca();
                         try {                
                        Connection con = getConectar();
                        java.sql.PreparedStatement ps = con.prepareStatement(sql);
                        ResultSet rs = ps.executeQuery();
                                if(rs.next()){
                                    f.setNombre(rs.getString("nombre"));
                                    f.setPromedio_diario(rs.getDouble("avg(produccion.total_prod)"));
                                    f.setPromedio_mensual(rs.getDouble("precio"));
                               }
                                }catch (Exception e){
                                    System.err.print("no pude buscar");
                                       }
                               return f;
    }
   //SELECT animal.id_animal,animal.nombre,max(produccion.total_prod) FROM lab.animal,lab.produccion,lab.finca where finca.id_finca=animal.id_finca and animal.id_animal=produccion.id_animal and finca.nombre_usuario='silviobig96' 
}


 