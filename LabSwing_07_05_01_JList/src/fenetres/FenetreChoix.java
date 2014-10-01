package fenetres;

import java.awt.Dimension;
import java.awt.HeadlessException;

import javax.swing.JFrame;

import principal.WindowsCloser;
import fenetres.panels.ChoixPanel;

@SuppressWarnings("serial")
public class FenetreChoix extends JFrame {


	public FenetreChoix(String title) throws HeadlessException {
		super(title);

		add( new ChoixPanel(this) );
		
		
		
		// Taille
		int hMin = 300;
		int lMin = 400;
		setMinimumSize(new Dimension(lMin, hMin));
		setPreferredSize(new Dimension(lMin, hMin));
		
//		pack();
		
		setLocation(400, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
//		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		WindowsCloser wc = new WindowsCloser();
		this.addWindowListener(wc);
		
	}

}
