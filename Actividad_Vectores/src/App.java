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

    public static void llenarVector(Scanner scanner, int[] vector) {
        System.out.println();
        System.out.println("===============================================");
        System.out.println("          INGRESO DE VALORES DEL VECTOR");
        System.out.println("===============================================");

        for (int i = 0; i < vector.length; i++) {
            int valor;
            do {
                System.out.print("Ingrese el valor " + (i + 1) + " (entre " + MIN_VALOR + " y " + MAX_VALOR + "): ");
                valor = scanner.nextInt();

                if (valor < MIN_VALOR || valor > MAX_VALOR) {
                    System.out.println("El numero esta fuera del rango permitido. Intente nuevamente.");
                }
            } while (valor < MIN_VALOR || valor > MAX_VALOR);

            vector[i] = valor;
        }

        System.out.println();
        System.out.println("El vector ha sido completado.");
        mostrarVector(vector);
    }

    public static void buscarValor(Scanner scanner, int[] vector) {
        System.out.println();
        System.out.println("===============================================");
        System.out.println("             BUSQUEDA DE VALOR");
        System.out.println("===============================================");
        System.out.print("Ingrese el numero a buscar: ");
        int valorBuscado = scanner.nextInt();
        boolean encontrado = false;

        for (int i = 0; i < vector.length; i++) {
            if (vector[i] == valorBuscado) {
                System.out.println();
                System.out.println("El numero " + valorBuscado + " se encuentra en la posicion " + i + ".");
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println();
            System.out.println("El numero " + valorBuscado + " no se encuentra en el vector.");
        }
    }

    public static void mostrarMayorYMenor(int[] vector) {
        int mayor = vector[0];
        int menor = vector[0];

        for (int i = 1; i < vector.length; i++) {
            if (vector[i] > mayor) {
                mayor = vector[i];
            }
            if (vector[i] < menor) {
                menor = vector[i];
            }
        }

        System.out.println();
        System.out.println("El numero mayor es: " + mayor);
        System.out.println("El numero menor es: " + menor);
    }

    public static void mostrarMultiplos(Scanner scanner, int[] vector) {
        System.out.println();
        System.out.println("===============================================");
        System.out.println("           MULTIPLOS DE X EN EL VECTOR");
        System.out.println("===============================================");
        System.out.print("Ingrese el valor de X para buscar multiplos: ");
        int x = scanner.nextInt();
        boolean existenMultiplos = false;

        System.out.println();
        System.out.println("Los multiplos de " + x + " en el vector son:");

        for (int i = 0; i < vector.length; i++) {
            if (vector[i] % x == 0) {
                System.out.print(vector[i] + " ");
                existenMultiplos = true;
            }
        }

        if (!existenMultiplos) {
            System.out.println();
            System.out.println("No hay multiplos de " + x + " en el vector.");
        } else {
            System.out.println();
        }
    }

    public static int sumarVector(int[] vector) {
        int suma = 0;

        for (int i = 0; i < vector.length; i++) {
            suma += vector[i];
        }

        return suma;
    }

    public static void mostrarPromedioYSuperiores(int[] vector) {
        double suma = sumarVector(vector);
        double promedio = suma / vector.length;

        System.out.println();
        System.out.println("El promedio del vector es: " + promedio);

        ArrayList<Integer> mayoresAlPromedio = new ArrayList<>();

        for (int valor : vector) {
            if (valor > promedio) {
                mayoresAlPromedio.add(valor);
            }
        }

        if (mayoresAlPromedio.isEmpty()) {
            System.out.println();
            System.out.println("No hay numeros mayores que el promedio.");
        } else {
            System.out.println();
            System.out.println("Los numeros mayores que el promedio son:");
            for (int valor : mayoresAlPromedio) {
                System.out.print(valor + " ");
            }
            System.out.println();
            System.out.println();
            System.out.println("Cantidad de numeros por encima del promedio: " + mayoresAlPromedio.size());
        }
    }

    public static void mostrarVector(int[] vector) {
        System.out.println();
        System.out.println("===============================================");
        System.out.println("                 VECTOR ACTUAL");
        System.out.println("===============================================");
        for (int i = 0; i < vector.length; i++) {
            System.out.print(vector[i] + " ");
        }
        System.out.println();
        System.out.println();
    }
}
