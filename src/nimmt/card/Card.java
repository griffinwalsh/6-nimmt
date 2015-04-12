package nimmt.card;


public class Card {

	public int cardID=0;
	public int pointValue=0;
	public int owner=2;
	
		// get the cardID
	public int getCardID() {
		return cardID;	
		}
	
		//get the pointValue
	public int getPointValue() {
		return pointValue;
	}
	
		//set the cardID and pointValue
	public void setCardValues(int cardID) {
		this.cardID = cardID;
		if ( cardID % 5 == 0) {	
			this.pointValue += 2;
		} if ( cardID % 10 == 0) {	
			this.pointValue += 1;
		} if ( cardID % 11 == 0) {	
			this.pointValue += 5;
		} if (pointValue == 0)
			this.pointValue = 1;
		System.out.println("PointValue is " + pointValue);
		}


	public int getOwner() {
		return owner;
	}
	public void setOwner(int owner) {
		this.owner = owner;
		System.out.println("Card " + cardID + "'s owner has been set to " + owner);
	}









}
