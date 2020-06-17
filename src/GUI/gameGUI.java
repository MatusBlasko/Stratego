package GUI;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class gameGUI  extends JPanel{
	private CardLayout cl;
	private JPanel north = new JPanel();
	private Board center = new Board();
	JButton b = new JButton("lol");
	
	gameGUI(CardLayout cl){
		this.cl = cl;
		north.setLayout(new GridLayout(1,1));
		north.add(b);
		
		setLayout(new BorderLayout());
		add(north,BorderLayout.NORTH);
		add(center,BorderLayout.CENTER);
	}
	
}
