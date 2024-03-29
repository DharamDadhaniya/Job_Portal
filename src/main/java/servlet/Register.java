package servlet;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Connect.DBConnect;
import jobs.UserD;
import model.User;

/**
 * Servlet implementation class Register
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
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String qua = request.getParameter("qua");
		String email = request.getParameter("email");
		String pwd= request.getParameter("pwd");
		
		UserD ud = new UserD(DBConnect.GetConnection());
		
		User u = new User(name, qua, email, pwd, "User");
		boolean f = ud.AddUser(u);
		
		HttpSession session = request.getSession();
		if(f) {
			response.sendRedirect("SignUp.jsp");
		}
		else {
			response.sendRedirect("Error.jsp");
		}
		
	}

}
