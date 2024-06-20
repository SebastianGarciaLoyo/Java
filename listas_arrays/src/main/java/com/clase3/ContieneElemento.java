package com.clase3;

import java.util.ArrayList;

public class ContieneElemento {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Backend");
        //---------------------------------------
        list.add(0, "Fundamentos");
        //---------------------------------------
        System.out.println(list);
    }
}
