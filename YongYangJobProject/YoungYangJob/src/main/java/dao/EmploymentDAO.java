package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JdbcUtil;
import vo.EmploymentVO;
import vo.Ent_emp_VO;

public class EmploymentDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql;

//	 table의 모든 값을 가져온다.
	public ArrayList<EmploymentVO> getUserDateList() {
		ArrayList<EmploymentVO> empList = new ArrayList<EmploymentVO>();
		sql = "select * from employment_tbl_gmlxo";

		try {
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			EmploymentVO vo = null;

			while (rs.next()) {
				vo = new EmploymentVO();
				vo.setEmp_title(rs.getString("emp_title"));
				vo.setEmp_name(rs.getString("emp_name"));
				vo.setEmp_email(rs.getString("emp_email"));
				vo.setCompany_name(rs.getString("company_name"));
				vo.setEmp_url(rs.getString("emp_url"));
				vo.setCareer(rs.getString("career"));
				vo.setEducation(rs.getString("education"));
				vo.setWork_type(rs.getString("work_type"));
				vo.setEmp_day(rs.getString("emp_day"));
				vo.setEmp_contents(rs.getString("emp_contents"));

				empList.add(vo);
			}

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		return empList;
	}

	public int insertEmp(String emp_title, String emp_name, String emp_email, String company_name, String emp_url,
			String career, String education, String work_type, String emp_day, String emp_contents) {
		int n = 0;
		sql = "insert into employment_tbl_gmlxo values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, emp_title);
			pstmt.setString(2, emp_name);
			pstmt.setString(3, emp_email);
			pstmt.setString(4, company_name);
			pstmt.setString(5, emp_url);
			pstmt.setString(6, career);
			pstmt.setString(7, education);
			pstmt.setString(8, work_type);
			pstmt.setString(9, emp_day);
			pstmt.setString(10, emp_contents);

			n = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt);
		}
		return n;
	}

//	index 의 필요한 값들을 가져온다.
	public ArrayList<Ent_emp_VO> indexEntList() {
		ArrayList<Ent_emp_VO> indexList = new ArrayList<Ent_emp_VO>();
		sql = "SELECT emp.company_name, emp.emp_title, TO_DATE(emp.emp_day, 'YYYY-MM-DD') - TO_DATE(sysdate, 'YYYY-MM-DD') emp_day, substr(emp.emp_contents, 1, 70) emp_contents, ent.logo_img, ent.sectors FROM employment_tbl_gmlxo emp, enterprise_tbl_gmlxo ent where emp.company_name = ent.ent_name";

		try {
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			Ent_emp_VO vo = null;

			while (rs.next()) {
				vo = new Ent_emp_VO();
				
				vo.setCompany_name(rs.getString("company_name"));
				vo.setEmp_day(rs.getString("emp_day"));
				vo.setEnt_logo_img(rs.getString("logo_img"));
				vo.setEmp_contents(rs.getString("emp_comtents"));
				vo.setEnt_sectors(rs.getString("sectors"));

				indexList.add(vo);
			}

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		return indexList;
	}
}
