package employment;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmploymentDAO;
import vo.EmploymentVO;

@WebServlet("/index")
public class setIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public setIndex() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EmploymentDAO dao = new EmploymentDAO();
		ArrayList<EmploymentVO> list = dao.indexEntList();
		
		if(list != null) {
			request.setAttribute("indexList", list);
		}
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

}
