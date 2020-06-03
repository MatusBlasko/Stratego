import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainGUI extends JPanel implements ActionListener {

	private JLabel titel = new JLabel("Stratego");
	private JButton b = new JButton("Start");
	private CardLayout cl;
	
	MainGUI(CardLayout cl){
		this.cl = cl;
		
	     this.add(this.titel);
	     this.add(this.b);
	     b.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == b) {
			cl.show(getParent(),"a");
		}
		
	}
}
