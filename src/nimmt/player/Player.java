package nimmt.player;

import java.util.ArrayList;
import java.util.Collections;





import nimmt.card.Card;
import nimmt.game.Game;
import nimmt.row.Row;

public class Player {
	
	public Card card = new Card();
	public int playerID;
	public  ArrayList<Card> hand = new ArrayList<Card>();
	public int cardID;
	public int points;
	public Row[] rowArray= new Row[4];
	
	public void playCard() {
		if(hand.size()>0) {
			Collections.shuffle(hand);
			Card card = hand.get(0);
			hand.remove(0);		
			Game.cardsToGame(card);
			System.out.println("Player " + playerID + " has played Card " + card.getCardID());
		} else { 
			Game.score();
		}
	}
	
 	public void takeCard(Card card) {
		
		card.setOwner(playerID);
		hand.add(card);
		cardID = card.getCardID();
		System.out.println("Player " + playerID + " has taken Card " + cardID);	
	}
 	
 	public int pickRowTake() {
 		rowArray = Game.getRowArray();
 		int pointValue;
 		int bestPointValue = 1000;
 		int bestRowToTake=5;
 		for (int i = 0 ; i < rowArray.length ; i++) {
			pointValue = rowArray[i].getPoints();
			if(pointValue<bestPointValue) {
				bestRowToTake = i;
				bestPointValue = pointValue;
			}
 		}
 		
 		System.out.println("Player " + playerID + " has chosen row " + bestRowToTake);
 		return bestRowToTake;
 	}	
 	

	public int getPlayerID() {
		return playerID;
	}
	public void setPlayerID(int playerID) {
		this.playerID = playerID;
		System.out.println("Player " + playerID + " has been created");
	}	

	public int getPoints() {
		return points;
	}
	public void addPoints(int newPoints) {
		this.points += newPoints;
		System.out.println("Player " + playerID + " got " + newPoints + " new points and now has " + points + " points" );
	}	
}
