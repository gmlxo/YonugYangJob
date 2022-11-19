package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JdbcUtil;
import vo.CommentVO;
import vo.CommunityVO;

public class CommunityDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql;

	/* community */
//	게시물 등록
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

//	게시물 불러오기
	public ArrayList<CommunityVO> getItyList() {
		ArrayList<CommunityVO> ityList = new ArrayList<CommunityVO>();
		CommunityVO vo = null;

		sql = "SELECT ity_idx, user_id, ity_title, TO_DATE(sysdate, 'YYYY-MM-DD') - TO_DATE(ity_day, 'YYYY-MM-DD')+1 ity_day, substr(ity_contents, 1, 10) FROM community_tbl_gmlxo";

		try {
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				vo = new CommunityVO();

				vo.setIty_idx(rs.getInt("ity_idx"));
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

	
	/* comment */
//	댓글 달기
	public int insetCom(int ity, String id, String contents) {
		int n = 0;

		sql = "insert into comment_tbl_gmlxo values (com_seq.NEXTVAL, ?, ?, sysdate, ?)";

		try {
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ity);
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
	
//	댓글 불러오기
	public ArrayList<CommentVO> getComList(int ity_idx) {
		ArrayList<CommentVO> comList = new ArrayList<CommentVO>();
		CommentVO vo = null;

		sql = "SELECT com_idx, user_id, TO_DATE(sysdate, 'YYYY-MM-DD') - TO_DATE(com_day, 'YYYY-MM-DD')+1 com_day, com_contents FROM comment_tbl_gmlxo where ity_idx=?";

		try {
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ity_idx);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				vo = new CommentVO();
				
				vo.setUser_id(rs.getString("user_id"));
				vo.setCom_day(rs.getString("com_day"));
				vo.setCom_contents(rs.getString("com_comtents"));

				comList.add(vo);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		return comList;
	}
}
