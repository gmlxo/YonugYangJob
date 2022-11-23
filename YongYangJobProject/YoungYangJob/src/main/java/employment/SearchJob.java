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

/* 검색한 지역에 있는 채용 정보 불러오기 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EmploymentDAO dao = new EmploymentDAO();
		
		/* keyword 값 받아오기 */
		String keyword = request.getParameter("keyword");
		/* keyword 에 맞는 값의 정보를 list에 저장하기 */
		ArrayList<Ent_emp_VO> list = dao.seaJobList(keyword);

		/* null 이 아니면 list 저장 */
		if (list != null) {
			request.setAttribute("indexList", list);
		}
		/* jobs jsp 로 이동 */
		request.getRequestDispatcher("/Information/jobs.jsp").forward(request, response);
	}
}
