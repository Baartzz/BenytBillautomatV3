/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automat;

import java.util.ArrayList;
import junit.framework.TestCase;

/**
 *
 * @author Thomas M. Elbo
 */
public class BilletautomatTest extends TestCase {

    /**
     * Test of getBilletNavn method, of class Billetautomat. Tester om navnene
     * stemmer overens med det index man indtaster.
     */
    public void testGetBilletNavn() {
        System.out.println("getBilletNavn");
        Billetautomat automat = new Billetautomat();

        automat.createTicket("Barn", 10, 14, 18);
        automat.createTicket("voksen", 14, 18, 22);
        automat.createTicket("Pensionist", 12, 16, 20);
        automat.createTicket("Cykel", 8, 10, 12);

        assertEquals("Pensionist", automat.getBilletNavn(2));

        assertEquals("Barn", automat.getBilletNavn(0));

    }

    /**
     * Test of getgetBilletForkertNavnOgIndex method, of class Billetautomat.
     * Prøver at hente en billettype der ikke findes, dermed forvents en fejl
     * her.
     */
    public void testGetBilletForkertNavnOgIndex() {
        System.out.println("getBilletForkertNavnOgIndex");
        Billetautomat automat = new Billetautomat();

        automat.createTicket("Barn", 10, 14, 18);
        automat.createTicket("voksen", 14, 18, 22);
        automat.createTicket("Pensionist", 12, 16, 20);
        automat.createTicket("Cykel", 8, 10, 12);

        assertEquals(null, automat.getBilletNavn(4));

    }

    /**
     * Test of getgetBalance method, of class Billetautomat. Tester om balancen
     * stemmer overens.
     */
    public void testGetBalance() {
        System.out.println("getBalance");
        Billetautomat automat = new Billetautomat();

        int beløb = 10;
        automat.indsætPenge(beløb);

        assertEquals(10, automat.getBalance());

    }

    /**
     * Test of getShoppingCart method, of class Billetautomat. Tester om det
     * rette antal billetter bliver tilføjet til indkøbskurven (shoppingCart).
     */
    public void testGetShoppingCart() {
        System.out.println("getShoppingCart");
        Billetautomat automat = new Billetautomat();
        int pris = 0; //pris er ligegyldig for denne opgave. 
        ArrayList<Integer> ShoppingCart = new ArrayList<Integer>();

        for (int i = 0; i <= 3; i++) {

            automat.ShoppingCartAdd(i, pris);
        }
        assertEquals(3, automat.ShoppingCartSize());

    }
}
