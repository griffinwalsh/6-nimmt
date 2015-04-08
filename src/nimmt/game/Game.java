package nimmt.game;

import java.util.ArrayList;
import java.util.Collections;

import nimmt.card.Card;
import nimmt.player.Player;

public class Game {
	
	public static int numOfPlayers = 5;	
	public static int numOfRows = 4;
	public static int handSize = 10;
	public static int deckSize = 104;
	
	public static Card card = new Card();
	public static ArrayList<Card> deck = new ArrayList<Card>();
	public static Player[] playerArray = new Player[numOfPlayers];
	public static ArrayList<ArrayList<Card>> rowArray = new ArrayList<ArrayList<Card>>(4);
	public static ArrayList<Card> row = new ArrayList<Card>();
	
	public static void CreateDeck() {
		for (int i = 0 ; i < deckSize ; i++) {
			System.out.println("Card " + (i+1) + " has been created");
				// Creates 104 cards and sets the card number and point value			
			Card card = new Card();
			deck.add(card);
			card.setCardValues(i+1);
			}
			// Shuffles the deck (Randomises cards placement in ArrayList<> deck)
		Collections.shuffle(deck);	
		System.out.println("-----Deck has been created and shuffled-----");
	}
	
	public static void CreatePlayers() {
		for (int i = 0 ; i < numOfPlayers ; i++) {
			playerArray[i] = new Player();
			playerArray[i].setPlayerID(i+1);
			System.out.println("Player " + (i+1) + " has been created");
		}
	}
	
	public static void Deal() {
		for (int i = 0 ; i < playerArray.length ; i++) {
			System.out.println("Dealing cards to player " + (i+1));
			for (int q = 0 ; q < handSize ; q++) {
				Card card = deck.get(0);
				playerArray[i].takeCard(card);
				deck.remove(0);
			}
		
		}
		
	}

	public static void CreateRows() {
		for (int i = 0 ; i < numOfRows ; i++) {
			ArrayList<Card> row = new ArrayList<Card>();
			Card card = deck.get(0);
			row.add(card);
			deck.remove(0);
			System.out.println("giving card " + card.getCardID() + " to row " + (i+1));
			rowArray.add(row);
			System.out.println("row " + (i+1) + " added to row array");
			
		}
	}
	
	public static void score() {
		for (int i = 0 ; i < numOfPlayers ; i++) {
			playerArray[i].getPoints();
			
		}
	}
}
