/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automat;

/**
 *
 * @author Thomas
 */
public class Billettyper {
    private String billetNavn;
    private int pris;
    private int prisSommer;
    private int prisVinter;
    
    public Billettyper(int pris, int prisSommer, int prisVinter, String billetNavn){
        this.billetNavn = billetNavn;
        this.pris = pris;
        this.prisVinter = prisVinter;
        this.prisSommer = prisSommer;
    }
    
    public String toString(){
        return "Billetnavn: " + billetNavn + " standardpris: " + pris + " prisvinter: " + prisVinter + " prisSommer: " + prisSommer;
    }
    
    public String getBilletnavn(){
        return billetNavn;
    }
    
    public int getPrisSommer(){
        return prisSommer;
    }
    public int getPrisVinter(){
        return prisVinter;
    }
}
