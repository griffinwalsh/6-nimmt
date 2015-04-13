
import nimmt.game.Game;
import nimmt.player.Player;


public class main {



	public static void main(String[] args) {
	
		//creates the deck
		Game.createDeck();
		
		//creates the players
		Game.createPlayers();
		
		//give each player a hand and put one card in all four starting rows
		Game.deal();
		
		//creates the rows and puts the first card in those rows
		Game.createRows();
		
		//run the game
		Game.go();
		
		//put final score in console
		Game.score();
		}

	}
