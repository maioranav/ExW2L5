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

    public Pubblicazione() {
        this.isbn = (long) Math.floor(Math.random() * (999999999 - 111111111 + 1) + 111111111);
    }

    public Pubblicazione(String title, int year, short pages) {
        this();
        this.title = title;
        this.year = year;
        this.pages = pages;
    }

}
