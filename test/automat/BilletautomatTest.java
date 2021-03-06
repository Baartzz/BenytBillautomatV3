/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automat;

import java.io.IOException;
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
    public void testGetBilletNavn() throws IOException {
        System.out.println("getBilletNavn");
        Billetautomat automat = new Billetautomat();

        assertEquals("Barn", automat.getBilletNavn(0));
        assertEquals("Pensionist", automat.getBilletNavn(2));

    }

    /**
     * Test of getgetBilletForkertNavnOgIndex method, of class Billetautomat.
     * Prøver at hente en billettype der ikke findes, dermed forvents en fejl
     * her.
     */
    public void testGetBilletForkertNavnOgIndex() throws IOException {
        System.out.println("getBilletForkertNavnOgIndex");
        Billetautomat automat = new Billetautomat();

        assertEquals(null, automat.getBilletNavn(4));
    }

    /**
     * Test of getgetBalance method, of class Billetautomat. Tester om balancen
     * stemmer overens.
     */
    public void testGetBalance() throws IOException {
        System.out.println("getBalance");
        Billetautomat automat = new Billetautomat();

        int beløb = -10;
        automat.indsætPenge(beløb);

        assertEquals(0, automat.getBalance());

    }

    /**
     * Test of getShoppingCart method, of class Billetautomat. Tester om det
     * rette antal billetter bliver tilføjet til indkøbskurven (shoppingCart).
     */
    public void testGetShoppingCart() throws IOException {
        System.out.println("getShoppingCart");
        Billetautomat automat = new Billetautomat();

        automat.loadTickets();

        for (int i = 0; i <= 3; i++) {

            automat.ShoppingCartAdd(automat.Billetter.get(i));
        }
        assertEquals(3, automat.ShoppingCartSize());

    }
}
