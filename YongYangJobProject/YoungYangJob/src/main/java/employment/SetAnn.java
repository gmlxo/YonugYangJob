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

        /* title 값 받아오기 */
		String title = request.getParameter("title");
		/* title 에 맞는 값을 받아와 list에 넣어두기 */
        ArrayList<Ent_emp_VO> list = dao.annEntEmpList(title);
		
        /* 값이 있으면 값을 저장 */
		if(list != null) {
			request.setAttribute("annList", list);
		}
        /* set annoucement jsp 로 이동 */
		request.getRequestDispatcher("/Information/setAnnouncement.jsp").forward(request, response);
	}
}
