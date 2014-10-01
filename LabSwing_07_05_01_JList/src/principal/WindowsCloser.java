package principal;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class WindowsCloser implements WindowListener {

	
	public static int closeMsg(){
		Object[] options = { "Oui...! j'veux sortir!!!", "Non mais non !!" };
		int n = JOptionPane
				.showOptionDialog(
						null,
						"Etes-vous vraiiiiiment sur de vouloir quitter cette application de r�ve?!",
						"Question B�te...", 
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE, 
						null,
						options,
						options[1]);
		return n;
	}
	
	public WindowsCloser() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("La fenetre s'ouvre");

	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("La fenetre se ferme");
		
		if( WindowsCloser.closeMsg() == 0)
			((JFrame)e.getSource()).dispose();
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("La fenetre est ferm�e");
		//System.exit(0);
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("La fenetre est Iconifi�e");

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("La fenetre est D�Iconifi�e");

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

		System.out.println("La fenetre est Activ�e");
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("La fenetre est Desactiv�e");

	}

}
