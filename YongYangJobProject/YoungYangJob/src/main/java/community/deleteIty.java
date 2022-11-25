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

	/* 신고당한 게시물 삭제 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		PrintWriter out = response.getWriter();

		CommunityDAO dao = new CommunityDAO();

		/* report, ity_idx 값을 받아옴 */
		String report = request.getParameter("report");
		String ity_idx = request.getParameter("ity_idx");

		/* report null 값이 아니면 실행 */
		if (report != null) {
			/* 값을 보내 delete ity 를 실행 */
			int n_2 = dao.deleteCom(ity_idx);
			int n = dao.deleteIty(ity_idx);

			/* 삭제에 성공 했을 시 실행 */
			if (n < 0) {
				out.println("<script> alert(\"신고에 실패하였습니다.\"); history.go(-1); </script>");
			} else {
				out.println("<script> alert(\"신고에 실패하였습니다.\"); history.go(-1); </script>");
			}
			/* 실행이 끝나면 ity list로 이동 */
			response.sendRedirect("/ityList");
		} else {
			out.println("<script> alert(\"신고 이유를 선택해 주세요.\"); history.go(-1); </script>");
		}
	}

}
