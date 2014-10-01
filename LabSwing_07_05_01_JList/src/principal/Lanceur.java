package principal;

import fenetres.FenetreChoix;

public class Lanceur {
	public static void main(String[] args) {
		
		String sText = "Choisir...Un choix...";
		if( args.length != 0 ){
			sText = args[0];
			new FenetreChoix(sText);
		}else
			new FenetreChoix("Fenetre de choix...");

		// ca chie...
	}

}
