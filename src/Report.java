

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Report
 */
@WebServlet("/Report")
public class Report extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Report() {
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
		
		
		String sqlUrl="jdbc:mysql://localhost:3306/customer?useSSL=false";
		String sqlUser="root";
		String sqlPass="root";
		
		HttpSession session=request.getSession();
		String uname=session.getAttribute("name").toString();
		String repsub=request.getParameter("subj");
		String desp=request.getParameter("detl");
		
		try {
			Class.forName("com.mysql.jdbc.Driver"); 
			Connection myConn=DriverManager.getConnection(sqlUrl,sqlUser,sqlPass);
			PreparedStatement ps=myConn.prepareStatement("INSERT INTO report (username,subject,details) values(?,?,?)");
			ps.setString(1,uname);
			ps.setString(2,repsub);
			ps.setString(3,desp);
			ps.executeUpdate();
			System.out.println("Entry of report was sucessful.");
			response.sendRedirect("http://localhost:8000/OCRP/WelcomeUser.jsp");
		}
		catch(Exception exc) {
			exc.printStackTrace();
			System.out.println("Failed to add the report.");
		}
		
	}
}
