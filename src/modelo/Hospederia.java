package modelo;

public abstract class Hospederia extends MedioAlojamiento {
    private Integer capacidad;
    private Boolean esFumador;

    public Hospederia(Integer cantidadNoches, String tipoTemporada, Integer valorBaseNoche, DatoCliente datoCliente, Integer capacidad, Boolean esFumador) {
        super(cantidadNoches, tipoTemporada, valorBaseNoche, datoCliente);
        this.capacidad = capacidad;
        this.esFumador = esFumador;
    }

    public Hospederia() {
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public Boolean getEsFumador() {
        return esFumador;
    }

    public void setEsFumador(Boolean esFumador) {
        this.esFumador = esFumador;
    }
}
