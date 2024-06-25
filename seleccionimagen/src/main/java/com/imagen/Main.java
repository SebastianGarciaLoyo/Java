package com.imagen;

import javax.swing.JFileChooser;

public class Main {
    public static void main(String[] args) {
        JFileChooser j = new JFileChooser();
        try{
            j.showOpenDialog(j);

            String path = j.getSelectedFile().getAbsolutePath();
            System.out.println(path);
        } catch (Exception e){
            System.out.println("No se selecciono ningun archivo");
        }
    }
}