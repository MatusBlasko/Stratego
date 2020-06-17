package GUI;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import game.Game;

public class gameGUI  extends JPanel{
	private CardLayout cl;
	private JPanel north = new JPanel();
	private Board center = new Board();
	
	JLabel spieler1Name = new JLabel("bruno");
	JLabel spiele2Name = new JLabel("man");
	JLabel turnLabel = new JLabel("Rot ist am Zug");
	
	
	
	gameGUI(CardLayout cl){
		this.cl = cl;

		turnLabel.setHorizontalAlignment(JLabel.CENTER);
		
		north.setLayout(new BorderLayout());
		north.add(turnLabel,BorderLayout.CENTER);
		north.add(spieler1Name,BorderLayout.WEST);
		north.add(spiele2Name,BorderLayout.EAST);
		
		setLayout(new BorderLayout());
		add(north,BorderLayout.NORTH);
		add(center,BorderLayout.CENTER);
	}
	
}
