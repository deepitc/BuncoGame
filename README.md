# BuncoGame

The Bunco game project is a fully functional, simplified version of the dice game Bunco. In this project, two players (one user and one computer) can play against each other at a single table. The game consists of six rounds, numbered from one to six in the order they are played. Each player takes turns rolling three dice, and the objective is to roll the same number as the current round. For example, in Round 1, the player will be hoping to roll ones.

The rules of the game are as follows:

Points are scored by rolling the same number as the current round with the dice.
Each die that a player rolls that matches the corresponding round is worth one point, and the player can continue rolling in the same round.
If a player rolls all three dice so that they match the corresponding round number (i.e. in Round 2, they roll all 2s), it is known as a "Bunco" and the round is over (even if other players have not yet rolled in the round). Rolling a bunco is worth 21 points.
If a player rolls three ones in a different round, it is known as a "mini Bunco". It is not a "Bunco", but it is still worth five points and the player continues rolling.
If the player is playing a round and does not roll any dice that match the corresponding round number, that player stops rolling and passes the turn to the other player.
When all players finish a round (i.e. all of them have rolled on a specific round), the round is over.
The winner of the game is the player with the highest total score after six rounds.
The project consists of several classes, including BuncoGame, Dice, Dice cup/box, and Player. The Player class has a player's name, which is assigned in the constructor. The default name is "Computer" if no name is specified at the Player instantiation time. The project also includes several methods, including isABunco, isAMiniBunco, playRound (which plays a round for the current player), and roll.

To start the game, the program asks the user for their name and creates a BuncoGame with two players and one dice cup with three dice. To decide which player goes first, each player rolls the dice, and the one with the higher running total starts Round 1. The program then prints out all the information related to each turn, roll, round, and game in the console. Every time the user must roll the dice, they are prompted to press RETURN to roll the dice and continue with the game.

After the game is finished, the program prints out the information for the current winner and the statistics showing the number of total games played so far, and the times each player won a game. Finally, the program asks the user whether they want to play again or not.
