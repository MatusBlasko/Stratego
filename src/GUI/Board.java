package GUI;

	import java.awt.BasicStroke;
import java.awt.Color;
	import java.awt.Graphics;
import java.awt.Stroke;
import java.util.ArrayList;

import javax.swing.JFrame;
	import javax.swing.JPanel;

import game.Character;
import game.Game;
import game.Player;
	
public class Board extends JPanel{
	

	private Player p1 = Game.getInstance().getPlayerOne();
	private Player p2 = Game.getInstance().getPlayerTwo();
	
	private int startX = 0;
	private int startY = 0;
	
	private int tileWidth = 50;
	private int tileHeight = 50;
	 
	private ArrayList<Character> characters;


	 Color darkGreen = new Color(0,230,0);
	    public void paint(Graphics g){
	    	paintBoard(g);
	    	paintSee(g); 
	    	paintP1Figures(g);
	    	paintP2Figures(g);
           
	    }
	    
	    public void paintBoard(Graphics g) {
	    	for(int i = startX; i <= 450; i+=tileWidth){
	            for(int j = startY; j <= 450; j+=tileHeight){
	                g.setColor(darkGreen);
	                g.fillRect(i, j, tileWidth, tileHeight);
	                g.setColor(Color.black);
	                g.drawRect(i, j, tileWidth, tileHeight);
	            }
	        }
	    }
	    
	    public void paintSee(Graphics g) {
	    	 for(int j = 200; j <= 250; j+=tileHeight){
	                for(int i = 100; i <= 150; i+=tileWidth){
		                g.setColor(Color.blue);
		                g.fillRect(i, j, tileWidth, tileHeight);
		                g.setColor(Color.black);
		                g.drawRect(i, j, tileWidth, tileHeight);
	                }
	                
	                for(int i = 300; i <= 350; i+=tileWidth){
		                g.setColor(Color.blue);
		                g.fillRect(i, j, tileWidth, tileHeight);
		                g.setColor(Color.black);
		                g.drawRect(i, j, tileWidth, tileHeight);
	                }
	            }
	    } 
	    
	    public void paintP1Figures(Graphics g) {
	    	//ArrayList<game.Character> Characters = this.p1.getCharacters();
	    	/*for (game.Character character : Characters) {
	    		int [] chPosition = character.getPosition();
                g.setColor(Color.blue);
                g.fillRect(chPosition[0] , chPosition[1], tileWidth, tileHeight);
                g.setColor(Color.black);
                g.drawRect(chPosition[0], chPosition[1], tileWidth, tileHeight);
	    	 }
	    	*/
	    	
	    } 
	    
	    public void paintP2Figures(Graphics g) {
	    	
	    } 

}
