package employment;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmploymentDAO;
import vo.Ent_emp_VO;

@WebServlet("/setAnn")
public class SetAnn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SetAnn() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmploymentDAO dao = new EmploymentDAO();
		
		String title = request.getParameter("title");
		
		ArrayList<Ent_emp_VO> list = dao.
	}
}
