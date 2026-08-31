package org.example;

import java.util.Scanner;

public class PROYECTO {

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        mostrarMenuInicial();
        int opcion = scr.nextInt();
        System.out.println();

        switch (opcion) {
            case 1:
                registrarEstudiantes(scr);
                break;

            case 2:
                System.out.println("Saliendo del sistema...");
                break;

            default:
                System.out.println("Opción no válida");
        }
        System.out.println();

        mostrarMenuPrincipal();
        opcion = scr.nextInt();
        System.out.println();
        do {
            switch (opcion) {
                case 1:
                    registrarEstudiantes(scr);
                    break;

                case 2:
                    mostrarListadoCompleto();
                    break;

                case 3:
                    for (int i = 0; i < calificaciones.length; i++) {
                        double promedio = calcularPromedio(calificaciones[i]);
                        System.out.println("El promedio del estudiante " + estudiantes[i] + " es: " + promedio);
                    }
                    break;


                default:
                    System.out.println("Opción aún no implementada.");
            }
            System.out.println();

            mostrarMenuPrincipal();
            opcion = scr.nextInt();
            System.out.println();

        } while (opcion != 7);
        System.out.println("Saliendo del sistema...");
    }


    //MENU INICIAL
    public static void mostrarMenuInicial() {
        System.out.println("******** Bienvenido al Sistema de Gestión Académica ********");
        System.out.println("Por favor, seleccione una opción:");
        System.out.println("1. Registrar estudiantes");
        System.out.println("2. Salir");
    }

    static String[] estudiantes;
    static long[] identificaciones;
    static double[][] calificaciones;

    public static void registrarEstudiantes(Scanner scr) {

        System.out.println("Ingrese el número de estudiantes a registrar: ");
        int numEstudiantes = scr.nextInt();
        scr.nextLine();

        estudiantes = new String[numEstudiantes];
        System.out.println();

        System.out.println("Ingrese los nombres de los estudiantes: ");
        for (int i = 0; i < numEstudiantes; i++) {
            System.out.println("Nombre completo del estudiante " + (i + 1) + ": ");
            estudiantes[i] = scr.nextLine();
        }
        System.out.println();

        System.out.println("Ahora proceda a agregar su numero de identificacion a cada estudiante: ");
        identificaciones = new long[numEstudiantes];
        for (int i = 0; i < numEstudiantes; i++) {
            System.out.println("Ingrese el numero de identificacion del estudiante " + "(" + estudiantes[i] + ")" + ": ");
            identificaciones[i] = scr.nextLong();
            scr.nextLine();
        }
        System.out.println();

        System.out.println("Ahora registre las calificaciones de cada estudiante: ");
        System.out.println("Ingrese el número de calificaciones a registrar para cada estudiante: ");
        int numCalificaciones = scr.nextInt();
        calificaciones = new double[numEstudiantes][numCalificaciones];
        for (int i = 0; i < numEstudiantes; i++) {
            System.out.println();
            for (int j = 0; j < numCalificaciones; j++) {
                System.out.println("Ingrese la calificacion del estudiante " + "(" + estudiantes[i] + ")" + " en la nota " + "(" + (j + 1) + ")" + ": ");
                calificaciones[i][j] = scr.nextDouble();
            }


        }
    }

    //MENU PRINCIPAL
    public static void mostrarMenuPrincipal() {
        System.out.println("******** Menú Principal ********");
        System.out.println("Por favor, seleccione una opción:");
        System.out.println("1. Registrar estudiantes");
        System.out.println("2. Mostrar listado completo de los estudiantes");
        System.out.println("3. Calcular promedio de cada estudiante");
        System.out.println("4. Buscar un estudiante por su número de identificación");
        System.out.println("5. Ordenar las calificaciones de un estudiante de menor a mayor");
        System.out.println("6. Encontrar y mostrar el estudiante con el promedio mas alto y mas bajo");
        System.out.println("7. Salir");
    }

    public static void mostrarListadoCompleto() {
        if (estudiantes == null || identificaciones == null) {
            System.out.println("No hay estudiantes registrados.");
            return;
        }
        System.out.println("Listado completo de los estudiantes: ");
        for (int i = 0; i < estudiantes.length; i++) {
            System.out.println("Estudiante " + (i + 1) + ": " + estudiantes[i] + " - ID: " + identificaciones[i]);
        }
    }

    static double calcularPromedio(double[] calificaciones) {
        double suma = 0;
        for (double calificacion : calificaciones) {
            suma += calificacion;
        }
        return suma / calificaciones.length;
    }
}


