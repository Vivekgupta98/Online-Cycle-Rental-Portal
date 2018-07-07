
import java.sql.*;

public class User {
	private String fname;
	private String lname;
	String username;
	private String password;
	private String email;
	private String phone;
	private String addr;
	String sqlUrl="jdbc:mysql://localhost:3306/customer?useSSL=false";
	String sqlUser="root";
	String sqlPass="root";
	public User() {
		
	}
	
	public User(String uname) {
		username=uname;
	}

	public boolean checkexist() {
		try {
			Class.forName("com.mysql.jdbc.Driver"); 
			Connection myConn=DriverManager.getConnection(sqlUrl,sqlUser,sqlPass);
			Statement myStmt =  myConn.createStatement();
			ResultSet myRs=myStmt.executeQuery("select * from login_data where username = '"+username+"'");
			if(myRs.next()) {
				return true;
			}
			else {
				return false;
			}
		}
		catch(Exception exc) {
			exc.printStackTrace();
			return false;
		}	
	}
	public void registernew(String uname,String pass,String fname,String lname,String email,String phone,String addr) {
		username=uname;
		password=pass;
		this.fname=fname;
		this.lname=lname;
		this.phone=phone;
		this.email=email;
		this.addr=addr;
	}
	public void getall() {
		try {
			Class.forName("com.mysql.jdbc.Driver"); 
			Connection myConn=DriverManager.getConnection(sqlUrl,sqlUser,sqlPass);
			Statement myStmt =  myConn.createStatement();
			ResultSet myRs=myStmt.executeQuery("select * from full_user where username = '"+username+"'");
			if(myRs.next()) {
				password=myRs.getNString("password");
				fname=myRs.getNString("first_name");
				lname=myRs.getNString("last_name");
				email=myRs.getNString("email");
				phone=myRs.getNString("phone");
				addr=myRs.getNString("address");
			}
			else {
				System.out.println("Does not exist in the database!");
			}
		}		
		catch(Exception exc) {
			exc.printStackTrace();
		}	
	}
	public boolean inride() {
		try {
			Class.forName("com.mysql.jdbc.Driver"); 
			Connection myConn=DriverManager.getConnection(sqlUrl,sqlUser,sqlPass);
			Statement myStmt =  myConn.createStatement();
			ResultSet myRs=myStmt.executeQuery("select * from user_inride where user = '"+username+"'");
			if(myRs.next()) {
				return true;
			}
			else {
				return false;
			}
		}
		catch(Exception exc) {
			exc.printStackTrace();
			return false;
		}
	}
	public boolean getRegister() {
		try {
			Class.forName("com.mysql.jdbc.Driver"); 
			Connection myConn=DriverManager.getConnection(sqlUrl,sqlUser,sqlPass);
			PreparedStatement ps=myConn.prepareStatement("INSERT INTO full_user (username,password,first_name,last_name,email,phone,address) values(?,?,?,?,?,?,?)");
			ps.setString(1,username);
			ps.setString(2,password);
			ps.setString(3,fname);
			ps.setString(4,lname);
			ps.setString(5,email);
			ps.setString(6,phone);
			ps.setString(7,addr);
			ps.executeUpdate();   
			ps=myConn.prepareStatement("INSERT INTO login_data (username,password,first_name,last_name) values(?,?,?,?)");
			ps.setString(1,username);
			ps.setString(2,password);
			ps.setString(3,fname);
			ps.setString(4,lname);
			ps.executeUpdate();   
			return true;
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}
		return false;
	}
	public String getOwner() {
		try {
			Class.forName("com.mysql.jdbc.Driver"); 
			Connection myConn=DriverManager.getConnection(sqlUrl,sqlUser,sqlPass);
			Statement myStmt =  myConn.createStatement();
			ResultSet myRs=myStmt.executeQuery("select * from user_inride where user = '"+username+"'");
			if(myRs.next()) {
				return myRs.getString(2);
			}
			else {
				return "No owner";
			}
		}
		catch(Exception exc) {
			exc.printStackTrace();
			return null;
		}
	}
}
