// Name : Deepit Chandgothia, 
// Project: Bunco Game

import java.util.Scanner;

/**
 * A class for simulating the Bunco game
 * 
 * @author Deepit Chandgothia
 */

public class BuncoTester {

	/**
	 * FUNCTION TO display wekcome message
	 * 
	 * 
	 */
	public static void welcome() { // PRINTS THE WELCOME ADDRESS
		System.out.println("-------- This is Bunco! -------------");

		System.out.println("------- GET READY TO PLAY! ----------\n RULES \n\n");

		System.out.println(
				"Points are scored by rolling the same number as the round you are in with the dice. In Round 1, the player is hoping to roll ones.");

		System.out.println("Round 1 = ones");

		System.out.println("Round 2 = twos");

		System.out.println("Round 6 = sixes");

		System.out.println(
				"Each die that a player rolls in line with the corresponding round is worth one point and the player can continue rolling in the same Round.");

		System.out.println("For example:");

		System.out.println(
				"If the player is playing Round 2 and rolls 2-3-6; the player scored one point and continues rolling in Round 2.");
		System.out.println("If the player rolls 2-3-2; the player scores two points and continues rolling in Round 2.");
		System.out.println(
				"If a player rolls all three dice so that they match the corresponding round number (i.e. in Round 2, they roll all 2s) it is known as a “Bunco”, and the round is over (even if other players have not rolled in the round). Rolling a bunco is worth 21 points.");
		System.out.println(
				"If a player rolls three ones in a different round, it is known as a “mini Bunco”. It is not a “Bunco” but it is still worth five points and the player continues rolling. When all players finish a round (meaning all of them have rolled on a specific Round), the round is over.");
		System.out.println(
				"If the player is playing Round 2 and rolls 1-3-5, since the player did not roll any 2s, that player stops rolling and passes the turn to the other player.");
		System.out.println("The winner of the game is the one that scores the highest total after 6 Rounds.");

	}

	/**
	 * main function
	 * 
	 * Prints all the results on console
	 */
	public static void main(String[] args) {

		welcome();
		Scanner grin = null;
		// asks user for their name and then assigns it to player name
		System.out.println("Before we start, what is your name? ");
		try {
			grin = new Scanner(System.in);
			String player_name = null;
			String response = null;
			int games = 0;
			int wins = 0;

			if (grin.hasNext()) {
				player_name = grin.nextLine();
			}

			System.out.println("Welcome " + player_name);

			boolean continuePlaying = true;
			while (continuePlaying) {

				System.out.print("Do you want to play a game (yes or no)? ");

				if (grin.hasNext()) { // used has next to avoid some exceptions
					response = grin.nextLine();

					if (response.equalsIgnoreCase("yes")) {
						BuncoGame game = new BuncoGame(player_name);
						games++;
						if (game.playGame()) {
							wins++;
							System.out.println("You won!");
						} else
							System.out.println("Sorry, you Lost!\n");

						System.out.println("You played " + games + " games.");
						System.out.println("You won " + wins + " games.\n");

					} else
						continuePlaying = false;

				}
			}

			// NOW WE PRINT THE FINAL RESULT OF ALL GAMES

			System.out.println("Thank you for playing!");

		} catch (Exception ioe) { // TRY CATCH FOR SCANNER
			System.err.println(ioe);
		} finally {
			if (grin != null) // CLOSES SCANNER
				grin.close();
		}

	}
}
