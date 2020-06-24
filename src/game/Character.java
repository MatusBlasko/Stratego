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
	public int move(Player player, Player opponent, int[] destination) {
		
		//initialize new position
		int[] position = this.getPosition().clone();
		
		if(!(position[0] == destination[0] && position[1]-1 == destination[1] || position[0] == destination[0] && position[1]+1 == destination[1] || position[0]-1 == destination[0] && position[1] == destination[1] || position[0]+1 == destination[0] && position[1] == destination[1])) {
			return 1;
		}
		
		//calculate new position
		/*
		switch(destination) {
			case 0: newPosition[1] = newPosition[1]+1; break;
			case 1: newPosition[0] = newPosition[0]+1; break;
			case 2: newPosition[1] = newPosition[1]-1; break;
			case 3: newPosition[0] = newPosition[0]-1; break;
		}
		*/
		//get Characters
		Character playersCharacterOnNewPosition = player.getCharacterByPosition(destination);
		Character opponentsCharacterOnNewPosition = opponent.getCharacterByPosition(destination);
		
		//check if position is occupied by player
		//if occupied by player
		if(playersCharacterOnNewPosition != null) {
			return 1;
		}
		
		int returnValue = 2;
		
		//check if position is occupied by opponent		
		if(opponentsCharacterOnNewPosition != null) {
			
			//if fight won
			if(this.fight(opponentsCharacterOnNewPosition, destination, player, opponent) == 0) {
				returnValue = 2;
				
			//if fight draw	
			}else if(this.fight(opponentsCharacterOnNewPosition, destination, player, opponent) == 1) {
				returnValue = 3;
			
			//if fight lost	
			}else if(this.fight(opponentsCharacterOnNewPosition, destination, player, opponent) == 2) {
				returnValue = 4;	
				
			//if flag
			}else if (this.fight(opponentsCharacterOnNewPosition, destination, player, opponent) == 3){
				returnValue = 5;
			}
			
		//if free 	
		}else {
			this.setPosition(destination);
			returnValue = 0;
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
	public int fight(Character opponentsCharacterOnNewPosition, int[] newPosition, Player player, Player opponent) {
		
		int returnValue = 0;
		
		//if fight won
		if(this.getRank() > opponentsCharacterOnNewPosition.getRank()) {
			this.setPosition(newPosition);
			opponent.getCharacters().remove(opponentsCharacterOnNewPosition);
			returnValue = 0;
			
		//if fight draw	
		}else if(this.getRank() == opponentsCharacterOnNewPosition.getRank()){
			opponent.getCharacters().remove(opponentsCharacterOnNewPosition);
			player.getCharacters().remove(this);
			returnValue = 1;
		}
		
		//if fight lost
		else {
			opponentsCharacterOnNewPosition.setPosition(newPosition);
			player.getCharacters().remove(this);
			returnValue = 2;
		}
		
		return returnValue;
		
	}
}