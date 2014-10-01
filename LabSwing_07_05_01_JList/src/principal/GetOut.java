package principal;

import javax.swing.JOptionPane;

public class GetOut {
	private int iRaiponce;
	
	public GetOut(){
		Object[] options = { "Oui...! j'veux sortir!!!", "Non mais non !!" };
		iRaiponce = JOptionPane
				.showOptionDialog(
						null,
						"Etes-vous vraiiiiiment sur de vouloir quitter cette application de rêve?!",
						"Question Bête...", 
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE, 
						null,
						options,
						options[1]);
	}

	public int getiRaiponce() {
		return iRaiponce;
	}

}
