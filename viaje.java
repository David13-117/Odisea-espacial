import java.util.*;

public class viaje {

    final static String Reset = "\u001B[0m";
    final static String red = "\u001B[31m";
    final static String green = "\u001B[32m";
    final static String yellow = "\u001B[33m";

    public int combustible;
    private int daños;
    private int progresoViaje;

     public int getCombustible() {
        return combustible;
    }

    public int getDaños() {
        return daños;
    }

    public int getProgresoViaje() {
        return progresoViaje;
    }

    public viaje(int combustible, int daños, int progresoViaje) {
        this.combustible = combustible;
        this.daños = daños;
        this.progresoViaje = progresoViaje;
    }

    // validación de la información del viaje y calculo de las distancias
    public static boolean viaje(int nave, int pasajeros, int destino) {
        boolean ticket;
        if (nave == -1 && pasajeros ==-1 && destino == -1) {
            System.out.println(red + "Por favor seleccione un vehículo y un destino\npara iniciar el viaje" + Reset);
            ticket = false;
        } else if (nave > -1 && pasajeros > -1 && destino == -1){
            System.out.println(red+"Selecciona un destino para iniciar el viaje"+Reset);
            ticket = false;
        } else if (nave == -1 || pasajeros ==-1 && destino > -1){
            System.out.println(red+"Selecciona un vehículo para iniciar el viaje"+Reset);
            ticket = false;
        }else{
            int distancia = (Integer.parseInt(Planeta.planetas[(destino-1)][1])*100000);
            int velocidad = (Integer.parseInt(Naves.naves[(nave-1)][1]));
            int duracion = distancia/velocidad;
            int dias = duracion / 24;
        int horas = duracion % 24;
            System.out.printf("%-20s%-20s\n", "Planeta","Nave");
            System.out.println("---------------------------------");
            System.out.printf("%-16s%-16s\n", Planeta.planetas[(destino-1)][0],Naves.naves[(nave-1)][0]);
            System.out.printf("%-16s%-16s\n", "Distancia: "+Planeta.planetas[(destino-1)][1],"Velocidad: "+Naves.naves[(nave-1)][1]+" k/s");
            System.out.printf("%-16s%-16s\n","Pasajeros: "+pasajeros,"Habilidad: "+Naves.naves[(nave-1)][3]);
            System.out.println("---------------------------------");
            System.out.println("Duración del viaje: "+dias+" días "+horas+" horas\n");
            ticket = true;
        }
        return ticket;
    }

    // calculo de los indicadores así como mensajes de advertencia y la pantalla del viaje
    public void indicadores(int nave){
        Random azar = new Random();

        combustible -= azar.nextInt(4);
        daños -= azar.nextInt(4);

        if(progresoViaje < 100){
            progresoViaje += azar.nextInt(5);
            if(progresoViaje>100){
                progresoViaje = 100;
            }
            System.out.flush();
            System.out.println("*^*^*^*^* Odisea Espacial *^*^*^*^*");
            System.out.println("   *   "+yellow+"°"+Reset+"    *    "+yellow+"°"+Reset+"   *  ");
            System.out.println(" *     *   "+red+"["+yellow+"°"+red+"]"+Reset+"    *   "+yellow+"°   "+Reset);
            System.out.println("      *   "+green+"<^>"+Reset+"     *     ");
            System.out.println("Progreso del viaje "+green+progresoViaje+" %"+Reset);
            System.out.println("Combustible: "+yellow+combustible+" %"+Reset);
            System.out.println("Daños:       "+yellow+(100-daños)+" %"+Reset);
        }
        if(progresoViaje >= 50 && progresoViaje <= 52){
            Scanner entrada = new Scanner(System.in);
            System.out.println("Vamos por la mitad del viaje\nTe gustaria activar la habilidad?");
            System.out.println("1.Si\n2.No");
            int op = entrada.nextInt();
            switch (op) {
                case 1:
                    eventos(nave);
                    break;

                case 2:
                    
                    break;
            
                default:
                    System.out.println("");
                    break;
            }
        }

        if(combustible <= 25 && combustible > 5){
            System.out.println(red+"Cuidado combustible bajo..."+Reset);
        }else if (combustible < 0){
            combustible = 0;
            System.out.println(red+"oh no, te quedaste sin combustible"+Reset);
        }
        
        if(daños <= 35 && daños > 10){
            System.out.println(red+"Advertencia! infraestructura comprometida..."+Reset);
        }else if (daños < 5){
            daños = 0;
            System.out.println(red+"Daños criticos..."+Reset);
        }

        if(progresoViaje==100){
            System.out.println(green+"Felicidades has llegado a tu destino..."+Reset);
        }

    }

    public void eventos(int nave){
        //acortar la distancia del viaje
        if(Integer.parseInt(Naves.naves[(nave-1)][2]) == 4){
            System.out.println("Aplicando "+Naves.naves[(nave-1)][3]+" ...");
            progresoViaje += 35;
        }
        // reparar 30 % y recargar los suministros
        if(Integer.parseInt(Naves.naves[(nave-1)][2]) == 6){
            System.out.println("Aplicando "+Naves.naves[(nave-1)][3]+" ...");
            combustible += 100;
            combustible = Math.min(combustible, 100);
            daños += 30;
            daños = Math.min(daños, 100);

        }
        // detener el daño
        if(Integer.parseInt(Naves.naves[(nave-1)][2]) == 3){
            System.out.println("Aplicando "+Naves.naves[(nave-1)][3]+" ...");
            daños = 100;
        }
        //repación al 100%
        if(Integer.parseInt(Naves.naves[(nave-1)][2]) == 8){
            System.out.println("Aplicando "+Naves.naves[(nave-1)][3]+" ...");
            daños += 100;
            daños = Math.min(daños, 100);
        }
    }
   
}
