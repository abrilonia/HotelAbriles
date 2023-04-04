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
        //Si la capacidad es mayor a 5, incrementa 18%
        int incrementaValorBase = 0;

        if(this.getCapacidad()>5){
            incrementaValorBase= (int)Math.round(this.getValorBaseNoche()*0.18);
            setValorBaseNoche(getValorBaseNoche()+incrementaValorBase);

        }
        return incrementaValorBase;
    }

    @Override
    public int valorACancelar() {
        return this.subTotal() - this.bonoDescuento();
    }
}
