package automat;

public class BenytBilletautomat {

    public static void main(String[] arg) {

        java.util.Scanner tastatur = new java.util.Scanner(System.in);  // forbered

        System.out.println("BenytBilletautomat version 3");
        System.out.println();

        boolean startup = false;
        Billetautomat automat = null;
        int beløb;

        while (!startup) {
            System.out.print("Indtast navn på den billet du vil lave, afslut med enter: ");
            String navn = " ";
            navn =tastatur.nextLine();
            
            if (navn.equals("")) {
                startup = true;
               
            } else {
            System.out.print("Indtast standard pris: ");
            int standardPris = tastatur.nextInt();
            System.out.print("Indtast sommer pris: ");
            int sommerPris = tastatur.nextInt();
            System.out.print("Indtast vinter pris: ");
            int vinterPris = tastatur.nextInt();
            automat = new Billetautomat(navn, standardPris, sommerPris, vinterPris);

            }
           

        }
        while (startup) {
            if (!automat.erMontør()) {
                System.out.println("-----------------------------------------------");
                System.out.println("En billet koster " + automat.getPrisStandard() + " kroner");
                System.out.println("Balancen er på " + automat.getBalance() + " kroner");
                System.out.println();
                System.out.println("Tast 1 for at indbetale penge");
                System.out.println("Tast 2 for at udskrive din billet");
                System.out.println("Tast 3 for at få returpengene");
                System.out.println();
                System.out.println("Tast 10 for at logge ind som montør");
            }
            int valg = tastatur.nextInt();
            tastatur.nextLine();

            switch (valg) {
                case 1:
                    System.out.print("Skriv beløb: ");
                    beløb = tastatur.nextInt();
                    while (beløb < 0) {
                        System.out.println("Beløbet skal være positivt");
                        beløb = tastatur.nextInt();
                    }
                    automat.indsætPenge(beløb);
                    break;
                case 2:
                    if (automat.getBalance() < automat.getPrisStandard()) {
                        System.out.println("Din balance er for lav, put flere penge i automaten");

                    }
                    if (automat.getBalance() >= automat.getPrisStandard()) {
                        automat.udskrivBillet();
                    }
                    break;
                case 3:
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
                                System.out.print("Skriv beløb: ");
                                beløb = tastatur.nextInt();

                                while (beløb < 0) {

                                    System.out.print("Beløbet skal være positivt eller 0, indtast et nyt beløb: ");
                                    beløb = tastatur.nextInt();
                                }
                                if (beløb >= 0) {
                                    automat.setBilletpris(beløb);
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
