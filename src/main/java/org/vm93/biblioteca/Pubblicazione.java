package org.vm93.biblioteca;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Pubblicazione {
    private long isbn;
    private String title;
    private int year;
    private short pages;

    public Pubblicazione(long isbn) {
        this.isbn = isbn;
    }

    public Pubblicazione(long isbn, String title, int year, short pages) {
        this(isbn);
        this.title = title;
        this.year = year;
        this.pages = pages;
    }

}
