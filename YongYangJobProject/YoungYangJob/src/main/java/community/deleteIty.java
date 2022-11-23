package community;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CommunityDAO;

/**
 * Servlet implementation class delectIty
 */
@WebServlet("/delIty")
public class deleteIty extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public deleteIty() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		PrintWriter out = response.getWriter();
		
		CommunityDAO dao = new CommunityDAO();
		
		String report = request.getParameter("report");
		String ity_idx = request.getParameter("ity_idx");
		
		if(report != null) {
			int n = dao.deleteIty(ity_idx);
			
			if(n < 0) {
				int n_2 = dao.deleteCom(ity_idx);
				
				if(n_2<0) {
					out.println("<script> alert(\"신고에 실패하였습니다.\"); </script>");
				}
			} else {
				out.println("<script> alert(\"신고에 실패하였습니다.\"); </script>");
			}
			response.sendRedirect("/ityList");
		} else {
			out.println("<script> alert(\"신고 이유를 선택해 주세요.\"); history.go(-1); </script>");
		}
	}

}
