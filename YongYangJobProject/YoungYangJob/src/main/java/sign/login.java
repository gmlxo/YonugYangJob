package sign;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;

@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		한글 인코딩 설정
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		PrintWriter out = response.getWriter();

		UserDAO dao = new UserDAO();
		String id, pwd;

//		세션생성
		HttpSession session = request.getSession();
//		DB에서 유저의 ID와 PASSWORD가져오기
		id = request.getParameter("id");
		pwd = request.getParameter("pwd");

		String[] log = dao.login(id, pwd);

		if (log != null) {
			session.setAttribute("logOK", log[0]);
			session.setAttribute("type", log[1]);
			response.sendRedirect("/index");
            /* request.getRequestDispatcher("/memberList.jsp").forward(request, response); */
		} else {
			out.println("<script> alert(\"로그인에 실패하였습니다.\"); history.go(-1); </script>");
		}
	}

}
