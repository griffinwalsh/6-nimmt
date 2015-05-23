package dbConnect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class DBConnect {

	
	
	private static Connection con;
	private static Statement st;
	private static ResultSet rs;
	public int GameID=0;
	public int GameInterest=0;
	public int TurnID=0;
	public int TurnInterest=0;
	
	public DBConnect() {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/nimmt","root","");
			st = con.createStatement();
			
			
		}catch(Exception ex) {
			System.out.println("Error: "+ex);
		}
	}
	
	public static void addDataToGameIndex(int gameID, int gameInterest, int turnID, int turnInterest) {
		
		try{
			
			String sql =  "INSERT INTO `gameindex` (`GameID`, `GameInterest`, `TurnID`, `TurnInterest`) VALUES ("+gameID+","+gameInterest+","+turnID+","+turnInterest+")";
			st.executeUpdate(sql);		
					
			
		
			
		}catch(Exception ex) {
			System.out.println("Error: "+ex);
		}
	}

	public static void addDataToPlayData(int gameID, int turnID, int playerID, int cardID, int success, int interest) {
		try{
					
			String sql =  "INSERT INTO `playdata` (`GameID`, `TurnID`, `PlayerID`, `CardID`, `Success`, `Interest`) VALUES ("+gameID+","+turnID+","+playerID+","+cardID+","+success+","+interest+")";
			st.executeUpdate(sql);		
							
					
				
					
		}catch(Exception ex) {
			System.out.println("Error: "+ex);
		}
	}

	public static void addDatatoFactData(int gameID, int turnID, String classifier, int value, String location){
		try{
			
			String sql =  "INSERT INTO `factdata` (`GameID`, `TurnID`, `Classifier`, `Value`, `Location`) VALUES ("+gameID+","+turnID+","+classifier+","+value+","+location+")";
			st.executeUpdate(sql);		
							
					
				
					
		}catch(Exception ex) {
			System.out.println("Error: "+ex);
		}
	}
}








