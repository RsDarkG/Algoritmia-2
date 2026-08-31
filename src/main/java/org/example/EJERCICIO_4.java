/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example;

import java.util.Scanner;

//Ejercicio 4.  Comparar si dos matrices son iguales
//Dadas dos matrices del mismo tamaño, determinar si son exactamente iguales (mismo valor en
//cada posición correspondiente). Si encuentras una sola diferencia, el programa debe indicar en qué
//posición ocurrió.

/**
 *
 * @author ltluc
 */
public class EJERCICIO_4 {
           public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        System.out.print("Ingrese el numero de filas: ");
        int n = sc.nextInt();
        System.out.print("Ingrese el numero de columnas: ");
        int m = sc.nextInt();
 
        int[][] matrizA = new int[n][m];
        int[][] matrizB = new int[n][m];
 
        System.out.println("Ingrese los elementos de la matriz A:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print("A[" + i + "][" + j + "]: ");
                matrizA[i][j] = sc.nextInt();
            }
        }
 
        System.out.println("Ingrese los elementos de la matriz B:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print("B[" + i + "][" + j + "]: ");
                matrizB[i][j] = sc.nextInt();
            }
        }
 
        boolean sonIguales = true;
 
        for (int i = 0; i < n && sonIguales; i++) {
            for (int j = 0; j < m && sonIguales; j++) {
                if (matrizA[i][j] != matrizB[i][j]) {
                    sonIguales = false;
                    System.out.println("Las matrices no son iguales.");
                    System.out.println("Primera diferencia en la posicion [" + i + "][" + j + "]:");
                    System.out.println("A[" + i + "][" + j + "] = " + matrizA[i][j]);
                    System.out.println("B[" + i + "][" + j + "] = " + matrizB[i][j]);
            }
          }
        }
 
        if (sonIguales) {
            System.out.println("\nLas matrices son exactamente iguales.");
          }
      }
   }