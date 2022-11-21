package enterprise;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EnterpriseDAO;
import vo.EnterpriseVO;

@WebServlet("/entList")
public class EntList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EntList() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		EnterpriseDAO dao = new EnterpriseDAO();

		String n = request.getParameter("n");
		String keyword = request.getParameter("keyword");

		int count = dao.allCountEnt(n, keyword);
		ArrayList<EnterpriseVO> list = dao.EntDateList(n, keyword);

		if (list != null) {
			request.setAttribute("count", count);
			request.setAttribute("entList", list);
		}
		request.getRequestDispatcher("/Information/enterprise.jsp").forward(request, response);
	}
}
