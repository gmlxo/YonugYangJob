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

@WebServlet("/comList")
public class commentList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public commentList() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CommunityDAO dao = new CommunityDAO();
		
		int ity_idx = request.getParameter("ity_idx");
		
		ArrayList<CommentVO> ityList = dao.getComList(ity_idx);
		if (ityList != null) {
			request.setAttribute("ityList", ityList);
		}
		request.getRequestDispatcher("/Information/setCommunity.jsp").forward(request, response);
	}
}
