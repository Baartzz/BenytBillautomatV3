package automat;

import java.util.ArrayList;
import java.io.*;
import java.lang.reflect.Array;

public class BenytBilletautomat {

    public static void main(String[] arg) throws IOException {

        java.util.Scanner tastatur = new java.util.Scanner(System.in);  // forbered

        System.out.println("BenytBilletautomat version 3");
        System.out.println();

        boolean startup = false;
        Billetautomat automat = new Billetautomat();

        int beløb;
        String billettypeIBrug = "Standard";

        File billettyper = new File("billettyper.txt");

        if (billettyper.exists()) {
            BufferedReader ind = new BufferedReader(new FileReader(billettyper));
            String linje = ind.readLine();

            while (linje != null) {
                String[] bidder = linje.split(" ");
                automat.createTicket(bidder[0], Integer.parseInt(bidder[1]), Integer.parseInt(bidder[2]), Integer.parseInt(bidder[3]));
                linje = ind.readLine();
            }
            startup = true;
        } else {
            FileWriter fil = new FileWriter("billettyper.txt");
            PrintWriter text = new PrintWriter(fil);
            while (!startup) {
                System.out.print("Indtast navn på den billet du vil lave, afslut med enter: ");

                String navn = tastatur.nextLine();

                if (navn.equals("")) {
                    startup = true;

                } else {
                    try {
                        System.out.print("Indtast standard pris: ");
                        int standardPris = tastatur.nextInt();
                        System.out.print("Indtast sommer pris: ");
                        int sommerPris = tastatur.nextInt();
                        System.out.print("Indtast vinter pris: ");
                        int vinterPris = tastatur.nextInt();
                        String temp = tastatur.nextLine();

                        automat.createTicket(navn, standardPris, sommerPris, vinterPris);
                        text.println(navn + " " + standardPris + " " + sommerPris + " " + vinterPris);
                    } catch (Exception u) {
                        u.getStackTrace();
                    }

                }
            }
            text.close();
        }
        double total = 0;
        while (startup) {
            if (!automat.erMontør()) {
                System.out.println("-----------------------------------------------");
                System.out.println("Der er følgende billeter til rådighed: ");
                if (billettypeIBrug.equals("Standard")) {
                    for (int i = 0; i < automat.amountOfTickets(); i++) {
                        System.out.println(automat.getBilletNavn(i) + " pris: " + automat.getPrisStandard(i));
                    }
                } else if (billettypeIBrug.equals("Sommer")) {
                    for (int i = 0; i < automat.amountOfTickets(); i++) {
                        System.out.println(automat.getBilletNavn(i) + " pris: " + automat.getPrisSommer(i));
                    }
                } else if (billettypeIBrug.equals("Vinter")) {
                    for (int i = 0; i < automat.amountOfTickets(); i++) {
                        System.out.println(automat.getBilletNavn(i) + " pris: " + automat.getPrisVinter(i));
                    }
                }
                System.out.println("Balancen er på " + automat.getBalance() + " kroner");
                if (automat.ShoppingCartSize() < 0) {
                    System.out.println("Din indkøbskurv er tom");
                }
                System.out.println();
                System.out.println("Tast 1 for at indbetale penge");
                System.out.println("Tast 2 for at vælge billetter");
                System.out.println("Tast 3 for at printe billetter ud");
                System.out.println("Tast 4 for at få penge retur");
                System.out.println();
                System.out.println("Tast 10 for at logge ind som montør");

            }
            int valg = tastatur.nextInt();

            tastatur.nextLine();

            switch (valg) {
                case 1:
                    System.out.print("Skriv beløb: ");
                    beløb = 0;
                    try {
                        beløb = tastatur.nextInt();
                    } catch (Exception u) {
                        System.out.println("Der skete en fejl, prøv igen");
                        beløb = 0;
                    }
                    while (beløb <= 0) {
                        System.out.println("Beløbet skal være positivt");
                        String temp = tastatur.nextLine();
                        beløb = tastatur.nextInt();
                    }
                    automat.indsætPenge(beløb);
                    break;
                case 2:
                    String valg2 = " ";
                    while (!valg2.equals("")) {
                        System.out.println("Hvilken billettype vil du have?");
                        automat.ContainsTickets();
                        int billetkøb = tastatur.nextInt();
                        if (billetkøb <= automat.amountOfTickets()) {
                            System.out.println("Hvor mange vil du have?");
                            int antal = tastatur.nextInt();
                            for (int i = 1; i <= antal; i++) {
                                automat.ShoppingCartAdd(billetkøb, automat.getPrisStandard(billetkøb));
                            }
                        } else {
                            System.out.println("Ikke gyldig billet");
                        }
                        automat.ShoppingCartContains();
                        System.out.println("Start forfra? Skriv y, ellers tryk enter");
                        String debug = tastatur.nextLine();
                        valg2 = tastatur.nextLine();
                        if (valg2.equals("y")) {
                            automat.ShoppingCartClear();
                            break;
                        }

                    }

                    System.out.println("Det bliver total: " + automat.ShoppingCartContainsTotal() + " kr.");

                    break;
                case 3:

                    if (automat.getBalance() < automat.ShoppingCartContainsTotal()) {
                        System.out.println("Din balance er for lav, put flere penge i automaten");

                    }

                    if (automat.getBalance() >= automat.ShoppingCartContainsTotal()) {

                        automat.printAllTickets();

                    }
                    automat.ShoppingCartClear();

                    break;

                case 4:
                    beløb = automat.returpenge();
                    System.out.println("Du fik " + beløb + " retur");
                    break;
                case 10:
                    System.out.print("Skriv kode: ");
                    String kode = tastatur.next();
                    automat.montørLogin(kode);
                    while (automat.erMontør() == true) {
                        System.out.println("Tast 11 for at se status (montør)");
                        System.out.println("Tast 12 for at nulstille (montør)");
                        System.out.println("Tast 13 for at sætte billetpris (montør)");
                        System.out.println("Tast 14 for at logge ud af montørtilstand");
                        valg = tastatur.nextInt();
                        switch (valg) {
                            case 11:
                                System.out.println("Antal billetter solgt: " + automat.getAntalBilletterSolgt());
                                System.out.println("Total indkomst: " + automat.getTotal() + " kr");
                                break;
                            case 12:
                                automat.nulstil();
                                break;
                            case 13:
                                System.out.println("Ændre billetprisen?");
                                System.out.println("Du kan vælge imellem:");
                                System.out.println("1. Standardpris");
                                System.out.println("2. Sommerpris");
                                System.out.println("3. Vinterpris");
                                System.out.println("Indtast 1-3, afslut med enter");

                                int billetvalg = tastatur.nextInt();
                                switch (billetvalg) {
                                    case 1:
                                        billettypeIBrug = "Standard";
                                        break;
                                    case 2:
                                        billettypeIBrug = "Sommer";
                                        break;
                                    case 3:
                                        billettypeIBrug = "Vinter";
                                        break;
                                    default:
                                        System.out.println("Ugyldigt valg");

                                }

                                break;
                            case 14:
                                automat.montørLogin(" ");
                                break;
                            default:
                                System.out.println("Ugyldigt valg, prøv igen");

                        }

                    }
                    break;
            }
        }

    }
}
