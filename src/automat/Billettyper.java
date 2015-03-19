/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automat;

/**
 *
 * @author Thomas M. Elbo
 */
public class Billettyper {
    
    private String billetNavn;
    private int prisStandard;
    private int prisSommer;
    private int prisVinter;
    
    public Billettyper(String navn, int pris1, int pris2, int pris3){
        this.billetNavn = navn;
        this.prisStandard = pris1;
        this.prisSommer = pris2;
        this.prisVinter = pris3;
    }
    
    public String getBilletNavn() {
        return billetNavn;
    }
    
    public int getPrisStandard(){
        return prisStandard;
    }
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
    
    
}
