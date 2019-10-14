package modelo;

public class Animal {
    private int id_animal;
    private String nombre;
    private double precio;
    private double promedio;
    private String estado;
    private Raza raza;
    private String fecha_venta;
    private Finca finca;
    private Enfermedad enfermedad;
  
    
    public Animal()
    {
       super();  
    }
    
public Animal(int id_animal,String nombre, double precio, double promedio, String estado, Raza raza){
    super();
    this.id_animal= id_animal;
    this.nombre= nombre;
    this.precio= precio;
    this.promedio= promedio;
    this.estado= estado;
    this.raza= raza;
}

    public int getId_animal() {
        return id_animal;
    }

    public void setId_animal(int id_animal) {
        this.id_animal = id_animal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Raza get_raza() {
        return raza;
    }

    public void set_raza(Raza raza) {
        this.raza = raza;
    }

    public String getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(String fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public Finca getFinca() {
        return finca;
    }

    public void setFinca(Finca finca) {
        this.finca = finca;
    }

    /**
     * @return the enfermedad
     */
    public Enfermedad getEnfermedad() {
        return enfermedad;
    }

    /**
     * @param enfermedad the enfermedad to set
     */
    public void setEnfermedad(Enfermedad enfermedad) {
        this.enfermedad = enfermedad;
    }
}

