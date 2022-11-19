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
public class signOut extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public signOut() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String id, type;
		id = (String) session.getAttribute("logOK");
		type = (String) session.getAttribute("type");
		
		session.invalidate();
		
		response.sendRedirect("/index.jsp");
	}
}
