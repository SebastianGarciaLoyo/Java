package com.intro;

import java.text.MessageFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int edad = 18;
        float precio = 23.5f;
        String nombre = "Juan";
        int valor = 0;
        int acum = 0;

        try (Scanner sc = new Scanner(System.in)){
            /*while (valor >= 0) {
                System.out.println("Ingrese un valor mayor a cero(0) :");
                valor = sc.nextInt();
                if (valor <0) continue;
                acum += valor;

            }*/

            System.out.println(MessageFormat.format("La suma de los numeros ingresados es = (0)", acum));
            /*System.out.println("Ingrese la edad: ");
            edad = sc.nextInt();
            sc.nextLine();
            System.out.println("Ingrese su nombre: ");
            nombre = sc.nextLine();
            sc.close();*/
        }

        /*System.out.println(nombre+" tiene "+edad+" años ");
        System.out.println(MessageFormat.format("{0} tiene {1} años",nombre,edad));*/


    }
}