package co.kh.dev.home.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import co.kh.dev.common.ConnectionPool;

public class CustomerDAO {
	ConnectionPool cp = ConnectionPool.getInstance();
	String INSERT_SQL = "INSERT INTO CUSTOMER VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	String SELECT_BY_ID_SQL = "SELECT COUNT(*) COUNT FROM CUSTOMER WHERE ID = ?";
	private final String SELECT_LOGIN_CHECK_SQL = "SELECT COUNT(*) COUNT FROM Customer WHERE ID = ? AND PWD = ?";
	private static CustomerDAO cDAO;

	
	public static CustomerDAO getInstance() {
		try {
			if (cDAO == null) {
				synchronized (ConnectionPool.class) {
					cDAO = new CustomerDAO();
				}
			}
		} catch (Exception e) {
		}
		return cDAO;
	}
	// 데이터 삽입 메서드
	public boolean insertDB(CustomerVO cvo) {
		Connection con = cp.getConnection();
		PreparedStatement pstmt = null;
		int rs = 0;
		try {
			pstmt = con.prepareStatement(INSERT_SQL);
			pstmt.setString(1, cvo.getId());
			pstmt.setString(2, cvo.getPwd());
			pstmt.setString(3, cvo.getName());
			pstmt.setString(4, cvo.getNickName());
			pstmt.setString(5, cvo.getEmail());
			pstmt.setString(6, cvo.getTel());
			pstmt.setString(7, cvo.getPhone());
			pstmt.setString(8, cvo.getBirth());
			pstmt.setString(9, cvo.getZipcode());
			pstmt.setString(10, cvo.getAddress1());
			pstmt.setString(11, cvo.getAddress2());
			rs = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			cp.dbClose(con, pstmt);
		}
		return (rs != 0) ? true : false; // 성공 여부 반환

	}

	// ID 중복 체크 메서드
	public boolean selectByIdDB(CustomerVO cvo) {
		Connection con = cp.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		int count = 0;
		try {
			pstmt = con.prepareStatement(SELECT_BY_ID_SQL);
			pstmt.setString(1, cvo.getId());
			rs=pstmt.executeQuery();
			if(rs.next()) {
			count = rs.getInt("COUNT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			cp.dbClose(con, rs, pstmt);
		}
		
		return (count==0)?true:false;
	}
	
		
		//id, pwd를받아서 맞는 레코드를 출력
		public boolean selectLoginCheckDB(CustomerVO cvo) {
			Connection con = cp.getConnection();
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			int count = 0;
			try {
				pstmt= con.prepareStatement(SELECT_LOGIN_CHECK_SQL);
				pstmt.setString(1, cvo.getId());
				pstmt.setString(2, cvo.getPwd());
				rs=pstmt.executeQuery();
				if(rs.next()) {
				count = rs.getInt("COUNT");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				cp.dbClose(con, rs, pstmt);
			}
			
			return (count==0)?true:false;
		}
		
}