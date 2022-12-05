package community;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CommunityDAO;

@WebServlet("/updateIty")
public class updateIty extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public updateIty() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		CommunityDAO dao = new CommunityDAO();
		
		String ity_idx = request.getParameter("ity_idx");
		String updateContents = request.getParameter("updateContents");
		
		int n = dao.updateItyContents(ity_idx, updateContents);
		
		if(n>0) {
			response.sendRedirect("/comList?ity_idx="+ity_idx+"&&itySet=set");
		} else {
			out.println("<script> alert(\"변경에 실패하였습니다.\"); history.go(-1); </script>");
		}
	}

}
