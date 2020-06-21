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
	
	public boolean fight(Character opponentsCharacterOnNewPosition, int[] newPosition, Player player, Player opponent) {
		
		boolean returnValue = false;
		
		if(opponentsCharacterOnNewPosition.getSpecial() == 2) {
			this.setPosition(newPosition);
			opponent.getCharacters().remove(opponentsCharacterOnNewPosition);
			returnValue = true;
			
		}else{
			returnValue = super.fight(opponentsCharacterOnNewPosition, newPosition, player, opponent);	
		}
		
		return returnValue;
	}
}