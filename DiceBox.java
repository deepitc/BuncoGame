
/**
 * A class to make a dice cup consisting of 3 dices
 * 
 * @author Deepit Chandgothia
 */

public class DiceBox {
	Dice dice1;
	Dice dice2;
	Dice dice3;
	boolean conclude_round;
	boolean repeat;

	/**
	 * Constructor
	 * 
	 * 
	 */
	public DiceBox() { // constructor to initialize variables
		dice1 = new Dice();
		dice2 = new Dice();
		dice3 = new Dice();
		conclude_round = false;
		repeat = false;
	}

	/**
	 * FUNCTION TO roll the dice cup
	 * 
	 * @return the sum of the dice rolls
	 */
	public int roll() {
		int face1 = dice1.getFace();
		int face2 = dice2.getFace();
		int face3 = dice3.getFace();
		return face1 + face2 + face3;
	}

	/**
	 * FUNCTION TO check if a bunco occured
	 * 
	 * @return true if bunco otherwise false
	 */
	public static boolean isABunco(int round, int f1, int f2, int f3) {
		if ((f1 == round) && (f2 == round) && (f3 == round))
			return true;
		else
			return false;

	}

	/**
	 * FUNCTION TO check if a MiniBunco occured
	 * 
	 * @return true if MiniBunco otherwise false
	 */

	public static boolean isAMiniBunco(int f1, int f2, int f3) {
		if ((f1 == 1) && (f2 == 1) && (f3 == 1))
			return true;
		else
			return false;
	}

	/**
	 * FUNCTION TO return round over state
	 * 
	 * @return round concluded or not
	 */

	public boolean isRoundOver() {
		return conclude_round;
	}

	/**
	 * FUNCTION TO set the conclude state to given state
	 * 
	 * 
	 */
	public void setConclude(boolean state) {
		conclude_round = state;

	}

	/**
	 * FUNCTION TO start the roll for the player
	 * 
	 * 
	 */
	public void playerStart() {
		repeat = true;
	}

	/**
	 * FUNCTION TO return the state if player continues
	 * 
	 * @return true if player continues otherwise false
	 */

	public boolean doesPlayerContinue() {
		return repeat;
	}

	/**
	 * FUNCTION TO play a round for the player
	 * 
	 * @return score for the round
	 */

	public int playRound(int round) {
		int score = 0;
		int d1 = dice1.getFace();
		int d2 = dice2.getFace();
		int d3 = dice3.getFace();
		repeat = false;

		System.out.println("Dice rolled: " + d1 + " " + d2 + " " + d3);

		if (d1 == round) {
			score++;
			repeat = true;
		}

		if (d2 == round) {
			score++;
			repeat = true;
		}

		if (d3 == round) {
			score++;
			repeat = true;
		}

		if (isABunco(round, d1, d2, d3)) {
			System.out.println("Bunco!");
			score = score + 21;
			repeat = false;
			conclude_round = true;
		}

		else if (isAMiniBunco(d1, d2, d3)) {
			System.out.println("Mini Bunco!");
			score = score + 5;
		}

		return score;
	}

}
