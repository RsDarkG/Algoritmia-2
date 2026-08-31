package org.example;
import java.util.Scanner;

//Ejercicio 3.  Suma de la diagonal principal y la diagonal secundaria
//Dada una matriz cuadrada (n x n), calcular por separado la suma de los elementos de la diagonal
//principal (donde fila == columna) y la suma de la diagonal secundaria (donde fila + columna == n -
//1).

public class EJERCICIO_3 {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        System.out.print("Introduce el tamaño (n) para la matriz cuadrada (n x n): ");
        int n = scr.nextInt();
        System.out.println();

        int [][] matriz = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println("Introduce el valor para la posición ["+i+"]["+j+"]: ");
                matriz[i][j] = scr.nextInt();
            }
        }
        System.out.println();


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println("Valor de la posicion ["+i+"]["+j+"]: " + matriz[i][j]);
            }
        }
        System.out.println();

        int sumaDiagonalPrincipal = 0;
        for (int i = 0; i < n; i++) {
            sumaDiagonalPrincipal += matriz[i][i];
        }

        int sumaDiagonalSecundaria = 0;
        for (int i = 0; i < n; i++) {
            sumaDiagonalSecundaria += matriz[i][n - 1 - i];
        }

        System.out.println("Suma de la diagonal principal: " + sumaDiagonalPrincipal);
        System.out.println("Suma de la diagonal secundaria: " + sumaDiagonalSecundaria);
    }
}
