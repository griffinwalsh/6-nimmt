package nimmt.row;

import java.util.ArrayList;

import nimmt.card.Card;

public class Row {
 
	
	public Card card = new Card();
	public ArrayList<Card> CardsInRow = new ArrayList<Card>();
	public int pointValue;
	public int rowPointValue;
	
	public void PlayCard(Card card) {
		if (CardsInRow.size()>6) {
			this.card = card;
			CardsInRow.add(card);
		} else {
			for (int i = 0 ; i < 6 ; i++) {
				card = CardsInRow.get(0);
				pointValue = card.getPointValue();
				rowPointValue += pointValue;
			}
		}
		
	}
		
}
