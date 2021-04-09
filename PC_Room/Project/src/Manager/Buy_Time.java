package Manager;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Buy_Time implements ActionListener{

	private JFrame frame;
	private final JPanel panel;
	JButton []seat = new JButton[16];
	JLabel [] l_seat = new JLabel[16];
	JLabel [] use=new JLabel[16];
	JButton food;
	ImageIcon background=new ImageIcon("D:\\2020년_Mirim_2nd\\자바 프로젝트\\2106_2118\\images\\main.png");
	ImageIcon iconSeat=new ImageIcon("D:\\2020년_Mirim_2nd\\자바 프로젝트\\2106_2118\\images\\seat.png");
	ImageIcon iconFood=new ImageIcon("D:\\2020년_Mirim_2nd\\자바 프로젝트\\2106_2118\\images\\foodBtn.png");

	public Buy_Time() {
		panel=new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(background.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		
		frame = new JFrame("좌석");
		frame.setBounds(100, 100, 1600, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);//창 가운데 정렬
		frame.setResizable(false);//창 크기 고정
		panel.setBounds(0, 0, 1600, 1000);
		panel.setBackground(new Color(128,0,128));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		
		
		int j = 190;
		for(int i = 0; i<6; i++) {
			seat[i] = new JButton() {
				public void paintComponent(Graphics g) {
					g.drawImage(iconSeat.getImage(), 0, 0, null);
					setOpaque(false);
					super.paintComponent(g);
				}
			};
			seat[i].setBorderPainted(false);
			seat[i].setLayout(null);
			l_seat[i] = new JLabel((i+1) + "번");
			l_seat[i].setBounds(46, -30, 100, 100);
			l_seat[i].setForeground(Color.WHITE);
			seat[i].setBounds(new Rectangle(j, 185, 120, 150));//55, 185, 160, 180
			j+= 160;
			seat[i].setBackground(new Color(255, 255, 228, 255));
			seat[i].setForeground(Color.BLACK);
			l_seat[i].setFont(new Font("굴림", Font.BOLD, 20));
			use[i]=new JLabel();
			use[i].setFont(new Font("굴림", Font.BOLD, 15));
			use[i].setBounds(40,40,60,40);
			seat[i].add(use[i]);
			seat[i].add(l_seat[i]);
			panel.add(seat[i]);
			seat[i].addActionListener(this);
			
		}
		
		
		int k = 190;
		for( int i = 6; i<12; i++) {
			seat[i] = new JButton() {
				public void paintComponent(Graphics g) {
					g.drawImage(iconSeat.getImage(), 0, 0, null);
					setOpaque(false);
					super.paintComponent(g);
				}
			};
			seat[i].setBorderPainted(false);
			seat[i].setFocusPainted(false);
			seat[i].setLayout(null);
			l_seat[i] = new JLabel((i+1) + "번");
			l_seat[i].setBounds(44, -30, 100, 100);
			l_seat[i].setForeground(Color.WHITE);
			seat[i].setBounds(new Rectangle(k, 500, 120, 150));//55, 570, 160, 180
			k+= 160;
			seat[i].setBackground(new Color(255, 255, 228, 255));
			seat[i].setForeground(Color.BLACK);
			l_seat[i].setFont(new Font("굴림", Font.BOLD, 20));
			use[i]=new JLabel();
			use[i].setFont(new Font("굴림", Font.BOLD, 15));
			use[i].setBounds(40,40,60,40);
			seat[i].add(use[i]);
			seat[i].add(l_seat[i]);
			panel.add(seat[i]);
			seat[i].addActionListener(this);
			
		}
		int o = 85;
		for(int i = 12; i<16; i++) {
			seat[i] = new JButton() {
				public void paintComponent(Graphics g) {
					g.drawImage(iconSeat.getImage(), 0, 0, null);
					setOpaque(false);
					super.paintComponent(g);
				}
			};
			seat[i].setBorderPainted(false);
			seat[i].setFocusPainted(false);
			seat[i].setLayout(null);
			l_seat[i] = new JLabel((i+1) + "번");
			l_seat[i].setForeground(Color.WHITE);
			l_seat[i].setBounds(40, -30, 100, 100);
			seat[i].setBounds(new Rectangle(1200, o, 140, 160));//1167, 486, 160, 180
			o+= 160;
			seat[i].setBackground(new Color(255, 255, 228, 255));
			l_seat[i].setFont(new Font("굴림", Font.BOLD, 20));
			use[i]=new JLabel();
			use[i].setFont(new Font("굴림", Font.BOLD, 15));
			use[i].setBounds(40,40,60,40);
			seat[i].add(l_seat[i]);
			seat[i].add(use[i]);
			panel.add(seat[i]);
			seat[i].addActionListener(this);
		}
	
		frame.getContentPane().add(panel);
		frame.setVisible(true);
		
		food = new JButton() {
			public void paintComponent(Graphics g) {
				g.drawImage(iconFood.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		food.setBorderPainted(false);  // 외곽선 없애주기
		food.setContentAreaFilled(false);  // 버튼 투명 하게 
		food.setFocusPainted(false);  // 선택하면 테두리 안 나오게
		food.setFont(new Font("굴림", Font.BOLD, 40));
		food.setBounds(30, 850, 200, 100);
		panel.add(food);
		
		food.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				FoodExam f=new FoodExam();
				f.setVisible(true);
			}
		});
		

	}
	public void change() {
		String dbURL="jdbc:mysql://127.0.0.1:3306/pc_room?useSSL=false&serverTimezone=UTC";
		String jdbc_driver="com.mysql.cj.jdbc.Driver";
		Connection conn=null;
		PreparedStatement pstmt = null;
		ResultSet rs;
		int seatNum;
		try {
			Class.forName(jdbc_driver);
			System.out.println("Mysql client 데이터 베이스 연결 대기중...");
			conn=DriverManager.getConnection(dbURL,"root","mirim2");
			String sql="select seatNum from seat WHERE useable=1";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery(sql);
			System.out.println("성공");
			while(rs.next()) {
				seatNum=rs.getInt("seatNum");
				//System.out.println(seatNum);
				seat[seatNum-1].setEnabled(false);
				seat[seatNum-1].setFont(new Font("굴림", Font.BOLD, 20));
				use[seatNum-1].setText("사용중");
			}
			
		}catch(ClassNotFoundException e1) {
			e1.printStackTrace();
		}catch(SQLException e2) {
			e2.printStackTrace();
		}
	}
	public static void main(String[] args) {
		Buy_Time b=new Buy_Time();
		Client client=new Client();
		client.setGui(b);
		b.change();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		for(int i=0;i<seat.length;i++) {
			if(e.getSource()==seat[i]) {
				Modal m =new Modal(i);
				m.setVisible(true);
				seat[i].setEnabled(false);
				seat[i].setFont(new Font("굴림", Font.BOLD, 20));
				use[i].setText("사용중");
				break;
				
			}
		}
	}
}


