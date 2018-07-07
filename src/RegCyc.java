

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RegCyc
 */
@WebServlet("/RegCyc")
public class RegCyc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegCyc() {
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
		HttpSession session=request.getSession();
		String name = session.getAttribute("name").toString();
		String cynum = request.getParameter("cid").toString();
		String ctype = request.getParameter("ctype").toString();
		String hall = request.getParameter("hall").toString();
		Cycle myCycle = new Cycle(name);
		if(myCycle.check()) {
			System.out.println("A cycle already exists in your name, Delete it to add new cycle");
		}
		else {
			myCycle.getRegister(name, cynum, ctype, hall,"NO");
			if(myCycle.getRegister()) {
				System.out.println("Registration Suceesful");
				response.sendRedirect("WelcomeUser.jsp");
			}
			else {
				System.out.println("Could not register the cycle");
				response.sendRedirect("WelcomeUser.jsp");
			}
		}
		
	}

}
