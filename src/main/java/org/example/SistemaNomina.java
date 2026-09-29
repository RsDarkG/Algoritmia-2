package org.example;

import java.util.ArrayList;

import java.util.Scanner;

public class SistemaNomina {

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        ArrayList<Empleado> listaEmpleados = new ArrayList<>();

        do {
            mostrarMenuInicial();
            int opcion = scr.nextInt();
            System.out.println();

            switch (opcion) {
                case 1:
                    mostrarMenuRegistrar();
                    int subOpcion = scr.nextInt();
                    System.out.println();
                    scr.nextLine();

                    switch (subOpcion) {
                        case 1:
                            System.out.println("--- Agregar Empleado Fijo ---");
                            System.out.print("Ingrese el nombre: ");
                            String nombreFijo = scr.nextLine();
                            System.out.print("Ingrese el salario base: ");
                            double salarioBaseFijo = scr.nextDouble();
                            System.out.print("Ingrese el bono: ");
                            double bonoFijo = scr.nextDouble();
                            scr.nextLine();

                            listaEmpleados.add(new EmpleadoFijo(nombreFijo, salarioBaseFijo, bonoFijo));
                            System.out.println("Empleado fijo agregado con éxito.");
                            break;

                        case 2:
                            System.out.println("--- Agregar Empleado Por Horas ---");
                            System.out.print("Ingrese el nombre: ");
                            String nombreHoras = scr.nextLine();
                            System.out.print("Ingrese las horas trabajadas: ");
                            double horasTrabajadas = scr.nextDouble();
                            System.out.print("Ingrese el valor por hora: ");
                            double valorHora = scr.nextDouble();
                            scr.nextLine();

                            listaEmpleados.add(new EmpleadoPorHoras(nombreHoras, 0, horasTrabajadas, valorHora));
                            System.out.println("Empleado por horas agregado con éxito.");
                            break;

                            break;
                        case 3:
                            System.out.println("--- Agregar Gerente ---");
                            System.out.print("Ingrese el nombre: ");
                            String nombreGerente = scr.nextLine();
                            System.out.print("Ingrese el salario base: ");
                            double salarioBaseGerente = scr.nextDouble();
                            System.out.print("Ingrese el bono regular: ");
                            double bonoGerente = scr.nextDouble();
                            System.out.print("Ingrese el bono gerencial: ");
                            double bonoGerencial = scr.nextDouble();
                            scr.nextLine();

                            listaEmpleados.add(new Gerente(nombreGerente, salarioBaseGerente, bonoGerente, bonoGerencial));
                            System.out.println("Gerente agregado con éxito.");
                            break;
                        case 4:
                            System.out.println("Regresando al menú principal...");
                            break;
                        default:
                            System.out.println("Opción inválida");
                    }
                    break;
                case 2:


            }
        } while (opcion != 4);
        scr.close();
    }

        //METODOS

        //Menu inicial
        public static void mostrarMenuRegistrar () {
            System.out.println("1. Agregar empleado fijo");
            System.out.println("2. Lista de empleados");
            System.out.println("3. Total de nomina");
            System.out.println("4. Salir");
        }

        public static void mostrarMenuInicial () {
            System.out.println("1. Registrar empleado");
            System.out.println("2. Ver lista de empleados");
            System.out.println("3. Ver total de nómina");
            System.out.println("4. Salir");
        }

    }

    //CLASES

    //Empleado (clase ABSTRACTA): atributos protected (nombre, salarioBase). Constructor. Método abstracto
    //calcularSalario(). Método concreto mostrarInfo() que use calcularSalario().
    abstract class Empleado {

    // las subclases acceden a protected
    protected String nombre;
    protected double salarioBase;

    public Empleado(String nombre, double salarioBase) {
        this.nombre = nombre;
        this.salarioBase = salarioBase;
    }

    // cada subclase define su formula
    public abstract double calcularSalario();

    // java define cual usar
    public void mostrarInfo() {
        System.out.println("Nombre: " + nombre + ", Salario: " + calcularSalario());
    }
    }

    //EmpleadoFijo (extends Empleado): agrega un atributo bono. Su constructor usa super(...). Sobrescribe
    //calcularSalario() = salarioBase + bono.
    class EmpleadoFijo extends Empleado {

    protected double bono;

    public EmpleadoFijo(String nombre, double salarioBase, double bono) {
        super(nombre, salarioBase);
        this.bono = bono;
    }

    @Override
    public double calcularSalario() {
        return salarioBase + bono;
        }
    }


    //EmpleadoPorHoras (extends Empleado): agrega horasTrabajadas y valorHora. Su constructor usa super(...).
    //Sobrescribe calcularSalario() = horasTrabajadas * valorHora.
    class EmpleadoPorHoras extends Empleado {

    protected double horasTrabajadas;
    protected double valorHora;

    public EmpleadoPorHoras(String nombre, double salarioBase, double horasTrabajadas, double valorHora) {
        super(nombre, salarioBase);
        this.horasTrabajadas = horasTrabajadas;
        this.valorHora = valorHora;
    }

    @Override
    public double calcularSalario() {
        return horasTrabajadas * valorHora;
        }
    }

    //Gerente (extends EmpleadoFijo): agrega un atributo bonoGerencial. Sobrescribe calcularSalario(), reutilizando
    //el cálculo del padre con super.calcularSalario() y sumándole el bonoGerencial (herencia de dos niveles).
    class Gerente extends EmpleadoFijo {

    protected double bonoGerencial;

    public Gerente(String nombre, double salarioBase, double bono, double bonoGerencial) {
        super(nombre, salarioBase, bono);
        this.bonoGerencial = bonoGerencial;
    }

    @Override
    public double calcularSalario() {
        return super.calcularSalario() + bonoGerencial;
        }
    }
