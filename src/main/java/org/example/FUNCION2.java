/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package alg.pkg2;

import java.util.Scanner;

/**
 *
 * @author INGSISTEMAS
 */
public class FUNCION2 {

    /**
     * @param args the command line arguments
     */
    
    
    
    static void mostrarTabla(int a){
        for (int i = 0; i < 11; i++) {
            int multiplicacion = 0;
            multiplicacion = a*i;
            System.out.println(a + " * ["+i+"] = " + multiplicacion);
        }
    }
    
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        
        System.out.println("Ingrese el numero a mostrar su tabla de multiplicar: ");
        int num1 = scr.nextInt();
        System.out.println();
        
        mostrarTabla(num1);
        
        
    }
    
}
