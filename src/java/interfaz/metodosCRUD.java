/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;


import java.util.List;
import modelo.Animal;

/**
 *
 * @author ..crisbel
 */
public interface metodosCRUD {
    
    public List listar(String nombre_usuario);
    public Animal list(int id);
    public boolean registrarVaca(Animal animal);
    public boolean editar(Animal animal);
    public boolean eliminar(int id);
    
}
