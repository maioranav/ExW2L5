package org.vm93;

import org.apache.commons.io.FileUtils;
import org.vm93.biblioteca.Libro;
import org.vm93.biblioteca.Periodic;
import org.vm93.biblioteca.Pubblicazione;
import org.vm93.biblioteca.Rivista;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static Scanner scan = new Scanner(System.in);

    private static List<Pubblicazione> libreria = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        System.out.println("\n** BIBLIOTECA DI VINCENZO **");

        while (true) {
            System.out.println("=> SCEGLI COSA FARE:\n");
            System.out.println("\t 1 - AGGIUNGI UNA PUBBLICAZIONE");
            System.out.println("\t 2 - RIMUOVI UNA PUBBLICAZIONE TRAMITE IL SUO ISBN");
            System.out.println("\t 3 - RICERCA PER ANNO DI PUBBLICAZIONE");
            System.out.println("\t 4 - RICERCA PER AUTORE");
            System.out.println("\t 5 - MOSTRA TUTTO");
            System.out.println("\t 6 - BACKUP E RIPRISTINO");
            System.out.println("\t 0 - ESCI");

            switch (scan.nextInt()) {
                case 1 -> {
                    System.out.println("\n\tCosa vuoi aggiungere?\n\t 1-LIBRO\t2-RIVISTA");
                    switch (scan.nextInt()) {
                        case 1 -> {
                            System.out.println("=> INSERIAMO UN LIBRO");
                            scan.nextLine();
                            libreria.add(Libro.newBookByScan());
                        }
                        case 2 -> {
                            System.out.println("=> INSERIAMO UNA RIVISTA");
                            scan.nextLine();
                            libreria.add(Rivista.newRivistaByScan());
                        }
                        default -> {
                            System.out.println("Scelta non valida, riprova \n");
                        }
                    }
                }
                case 2 -> {
                    System.out.print("\n\t >> INSERISCI ISBN DA ELIMINARE: ");
                    scan.nextLine();
                    long isbn = scan.nextLong();
                    Boolean match = libreria.stream().anyMatch(n -> n.getIsbn() == isbn);
                    if (match) {
                        System.out.println("\n\tElimino il risultato per l'ISBN inserito.");
                    } else {
                        System.out.println("\n\tNessuna corrispondenza soddisfa la ricerca.");
                    }
                }
                case 3 -> {
                    System.out.print("\n\t >> RICERCA PER ANNO: ");
                    int anno = scan.nextInt();
                    scan.nextLine();
                    System.out.print("\n");
                    libreria.stream().filter(n -> n.getYear() == anno).forEach(el -> System.out.println(el.toString()));
                    System.out.print("\n");
                }
                case 4 -> {
                    System.out.print("\n\t >> RICERCA PER AUTORE: ");
                    scan.nextLine();
                    String autore = scan.nextLine();
                    System.out.print("\n");
                    libreria.stream().filter(n -> n instanceof Libro).filter(libro -> ((Libro) libro).getAuthor().toLowerCase().contains(autore.toLowerCase())).forEach(el -> System.out.println(el.toString()));
                    System.out.print("\n");
                }
                case 5 -> {
                    System.out.println("\n\t >> MOSTRO TUTTI I LIBRI IN LIBRERIA");
                    libreria.stream().forEach(el -> System.out.println(el.toString()));
                    System.out.println("\t> Totale pubblicazioni diponibili: " + libreria.size() + "\n");
                }
                case 6 -> {
                    System.out.println("\n\tBACKUP E RIPRISTINO\n\t 1-SALVA\t2-RIPRISTINA");
                    switch (scan.nextInt()) {
                        case 1 -> {
                            System.out.println("=> INSERIAMO NOME DEL FILE");
                            scan.nextLine();
                            String nomefile = scan.nextLine();
                            File f = new File(nomefile);
                            try {
                                FileUtils.writeStringToFile(f, libreria.toString(), "UTF-8");
                                System.out.println("\n-> Ho scritto i valori sul file" + f);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        case 2 -> {
                            System.out.println("=> INSERIAMO NOME DEL FILE");
                            scan.nextLine();
                            String nomefile = scan.nextLine();
                            readFromFile(nomefile);
                        }
                        default -> {
                            System.out.println("Scelta non valida, riprova \n");
                        }
                    }
                }
                case 0 -> {
                    System.out.println("\nQuesto programma è stato sviluppato da Vincenzo Maiorana");
                    System.out.println("\nPer ulteriori informazioni visita https://www.vincenzomaiorana.it");
                    System.out.println("\nArrivederci! <3");
                    System.exit(1);
                }
                default -> System.out.println("Scelta non valida, riprova \n");
            }


        }

    }

    public static void readFromFile(String filename) {

        try {
            // Crea un oggetto BufferedReader per leggere il file
            File file = new File(filename);
            String input = FileUtils.readFileToString(file, "UTF-8");
            input = input.substring(1, input.length() - 1).replaceAll("}, ", "}; ");


            //MANIPOLO IL FILE
            String[] items = input.split("; ");

            for (String item : items) {
                String[] attributes = item.split("\\{")[1].split("\\}")[0].split(", ");
                String type = item.split("\\{")[0];
                switch (type) {
                    case "Libro":
                        String author = attributes[0].split("=")[1].replaceAll("'", "");
                        String title = attributes[1].split("=")[1].replaceAll("'", "");
                        int year = Integer.parseInt(attributes[2].split("=")[1].replaceAll("'", ""));
                        String genre = attributes[3].split("=")[1].replaceAll("'", "");
                        short pages = Short.parseShort(attributes[4].split("=")[1].replaceAll("'", ""));
                        long isbn = Long.parseLong(attributes[5].split("=")[1].replaceAll("'", ""));
                        libreria.add(new Libro(isbn, title, year, pages, author, genre));
                        break;
                    case "Rivista":
                        title = attributes[0].split("=")[1].replaceAll("'", "");
                        Periodic periods = Periodic.valueOf(attributes[1].split("=")[1].replaceAll("'", ""));
                        year = Integer.parseInt(attributes[2].split("=")[1].replaceAll("'", ""));
                        pages = Short.parseShort(attributes[3].split("=")[1].replaceAll("'", ""));
                        isbn = Long.parseLong(attributes[4].split("=")[1].replaceAll("'", ""));
                        libreria.add(new Rivista(isbn, title, year, pages, periods));
                        break;
                    default:
                        System.out.println("Tipo non supportato");
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("File non trovato!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public static boolean checkIsbn(long isbn) {
        return libreria.stream().anyMatch(n -> n.getIsbn() == isbn);
    }

}