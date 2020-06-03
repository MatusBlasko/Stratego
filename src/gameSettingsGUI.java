import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class gameSettingsGUI extends JPanel implements ActionListener {

	private JLabel titel = new JLabel("Spieler");
	private JButton b = new JButton("Start");
	private CardLayout cl;
	
	gameSettingsGUI(CardLayout cl){
		this.cl = cl;
		
	     this.add(this.titel);
	     this.add(this.b);
	     b.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == b) {
			cl.show(getParent(),"main");
		}
		
	}
}
