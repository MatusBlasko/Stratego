package character;

import game.Character;
import game.Player;

public class Fieldmarshal extends Character {

	public Fieldmarshal(int[] position){
		setName("Fieldmarshal");
		setRank(10);
		setPosition(position);
		setSpecial(5);
	}
	
	public boolean fight(Character opponentsCharacterOnNewPosition, int[] newPosition, Player player, Player opponent) {
		
		boolean returnValue = false;
		
		if(opponentsCharacterOnNewPosition.getSpecial() == 3) {
			this.setPosition(newPosition);
			opponent.getCharacters().remove(opponentsCharacterOnNewPosition);
			returnValue = true;
			
		}else{
			returnValue = super.fight(opponentsCharacterOnNewPosition, newPosition, player, opponent);	
		}
		
		return returnValue;
	}
}