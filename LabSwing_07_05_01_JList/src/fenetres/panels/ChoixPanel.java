package fenetres.panels;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import principal.WindowsCloser;

@SuppressWarnings("serial")
public class ChoixPanel extends JPanel implements ActionListener {

	private JButton btOK = new JButton("Ok");
	private JButton btAnnnuler = new JButton("Annuler");
	private JButton btAdd = new JButton(">");
	private JButton btDel = new JButton("<");

	private JLabel lblVal = new JLabel("Valeurs :");
	private JLabel lblCho = new JLabel("Choix :");

	private DefaultListModel<String> listModVal = new DefaultListModel<String>();
	private DefaultListModel<String> listModCho = new DefaultListModel<String>();
	private JList<String> liVal;
	private JList<String> liCho;

	private JFrame frame;

	// private JList

	public ChoixPanel(JFrame frame) {
		this.frame = frame;

		setLayout(new GridBagLayout());

		// // Création des items
		String[] alString = new String[] { "Paris", "Londres", "Berlin",
				"Rome", "Madrid", "Bruxelles", "New York", "Ottawa", "Tokyo",
				"Dublin", "Dublin", "Dublin", "Dublin", "Dublin" };

		for (int i = 0; i < alString.length; i++)
			listModVal.addElement(alString[i]);

		liVal = new JList<>(listModVal);
		liCho = new JList<>(listModCho);

		JScrollPane spVal = new JScrollPane(liVal);
		JScrollPane spCho = new JScrollPane(liCho);

		// // Les Listeners
		btOK.setActionCommand("OK");
		btAnnnuler.setActionCommand("ANNULER");
		btAdd.setActionCommand("ADD");
		btDel.setActionCommand("DEL");
		btOK.addActionListener(this);
		btAnnnuler.addActionListener(this);
		btAdd.addActionListener(this);
		btDel.addActionListener(this);

		// // Placement des items
		// GridBagConstraints gbc = new GridBagConstraints(gridx, gridy,
		// gridwidth, gridheight, weightx, weighty, anchor, fill, insets, ipadx,
		// ipady)
		GridBagConstraints gbc = new GridBagConstraints();

		// Lbl "Valeurs"
		Insets insets = new Insets(0, 2, 2, 0);
		gbc.insets = insets;

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		gbc.weightx = 1;
		gbc.weighty = 0;
		gbc.anchor = GridBagConstraints.WEST;
		add(lblVal, gbc);

		// Lbl "Choix"
		gbc.gridx = 3;
		add(lblCho, gbc);

		// List Valeur
		gbc = new GridBagConstraints();
		insets = new Insets(0, 2, 0, 0);
		gbc.insets = insets;

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		gbc.gridheight = 2;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.fill = GridBagConstraints.BOTH;
		add(spVal, gbc);
		// add(liVal, gbc);

		// List Choix
		gbc.gridx = 3;
		add(spCho, gbc);
		// add(liCho, gbc);

		// Bouton >
		gbc = new GridBagConstraints();
		insets = new Insets(5, 5, 5, 5);
		gbc.insets = insets;

		gbc.gridx = 2;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 0;
		gbc.weighty = 1;
		gbc.anchor = GridBagConstraints.SOUTH;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		add(btAdd, gbc);

		// Bouton <
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.NORTH;
		add(btDel, gbc);

		// Boutons Annuler/OK
		JPanel jp = new JPanel();
		jp.add(btAnnnuler);
		jp.add(btOK);

		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 5;
		gbc.gridheight = 1;
		gbc.weightx = 1;
		gbc.weighty = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		add(jp, gbc);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		// Si on est en mode ajout
		if (cmd.equals("ADD")) {
			int iIndex;
			do{
				// On récupère les info
				String sValue = liVal.getSelectedValue();
				 iIndex = liVal.getSelectedIndex();
				// Y a-t-il quelque chose de selectionné
				if (iIndex != -1) {
					listModVal.remove(iIndex);
					listModCho.addElement(sValue);
	
				}
			}while( iIndex != -1 );
			
		} else if (cmd.equals("DEL")) {
			int iIndex;
				do{
				// On récupère les info
				String sValue = liCho.getSelectedValue();
				iIndex = liCho.getSelectedIndex();
				// Y a-t-il quelque chose de selectionné
				if (iIndex != -1) {
					listModCho.remove(iIndex);
					listModVal.addElement(sValue);
	
				}
			}while( iIndex != -1 );
				
		} else if (cmd.equals("OK")) {
			String sMsg = "Vous avez sélectionné : \n";
			int i;
			for (i = 0; i < listModCho.getSize(); i++)
				sMsg += "- " + listModCho.getElementAt(i) + "\r\n";

			if (i != 0)
				JOptionPane.showMessageDialog(null, sMsg, "Votre Selection :",
						JOptionPane.PLAIN_MESSAGE);
			else
				JOptionPane.showMessageDialog(null, "Rien n'a été sélectionné",
						"Votre Selection :", JOptionPane.PLAIN_MESSAGE);

		} else if (cmd.equals("ANNULER")) {

			
			if ( WindowsCloser.closeMsg() == 0)
				// System.exit(0);
				frame.dispose();

		}

	}

}
