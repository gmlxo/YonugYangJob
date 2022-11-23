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

//	user table의 모든 값을 가져온다.
	public ArrayList<UserVO> getUserDateList() {
		ArrayList<UserVO> userList = new ArrayList<UserVO>();
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
	public String[] login(String id, String pwd) {
		String[] log = new String[2];
		sql = "select user_id, user_type from user_tbl_gmlxo where user_id=? and user_pwd=?";

		try {
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				log[0] = rs.getString("user_id");
				log[1] = rs.getString("user_type");
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		return log;
	}

// 회원가입
	public int sign_up(String id, String name, String pwd, String email) {
		int n = 0;
		sql = "insert into user_tbl_gmlxo values (?, ?, ?, sysdate, ?, '1')";

		try {
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, pwd);
			pstmt.setString(4, email);

			n = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt);
		}
		return n;
	}
}
