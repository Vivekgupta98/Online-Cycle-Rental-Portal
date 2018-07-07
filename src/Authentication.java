import java.sql.*;

public class Authentication {
	
	static String sqlUrl;
	static String sqlUser;
	static String sqlPass;
	
	public Authentication() {
		sqlUrl="jdbc:mysql://localhost:3306/customer?useSSL=false";
		sqlUser="root";
		sqlPass="root";
	}
	
	int login_auth(String Username,String Password) {
		try {
			Class.forName("com.mysql.jdbc.Driver"); 
			Connection myConn=DriverManager.getConnection(sqlUrl,sqlUser,sqlPass);
			Statement myStmt =  myConn.createStatement();
			ResultSet myRs=myStmt.executeQuery("select * from login_data where username = '"+Username+"'");
			if(myRs.next()) {
				if(myRs.getString("password").compareTo(Password)==0) {
					return 1;//Correct password
				}
				else {
					return -1;//Wrong password
				}
			}
			else {
				return 0;//not registered(Username not found)
			}
		}
		catch(Exception exc){
			exc.printStackTrace();
			return -2;// Something error with sql
		}
		
	}
	
	
}
