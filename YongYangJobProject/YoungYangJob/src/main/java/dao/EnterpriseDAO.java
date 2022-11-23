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
// 모든 값 불러오기
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

// ㄱㅣ업 정보 올리기
	public int insertEnt(String ent_name, String representative, String establishment_date, String sectors, String url,
			String address, String explanation) {
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
		} finally {
			JdbcUtil.close(conn, pstmt);
		}
		return n;
	}

// n 값이 1 이면 기업명 주소 업종 에 맞는 keyword 가 있으면 그 개수 불러오기
// n 값이 2 이면 모든 기업 정보 개수 가져오기
	public int allCountEnt(String n, String keyword) {
		if (n.equals("1")) {
			sql = "select count(*) from enterprise_tbl_gmlxo where ent_name like '%"+keyword+"%' or sectors like '%"+keyword+"%' or address like '%"+keyword+"%' ORDER by ent_name asc";
		} else if (n.equals("2")) {
			sql = "select count(*) from enterprise_tbl_gmlxo";
		}
		int conut = 0;

		try {
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				conut = rs.getInt("count(*)");
			}

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		return conut;
	}

// n 값이 1 이면 기업명 주소 업종 에 맞는 keyword 가 있으면 불러오기
// n 값이 2 이면 모든 기업 정보 가져오기
	public ArrayList<EnterpriseVO> EntDateList(String n, String keyword) {
		ArrayList<EnterpriseVO> entList = new ArrayList<EnterpriseVO>();

		try {
			if (n.equals("1")) {
				sql = "SELECT ent_name, sectors, TO_CHAR(establishment_date, 'YYYY\"년 \"MM\"월 \"DD\"일\"') establishment_date, representative, address, url, Explanation, logo_img FROM enterprise_tbl_gmlxo where ent_name like '%"+keyword+"%' or sectors like '%"+keyword+"%' or address like '%"+keyword+"%' ORDER by ent_name asc";
			} else if (n.equals("2")) {
				sql = "SELECT ent_name, sectors, TO_CHAR(establishment_date, 'YYYY\"년 \"MM\"월 \"DD\"일\"') establishment_date, representative, address, url, Explanation, logo_img FROM enterprise_tbl_gmlxo";
			}

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
				vo.setExplanation(rs.getString("Explanation"));
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
}
