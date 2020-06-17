package GUI;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Console;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import game.Game;
import game.Player;

public class gameSettingsGUI extends JPanel implements ActionListener {

	private JLabel titel = new JLabel("Einstellungen");
	
	private JLabel spieler1Label = new JLabel("Spieler1:");
	private JTextField spieler1Name = new JTextField("");
	
	private JLabel spieler2Label = new JLabel("Spieler2:");
	private JTextField spieler2Name = new JTextField("");
	
	private JButton bStart = new JButton("Start");
	private JButton bZurück = new JButton("Zurück");
	private CardLayout cl;
	
	
	gameSettingsGUI(CardLayout cl){
		this.cl = cl;
		
		//spieler1Name.;
		//this.spieler1Name.setPreferredSize(new Dimension(100,40));
		
		titel.setBounds(325,25,150,80);
		spieler1Label.setBounds(50,100,100,50);
		spieler1Name.setBounds(50,160,100,50);
		spieler2Label.setBounds(650,100,100,50);
		spieler2Name.setBounds(650,160,100,50);
		
		bStart.setBounds(575,600,150,60);
		bZurück.setBounds(75,600,150,60);
		
		setFontSizetoMaximum(titel);
		setFontSizetoMaximum(spieler1Label);
		setFontSizetoMaximum(spieler2Label);
		
	     this.add(this.spieler1Label);
	     this.add(this.spieler1Name);
	     this.add(this.spieler2Label);
	     this.add(this.spieler2Name);
	     this.add(this.titel);
	     this.add(this.bStart);
	     this.add(this.bZurück);
	     bStart.addActionListener(this);
	     bZurück.addActionListener(this);
	     
	     setLayout(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == bStart) {
			
			if(spieler1Name.getText().equals("") || spieler2Name.getText().equals(""))
			{
				System.out.println("Spieler namen müssen angegeben wereden");
			}else {
				Game.getInstance().createGamePlayers(spieler1Name.getText(), spieler2Name.getText());
				cl.show(getParent(),"game");
			}
		}
		
		if(e.getSource() == bZurück) {
			cl.show(getParent(),"main");
		}
		
	}
	
	
	public void setFontSizetoMaximum(JLabel label){
		Font labelFont = label.getFont();
		String labelText = label.getText();

		int stringWidth = label.getFontMetrics(labelFont).stringWidth(labelText);
		int componentWidth = label.getWidth();

		// Find out how much the font can grow in width.
		double widthRatio = (double)componentWidth / (double)stringWidth;

		int newFontSize = (int)(labelFont.getSize() * widthRatio);
		int componentHeight = label.getHeight();

		// Pick a new font size so it will not be larger than the height of label.
		int fontSizeToUse = Math.min(newFontSize, componentHeight);

		// Set the label's font size to the newly determined size.
		label.setFont(new Font(labelFont.getName(), Font.PLAIN, fontSizeToUse));
	}
}
