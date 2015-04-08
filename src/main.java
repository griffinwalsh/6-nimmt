
import nimmt.game.Game;
import nimmt.player.Player;


public class main {



	public static void main(String[] args) {
	
		//creates the deck
		Game.CreateDeck();
		
		//creates the players
		Game.CreatePlayers();
		
		//give each player a hand and put one card in all four starting rows
		Game.Deal();
		
		//creates the rows and puts the first card in those rows
		Game.CreateRows();
					
//		Player.takeAction();
		}

	}
