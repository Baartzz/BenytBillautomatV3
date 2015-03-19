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
    private int KurvTotal;
    private int antalBilletterSolgt; // Antal billetter automaten i alt har solgt
    private boolean montørtilstand = false;
    private String billetNavn;
    private int prisStandard;
    private int prisSommer;
    private int prisVinter;
    private int totalSolgt;
    ArrayList<Billettyper> Billetter = new ArrayList<Billettyper>();
    Billettyper Billet = new Billettyper(null, 0,0,0);
    ArrayList<Integer> ShoppingCart = new ArrayList<Integer>();
  

    /**
     * Billettyper indeholder string værdier.
     */
    /**
     * Kræver 4 argumenter, string billetNavn, int standard pris, int sommer
     * pris, int vinter pris
     */
    public Billetautomat() {
        balance = 0;
        antalBilletterSolgt = 0;
        totalSolgt = 0;
        
    }
    public void createTicket(String name, int pris1, int pris2, int pris3){
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
    public String toString() {
        return Billetter.toString();
    }
    public void ContainsTickets(){
        for (Billettyper billetnavn :  Billetter){
        System.out.println(billetnavn);
       }
    }
    public int amountOfTickets(){
        return Billetter.size();
    }
    /**
     * Modtag nogle penge (i kroner) fra en kunde.
     */

    public void ShoppingCartAdd(int i, int pris){
        ShoppingCart.add(i);
        KurvTotal = KurvTotal + pris;
}
    public int ShoppingCartContainsTotal(){
        return KurvTotal;
    }
    public void ShoppingCartClear(){
        ShoppingCart.clear();
        KurvTotal = 0;
    }
    public void ShoppingCartContains(){
        for(Integer value: ShoppingCart){
            System.out.print(getBilletNavn(value) + " | ");
            
        }
        System.out.println("");
    }
    public int ShoppingCartSize(){
        return ShoppingCart.size()-1;
    }
    public int ShoppingCartItem(int i){
        return ShoppingCart.get(i);
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

    
    public void printAllTickets(){
       for (Integer value : ShoppingCart){
        udskrivBillet(getBilletNavn(value), getPrisStandard(value));
       }
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
