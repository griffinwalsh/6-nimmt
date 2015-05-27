
import dbConnect.DBConnect;
import nimmt.game.Game;
import nimmt.player.Player;


public class main {



	public static void main(String[] args) {
		DBConnect connect = new DBConnect();
		
		Game.initGame();
		
		//run the game
		Game.go();
		
		//put final score in console
		Game.score();
		}

	}
