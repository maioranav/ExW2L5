package org.vm93;

import org.vm93.biblioteca.Libro;
import org.vm93.biblioteca.Pubblicazione;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static List<Pubblicazione> libreria = new ArrayList<>();

    public static void main(String[] args) {
        libreria.add(new Libro("Il passante", 2020, (short) 12, "Vincenzo", "Horror"));
        System.out.println(libreria.toString());
    }
}