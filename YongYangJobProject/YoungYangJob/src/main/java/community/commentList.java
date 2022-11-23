package community;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CommunityDAO;
import vo.CommentVO;
import vo.CommunityVO;

@WebServlet("/comList")
public class commentList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public commentList() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CommunityDAO dao = new CommunityDAO();
		
        /* ity_idx 값을 받아옴 */
		int ity_idx = Integer.parseInt(request.getParameter("ity_idx"));
		
        /* 실행한 값을 각각 맞는 list에 저장 */
		ArrayList<CommentVO> comList = dao.getComList(ity_idx);
		ArrayList<CommunityVO> setIty = dao.setIty(ity_idx);
		
        /* 두개의 list가 null 값이 아니라면 값을 각각 이름에 맞게 저장 */
		if (comList != null && setIty != null) {
			request.setAttribute("comList", comList);
			request.setAttribute("ity", setIty);
		}
        /* 실행이 다 되면 set enterprise jsp 로 이동 */
		request.getRequestDispatcher("/Information/setEnterprise.jsp").forward(request, response);
	}
}
