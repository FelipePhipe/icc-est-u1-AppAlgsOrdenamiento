import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int[] listadoOG = {12, -7, 25, 0, -15, 33, 19, -22, 5, 48, -3, 27, -30, 14, 7, -1, 41, 20, -11, 8};
        MetodoBurbujaFP mBFP = new MetodoBurbujaFP();
        MetodoInsercionFP mIFP = new MetodoInsercionFP();
        MetodoSeleccionFP mSFP = new MetodoSeleccionFP();
        MetodoBurbujaMFP mBMFP = new MetodoBurbujaMFP();

        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while(continuar) {
            System.out.println("Seleccione el método de ordenamiento:");
            System.out.println("1. Burbuja");
            System.out.println("2. Selección");
            System.out.println("3. Inserción");
            System.out.println("4. Burbuja Mejorado");
            System.out.println("5. Salir");

            int metodo = getPositive(scanner, "Ingrese la opcion");

            if (metodo == 5) {
                System.out.println("Adios");
                continuar = false;
                break;
            }

            System.out.println("¿Desea ver los pasos? (true/false):");
            boolean conPasos = scanner.nextBoolean();

            String orden = getValidString(scanner, new String[]{"A","D"},
                    "¿Desea ordenar ascendentemente (A) o descendentemente (D)?:");

            boolean ascendente = orden.equalsIgnoreCase("A");

            int[] listado = listadoOG.clone();
            System.out.println("Arreglo original -> " + arrayToString(listado));

            switch (metodo) {
                case 1:
                    System.out.println("Método Burbuja");
                    mBFP.ordenar(listado, ascendente, conPasos);
                    break;
                case 2:
                    System.out.println("Método Selección");
                    mSFP.ordenar(listado, ascendente, conPasos);
                    break;
                case 3:
                    System.out.println("Método Inserción");
                    mIFP.ordenar(listado, ascendente, conPasos);
                    break;
                case 4:
                    System.out.println("Método Burbuja Mejorado");
                    int[] resultados = mBMFP.ordenar(listado, ascendente, conPasos);
                    System.out.println("Comparaciones Totales -> " + resultados[0]);
                    System.out.println("Cambios Totales -> " + resultados[1]);
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }

            System.out.println("--FIN DEL METODO--");
            System.out.println("Arreglo ordenado -> " + arrayToString(listado));
            System.out.println();
        }
        scanner.close();
    }

    public static int getPositive(Scanner scanner, String message) {
        int input;
        do {
            System.out.print(message + ": ");
            input = scanner.nextInt();
            if (input <= 0) {
                System.out.println("El número debe ser positivo. Intente nuevamente.");
            }
        } while (input <= 0);
        return input;
    }

    public static String getValidString(Scanner scanner, String[] posibles, String message) {
        String input;
        boolean valido;
        do {
            System.out.print(message + ": ");
            input = scanner.next();
            valido = false;
            for (String posible : posibles) {
                if (input.equalsIgnoreCase(posible)) {
                    valido = true;
                    break;
                }
            }
            if (!valido) {
                System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (!valido);
        return input;
    }

    public static String arrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}