package servlet;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import Connect.DBConnect;
import jobs.UserD;
import model.User;

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
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String em = request.getParameter("email");
		String pwd = request.getParameter("password");
		User u = new User();
		HttpSession session = request.getSession();
		
		if("admin@gmail.com".equals(em) && "admin@123".equals(pwd)) {
			session.setAttribute("userobj", u);
			
			u.setRole("admin");
			response.sendRedirect("admin.jsp");
		}
		else {

			UserD ud = new UserD(DBConnect.GetConnection());
			User user = ud.login(em, pwd);
			
			if(user!=null) {
				session.setAttribute("userobj", user);
				response.sendRedirect("home.jsp");
			}
			else {
				response.sendRedirect("Error.jsp");
			}
		}
	}

}
