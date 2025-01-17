//David Castillo Dev Senior Code

import java.util.Scanner;

public class Principal {
  public static void main(String[] args) {

    final String Reset = "\u001B[0m";
    final String red = "\u001B[31m";
    final String green = "\u001B[32m";
    final String yellow = "\u001B[33m";

    Scanner entrada = new Scanner(System.in);
    int option;
    int nave = -1, pasajeros = -1, destino = -1;

    String msg = (red + "Digite un valor valido" + Reset);
    while (true) {
      System.out.println("   *   " + yellow + "°" + Reset + "    *    " + yellow + "°" + Reset + "   *  ");
      System.out.println(" *     *   " + red + "[" + yellow + "°" + red + "]" + Reset + "    *   " + yellow + "°   " + Reset);
      System.out.println("      *   " + green + "<^>" + Reset + "     *     ");
      System.out.println("*^*^*^*^* Menu *^*^*^*^*");
      System.out.println("1. Seleccionar Planeta");
      System.out.println("2. Seleccionar Vehículo");
      System.out.println("3. Iniciar viaje");
      System.out.println("4. Salir");
      System.out.println("Seleccione una opción");
      option = entrada.nextInt();

      switch (option) {
        case 1:
          Planeta.mostrarPlanetas();
          System.out.println("Seleccione un planeta destino");
          destino = entrada.nextInt();
          Planeta.planetaSeleccionado(destino);
          System.out.println("1. Volver al menú");
          option = entrada.nextInt();
          switch (option) {
            case 1:

              break;

            default:
              System.out.println(msg);
              break;
          }
          break;
        case 2:
          Naves.mostrarNaves();
          System.out.println("Seleccione un vehículo para el viaje");
          nave = entrada.nextInt();
          System.out.println("Ingrese el número de pasajeros");
          pasajeros = entrada.nextInt();
          Naves.naveSeleccionada(nave, pasajeros);
          System.out.println("1. Volver al menú");
          option = entrada.nextInt();
          switch (option) {
            case 1:

              break;

            default:
              System.out.println(msg);
              break;
          }
          break;

        case 3:
          boolean ticket = viaje.viaje(nave, pasajeros, destino);
          System.out.println(green + "1. Iniciar Viaje" + Reset);
          System.out.println("2. Volver al menú");
          option = entrada.nextInt();
          viaje valores = new viaje(100, 100, 0);
          switch (option) {
            case 1:
              if (ticket == true) {
                while (valores.getProgresoViaje() < 100) {
                  try {
                    Thread.sleep(2000);
                  } catch (InterruptedException e) {
                    System.out.println(red + "No se pudo ejecutar el viaje" + Reset);
                    e.printStackTrace();
                  }
                  valores.indicadores(nave);
                }
              } else {
                System.out.println("No se pudo iniciar viaje...");
                continue;
              }
              break;

            case 2:

              break;

            default:
              System.out.println(msg);
              break;
          }

          break;

        case 4:
          System.out.println("Saliendo del sistema...");
          System.exit(0);
          break;

        default:
          System.out.println(msg);
          break;
      }

    }
  }
}