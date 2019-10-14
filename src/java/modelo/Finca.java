package modelo;

public class Finca {
    private String id_finca;
    private String nombre;
    private String direccion;
    private int cant_hect;
    private Usuario nombre_usuario;
    private double promedio_diario;
    private double promedio_mensual;
    
    public Finca()
    {
    super();
    }
    
public Finca(String id_finca, String nombre, String direccion, int cant_hect, double promedio_diario, double promedio_mensual){
    super();
    this.id_finca= id_finca;
    this.nombre= nombre;
    this.direccion= direccion;
    this.cant_hect= cant_hect;
    this.promedio_diario= promedio_diario;
    this.promedio_mensual= promedio_mensual;
}

    public String getId_finca() {
        return id_finca;
    }

    public void setId_finca(String id_finca) {
        this.id_finca = id_finca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCant_hect() {
        return cant_hect;
    }

    public void setCant_hect(int cant_hect) {
        this.cant_hect = cant_hect;
    }

    public double getPromedio_diario() {
        return promedio_diario;
    }

    public void setPromedio_diario(double promedio_diario) {
        this.promedio_diario = promedio_diario;
    }

    public double getPromedio_mensual() {
        return promedio_mensual;
    }

    public void setPromedio_mensual(double promedio_mensual) {
        this.promedio_mensual = promedio_mensual;
    }

    public Usuario getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(Usuario nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

}
