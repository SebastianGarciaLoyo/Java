package com.clase3;

import java.util.ArrayList;

public class RemplazarElemento {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Backend");
        list.add(0, "Fundamentos");
        String elemento = list.get(0);
        System.out.println(elemento);
        //-------------------------------------------
        list.set(0, "Progamacion web");
        //-------------------------------------------
        System.out.println(list);
    }
}
