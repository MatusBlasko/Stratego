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
	
	public boolean fight(Character opponentsCharacterOnNewPosition, int[] newPosition, Player player, Player opponent) {
		
		boolean returnValue = false;
		
		if(opponentsCharacterOnNewPosition.getSpecial() == 5) {
			this.setPosition(newPosition);
			opponent.getCharacters().remove(opponentsCharacterOnNewPosition);
			returnValue = true;
			
		}else{
			returnValue = super.fight(opponentsCharacterOnNewPosition, newPosition, player, opponent);	
		}
		
		return returnValue;
	}
}