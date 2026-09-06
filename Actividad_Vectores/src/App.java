import java.util.ArrayList;
import java.util.Scanner;

public class App {
    static final int TAMAÑO = 15;
    static final int MIN_VALOR = 10;
    static final int MAX_VALOR = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] vector = new int[TAMAÑO];
        boolean vectorLleno = false;

        while (true) {
            System.out.println();
            System.out.println("===============================================================");
            System.out.println("        MENU DE OPERACIONES CON VECTORES - YESID RIOS");
            System.out.println("===============================================================");
            System.out.println("1. Ingresar vector");
            System.out.println("2. Buscar valor en el vector");
            System.out.println("3. Mostrar mayor y menor");
            System.out.println("4. Mostrar multiplos de X");
            System.out.println("5. Calcular suma total");
            System.out.println("6. Mostrar promedio y valores por encima del promedio");
            System.out.println("7. Mostrar vector completo");
            System.out.println("0. Salir");
            System.out.println("-----------------------------------------------");
            System.out.print("Seleccione una opcion: ");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    llenarVector(scanner, vector);
                    vectorLleno = true;
                    break;
                case 2:
                    if (!vectorLleno) {
                        System.out.println("\nPrimero debe llenar el vector.");
                    } else {
                        buscarValor(scanner, vector);
                    }
                    break;
                case 3:
                    if (!vectorLleno) {
                        System.out.println("\nPrimero debe llenar el vector.");
                    } else {
                        mostrarMayorYMenor(vector);
                    }
                    break;
                case 4:
                    if (!vectorLleno) {
                        System.out.println("\nPrimero debe llenar el vector.");
                    } else {
                        mostrarMultiplos(scanner, vector);
                    }
                    break;
                case 5:
                    if (!vectorLleno) {
                        System.out.println("\nPrimero debe llenar el vector.");
                    } else {
                        System.out.println("\nLa suma total del vector es: " + sumarVector(vector));
                    }
                    break;
                case 6:
                    if (!vectorLleno) {
                        System.out.println("\nPrimero debe llenar el vector.");
                    } else {
                        mostrarPromedioYSuperiores(vector);
                    }
                    break;
                case 7:
                    if (!vectorLleno) {
                        System.out.println("\nPrimero debe llenar el vector.");
                    } else {
                        mostrarVector(vector);
                    }
                    break;
                case 0:
                    System.out.println("\nGracias por usar el programa.");
                    scanner.close();
                    return;
                default:
                    System.out.println("\nOpcion invalida. Intente nuevamente.");
            }
        }
    }

    
}
