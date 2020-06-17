package character;

import game.Character;

public class Bomb extends Character {
	
	public Bomb(int[] position){
		setName("Bomb");
		//setRank();
		setPosition(position);
		setSpecial(null);
	}	
}