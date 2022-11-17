package enterprise;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EnterpriseDAO;

@WebServlet("/addEnt")
public class addEnterprise extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public addEnterprise() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		PrintWriter out = response.getWriter();
		
		EnterpriseDAO dao = new EnterpriseDAO();
		
		String ent_name, representative, establishment_date, sectors, url, address, explanation;
		
		ent_name = request.getParameter("ent_name");
		representative = request.getParameter("representative");
		establishment_date = request.getParameter("establishment_date");
		sectors = request.getParameter("sectors");
		url = request.getParameter("url");
		address = request.getParameter("address");
		explanation = request.getParameter("explanation");

		int n = dao.insertEnt(ent_name, representative, establishment_date, sectors, url, address, explanation);
		
		if(n>0) 
			out.println("<script> alert(\"추가되였습니다.\"); history.go(-2); </script>");
		else
			out.println("<script> alert(\"추가에 실패하였습니다.\"); history.go(-1); </script>");
	}
}
