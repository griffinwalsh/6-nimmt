package nimmt.game;



import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import dbConnect.DBConnect;
import nimmt.card.Card;
import nimmt.player.Player;
import nimmt.row.Row;

public class Game {
	
	public static int numOfPlayers = 5;	
	public static int numOfRows = 4;
	public static int handSize = 10;
	public static int deckSize = 104;
	public static int numDataObjects = 0;
	
	
	public static Card card = new Card();	
	public static Row row = new Row();
	public static ArrayList<Card> deck = new ArrayList<Card>();
	public static Player[] playerArray = new Player[numOfPlayers];
	public static Row[] rowArray = new Row[numOfRows];
	public static ArrayList<Card> cardArray = new ArrayList<Card>();
	public static int[] lastCardIDs = new int[numOfRows];
	
	public static int rCardValue = 0;
	public static int pCardValue = 0;
	
	public static int gameInterest =7;
	public static int turnInterest =1;
	public static int playInterest = 1;
	
	
	public static void createDeck() {
		for (int i = 0 ; i < deckSize ; i++) {
			System.out.println("Card " + (i+1) + " has been created");
				// Creates 104 cards and sets the card number and point value			
			Card card = new Card();
			deck.add(card);
			card.setCardValues(i+1);
			}
			// Shuffles the deck (Randomizes cards placement in ArrayList<> deck)
		Collections.shuffle(deck);	
		System.out.println("-----Deck has been created and shuffled-----");
		
	}
	
	public static void createPlayers() {
		for (int i = 0 ; i < numOfPlayers ; i++) {
			playerArray[i] = new Player();
			playerArray[i].setPlayerID(i);
			;
		}
		
	}
	
	public static void deal() {
		for (int i = 0 ; i < playerArray.length ; i++) {
			System.out.println("Dealing cards to player " + (i));
			for (int q = 0 ; q < handSize ; q++) {
				Card card = deck.get(0);
				playerArray[i].takeCard(card);
				deck.remove(0);
			}
			
		}
		numDataObjects++;
		System.out.println("numDataObjects = "+numDataObjects);		
	}
	
	public static void createRows() {
		for (int i = 0 ; i < numOfRows ; i++) {
			rowArray[i] = new Row();
			int rowID = (i);
			rowArray[i].setRowID(rowID);
			System.out.println("row " + (i) + " added to row array");
			
		}	
		for (int i = 0 ; i < numOfRows ; i++) {	
			Card card = deck.get(0);
			rowArray[i].takeCard(card);
			deck.remove(0);
			
		}
	}
	
	public static void go() {
		int currentBestValue = 0;
		int currentBestRow=10 ;
		int currentLowestCard = 1+deckSize;
		int currentLowestCardsRow = 0;
		int cardValue;
		
		for(int i = 0 ; i < handSize ; i++) {
			for (int q = 0 ; q < playerArray.length ; q++) {
				playerArray[q].playCard();
				
			}	
			
			for (int q = 0 ; q < playerArray.length ; q++) {
				for (int k = 0 ; k < cardArray.size() ; k++) {
					Card card = cardArray.get(k);
					cardValue = card.getCardID();
					if(cardValue<currentLowestCard){
						currentLowestCardsRow = k;
						currentLowestCard = cardValue;
					}
				}
				currentLowestCard = (deckSize+1);
				card = cardArray.get(currentLowestCardsRow);
				cardArray.remove(currentLowestCardsRow);
				pCardValue = card.getCardID();
				
				for (int j = 0 ; j < rowArray.length ; j++) {
					
					Card rowCard = rowArray[j].getLastCard();
					rCardValue = rowCard.getCardID();
					
					if (pCardValue > rCardValue) {
						if (rCardValue > currentBestValue) {
						currentBestValue = rCardValue;
						currentBestRow = j;
						}
					}
				}
				if (currentBestRow == 10) {
					currentBestRow = playerArray[q].pickRowTake();
					rowArray[currentBestRow].replaceRow(card);
				} else {
					rowArray[currentBestRow].takeCard(card);
					currentBestValue = 0;
				}
				
				DBConnect.addDataToPlayData(1,i,card.getOwner(),card.getCardID(),1,1 );
				
			}
			Game.addDataToFactData(i);
			DBConnect.addDataToGameIndex(1,gameInterest,i,turnInterest);
			}	
		
		}
	
	public static void score() {
		for (int i = 0 ; i < numOfPlayers ; i++) {
			int points = playerArray[i].getPoints();
			System.out.println("Player " + i + " got " + points + " points");
			
		}
	}

	public static void rowFull() {
		
	}
	
	public static void addDataToFactData(int i) {
		
		Random rand = new Random();

		int  randNum;
		numDataObjects=3+2*rowArray.length;
		for (int a = 0 ; a < rowArray.length ; a++) {
			for (int b = 0 ; b < rowArray[a].getNumCards() ; b++) {
				numDataObjects+=2;
			}
		}
		
		for (int q = 0 ; q < rowArray.length ; q++) {
			 
			randNum = rand.nextInt(numDataObjects) + 1; if (randNum <= gameInterest) { DBConnect.addDatatoFactData(1, i, "\"NumCards\"", rowArray[q].getNumCards(), "\"R"+q+"\"");}
			randNum = rand.nextInt(numDataObjects) + 1; if (randNum <= gameInterest) { DBConnect.addDatatoFactData(1, i, "\"PointValue\"", rowArray[q].getPointValue() , "\"R"+q+"\"");}
			for (int p = 0 ; p < rowArray[q].getNumCards() ; p++) {
				Card recordCard = rowArray[q].getCard(p);
				randNum = rand.nextInt(numDataObjects) + 1; if (randNum <= gameInterest) {DBConnect.addDatatoFactData(1,i,"\"CardID\"",recordCard.getCardID(),"\"C"+p+"R"+q+"\"");}
				randNum = rand.nextInt(numDataObjects) + 1; if (randNum <= gameInterest) {DBConnect.addDatatoFactData(1,i,"\"PointValue\"",recordCard.getPointValue(),"\"C"+p+"R"+q+"\"");}
			}
		}
		randNum = rand.nextInt(numDataObjects) + 1; if (randNum <= gameInterest) {DBConnect.addDatatoFactData(1, i, "\"NumPlayers\"", numOfPlayers, "\"G\"");}
		randNum = rand.nextInt(numDataObjects) + 1; if (randNum <= gameInterest) {DBConnect.addDatatoFactData(1, i, "\"NumCards\"", 9-i, "\"H\"");}
		randNum = rand.nextInt(numDataObjects) + 1; if (randNum <= gameInterest) {DBConnect.addDatatoFactData(1, i, "\"NumCards\"", deck.size(), "\"D\"");}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public static void cardToRow(int i) {
		Card card = deck.get(0);
		rowArray[i].takeCard(card);
		deck.remove(0);
	}
	public static void givePlayerPoints(int player,int points){
		
	}
	
	public static void cardsToGame(Card newCard) {
		cardArray.add(newCard);
	}
	public static Player[] getPlayerArray() {
		return playerArray;
	}
	public static void setPlayerArray(Player[] newPlayerArray) {
		playerArray = newPlayerArray;
	}
	public static Row[] getRowArray() {
		return rowArray;
	}
	public static void setRowArray(Row[] newRowArray) {
		rowArray = newRowArray;
	}
	
}








































