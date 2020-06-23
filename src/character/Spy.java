package character;

import game.Character;
import game.Player;

public class Spy extends Character {

	public Spy(int[] position){
		setName("Spy");
		setRank(1);
		setPosition(position);
		setSpecial(3);
	}
	
	public int fight(Character opponentsCharacterOnNewPosition, int[] newPosition, Player player, Player opponent) {
		
		int returnValue = 0;
		
		//if fieldmarshal
		if(opponentsCharacterOnNewPosition.getSpecial() == 5) {
			this.setPosition(newPosition);
			opponent.getCharacters().remove(opponentsCharacterOnNewPosition);
			returnValue = 0;
		
			//if not
		}else{
			returnValue = super.fight(opponentsCharacterOnNewPosition, newPosition, player, opponent);	
		}
		
		return returnValue;
	}
}