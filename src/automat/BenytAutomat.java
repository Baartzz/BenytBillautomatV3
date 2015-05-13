/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automat;

import javax.swing.*;

/**
 *
 * @author Thomas Elbo
 */
public class BenytAutomat{


	private Billetautomat automat;
	private GUI_master    master;

	/**
	 * @param args the command line arguments
	 */




	public static void main(String[] args) {
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
            master.setIndex(2);
		while (true)
		{
			
		}
	}


}

