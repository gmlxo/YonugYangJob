package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JdbcUtil;
import vo.EnterpriseVO;

public class EnterpriseDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql;

	public ArrayList<EnterpriseVO> getUserDateList() {
		ArrayList<EnterpriseVO> entList = new ArrayList<EnterpriseVO>();
		sql = "select * from enterprise_tbl_gmlxo";

		try {
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			EnterpriseVO vo = null;

			while (rs.next()) {
				vo = new EnterpriseVO();
				vo.setEnt_name(rs.getString("ent_name"));
				vo.setRepresentative(rs.getString("representative"));
				vo.setEstablishment_date(rs.getString("establishment_date"));
				vo.setSectors(rs.getString("sectors"));
				vo.setUrl(rs.getString("url"));
				vo.setAddress(rs.getString("address"));
				vo.setExplanation(rs.getString("explanation"));
				vo.setLogo_img(rs.getString("logo_img"));

				entList.add(vo);
			}

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		return entList;
	}

	public int insertEnt(String ent_name, String representative, String establishment_date,String sectors, String url, String address, String explanation) {
		int n = 0;
		String img = "https://www.viewhotels.jp/asakusa-annex/wp-content/uploads/sites/6/2020/03/test-img.jpg";
		sql = "insert into enterprise_tbl_gmlxo VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ent_name);
			pstmt.setString(2, representative);
			pstmt.setString(3, establishment_date);
			pstmt.setString(4, sectors);
			pstmt.setString(5, url);
			pstmt.setString(6, address);
			pstmt.setString(7, explanation);
			pstmt.setString(8, img);
			
			n = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, pstmt);
		}
		return n;
	}
}
