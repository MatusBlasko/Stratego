package character;

import game.Character;
import game.Player;

public class Bomb extends Character {
	
	public Bomb(int[] position){
		setName("Bomb");
		setRank(11);
		setPosition(position);
		setSpecial(2);
	}	
	
	public int move(Player player, Player opponent, int[] destination) {
	
		return 1;
		
	}	
}