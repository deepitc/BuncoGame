/**
 * A class to generate a player
 * 
 * @author Deepit Chandgothia
 */

public class Player {

	private String player_name;

	// default constructor
	public Player() {
		player_name = "Computer";
	}

	// constructor when given a name
	public Player(String name) {
		player_name = name;

	}

	/**
	 * FUNCTION TO return player name
	 * 
	 * @return the name of the player
	 */
	public String getPlayerName() {
		return player_name;
	}

}
