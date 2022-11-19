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
 * Servlet implementation class AddComment
 */
@WebServlet("/com")
public class AddComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddComment() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		PrintWriter out = response.getWriter();
		
		CommunityDAO dao = new CommunityDAO();
		
		String id, contents;
		int ity;
		
		id = request.getParameter("id");
		ity = Integer.parseInt(request.getParameter("ity"));
		contents = request.getParameter("contents");
		
		int n = dao.insetCom(ity, id, contents);
		
		if(n>0) 
			response.sendRedirect("/comList?ity_idx="+ity);
		else
			out.println("<script> alert(\"댓글 업로드에 실패하였습니다.\"); history.go(-1); </script>");
	}
}
