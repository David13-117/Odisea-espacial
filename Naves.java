public class Naves {

    final static String Reset = "\u001B[0m";
    final static String red = "\u001B[31m";
    final static String green = "\u001B[32m";
    final static String yellow = "\u001B[33m";

    static String[][] naves = {
            { "Space-X", "89000", "4", "Distorsión Gravitacional", "manipula la gravedad acortando las distancias" },
            { "Enterprise", "120000", "6", "Recuperación Espacial","Repara un 50% los daños y recarga los suministros" },
            { "Nautilus", "75000", "3", "Escudo de Plasma", "Escudo de energia que protege de impactos" },
            { "Excelsior", "99000", "8", "Reparación Automática","Repara la nave de forma autónoma durante la exploración." },
    };

    // metodo de mostrar las naves y el nombre de la habilidad
    public static void mostrarNaves() {
        System.out.println("^^^^^^Vehículos^^^^^^");
        for (int i = 0; i < naves.length; i++) {
            System.out.println((i + 1) + ". " + naves[i][0] + " - " + naves[i][2] + " Pasajeros");
        }
    }

    // metodo de información de la nave seleccionada y validación de pasajeros
    public static void naveSeleccionada(int option, int pasajeros) {
        if (pasajeros > 0) {
            System.out.println("La nave seleccionada es " + green + naves[(option - 1)][0] + Reset);
            System.out.println("La velocidad de la nave es " + naves[(option - 1)][1] + " k/s");
            System.out.println("Habilidad: " + yellow + naves[(option - 1)][3] + Reset + "\n" + naves[(option - 1)][4]);
        } else {
            System.out.println(red + "La cantidad de pasajeros no es valida" + Reset);
        }

    }

}
