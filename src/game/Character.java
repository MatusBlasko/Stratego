package game;

import java.util.ArrayList;

public abstract class Character {

	private String name;
	private int rank;
	private int[] position;
	private ArrayList<Integer> special;
	
	/**
	 * Get Name
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	* Set Name
	* @param name
	*/
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get Rank
	 * @return rank
	 */
	public int getRank() {
		return rank;
	}
	
	/**
	* Set Rank
	* @param rank
	*/
	public void setRank(int rank) {
		this.rank = rank;
	}

	/**
	* Get Position
	* @return position
	*/
	public int[] getPosition() {
		return position;
	}

	/**
	* Set Position
	* @param position
	*/
	public void setPosition(int[] position) {
		this.position = position;
	}
	
	public ArrayList<Integer> getSpecial() {
		return special;
	}
	
	public void setSpecial(ArrayList<Integer> special) {
		this.special = special;
	}
	
	/**
	 * 
	 * @param player
	 * @param opponent
	 * @param destination
	 * @return
	 */
	public boolean move(Player player, Player opponent, int destination) {
		
		//initialize new position
		int[] tempPosition = this.getPosition().clone();
		
		//calculate new position
		switch(destination) {
			case 0: tempPosition[1] = tempPosition[1]+1; break;
			case 1: tempPosition[0] = tempPosition[0]+1; break;
			case 2: tempPosition[1] = tempPosition[1]-1; break;
			case 3: tempPosition[0] = tempPosition[0]-1; break;
		}
		
		//get Characters
		Character playersCharacter = player.getCharacterByPosition(tempPosition);
		Character opponentsCharacter = opponent.getCharacterByPosition(tempPosition);
		
		//check if position is occupied by player
		if(playersCharacter != null) {
			return false;
		}
		
		boolean returnValue = false;
		
		//check if position is occupied by opponent		
		if(opponentsCharacter != null) {
			if(this.fight(playersCharacter, opponentsCharacter, player, opponent, tempPosition) == true) {
				returnValue = true;
			}else {
				returnValue = false;
			}
		}
		
		return returnValue;
		
	}
	
	public boolean fight(Character playersCharacter, Character opponentsCharacter, Player player, Player opponent, int[] tempPosition) {
		
		boolean returnValue = false;
		
		if(playersCharacter.getRank() > opponentsCharacter.getRank()) {
			playersCharacter.setPosition(tempPosition);
			opponent.getCharacters().remove(opponentsCharacter);
			returnValue = true;
		}else {
			opponentsCharacter.setPosition(tempPosition);
			player.getCharacters().remove(playersCharacter);
			returnValue = false;
		}
		
		return returnValue;
		
	}
}