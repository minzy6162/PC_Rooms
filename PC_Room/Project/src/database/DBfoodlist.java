package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

public class DBfoodlist {
	public Connection conn=null;
	public PreparedStatement pstmt=null;
	public Statement stmt=null;
	public ResultSet rs;
	
	public DBfoodlist() {
		connect();
	}
	void connect() {
		String dbinfor = "jdbc:mysql://127.0.0.1:3306/pc_room?serverTimezone=UTC";
		String dbID = "root";
		String dbPW = "mirim2";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.conn = DriverManager.getConnection(dbinfor, dbID, dbPW);
			this.stmt = this.conn.createStatement();
		} catch (Exception e) {
			System.out.println("connection error:" + e);
		}
	}// connect()
	public void foodlist(String SeatNum, String FoodName, int price,int count,int sum,String need) {
		String dbinfor="jdbc:mysql://127.0.0.1:3306/pc_room?useSSL=false&serverTimezone=UTC";
		String dbID="root";
		String dbPW="mirim2";
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection(dbinfor,dbID,dbPW);
			
			String sql="INSERT INTO FoodList (SeatNum, FoodName, price,count,sum,need) VALUES (?,?,?,?,?,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, SeatNum);
			pstmt.setString(2, FoodName);
			pstmt.setInt(3, price);
			pstmt.setInt(4,count);
			pstmt.setInt(5,sum);
			pstmt.setString(6, need);
			pstmt.executeUpdate();
			
			conn.close();
			
		}catch(Exception e){
			System.out.println("connection error:" + e);
		}
	}
	public DefaultTableModel showList() {
		String [] title= {"자리","음식","개수","메모"};
		String sql="SELECT SeatNum, FoodName, count, need FROM foodlist;";
		DefaultTableModel model=new DefaultTableModel();
		model.addRow(title);
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				model.addRow(new Object [] {
						rs.getString("SeatNum"),
						rs.getString("FoodName"),
						rs.getString("count"),
						rs.getString("need")
				});
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return model;
	}
}
