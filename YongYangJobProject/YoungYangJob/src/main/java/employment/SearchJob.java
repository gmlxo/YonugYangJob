package employment;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmploymentDAO;
import vo.Ent_emp_VO;

/**
 * Servlet implementation class SearchJob
 */
@WebServlet("/seaJob")
public class SearchJob extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SearchJob() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EmploymentDAO dao = new EmploymentDAO();
		
		String keyword = request.getParameter("keyword");
		ArrayList<Ent_emp_VO> list = dao.seaJobList(keyword);

		if (list != null) {
			request.setAttribute("indexList", list);
		}
		request.getRequestDispatcher("/Information/jobs.jsp").forward(request, response);
	}
}
