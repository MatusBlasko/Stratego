package GUI;

	import java.awt.BasicStroke;
import java.awt.Color;
	import java.awt.Graphics;
import java.awt.Stroke;

import javax.swing.JFrame;
	import javax.swing.JPanel;
	
public class Board extends JPanel{    

	 Color darkGreen = new Color(0,230,0);
	    public void paint(Graphics g){
	        for(int i = 0; i <= 450; i+=50){
	            for(int j = 0; j <= 450; j+=50){
	                g.setColor(darkGreen);
	                g.fillRect(i, j, 50, 50);
	                g.setColor(Color.black);
	                g.drawRect(i, j, 50, 50);
	            }
	        }
            for(int j = 200; j <= 250; j+=50){
                for(int i = 100; i <= 150; i+=50){
	                g.setColor(Color.blue);
	                g.fillRect(i, j, 50, 50);
	                g.setColor(Color.black);
	                g.drawRect(i, j, 50, 50);
                }
                
                for(int i = 300; i <= 350; i+=50){
	                g.setColor(Color.blue);
	                g.fillRect(i, j, 50, 50);
	                g.setColor(Color.black);
	                g.drawRect(i, j, 50, 50);
                }
            }
	    }

}
