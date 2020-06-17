package GUI;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainGUI extends JPanel implements ActionListener {

	private JLabel titel = new JLabel("Stratego");
	private JButton bStart = new JButton("Start");
	private CardLayout cl;
	
	MainGUI(CardLayout cl){
		this.cl = cl;
		
		
	     titel.setBounds(300, 50, 200, 100);
	     bStart.setBounds(330, 600, 140, 60);
	     setFontSizetoMaximum(titel);
	     this.bStart.setFont(new Font("Arial", Font.PLAIN, 28));
	     this.add(this.titel);
	     this.add(this.bStart);
	     bStart.addActionListener(this);
	     setLayout(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == bStart) {
			cl.show(getParent(),"gameSettings");
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
