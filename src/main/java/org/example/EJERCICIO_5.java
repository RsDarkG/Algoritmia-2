package org.example;
import java.util.Scanner;

//Ejercicio 5.  Clasificar valores respecto al promedio
//Dada una matriz de 3x4, calcular el promedio de todos sus elementos y luego recorrerla
//nuevamente para contar cuántos valores están por encima del promedio, cuántos por debajo y
//cuántos son iguales al promedio.

public class EJERCICIO_5 {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);


        int [][] matriz= new int[3][4];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.println("Introduce el valor para la posición ["+i+"]["+j+"]: ");
                matriz[i][j] = scr.nextInt();
            }
        }
        System.out.println();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.println("Valor de la posicion ["+i+"]["+j+"]: " + matriz[i][j]);
            }
        }
        System.out.println();

        int suma = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                suma += matriz[i][j];
            }
        }
        double promedio = suma / (12.0);
        int conIgual = 0, conMayor = 0, conMenor = 0;
        System.out.println("El promedio de los valores de la matriz es: " + promedio);
        System.out.println();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (matriz[i][j] == promedio) {
                    System.out.println("El valor de la posicion ["+i+"]["+j+"]: " + matriz[i][j] + " es igual al promedio: " + promedio );
                    conIgual++;
                }
                if (matriz[i][j] < promedio) {
                    System.out.println("El valor de la posicion ["+i+"]["+j+"]: " + matriz[i][j] + " es menor al promedio: " + promedio );
                    conMenor++;
                }
                if (matriz[i][j] > promedio) {
                    System.out.println("El valor de la posicion ["+i+"]["+j+"]: " + matriz[i][j] + " es mayor al promedio: " + promedio );
                    conMayor++;
                }

            }
        }
        System.out.println();

        System.out.println("Valores iguales al promedio: " + conIgual);
        System.out.println("Valores menores al promedio: " + conMenor);
        System.out.println("Valores mayores al promedio: " + conMayor);

    }
}
