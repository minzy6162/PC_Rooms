package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBsave {
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs;
	
	public DBsave(int seatNum,int time,int useable) {
		String dbinfor="jdbc:mysql://127.0.0.1:3306/pc_room?useSSL=false&serverTimezone=UTC";
		String dbID="root";
		String dbPW="mirim2";
	try
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn=DriverManager.getConnection(dbinfor,dbID,dbPW);
		
		String sql="UPDATE seat SET time = ?, useable = ? WHERE seatNum =?";
		pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, time);
		pstmt.setInt(2,useable);
		pstmt.setInt(3, seatNum);
		
		pstmt.executeUpdate();
		
		conn.close();
		
	}catch(Exception e){
		System.out.println("connection error:" + e);
	}
	}
}
