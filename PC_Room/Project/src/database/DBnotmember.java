package database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBnotmember {
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs;
	
	public DBnotmember(String member,String cardNum) {
		String dbinfor="jdbc:mysql://127.0.0.1:3306/pc_room?serverTimezone=UTC";
		String dbID="root";
		String dbPW="mirim2";
	try
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn=DriverManager.getConnection(dbinfor,dbID,dbPW);
		
		String sql="INSERT INTO User (member,id) VALUES (?,?)";
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, member);
		pstmt.setString(2, cardNum);
	
		pstmt.executeUpdate();
		
		conn.close();
		
	}catch(Exception e){
		System.out.println("connection error:" + e);
	}
	}
}

