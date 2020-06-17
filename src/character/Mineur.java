package character;

import game.Character;

public class Mineur extends Character {

	public Mineur(int[] position){
		setName("Mineur");
		setRank(3);
		setPosition(position);
		setSpecial(null);
	}
}