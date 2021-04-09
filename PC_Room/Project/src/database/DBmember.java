package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBmember {
	Connection conn=null;
	PreparedStatement pstmt=null;
	Statement stmt=null;
	ResultSet rs;
	
	public DBmember() {
		connect();
	}
	void connect() {
		String dbinfor = "jdbc:mysql://127.0.0.1:3306/pc_room?serverTimezone=UTC";
		String dbID = "root";
		String dbPW = "mirim2";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.conn = java.sql.DriverManager.getConnection(dbinfor, dbID, dbPW);
			this.stmt = this.conn.createStatement();
		} catch (Exception e) {
			System.out.println("connection error:" + e);
		}
	}// connect()
	
	public void insert(String member, String id, String password, String name) {
		String dbinfor="jdbc:mysql://127.0.0.1:3306/pc_room?serverTimezone=UTC";
		String dbID="root";
		String dbPW="mirim2";
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection(dbinfor,dbID,dbPW);
			
			String sql="INSERT INTO User (member,id,password,name) VALUES (?,?,?,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, member);
			pstmt.setString(2, id);
			pstmt.setString(3, password);
			pstmt.setString(4, name);
			pstmt.executeUpdate();
			
			conn.close();
			
		}catch(Exception e){
			System.out.println("connection error:" + e);
		}
	}
	public boolean checkid(String id) {
		boolean result = true;
		 try {
	            pstmt = conn.prepareStatement("SELECT * FROM User WHERE id=?");
	            pstmt.setString(1, id.trim());
	            rs = pstmt.executeQuery(); //실행
	            if (rs.next())
	                result = false; //레코드가 존재하면 false
	 
	        } catch (SQLException e) {
	            System.out.println(e + "=>  getIdByCheck fail");
	        } 
	        return result;
	}
}
