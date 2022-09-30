import java.util.Scanner;

/**
 * A class for playing Bunco Game
 * 
 * @author Deepit Chandgothia
 */
public class BuncoGame {

	private Player user;
	private Player computer;
	private Player player1;
	private Player player2;
	private int round;
	private DiceBox box;

	/**
	 * Constructor
	 * 
	 * 
	 */
	public BuncoGame(String name) {
		user = new Player(name);
		computer = new Player();
		round = 0;

		box = new DiceBox(); // creates new dicebox for rolls

		System.out.println("You will be playing against " + computer.getPlayerName() + ".");

	}

	/**
	 * FUNCTION TO DECIDE WHO GOES FIRST
	 * 
	 * @return the player who goes first.
	 */
	public Player getstartingPlayer() { // FUNCTION TO DECIDE WHO GOES FIRST
		int p1 = box.roll(); // COMPUTER GETS ADVANTAGE ON A TIE
		int p2 = box.roll();

		if (p1 > p2) {
			player1 = user;
			player2 = computer;
		} else {
			player1 = computer;
			player2 = user;
		}
		System.out.print("------- ROLL FOR WHO WILL START --------\n");
		System.out.print(user.getPlayerName() + " rolled ");
		System.out.println(p1);
		System.out.print(computer.getPlayerName() + " rolled ");
		System.out.println(p2);
		System.out.println(player1.getPlayerName() + " goes first.");

		return player1;
	}

	/**
	 * FUNCTION TO play a round
	 * 
	 * @return the score of the round
	 */

	public int playRound(boolean pauses) {
		Scanner continuer = new Scanner(System.in);
		box.setConclude(false);
		box.playerStart();
		int score = 0;
		while (box.doesPlayerContinue()) {
			if (pauses && box.doesPlayerContinue()) {
				System.out.println("Your roll. Press 'RETURN' to continue.");
				String response = continuer.nextLine(); // used to take input from user to continue

				if (response.equalsIgnoreCase("no")) {
					System.out.println("You have decided to exit the game, have  a great day!");
					continuer.close();
					System.exit(0);
				}

			}
			score += box.playRound(round);
		}
		return score;

	}

	/**
	 * FUNCTION TO play an entire game of bunco
	 * 
	 * @return true if user wins otherwise false
	 */

	public boolean playGame() { // MOST IMPORTANT FUNCTION TO PLAY THE GAME WHICH CALLS EVERYTHING
		int total_first = 0;
		int total_second = 0;
		Player winner = null;
		this.getstartingPlayer();
		for (int i = 1; i <= 6; i++) {
			round = i;
			System.out.println("--------------------------\n");
			System.out.println("-------- ROUND  " + round + " --------\n");
			System.out.println("--------------------------\n");

			if (player1.equals(user)) // PLAYER ONE STARTS PLAYING
				total_first += this.playRound(true);
			else
				total_first += this.playRound(false);
			System.out.println("Round " + round + " for " + player1.getPlayerName() + ": " + total_first + "\n");

			if (player2.equals(user)) // PLAYER TWO STARTS PLAYING
				total_second += this.playRound(true);
			else
				total_second += this.playRound(false);
			System.out.println("Round " + round + " for " + player2.getPlayerName() + ": " + total_second + "\n");
		}

		if (total_first > total_second)
			winner = player1;
		else
			winner = player2;

		if (winner.equals(user) && total_first != total_second) // COMPUTER WINS IF ITS A TIE
			return true;
		else
			return false;

	}
}
