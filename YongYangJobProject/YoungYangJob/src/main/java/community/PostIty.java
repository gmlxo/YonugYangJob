package community;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CommentDAO;
import dao.CommunityDAO;

@WebServlet("/ity")
public class PostIty extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PostIty() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		PrintWriter out = response.getWriter();
		
		CommunityDAO dao = new CommunityDAO();
		
		String id, title, contents;
		
		id = request.getParameter("id");
		title = request.getParameter("title");
		contents = request.getParameter("contents");
		
		int n = dao.insetIty(id, title, contents);
		
		if(n>0) 
			response.sendRedirect("/Information/setCommunity.jsp");
		else
			out.println("<script> alert(\"회원가입에 실패하였습니다.\"); history.go(-1); </script>");
	}

}
