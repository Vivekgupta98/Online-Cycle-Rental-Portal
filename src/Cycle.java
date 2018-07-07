import java.sql.*;

public class Cycle {
	String name,cid,ctype,hall,avail,inride;
	String sqlUrl="jdbc:mysql://localhost:3306/cycle?useSSL=false";
	String sqlUser="root";
	String sqlPass="root";
	public Cycle() {
		// TODO Auto-generated constructor stub
	}
	public Cycle(String user) {
		name=user;
	}
	public boolean check() {
		try {
			Class.forName("com.mysql.jdbc.Driver"); 
			Connection myConn=DriverManager.getConnection(sqlUrl,sqlUser,sqlPass);
			Statement myStmt =  myConn.createStatement();
			ResultSet myRs=myStmt.executeQuery("select * from cycle_data where username = '"+name+"'");
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
	
	public void getRegister(String name,String cid,String ctype,String hall,String avail) {
		this.name=name;
		this.cid=cid;
		this.ctype=ctype;
		this.hall=hall;
		this.avail=avail;
		this.inride="NO";
	}
	
	public void getall() {
		try {
			Class.forName("com.mysql.jdbc.Driver"); 
			Connection myConn=DriverManager.getConnection(sqlUrl,sqlUser,sqlPass);
			Statement myStmt =  myConn.createStatement();
			ResultSet myRs=myStmt.executeQuery("select * from cycle_data where username = '"+name+"'");
			if(myRs.next()) {
				cid=myRs.getString("cycleid");
				ctype=myRs.getString("cycletype");
				hall=myRs.getString("hallname");
				avail=myRs.getString("avail");
				inride=myRs.getString("inride");
			}
			else {
				
			}
		}		
		catch(Exception exc) {
			exc.printStackTrace();
		}
	}
	
	public boolean getRegister() {
		try {
			Class.forName("com.mysql.jdbc.Driver"); 
			Connection myConn=DriverManager.getConnection(sqlUrl,sqlUser,sqlPass);
			PreparedStatement ps=myConn.prepareStatement("INSERT INTO cycle_data (username,cycleid,cycletype,hallname,avail,inride) values(?,?,?,?,?,?)");
			ps.setString(1,name);
			ps.setString(2,cid);
			ps.setString(3,ctype);
			ps.setString(4,hall);
			ps.setString(5,avail);
			ps.setString(6,inride);
			ps.executeUpdate();  
			return true;
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}
		return false;
	}
	public boolean remove() {
		//if(inride.equals("YES")) {System.out.println("In ride, Can't Delete");;return false;}
		try {
			Class.forName("com.mysql.jdbc.Driver"); 
			Connection myConn=DriverManager.getConnection(sqlUrl,sqlUser,sqlPass);
			PreparedStatement ps=myConn.prepareStatement("DELETE FROM cycle_data WHERE username = '"+name+"'");
			ps.executeUpdate(); 
			return true;
		}
		catch(Exception exc) {
			exc.printStackTrace();
			return false;
		}		
	}
	
	public boolean toggle() {
		getall();
		if(this.avail.equals("NO")) {this.avail="YES";}
		else {this.avail="NO";}
		remove();
		return getRegister();
	}
	public boolean toggleinride() {
		getall();
		if(this.inride.equals("NO")) {this.inride="YES";}
		else {this.inride="NO";}
		remove();
		return getRegister();
	}
}
