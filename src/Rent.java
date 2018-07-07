

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Rent
 */
@WebServlet("/Rent")
public class Rent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Rent() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String uname=request.getParameter("user").toString();
		HttpSession session=request.getSession();
		String name=session.getAttribute("name").toString();
		
		// name is the username of the user whose cycle the user isrenting
		String sqlUrl="jdbc:mysql://localhost:3306/customer?useSSL=false";
		String sqlUser="root";
		String sqlPass="root";
		String noo="NO";
		try {
			Class.forName("com.mysql.jdbc.Driver"); 
			Connection myConn=DriverManager.getConnection(sqlUrl,sqlUser,sqlPass);
			PreparedStatement ps=myConn.prepareStatement("INSERT INTO user_inride (user,cycleof,retreq) values(?,?,?)");
			ps.setString(1,name);
			ps.setString(2,uname);
			ps.setString(3,noo);
			ps.executeUpdate();
			System.out.println("No Error till now");
			Cycle takencycle=new Cycle(uname);
			takencycle.toggleinride();
			session.setAttribute("inRide", "Yes");
			session.setAttribute("rentfrom", uname);
			response.sendRedirect("http://localhost:8000/OCRP/RentStart.jsp");
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}
		
	}

}
