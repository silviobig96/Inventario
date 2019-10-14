/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Silvio
 */
public class Enfermedad {
    private int id_enf;
    private String nombre;

    /**
     * @return the id_enf
     */
    public int getId_enf() {
        return id_enf;
    }

    /**
     * @param id_enf the id_enf to set
     */
    public void setId_enf(int id_enf) {
        this.id_enf = id_enf;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
