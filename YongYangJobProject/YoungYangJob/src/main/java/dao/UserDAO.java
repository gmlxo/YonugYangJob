package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JdbcUtil;
import vo.UserVO;

public class UserDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql;
	int n;
	
//	user table의 모든 값을 가져온다.
	public ArrayList<UserVO> getUserDateList() {
		ArrayList<UserVO> userList =  new ArrayList<UserVO>();
		sql = "select * from user_tbl_gmlxo";
		
		try {
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			UserVO vo = null;
			
			while (rs.next()) {
				vo = new UserVO();
				vo.setUser_id(rs.getString("user_id"));
				vo.setUser_name(rs.getString("user_name"));
				vo.setUser_pwd(rs.getString("user_pwd"));
				vo.setUser_email(rs.getString("user_email"));
				vo.setUser_date(rs.getString("user_date"));
				vo.setUser_type(rs.getString("user_type"));
				
				userList.add(vo);
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		return userList;
	}
	
//	로그인한 아이디와 비번의 계정이 존재한가?
//	존재한다면 loginID의 담는다.	 
	public String login(String id, String pwd) {
		String log = null;
		sql = "select user_id from user_tbl_gmlxo where user_id=? and user_pwd=?";
		
		try {
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				log = rs.getString("user_id");
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		return log;
	}
}
