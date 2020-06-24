package GUI;

	import java.awt.BasicStroke;
import java.awt.Color;
	import java.awt.Graphics;
import java.awt.Stroke;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
	import javax.swing.JPanel;

import game.Character;
import game.Game;
import game.Player;
	
public class Board extends JPanel implements MouseListener{
	

	//private Player p1 = Game.getInstance().getPlayerOne();
	//private Player p2 = Game.getInstance().getPlayerTwo();
	
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
	    	ArrayList<game.Character> Characters = Game.getInstance().getPlayerOne().getCharacters();
	    	for (game.Character character : Characters) {
	    		int [] chPosition = character.getPosition();
                g.setColor(Color.red);
                g.fillRect(chPosition[0]*tileWidth , chPosition[1]*tileHeight, tileWidth, tileHeight);
                g.setColor(Color.black);
                g.drawRect(chPosition[0]*tileWidth, chPosition[1]*tileHeight, tileWidth, tileHeight);
	    	 }
	    	
	    	
	    } 
	    
	    public void paintP2Figures(Graphics g) {
	    	ArrayList<game.Character> Characters = Game.getInstance().getPlayerTwo().getCharacters();
	    	for (game.Character character : Characters) {
	    		int [] chPosition = character.getPosition();
                g.setColor(Color.blue);
                g.fillRect(chPosition[0]*tileWidth , chPosition[1]*tileHeight, tileWidth, tileHeight);
                g.setColor(Color.black);
                g.drawRect(chPosition[0]*tileWidth, chPosition[1]*tileHeight, tileWidth, tileHeight);
	    	 }
	    }

	    public void mouseClicked(MouseEvent e) {
	    	int[] position = new int[2];
	    	position[0] = (int) ((long) (e.getX() - startX)/tileWidth);
	    	position[1] = (int) ((long) (e.getY() - startY)/tileHeight);
	    	System.out.println(position[0] + "," + position[1]);
	    	Character character = Game.getInstance().getPlayerOne().getCharacterByPosition(position);
	    	
	    	if(character == null){
	    		System.out.println("i got here 1");
	    		character = Game.getInstance().getPlayerTwo().getCharacterByPosition(position);
	    		if(character == null && Game.getInstance().getLastSelectedCharacter() == null){
		    		System.out.println("i got here 2");
	    			return;
	    		}
	    		if(Game.getInstance().getLastSelectedCharacter() == null) {
		    		System.out.println("i got here 3");
	    			Game.getInstance().setLastSelectedCharacter(character);
	    		}else {
		    		System.out.println("i got here 4");
		    		Game.getInstance().getLastSelectedCharacter();
	    			System.out.println(Game.getInstance().getLastSelectedCharacter().move(Game.getInstance().getPlayerTwo(), Game.getInstance().getPlayerOne(), position));
	    			Game.getInstance().setLastSelectedCharacter(character);
	    		}
	    	}else {
	    		System.out.println("i got here 5");
	    		if(Game.getInstance().getLastSelectedCharacter() == null) {
		    		System.out.println("i got here 6");
	    			Game.getInstance().setLastSelectedCharacter(character);
	    		}else {
		    		System.out.println("i got here 7");
	    			System.out.println(character.move(Game.getInstance().getPlayerOne(), Game.getInstance().getPlayerTwo(), position));
	    			Game.getInstance().setLastSelectedCharacter(character);
	    		}
	    	}
	    	
	      }

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		} 
	    
	    
	    

}
