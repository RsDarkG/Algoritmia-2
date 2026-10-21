package org.example;

import java.util.Scanner;

public class GestionTorneo {
    
   static Deportista[] deportistas = new Deportista[10];
    static int[] identificaciones = new int[10];
    static double[][] puntajes = new double[10][4];
    static int contador = 0;
    
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
                    listarDeportistas();

                    break;

                case 3:
                    calcularPuntajeFinal();

                    break;

                case 4:
                    buscarDeportista(scr);

                    break;

                case 5:
                    modificarNombre(scr);

                    break;

                case 6:
                     ordenarPuntajes();

                    break;

                case 7:
                     mostrarCampeonYMenor();
                    break;
                case 8:
                     mostrarSumaPuntajes(scr);
                    break;
                    
                case 9:
                     System.out.println("Saliendo del sistema...");
                    return;

                default:
                    System.out.println("Opción aún no implementada.");
                    break;
            }
            System.out.println();

        } while (opcion != 9);
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
    // 1. REGISTRAR DEPORTISTA
    public static void registrarDeportistas(Scanner scr) {
        if (contador == 10) {
            System.out.println("No hay espacio para más deportistas.");
            return;
        }
        scr.nextLine();
    //NOMBRE
    System.out.print("Nombre: ");
        String nombre = scr.nextLine();
        while (nombre.trim().isEmpty()) {
            System.out.print("El nombre no puede estar vacío. Ingrese un nombre: ");
            nombre = scr.nextLine();
        
           }
        //IDENTIFICACION
        System.out.print("Identificación: ");
        int id = scr.nextInt();
        while (id <= 0 || buscarPosicion(id) != -1) {
            System.out.print("Identificación inválida o repetida. Intente de nuevo: ");
            id = scr.nextInt();
        
    }
         //CATEGORIA
       System.out.print("Categoría (1. Aficionado, 2. Profesional): ");
        int categoria = scr.nextInt();
        while (categoria != 1 && categoria != 2) {
            System.out.print("Categoría inválida. Digite 1 o 2: ");
            categoria = scr.nextInt();
        }
 
        //PUNTAJES
         for (int j = 0; j < 4; j++) {
            System.out.print("Puntaje de la prueba " + (j + 1) + " (0.0 - 10.0): ");
            double p = scr.nextDouble();
            while (p < 0 || p > 10) {
                System.out.print("Puntaje fuera de rango. Intente de nuevo: ");
                p = scr.nextDouble();
            }
            puntajes[contador][j] = p;
        }
 
        if (categoria == 1) {
            deportistas[contador] = new DeportistaAficionado(nombre, id);
        } else {
            deportistas[contador] = new DeportistaProfesional(nombre, id);
        }
        identificaciones[contador] = id;
        contador++;
 
        System.out.println("Deportista registrado correctamente.");
    }

    // 2. LISTAR DEPORTISTA
    public static void listarDeportistas() {
        if (contador == 0) {
            System.out.println("No hay deportistas registrados.");
            return;
        }
        for (int i = 0; i < contador; i++) {
            mostrarDatos(i);
        }
    }
 
    // 3. Calcular puntaje final 
    public static void calcularPuntajeFinal() {
        for (int i = 0; i < contador; i++) {
            System.out.println(deportistas[i].getNombre() + ": " + puntajeFinal(i));
        }
    }
 
    // 4. Buscar deportista por identificación
    public static void buscarDeportista(Scanner scr) {
        System.out.print("Identificación a buscar: ");
        int pos = buscarPosicion(scr.nextInt());
 
        if (pos == -1) {
            System.out.println("No existe un deportista con esa identificación.");
        } else {
            mostrarDatos(pos);
        }
    }
 
    // 5. Modificar el nombre de un deportista 
    public static void modificarNombre(Scanner scr) {
        System.out.print("Identificación del deportista: ");
        int pos = buscarPosicion(scr.nextInt());
 
        if (pos == -1) {
            System.out.println("No existe un deportista con esa identificación.");
            return;
        }
        scr.nextLine(); 
        System.out.print("Nuevo nombre: ");
        deportistas[pos].setNombre(scr.nextLine());
        System.out.println("Nombre actual: " + deportistas[pos].getNombre());
    }
 
    // 6. Ordenar puntajes para mostrar
    public static void ordenarPuntajes() {
        for (int i = 0; i < contador; i++) {
            ordenarBurbuja(puntajes[i]);
            mostrarDatos(i);
        }
    }
 
    // 7. Mostrar deportista con puntaje mas bajo y alto
    public static void mostrarCampeonYMenor() {
        if (contador == 0) {
            System.out.println("No hay deportistas registrados.");
            return;
        }
        int posMayor = 0;
        int posMenor = 0;
        for (int i = 1; i < contador; i++) {
            if (puntajeFinal(i) > puntajeFinal(posMayor)) {
                posMayor = i;
            }
            if (puntajeFinal(i) < puntajeFinal(posMenor)) {
                posMenor = i;
            }
        }
        System.out.println("Campeón: " + deportistas[posMayor].getNombre() + " con " + puntajeFinal(posMayor));
        System.out.println("Puntaje más bajo: " + deportistas[posMenor].getNombre() + " con " + puntajeFinal(posMenor));
    }
 
    // 8. Suma de puntajes de deportista
    public static void mostrarSumaPuntajes(Scanner scr) {
        System.out.print("Identificación del deportista: ");
        int pos = buscarPosicion(scr.nextInt());
 
        if (pos == -1) {
            System.out.println("No existe un deportista con esa identificación.");
        } else {
            mostrarSuma(pos);
        }
    }
       // Búsqueda en el vector de identificaciones
    public static int buscarPosicion(int id) {
        for (int i = 0; i < contador; i++) {
            if (identificaciones[i] == id) {
                return i;
            }
        }
        return -1;
    }
 
    // Puntaje final
    public static double puntajeFinal(int pos) {
        return deportistas[pos].calcularPromedio(puntajes[pos]);
    }
 
    // Ordenamiento burbuja de menor a mayor
    public static void ordenarBurbuja(double[] fila) {
        for (int i = 0; i < fila.length - 1; i++) {
            for (int j = 0; j < fila.length - 1 - i; j++) {
                if (fila[j] > fila[j + 1]) {
                    double aux = fila[j];
                    fila[j] = fila[j + 1];
                    fila[j + 1] = aux;
                }
            }
        }
    }
 
    // Datos de deportista
    public static void mostrarDatos(int pos) {
        deportistas[pos].mostrarInfo();
        System.out.print("   Puntajes: ");
        for (int j = 0; j < 4; j++) {
            System.out.print(puntajes[pos][j] + " ");
        }
        System.out.println();
    }
 
    // suma de puntajes
    public static void mostrarSuma(int pos) {
        double suma = 0;
        for (int j = 0; j < 4; j++) {
            suma += puntajes[pos][j];
        }
        System.out.println("Suma de puntajes de " + deportistas[pos].getNombre() + ": " + suma);
    }
}


    // Clase abstracta Deportista con atributos private (nombre, identificacion) y getters/setters; el
    // setter del nombre rechaza valores vacíos y el de identificación rechaza valores menores a 0.
    abstract class Deportista {

    private String nombre;
    private int identificacion;

    public Deportista(String nombre, int identificacion) {
        this.nombre = nombre;
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public void setNombre(String nombre) {
      if (nombre != null && nombre.length() > 0) {
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