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

@WebServlet("/index")
public class setIndexList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public setIndexList() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EmploymentDAO dao = new EmploymentDAO();
		/* 값을 담아 온다 */
		ArrayList<Ent_emp_VO> list = dao.indexEntList();
		
		/* index 인지 jobs jsp 인지 확인 용 */
		String n = request.getParameter("n");
		
		/* 값이 있다면 indexList 에 list 값을 넣어준다. */
		if(list != null) {
			request.setAttribute("indexList", list);
		}
		
		if(n.equals("1"))  /* index jsp  화면으로 넘긴다 */
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		else if (n.equals("2")) {  /* jobs jsp  화면으로 넘긴다 */
			request.getRequestDispatcher("/Information/jobs.jsp").forward(request, response);
		}
	}

}
