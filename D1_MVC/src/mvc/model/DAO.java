package mvc.model;

import java.sql.*;

import javax.sql.*;
import javax.naming.*;

import java.util.*; 

public class DAO {
	
	private static DAO dao = new DAO();
	private Connection conn = null;
	
	PreparedStatement pstmt = null;	
	
	private DAO() {
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2단계 DB 연결
			String path="jdbc:oracle:thin:@khjob.iptime.org:7000:xe";
			conn = DriverManager.getConnection(path,"java20","java20"); // ip, 연결할 계정, pw
		} catch (Exception e) {			
			e.printStackTrace();
		}		
	}
	
	public static DAO getInstance(){
		return dao;
	}

		
	public boolean insert(DTO dto){			
		
		boolean isSuccess = false;
	
		try {
			String sql = "INSERT INTO member VALUES(?,?,?)";			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getName());
			pstmt.executeUpdate();
			isSuccess = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
		
	}
	
	public List select(){		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List mlist = new ArrayList();
		
		try {			
			String sql = "SELECT * FROM member";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				
				DTO dto = new DTO(id, pw, name);
				mlist.add(dto);
			}		
		} catch(Exception e){
			e.printStackTrace();
		}
		return mlist;
	}
}
