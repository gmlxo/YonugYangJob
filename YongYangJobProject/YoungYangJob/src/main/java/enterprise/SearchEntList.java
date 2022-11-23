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

@WebServlet("/seaEntList")
public class SearchEntList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SearchEntList() {
        super();
    }

/* 검샥한 결과에 맞는 기업 정보에 수와 그 정보들을 가져와 list에 담아 jsp 로 보내주는 servlet */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EnterpriseDAO dao = new EnterpriseDAO();
		
        /* n keyword 값 받아오기 */
		String n = request.getParameter("n");
		String keyword = request.getParameter("keyword");
		
        /* 조건에 맞는 값의 개수 가져오기 */
		int count = dao.allCountEnt(n, keyword);
        /* 조건에 맞는 값 받아와 list에 담기 */
		ArrayList<EnterpriseVO> list = dao.EntDateList(n, keyword);
		
        /* 값이 있으면 각각 맞게 저장 */
		if(list != null) {
			request.setAttribute("count", count);
			request.setAttribute("entList", list);
		}
        /* enterprise jsp 로 이동 */
		request.getRequestDispatcher("/Information/enterprise.jsp").forward(request, response);
	}
}
