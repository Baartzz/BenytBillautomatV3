/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.*;

/**
 *
 * @author Thomas Elbo
 */
public class BenytAutomat implements ActionListener{


	private Billetautomat automat;
	private GUI_master    master;

	/**
	 * @param args the command line arguments
	 */

        


	public static void main(String[] args) throws IOException {
		new BenytAutomat(new GUI_master(), new Billetautomat());
	}
	
	public BenytAutomat(GUI_master GUI, Billetautomat billetAutomat)
	{
		automat = billetAutomat;
		master  = GUI;
		
		run();
	}
	
	public void run()
	{
                
		while (true)
		{
		
		}
	}

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
        


}

