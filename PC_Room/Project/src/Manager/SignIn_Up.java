package Manager;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import database.DBnotmember;
import database.DBmember;


public class SignIn_Up {

	 JFrame frame;
	 JTextField T_Id;
	 JTextField T_Password;
	 JTextField T_NCardnumber;
	 JTextField T_SId;
	 JPasswordField PF_SPassword;
	 JTextField T_SName;
	
	JButton B_member ;//회원
	JButton B_Nmember;//비회원
	JButton B_SignUp;
	
	String member="";
	JButton B_Back;
	ImageIcon background=new ImageIcon("D:\\2020년_Mirim_2nd\\자바 프로젝트\\2106_2118\\images\\main_1.png");
	ImageIcon arrow=new ImageIcon("D:\\2020년_Mirim_2nd\\자바 프로젝트\\2106_2118\\images\\left.png");
	ImageIcon login=new ImageIcon("D:\\2020년_Mirim_2nd\\자바 프로젝트\\2106_2118\\images\\login.png");

	public SignIn_Up() {
		frame = new JFrame();
		frame.setTitle("메인화면");
		frame.setBounds(100, 100, 1400, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);//창 가운데 정렬
		frame.setResizable(false);//창 크기 고정
		
		
		
		
		//==================================================
		
		
		
		final JPanel PNmember = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(background.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};//비회원 화면
		PNmember.setBackground(new Color(128,0,128));
		PNmember.setBounds(0, 0, 1395, 965);
		frame.getContentPane().add(PNmember);
		PNmember.setLayout(null);
		
		JLabel L_NLing = new JLabel("비회원 Login");
		L_NLing.setForeground(Color.WHITE);
		L_NLing.setFont(new Font("HY동녘M", Font.PLAIN, 50));
		L_NLing.setBounds(550, 110, 318, 98);
		PNmember.add(L_NLing);
		
		JLabel L_NCardnumber = new JLabel("카드 번호 : ");
		L_NCardnumber.setForeground(Color.WHITE);
		L_NCardnumber.setBounds(484, 350, 204, 41);
		PNmember.add(L_NCardnumber);
		L_NCardnumber.setFont(new Font("굴림", Font.BOLD, 30));
		
		T_NCardnumber = new JTextField();
		T_NCardnumber.setFont(new Font("굴림", Font.PLAIN, 30));
		T_NCardnumber.setColumns(10);
		T_NCardnumber.setBounds(670, 350, 216, 41);
		PNmember.add(T_NCardnumber);
		
		JButton B_NLogin = new JButton(login);
		B_NLogin.setFont(new Font("굴림", Font.PLAIN, 20));
		B_NLogin.setBounds(655, 550, 100, 50);
		B_NLogin.setBorderPainted(false);  // 외곽선 없애주기
		B_NLogin.setContentAreaFilled(false);  // 버튼 투명 하게 
		B_NLogin.setFocusPainted(false);  // 선택하면 테두리 안 나오게
		PNmember.add(B_NLogin);
		
		JButton B_NBack = new JButton(arrow);
		B_NBack.setFont(new Font("굴림", Font.BOLD, 50));
		B_NBack.setBounds(14, 908, 90, 45);
		PNmember.add(B_NBack);
		B_NBack.setBorderPainted(false);  // 외곽선 없애주기
		B_NBack.setContentAreaFilled(false);  // 버튼 투명 하게 
		B_NBack.setFocusPainted(false);  // 선택하면 테두리 안 나오게
		PNmember.setVisible(false);
		
		//==================================================
		
		final JPanel Pmember = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(background.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};//회원 화면
		Pmember.setBackground(new Color(128,0,128));
		Pmember.setBounds(0, 0, 1395, 965);
		frame.getContentPane().add(Pmember);
		Pmember.setLayout(null);
		
		JLabel L_Login = new JLabel("회원 Login");
		L_Login.setForeground(Color.WHITE);
		L_Login.setBounds(600, 110, 264, 98);
		L_Login.setFont(new Font("HY동녘M", Font.PLAIN, 50));
		Pmember.add(L_Login);
		
		JLabel L_Id = new JLabel("아이디 : ");
		L_Id.setForeground(Color.WHITE);
		L_Id.setBounds(527, 320, 132, 45);
		L_Id.setFont(new Font("굴림", Font.BOLD, 30));
		Pmember.add(L_Id);
		
		T_Id = new JTextField();
		T_Id.setBounds(673, 320, 216, 41);
		T_Id.setFont(new Font("굴림", Font.PLAIN, 30));
		Pmember.add(T_Id);
		T_Id.setColumns(10);
		
		JLabel L_Password = new JLabel("비밀번호 : ");
		L_Password.setForeground(Color.WHITE);
		L_Password.setBounds(495, 450, 170, 45);
		L_Password.setFont(new Font("굴림", Font.BOLD, 30));
		Pmember.add(L_Password);
		
		T_Password = new JPasswordField();
		T_Password.setBounds(673, 450, 216, 41);
		T_Password.setFont(new Font("굴림", Font.PLAIN, 30));
		T_Password.setColumns(10);
		Pmember.add(T_Password);
		
		JButton B_Login = new JButton(login);
		B_Login.setBounds(656, 600, 100, 50);
		B_Login.setFont(new Font("굴림", Font.PLAIN, 20));
		B_Login.setBorderPainted(false);  // 외곽선 없애주기
		B_Login.setContentAreaFilled(false);  // 버튼 투명 하게 
		B_Login.setFocusPainted(false);  // 선택하면 테두리 안 나오게
		Pmember.add(B_Login);
		
		
		B_Back = new JButton(arrow);
		B_Back.setFont(new Font("굴림", Font.BOLD, 50));
		B_Back.setBounds(14, 908, 90, 45);
		B_Back.setBorderPainted(false);  // 외곽선 없애주기
		B_Back.setContentAreaFilled(false);  // 버튼 투명 하게 
		B_Back.setFocusPainted(false);  // 선택하면 테두리 안 나오게
		Pmember.add(B_Back);
		
		
		
		Pmember.setVisible(false);
		
		//==================================================        
		
		
		// 회원가입 화면
		final JPanel Psignup = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(background.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		Psignup.setBackground(new Color(128,0,128));
		Psignup.setBounds(0, 0, 1395, 965);
		frame.getContentPane().add(Psignup);
		Psignup.setLayout(null);
		
		JLabel L_Sinup = new JLabel("회원가입");
		L_Sinup.setForeground(Color.WHITE);
		L_Sinup.setFont(new Font("HY동녘M", Font.PLAIN, 50));
		L_Sinup.setBounds(600, 110, 213, 98);
		Psignup.add(L_Sinup);
		
		JLabel L_SName = new JLabel("이름 : ");
		L_SName.setForeground(Color.WHITE);
		L_SName.setFont(new Font("굴림", Font.BOLD, 30));
		L_SName.setBounds(545, 290, 132, 45);
		Psignup.add(L_SName);
		
		T_SName = new JTextField();
		T_SName.setFont(new Font("굴림", Font.PLAIN, 30));
		T_SName.setColumns(10);
		T_SName.setBounds(658, 290, 216, 41);
		Psignup.add(T_SName);
		
		JLabel L_SId = new JLabel("아이디 : ");
		L_SId.setForeground(Color.WHITE);
		L_SId.setFont(new Font("굴림", Font.BOLD, 30));
		L_SId.setBounds(512, 370, 132, 45);
		Psignup.add(L_SId);
		
		T_SId = new JTextField();
		T_SId.setFont(new Font("굴림", Font.PLAIN, 30));
		T_SId.setColumns(10);
		T_SId.setBounds(658, 370, 216, 41);
		Psignup.add(T_SId);
		
		JLabel L_SPassword = new JLabel("비밀번호 : ");
		L_SPassword.setForeground(Color.WHITE);
		L_SPassword.setFont(new Font("굴림", Font.BOLD, 30));
		L_SPassword.setBounds(480, 450, 170, 45);
		Psignup.add(L_SPassword);
		
		PF_SPassword = new JPasswordField();
		PF_SPassword.setFont(new Font("굴림", Font.PLAIN, 30));
		PF_SPassword.setColumns(10);
		PF_SPassword.setBounds(658, 450, 216, 41);
		Psignup.add(PF_SPassword);
		
		ImageIcon signup=new ImageIcon("D:\\2020년_Mirim_2nd\\자바 프로젝트\\2106_2118\\images\\signup.png");
		JButton B_signup = new JButton(signup);
		B_signup.setFont(new Font("굴림", Font.PLAIN, 20));
		B_signup.setBounds(650, 560, 132, 60);
		B_signup.setBorderPainted(false);  // 외곽선 없애주기
		B_signup.setContentAreaFilled(false);  // 버튼 투명 하게 
		B_signup.setFocusPainted(false);  // 선택하면 테두리 안 나오게
		Psignup.add(B_signup);
		
		JButton B_SBack = new JButton(arrow);
		B_SBack.setFont(new Font("굴림", Font.BOLD, 50));
		B_SBack.setBounds(14, 908, 90, 45);
		B_SBack.setBorderPainted(false);  // 외곽선 없애주기
		B_SBack.setContentAreaFilled(false);  // 버튼 투명 하게 
		B_SBack.setFocusPainted(false);  // 선택하면 테두리 안 나오게
		Psignup.add(B_SBack);
		
		ImageIcon doubleCheck=new ImageIcon("D:\\2020년_Mirim_2nd\\자바 프로젝트\\2106_2118\\images\\doubleCheck.png");
		JButton bnt_DoubleCheck = new JButton(doubleCheck);
		bnt_DoubleCheck.setBounds(890, 370, 90, 41);
		bnt_DoubleCheck.setBorderPainted(false);  // 외곽선 없애주기
		bnt_DoubleCheck.setContentAreaFilled(false);  // 버튼 투명 하게 
		bnt_DoubleCheck.setFocusPainted(false);  // 선택하면 테두리 안 나오게
		Psignup.add(bnt_DoubleCheck);
		Psignup.setVisible(false);
		
		//아이디 중복확인
		bnt_DoubleCheck.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DBmember db = new DBmember();
				 if( db.checkid(T_SId.getText()) ){ //중복아니다.(사용가능)
	                  //messageBox(this, T_SId.getText()+"는 사용가능합니다.");
	                  JOptionPane.showMessageDialog(null, T_SId.getText()+"는 사용가능합니다.");
	              }else{ //중복이다.
	                  JOptionPane.showMessageDialog(null, T_SId.getText()+"는 중복입니다.");
	                 
	                  T_SId.setText("");//text박스지우기
	                  T_SId.requestFocus();//커서놓기
	              }
			}


			
		});
	
		
		//==================================================  
		
		// 첫화면
		final JPanel Pmain = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(background.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		Pmain.setBackground(new Color(128,0,128));
		Pmain.setBounds(0, 0, 1395, 965);
		frame.getContentPane().add(Pmain);
		Pmain.setLayout(null);
		
		JLabel L_PCroom = new JLabel("PC방");
		L_PCroom.setForeground(Color.WHITE);
		L_PCroom.setBounds(630, 110, 200, 134);
		Pmain.add(L_PCroom);
		L_PCroom.setFont(new Font("HY동녘M", Font.PLAIN, 60));
		
		ImageIcon iconMember=new ImageIcon("D:\\2020년_Mirim_2nd\\자바 프로젝트\\2106_2118\\images\\member.png");
		B_member=new JButton(iconMember);
		B_member.setBounds(470, 400, 180, 80);
		B_member.setBorderPainted(false);  // 외곽선 없애주기
		B_member.setContentAreaFilled(false);  // 버튼 투명 하게 
		B_member.setFocusPainted(false);  // 선택하면 테두리 안 나오게
		Pmain.add(B_member);
		B_member.setFont(new Font("굴림", Font.BOLD, 40));
		
		ImageIcon notMember=new ImageIcon("D:\\2020년_Mirim_2nd\\자바 프로젝트\\2106_2118\\images\\notmember.png");
		B_Nmember=new JButton(notMember);	
		B_Nmember.setBounds(750, 400, 180, 80);
		B_Nmember.setBorderPainted(false);  // 외곽선 없애주기
		B_Nmember.setContentAreaFilled(false);  // 버튼 투명 하게 
		B_Nmember.setFocusPainted(false);  // 선택하면 테두리 안 나오게
		Pmain.add(B_Nmember);
		B_Nmember.setFont(new Font("굴림", Font.BOLD, 40));
		
		ImageIcon signup1=new ImageIcon("D:\\2020년_Mirim_2nd\\자바 프로젝트\\2106_2118\\images\\signup_1.png");
		B_SignUp = new JButton(signup1);//회원가입
		B_SignUp.setFont(new Font("굴림", Font.BOLD, 40));
		B_SignUp.setBounds(590, 550, 228, 90);
		B_SignUp.setBorderPainted(false);  // 외곽선 없애주기
		B_SignUp.setContentAreaFilled(false);  // 버튼 투명 하게 
		B_SignUp.setFocusPainted(false);  // 선택하면 테두리 안 나오게
		Pmain.add(B_SignUp);
		frame.add(Pmain);
		frame.setVisible(true);
		
		
		
		
		//==================================================  

		
		
		
		B_member.addActionListener(new ActionListener() {//메인 => 회원
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Pmember.setVisible(true);
				Pmain.setVisible(false);
				
				
			}
		});
		
		
		B_Back.addActionListener(new ActionListener() {//회원 => 메인
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Pmain.setVisible(true);
				Pmember.setVisible(false);
			}
		});
		
		
		
		B_Nmember.addActionListener(new ActionListener() {//메인 => 비회원
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				PNmember.setVisible(true);
				Pmain.setVisible(false);
				//s.setVisible(false);
				//s.setMember("비회원");
			}
		});
			
		
		B_NBack.addActionListener(new ActionListener() {//비회원 => 메인
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Pmain.setVisible(true);
				PNmember.setVisible(false);
			}
		});
		B_NLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String cardNum=T_NCardnumber.getText();
				member="비회원";
				DBnotmember db=new DBnotmember(member, cardNum);
				Buy_Time b=new Buy_Time();
				b.change();
				frame.setVisible(false);
			}
		});
		
		B_Login.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "로그인 되었습니다.");	
				Buy_Time b=new Buy_Time();
				b.change();
				frame.setVisible(false);
								
			}
		});
		

		
		B_SignUp.addActionListener(new ActionListener() {//메인 => 회원가입
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Psignup.setVisible(true);
				Pmain.setVisible(false);
			}
		});
		
		B_SBack.addActionListener(new ActionListener() {//회원가입 => 메인
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Pmain.setVisible(true);
				Psignup.setVisible(false);
			}
		});	
		
	B_signup.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//Hashtable loginUsers = new Hashtable();
		String t_SName=T_SName.getText();
		String t_SId=T_SId.getText();
		String t_Password=PF_SPassword.getPassword().toString();
			
		member="회원";
		DBmember db=new DBmember();
		db.insert(member, t_SId, t_Password, t_SName);	
		
		//DBsignup.createCustomer(t_SName, t_SId, t_Password);
		JOptionPane.showMessageDialog(null, "회원가입 되었습니다. 로그인 해주세요.");
		Pmember.setVisible(true);
		Psignup.setVisible(false);
			
		}
	});	
	}
	public static void main(String[] args) {
		SignIn_Up s=new SignIn_Up();
	}

}

