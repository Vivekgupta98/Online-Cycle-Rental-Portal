
import java.sql.*;

public class demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String urlString="jdbc:mysql://localhost:3306/demo?useSSL=false";
			String user ="root";
			String pass="root";
			//Get a connection to database
			Connection myConn= DriverManager.getConnection(urlString,user,pass);
			
			//create a statement
			Statement myStmt =  myConn.createStatement();
			//Execute SQL 
			ResultSet myRs=myStmt.executeQuery("select * from new_table");
			//Proess result
			while(myRs.next()) {
				System.out.println(myRs.getString("name")+", "+myRs.getString("user"));
			}
		}	
		catch(Exception exc) {
			exc.printStackTrace();
		}
	}
}
