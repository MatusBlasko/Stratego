package character;

import game.Character;
import game.Player;

public class Mineur extends Character {

	public Mineur(int[] position){
		setName("Mineur");
		setRank(3);
		setPosition(position);
		setSpecial(4);
	}
	
	public int fight(Character opponentsCharacterOnNewPosition, int[] newPosition, Player player, Player opponent) {
		
		int returnValue = 0;
		
		//if bomb
		if(opponentsCharacterOnNewPosition.getSpecial() == 2) {
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