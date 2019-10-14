package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import bean.Conexion;
import java.sql.Connection;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Dao_produccion extends ConexionDao{
    Dao_animal dao_animal=new Dao_animal();
    
    public boolean registrarProduccion(Produccion p) {
        Calendar fecha = new GregorianCalendar();
        int ano = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH)+1;
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        System.err.print("'"+ano+"-"+mes+"-"+dia+"'");
        String sql= "insert into produccion  (id_animal, ordeno1, ordeno2, fecha, total_prod) values ('"+
                p.getAnimal().getId_animal()+"','"+p.getOrdeño1()+"','"+
                p.getOrdeño2()+"','"+ano+"-"+mes+"-"+dia+"','"+p.getTot_produccion_leche()+"')";
        try{
            Connection con = getConectar();
            java.sql.PreparedStatement ps = con.prepareStatement(sql);
            ps.executeUpdate();
        }catch (Exception e)
        {
            System.err.println(" No se puede registrar la produccion...............");  
        }
        return false;
    }
    
     //eliminar por el id
        public static boolean eliminar(String id_produccion)
    {
        String sql="delete from produccion"  +"' where id="+ id_produccion;
        return Conexion.ejecutar(sql);
    }
     
      //retorna arrylist de la clase del modelo
    public ArrayList<Produccion> getListado(String nombre_usuario)
	{
		ArrayList<Produccion> listado=new ArrayList();
                    try {
                        Connection con = getConectar();
                        java.sql.PreparedStatement ps = con.prepareStatement("select produccion.* from produccion,animal,finca where animal.id_animal=produccion.id_animal and animal.id_finca=finca.id_finca and finca.nombre_usuario='"+nombre_usuario+"' order by id_produccion");
                        ResultSet rs = ps.executeQuery();
                        while(rs.next())
                        { 
                            // crear el objeto
                                Produccion p= new Produccion();
                                p.setAnimal(dao_animal.buscar(rs.getInt("id_animal")));
                                p.setFecha(rs.getString("fecha"));
                                p.setId_produccion(rs.getInt("id_produccion"));
                                p.setOrdeño1(rs.getDouble("ordeno1"));
                                p.setOrdeño2(rs.getDouble("ordeno2"));
                                p.setTot_produccion_leche(rs.getDouble("total_prod"));
                         
                            // setearlo
                            listado.add(p);
                            // agregarlo al array list
                        }
                    } catch (SQLException ex) {
                        System.err.println(" No pude buscar");  
                        Logger.getLogger(Dao_finca.class.getName()).log(Level.SEVERE, null, ex);
                        return null;
                    }
		return listado;
	}
    
    public Produccion list(int id) {
         String sql= "select * from produccion where id_produccion="+id;
                        Produccion p= new Produccion();    
                        try {    
                            Connection con = getConectar();
                            java.sql.PreparedStatement ps = con.prepareStatement(sql);
                            ResultSet rs = ps.executeQuery();
                               if(rs.next()){
                               p.setAnimal(dao_animal.buscar(rs.getInt("id_animal")));
                               p.setFecha(rs.getString("fecha"));
                               p.setId_produccion(rs.getInt("id_produccion"));
                               p.setOrdeño1(rs.getDouble("ordeno1"));
                               p.setOrdeño2(rs.getDouble("ordeno2"));
                               p.setTot_produccion_leche(rs.getDouble("total_prod"));                              
                                
                               }
                                }catch (Exception e){
                                       }
                               return p;
    }
    
    public boolean editar(Produccion prod) {
        String sql= "update produccion set ordeno1='"+prod.getOrdeño1()+"',ordeno2='"+prod.getOrdeño2()+"' where id_produccion= "+prod.getId_produccion()+"";
    try {    
                                
                       Connection con = getConectar();
                       java.sql.PreparedStatement ps = con.prepareStatement(sql);
                       ps.executeUpdate();
                              System.err.println("editando................");                               
                                }catch (Exception e){
                                     System.err.println("No se puede editar..............."); 
                                       }
                               return false;             
                          
        }
    
    public ArrayList buscar_en_lista(String texto, String nombre_usuario){   //implementar metodo en el dao animal
        ArrayList<Produccion> lista = new ArrayList<>();
        String sql= "select produccion.* from lab.produccion,lab.animal,lab.finca where animal.id_animal=produccion.id_animal and animal.id_finca=finca.id_finca and finca.nombre_usuario='"+
                nombre_usuario+"' and (produccion.id_produccion like '%"+texto+"%' or animal.nombre like '%"+texto+"%')";  
        try{
            Connection con = getConectar();
            java.sql.PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Produccion p= new Produccion();
                p.setAnimal(dao_animal.buscar(rs.getInt("id_animal")));
                p.setFecha(rs.getString("fecha"));
                p.setId_produccion(rs.getInt("id_produccion"));
                p.setOrdeño1(rs.getDouble("ordeno1"));
                p.setOrdeño2(rs.getDouble("ordeno2"));
                p.setTot_produccion_leche(rs.getDouble("total_prod"));                                
                lista.add(p);
            }
        }catch (Exception e){
            System.err.println(" No se puede Buscar la produccion...............");  
        }
        return lista;
    }
    
    public ArrayList buscar_prod_diaria(String fecha, String nombre_usuario){   //implementar metodo en el dao animal
        ArrayList<Produccion> lista = new ArrayList<>();
        String sql= "select finca.nombre,animal.id_animal,produccion.fecha,sum(produccion.total_prod),(sum(produccion.total_prod)*2000) from lab.animal,lab.produccion,lab.finca where animal.id_finca=finca.id_finca and produccion.id_animal=animal.id_animal and produccion.fecha='"+fecha+"' and finca.nombre_usuario='"+nombre_usuario+"' group by id_animal order by finca.nombre";  
        try{
            Connection con = getConectar();
            java.sql.PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Produccion p= new Produccion();
                p.setAnimal(dao_animal.buscar(rs.getInt("id_animal")));
                p.setFecha(rs.getString("fecha"));
                p.setTot_produccion_leche(rs.getDouble("sum(produccion.total_prod)"));
                lista.add(p);
            }
        }catch (Exception e){
            System.err.println(" No se puede Buscar la produccion...............");  
        }
        return lista;
    }
    
    public ArrayList buscar_prod_mensual(String mes,String año, String nombre_usuario){
        //aca se establece las fechas limites de los meses ejemplo enero corresponde a 01/01/2019 y 31/01/2019
            String fecha1="";
            String fecha2="";
            if(mes.equals("Enero")){
                fecha1=""+año+"-01-01";
                fecha2=""+año+"-01-31";
            }
            if(mes.equals("Febrero")){
                fecha1=""+año+"-02-01";
                fecha2=""+año+"-02-28";
            }
            if(mes.equals("Marzo")){
                fecha1=""+año+"-03-01";
                fecha2=""+año+"-03-31";
            }
            if(mes.equals("Abril")){
                fecha1=""+año+"-04-01";
                fecha2=""+año+"-04-30";
            }
            if(mes.equals("Mayo")){
                fecha1=""+año+"-05-01";
                fecha2=""+año+"-05-31";
            }
            if(mes.equals("Junio")){
                fecha1="}"+año+"-06-01";
                fecha2=""+año+"-06-30";
            }
            if(mes.equals("Julio")){
                fecha1=""+año+"-07-01";
                fecha2=""+año+"-07-31";
            }
            if(mes.equals("Agosto")){
                fecha1=""+año+"-08-01";
                fecha2=""+año+"-08-31";
            }
            if(mes.equals("Septiembre")){
                fecha1=""+año+"-09-01";
                fecha2=""+año+"-09-30";
            }
            if(mes.equals("Octubre")){
                fecha1=""+año+"-10-01";
                fecha2=""+año+"-10-31";
            }
            if(mes.equals("Noviembre")){
                fecha1=""+año+"-11-01";
                fecha2=""+año+"-30-01";
            }
            if(mes.equals("Diciembre")){
                fecha1=""+año+"-12-01";
                fecha2=""+año+"-31-01";
            }
        ArrayList<Produccion> lista = new ArrayList<>();
        String sql= "select finca.nombre,animal.id_animal,produccion.fecha,sum(produccion.total_prod),(sum(produccion.total_prod)*2000) from lab.animal,lab.produccion,lab.finca where animal.id_finca=finca.id_finca and produccion.id_animal=animal.id_animal and produccion.fecha between '"+fecha1+"' and '"+fecha2+"' and finca.nombre_usuario='"+nombre_usuario+"' group by id_animal order by finca.nombre";  
        try{
            Connection con = getConectar();
            java.sql.PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Produccion p= new Produccion();
                p.setAnimal(dao_animal.buscar(rs.getInt("id_animal")));
                p.setFecha(rs.getString("fecha"));
                p.setTot_produccion_leche(rs.getDouble("sum(produccion.total_prod)"));
                lista.add(p);
            }
        }catch (Exception e){
            System.err.println(" No se puede Buscar la produccion...............");  
        }
        return lista;
    }
    
    public ArrayList buscar_prod_diaria_admin(String fecha){   //implementar metodo en el dao animal
        ArrayList<Produccion> lista = new ArrayList<>();
        String sql= "select finca.nombre,animal.id_animal,produccion.fecha,sum(produccion.total_prod),(sum(produccion.total_prod)*2000) from lab.animal,lab.produccion,lab.finca where animal.id_finca=finca.id_finca and produccion.id_animal=animal.id_animal and produccion.fecha='"+fecha+"' group by id_animal order by finca.nombre";  
        try{
            Connection con = getConectar();
            java.sql.PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Produccion p= new Produccion();
                p.setAnimal(dao_animal.buscar(rs.getInt("id_animal")));
                p.setFecha(rs.getString("fecha"));
                p.setTot_produccion_leche(rs.getDouble("sum(produccion.total_prod)"));
                lista.add(p);
            }
        }catch (Exception e){
            System.err.println(" No se puede Buscar la produccion...............");  
        }
        return lista;
    }
    
    public ArrayList buscar_prod_mensual_admin(String mes,String año){
        //aca se establece las fechas limites de los meses ejemplo enero corresponde a 01/01/2019 y 31/01/2019
            String fecha1="";
            String fecha2="";
            if(mes.equals("Enero")){
                fecha1=""+año+"-01-01";
                fecha2=""+año+"-01-31";
            }
            if(mes.equals("Febrero")){
                fecha1=""+año+"-02-01";
                fecha2=""+año+"-02-28";
            }
            if(mes.equals("Marzo")){
                fecha1=""+año+"-03-01";
                fecha2=""+año+"-03-31";
            }
            if(mes.equals("Abril")){
                fecha1=""+año+"-04-01";
                fecha2=""+año+"-04-30";
            }
            if(mes.equals("Mayo")){
                fecha1=""+año+"-05-01";
                fecha2=""+año+"-05-31";
            }
            if(mes.equals("Junio")){
                fecha1="}"+año+"-06-01";
                fecha2=""+año+"-06-30";
            }
            if(mes.equals("Julio")){
                fecha1=""+año+"-07-01";
                fecha2=""+año+"-07-31";
            }
            if(mes.equals("Agosto")){
                fecha1=""+año+"-08-01";
                fecha2=""+año+"-08-31";
            }
            if(mes.equals("Septiembre")){
                fecha1=""+año+"-09-01";
                fecha2=""+año+"-09-30";
            }
            if(mes.equals("Octubre")){
                fecha1=""+año+"-10-01";
                fecha2=""+año+"-10-31";
            }
            if(mes.equals("Noviembre")){
                fecha1=""+año+"-11-01";
                fecha2=""+año+"-30-01";
            }
            if(mes.equals("Diciembre")){
                fecha1=""+año+"-12-01";
                fecha2=""+año+"-31-01";
            }
        ArrayList<Produccion> lista = new ArrayList<>();
        String sql= "select finca.nombre,animal.id_animal,produccion.fecha,sum(produccion.total_prod),(sum(produccion.total_prod)*2000) from lab.animal,lab.produccion,lab.finca where animal.id_finca=finca.id_finca and produccion.id_animal=animal.id_animal and produccion.fecha between '"+fecha1+"' and '"+fecha2+"' group by id_animal order by finca.nombre";  
        try{
            Connection con = getConectar();
            java.sql.PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Produccion p= new Produccion();
                p.setAnimal(dao_animal.buscar(rs.getInt("id_animal")));
                p.setFecha(rs.getString("fecha"));
                p.setTot_produccion_leche(rs.getDouble("sum(produccion.total_prod)"));
                lista.add(p);
            }
        }catch (Exception e){
            System.err.println(" No se puede Buscar la produccion...............");  
        }
        return lista;
    }
     
 
}