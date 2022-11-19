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
		
		int ity_idx = Integer.parseInt(request.getParameter("ity_idx"));
		
		ArrayList<CommentVO> comList = dao.getComList(ity_idx);
		ArrayList<CommunityVO> setIty = dao.setIty(ity_idx);
		
		if (comList != null && setIty != null) {
			request.setAttribute("comList", comList);
			request.setAttribute("ity", setIty);
		}
		request.getRequestDispatcher("/Information/setCommunity.jsp").forward(request, response);
	}
}
