package sign;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;

@WebServlet("/signUp")
public class signUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public signUp() {
        super();
    }

/* 화원가입 servlet */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		한글 인코딩 설정
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		PrintWriter out = response.getWriter();

		UserDAO dao = new UserDAO();
		String id, name, pwd, email;
		
        /* id, name, pwd, email 값을 가져옴 */
		id = request.getParameter("id");
		name = request.getParameter("name");
		pwd = request.getParameter("pwd");
		email = request.getParameter("email");
		
        /* 값을 user table 에 넣어줌 */
		int n = dao.sign_up(id, name, pwd, email);
		
        /* 성공시 login jsp 로 이동 */
		if(n>0) 
			response.sendRedirect("/login/login.jsp");
		else
			out.println("<script> alert(\"회원가입에 실패하였습니다.\"); history.go(-1); </script>");
	}

}
