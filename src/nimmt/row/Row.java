package nimmt.row;

import java.util.ArrayList;

import nimmt.card.Card;
import nimmt.game.Game;
import nimmt.player.Player;

public class Row {
 
	
	public Card card = new Card();
	public ArrayList<Card> cardsInRow = new ArrayList<Card>();
	public int pointValue;
	public int rowPointValue;
	public int rowID;
	public int owner=2;
	public Player[] playerArray = new Player[5];
	
	public void takeCard(Card card) {
		
			this.card = card;
			cardsInRow.add(card);
			System.out.println("card " + card.getCardID() + " given to row " + rowID + " in spot " + cardsInRow.size());
			if (cardsInRow.size()==6) {
				for (int i = 0 ; i < 6 ; i++) {
					Card pointCard = cardsInRow.get(i);
					pointValue = pointCard.getPointValue();
					rowPointValue += pointValue;
					
				}
				playerArray = Game.getPlayerArray();
				owner = card.getOwner();
				System.out.println(owner + " " + card.getOwner());
				playerArray[owner].addPoints(rowPointValue);
				Game.setPlayerArray(playerArray);
				clearRow();
				Game.cardToRow(rowID);
				
			}
		
	}
	
	
	
	
	
	
	public void clearRow() {
		  this.cardsInRow = new ArrayList<Card>();
		  rowPointValue = 0;
	}
	
	
	
	
	
	
	
	
	
	public Card getLastCard() {
		Card card = this.cardsInRow.get(cardsInRow.size()-1);
		return card;
	}
		//get the pointValue
	public int getRowID() {
		return pointValue;
	}	
	public void setRowID(int rowID) {
		this.rowID = rowID;
	}
	public Player[] getPlayerArray() {
		return playerArray;
	}
	public void setPlayerArray(Player[] playerArray) {
		this.playerArray = playerArray;
	}







}

