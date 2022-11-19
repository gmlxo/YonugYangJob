package community;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CommunityDAO;
import vo.CommunityVO;

/**
 * Servlet implementation class commnuityList
 */
@WebServlet("/ityList")
public class commnuityList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public commnuityList() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CommunityDAO dao = new CommunityDAO();
		ArrayList<CommunityVO> ityList = dao.getItyList();

		if (ityList != null) {
			request.setAttribute("ityList", ityList);
		}
		request.getRequestDispatcher("/Information/setCommunity.jsp").forward(request, response);
	}

}
