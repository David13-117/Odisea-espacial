public class Planeta {

    final static String Reset = "\u001B[0m";
    final static String green = "\u001B[32m";

    static String[][] planetas = {
            { "Marte", "78", "El 'planeta rojo', tiene una atmósfera delgada y dos lunas." },
            { "Júpiter", "628", "El más grande, con la Gran Mancha Roja." },
            { "Saturno", "1275", "Famoso por sus anillos espectaculares." },
    };

    // metodo de mostrar los planetas
    public static void mostrarPlanetas() {
        System.out.println("*****Planetas*****");
        for (int i = 0; i < planetas.length; i++) {
            System.out.println((i + 1) + ". " + planetas[i][0]);
        }
    }

    // metodo de información del planeta seleccionado
    public static void planetaSeleccionado(int option) {
        System.out.println("El planeta seleccionado es " + green + planetas[(option - 1)][0]+Reset);
        System.out.println("El planeta destino esta a " + planetas[(option - 1)][1] + " millones de kilometros");
        System.out.println(planetas[(option - 1)][2]);
    }

}