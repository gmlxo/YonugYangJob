package employment;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmploymentDAO;

@WebServlet("/jobPosting")
public class jobPosting extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public jobPosting() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		PrintWriter out = response.getWriter();

		EmploymentDAO dao = new EmploymentDAO();
		String emp_title, emp_name, emp_email, company_name, emp_url, career, education, work_type, emp_day,
				emp_contents;
		
		/* emp_title, emp_name, emp_email, company_name, emp_url, career, education, work_type, emp_day,
				emp_contents 값 받아오기 */
		emp_title =  request.getParameter("emp_title");
		emp_name =  request.getParameter("emp_name");
		emp_email =  request.getParameter("emp_email");
		company_name =  request.getParameter("company_name");
		emp_url =  request.getParameter("emp_url");
		career =  request.getParameter("career");
		education =  request.getParameter("education");
		work_type =  request.getParameter("work_type");
		emp_day =  request.getParameter("emp_day");
		emp_contents =  request.getParameter("emp_contents");

		/* 값 보내 넣어주기 */
		int n = dao.insertEmp(emp_title, emp_name, emp_email, company_name, emp_url, career, education, work_type,
				emp_day, emp_contents);
		
		/* 성공하면 index jsp 로 이동 */
		if(n>0) {
			out.println("<script> alert(\"추가되였습니다.\");</script>");
			response.sendRedirect("/index.jsp");
		}else
			out.println("<script> alert(\"추가에 실패하였습니다.\"); history.go(-1); </script>");
	}

}
