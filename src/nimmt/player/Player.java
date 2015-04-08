package nimmt.player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import nimmt.card.Card;

public class Player {
	
	public Card card = new Card();
	public int playerID;
	public static  ArrayList<Card> hand = new ArrayList<Card>();
	public  int cardID;
	public int points;
	
	public static void takeAction() {
		Random r = new Random();
		r.nextInt(4);
		Collections.shuffle(hand);
		Card card = hand.get(0);
		playerArray[i].takeCard(card);
		hand.remove(0);
	}
	
 	public void takeCard(Card card) {
		this.card = card;
		hand.add(card);
		cardID = card.getCardID();
		System.out.println("Player " + playerID + " has taken Card " + cardID);	
	}	
 	

	public int getPlayerID() {
		return playerID;
	}
	public void setPlayerID(int playerID) {
		this.playerID = playerID;
	}	

	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}	
}
