package org.vm93.biblioteca;

import lombok.Getter;

@Getter
public class Rivista extends Pubblicazione {
    private Periodic periods;

    public Rivista(String title, int year, short pages, Periodic periods) {
        super(title, year, pages);
        this.periods = periods;
    }

    @Override
    public String toString() {
        return "Rivista{" +
                "periods=" + periods +
                "} " + super.toString();
    }
}
