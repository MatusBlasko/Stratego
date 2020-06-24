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
	    	
	    	Character character;
	    	
	    	if(Game.getInstance().getPlayerTurn() == "red") {
	    		 character = Game.getInstance().getPlayerOne().getCharacterByPosition(position);
	    	}else{
	    		 character = Game.getInstance().getPlayerTwo().getCharacterByPosition(position);
	    	}
	    	
	    	System.out.println(Game.getInstance().getPlayerTurn());
	    	if(character == null && Game.getInstance().getLastSelectedPosition() == null){
	    		System.out.println("i got here 2");
    			return;
	    	}else{
	    	System.out.println("i got here 1");
    		if(Game.getInstance().getPlayerTurn() == "blue") {
	    
	    		if(Game.getInstance().getLastSelectedPosition() == null) {
		    		System.out.println("i got here 3");
	    			Game.getInstance().setLastSelectedPosition(position);
	    		}else {
	    			Character lastSelectedCharacter = Game.getInstance().getPlayerTwo().getCharacterByPosition(Game.getInstance().getLastSelectedPosition());
		    		System.out.println("i got here 4");
		    		Game.getInstance().getLastSelectedPosition();
	    			int result = lastSelectedCharacter.move(Game.getInstance().getPlayerTwo(), Game.getInstance().getPlayerOne(), position);
	    			if(result != 1) {
	    				Game.getInstance().setLastSelectedPosition(null);
	    				Game.getInstance().changePlayerTurn();
	    				repaint();
	    			}if(result == 1) {
		    			Game.getInstance().setLastSelectedPosition(position);
	    			}
	    			Game.getInstance().setLastSelectedPosition(position);
	    		}
    		}else if(Game.getInstance().getPlayerTurn() == "red") {
    			
	    		if(Game.getInstance().getLastSelectedPosition() == null) {
		    		System.out.println("i got here 6");
	    			Game.getInstance().setLastSelectedPosition(position);
	    		}else {
		    		System.out.println("i got here 7");
	    			Character lastSelectedCharacter = Game.getInstance().getPlayerOne().getCharacterByPosition(Game.getInstance().getLastSelectedPosition());
	    			int result = lastSelectedCharacter.move(Game.getInstance().getPlayerOne(), Game.getInstance().getPlayerTwo(), position);
	    			if(result != 1) {
	    				Game.getInstance().setLastSelectedPosition(null);
	    				Game.getInstance().changePlayerTurn();
	    				repaint();
	    			}if(result == 1) {
		    			Game.getInstance().setLastSelectedPosition(position);
	    			}
	    		}
	    	}
	    	}
	    		
	    		
	    	/*	
	    	}else {
	    		
	    	}
	    	*/
	    	
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
