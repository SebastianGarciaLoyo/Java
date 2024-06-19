package com.juego;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String palabraSecreta = getPalabraSecreta();
        char [] palabrasGuiones = getGuionesPalabra(palabraSecreta);
        boolean GameFinish = false;
        Scanner lector = new Scanner(System.in);
        int vidas = 3;
        
        
        do {
            System.out.println("Te quedan " + vidas + " vidas");
            System.out.println(palabrasGuiones);
            System.out.println("Introduzca una letra por favor:");
            char letra = lector.next().charAt(0);
            boolean letraAcertada = false;
            for(int i=0; i< palabraSecreta.length(); i++){
                if(palabraSecreta.charAt(i) == letra) {
                    palabrasGuiones[i] = letra;
                    letraAcertada = true;
                }
                
            }
            if (!letraAcertada) {
                System.out.println("Letra Incorrecta");
                vidas--;
                if (vidas == 0) {
                    System.out.println("Perdiste :(");
                    GameFinish = true;
                }
            } else {
                boolean Victoria = !sihayGuiones(palabrasGuiones);
                if (Victoria) {
                    System.out.println("Ganaste :D!");
                    GameFinish = true;
                }
            }
            
        }while(!GameFinish);
        lector.close();
    }



    static String getPalabraSecreta() {
        String [] palabras = {"mateo", "hogar", "perro"};
        Random r = new Random();
        int n = r.nextInt(palabras.length);
        return palabras[n];
    }

    static char[] getGuionesPalabra(String palabra) {
        int nLetrasPalabrasSecreta = palabra.length();

        char [] palabrasGuiones = new char[nLetrasPalabrasSecreta];

        for(int i=0; i<palabrasGuiones.length; i++) {
            palabrasGuiones[i] = '_';
        }
        return palabrasGuiones;
    }

    static boolean sihayGuiones(char[] array){
        for(char l:array){
            if(l== '_') return true;
        }
        return false;
    }
}
