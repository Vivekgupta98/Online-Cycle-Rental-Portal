

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
 * Servlet implementation class Return
 */
@WebServlet("/Return")
public class Return extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Return() {
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
		String owname=request.getParameter("user");
		HttpSession session=request.getSession();
		String name=session.getAttribute("name").toString();
		String sqlUrl="jdbc:mysql://localhost:3306/customer?useSSL=false";
		String sqlUser="root";
		String sqlPass="root";
		try {
			Class.forName("com.mysql.jdbc.Driver"); 
			Connection myConn=DriverManager.getConnection(sqlUrl,sqlUser,sqlPass);
			PreparedStatement ps=myConn.prepareStatement("DELETE FROM user_inride WHERE user = '"+name+"'");
			ps.executeUpdate(); 
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}
		Cycle mycyc=new Cycle(owname);
		mycyc.toggleinride();
		session.setAttribute("inRide", "No");
		response.sendRedirect("WelcomeUser.jsp");
	}

}
