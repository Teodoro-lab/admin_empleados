package models;

import interfaces.Printable;
import interfaces.Storable;

public class Empleado implements Printable, Storable {
    private int id;
    private String nombre;
    private String apellido;
    private float pago;

    private static int idCounter = 0;

    public Empleado(String nombre, String apellido) {
        this.id = idCounter++;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public float getPago() {
        return pago;
    }

    public void setPago(float pago) {
        this.pago = pago;
    }

    @Override
    public String infoToStore() {
        return "" + id + "," + nombre + "," + apellido;
    }

    @Override
    public String infoToPrint() {
        return "" + id + "-" + nombre + "-" + apellido + "-" + pago;
    };

}
