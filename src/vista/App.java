package vista;

import controlador.MiHotel;
import modelo.Cabagna;
import modelo.Carpa;
import modelo.DatoCliente;
import modelo.Hotel;

import java.util.ArrayList;

public class App {



    public static void main(String[] args) {
        MiHotel elHotel = new MiHotel(new ArrayList<>());
        String rut;

        Hotel hotel = new Hotel(2, "Temporada baja", 20000, new DatoCliente("Maria", "27154876-2"), 1, true, true);

        elHotel.ingresaHotel(hotel);

        int opcion;
        do {
            opcion = menu();
            switch (opcion) {
                case 1:
                    rut = pedirRut();
                    if (elHotel.buscaRut(rut) == -1) {
                        System.out.println("Ingrese la cantidad de noches");
                        int nNoches = Leer.datoInt();

                        String temporada;
                        do {
                            System.out.println("Ingrese el tipo de temporada, temporada baja, temporada media o temporada alta.");
                            temporada = Leer.dato();
                        } while (temporada.compareToIgnoreCase("Temporada media") != 0 && temporada.compareToIgnoreCase("Temporada baja") != 0 && temporada.compareToIgnoreCase("Temporada alta") != 0);

                        System.out.println("Ingrese el valor base por noche");
                        int valorBase = Leer.datoInt();

                        System.out.println("Ingrese el nombre del cliente");
                        String nombreCte = Leer.dato();

                        System.out.println("Ingrese el rut del cliente (Ej: 123456789-1)");
                        String rutCte = Leer.dato();

                        String tipoAloja;
                        do {
                            System.out.println("Ingrese el alojamiento a. Carpa, b. Hotel y c. Cabagna");
                            System.out.println("Seleccione a, b o c según corresponda");
                            tipoAloja = Leer.dato();
                        } while (tipoAloja.compareToIgnoreCase("a") != 0 && tipoAloja.compareToIgnoreCase("b") != 0 && tipoAloja.compareToIgnoreCase("c") != 0);

                        if (tipoAloja.equalsIgnoreCase("a")) {
                            System.out.println("Ingrese la cantidad de personas");
                            int personasCarpa = Leer.datoInt();
                            Carpa carpa = new Carpa(nNoches, temporada, valorBase, new DatoCliente(nombreCte, rutCte), personasCarpa);

                            elHotel.ingresaCarpa(carpa);
                            System.out.println("Alojamiento creado con éxito\n" + elHotel.imprimeCarpa());
                        } else {
                            System.out.println("Ingrese la capacidad");
                            int capacidad = Leer.datoInt();

                            String caso;
                            boolean fumador = false;
                            do {
                                System.out.println("Indique si es fumador, * y * si lo es, * x * si no lo es");

                                caso = Leer.dato();

                                switch (caso) {
                                    case "y":
                                        fumador = true;
                                        break;
                                    case "x":
                                        fumador = false;
                                        break;
                                }

                            } while (caso.compareToIgnoreCase("y") != 0 && caso.compareToIgnoreCase("x") != 0);


                            if (tipoAloja.equalsIgnoreCase("b")) {
                                String desa;
                                boolean desayuno = false;
                                do {
                                    System.out.println("¿Incluye desayuno? Marque * s * para sí y * n * para no");
                                    desa = Leer.dato();

                                    switch (desa) {
                                        case "s":
                                            desayuno = true;
                                            break;
                                        case "n":
                                            desayuno = false;
                                            break;
                                    }

                                }while (desa.compareToIgnoreCase("s")!=0 && desa.compareToIgnoreCase("n")!=0);

                                elHotel.ingresaHotel(new Hotel(nNoches, temporada, valorBase, new DatoCliente(nombreCte, rutCte), capacidad, fumador, desayuno));
                                System.out.println("Alojamiento creado con éxito\n" + elHotel.imprimeHotel());
                            } else {
                                System.out.println("¿Tiene chimenea? Escriba true para sí, y false para no");
                                boolean chimenea = Leer.datoBoolean();
                                elHotel.ingresaCabagna(new Cabagna(nNoches, temporada, valorBase, new DatoCliente(nombreCte, rutCte), capacidad, fumador, chimenea));
                                System.out.println("Alojamiento ingresado con éxito\n" + elHotel.imprimeCabagna());
                            }

                        }
                    }else {
                        System.out.println("El cliente ya se encuentra registrado");
                    }
                            break;


                case 2:

                    System.out.println("Mostrar alojamientos---->\n" + elHotel.toString() );

                    break;
                case 3:
                    rut=pedirRut();
                    System.out.println(elHotel.imprimeDatosCliente(rut));

                    break;
                case 4:
                    rut=pedirRut();
                    System.out.println( elHotel.totalAdicional(rut));
                    break;
                case 5:
                    rut=pedirRut();
                    System.out.println(elHotel.bonoDescuentos(rut));
                    break;
                case 6:
                    System.out.println("La cantidad de alojamientos es de: " + elHotel.getElHotel().size());
                    break;
                case 7:
                    rut=pedirRut();
                    System.out.println(elHotel.aCancelarCliente(rut));
                    break;
                case 8:
                    rut=pedirRut();
                    System.out.println(elHotel.incremento(rut));
            }

        } while (opcion != 9); //repetir
    }





    public static int menu(){
        System.out.println("**********Bievenido a Mi Hotel *********");
        System.out.println("1.\tIngresar alojamiento");
        System.out.println("2.\tMostrar alojamientos");
        System.out.println("3.\tVer datos de un cliente");
        System.out.println("4.\tVer el total adicional");
        System.out.println("5.\tVer el total con bono descuento");
        System.out.println("6.\tVer total de medios de alojamiento de un cliente");
        System.out.println("7.\tVer el valor a cancelar del cliente");
        System.out.println("8.\tVer el incremento valor base");
        System.out.println("9.\tSalir");
        System.out.println("Favor ingrese una opción válida.");

        return Leer.datoInt();
    }

    public static String pedirRut(){
        System.out.println("Favor ingrese el rut del cliente (Ej: 12345678-1)");
        return Leer.dato();
    }
}
