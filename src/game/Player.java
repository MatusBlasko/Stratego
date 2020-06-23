package game;

import java.util.ArrayList;
import java.util.Arrays;

public class Player {

	private String name;
	private ArrayList<Character> characters;
	
	public Player(String name, ArrayList<Character> characters){
		this.name = name;
		this.characters = characters;
	}
	
	/**
	 * Set player name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Get player name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Set whole character list
	 * @param whole character list
	 */
	public void setCharacters(ArrayList<Character> characters) {
		this.characters = characters;
	}
	
	/**
	 * Get whole character list
	 */
	public ArrayList<Character> getCharacters() {
		return characters;
	}
	
	/**
	 * Get character on specific position
	 * @param position
	 * @return character on specific position or null
	 */
	public Character getCharacterByPosition(int[] position) {
		
		for (Character charcater : characters) {
			
			if(Arrays.equals(charcater.getPosition(), position)) {
				return charcater;
			}else {
				return null;
			}
		}
		return null;
	}	
}
