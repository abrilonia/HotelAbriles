package modelo;

public class Cabagna extends Hospederia{
    private Boolean chimenea;

    public Cabagna(Integer cantidadNoches, String tipoTemporada, Integer valorBaseNoche, DatoCliente datoCliente, Integer capacidad, Boolean esFumador, Boolean chimenea) {
        super(cantidadNoches, tipoTemporada, valorBaseNoche, datoCliente, capacidad, esFumador);
        this.chimenea = chimenea;
    }

    public Cabagna() {
    }

    public Boolean getChimenea() {
        return chimenea;
    }

    public void setChimenea(Boolean chimenea) {
        this.chimenea = chimenea;
    }

    public int incrementaValorBase(){

        int incrementaValorBase = 0;
        if(this.getCapacidad()>5){
            incrementaValorBase= (int)Math.round(this.getValorBaseNoche()*0.18);
        }
        return incrementaValorBase;
    }

    @Override
    public int valorACancelar() {
        double factor = 1;
        if(this.getCapacidad()>5){
            factor=1.18;
        }
        return (int)(this.subTotal()*factor - this.bonoDescuento()*factor);

    }

    @Override
    public String toString() {
        return " Cabagnas {" + "nNoches: "+ getCantidadNoches() + ", temporada: " + getTipoTemporada() + ",\n valorNoche: "
                + getValorBaseNoche() + ", nombreCte: " + getDatoCliente().getNombreCliente() + " rutCte: " + getDatoCliente().getRut() +
                ", capacidad: " + getCapacidad() + ", esFumador: " + getEsFumador() + ", chimenea: " + chimenea + '}';
    }
}
