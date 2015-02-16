package automat;



public class BenytBilletautomat
{
	public static void main(String[] arg)
	{
		Billetautomat automat = new Billetautomat();
		java.util.Scanner tastatur = new java.util.Scanner(System.in);  // forbered

		System.out.println("BenytBilletautomat version 3");
		System.out.println();
		
		while (true) {
			System.out.println("-----------------------------------------------");
			System.out.println("En billet koster " + automat.getBilletpris() + " kroner");
			System.out.println("Balancen er på " + automat.getBalance() + " kroner");
			System.out.println();
			System.out.println("Tast 1 for at indbetale penge");
			System.out.println("Tast 2 for at udskrive din billet");
			System.out.println("Tast 3 for at få returpengene");
			System.out.println();
			System.out.println("Tast 10 for at logge ind som montør");
			if (automat.erMontør()) {
				System.out.println("Tast 11 for at se status (montør)");
				System.out.println("Tast 12 for at nulstille (montør)");
				System.out.println("Tast 13 for at sætte billetpris (montør)");
				System.out.println("Tast 14 for at logge ud af montørtilstand");
			}
			int valg = tastatur.nextInt();
			tastatur.nextLine();
		
			if (valg==1) {
				System.out.print("Skriv beløb: ");
				int beløb = tastatur.nextInt();
				automat.indsætPenge(beløb);
			}
			else if (valg==2) {
				automat.udskrivBillet();
			}
			else if (valg==3) {
				int beløb = automat.returpenge();
				System.out.println("Du fik "+beløb+" retur retur");
			}
			else if (valg==10) {
				System.out.print("Skriv kode: ");
				String kode = tastatur.next();
				automat.montørLogin(kode);
			}
			else if (valg==11) {
				System.out.println("Antal billetter solgt: " + automat.getAntalBilletterSolgt());
				System.out.println("Total indkomst: " + automat.getTotal()+" kr");
			}
			else if (valg==12) {
				automat.nulstil();
			}
			else if (valg==13) {
				System.out.print("Skriv beløb: ");
				int beløb = tastatur.nextInt();
				automat.setBilletpris(beløb);
			}
			else if (valg==14) {
				automat.montørLogin("");;
			}
			else {
				System.out.println("Ugyldigt valg, prøv igen");
			}
		}
	}
}