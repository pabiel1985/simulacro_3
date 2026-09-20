import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Enum.Estados;

public class App {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        GestorOrden gestorOrden = new GestorOrden();

        int opcion;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Agregar");
            System.out.println("2. Buscar");
            System.out.println("3. Modificar");
            System.out.println("4. Buscar por estado");
            System.out.println("5. Precio total:  ");
            System.out.println("6. Orden mas cara");
            System.out.println("7. Mayor a menor");
            System.out.println("0. Salir");

            opcion = entrada.nextInt();
            entrada.nextLine();

            switch (opcion) {

                case 1:
                    OrdenTrabajo orden = null;
                    System.out.println("Elegir 1-preventivo o 2-corecctivo");
                    int tipoMantenimiento = entrada.nextInt();
                    entrada.nextLine();
                    System.out.println("Nombre de maquina");
                    String nombre = entrada.nextLine();
                    System.out.println("Descripcion");
                    String descripcion = entrada.nextLine();
                    System.out.println("Fecha");
                    String fecha = entrada.nextLine();
                    if (tipoMantenimiento == 1) {
                        System.out.println("Horas");
                        int horas = entrada.nextInt();
                        entrada.nextLine();
                        orden = new MantenimientoPreventivo(descripcion, nombre, fecha, horas);
                    } else if (tipoMantenimiento == 2) {
                        System.out.println("Nivel urgencia de 1 a 5");
                        int nivel = entrada.nextInt();
                        entrada.nextLine();
                        orden = new MantenimientoCorrectivo(descripcion, nombre, fecha, nivel);
                    } else {
                        System.out.println("Incorrecto");
                    }
                    gestorOrden.nuevaOrdenTrabajo(orden);
                    break;

                case 2:
                    System.out.println("numero de orden a buscar");
                    int numOrden = entrada.nextInt();
                    entrada.nextLine();
                    OrdenTrabajo orden2 = gestorOrden.buscarOrdenTrabajo(numOrden);
                    if (orden2 != null) {
                        System.out.println(orden2);
                    } else {
                        System.out.println("No se encontro el orden");
                    }
                    break;

                case 3:
                    System.out.println("Numero de orden a modificar Estado");
                    int numOrden2 = entrada.nextInt();
                    entrada.nextLine();
                    Estados cambiarEstado = Estados.valueOf(entrada.nextLine().toUpperCase());
                    if (gestorOrden.cambiarEstadoOrdenTrabajo(numOrden2, cambiarEstado)) {
                        System.out.println("Estado actualizado");
                    } else {
                        System.out.println("Error al cambiar estado");
                    }
                    break;

                case 4:
                    System.out.println("Ingrese estado");
                    Estados b = Estados.valueOf(entrada.nextLine().toUpperCase());
                    List<OrdenTrabajo> listaEstados = gestorOrden.listarPorEstado(b);
                    for (OrdenTrabajo estado : listaEstados) {
                        System.out.println(estado);
                    }
                    break;

                case 5:
                    double total;
                    total = gestorOrden.calcualTotal();
                    System.out.println("El total es: " + total);
                    break;


                case 6:
                    OrdenTrabajo m;
                    m = gestorOrden.ordenMasCara();
                    System.out.println("El mas cara: " + m);
                    break;


                case 7:
                    List<OrdenTrabajo> ordenes = gestorOrden.ordenarMaxorMenor();
                    for (OrdenTrabajo estado : ordenes) {
                        System.out.println(estado);
                    }
                    break;

                case 0:
                    System.out.println("Hasta pronto");
                    break;

                default:
                    System.out.println("Opcion no permitida");
                    break;
            }

        } while (opcion != 0);
    }
}