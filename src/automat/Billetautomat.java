package automat;

import java.util.ArrayList;
import java.io.*;

/**
 * Model af en simpel billetautomat til enkeltbilletter med én fast pris. Her
 * laves nogle ændringer
 */
public class Billetautomat {

    private int billetpris;    // Prisen for én billet.
    private int balance; // Hvor mange penge kunden p.t. har puttet i automaten
    private int årstid;
    private int KurvTotal;
    private int antalBilletterSolgt; // Antal billetter automaten i alt har solgt
    private boolean montørtilstand = false;
    private String billetNavn;
    private int totalSolgt;

    ArrayList<Billettyper> Billetter = new ArrayList<Billettyper>();
    Billettyper Billet = new Billettyper(null, 0, 0, 0);
    ArrayList<Integer> ShoppingCart = new ArrayList<Integer>();

    /**
     * Laver en Billetautomat uden argumenter og uden billetter
     */
    public Billetautomat() {
        balance = 0;
        antalBilletterSolgt = 0;
        totalSolgt = 0;

    }

    /**
     * Laver en billet i billetautomaten med navn, standard pris, sommer pris og
     * vinter pris
     *
     * @param name
     * @param pris1
     * @param pris2
     * @param pris3
     */
    public void createTicket(String name, int pris1, int pris2, int pris3) {
        Billetter.add(new Billettyper(name, pris1, pris2, pris3));
    }

    /**
     * Returnerer billetnavnet
     */
    public String getBilletNavn(int i) {
        return Billetter.get(i).getBilletNavn();
    }

    /**
     * Returnerer standard pris
     */
    public int getPrisStandard(int i) {
        return Billetter.get(i).getPrisStandard();
    }

    /**
     * Returnerer prisSommer
     */
    public int getPrisSommer(int i) {
        return Billetter.get(i).getPrisSommer();
    }

    /**
     * Returnerer prisVinter
     */
    public int getPrisVinter(int i) {
        return Billetter.get(i).getPrisVinter();
    }

    /**
     *
     * Returnerer ArrayList Billetter som string
     */
    public String toString() {
        return Billetter.toString();
    }

    /**
     * Printer hvilke type billetter billetautomaten indeholder samt deres pris.
     * Tager forbehold for hvilken årstid (pristype)
     */
    public void ContainsTickets() {
        int i = 1;
        for (Billettyper value : Billetter) {
            if (årstid == 0) {
                System.out.println(i + ". " + value.getBilletNavn() + " pris: " + value.getPrisStandard());
            }
            if (årstid == 1) {
                System.out.println(i + ". " + value.getBilletNavn() + " pris: " + value.getPrisSommer());
            }
            if (årstid == 2) {
                System.out.println(i + ". " + value.getBilletNavn() + value.getPrisVinter());
            }
            i++;
        }
    }

    /**
     *
     * Returnerer antallet af billetter
     */
    public int amountOfTickets() {
        return Billetter.size();
    }

    /**
     * Lægger en billet i indkøbskurven
     *
     * @param i
     * @param pris
     */
    public void ShoppingCartAdd(int i, int pris) {
        ShoppingCart.add(i);
        KurvTotal = KurvTotal + pris;
    }

    /**
     *
     * Returnerer den samlede pris for alle billetterne i indkøbskurven
     */
    public int ShoppingCartContainsTotal() {
        return KurvTotal;
    }

    /**
     * Tømmer indkøbskurven
     */
    public void ShoppingCartClear() {
        ShoppingCart.clear();
        KurvTotal = 0;
    }

    /**
     * Printer indkøbskurvens indhold ud som tekst
     */
    public void ShoppingCartContains() {
        for (Integer value : ShoppingCart) {
            System.out.print(getBilletNavn(value) + " | ");

        }
        System.out.println("");
    }

    /**
     *
     * Returnerer indkøbskurvens størrelse
     */
    public int ShoppingCartSize() {
        return ShoppingCart.size() - 1;
    }

    /**
     *
     * Returnerer den billet der lægger i indkøbskurven på den givne plads
     *
     */
    public int ShoppingCartItem(int i) {
        return ShoppingCart.get(i);
    }

    /**
     *
     * Indsætter et beløb i billetautomaten
     */
    public void indsætPenge(int beløb) {
        balance = balance + beløb;
    }

    /**
     * Giver balancen (beløbet maskinen har modtaget til den næste billet).
     */
    public int getBalance() {
        return balance;
    }

    /**
     * Udskriver alle billetterne, tager forbehold for årstid, kalder dernæst
     * udskrivBillet
     */
    public void printAllTickets() {
        for (Integer value : ShoppingCart) {
            if (årstid == 0) {
                udskrivBillet(getBilletNavn(value), getPrisStandard(value));
            }
            if (årstid == 1) {
                udskrivBillet(getBilletNavn(value), getPrisSommer(value));
            }
            if (årstid == 2) {
                udskrivBillet(getBilletNavn(value), getPrisVinter(value));
            }

        }
    }

    /**
     * Udskriv en billet. Opdater total og nedskriv balancen med billetprisen
     */
    private void udskrivBillet(String billetnavnprint, int billetprisprint) {
        if (balance < billetprisprint) {
            System.out.println("Du mangler at indbetale nogle penge");
        }
        System.out.println("##########B##T#########");
        System.out.println("# BlueJ Trafikselskab #");
        System.out.println("#                     #");
        System.out.println("#     " + billetnavnprint + "     #");
        System.out.println("#        " + billetprisprint + " kr.       #");
        System.out.println("#                     #");
        System.out.println("##########B##T#########");
        System.out.println("##########B##T#########");
        System.out.println();

        antalBilletterSolgt = antalBilletterSolgt + 1;
        totalSolgt = totalSolgt + billetprisprint;

        balance = balance - billetprisprint;
    }

    /**
     *
     * Returnerer returpenge og sætter balance til 0
     */
    public int returpenge() {
        int returbeløb = balance;
        balance = 0;
        return returbeløb;
    }

    /**
     *
     * Montørlogin - kræver adgangskode
     */
    void montørLogin(String adgangskode) {
        if ("1234".equals(adgangskode)) {
            montørtilstand = true;
            System.out.println("Montørtilstand aktiveret");
            System.out.println("Du kan nu angive billetpris");
        } else {
            montørtilstand = false;
            System.out.println("Montørtilstand deaktiveret");
        }
    }

    /**
     *
     * Returnerer den totale værdi solgt for i kr.
     */
    public int getTotal() {
        if (montørtilstand) {
            return totalSolgt;
        } else {
            System.out.println("Afvist - log ind først");
            return 0;
        }
    }

    /**
     *
     * Returnerer antal billetter solgt
     */
    public int getAntalBilletterSolgt() {
        if (montørtilstand) {
            return antalBilletterSolgt;
        } else {
            System.out.println("Afvist - log ind først");
            return 0;
        }
    }

    /**
     * Nulstiller billetautomaten
     */
    public void nulstil() {
        if (montørtilstand) {
            antalBilletterSolgt = 0;
            totalSolgt = 0;
        } else {
            System.out.println("Afvist - log ind først");
        }
    }

    /**
     * Sætter årstid Kræver integer
     */
    public void setÅrstid(int i) {
        årstid = i;
    }

    /**
     * Returnerer årstid
     *
     */
    public int årstid() {
        return årstid;
    }

    /**
     * Returnerer om montørtilstand er aktiv eller ej
     *
     */
    public boolean erMontør() {
        return montørtilstand;
    }

}
