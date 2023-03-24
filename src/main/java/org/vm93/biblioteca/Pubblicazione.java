package org.vm93.biblioteca;

import lombok.Getter;
import lombok.ToString;
import org.vm93.Main;

@Getter
@ToString
public class Pubblicazione {
    private long isbn;
    private String title;
    private int year;
    private short pages;

    public Pubblicazione(long isbn) throws Exception {
        if (!Main.checkIsbn(isbn)) {
            this.isbn = isbn;
        } else {
            throw new Exception("Il codice isbn già esiste!");
        }
    }

    public Pubblicazione(long isbn, String title, int year, short pages) throws Exception {
        this(isbn);
        this.title = title;
        this.year = year;
        this.pages = pages;
    }

}
