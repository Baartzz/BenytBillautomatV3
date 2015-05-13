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


    /**
     * Test of getBilletNavn method, of class Billetautomat.
     */
    public void testGetBilletNavn() {
        System.out.println("getBilletNavn");
        Billetautomat b = new Billetautomat();
        
             b.createTicket("Barn", 10, 14, 18);
          b.createTicket("voksen", 10, 14, 18);
           b.createTicket("Pensionist", 10, 14, 18);
            b.createTicket("Cykel", 10, 14, 18);
        
        
        assertEquals("Pensionist", b.getBilletNavn(2));
  
        assertEquals("Barn", b.getBilletNavn(0));
        
      
    }


    /**
     * Test of getBilletNavn method, of class Billetautomat.
     */
    public void testGetBilletNavulocliginputn() {
        System.out.println("getBilletNavn");
        Billetautomat b = new Billetautomat();
        
             b.createTicket("Barn", 10, 14, 18);
          b.createTicket("voksen", 10, 14, 18);
           b.createTicket("Pensionist", 10, 14, 18);
            b.createTicket("Cykel", 10, 14, 18);
        
        
        assertEquals(null, b.getBilletNavn(22));
  
      
    }

}
