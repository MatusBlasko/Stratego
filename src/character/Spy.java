package character;

import game.Character;

public class Spy extends Character {

	public Spy(int[] position){
		setName("Spy");
		setRank(1);
		setPosition(position);
		setSpecial(null);
	}
}