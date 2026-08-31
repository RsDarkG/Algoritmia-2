/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package org.example;
import java.util.Scanner;
/**
 *
 * @author INGSISTEMAS
 */
public class FUNCION1 {

    /**
     */
    
    static boolean EsMayorDeEdad(int edad){
        if (edad >= 18){
            return true;
        }
            return false;
    }
    
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        
        System.out.println("Ingrese su edad: ");
        int edad = scr.nextInt();
        System.out.println();
        
        if (EsMayorDeEdad(edad)){
            System.out.println("Usted es mayor de edad");
        }
        else {
            System.out.println("Usted es menor de edad");
        }
        
        
    }
    
}
