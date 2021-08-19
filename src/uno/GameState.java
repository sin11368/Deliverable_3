package uno;


import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class GameState {
	private static final String[] COLORS = {"red", "blue", "green", "yellow"};
	private static final int COLOR_SIZE = 10;
	private static final int START_HAND_SIZE = 7;

	private GroupOfCards deck;
	private int deckLimit;

	private GroupOfCards onTable;
	private List<GroupOfCards> playerHands;

	private int playersNum;
	private int currPlayer;
	private boolean skipAvailable;

	public GameState(int n) {
		playersNum = n;
		deckLimit = COLORS.length * COLOR_SIZE;
		deck = new GroupOfCards(deckLimit);

		for (String color : COLORS) {
			for (int j = 0; j <= 10; j++) {
				deck.add(new Card(color, j));
			}
		}
		deck.shuffle();
		onTable = new GroupOfCards(deckLimit);

		playerHands = new ArrayList<>();
		for (int i = 0; i<playersNum; i++) {
			GroupOfCards playerHand = new GroupOfCards(deckLimit);
			for (int j = 0; j<START_HAND_SIZE; j++) {
				playerHand.add(deck.remove(0));
			}
			playerHands.add(playerHand);
		}

		onTable.add(deck.remove(0));

		currPlayer = 0;
		skipAvailable = true;
	}

	public Card getDeckCard() {
		return onTable.getTop();
	}

	public int getCurrPlayer() {
		return currPlayer;
	}

	public boolean makeMove(int player, int choice) {
		GroupOfCards playerHand = playerHands.get(player);
		boolean isNext = false;
		if (choice >= 0 && choice < playerHand.getCards().size()) {
			Card removed = playerHand.remove(choice);
			if (removed.matches(getDeckCard())) {
				onTable.add(removed);
				isNext = true;
			}
			else {
				playerHand.add(removed);
				throw new IllegalArgumentException();
			}
		}
		else {
			if (skipAvailable) {
				if (deck.getCards().isEmpty()) {
					Card topCard = onTable.remove(0);
					Card next = onTable.remove(0);
					while (next != null) {
						deck.add(next);
						next = onTable.remove(0);
					}
					deck.shuffle();
					onTable.add(topCard);
				}
				playerHand.add(deck.remove(0));
				skipAvailable = false;
			}
			else {
				isNext = true;
			}
		}

		if (isNext) {
			if (playerHand.getTop() == null) {
				return true;
			}
			skipAvailable = true;
			currPlayer = (currPlayer + 1) % playersNum;
		}
		return false;
	}

	public String getPlayerOptions(int player) {
		GroupOfCards playerHand = playerHands.get(player);
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i<playerHand.getCards().size(); i++) {
			builder.append(MessageFormat.format("{0}. {1}", i, playerHand.getCards().get(i))).append(System.lineSeparator());
		}
		builder.append(MessageFormat.format("{0}. Skip", playerHand.getCards().size()));
		return builder.toString();
	}
}
