package org.vm93.biblioteca;

import lombok.Getter;
import org.vm93.Main;

@Getter
public class Rivista extends Pubblicazione {
    private Periodic periods;

    public Rivista(long isbn, String title, int year, short pages, Periodic periods) throws Exception {
        super(isbn, title, year, pages);
        this.periods = periods;
    }

    @Override
    public String toString() {
        return "Rivista{" +
                "title='" + getTitle() + '\'' +
                ", periods='" + getPeriods() + '\'' +
                ", year='" + getYear() + '\'' +
                ", pages='" + getPages() + '\'' +
                ", isbn='" + getIsbn() + '\'' +
                "}";
    }

    public static Rivista newRivistaByScan() throws Exception {
        System.out.println(">> Inserisci l'ISBN della rivista");
        long isbn = Main.scan.nextLong();
        Main.scan.nextLine();
        System.out.println(">> Inserisci titolo della rivista");
        String title = Main.scan.nextLine();
        System.out.println(">> Inserisci anno di pubblicazione");
        int year = Main.scan.nextInt();
        System.out.println(">> Inserisci il numero di pagine");
        short pages = Main.scan.nextShort();
        System.out.println(">> Inserisci la frequenza di pubblicazione\n 1-SETTIMANALE\t2-MENSILE\t3-SEMESTRALE");
        Periodic period = null;
        int periodscan = -1;
        do {
            periodscan = Main.scan.nextInt();
            switch (periodscan) {
                case 1:
                    period = Periodic.SETTIMANALE;
                case 2:
                    period = Periodic.MENSILE;
                case 3:
                    period = Periodic.SEMESTRALE;
                case 0:
                    System.out.println("Torno al menu principale");
                    break;
                default:
                    System.out.println("Scelta non valida, riprova");

            }
            ;
        } while (periodscan < 0 || periodscan > 3);

        System.out.println("Grazie, rivista aggiunta alla biblioteca!");
        while (true) {
            try {
                return new Rivista(isbn, title, year, pages, period);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(">> Inserisci l'ISBN del libro");
                isbn = Main.scan.nextLong();
            }
        }
    }
}
