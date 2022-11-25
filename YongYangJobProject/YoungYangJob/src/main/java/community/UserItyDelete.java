package community;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CommunityDAO;

@WebServlet("/userDelete")
public class UserItyDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserItyDelete() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		CommunityDAO dao = new CommunityDAO();

		/* report, ity_idx 값을 받아옴 */
		String ity_idx = request.getParameter("ity_idx");

		/* 값을 보내 delete ity 를 실행 */
		int n_2 = dao.deleteCom(ity_idx);
		int	n = dao.deleteIty(ity_idx);

		/* 삭제에 성공 했을 시 실행 */
		if (n < 0) {
			out.println("<script> alert(\"게시물을 내리지 못했습니다.\"); history.go(-1); </script>");
		}
		/* 실행이 끝나면 ity list로 이동 */
		response.sendRedirect("/ityList");
	}

}
