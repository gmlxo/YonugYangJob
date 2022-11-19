package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JdbcUtil;
import vo.CommunityVO;

public class CommunityDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql;

	public int insetIty(String id, String title, String contents) {
		int n = 0;

		sql = "insert into community_tbl_gmlxo values (ity_seq.NEXTVAL, ?, ?, sysdate, ?)";

		try {
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, title);
			pstmt.setString(3, contents);

			n = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt);
		}

		return n;
	}

	public ArrayList<CommunityVO> getItyList() {
		ArrayList<CommunityVO> ityList = new ArrayList<CommunityVO>();
		CommunityVO vo = null;

		sql = "SELECT ity_idx, user_id, ity_title, TO_DATE(sysdate, 'YYYY-MM-DD') - TO_DATE(ity_day, 'YYYY-MM-DD')+1 ity_day, ity_contents FROM community_tbl_gmlxo";

		try {
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				vo = new CommunityVO();

				vo.setIty_idx(rs.getString("ity_idx"));
				vo.setUser_id(rs.getString("user_id"));
				vo.setIty_title(rs.getString("ity_title"));
				vo.setIty_day(rs.getString("ity_day"));
				vo.setIty_contents(rs.getString("ity_contents"));

				ityList.add(vo);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		return ityList;
	}

	public int insetCom(String ity, String id, String contents) {
		int n = 0;

		sql = "insert into comment_tbl_gmlxo values (com_seq.NEXTVAL, ?, ?, sysdate, ?)";

		try {
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ity);
			pstmt.setString(2, id);
			pstmt.setString(3, contents);

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
