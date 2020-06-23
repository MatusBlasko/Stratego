package character;

import game.Character;
import game.Player;

public class Flag extends Character {
	
	public Flag(int[] position){
		setName("Flag");
		//setRank();
		setPosition(position);
		setSpecial(1);
	}	
	
	public int move(Player player, Player opponent, int destination) {
		
		return 3;
		
	}	
}