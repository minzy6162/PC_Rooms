package Manager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.Caret;

import database.DBfooddelete;
import database.DBfoodlist;

import javax.swing.JTextArea;
import javax.swing.JLabel;

public class FoodExam extends JFrame {
	int count = 0;
	String showfood = "";
	int k;
	String menu[] = { "탄산음료", "삼양라면", "짜파게티", "소떡소떡", "샌드위치", "샐러드", "카레덮밥", "치킨너겟" };// 메뉴
	int price[] = { 1000, 2500, 3000, 3000, 4500, 5000, 5500, 9000 };// 메뉴가격
	JButton bt[] = new JButton[menu.length];// 햄버거 버튼 누른 후에 수량 입력할 수있게
	JLabel jl[] = new JLabel[menu.length];
	JTextField quantity[] = new JTextField[menu.length]; // 몇개 주문할건지
	JButton minus[] = new JButton[menu.length];// 수량 빼기
	JButton plus[] = new JButton[menu.length];// 수량 더하기
	JButton ok[] = new JButton[menu.length];// 먹을만큼 정했으면 확인 누르기
	JLabel value[] = new JLabel[menu.length];// ~~원
	JButton seat[] = new JButton[16];
	JLabel[] l_seat = new JLabel[16];
	JTextArea need = new JTextArea("요구사항을 작성해주세요.", 7, 20);
	JTextArea ta = new JTextArea("", 0, 0);// 수량 입력하면 중앙에 나오는 값
	String seatNum;

	public FoodExam() {
		super("음식결제 창");
		setBounds(0, 0, 1300, 1000);
		setBackground(Color.black);

		// 폰트
		Font font1 = new Font(Font.MONOSPACED, Font.BOLD, 22);

		// 위쪽
		Panel panel = new Panel();
		panel.setBackground(new Color(128, 0, 128));
		panel.setLayout(null);
		panel.setSize(0, 500);
		// 배열 설정 부분
		
		ImageIcon drink=new ImageIcon("D:\\2020년_Mirim_2nd\\자바 프로젝트\\2106_2118\\images\\drink.png");
		ImageIcon ramen=new ImageIcon("D:\\2020년_Mirim_2nd\\자바 프로젝트\\2106_2118\\images\\ramen.png");
		ImageIcon jajang=new ImageIcon("D:\\2020년_Mirim_2nd\\자바 프로젝트\\2106_2118\\images\\jajang.png");
		ImageIcon so_tteok=new ImageIcon("D:\\2020년_Mirim_2nd\\자바 프로젝트\\2106_2118\\images\\so_tteok.png");
		ImageIcon sandwich=new ImageIcon("D:\\2020년_Mirim_2nd\\자바 프로젝트\\2106_2118\\images\\sandwich.png");
		ImageIcon salad=new ImageIcon("D:\\2020년_Mirim_2nd\\자바 프로젝트\\2106_2118\\images\\salad.png");
		ImageIcon curry=new ImageIcon("D:\\2020년_Mirim_2nd\\자바 프로젝트\\2106_2118\\images\\curry.png");
		ImageIcon chicken=new ImageIcon("D:\\2020년_Mirim_2nd\\자바 프로젝트\\2106_2118\\images\\chicken.png");

		// 버튼 설정 부분
		for (int i = 0; i < menu.length; i++) {

			// 음식 버튼
			bt[i] = new JButton(menu[i]);
			switch(i) {
			case 0:
				bt[i]=new JButton(drink);
				bt[i].setContentAreaFilled(false);
				bt[i].setBorderPainted(false);  // 외곽선 없애주기
				bt[i].setFocusPainted(false);  // 선택하면 테두리 안 나오게 
				break;
			case 1:
				bt[i]=new JButton(ramen);
				bt[i].setContentAreaFilled(false);
				bt[i].setBorderPainted(false);  // 외곽선 없애주기
				bt[i].setFocusPainted(false);  // 선택하면 테두리 안 나오게
				break;
			case 2:
				bt[i]=new JButton(jajang);
				bt[i].setContentAreaFilled(false);
				bt[i].setBorderPainted(false);  // 외곽선 없애주기
				bt[i].setFocusPainted(false);  // 선택하면 테두리 안 나오게
				break;
			case 3:
				bt[i]=new JButton(so_tteok);
				bt[i].setContentAreaFilled(false);
				bt[i].setBorderPainted(false);  // 외곽선 없애주기
				bt[i].setFocusPainted(false);  // 선택하면 테두리 안 나오게
				break;
			case 4:
				bt[i]=new JButton(sandwich);
				bt[i].setContentAreaFilled(false);
				bt[i].setBorderPainted(false);  // 외곽선 없애주기
				bt[i].setFocusPainted(false);  // 선택하면 테두리 안 나오게
				break;
			case 5:
				bt[i]=new JButton(salad);
				bt[i].setContentAreaFilled(false);
				bt[i].setBorderPainted(false);  // 외곽선 없애주기
				bt[i].setFocusPainted(false);  // 선택하면 테두리 안 나오게
				break;
			case 6:
				bt[i]=new JButton(curry);
				bt[i].setContentAreaFilled(false);
				bt[i].setBorderPainted(false);  // 외곽선 없애주기
				bt[i].setFocusPainted(false);  // 선택하면 테두리 안 나오게
				break;
			case 7:
				bt[i]=new JButton(chicken);
				bt[i].setContentAreaFilled(false);
				bt[i].setBorderPainted(false);  // 외곽선 없애주기
				bt[i].setFocusPainted(false);  // 선택하면 테두리 안 나오게
				break;
			}

			bt[i].setBackground(new Color(255, 255, 228, 255));
			if (i < 4) {
				bt[i].setBounds(25 + i * 150, 50, 100, 100);
			} else {
				bt[i].setBounds(25 + (i - 4) * 150, 300, 100, 100);
			}
			
//			

			// 숫자 txt 버튼
			quantity[i] = new JTextField("0");
			quantity[i].setBackground(Color.white);// 수량 상자 색
			quantity[i].setEditable(false);
			quantity[i].setBounds(bt[i].getX() + 30, bt[i].getY() + 130, 40, 20);

			// "-" 버튼
			minus[i] = new JButton("-");
			minus[i].setBounds(bt[i].getX(), quantity[i].getY(), 20, 20);
			minus[i].setFont(new Font("굴림", Font.BOLD, 5));
			minus[i].setEnabled(false);

			// "+" 버튼
			plus[i] = new JButton("+");
			plus[i].setBounds(bt[i].getX() + (100 - 20), quantity[i].getY(), 20, 20);
			plus[i].setFont(new Font("굴림", Font.BOLD, 7));
			plus[i].setEnabled(false);

			// 가격
			value[i] = new JLabel(price[i] + "원");
			value[i].setForeground(Color.WHITE);// 가격 글씨 색상
			value[i].setBounds(bt[i].getX() + 60, quantity[i].getY() - 25, 100, 20);
			
			// 음식 라벨
			jl[i] = new JLabel(menu[i]);
			jl[i].setBackground(new Color(255, 255, 228, 255));
			jl[i].setForeground(Color.WHITE);// 가격 글씨 색상
			jl[i].setBounds(bt[i].getX(), quantity[i].getY() - 25, 100, 20);

			// 확인 버튼
			ok[i] = new JButton("확인");
			ok[i].setBounds(bt[i].getX(), quantity[i].getY() + 30, 100, 20);
			ok[i].setEnabled(false);

			need.setBounds(600, 300, 350, 180);// x, y, w, h

			panel.add(bt[i]);
			panel.add(jl[i]);
			panel.add(quantity[i]);
			panel.add(minus[i]);
			panel.add(plus[i]);
			panel.add(value[i]);
			panel.add(ok[i]);
			panel.add(need);
		}


		// 중앙

		ta.setText("    좌석번호        상품명        단가        수량        합계        요구사항\n\n");
		ta.setBackground(Color.white);
		ta.setEditable(false);
		ta.setFont(font1);

		// 아래 버튼2개
		Panel panel2 = new Panel();
		panel2.setBackground(new Color(128, 0, 128));

		ImageIcon iconOrder=new ImageIcon("D:\\2020년_Mirim_2nd\\자바 프로젝트\\2106_2118\\images\\order.png");
		JButton order = new JButton(iconOrder);
		order.setContentAreaFilled(false);
		order.setBorderPainted(false);  // 외곽선 없애주기
		order.setFocusPainted(false);  // 선택하면 테두리 안 나오게


		ImageIcon iconReset=new ImageIcon("D:\\2020년_Mirim_2nd\\자바 프로젝트\\2106_2118\\images\\reset.png");
		JButton reset = new JButton(iconReset);
		reset.setContentAreaFilled(false);
		reset.setBorderPainted(false);  // 외곽선 없애주기
		reset.setFocusPainted(false);  // 선택하면 테두리 안 나오게
		
		panel2.add(order);
		panel2.add(reset);

		// 주문버튼
		order.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, ta.getText() + "\n 주문되었습니다. \n이용해주셔서 감사합니다.");

				for (int i = 0; i < menu.length; i++) {
					// DBfoodlist db=new DBfoodlist(seatNum, showfood, p, count, p * count,
					// need.getText());
					bt[i].setEnabled(true);
					minus[i].setEnabled(false);
					plus[i].setEnabled(false);
					quantity[i].setText("0");
					ta.setText("    좌석번호        상품명        단가        수량        합계        요구사항\n\n");

				}
			}
		});

		// 초기화 버튼
		reset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < menu.length; i++) {
					bt[i].setEnabled(true);
					minus[i].setEnabled(false);
					plus[i].setEnabled(false);
					quantity[i].setText("0");
					seat[i].setEnabled(true);
					seat[i].setBackground(new Color(255, 255, 228, 255));
					DBfooddelete db = new DBfooddelete(seatNum);
					ta.setText("    좌석번호        상품명        단가        수량        합계        요구사항\n\n");

				}
			}
		});
		need.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				need.setText("");
			}
		});
		// 컴포넌트
		add(panel, BorderLayout.NORTH);
		add(ta, BorderLayout.CENTER);
		add(panel2, BorderLayout.SOUTH);
		setVisible(true);

		// 좌석 버튼
		int q = 600;
		for (k = 0; k < 6; k++) {
			seat[k] = new JButton();
			seat[k].setLayout(null);
			l_seat[k] = new JLabel((k + 1) + "번");
			l_seat[k].setBounds(13, 0, 30, 30);// x, y, w, h
			seat[k].setBounds(new Rectangle(q, 50, 50, 50));// x, y, w, h
			q += 60;
			seat[k].setBackground(new Color(255, 255, 228, 255));
			l_seat[k].setFont(new Font("굴림", Font.BOLD, 15));
			seat[k].add(l_seat[k]);
			panel.add(seat[k]);

			seat[k].addActionListener(new ActionListener() {// 버튼을 누르면
				// 만들어진 버튼 "새 창 띄우기"에 버튼이 눌러지면 발생하는 행동을 정의
				@Override
				public void actionPerformed(ActionEvent e) {
					for (int i = 0; i < seat.length; i++) {
						if (e.getSource() == seat[i]) {
							seatNum = l_seat[i].getText();
							l_seat[i].setSize(30, 30);
							ta.append("      " + seatNum);

						}
					}

				}

			});

		}

		int s = 600;
		for (k = 6; k < 12; k++) {
			seat[k] = new JButton();
			seat[k].setLayout(null);
			l_seat[k] = new JLabel((k + 1) + "번");
			l_seat[k].setBounds(10, 0, 50, 50);// x, y, w, h
			seat[k].setBounds(new Rectangle(s, 115, 50, 50));// x, y, w, h
			s += 60;
			seat[k].setBackground(new Color(255, 255, 228, 255));
			l_seat[k].setFont(new Font("굴림", Font.BOLD, 15));
			seat[k].add(l_seat[k]);
			panel.add(seat[k]);

			seat[k].addActionListener(new ActionListener() {// 버튼을 누르면
				// 만들어진 버튼 "새 창 띄우기"에 버튼이 눌러지면 발생하는 행동을 정의
				@Override
				public void actionPerformed(ActionEvent e) {
					for (int i = 0; i < seat.length; i++) {
						if (e.getSource() == seat[i]) {
							seatNum = l_seat[i].getText();
							ta.append("      " + seatNum);

						}
					}

				}

			});

		}

		int a = 660;
		for (k = 12; k < 16; k++) {
			seat[k] = new JButton();
			seat[k].setLayout(null);
			l_seat[k] = new JLabel((k + 1) + "번");
			l_seat[k].setBounds(10, 0, 50, 50);// x, y, w, h
			seat[k].setBounds(new Rectangle(a, 180, 50, 50));// x, y, w, h
			a += 60;
			seat[k].setBackground(new Color(255, 255, 228, 255));
			l_seat[k].setFont(new Font("굴림", Font.BOLD, 15));
			seat[k].add(l_seat[k]);
			panel.add(seat[k]);

			seat[k].addActionListener(new ActionListener() {// 버튼을 누르면
				// 만들어진 버튼 "새 창 띄우기"에 버튼이 눌러지면 발생하는 행동을 정의
				@Override
				public void actionPerformed(ActionEvent e) {
					for (int i = 0; i < seat.length; i++) {
						if (e.getSource() == seat[i]) {
							seatNum = l_seat[i].getText();
							ta.append("      " + seatNum);
						}
					}

				}

			});
		}

		// 이벤트단
		for (int i = 0; i < menu.length; i++) {
			int j = i;

			// 햄버그 버튼 이벤트
			bt[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					minus[j].setEnabled(true);
					plus[j].setEnabled(true);
					bt[j].setEnabled(false);
					ok[j].setEnabled(true);

					count = 0;
				}
			});

			// "-" 버튼 이벤트
			minus[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if (count > 0) {
						count = count - 1;
						quantity[j].setText(count + "");
						ok[j].setEnabled(true);
					} else {
						minus[j].setEnabled(false);
					}
				}
			});

			// "+" 버튼 이벤트
			plus[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					count = count + 1;
					quantity[j].setText(count + "");
					ok[j].setEnabled(true);
					if (count > 0) {
						minus[j].setEnabled(true);
					}
				}
			});

			// 확인 버튼 이벤트
			ok[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					showfood = bt[j].getActionCommand();
					ta.append("\t   " + jl[j].getText());
					ta.append("       " + price[j]);
					ta.append("        " + count);
					ta.append("         " + price[j] * count);
					ta.append("원" + "         " + need.getText() + "\n");
					DBfoodlist db = new DBfoodlist();
					db.foodlist(seatNum, jl[j].getText(), price[j], count, price[j] * count, need.getText());
					bt[j].setEnabled(true);
					minus[j].setEnabled(false);
					plus[j].setEnabled(false);
					quantity[j].setText("0");
					ok[j].setEnabled(false);
					need.setText("");

				}
			});

		}

	}

	// 메인
	public static void main(String[] args) {
		new FoodExam();
	}
}
