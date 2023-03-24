package org.vm93.biblioteca;

import lombok.Getter;
import org.vm93.Main;

@Getter
public class Libro extends Pubblicazione {
    private String author;
    private String genre;

    public Libro(long isbn, String title, int year, short pages, String author, String genre) throws Exception {
        super(isbn, title, year, pages);
        this.author = author;
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "author='" + author + '\'' +
                ", title='" + getTitle() + '\'' +
                ", year='" + getYear() + '\'' +
                ", genre='" + genre + '\'' +
                ", pages='" + getPages() + '\'' +
                ", isbn='" + getIsbn() + '\'' +
                "}";
    }

    public static Libro newBookByScan() {
        System.out.println(">> Inserisci l'ISBN del libro");
        long isbn = Main.scan.nextLong();
        Main.scan.nextLine();
        System.out.println(">> Inserisci titolo del libro");
        String title = Main.scan.nextLine();
        System.out.println(">> Inserisci anno di pubblicazione");
        int year = Main.scan.nextInt();
        System.out.println(">> Inserisci il numero di pagine");
        short pages = Main.scan.nextShort();
        Main.scan.nextLine();
        System.out.println(">> Inserisci il nome dell'autore");
        String author = Main.scan.nextLine();
        System.out.println(">> Inserisci il genere del libro");
        String genre = Main.scan.nextLine();
        System.out.println("Grazie, libro aggiunto alla biblioteca!");
        while (true) {
            try {
                return new Libro(isbn, title, year, pages, author, genre);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(">> Inserisci l'ISBN del libro");
                isbn = Main.scan.nextLong();
            }
        }
    }

}
