package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcUtil {

	// 1. DB연결 getConnection()	
	public static Connection getConnection() {
		
		Connection conn = null;
		
		try {
			/* 수민이 DB */
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@pukkuk.pp.ua:1521:xe","hr","jeongsumin0701");
		} catch (Exception e) {
			try {
				/* local DB */
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","hr","hr");
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		}
		return conn;
	}
	// 2. DB종료 close(conn, pstmt)	
	public static void close(Connection conn, PreparedStatement pstmt) {
		if(pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	// 3. DB종료 close(conn, pstmt, rs)
	public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs)  {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		close(conn, pstmt);
		
	}
	

}