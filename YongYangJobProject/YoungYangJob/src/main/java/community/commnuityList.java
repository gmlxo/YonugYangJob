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

/* ㄱㅔ시물 전체 불러오기 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CommunityDAO dao = new CommunityDAO();
	/* get ity list 에서 실행한 값을 list에 저장 */
		ArrayList<CommunityVO> ityList = dao.getItyList();

	/* null 값이 아니라면 list 값을 저장 */
		if (ityList != null) {
			request.setAttribute("ityList", ityList);
		}
	/* set community jsp 로 이동 */
		request.getRequestDispatcher("/Information/setCommunity.jsp").forward(request, response);
	}

}
