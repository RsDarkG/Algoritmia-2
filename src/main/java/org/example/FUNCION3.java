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
public class FUNCION3 {

    /**
     * @param args the command line arguments
     */
    
    
    static long funcionFactorial(int a){
        long factorial = 1;
        
        for (int i = 1; i <= a; i++) {
            factorial = factorial * i;
        }
        
        return factorial;
    }
    
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        
        System.out.println("Ingrese su numero para devolverle su factorial: ");
        int num1 = scr.nextInt();
        System.out.println();
        
        long resultado = funcionFactorial(num1);
        
        System.out.println("El factorial de " + num1 + " es " + resultado);
       
        
        
    }
    
}
