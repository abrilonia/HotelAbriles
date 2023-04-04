package modelo;

public abstract class MedioAlojamiento{
    private Integer cantidadNoches;
    private String tipoTemporada;
    private Integer valorBaseNoche;
    private DatoCliente datoCliente;

    public MedioAlojamiento(Integer cantidadNoches, String tipoTemporada, Integer valorBaseNoche, DatoCliente datoCliente) {
        this.cantidadNoches = cantidadNoches;
        this.tipoTemporada = tipoTemporada;
        this.valorBaseNoche = valorBaseNoche;
        this.datoCliente = datoCliente;
    }

    public MedioAlojamiento() {
    }

    public Integer getCantidadNoches() {
        return cantidadNoches;
    }

    public void setCantidadNoches(Integer cantidadNoches) {
        this.cantidadNoches = cantidadNoches;
    }

    public String getTipoTemporada() {
        return tipoTemporada;
    }

    public void setTipoTemporada(String tipoTemporada) {
        this.tipoTemporada = tipoTemporada;
    }

    public Integer getValorBaseNoche() {
        return valorBaseNoche;
    }

    public void setValorBaseNoche(Integer valorBaseNoche) {
        this.valorBaseNoche = valorBaseNoche;
    }

    public DatoCliente getDatoCliente() {
        return datoCliente;
    }

    public void setDatoCliente(DatoCliente datoCliente) {
        this.datoCliente = datoCliente;
    }

    public int subTotal(){
        return this.getCantidadNoches()*getValorBaseNoche();
    }
    public int bonoDescuento(){
        int bonoDescuento=0;
        if(this.getTipoTemporada().equalsIgnoreCase("Temporada baja")){
            bonoDescuento=Math.round(this.subTotal()*25/100);
        }
        if (this.getTipoTemporada().equalsIgnoreCase("Temporada media")){
            bonoDescuento = (int)Math.round(this.subTotal()*12.5/100);
        }
        return bonoDescuento;
    }

    public abstract int valorACancelar();

}
