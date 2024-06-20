package com.clase3;

import java.util.ArrayList;

public class BooleanRemove {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Backend");
        list.add(0, "Fundamentos");
        String elementos = list.get(0);
        System.out.println(elementos);
        list.set(0, "Progamacion web");
        String eliminado = list.remove(1);
        System.out.println(eliminado);
        //----------------------------------
        list.add("Pasteleria");
        boolean result = list.remove("Pasteleria");
        System.out.println(result);
        System.out.println(list);
    }
}
