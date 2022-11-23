package sign;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/signOut")
public class SignOut extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SignOut() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String id, type;
		
	/* 세션 값 불러오기 */
		id = (String) session.getAttribute("logOK");
		type = (String) session.getAttribute("type");
		
		/* 세션 값들 삭제 */
		session.invalidate();
		
		/* index jsp 로 이동 */
		response.sendRedirect("/index.jsp");
	}
}
