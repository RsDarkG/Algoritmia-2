package org.example;

import java.util.ArrayList;

import java.util.Scanner;

public class SistemaNomina {

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        ArrayList<Empleado> listaEmpleados = new ArrayList<>();
        int opcion = 0;

        do {
            mostrarMenuInicial();
            opcion = scr.nextInt();
            System.out.println();

            switch (opcion) {
                case 1:
                    mostrarMenuRegistrar();
                    int subOpcion = scr.nextInt();
                    System.out.println();
                    scr.nextLine();

                    switch (subOpcion) {

                        //Registrar un nuevo empleado, eligiendo su tipo (Fijo, Por Horas o Gerente) e ingresando sus datos.
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

                //Mostrar el listado completo de empleados registrados, con su salario calculado (usando mostrarInfo()).
                case 2:
                if (listaEmpleados.isEmpty()){
                    System.out.println("No hay empleados registrados");

                }else{
                System.out.println("--Lista de empleados--");

                for (Empleado e : listaEmpleados){

                    e.mostrarInfo();
                    }
                }
                break;


                //Calcular y mostrar el total de la nómina (la suma del salario de TODOS los empleados registrados, sin importar
                //su tipo).
                case 3:
                System.out.println("--Total de nómina--");
                double total = 0;
                for(Empleado e : listaEmpleados){
                    total += e.calcularSalario();


                }
                System.out.println("Total de la nomina: "+ total);
                break;

                //Salir del programa de forma controlada.
                case 4:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida");


            }
        } while ( opcion != 4);

    }

        //METODOS

        //Menu registrar empleado
        public static void mostrarMenuRegistrar () {
            System.out.println("--- Tipo de empleado a registrar ---");
            System.out.println("1. Agregar empleado fijo");
            System.out.println("2. Agregar empleado por horas");
            System.out.println("3. Agregar gerente");
            System.out.println("4. Volver al menú principal");
        }
        //Menu inicial
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


    protected String nombre;
    protected double salarioBase;

    public Empleado(String nombre, double salarioBase) {
        this.nombre = nombre;
        this.salarioBase = salarioBase;
    }


    public abstract double calcularSalario();


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
