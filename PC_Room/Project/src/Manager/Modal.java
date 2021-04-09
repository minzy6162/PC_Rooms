package Manager;


import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import database.DBsave;



public class Modal extends JFrame{
	static JComboBox<String> ch=new JComboBox<String>();
	int result;
	int t=0;
	Container c=getContentPane();
	JPanel jp;
	Client client=new Client();
	ImageIcon background=new ImageIcon("D:\\2020년_Mirim_2nd\\자바 프로젝트\\2106_2118\\images\\400x400.png");
	ImageIcon iconCard=new ImageIcon("D:\\2020년_Mirim_2nd\\자바 프로젝트\\2106_2118\\images\\card.png");
	ImageIcon iconCash=new ImageIcon("D:\\2020년_Mirim_2nd\\자바 프로젝트\\2106_2118\\images\\cash.png");

	public Modal(int seatNum) {
		super("결재 창");
		
		setSize(400, 440);
		setLayout(null);
		setLocation(300,300);
		c.setBackground(new Color(128,0,128));

		jp=new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(background.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		jp.setBackground(new Color(128, 0, 128));
		jp.setLayout(null);
		jp.setSize(400, 480);
		
		JLabel time = new JLabel("-------------시간-------------");
		time.setForeground(Color.BLACK);
		time.setFont(new Font("HY동녘M", Font.PLAIN, 25));
		time.setLocation(100, 100);
		time.setBounds(66,10,1000,50);
		
		JLabel lb = new JLabel("원하는 시간대를 선택하세요.");
		lb.setForeground(Color.BLACK);
		lb.setFont(new Font("Hachoma", Font.PLAIN, 20));
		lb.setLocation(180,80);
		lb.setBounds(66,60,300,50);
		
		ch.addItem("1시간    1000천원");
		ch.addItem("2시간    2000천원");
		ch.addItem("3시간    3000천원");
		ch.addItem("4시간    4000천원");
		ch.addItem("5시간    5000천원");
		ch.setBounds(130,130,130,40);
	
		//getTime();
		JLabel payment = new JLabel("-------------결제-------------");
		payment.setForeground(Color.BLACK);
		payment.setFont(new Font("HY동녘M", Font.PLAIN, 25));
		payment.setLocation(0, 200);
		payment.setBounds(66,200,1000,50);
		
		JLabel way = new JLabel("결제 방법을 선택해주세요.");
		way.setForeground(Color.BLACK);
		way.setFont(new Font("Hachoma", Font.PLAIN, 20));
		way.setLocation(180,260);
		way.setBounds(66,250,300,50);
		
		JButton card = new JButton(iconCard);
		card.setFont(new Font("굴림", Font.PLAIN, 20));
		card.setBorderPainted(false);  // 외곽선 없애주기
		card.setContentAreaFilled(false);  // 버튼 투명 하게 
		card.setFocusPainted(false);  // 선택하면 테두리 안 나오게
		card.setBounds(55, 320, 80, 40);
		
		
		System.out.println(seatNum);
		
		
		ch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				t=(ch.getSelectedIndex()+1);
				System.out.println(t);
				
			}
		});
		
		
		card.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				t=setTime();
				JOptionPane.showMessageDialog(null, "카드결제 되었습니다.");
				DBsave db=new DBsave(seatNum+1, t, 1);
				client.connect();
				setVisible(false);
			}
			
			});
		
		JButton cash = new JButton(iconCash);
		cash.setFont(new Font("굴림", Font.PLAIN, 20));
		cash.setBorderPainted(false);  // 외곽선 없애주기
		cash.setContentAreaFilled(false);  // 버튼 투명 하게 
		cash.setFocusPainted(false);  // 선택하면 테두리 안 나오게
		cash.setBounds(240, 320, 80, 40);
		
		cash.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
					t=setTime();
					result=JOptionPane.showConfirmDialog(null, "현금으로 결제하시겠습니까?","Comfirm",JOptionPane.YES_NO_OPTION);
					DBsave db=new DBsave(seatNum+1, t, 1);
					client.connect();
					setVisible(false);
			}
			
			});
		jp.add(time);
		jp.add(lb);
		jp.add(ch);
		jp.add(payment);
		jp.add(way);
		jp.add(card);
		jp.add(cash);
		add(jp);
		setVisible(true);
	}
	public int setTime() {
		t=ch.getSelectedIndex();
		switch(t) {
		case 0: t=1; break;
		case 1: t=2; break;
		case 2: t=3; break;
		case 3: t=4; break;
		case 4: t=5; break;
		}
		return t;
	}
}