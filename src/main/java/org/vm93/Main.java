package org.vm93;

import org.vm93.biblioteca.Libro;
import org.vm93.biblioteca.Periodic;
import org.vm93.biblioteca.Pubblicazione;
import org.vm93.biblioteca.Rivista;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static Scanner scan = new Scanner(System.in);

    private static List<Pubblicazione> libreria = new ArrayList<>();

    public static void main(String[] args) {
        libreria.add(new Libro("Il passante", 2020, (short) 12, "Vincenzo", "Horror"));
        libreria.add(new Rivista("Gesu è risorto", 2023, (short) 32, Periodic.SETTIMANALE));
        System.out.println(libreria.toString());

        System.out.println("\n** BIBLIOTECA DI VINCENZO **");

        while (true) {
            System.out.println("=> SCEGLI COSA FARE:\n");
            System.out.println("\t 1 - AGGIUNGI UN LIBRO");
            System.out.println("\t 2 - RIMUOVI UN LIBRO TRAMITE IL SUO ISBN");
            System.out.println("\t 3 - RICERCA PER ANNO DI PUBBLICAZIONE");
            System.out.println("\t 4 - RICERCA PER AUTORE");
            System.out.println("\t 5 - MOSTRA TUTTO");
            System.out.println("\t 0 - ESCI");

            switch (scan.nextInt()) {
                case 1:
                    System.out.println("\n\tCosa vuoi aggiungere?\n\t 1-LIBRO\t2-RIVISTA");
                    switch (scan.nextInt()) {
                        case 1:
                            System.out.println("=> INSERIAMO UN LIBRO");
                            scan.nextLine();
                            libreria.add(Libro.newBookByScan());
                            continue;
                        case 2:
                            System.out.println("=> INSERIAMO UNA RIVISTA");
                            continue;
                        default:
                            System.out.println("Scelta non valida, riprova \n");
                            continue;
                    }
                case 5:
                    System.out.println("\n\t >> MOSTRO TUTTI I LIBRI IN LIBRERIA");
                    System.out.println(libreria.toString());
                    break;
                case 0:
                    System.out.println("\nQuesto programma è stato sviluppato da Vincenzo Maiorana");
                    System.out.println("\nPer ulteriori informazioni visita https://www.vincenzomaiorana.it");
                    System.out.println("\nArrivederci! <3");
                    System.exit(1);
                default:
                    System.out.println("Scelta non valida, riprova \n");
                    break;

            }


        }

    }


}