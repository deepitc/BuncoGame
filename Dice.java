import java.util.Random;

/**
 * A class to create a dice which generates the roll of dice
 * 
 * @author Deepit Chandgothia
 */

public class Dice {
	int value;

	/**
	 * Constructor
	 * 
	 * 
	 */

	public Dice() {
		value = 0;
	}

	/**
	 * FUNCTION TO roll a dice for the player and return the face value of the dice
	 * 
	 * @return face of the dice
	 */
	public int getFace() {
		Random roller = new Random();
		return roller.nextInt(6) + 1;
	}

}
