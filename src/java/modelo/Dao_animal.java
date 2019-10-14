package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import bean.Conexion;
import interfaz.metodosCRUD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Calendar;
import java.util.GregorianCalendar;

import java.util.List;

public  class Dao_animal extends ConexionDao implements metodosCRUD {
    Dao_finca dao_finca=new Dao_finca();
    Dao_raza dao_raza=new Dao_raza();
    Dao_enfermedad dao_enf=new  Dao_enfermedad();
    ConexionDao cn = new ConexionDao();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Animal animal = new Animal();

    
    
   //Muestra tlista de todas las vacas 
    @Override
    public ArrayList listar(String nombre_usuario) {
        ArrayList<Animal> list = new ArrayList<>();
        
                   String sql= "select animal.* from animal,finca where animal.id_finca=finca.id_finca and finca.nombre_usuario='"+nombre_usuario+"' and animal.estado_venta='No Vendida' and not animal.estado='Eliminado'  ";
                         try {    
                                
                       con=cn.getConectar();
                       ps=con.prepareStatement(sql);
                       rs=ps.executeQuery();
                               while(rs.next()){
                                Animal animal= new Animal(); 
                                animal.setId_animal(rs.getInt("id_animal"));
                                animal.setNombre(rs.getString("nombre"));
                                animal.setPrecio(rs.getDouble("precio"));
                                animal.setFinca(dao_finca.buscar(rs.getString("id_finca")));
                                animal.setPromedio(rs.getDouble("promedio_lt"));
                                animal.setEstado(rs.getString("estado"));
                                animal.set_raza(dao_raza.buscar( rs.getInt("id_raza")));
                                animal.setEnfermedad(dao_enf.buscar(rs.getInt("id_enf")));
                                list.add(animal);
                               }
                                }catch (Exception e){
                                    System.err.println(" No se puede buscar...............");
                                       }
                               return list;
    }
    
    public ArrayList listar_admin() {
        ArrayList<Animal> list = new ArrayList<>();
        
                   String sql= "select * from animal where animal.estado_venta='No Vendida' and not animal.estado='Eliminado' ";
                         try {    
                                
                       con=cn.getConectar();
                       ps=con.prepareStatement(sql);
                       rs=ps.executeQuery();
                               while(rs.next()){
                                Animal animal= new Animal(); 
                                animal.setId_animal(rs.getInt("id_animal"));
                                animal.setNombre(rs.getString("nombre"));
                                animal.setPrecio(rs.getDouble("precio"));
                                animal.setFinca(dao_finca.buscar(rs.getString("id_finca")));
                                animal.setPromedio(rs.getDouble("promedio_lt"));
                                animal.setEstado(rs.getString("estado"));
                                animal.set_raza(dao_raza.buscar( rs.getInt("id_raza")));                                
                                list.add(animal);
                               }
                                }catch (Exception e){
                                    System.err.println(" No se puede buscar...............");
                                       }
                               return list;
    }
    
    
    public ArrayList listarEnf(String nombre_usuario) {
        ArrayList<Animal> list = new ArrayList<>();
        
                   String sql= "select animal.* from animal,finca where animal.id_finca=finca.id_finca and finca.nombre_usuario='"+nombre_usuario+"' and animal.estado_venta='No Vendida' and not animal.estado='Eliminado'  and not animal.id_enf='0'";
                         try {    
                                
                       con=cn.getConectar();
                       ps=con.prepareStatement(sql);
                       rs=ps.executeQuery();
                               while(rs.next()){
                                Animal animal= new Animal(); 
                                animal.setId_animal(rs.getInt("id_animal"));
                                animal.setNombre(rs.getString("nombre"));
                                animal.setPrecio(rs.getDouble("precio"));
                                animal.setFinca(dao_finca.buscar(rs.getString("id_finca")));
                                animal.setPromedio(rs.getDouble("promedio_lt"));
                                animal.setEstado(rs.getString("estado"));
                                animal.set_raza(dao_raza.buscar( rs.getInt("id_raza")));
                                animal.setEnfermedad(dao_enf.buscar(rs.getInt("id_enf")));
                                list.add(animal);
                               }
                                }catch (Exception e){
                                    System.err.println(" No se puede buscar...............");
                                       }
                               return list;
    }
    
    public ArrayList listar_adminEnf() {
        ArrayList<Animal> list = new ArrayList<>();
        
                   String sql= "select * from animal where animal.estado_venta='No Vendida' and not animal.estado='Eliminado' and not animal.id_enf='0'";
                         try {    
                                
                       con=cn.getConectar();
                       ps=con.prepareStatement(sql);
                       rs=ps.executeQuery();
                               while(rs.next()){
                                Animal animal= new Animal(); 
                                animal.setId_animal(rs.getInt("id_animal"));
                                animal.setNombre(rs.getString("nombre"));
                                animal.setPrecio(rs.getDouble("precio"));
                                animal.setFinca(dao_finca.buscar(rs.getString("id_finca")));
                                animal.setPromedio(rs.getDouble("promedio_lt"));
                                animal.setEstado(rs.getString("estado"));
                                animal.set_raza(dao_raza.buscar( rs.getInt("id_raza")));                                
                                list.add(animal);
                               }
                                }catch (Exception e){
                                    System.err.println(" No se puede buscar...............");
                                       }
                               return list;
    }
    
    public ArrayList listar_vendidas(String nombre_usuario) {
        ArrayList<Animal> list = new ArrayList<>();
                   String sql= "select animal.* from animal,finca where animal.id_finca=finca.id_finca and finca.nombre_usuario='"+nombre_usuario+"' and animal.estado_venta='Vendida'";
                             
                         try {    
                                
                       con=cn.getConectar();
                       ps=con.prepareStatement(sql);
                       rs=ps.executeQuery();
                               while(rs.next()){
                                Animal animal= new Animal(); 
                                animal.setId_animal(rs.getInt("id_animal"));
                                animal.setFecha_venta(rs.getString("fecha_venta"));
                                animal.setFinca(dao_finca.buscar(rs.getString("id_finca")));
                                animal.setNombre(rs.getString("nombre"));
                                animal.setPrecio(rs.getDouble("precio"));
                                animal.setPromedio(rs.getDouble("promedio_lt"));
                                animal.setEstado(rs.getString("estado"));
                                animal.set_raza(dao_raza.buscar( rs.getInt("id_raza")));                                 
                                list.add(animal);
                               }
                                }catch (Exception e){
                                       }
                               return list;
    }
    
 
     @Override
    public boolean registrarVaca(Animal animal) {
        String sql= "insert into animal  (nombre, precio,promedio_lt,estado,id_raza,estado_venta,id_finca,id_enf) values ('"
                +animal.getNombre()+  "','"+animal.getPrecio()+"','"+animal.getPromedio()+"','"
                +animal.getEstado()+  "','"+animal.get_raza().getId_raza()+  "','No Vendida','"+animal.getFinca().getId_finca()+"','"+animal.getEnfermedad().getId_enf()+"')";
        try{
            con=cn.getConectar();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        }catch (Exception e)
        {
            System.err.println(" No se puede registrar la vaca...............");  
        }
        return false;
    }
    
    //muestra dato de una sola vaca seleccionada en el listado
    @Override
    public Animal list(int id) {
         String sql= "select * from animal where id_animal="+id;
                             
                         try {    
                                
                       con=cn.getConectar();
                       ps=con.prepareStatement(sql);
                       rs=ps.executeQuery();
                               while(rs.next()){
                               
                                animal.setId_animal(rs.getInt("id_animal"));
                                animal.setNombre(rs.getString("nombre"));
                                animal.setPrecio(rs.getDouble("precio"));
                                animal.setPromedio(rs.getDouble("promedio_lt"));
                                animal.setEstado(rs.getString("estado"));
                                animal.set_raza(dao_raza.buscar( rs.getInt("id_raza")));                                
                                
                               }
                                }catch (Exception e){
                                       }
                               return animal;
    }
    
    public Animal lista_promedio_vacas(int id) {
         String sql= "SELECT animal.id_animal,animal.nombre,avg(produccion.total_prod) from lab.produccion,lab.animal where animal.id_animal=produccion.id_animal and animal.id_animal='"+id+"'";
                             
                         try {    
                                
                       con=cn.getConectar();
                       ps=con.prepareStatement(sql);
                       rs=ps.executeQuery();
                                if(rs.next()){
                                    animal.setId_animal(rs.getInt("id_animal"));
                                    animal.setNombre(rs.getString("nombre"));
                                    animal.setPromedio(rs.getDouble("avg(produccion.total_prod)"));                              
                               }
                                }catch (Exception e){
                                    System.err.print("no pude buscar");
                                       }
                               return animal;
    }

    public ArrayList buscar_en_lista(String texto, String nombre_usuario){   //implementar metodo en el dao animal
        ArrayList<Animal> lista = new ArrayList<>();
        String sql= "select animal.* from lab.animal,lab.raza,lab.finca where animal.id_raza=raza.id_raza and animal.id_finca=finca.id_finca and finca.nombre_usuario='"+
                nombre_usuario+"' and (animal.id_animal like '%"+texto+"%' or animal.nombre like '%"+texto+"%' or raza.nombre like '%"+texto+"%' or animal.estado like '%"+texto+"%') and not animal.estado='Eliminado' and animal.estado_venta='No Vendida'";  
         try{
             
         con=cn.getConectar();
         ps=con.prepareStatement(sql);
          rs=ps.executeQuery();
          while(rs.next()){
               Animal animal= new Animal(); 
                                animal.setId_animal(rs.getInt("id_animal"));
                                animal.setNombre(rs.getString("nombre"));
                                animal.setPrecio(rs.getDouble("precio"));
                                animal.setFinca(dao_finca.buscar(rs.getString("id_finca")));
                                animal.setPromedio(rs.getDouble("promedio_lt"));
                                animal.setEstado(rs.getString("estado"));
                                animal.set_raza(dao_raza.buscar( rs.getInt("id_raza")));                                 
                                lista.add(animal);
          }
         }catch (Exception e){
             System.err.println(" No se puede Buscar la vaca...............");  
                                  }
         return lista;
    }
    
    public ArrayList buscar_en_lista_admin(String texto){   //implementar metodo en el dao animal
        ArrayList<Animal> lista = new ArrayList<>();
        String sql= "select animal.* from lab.animal,lab.raza,lab.finca where animal.id_raza=raza.id_raza and animal.id_finca=finca.id_finca and (animal.id_animal like '%"+
                texto+"%' or animal.nombre like '%"+texto+"%' or raza.nombre like '%"+texto+"%' or animal.estado like '%"+texto+"%') and not animal.estado='Eliminado' and animal.estado_venta='No Vendida'";  
         try{
             
         con=cn.getConectar();
         ps=con.prepareStatement(sql);
          rs=ps.executeQuery();
          while(rs.next()){
               Animal animal= new Animal(); 
                                animal.setId_animal(rs.getInt("id_animal"));
                                animal.setNombre(rs.getString("nombre"));
                                animal.setPrecio(rs.getDouble("precio"));
                                animal.setFinca(dao_finca.buscar(rs.getString("id_finca")));
                                animal.setPromedio(rs.getDouble("promedio_lt"));
                                animal.setEstado(rs.getString("estado"));
                                animal.set_raza(dao_raza.buscar( rs.getInt("id_raza")));                                 
                                lista.add(animal);
          }
         }catch (Exception e){
             System.err.println(" No se puede Buscar la vaca...............");  
                                  }
         return lista;
    }
    
    @Override
    public boolean editar(Animal animal) {
        String sql= "update  animal  set nombre='"+animal.getNombre()+  "',precio='"+animal.getPrecio()+"',promedio_lt='"+animal.getPromedio()+"',estado='"+animal.getEstado()+  "',id_raza='"+animal.get_raza().getId_raza()+  "', id_enf='"+animal.getEnfermedad().getId_enf()+"' where id_animal="+animal.getId_animal();
    try {    
                                
                       con=cn.getConectar();
                       ps=con.prepareStatement(sql);
                       ps.executeUpdate();
                              System.err.println("editando................");                               
                                }catch (Exception e){
                                     System.err.println("No se puede editar..............."); 
                                       }
                               return false;             
                          
        }

    @Override
    public boolean eliminar(int id) {
       String sql= "update lab.animal set estado='Eliminado' where id_animal='"+id+"'";
    try {    
                                
                       con=cn.getConectar();
                       ps=con.prepareStatement(sql);
                       ps.executeUpdate();
                       System.err.println("Eliminado correctamente");
                                                       
                                }catch (Exception e){
                              System.err.println("No se puede eliminar..............."); 
                                       }
                               return false;      
    }
    
    public boolean vender(int id) {
        Calendar fecha = new GregorianCalendar();
        int ano = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH)+1;
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
       String sql= "update animal set estado_venta='Vendida', fecha_venta='"+ano+"-"+mes+"-"+dia+""+"' where id_animal="+id;
    try {    
                                
                       con=cn.getConectar();
                       ps=con.prepareStatement(sql);
                       ps.executeUpdate();
                                                       
                                }catch (Exception e){
                              
                                       }
                               return false;      
    }
    
    public Animal buscar(int id_animal){   
        String sql="select * from animal where id_animal='"+id_animal+"'";
        return buscarinterno(sql);
    }
    
    public Animal buscarinterno(String sql)
	{
                    try
                    {
                        Connection con = getConectar();
                        java.sql.PreparedStatement ps = con.prepareStatement(sql);
                        ResultSet res = ps.executeQuery();
                        if (res.next())
                        {
                                Animal a= new Animal();
                                a.setId_animal(res.getInt("id_animal"));
                                a.setNombre(res.getString("nombre"));
                                a.setFinca(dao_finca.buscar(res.getString("id_finca")));
                                return a;
                        }else
                                return null;
                    }catch(Exception e)
                    {
                            System.err.println("no pude buscar");
                            return null;
                    }
	}
    
    public Animal menor_vaca(String nombre_usuario) {
         String sql= "SELECT produccion.id_animal,animal.nombre,sum(produccion.total_prod) FROM lab.animal,lab.produccion,lab.finca where finca.id_finca=animal.id_finca and animal.id_animal=produccion.id_animal and finca.nombre_usuario='"+nombre_usuario+"' group by produccion.id_animal order by sum(produccion.total_prod) asc";
         Animal a=new Animal();
         try {                                
                       con=cn.getConectar();
                       ps=con.prepareStatement(sql);
                       rs=ps.executeQuery();
                                if(rs.next()){
                                    a.setId_animal(rs.getInt("id_animal"));
                                    a.setNombre(rs.getString("nombre"));
                                    a.setPromedio(rs.getDouble("sum(produccion.total_prod)"));   
                                    System.err.print(a.getNombre());
                               }
                                }catch (Exception e){
                                    System.err.print("no pude buscar vaca1");
                                       }
                               return a;
    }
    
    public Animal mayor_vaca(String nombre_usuario) {
         String sql= "SELECT produccion.id_animal,animal.nombre,sum(produccion.total_prod) FROM lab.animal,lab.produccion,lab.finca where finca.id_finca=animal.id_finca and animal.id_animal=produccion.id_animal and finca.nombre_usuario='"+nombre_usuario+"' group by produccion.id_animal order by sum(produccion.total_prod) desc";
         Animal a=new Animal();                
         try {                                
                       con=cn.getConectar();
                       ps=con.prepareStatement(sql);
                       rs=ps.executeQuery();
                                if(rs.next()){
                                    a.setId_animal(rs.getInt("id_animal"));
                                    a.setNombre(rs.getString("nombre"));
                                    a.setPromedio(rs.getDouble("sum(produccion.total_prod)"));                              
                               }
                                }catch (Exception e){
                                    System.err.print("no pude buscar vaca2");
                                       }
                               return a;
    }
    
    public Animal menor_vaca_admin() {
         String sql= "SELECT produccion.id_animal,animal.nombre,sum(produccion.total_prod) FROM lab.animal,lab.produccion,lab.finca where finca.id_finca=animal.id_finca and animal.id_animal=produccion.id_animal group by produccion.id_animal order by sum(produccion.total_prod) asc";
         Animal a=new Animal();
         try {                                
                       con=cn.getConectar();
                       ps=con.prepareStatement(sql);
                       rs=ps.executeQuery();
                                if(rs.next()){
                                    a.setId_animal(rs.getInt("id_animal"));
                                    a.setNombre(rs.getString("nombre"));
                                    a.setPromedio(rs.getDouble("sum(produccion.total_prod)"));   
                                    System.err.print(a.getNombre());
                               }
                                }catch (Exception e){
                                    System.err.print("no pude buscar vaca1");
                                       }
                               return a;
    }
    
    public Animal mayor_vaca_admin() {
         String sql= "SELECT produccion.id_animal,animal.nombre,sum(produccion.total_prod) FROM lab.animal,lab.produccion,lab.finca where finca.id_finca=animal.id_finca and animal.id_animal=produccion.id_animal group by produccion.id_animal order by sum(produccion.total_prod) desc";
         Animal a=new Animal();                
         try {                                
                       con=cn.getConectar();
                       ps=con.prepareStatement(sql);
                       rs=ps.executeQuery();
                                if(rs.next()){
                                    a.setId_animal(rs.getInt("id_animal"));
                                    a.setNombre(rs.getString("nombre"));
                                    a.setPromedio(rs.getDouble("sum(produccion.total_prod)"));                              
                               }
                                }catch (Exception e){
                                    System.err.print("no pude buscar vaca2");
                                       }
                               return a;
    }
}


 