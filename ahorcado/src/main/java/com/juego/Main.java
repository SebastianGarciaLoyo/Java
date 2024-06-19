package com.juego;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        int opcion = JOptionPane.showConfirmDialog(null, "¿Quieres Jugar?", "Ahorcado", JOptionPane.YES_NO_OPTION);
        
        if (opcion == JOptionPane.YES_OPTION) {
            jugarAhorcado();
        } else {
            JOptionPane.showMessageDialog(null, "Quizás en otro momento.");
        }
    }
    
    static void jugarAhorcado() {
        String palabraSecreta = getPalabraSecreta();
        char[] palabrasGuiones = getGuionesPalabra(palabraSecreta);
        boolean gameFinish = false;
        Scanner lector = new Scanner(System.in);
        int vidas = 3;
        ArrayList<Character> letrasUtilizadas = new ArrayList<>(); 

        do {
            System.out.println("Te quedan " + vidas + " vidas");
            System.out.println(String.valueOf(palabrasGuiones));
            System.out.println("Introduzca una letra por favor:");
            char letra = lector.next().toLowerCase().charAt(0); 
          
            
            if (letrasUtilizadas.contains(letra)) {
                System.out.println("Ya has utilizado esta letra. Introduce otra letra.");
                continue; 
            }
            
            letrasUtilizadas.add(letra); 
            
            boolean letraAcertada = false;
            
            for (int i = 0; i < palabraSecreta.length(); i++) {
                if (palabraSecreta.charAt(i) == letra) {
                    palabrasGuiones[i] = letra;
                    letraAcertada = true;
                }
            }
            
            if (!letraAcertada) {
                System.out.println("Letra Incorrecta");
                vidas--;
                if (vidas == 0) {
                    System.out.println("Perdiste :(");
                    gameFinish = true;
                }
            } else {
                boolean victoria = !sihayGuiones(palabrasGuiones);
                if (victoria) {
                    System.out.println("Ganaste :D!");
                    gameFinish = true;
                }
            }

        } while (!gameFinish);
        
        lector.close();
    }

    static String getPalabraSecreta() {
        String[] palabras = {"mateo", "hogar", "perro"};
        Random r = new Random();
        int n = r.nextInt(palabras.length);
        return palabras[n];
    }

    static char[] getGuionesPalabra(String palabra) {
        int nLetrasPalabraSecreta = palabra.length();
        char[] palabrasGuiones = new char[nLetrasPalabraSecreta];

        for (int i = 0; i < palabrasGuiones.length; i++) {
            palabrasGuiones[i] = '_';
        }
        return palabrasGuiones;
    }

    static boolean sihayGuiones(char[] array) {
        for (char l : array) {
            if (l == '_')
                return true;
        }
        return false;
    }
}
