/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automat;

import junit.framework.TestCase;

/**
 *
 * @author Thomas M. Elbo
 */
public class BilletautomatTest extends TestCase {
    
    public BilletautomatTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of getBilletNavn method, of class Billetautomat.
     */
    public void testGetBilletNavn() {
        System.out.println("getBilletNavn");
        Billetautomat instance = null;
        String expResult = "";
        String result = instance.getBilletNavn();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPrisStandard method, of class Billetautomat.
     */
    public void testGetPrisStandard() {
        System.out.println("getPrisStandard");
        Billetautomat instance = null;
        int expResult = 0;
        int result = instance.getPrisStandard();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPrisSommer method, of class Billetautomat.
     */
    public void testGetPrisSommer() {
        System.out.println("getPrisSommer");
        Billetautomat instance = null;
        int expResult = 0;
        int result = instance.getPrisSommer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPrisVinter method, of class Billetautomat.
     */
    public void testGetPrisVinter() {
        System.out.println("getPrisVinter");
        Billetautomat instance = null;
        int expResult = 0;
        int result = instance.getPrisVinter();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Billetautomat.
     */
    public void testToString() {
        System.out.println("toString");
        Billetautomat instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of transcript method, of class Billetautomat.
     */
    public void testTranscript() throws Exception {
        System.out.println("transcript");
        String temp = "";
        Billetautomat instance = null;
        instance.transcript(temp);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of indsætPenge method, of class Billetautomat.
     */
    public void testIndsætPenge() {
        System.out.println("inds\u00e6tPenge");
        int beløb = 0;
        Billetautomat instance = null;
        instance.indsætPenge(beløb);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBalance method, of class Billetautomat.
     */
    public void testGetBalance() {
        System.out.println("getBalance");
        Billetautomat instance = null;
        int expResult = 0;
        int result = instance.getBalance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of udskrivBillet method, of class Billetautomat.
     */
    public void testUdskrivBillet() {
        System.out.println("udskrivBillet");
        String billetnavnprint = "";
        int billetprisprint = 0;
        Billetautomat instance = null;
        instance.udskrivBillet(billetnavnprint, billetprisprint);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of returpenge method, of class Billetautomat.
     */
    public void testReturpenge() {
        System.out.println("returpenge");
        Billetautomat instance = null;
        int expResult = 0;
        int result = instance.returpenge();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of montørLogin method, of class Billetautomat.
     */
    public void testMontørLogin() {
        System.out.println("mont\u00f8rLogin");
        String adgangskode = "";
        Billetautomat instance = null;
        instance.montørLogin(adgangskode);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTotal method, of class Billetautomat.
     */
    public void testGetTotal() {
        System.out.println("getTotal");
        Billetautomat instance = null;
        int expResult = 0;
        int result = instance.getTotal();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAntalBilletterSolgt method, of class Billetautomat.
     */
    public void testGetAntalBilletterSolgt() {
        System.out.println("getAntalBilletterSolgt");
        Billetautomat instance = null;
        int expResult = 0;
        int result = instance.getAntalBilletterSolgt();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBilletpris method, of class Billetautomat.
     */
    public void testSetBilletpris() {
        System.out.println("setBilletpris");
        int billetpris = 0;
        Billetautomat instance = null;
        instance.setBilletpris(billetpris);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of nulstil method, of class Billetautomat.
     */
    public void testNulstil() {
        System.out.println("nulstil");
        Billetautomat instance = null;
        instance.nulstil();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAntalBilletterSolgt method, of class Billetautomat.
     */
    public void testSetAntalBilletterSolgt() {
        System.out.println("setAntalBilletterSolgt");
        int antalBilletterSolgt = 0;
        Billetautomat instance = null;
        instance.setAntalBilletterSolgt(antalBilletterSolgt);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of erMontør method, of class Billetautomat.
     */
    public void testErMontør() {
        System.out.println("erMont\u00f8r");
        Billetautomat instance = null;
        boolean expResult = false;
        boolean result = instance.erMontør();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
