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
    private int antalBilletterSolgt; // Antal billetter automaten i alt har solgt
    private boolean montørtilstand = false;
    private String billetNavn;
    private int prisStandard;
    private int prisSommer;
    private int prisVinter;
    private int totalSolgt;

    /**
     * Billettyper indeholder string værdier.
     */
    /**
     * Kræver 4 argumenter, string billetNavn, int standard pris, int sommer
     * pris, int vinter pris
     */
    public Billetautomat(String billetNavn, int prisStandard, int prisSommer, int prisVinter) {
        this.billetNavn = billetNavn;
        this.prisStandard = prisStandard;
        this.prisVinter = prisVinter;
        this.prisSommer = prisSommer;
        balance = 0;
        antalBilletterSolgt = 0;
        totalSolgt = 0;

    }

    /**
     * Returnerer billetnavnet
     */
    public String getBilletNavn() {
        return billetNavn;
    }

    /**
     * Returnerer standard pris
     */
    public int getPrisStandard() {
        return prisStandard;
    }

    /**
     * Returnerer prisSommer
     */
    public int getPrisSommer() {
        return prisSommer;
    }

    /**
     * Returnerer prisVinter
     */
    public int getPrisVinter() {
        return prisVinter;
    }

    public String toString() {
        return "Billetnavn: " + billetNavn + " standardpris: " + prisStandard + " prisvinter: " + prisVinter + " prisSommer: " + prisSommer;
    }

    /**
     * Modtag nogle penge (i kroner) fra en kunde.
     */

    public void transcript(String temp) throws IOException {

        File fil = new File("transcript.txt");
        FileWriter out = null;
        if (!fil.exists()) {
            out = new FileWriter("transcript.txt");
            PrintWriter info = new PrintWriter("transcript.txt");
        } else {
            PrintWriter info = new PrintWriter("transcript.txt");

            info.println(temp);

            info.close();
        }

    }

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
     * Udskriv en billet. Opdater total og nedskriv balancen med billetprisen
     */
    public void udskrivBillet(String billetnavnprint, int billetprisprint) {
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

    public int returpenge() {
        int returbeløb = balance;
        balance = 0;
        return returbeløb;
    }

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

    public int getTotal() {
        if (montørtilstand) {
            return totalSolgt;
        } else {
            System.out.println("Afvist - log ind først");
            return 0;
        }
    }

    public int getAntalBilletterSolgt() {
        if (montørtilstand) {
            return antalBilletterSolgt;
        } else {
            System.out.println("Afvist - log ind først");
            return 0;
        }
    }

    public void setBilletpris(int billetpris) {
        this.billetpris = billetpris;
    }

    public void nulstil() {
        if (montørtilstand) {
            antalBilletterSolgt = 0;
        } else {
            System.out.println("Afvist - log ind først");
        }
    }

    public void setAntalBilletterSolgt(int antalBilletterSolgt) {
        if (montørtilstand) {
            this.antalBilletterSolgt = antalBilletterSolgt;
        } else {
            System.out.println("Afvist - log ind først");
        }
    }

    public boolean erMontør() {
        return montørtilstand;
    }

}
