package org.vm93.biblioteca;

import lombok.Getter;

@Getter
public class Libro extends Pubblicazione {
    private String author;
    private String genre;

    public Libro(String title, int year, short pages, String author, String genre) {
        super(title, year, pages);
        this.author = author;
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                "} " + super.toString();
    }
}
