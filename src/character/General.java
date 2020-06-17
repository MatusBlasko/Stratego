package character;

import game.Character;

public class General extends Character {

	public General(int[] position){
		setName("General");
		setRank(9);
		setPosition(position);
		setSpecial(null);
	}
}