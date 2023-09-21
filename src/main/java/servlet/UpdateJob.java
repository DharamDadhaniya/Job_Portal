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
import model.Jobs;

/**
 * Servlet implementation class UpdateJob
 */
@WebServlet("/UpdateJob")
public class UpdateJob extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateJob() {
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
		String title = request.getParameter("title");
		String locatin = request.getParameter("Location");
		String category = request.getParameter("Category");
		String status = request.getParameter("Status");
		String desc = request.getParameter("desc");
		
		Jobs j = new Jobs();
		j.setId(id);
		j.setTitle(title);
		j.setDescription(desc);
		j.setCategory(category);
		j.setLocation(locatin);
		j.setStatus(status);
		
		HttpSession session = request.getSession();
		jobD jd = new jobD(DBConnect.GetConnection());
		boolean f = jd.UpdateJob(j);
		
		if(f) {
			session.setAttribute("succMsg", "Job Post Sucessfully...");
			response.sendRedirect("view_jobs.jsp");
		}
		else {
			session.setAttribute("succMsg", "Something wrong on server...");
			response.sendRedirect("view_jobs.jsp");
		}
		
	}

}
