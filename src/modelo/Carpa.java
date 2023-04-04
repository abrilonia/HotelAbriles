package modelo;

public class Carpa extends MedioAlojamiento{

    private Integer cantidadPersonas;

    public Carpa(Integer cantidadNoches, String tipoTemporada, Integer valorBaseNoche, DatoCliente datoCliente, Integer cantidadPersonas) {
        super(cantidadNoches, tipoTemporada, valorBaseNoche, datoCliente);
        this.cantidadPersonas = cantidadPersonas;
    }

    public Carpa() {
    }

    public Integer getCantidadPersonas() {
        return cantidadPersonas;
    }

    public void setCantidadPersonas(Integer cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }

    @Override
    public int valorACancelar() {
        return this.subTotal() - this.bonoDescuento();
    }
}
