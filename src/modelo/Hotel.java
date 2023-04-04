package modelo;

public class Hotel extends Hospederia{
    private Boolean conDesayuno;

    public Hotel(Integer cantidadNoches, String tipoTemporada, Integer valorBaseNoche, DatoCliente datoCliente, Integer capacidad, Boolean esFumador, Boolean conDesayuno) {
        super(cantidadNoches, tipoTemporada, valorBaseNoche, datoCliente, capacidad, esFumador);
        this.conDesayuno = conDesayuno;
    }

    public Hotel() {
    }

    public Boolean getConDesayuno() {
        return conDesayuno;
    }

    public void setConDesayuno(Boolean conDesayuno) {
        this.conDesayuno = conDesayuno;
    }

    public int adicional(){
        //si es fumador y con desayuno, aumenta 30%
        int adicional = 0;
        if(this.getEsFumador().equals(true) && this.getConDesayuno().equals(true)){
            adicional=Math.round(this.subTotal()*30/100);
        }
        return adicional;
    }

    @Override
    public int valorACancelar() {
        return this.subTotal() + this.adicional() - this.bonoDescuento();
    }
}
