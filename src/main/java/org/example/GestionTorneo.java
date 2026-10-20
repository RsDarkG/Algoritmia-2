package org.example;

import java.util.Scanner;

public class GestionTorneo {

    static long[] identificaciones;

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int opcion;

        // MENU INICIAL
        mostrarMenuInicial();
        opcion = scr.nextInt();
        System.out.println();

        switch (opcion) {
            case 1:
                registrarDeportistas(scr);
                break;

            case 2:
                System.out.println("Saliendo del sistema...");
                return;

            default:
                System.out.println("Opción no válida");
                return;
        }
        System.out.println();

        // MENU PRINCIPAL
        do {
            mostrarMenuPrincipal();
            opcion = scr.nextInt();
            System.out.println();
            switch (opcion) {
                case 1:
                    registrarDeportistas(scr);
                    break;

                case 2:

                    break;

                case 3:

                    break;

                case 4:

                    break;

                case 5:

                    break;

                case 6:

                    break;

                case 7:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción aún no implementada.");
                    break;
            }
            System.out.println();

        } while (opcion != 7);
    }


    //Menus
    public static void mostrarMenuPrincipal() {
        System.out.println("******** Menú Principal ********");
        System.out.println("Por favor, seleccione una opción:");
        System.out.println("1. Registrar deportistas");
        System.out.println("2. Mostrar listado completo de los deportistas registrados");
        System.out.println("3. Calcular puntaje final");
        System.out.println("4. Buscar deportista por identificación y mostrar sus datos. ");
        System.out.println("5. Modificar el nombre de un deportista");
        System.out.println("6. Ordenar los puntajes de cada fila de la matriz de menor a mayor (burbuja) y mostrarlas. ");
        System.out.println("7. Mostrar el deportista con el puntaje final más alto y el de puntaje más bajo.");
        System.out.println("8. Mostrar la suma de todos los puntajes de un deportista usando un procedimiento.");
        System.out.println("9. Salir. ");
    }

    public static void mostrarMenuInicial() {
        System.out.println("******** Bienvenido al Sistema de Gestión de Torneo Deportivo ********");
        System.out.println("Por favor, seleccione una opción:");
        System.out.println("1. Registrar deportistas");
        System.out.println("2. Salir");
    }


    //Metodos
    public static void registrarDeportistas(Scanner scr) {

    }
}

    // Clase abstracta Deportista con atributos private (nombre, identificacion) y getters/setters; el
    // setter del nombre rechaza valores vacíos y el de identificación rechaza valores menores a 0.
    abstract class Deportista {

        private String nombre;
        private int identificacion;

    public Deportista(String nombre, int identificacion) {
        setNombre(nombre);
        setIdentificacion(identificacion);
    }

    public String getNombre() {
        return nombre;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public void setNombre(String nombre) {
        if (nombre != null) {
            this.nombre = nombre;
        } else {
            System.out.println("Error: El nombre no puede estar vacío.");
        }
    }

    public void setIdentificacion(int identificacion) {
        if (identificacion > 0) {
            this.identificacion = identificacion;
        } else {
            System.out.println("Error: Identificación inválida.");
        }
    }

    // Métodos abstractos
    public abstract double calcularPromedio(double[] puntajes);
    public abstract void mostrarInfo();
}

    class DeportistaAficionado extends Deportista {

    public DeportistaAficionado(String nombre, int identificacion) {
        super(nombre, identificacion);
    }

    @Override
    public double calcularPromedio(double[] puntajes) {
        double suma = 0;
        for (int i = 0; i < puntajes.length; i++) {
            suma += puntajes[i];
        }
        return suma / puntajes.length;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Deportista Aficionado - Nombre: " + getNombre() + " | Identificación: " + getIdentificacion());
    }
}

    class DeportistaProfesional extends Deportista {

    public DeportistaProfesional(String nombre, int identificacion) {
        super(nombre, identificacion);
    }

    @Override
    public double calcularPromedio(double[] puntajes) {
        double suma = 0;
        for (int i = 0; i < puntajes.length; i++) {
            suma += puntajes[i];
        }
        double promedio = suma / puntajes.length;
        double promedioBonificado = promedio + 0.5;

        if (promedioBonificado > 10.0) {
            return 10.0;
        }
        return promedioBonificado;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Deportista Profesional - Nombre: " + getNombre() + " | Identificación: " + getIdentificacion());
    }
}