

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;


/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		HttpSession session = request.getSession();
		session.setAttribute("islogin", "0");
		PrintWriter out= response.getWriter();
		doGet(request, response);
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		Authentication mylogin=new Authentication();
		if(mylogin.login_auth(name,pass)==1) {
			session.setAttribute("name", name);
			session.setAttribute("islogin", "1");
			User user=new User(name);
			if(user.inride()) {
				session.setAttribute("inRide", "Yes");
			}
			else {
				session.setAttribute("inRide", "No");
			}
			session.setAttribute("user", user.getOwner());
			System.out.println(user.getOwner());
			response.sendRedirect("WelcomeUser.jsp");
		}
		else {
			out.println("Wrong Username or password.");
			response.sendRedirect("home.jsp");
		}
	}

}
