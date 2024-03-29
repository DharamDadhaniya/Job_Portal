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
import jobs.jobD;

/**
 * Servlet implementation class DeleteJob
 */
@WebServlet("/DeleteJob")
public class DeleteJob extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteJob() {
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
		int id = Integer.parseInt(request.getParameter("id"));
		
		jobD jd = new jobD(DBConnect.GetConnection());
		boolean f = jd.deletejobs(id);
		
		HttpSession session = request.getSession();
		
		
		if(f) {
			response.sendRedirect("view_jobs.jsp");
		}
		else {
			response.sendRedirect("view_jobs.jsp");
		}
		
	}

}
