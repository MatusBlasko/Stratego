import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ContainerGUI extends JFrame implements ActionListener {

	ContainerGUI(){
		CardLayout cl = new CardLayout();
		setLayout(cl);
		
		MainGUI MainGUI = new MainGUI(cl);
		add(MainGUI,"main");
		gameSettingsGUI gameSettings = new gameSettingsGUI(cl); 
		add(gameSettings, "a");
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setSize(600,400);
		setVisible(true);	

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
