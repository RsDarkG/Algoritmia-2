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
public class FUNCION4 {

    /**
     */
    
    static double area(double lado1){
        double areaCu = lado1 * lado1;
        return areaCu;
    }
    
    static double area(double base, double altura){
        double areaRe = base * altura;
        return areaRe;
    }
    
    static double area(float radio){
        return Math.PI * (radio * radio);
    }
    
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        
        System.out.println("Ingrese el valor de ambos lados del cuadrado: ");
        double lado = scr.nextDouble();
        System.out.println();
        
        System.out.println("Ingrese el valor de la base del rectangulo: ");
        double base = scr.nextDouble();
        System.out.println("Ingrese el valor de la altura del rectangulo: ");
        double altura = scr.nextDouble();
        System.out.println();
        
        System.out.println("Ingrese el radio del circulo: ");
        float radio = scr.nextFloat();
        System.out.println();
        
        
        System.out.println("El area del cuadrado es: " + area(lado));
        System.out.println();
        System.out.println("El area del rectangulo es: " + area(base, altura));
        System.out.println();
        System.out.println("El area del circulo es: " + area(radio));
        System.out.println();
        
        
        
    }
    
}
