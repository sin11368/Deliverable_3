package uno;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Gurveer
 */
public class Uno {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter number of players:");
		int n = scanner.nextInt();

		//array player
		ArrayList<Player> player = new ArrayList<>();
		for (int j = 0; j < n; j++) {
			System.out.println("\nEnter " + Integer.parseInt(String.valueOf(j + 1)) + " player name:");
			String s = scanner.next();
			player.add(new Player(s));


		}
		Game game = new Game("UNO");

		game.setPlayers(player);

		System.out.println("\nWant to start the game? the press 'yes' or 'no'");
		String startgame = scanner.next();
		System.out.println("\n");

		if (startgame.toLowerCase().equals("yes")) {
			String playerwins;
			GameState gameState = new GameState(n);
			int currentPlayer = 0;
			int input;
			boolean isOver = false;
			while(!isOver) {
				currentPlayer = gameState.getCurrPlayer();
				System.out.println(gameState.getPlayerOptions(currentPlayer));
				System.out.println("\n");
				System.out.println("Deck Card - " + gameState.getDeckCard());
				System.out.println("\n" + game.getPlayers().get(currentPlayer).getName() + " please choose your card from above.");
				input = scanner.nextInt();
				System.out.println("\n");
				try {
					isOver = gameState.makeMove(currentPlayer, input);
				} catch (IllegalArgumentException e) {
					System.out.println("Invalid move play again\n");
				}
			}
			playerwins = game.getPlayers().get(currentPlayer).getName();
			System.out.println("Congratulations!!!!!! The WINNER is " + playerwins);
		} else {
			return;
		}
	}

}

