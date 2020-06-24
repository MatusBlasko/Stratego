package game;

import java.util.ArrayList;

import character.Bomb;
import character.Colonel;
import character.Fieldmarshal;
import character.Flag;
import character.General;
import character.Mineur;
import character.Spy;

public class Game {
	
	//Initialize characters
	private ArrayList<Character> playerOneList = new ArrayList<Character>();
	private ArrayList<Character> playerTwoList = new ArrayList<Character>();
	
	private Player playerOne;
	private Player playerTwo;
	
	private int[] lastSelectedPosition = null;
	String playerTurn = "red";
	
	
	private static Game instance = new Game();

	private Game(){
		
	}
	
    public static Game getInstance(){
    if(instance == null){
        instance = new Game();
    }
        return instance;
    }
	
	
	public void createGamePlayers(String playerOneName, String playerTwoName) {
		//Initialize PlayerOne characters
		playerOneList.add(new Flag(new int[] {0, 9}));
		
		playerOneList.add(new Bomb(new int[] {9, 9}));
		playerOneList.add(new Bomb(new int[] {2, 9}));
		playerOneList.add(new Bomb(new int[] {7, 8}));
		playerOneList.add(new Bomb(new int[] {5, 8}));
		playerOneList.add(new Bomb(new int[] {1, 8}));
		
		playerOneList.add(new Spy(new int[] {4, 9}));
		
		playerOneList.add(new Mineur(new int[] {8, 8}));
		playerOneList.add(new Mineur(new int[] {2, 8}));
		playerOneList.add(new Mineur(new int[] {5, 9}));
		playerOneList.add(new Mineur(new int[] {1, 9}));
		
		playerOneList.add(new Colonel(new int[] {9, 8}));
		playerOneList.add(new Colonel(new int[] {3, 8}));
		playerOneList.add(new Colonel(new int[] {0, 8}));
		playerOneList.add(new Colonel(new int[] {6, 9}));
		
		playerOneList.add(new General(new int[] {3, 9}));
		playerOneList.add(new General(new int[] {6, 8}));
		playerOneList.add(new General(new int[] {8, 9}));
		
		playerOneList.add(new Fieldmarshal(new int[] {4, 8}));
		playerOneList.add(new Fieldmarshal(new int[] {7, 9}));
		
		//Initialize PlayerTwo characters
		playerTwoList.add(new Flag(new int[] {9, 0}));
		
		playerTwoList.add(new Bomb(new int[] {8, 1}));
		playerTwoList.add(new Bomb(new int[] {4, 1}));
		playerTwoList.add(new Bomb(new int[] {2, 1}));
		playerTwoList.add(new Bomb(new int[] {7, 0}));
		playerTwoList.add(new Bomb(new int[] {0, 0}));
		
		playerTwoList.add(new Spy(new int[] {5, 0}));
		
		playerTwoList.add(new Mineur(new int[] {7, 1}));
		playerTwoList.add(new Mineur(new int[] {1, 1}));
		playerTwoList.add(new Mineur(new int[] {8, 0}));
		playerTwoList.add(new Mineur(new int[] {4, 0}));
		
		playerTwoList.add(new Colonel(new int[] {3, 0}));
		playerTwoList.add(new Colonel(new int[] {0, 1}));
		playerTwoList.add(new Colonel(new int[] {6, 1}));
		playerTwoList.add(new Colonel(new int[] {9, 1}));
		
		playerTwoList.add(new General(new int[] {6, 0}));
		playerTwoList.add(new General(new int[] {3, 1}));
		playerTwoList.add(new General(new int[] {1, 0}));
		
		playerTwoList.add(new Fieldmarshal(new int[] {5, 1}));
		playerTwoList.add(new Fieldmarshal(new int[] {2, 0}));
		
		this.playerOne = new Player(playerOneName, playerOneList);
		this.playerTwo = new Player(playerTwoName, playerTwoList);
	}
	
	/**
	 * Get player name
	 */
	public Player getPlayerOne() {
		return playerOne;
	}
	
	/**
	 * Get player name
	 */
	public Player getPlayerTwo() {
		return playerTwo;
	}

	public int[] getLastSelectedPosition() {
		return lastSelectedPosition;
	}

	public void setLastSelectedPosition(int[] lastSelectedPosition) {
		this.lastSelectedPosition = lastSelectedPosition;
	}
	
	public String getPlayerTurn() {
		return this.playerTurn;
	}

	public void changePlayerTurn() {
		if(this.playerTurn == "red"){
			this.playerTurn = "blue";
		}else {
			this.playerTurn = "red";
		}
	}
}
