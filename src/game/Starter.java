package game;

import java.util.ArrayList;

import character.Colonel;
import character.General;

public class Starter {

	public static void main(String[] args) {
		
		/*Game game = new Game("Leo", "Matus");
		System.out.println(game.getPlayerTwo().getCharacterByPosition(new int [] {8, 9}));*/
		
		ArrayList<Character> p1c = new ArrayList<Character>();
		ArrayList<Character> p2c = new ArrayList<Character>();
		
		p1c.add(new Colonel(new int[] {4, 5}));
		p1c.add(new General(new int[] {5, 5}));
		//p1c.add(new Colonel(new int[] {7, 5}));
		
		p2c.add(new Colonel(new int[] {5, 4}));
		p2c.add(new General(new int[] {4, 4}));
		//p2c.add(new Colonel(new int[] {7, 4}));
		
		Player p1 = new Player("player1", p1c);
		Player p2 = new Player("player2", p2c);
		
		//Game Class
		
		//Character car = p1.getCharacterByPosition(new int[] {4, 5});
		//car.move(p1, p2, 2);
		
		System.out.println(p2.getCharacterByPosition(new int[] {4, 4}).move(p2, p1, 2));
		System.out.println(p1.getCharacters());
		System.out.println(p2.getCharacters());
		
	}

}
