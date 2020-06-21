package game;

import java.util.ArrayList;

public abstract class Character {

	private String name;
	private int rank;
	private int[] position;
	private int special;
	
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
	
	public int getSpecial() {
		return special;
	}
	
	public void setSpecial(int special) {
		this.special = special;
	}
	
	/**
	 * Moves characters
	 * @param player player
	 * @param opponent opponent player
	 * @param destination destination where character should be moved
	 * @return true or false if move was successful or not
	 */
	public boolean move(Player player, Player opponent, int destination) {
		
		//initialize new position
		int[] newPosition = this.getPosition().clone();
		
		//calculate new position
		switch(destination) {
			case 0: newPosition[1] = newPosition[1]+1; break;
			case 1: newPosition[0] = newPosition[0]+1; break;
			case 2: newPosition[1] = newPosition[1]-1; break;
			case 3: newPosition[0] = newPosition[0]-1; break;
		}
		
		//get Characters
		Character playersCharacterOnNewPosition = player.getCharacterByPosition(newPosition);
		Character opponentsCharacterOnNewPosition = opponent.getCharacterByPosition(newPosition);
		
		//check if position is occupied by player
		if(playersCharacterOnNewPosition != null) {
			return false;
		}
		
		boolean returnValue = false;
		
		//check if position is occupied by opponent		
		if(opponentsCharacterOnNewPosition != null) {
			
			if(this.fight(opponentsCharacterOnNewPosition, newPosition, player, opponent)) {
				returnValue = true;
				
			}else {
				returnValue = false;
			}
			
		}else {
			
			this.setPosition(newPosition);
			returnValue = true;
		}
		
		return returnValue;
		
	}
	
	/**
	 * Fights if destination is occupied by opponent
	 * @param opponentsCharacterOnNewPosition opponents character on new position
	 * @param newPosition new position
	 * @param player player
	 * @param opponent opponent player
	 * @return true or false if fight was successful or not
	 */
	public boolean fight(Character opponentsCharacterOnNewPosition, int[] newPosition, Player player, Player opponent) {
		
		boolean returnValue = false;
		
		if(this.getRank() > opponentsCharacterOnNewPosition.getRank()) {
			this.setPosition(newPosition);
			opponent.getCharacters().remove(opponentsCharacterOnNewPosition);
			returnValue = true;
			
		}else if(this.getRank() == opponentsCharacterOnNewPosition.getRank()){
			opponent.getCharacters().remove(opponentsCharacterOnNewPosition);
			player.getCharacters().remove(this);
			returnValue = false;
		}
		
		else {
			opponentsCharacterOnNewPosition.setPosition(newPosition);
			player.getCharacters().remove(this);
			returnValue = false;
		}
		
		return returnValue;
		
	}
}