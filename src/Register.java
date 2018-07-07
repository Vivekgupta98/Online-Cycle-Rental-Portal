

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
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
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
		PrintWriter out= response.getWriter();
		doGet(request, response);
		
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		String fname = request.getParameter("fst_name");
		String lname = request.getParameter("lst_name");
		String email = request.getParameter("eid");
		String phone = request.getParameter("pno");
		String addr = request.getParameter("addr");
		
		User newuser=new User(name);
		if(newuser.checkexist()) {
			System.out.println("Existing username. Login with that account or check some new username");
		}
		else {
			newuser.registernew(name, pass, fname, lname, email, phone, addr);
			if(newuser.getRegister()) {
				System.out.println("Successfully Registered");
				response.sendRedirect("home.jsp");
			}
			else {
				System.out.println("Registration failed!");
				response.sendRedirect("home.jsp");
			}
		}
		
	}

}
