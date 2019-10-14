package modelo;

public class Produccion {
    private int id_produccion;
    private Animal animal;
    private double ordeño1;
    private double ordeño2;
    private String fecha;
    private double tot_produccion_leche;
    
    public int getId_produccion() {
        return id_produccion;
    }

    public void setId_produccion(int id_produccion) {
        this.id_produccion = id_produccion;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public double getOrdeño1() {
        return ordeño1;
    }

    public void setOrdeño1(double ordeño1) {
        this.ordeño1 = ordeño1;
    }

    public double getOrdeño2() {
        return ordeño2;
    }

    public void setOrdeño2(double ordeño2) {
        this.ordeño2 = ordeño2;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getTot_produccion_leche() {
        return tot_produccion_leche;
    }

    public void setTot_produccion_leche(double tot_produccion_leche) {
        this.tot_produccion_leche = tot_produccion_leche;
    }
    public double calc_precio(){
        return (tot_produccion_leche)*2000d;
    }
}
