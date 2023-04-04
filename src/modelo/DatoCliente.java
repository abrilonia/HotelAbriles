package modelo;

public class DatoCliente {
    private String nombreCliente;
    private String rut;

    public DatoCliente(String nombreCliente, String rut) {
        this.nombreCliente = nombreCliente;
        this.rut = rut;
    }

    public DatoCliente() {
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombre(String nombre) {
        this.nombreCliente = nombre;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }
}
