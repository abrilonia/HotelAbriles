package vista;

import modelo.Cabagna;
import modelo.Carpa;
import modelo.DatoCliente;
import modelo.Hotel;

public class App {
    public static void main(String[] args) {
        Hotel hotel1 = new Hotel(2,"Temporada baja", 20000, new DatoCliente("Abril","27654123-2"), 5, false,true);
        System.out.println("El subtotal es de: " + hotel1.subTotal());
        System.out.println("El bono descuento por temporada es de: " + hotel1.bonoDescuento());
        System.out.println("El adicional por fumar y tener desayuno es de: " + hotel1.adicional());
        System.out.println("El valor a cancelar por la hab. de hotel es de: " + hotel1.valorACancelar());

        System.out.println("-------- --- -------- --- -------- --- -------- --- --------");

        Cabagna cabagna1 = new Cabagna(1,"Temporada media", 20000, new DatoCliente("Luis", "27123456-1"),5,false, true);
        System.out.println("El subtotal es de: " + cabagna1.subTotal());
        System.out.println("El incremento en el valor base es de: " + cabagna1.incrementaValorBase());
        System.out.println("El subtotal actualizado es de: " + cabagna1.subTotal());
        System.out.println("El bono descuento por temporada es de: " + cabagna1.bonoDescuento());
        System.out.println("El valor a cancelar por la Cabagna es de: " + cabagna1.valorACancelar());

        System.out.println("-------- --- -------- --- -------- --- -------- --- --------");

        Carpa carpa1 = new Carpa(5, "Temporada baja", 15000, new DatoCliente("Maria", "26234567-k"),3);
        System.out.println("El subtotal es de: " + carpa1.subTotal());
        System.out.println("El descuento por temporada es de: " + carpa1.bonoDescuento());
        System.out.println("El valor a cancelar por la carpa es de: " + carpa1.valorACancelar() +", gracias por visitarnos, " + carpa1.getDatoCliente().getNombreCliente());
    }
}
