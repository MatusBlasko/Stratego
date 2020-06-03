import java.util.ArrayList;

public abstract class Character {

	private String name;
	private int rank;
	private int[] position;
	private ArrayList<Integer> special;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public int getRank() {
		return rank;
	}
	
	public void setRank(int rank) {
		this.rank = rank;
	}

	public ArrayList<Integer> getSpecial() {
		return special;
	}
	
	public void setSpecial(ArrayList<Integer> special) {
		this.special = special;
	}
	
	public boolean move(Player player, Player opponent, int destination) {
		
		int[] tempPosition = position;
		
		//calculate new position
		switch(destination) {
			case 0: tempPosition[0] = tempPosition[0]+1;
			case 1: tempPosition[1] = tempPosition[0]+1;
			case 2: tempPosition[0] = tempPosition[0]-1;
			case 3: tempPosition[1] = tempPosition[0]-1;
		}
		
		//get Characters
		Character playersCharacter = player.getCharacterByPosition(tempPosition);
		Character opponentsCharacter = opponent.getCharacterByPosition(tempPosition);
		
		//check if position is occupated by player
		if(playersCharacter != null) {
			return false;
		}
		
		boolean returnValue = false;
		
		//check if position is occupated by opponent		
		if(opponentsCharacter != null) {
			if(this.fight(player, opponent, tempPosition) == true) {
				returnValue = true;
			}else {
				returnValue = false;
			}
		}
		
		return returnValue;
		
	}
	
	public boolean fight(Player player, Player opponent, int[] tempPosition) {
		
		boolean returnValue = false;
		
		//get Characters
		Character playersCharacter = player.getCharacterByPosition(tempPosition);
		Character opponentsCharacter = opponent.getCharacterByPosition(tempPosition);
		
		if(playersCharacter.getRank()>opponentsCharacter.getRank()) {
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

	public int[] getPosition() {
		return position;
	}

	public void setPosition(int[] position) {
		this.position = position;
	}
}
