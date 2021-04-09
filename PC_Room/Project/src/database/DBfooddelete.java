package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBfooddelete {
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs;
	
	public DBfooddelete(String data) {
		String dbinfor="jdbc:mysql://127.0.0.1:3306/pc_room?serverTimezone=UTC";
		String dbID="root";
		String dbPW="mirim2";
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection(dbinfor,dbID,dbPW);
			
			String sql="DELETE FROM FoodList WHERE SeatNum = ?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, data);
			pstmt.executeUpdate();
			
			conn.close();
			
		}catch(Exception e){
			System.out.println("connection error:" + e);
		}
	}
}
