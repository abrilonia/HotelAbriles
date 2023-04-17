package controlador;

import modelo.Cabagna;
import modelo.Carpa;
import modelo.Hotel;
import modelo.MedioAlojamiento;

import java.util.ArrayList;

public class MiHotel {
    private ArrayList<MedioAlojamiento> elHotel;

    public MiHotel() {
    }

    public MiHotel(ArrayList<MedioAlojamiento> elHotel) {
        this.elHotel = elHotel;
    }

    public ArrayList<MedioAlojamiento> getElHotel() {
        return elHotel;
    }

    public void setElHotel(ArrayList<MedioAlojamiento> elHotel) {
        this.elHotel = elHotel;
    }

    public int buscaRut(String rutCliente){
        for(int i=0; i<elHotel.size(); i++){
            if(elHotel.get(i).getDatoCliente().getRut().compareToIgnoreCase(rutCliente)==0){
                return i;
            }
        }
        return -1;
    }

    public String imprimeDatosCliente(String rutCliente){
        for (int i=0; i<elHotel.size(); i++){
            Carpa carpa=null;
            Hotel hotel=null;
            Cabagna cabagna=null;
            if(elHotel.get(i).getDatoCliente().getRut().compareToIgnoreCase(rutCliente)==0 && elHotel.get(i) instanceof Carpa){
                carpa = (Carpa) elHotel.get(i);
                return "El cliente se encuentra registrado en :" + carpa.toString();
            }
            else if(elHotel.get(i).getDatoCliente().getRut().compareToIgnoreCase(rutCliente)==0 && elHotel.get(i) instanceof Hotel){
                hotel = (Hotel) elHotel.get(i);
                return "El cliente se encuentra registrado en :" + hotel.toString();
            }
            else if(elHotel.get(i).getDatoCliente().getRut().compareToIgnoreCase(rutCliente)==0 && elHotel.get(i) instanceof Cabagna){
                cabagna = (Cabagna) elHotel.get(i);
                return "El cliente se encuentra registrado en :" + cabagna.toString();
            }
        } return "El rut del cliente: " + rutCliente + ", no está asociado a ningún alojamiento";
    }

    public String totalAdicional() {
        Hotel hotel = null;
        int total=0;
        if (elHotel.size() > 0) {
            for (int i = 0; i < elHotel.size(); i++) {
                if (elHotel.get(i) instanceof Hotel) {
                    hotel = (Hotel) elHotel.get(i);
                    total=total+hotel.adicional();
                }
            }
            return "El total adicional es de: " + total;
        }
        return "No hay registros de alojamientos";
    }

    public String bonoDescuentos(){
        int total=0;
        Hotel hotel=null;
        Carpa carpa=null;
        Cabagna cabagna=null;
        if (elHotel.size() > 0) {
            for (int i = 0; i < elHotel.size(); i++) {
              total=total+elHotel.get(i).bonoDescuento();
                }

            return "El total de bono descuento es de: " + total;
        }
        return "No hay registros de alojamientos";

    }

    public String aCancelarCliente(String rutCliente){
        for (int i=0; i<elHotel.size(); i++){

            if(elHotel.get(i).getDatoCliente().getRut().compareToIgnoreCase(rutCliente)==0){

                return "El valor a cancelar es de: " + elHotel.get(i).valorACancelar();
            }

        } return "El rut del cliente: " + rutCliente + ", no está registrado o ingresó algún dato incorrecto";
    }

    public String incremento(String rutCliente){

        Cabagna cabagna=null;
        for (int i=0; i<elHotel.size(); i++){
            if (elHotel.get(i).getDatoCliente().getRut().compareToIgnoreCase(rutCliente)==0 && elHotel.get(i) instanceof Cabagna){
                cabagna = (Cabagna) elHotel.get(i);
                return "El incremento en el valor base es de: " + cabagna.incrementaValorBase();
            }

        }return "A este cliente no le corresponde un incremento o no está registrado";

    }

    public String imprimeCarpa() {
        Carpa carpa = null;
        for (int i = 0; i < elHotel.size(); i++) {
            if (elHotel.get(i) instanceof Carpa) {
                carpa = (Carpa) elHotel.get(i);
            }
        }
        return carpa.toString();
    }
    public String imprimeHotel() {
        Hotel hotel = null;
        for (int i = 0; i < elHotel.size(); i++) {
            if (elHotel.get(i) instanceof Hotel) {
                hotel = (Hotel) elHotel.get(i);
            }
        }
        return hotel.toString();
    }
    public String imprimeCabagna() {
        Cabagna cabagna = null;
        for (int i = 0; i < elHotel.size(); i++) {
            if (elHotel.get(i) instanceof Cabagna) {
                cabagna = (Cabagna) elHotel.get(i);
            }
        }
        return cabagna.toString();
    }
    public void ingresaHotel(Hotel hotel){
        if(buscaRut(hotel.getDatoCliente().getRut())==-1){
            elHotel.add(hotel);
        }
    }

    public void ingresaCabagna(Cabagna cabagna){
        if(buscaRut(cabagna.getDatoCliente().getRut())==-1){
            elHotel.add(cabagna);
        }
    }

    public void ingresaCarpa(Carpa carpa){
        if(buscaRut(carpa.getDatoCliente().getRut())==-1){
            elHotel.add(carpa);
        }
    }

    @Override
    public String toString() {
        return " MiHotel registros: {" +
                "Alojamientos creados= " + elHotel +
                '}';
    }
}
