package View;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;

import System.System_Control;
//import javafx.scene.control.Alert;

public class MainFrame extends JFrame { // 1) 사용자에게 출력되는 메인 프레임

	private static System_Control sys = new System_Control();
	private JPanel contentPane;

	public static System_Control getSystem() {
		return sys;
	}
	public static int input;
	/**
	 * Create the frame.
	 */
	public MainFrame() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/logo.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(117, 10, 284, 102);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("출금");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				input = 1;
				sys.input_menu(input);
				Input_ID_Frame Input_ID_withdraw = new Input_ID_Frame();
				Input_ID_withdraw.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton.setBounds(75, 144, 147, 43);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("입금");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				input = 2;
				sys.input_menu(input);
				Input_ID_Frame Input_ID_deposit = new Input_ID_Frame();
				Input_ID_deposit.setVisible(true);
				dispose();
			}
		});
		button.setBounds(292, 144, 147, 43);
		contentPane.add(button);
		
		JButton button_1 = new JButton("송금");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				input = 3;
				sys.input_menu(input);
				Input_ID_Frame Input_ID_remittance = new Input_ID_Frame();
				Input_ID_remittance.setVisible(true);
				dispose();
			}
		});
		button_1.setBounds(75, 216, 147, 43);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("조회");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				input = 4;
				sys.input_menu(input);
				Input_ID_Frame Input_ID_detailView = new Input_ID_Frame();
				Input_ID_detailView.setVisible(true);
				dispose();
			}
		});
		button_2.setBounds(292, 216, 147, 43);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("관리자");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				input = 5;
				sys.input_menu(input);
				Input_MID_Frame ManagerID = new Input_MID_Frame();
				ManagerID.setVisible(true);
				dispose();
				
			}
		});
		button_3.setBounds(292, 290, 147, 43);
		contentPane.add(button_3);
		
		if(sys.getATMcount().getCount50000()<=30 && sys.getATMcount().getCount10000()<=30) {
		JLabel label = new JLabel("5만원권, 만원권 부족합니다");
		label.setBounds(50, 300, 200, 15);
		contentPane.add(label);
		}
		else if(sys.getATMcount().getCount50000()<=30) {
			JLabel label = new JLabel("5만원권 부족합니다");
			label.setBounds(50, 300, 150, 15);
			contentPane.add(label);
		}
		else if(sys.getATMcount().getCount10000()<=30) {
			JLabel label = new JLabel("만원권 부족합니다");
			label.setBounds(50, 300, 150, 15);
			contentPane.add(label);
		}
	}

}

class Withdraw_Frame extends JFrame { // 3) 출금 금액을 입력하는 프레임
 
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	

	/**
	 * Create the frame.
	 */
	public Withdraw_Frame() {
		System_Control sys = MainFrame.getSystem();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/logo.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(117, 10, 284, 102);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uC608\uAE08\uCD9C\uAE08");
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_1.setBounds(215, 122, 84, 24);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(189, 212, 148, 24);
		contentPane.add(textField_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(189, 178, 148, 24);
		contentPane.add(textField);
		
		
		
		JLabel label = new JLabel("50,000");
		label.setBounds(130, 182, 57, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("10,000");
		label_1.setBounds(130, 216, 57, 15);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\uCD9C\uAE08\uC561 \uC218\uB7C9 \uC785\uB825");
		label_2.setFont(new Font("굴림", Font.PLAIN, 15));
		label_2.setBounds(208, 158, 127, 21);
		contentPane.add(label_2);
		
		JButton button_1 = new JButton("\uB3CC\uC544\uAC00\uAE30");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainFrame Back = new MainFrame();
				Back.setVisible(true);
				dispose();
				
			}
		});
		button_1.setFont(new Font("굴림", Font.BOLD, 15));
		button_1.setBounds(415, 328, 97, 23);
		contentPane.add(button_1);
		
		
		
		JButton button = new JButton("\uD655\uC778");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(sys.get_input_menu()==1) {
					String str = textField.getText();
					String str1 = textField_1.getText();
					Boolean isempty=textField.getText().isEmpty();
					Boolean isempty1=textField_1.getText().isEmpty();
					if(isempty) str = "0";
					if(isempty1) str1 = "0";
					for(int i=0; i<str.length(); i++) {
						if(str.charAt(i)>57 || str.charAt(i)<48) {
							isempty= true;
							isempty1= true;
						}
					}
					for(int i=0; i<str1.length(); i++) {
						if(str1.charAt(i)>57 || str1.charAt(i)<48) {
							isempty= true;
							isempty1= true;
						}
					}
					try {
						Integer.parseInt(str);
					} catch (NumberFormatException e) {
						// TODO: handle exception
						if(!isempty) isempty= true;
					}
					try {
						Integer.parseInt(str1);
					} catch (NumberFormatException e) {
						// TODO: handle exception
						if(!isempty1) isempty1= true;
					}
					ArrayList<Integer> input = new ArrayList<Integer>();
					if(isempty && isempty1){
						JOptionPane.showMessageDialog(null, "입력을 확인하세요", "입력 오류", JOptionPane.WARNING_MESSAGE);
					}
					else if(isempty && !Integer.valueOf(str1).equals(0)) {
						input.add(Integer.valueOf(0));
						input.add(Integer.valueOf(textField_1.getText()));
						int ischeck = MainFrame.getSystem().input_amount(input);
						if(ischeck==0) {
							InputPW_Frame inputPWF = new InputPW_Frame();
							inputPWF.setVisible(true);
							dispose();
						}
						else {
							JOptionPane.showMessageDialog(null, "비밀번호 확인하세요", "비밀번호 오류", JOptionPane.WARNING_MESSAGE);
						}
					}
					else if(isempty1 && !Integer.valueOf(str).equals(0)) {
						input.add(Integer.valueOf(textField.getText()));
						input.add(Integer.valueOf(0));
						int ischeck = MainFrame.getSystem().input_amount(input);
						if(ischeck==0) {
							InputPW_Frame inputPWF = new InputPW_Frame();
							inputPWF.setVisible(true);
							dispose();
						}
						else {
							JOptionPane.showMessageDialog(null, "비밀번호 확인하세요", "비밀번호 오류", JOptionPane.WARNING_MESSAGE);
						}
					}
					else if((!isempty && !isempty1)&&!Integer.valueOf(str).equals(0)||!Integer.valueOf(str1).equals(0)) {
						input.add(Integer.valueOf(textField.getText()));
						input.add(Integer.valueOf(textField_1.getText()));
						int ischeck = MainFrame.getSystem().input_amount(input);
						if(ischeck==0) {
							InputPW_Frame inputPWF = new InputPW_Frame();
							inputPWF.setVisible(true);
							dispose();
						}
						else {
							JOptionPane.showMessageDialog(null, "비밀번호 확인하세요", "비밀번호 오류", JOptionPane.WARNING_MESSAGE);
						}
					}
					else{
						JOptionPane.showMessageDialog(null, "입력을 확인하세요", "입력 오류", JOptionPane.WARNING_MESSAGE);
					}
					
				}
				
				
			}
		});
		button.setFont(new Font("굴림", Font.BOLD, 15));
		button.setBounds(214, 319, 97, 23);
		contentPane.add(button);
		
		
	}
}

class Deposit_Frame extends JFrame { // 14) 입금 금액을 입력하는 프레임

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	 /* Create the frame.
	 */
	public Deposit_Frame() {
		System_Control sys = MainFrame.getSystem();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/logo.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(117, 10, 284, 102);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uC785\uAE08");
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_1.setBounds(242, 124, 42, 24);
		contentPane.add(lblNewLabel_1);
		
		JLabel label = new JLabel("50,000");
		label.setBounds(130, 182, 57, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("10,000");
		label_1.setBounds(130, 216, 57, 15);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\uC785\uAE08\uC561 \uC218\uB7C9 \uC785\uB825");
		label_2.setFont(new Font("굴림", Font.PLAIN, 15));
		label_2.setBounds(208, 158, 127, 21);
		contentPane.add(label_2);
		
		JButton button = new JButton("\uD655\uC778");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String str = textField_1.getText();
				String str1 = textField.getText();
				String str2 = textField_2.getText();
				String str3 = textField_3.getText();
				Boolean isempty=textField_1.getText().isEmpty();
				Boolean isempty1=textField.getText().isEmpty();
				Boolean isempty2=textField_2.getText().isEmpty();
				Boolean isempty3=textField_3.getText().isEmpty();
				if(isempty) str = "0";
				if(isempty1) str1 = "0";
				if(isempty2) str2 = "0";
				if(isempty3) str3 = "0";
				for(int i=0; i<str.length(); i++) {
					if(str.charAt(i)>57 || str.charAt(i)<48) {
						isempty= true;
						isempty1= true;
						isempty2= true;
						isempty3= true;
					}
				}
				for(int i=0; i<str1.length(); i++) {
					if(str1.charAt(i)>57 || str1.charAt(i)<48) {
						isempty= true;
						isempty1= true;
						isempty2= true;
						isempty3= true;
					}
				}
				for(int i=0; i<str2.length(); i++) {
					if(str2.charAt(i)>57 || str2.charAt(i)<48) {
						isempty= true;
						isempty1= true;
						isempty2= true;
						isempty3= true; 
					}
				}
				for(int i=0; i<str3.length(); i++) {
					if(str3.charAt(i)>57 || str3.charAt(i)<48) {
						isempty= true;
						isempty1= true;
						isempty2= true;
						isempty3= true;
					}
				}
				try {
					Integer.parseInt(str);
					Integer.parseInt(str1);
					Integer.parseInt(str2);
					Integer.parseInt(str3);
				} catch (NumberFormatException e) {
					// TODO: handle exception
					isempty= true;
					isempty1= true;
					isempty2= true;
					isempty3= true;
				}
				ArrayList<Integer> input = new ArrayList<Integer>();
				if(isempty && isempty2 && isempty3 && isempty1) {
					JOptionPane.showMessageDialog(null, "입력을 확인하세요", "입력 오류", JOptionPane.WARNING_MESSAGE);
				}
				else if(Integer.valueOf(str).equals(0)&&Integer.valueOf(str1).equals(0)&&Integer.valueOf(str2).equals(0)&&Integer.valueOf(str3).equals(0)) {
					JOptionPane.showMessageDialog(null, "입력을 확인하세요", "입력 오류", JOptionPane.WARNING_MESSAGE);
				}
				else if(!isempty && Integer.parseInt(str)>500 || (MainFrame.getSystem().getATMcount().getCount50000()+Integer.parseInt(str) > 500)) {
					JOptionPane.showMessageDialog(null, "5만원권을 입력 초과하였습니다.", "입력 오류", JOptionPane.WARNING_MESSAGE);
				}
				else if(!isempty1 && Integer.parseInt(str1)>500 || (MainFrame.getSystem().getATMcount().getCount10000()+Integer.parseInt(str1) > 500)) {
					JOptionPane.showMessageDialog(null, "만원권을 입력 초과하였습니다.", "입력 오류", JOptionPane.WARNING_MESSAGE);
				}
				else if(!isempty2 && Integer.parseInt(str2)>500 || (MainFrame.getSystem().getATMcount().getCount5000()+Integer.parseInt(str2) > 500)) {
					JOptionPane.showMessageDialog(null, "5천원권을 입력 초과하였습니다.", "입력 오류", JOptionPane.WARNING_MESSAGE);
				}
				else if(!isempty3 && Integer.parseInt(str1)>500 || (MainFrame.getSystem().getATMcount().getCount1000()+Integer.parseInt(str3) > 500)) {
					JOptionPane.showMessageDialog(null, "천원권을 입력 초과하였습니다.", "입력 오류", JOptionPane.WARNING_MESSAGE);
				}
				else {
					input.add(Integer.valueOf(str));
					input.add(Integer.valueOf(str1));
					input.add(Integer.valueOf(str2));
					input.add(Integer.valueOf(str3));

					int ischeck = MainFrame.getSystem().input_amount(input);
					if(ischeck>=0) {
						Result_Frame inputPWF = new Result_Frame(ischeck);
						inputPWF.setVisible(true);
						dispose();
					}
					else if(ischeck==-1){
						JOptionPane.showMessageDialog(null, "비밀번호 확인하세요", "비밀번호 오류", JOptionPane.WARNING_MESSAGE);
					}
					else if(ischeck==-2){
						JOptionPane.showMessageDialog(null, "잔고 확인하세요", "잔고 부족", JOptionPane.WARNING_MESSAGE);
					}
					else if(ischeck==-3) {
						JOptionPane.showMessageDialog(null, "ATM잔고 부족입니다", "ATM잔고 부족", JOptionPane.WARNING_MESSAGE);
					}
					else if(ischeck==-4) {
						JOptionPane.showMessageDialog(null, "일반계좌 최대 입금한도는 10억입니다", "한도초과", JOptionPane.WARNING_MESSAGE);
					}
					else if(ischeck==-5) {
						JOptionPane.showMessageDialog(null, "ATM잔고 최대 한도는 초과입니다", "한도초과", JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});
		button.setFont(new Font("굴림", Font.BOLD, 15));
		button.setBounds(214, 319, 97, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\uB3CC\uC544\uAC00\uAE30");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainFrame Back = new MainFrame();
				Back.setVisible(true);
				dispose();
				
			}
		});
		button_1.setFont(new Font("굴림", Font.BOLD, 15));
		button_1.setBounds(415, 328, 97, 23);
		contentPane.add(button_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(189, 210, 148, 24);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(189, 176, 148, 24);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(189, 247, 148, 24);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(189, 281, 148, 24);
		contentPane.add(textField_3);
		
		JLabel label_3 = new JLabel("1,000");
		label_3.setBounds(130, 287, 57, 15);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("5,000");
		label_4.setBounds(130, 253, 57, 15);
		contentPane.add(label_4);
	
	}

}

class Input_ID_Frame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Create the frame.
	 */
	public Input_ID_Frame() { // 1. 사용자의 ID 를 입력받는 프레임
		System_Control sys = MainFrame.getSystem();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 540, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/logo.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(117, 10, 284, 102);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("통장/카드 입력");
		label.setFont(new Font("굴림", Font.BOLD, 20));
		label.setBounds(192, 143, 144, 24);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setBounds(95, 189, 338, 34);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("\uD655\uC778");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String str = textField.getText();
				Boolean isempty=textField.getText().isEmpty();
				for(int i=0; i<str.length(); i++) {
					if(str.charAt(i)>57 || str.charAt(i)<48) isempty= true; 
				}
				try {
					Integer.parseInt(str);
				} catch (NumberFormatException e) {
					// TODO: handle exception
					isempty= true; 
				}
				if (sys.get_input_menu()==1)//입금     //&& sys.input_ID(input)==true)
				{
					if(!isempty) {
						Boolean ischeck = MainFrame.getSystem().input_ID(Integer.parseInt(str));
						if(ischeck) {
							Withdraw_Frame withdrawF = new Withdraw_Frame();
							withdrawF.setVisible(true);
							dispose();
						}
						else {
							JOptionPane.showMessageDialog(null, "계좌/카드 확인하세요", "계좌/카드 오류", JOptionPane.WARNING_MESSAGE);
						}
					}
					else{
						JOptionPane.showMessageDialog(null, "입력을 확인하세요", "입력 오류", JOptionPane.WARNING_MESSAGE);
					}
				}
				else if(sys.get_input_menu()==2)//출금
				{
					if(!isempty) {
						Boolean ischeck = MainFrame.getSystem().input_ID(Integer.parseInt(str));
						if(ischeck) {
							Deposit_Frame depositF = new Deposit_Frame();
							depositF.setVisible(true);
							dispose();
						}
						else {
							JOptionPane.showMessageDialog(null, "계좌/카드 확인하세요", "계좌/카드 오류", JOptionPane.WARNING_MESSAGE);
						}
					}
					else{
						JOptionPane.showMessageDialog(null, "입력을 확인하세요", "입력 오류", JOptionPane.WARNING_MESSAGE);
					}
				}
				else if(sys.get_input_menu()==3)//송금
				{
					if(!isempty) {
						Boolean ischeck = MainFrame.getSystem().input_ID(Integer.parseInt(str));
						if(ischeck) {
							ReceiverID_Frame ReceiverF = new ReceiverID_Frame();
							ReceiverF.setVisible(true);
							dispose();
						}
						else {
							JOptionPane.showMessageDialog(null, "계좌/카드 확인하세요", "계좌/카드 오류", JOptionPane.WARNING_MESSAGE);
						}
					}
					else{
						JOptionPane.showMessageDialog(null, "입력을 확인하세요", "입력 오류", JOptionPane.WARNING_MESSAGE);
					}
					
				}
				else if(sys.get_input_menu()==4)//조회
				{
					if(!isempty) {
						Boolean ischeck = MainFrame.getSystem().input_ID(Integer.parseInt(str));
						if(ischeck) {
							InputPW_Frame InputPWF = new InputPW_Frame();
							InputPWF.setVisible(true);
							dispose();
						}
						else {
							JOptionPane.showMessageDialog(null, "계좌/카드 확인하세요", "계좌/카드 오류", JOptionPane.WARNING_MESSAGE);
						}
					}
					else{
						JOptionPane.showMessageDialog(null, "입력을 확인하세요", "입력 오류", JOptionPane.WARNING_MESSAGE);
					}
				}
//				else if(sys.get_input_menu()==1)
//				{
//					JOptionPane.showMessageDialog(null, "계좌번호를 확인하세요", "계좌번호 오류", JOptionPane.WARNING_MESSAGE);
//
//					
//				}
			}
		});
		button.setFont(new Font("굴림", Font.BOLD, 15));
		button.setBounds(220, 255, 97, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\uB3CC\uC544\uAC00\uAE30");
		button_1.setFont(new Font("굴림", Font.BOLD, 15));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainFrame Back = new MainFrame();
				Back.setVisible(true);
				dispose();
				
			}
		});
		button_1.setBounds(415, 328, 97, 23);
		contentPane.add(button_1);
	}
}

class Remmitance_Frame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Create the frame.
	 */
	public Remmitance_Frame() {
		System_Control sys = MainFrame.getSystem();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/logo.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(117, 10, 284, 102);
		contentPane.add(lblNewLabel);
		
		
		JLabel label = new JLabel("\uC1A1\uAE08 \uAE08\uC561 \uC785\uB825");
		label.setFont(new Font("굴림", Font.BOLD, 20));
		label.setBounds(188, 143, 175, 24);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(95, 189, 338, 34);
		contentPane.add(textField);
		
		JButton button = new JButton("\uD655\uC778");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String str = textField.getText();
				Boolean isempty=textField.getText().isEmpty();
				for(int i=0; i<str.length(); i++) {
					if(str.charAt(i)>57 || str.charAt(i)<48) isempty= true; 
				}
				try {
					Integer.parseInt(str);
				} catch (NumberFormatException e) {
					// TODO: handle exception
					isempty= true; 
				}
				if(!isempty) {
					ArrayList<Integer> input = new ArrayList<Integer>();
					input.add(Integer.parseInt(str));
					int ischeck = MainFrame.getSystem().input_amount(input);
					if(ischeck==0) {
						InputPW_Frame InputPWF = new InputPW_Frame();
						InputPWF.setVisible(true);
						dispose();
					}
					else {
						JOptionPane.showMessageDialog(null, "계좌/카드 확인하세요", "계좌/카드 오류", JOptionPane.WARNING_MESSAGE);
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "입력을 확인하세요", "입력 오류", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		button.setFont(new Font("굴림", Font.BOLD, 15));
		button.setBounds(220, 255, 97, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\uB3CC\uC544\uAC00\uAE30");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainFrame Back = new MainFrame();
				Back.setVisible(true);
				dispose();
				
			}
		});
		button_1.setFont(new Font("굴림", Font.BOLD, 15));
		button_1.setBounds(415, 328, 97, 23);
		contentPane.add(button_1);
		
		
		
	}

}

class ReceiverID_Frame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Create the frame.
	 */
	public ReceiverID_Frame() {
		System_Control sys = MainFrame.getSystem();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/logo.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(117, 10, 284, 102);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(95, 189, 338, 34);
		contentPane.add(textField);
		
		JLabel label = new JLabel("\uC218\uCDE8\uC778 \uACC4\uC88C \uC785\uB825");
		label.setFont(new Font("굴림", Font.BOLD, 20));
		label.setBounds(180, 143, 175, 24);
		contentPane.add(label);
		
		JButton button = new JButton("\uD655\uC778");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String str = textField.getText();
				Boolean isempty=textField.getText().isEmpty();
				for(int i=0; i<str.length(); i++) {
					if(str.charAt(i)>57 || str.charAt(i)<48) isempty= true; 
				}
				try {
					Integer.parseInt(str);
				} catch (NumberFormatException e) {
					// TODO: handle exception
					isempty= true; 
				}
				if(!isempty) {
					Boolean ischeck = MainFrame.getSystem().input_RID(Integer.parseInt(str));
					if(ischeck) {
						Remmitance_Frame RemmitanceF = new Remmitance_Frame();
						RemmitanceF.setVisible(true);
						dispose();
					}
					else {
						JOptionPane.showMessageDialog(null, "계좌/카드 확인하세요", "계좌/카드 오류", JOptionPane.WARNING_MESSAGE);
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "입력을 확인하세요", "입력 오류", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		button.setFont(new Font("굴림", Font.BOLD, 15));
		button.setBounds(220, 255, 97, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\uB3CC\uC544\uAC00\uAE30");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainFrame Back = new MainFrame();
				Back.setVisible(true);
				dispose();
				
			}
		});
		
		button_1.setFont(new Font("굴림", Font.BOLD, 15));
		button_1.setBounds(415, 328, 97, 23);
		contentPane.add(button_1);
		
		
	}

}

class MDeposit_Frame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Create the frame.
	 */
	public MDeposit_Frame() {
		System_Control sys = MainFrame.getSystem();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/logo.png")).getImage();
		contentPane.setLayout(null);
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(122, 10, 279, 95);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(189, 210, 148, 24);
		contentPane.add(textField);
		
		JLabel label = new JLabel("10,000");
		label.setBounds(130, 216, 57, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("50,000");
		label_1.setBounds(130, 182, 57, 15);
		contentPane.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(189, 176, 148, 24);
		contentPane.add(textField_1);
		
		
		
		JLabel label_2 = new JLabel("\uCD9C\uAE08\uC561 \uC218\uB7C9 \uC785\uB825");
		label_2.setFont(new Font("굴림", Font.PLAIN, 15));
		label_2.setBounds(208, 158, 127, 21);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("\uAD00\uB9AC\uC790 \uBAA8\uB4DC(\uCD9C\uAE08)");
		label_3.setFont(new Font("굴림", Font.BOLD, 20));
		label_3.setBounds(179, 126, 169, 24);
		contentPane.add(label_3);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(189, 247, 148, 24);
		contentPane.add(textField_2);
		
		JLabel label_4 = new JLabel("5,000");
		label_4.setBounds(130, 253, 57, 15);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("1,000");
		label_5.setBounds(130, 287, 57, 15);
		contentPane.add(label_5);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(189, 281, 148, 24);
		contentPane.add(textField_3);
		
		JButton button = new JButton("\uD655\uC778");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String str = textField_1.getText();
				String str1 = textField.getText();
				String str2 = textField_2.getText();
				String str3 = textField_3.getText();
				Boolean isempty=textField_1.getText().isEmpty();
				Boolean isempty1=textField.getText().isEmpty();
				Boolean isempty2=textField_2.getText().isEmpty();
				Boolean isempty3=textField_3.getText().isEmpty();
				if(isempty) str = "0";
				if(isempty1) str1 = "0";
				if(isempty2) str2 = "0";
				if(isempty3) str3 = "0";
				for(int i=0; i<str.length(); i++) {
					if(str.charAt(i)>57 || str.charAt(i)<48) {
						isempty= true;
						isempty1= true;
						isempty2= true;
						isempty3= true;
					}
				}
				for(int i=0; i<str1.length(); i++) {
					if(str1.charAt(i)>57 || str1.charAt(i)<48) {
						isempty= true;
						isempty1= true;
						isempty2= true;
						isempty3= true;
					}
				}
				for(int i=0; i<str2.length(); i++) {
					if(str2.charAt(i)>57 || str2.charAt(i)<48) {
						isempty= true;
						isempty1= true;
						isempty2= true;
						isempty3= true; 
					}
				}
				for(int i=0; i<str3.length(); i++) {
					if(str3.charAt(i)>57 || str3.charAt(i)<48) {
						isempty= true;
						isempty1= true;
						isempty2= true;
						isempty3= true;
					}
				}
				try {
					Integer.parseInt(str);
					Integer.parseInt(str1);
					Integer.parseInt(str2);
					Integer.parseInt(str3);
				} catch (NumberFormatException e) {
					// TODO: handle exception
					isempty= true;
					isempty1= true;
					isempty2= true;
					isempty3= true;
				}
				ArrayList<Integer> input = new ArrayList<Integer>();
				if(isempty && isempty2 && isempty3 && isempty1) {
					JOptionPane.showMessageDialog(null, "입력을 확인하세요", "입력 오류", JOptionPane.WARNING_MESSAGE);
				}
				else if(Integer.valueOf(str).equals(0)&&Integer.valueOf(str1).equals(0)&&Integer.valueOf(str2).equals(0)&&Integer.valueOf(str3).equals(0)) {
					JOptionPane.showMessageDialog(null, "입력을 확인하세요", "입력 오류", JOptionPane.WARNING_MESSAGE);
				}
				else {
					input.add(Integer.valueOf(str));
					input.add(Integer.valueOf(str1));
					input.add(Integer.valueOf(str2));
					input.add(Integer.valueOf(str3));

					int ischeck = MainFrame.getSystem().input_amount(input);
					if(ischeck>=0) {
						Manager_Frame Manage = new Manager_Frame();
						Manage.setVisible(true);
						dispose();
					}
					else {
						JOptionPane.showMessageDialog(null, "잔고 확인하세요", "잔고 오류", JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});
		button.setFont(new Font("굴림", Font.BOLD, 15));
		button.setBounds(214, 319, 97, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\uB3CC\uC544\uAC00\uAE30");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainFrame Back = new MainFrame();
				Back.setVisible(true);
				dispose();
				
			}
		});
		button_1.setFont(new Font("굴림", Font.BOLD, 15));
		button_1.setBounds(415, 328, 97, 23);
		contentPane.add(button_1);
	}

}

class MWithdraw_Frame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Create the frame.
	 */
	public MWithdraw_Frame() {
		System_Control sys = MainFrame.getSystem();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/logo.png")).getImage();
		contentPane.setLayout(null);
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(122, 10, 279, 95);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("\uAD00\uB9AC\uC790 \uBAA8\uB4DC(\uC785\uAE08)");
		label.setFont(new Font("굴림", Font.BOLD, 20));
		label.setBounds(179, 126, 169, 24);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\uC785\uAE08\uC561 \uC218\uB7C9 \uC785\uB825");
		label_1.setFont(new Font("굴림", Font.PLAIN, 15));
		label_1.setBounds(208, 158, 127, 21);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("50,000");
		label_2.setBounds(130, 182, 57, 15);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("10,000");
		label_3.setBounds(130, 216, 57, 15);
		contentPane.add(label_3);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(189, 176, 148, 24);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(189, 210, 148, 24);
		contentPane.add(textField_1);
		
		JLabel label_4 = new JLabel("5,000");
		label_4.setBounds(130, 253, 57, 15);
		contentPane.add(label_4);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(189, 247, 148, 24);
		contentPane.add(textField_2);
		
		JLabel label_5 = new JLabel("1,000");
		label_5.setBounds(130, 287, 57, 15);
		contentPane.add(label_5);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(189, 281, 148, 24);
		contentPane.add(textField_3);
		
		JButton button = new JButton("\uD655\uC778");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String str = textField.getText();
				String str1 = textField_1.getText();
				String str2 = textField_2.getText();
				String str3 = textField_3.getText();
				Boolean isempty=textField.getText().isEmpty();
				Boolean isempty1=textField_1.getText().isEmpty();
				Boolean isempty2=textField_2.getText().isEmpty();
				Boolean isempty3=textField_3.getText().isEmpty();
				if(isempty) str = "0";
				if(isempty1) str1 = "0";
				if(isempty2) str2 = "0";
				if(isempty3) str3 = "0";
				for(int i=0; i<str.length(); i++) {
					if(str.charAt(i)>57 || str.charAt(i)<48) {
						isempty= true;
						isempty1= true;
						isempty2= true;
						isempty3= true;
					}
				}
				for(int i=0; i<str1.length(); i++) {
					if(str1.charAt(i)>57 || str1.charAt(i)<48) {
						isempty= true;
						isempty1= true;
						isempty2= true;
						isempty3= true;
					}
				}
				for(int i=0; i<str2.length(); i++) {
					if(str2.charAt(i)>57 || str2.charAt(i)<48) {
						isempty= true;
						isempty1= true;
						isempty2= true;
						isempty3= true; 
					}
				}
				for(int i=0; i<str3.length(); i++) {
					if(str3.charAt(i)>57 || str3.charAt(i)<48) {
						isempty= true;
						isempty1= true;
						isempty2= true;
						isempty3= true;
					}
				}
				try {
					Integer.parseInt(str);
					Integer.parseInt(str1);
					Integer.parseInt(str2);
					Integer.parseInt(str3);
				} catch (NumberFormatException e) {
					// TODO: handle exception
					isempty= true;
					isempty1= true;
					isempty2= true;
					isempty3= true;
				}
				ArrayList<Integer> input = new ArrayList<Integer>();
				if(isempty && isempty2 && isempty3 && isempty1) {
					JOptionPane.showMessageDialog(null, "입력을 확인하세요", "입력 오류", JOptionPane.WARNING_MESSAGE);
				}
				else if(Integer.valueOf(str).equals(0)&&Integer.valueOf(str1).equals(0)&&Integer.valueOf(str2).equals(0)&&Integer.valueOf(str3).equals(0)) {
					JOptionPane.showMessageDialog(null, "입력을 확인하세요", "입력 오류", JOptionPane.WARNING_MESSAGE);
				}
				else if((!isempty && Integer.parseInt(str)>500) || (MainFrame.getSystem().getATMcount().getCount50000()+Integer.parseInt(str) > 500)) {
					JOptionPane.showMessageDialog(null, "5만원권을 입력 초과하였습니다.", "입력 오류", JOptionPane.WARNING_MESSAGE);
				}
				else if((!isempty1 && Integer.parseInt(str1)>500) || (MainFrame.getSystem().getATMcount().getCount10000()+Integer.parseInt(str1) > 500)) {
					JOptionPane.showMessageDialog(null, "만원권을 입력 초과하였습니다.", "입력 오류", JOptionPane.WARNING_MESSAGE);
				}
				else if((!isempty2 && Integer.parseInt(str2)>500) || (MainFrame.getSystem().getATMcount().getCount5000()+Integer.parseInt(str2) > 500)) {
					JOptionPane.showMessageDialog(null, "5천원권을 입력 초과하였습니다.", "입력 오류", JOptionPane.WARNING_MESSAGE);
				}
				else if((!isempty3 && Integer.parseInt(str1)>500) || (MainFrame.getSystem().getATMcount().getCount1000()+Integer.parseInt(str3) > 500)) {
					JOptionPane.showMessageDialog(null, "천원권을 입력 초과하였습니다.", "입력 오류", JOptionPane.WARNING_MESSAGE);
				}
				else {
					input.add(Integer.valueOf(str));
					input.add(Integer.valueOf(str1));
					input.add(Integer.valueOf(str2));
					input.add(Integer.valueOf(str3));

					int ischeck = MainFrame.getSystem().input_amount(input);
					if(ischeck>=0) {
						Manager_Frame Manage = new Manager_Frame();
						Manage.setVisible(true);
						dispose();
					}
					else {
						JOptionPane.showMessageDialog(null, "잔고 확인하세요", "잔고 오류", JOptionPane.WARNING_MESSAGE);
					}
				}
			
			}
		});
		button.setFont(new Font("굴림", Font.BOLD, 15));
		button.setBounds(214, 319, 97, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\uB3CC\uC544\uAC00\uAE30");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainFrame Back = new MainFrame();
				Back.setVisible(true);
				dispose();
				
			}
		});
		button_1.setFont(new Font("굴림", Font.BOLD, 15));
		button_1.setBounds(415, 328, 97, 23);
		contentPane.add(button_1);
	}

}

class Input_MPW_Frame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Create the frame.
	 */
	public Input_MPW_Frame() {
		System_Control sys = MainFrame.getSystem();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/logo.png")).getImage();
		contentPane.setLayout(null);
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(122, 10, 279, 95);
		contentPane.add(lblNewLabel);
		
		JLabel lblPw = new JLabel("\uAD00\uB9AC\uC790 PW \uC785\uB825");
		lblPw.setFont(new Font("굴림", Font.BOLD, 20));
		lblPw.setBounds(192, 143, 152, 24);
		contentPane.add(lblPw);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(95, 189, 338, 34);
		contentPane.add(textField);
		
		JButton button = new JButton("\uD655\uC778");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String str = textField.getText();
				Boolean isempty=textField.getText().isEmpty();
				for(int i=0; i<str.length(); i++) {
					if(str.charAt(i)>57 || str.charAt(i)<48) {
						isempty= true;
					}
				}
				try {
					Integer.parseInt(str);
				} catch (NumberFormatException e) {
					// TODO: handle exception
					isempty= true; 
				}
				if(!isempty) {
					Boolean ischeck = MainFrame.getSystem().input_MPW(Integer.parseInt(str));
					if(ischeck) {
						Manager_Frame Manage = new Manager_Frame();
						Manage.setVisible(true);
						dispose();
					}
					else {
						JOptionPane.showMessageDialog(null, "PW 확인하세요", "PW 오류", JOptionPane.WARNING_MESSAGE);
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "입력을 확인하세요", "입력 오류", JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		button.setFont(new Font("굴림", Font.BOLD, 15));
		button.setBounds(220, 255, 97, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\uB3CC\uC544\uAC00\uAE30");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainFrame Back = new MainFrame();
				Back.setVisible(true);
				dispose();
				
			}
		});
		button_1.setFont(new Font("굴림", Font.BOLD, 15));
		button_1.setBounds(415, 328, 97, 23);
		contentPane.add(button_1);
	}

}

class Manager_Frame extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public Manager_Frame() {
		System_Control sys = MainFrame.getSystem();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/logo.png")).getImage();
		contentPane.setLayout(null);
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(122, 10, 279, 95);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("50,000");
		label.setBounds(132, 182, 57, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("10,000");
		label_1.setBounds(132, 216, 57, 15);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("5,000");
		label_2.setBounds(132, 253, 57, 15);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("1,000");
		label_3.setBounds(132, 287, 57, 15);
		contentPane.add(label_3);
		
		JButton button_1 = new JButton("\uB3CC\uC544\uAC00\uAE30");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainFrame Back = new MainFrame();
				Back.setVisible(true);
				dispose();
				
			}
		});
		button_1.setFont(new Font("굴림", Font.BOLD, 15));
		button_1.setBounds(417, 328, 97, 23);
		contentPane.add(button_1);
		
		JLabel lblAtm = new JLabel("\uD604\uC7AC ATM \uD654\uD3D0 \uC218\uB7C9");
		lblAtm.setFont(new Font("굴림", Font.PLAIN, 15));
		lblAtm.setBounds(204, 157, 128, 18);
		contentPane.add(lblAtm);
		
		JLabel label_5 = new JLabel("\uAD00\uB9AC\uC790 \uBAA8\uB4DC");
		label_5.setFont(new Font("굴림", Font.BOLD, 20));
		label_5.setBounds(210, 124, 113, 24);
		contentPane.add(label_5);
		
		JLabel textPane = new JLabel();
		textPane.setText("\uD604\uC7AC\uC218\uB7C9"+MainFrame.getSystem().getATMcount().getCount50000());
		textPane.setBounds(196, 177, 157, 25);
		contentPane.add(textPane);
		
		JLabel textPane_1 = new JLabel();
		textPane_1.setText("\uD604\uC7AC\uC218\uB7C9"+MainFrame.getSystem().getATMcount().getCount10000());
		textPane_1.setBounds(195, 213, 157, 25);
		contentPane.add(textPane_1);
		
		JLabel textPane_2 = new JLabel();
		textPane_2.setText("\uD604\uC7AC\uC218\uB7C9"+MainFrame.getSystem().getATMcount().getCount5000());
		textPane_2.setBounds(196, 248, 157, 25);
		contentPane.add(textPane_2);
		
		JLabel textPane_3 = new JLabel();
		textPane_3.setText("\uD604\uC7AC\uC218\uB7C9"+MainFrame.getSystem().getATMcount().getCount1000());
		textPane_3.setBounds(195, 284, 157, 25);
		contentPane.add(textPane_3);
		
		JButton button_2 = new JButton("\uC785\uAE08");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainFrame.getSystem().input_POM(1);
				MWithdraw_Frame Manager_Withdraw = new MWithdraw_Frame();
				Manager_Withdraw.setVisible(true);
				dispose();
			}
		});
		button_2.setFont(new Font("굴림", Font.BOLD, 15));
		button_2.setBounds(157, 328, 97, 23);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("\uCD9C\uAE08");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainFrame.getSystem().input_POM(-1);
				MDeposit_Frame Manager_Deposit = new MDeposit_Frame();
				Manager_Deposit.setVisible(true);
				dispose();
			}
		});
		button_3.setFont(new Font("굴림", Font.BOLD, 15));
		button_3.setBounds(266, 328, 97, 23);
		contentPane.add(button_3);
	}

}

class Input_MID_Frame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	public Input_MID_Frame() {
		System_Control sys = MainFrame.getSystem();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		


		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/logo.png")).getImage();
		contentPane.setLayout(null);
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(122, 10, 279, 95);
		contentPane.add(lblNewLabel);
		
		JLabel lblId = new JLabel("\uAD00\uB9AC\uC790 ID \uC785\uB825");
		lblId.setFont(new Font("굴림", Font.BOLD, 20));
		lblId.setBounds(192, 143, 144, 24);
		contentPane.add(lblId);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(95, 189, 338, 34);
		contentPane.add(textField);
		
		JButton button = new JButton("\uD655\uC778");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
//				boolean check = input_ID(textField);
//				
//				if(check == true) {
//				Input_MPW_Frame ManagerPW = new Input_MPW_Frame();
//				ManagerPW.setVisible(true);
//				dispose();
//				}
				String str = textField.getText();
				Boolean isempty=textField.getText().isEmpty();
				for(int i=0; i<str.length(); i++) {
					if(str.charAt(i)>57 || str.charAt(i)<48) {
						isempty= true;
					}
				}
				try {
					Integer.parseInt(str);
				} catch (NumberFormatException e) {
					// TODO: handle exception
					isempty= true; 
				}
				if(!isempty) {
					Boolean ischeck = MainFrame.getSystem().input_MID(Integer.parseInt(str));
					if(ischeck) {
						Input_MPW_Frame ManagerPW = new Input_MPW_Frame();
						ManagerPW.setVisible(true);
						dispose();
					}
					else {
						JOptionPane.showMessageDialog(null, "ID 확인하세요", "ID 오류", JOptionPane.WARNING_MESSAGE);
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "입력을 확인하세요", "입력 오류", JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		button.setFont(new Font("굴림", Font.BOLD, 15));
		button.setBounds(220, 255, 97, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\uB3CC\uC544\uAC00\uAE30");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainFrame Back = new MainFrame();
				Back.setVisible(true);
				dispose();
				
			}
		});
		button_1.setFont(new Font("굴림", Font.BOLD, 15));
		button_1.setBounds(415, 328, 97, 23);
		contentPane.add(button_1);
	}

}

class DetailView_Frame extends JFrame {

	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public DetailView_Frame(int ischeck) {
		System_Control sys = MainFrame.getSystem();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/logo.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(117, 10, 284, 102);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("\uC608\uAE08 \uC870\uD68C");
		label.setFont(new Font("굴림", Font.BOLD, 20));
		label.setBounds(210, 134, 104, 24);
		contentPane.add(label);
		
		JButton button = new JButton("\uB3CC\uC544\uAC00\uAE30");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainFrame Back = new MainFrame();
				Back.setVisible(true);
				dispose();
				
			}
		});
		button.setFont(new Font("굴림", Font.BOLD, 15));
		button.setBounds(415, 328, 97, 23);
		contentPane.add(button);
		
		JLabel lblNewLabel_1 = new JLabel("계좌잔고");
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel_1.setBounds(94, 221, 69, 18);
		contentPane.add(lblNewLabel_1);
		
		JLabel textPane = new JLabel();
		textPane.setText(String.valueOf(ischeck));
		textPane.setBounds(176, 203, 194, 48);
		contentPane.add(textPane);
	}

}

class Result_Frame extends JFrame {

	private JPanel contentPane;

	

	/**
	 * Create the frame.
	 */
	public Result_Frame(int input) {
		System_Control sys = MainFrame.getSystem();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/logo.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(117, 10, 284, 102);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("\uAC70\uB798 \uB0B4\uC5ED");
		label.setFont(new Font("굴림", Font.BOLD, 20));
		label.setBounds(210, 134, 104, 24);
		contentPane.add(label);
		
		JLabel textPane = new JLabel();
		if(sys.get_input_menu()==4) textPane.setText("잔고:"+String.valueOf(input));
		else textPane.setText("거래 후 잔액:"+String.valueOf(input));
		textPane.setBounds(117, 170, 284, 159);
		contentPane.add(textPane);
		
		JButton button = new JButton("\uB3CC\uC544\uAC00\uAE30");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainFrame Back = new MainFrame();
				Back.setVisible(true);
				dispose();
				
			}
		});
		button.setFont(new Font("굴림", Font.BOLD, 15));
		button.setBounds(413, 328, 97, 23);
		contentPane.add(button);
	}
}

class InputPW_Frame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Create the frame.
	 */
	public InputPW_Frame() {
		System_Control sys = MainFrame.getSystem();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/logo.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(117, 10, 284, 102);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("비밀번호 입력");
		label.setFont(new Font("굴림", Font.BOLD, 20));
		label.setBounds(192, 143, 144, 24);
		contentPane.add(label);
		
		
		JButton button = new JButton("\uD655\uC778");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String str = textField.getText();
				Boolean isempty=textField.getText().isEmpty();	
				for(int i=0; i<str.length(); i++) {
					if(str.charAt(i)>57 || str.charAt(i)<48) {
						isempty= true;
					}
				}
				try {
					Integer.parseInt(str);
				} catch (NumberFormatException e) {
					// TODO: handle exception
					isempty= true; 
				}
				if(sys.get_input_menu()==1||sys.get_input_menu()==2||sys.get_input_menu()==3)
				{
					if(!isempty) {
						int ischeck = MainFrame.getSystem().input_PW(Integer.parseInt(str));
						if(sys.get_isjackpot()>=1 && ischeck>=0) {
							Jackpot_Frame JPF = new Jackpot_Frame(ischeck);
							JPF.setVisible(true);
							dispose();
						}
						else if(ischeck>=0) {
							Result_Frame Result = new Result_Frame(ischeck);
							Result.setVisible(true);
							dispose();
						}
						else if(ischeck==-1){
							JOptionPane.showMessageDialog(null, "비밀번호 확인하세요", "비밀번호 오류", JOptionPane.WARNING_MESSAGE);
						}
						else if(ischeck==-2){
							JOptionPane.showMessageDialog(null, "잔고 확인하세요", "잔고 부족", JOptionPane.WARNING_MESSAGE);
						}
						else if(ischeck==-3) {
							JOptionPane.showMessageDialog(null, "ATM잔고 부족입니다", "ATM잔고 부족", JOptionPane.WARNING_MESSAGE);
						}
						else if(ischeck==-4) {
							JOptionPane.showMessageDialog(null, "일반계좌 최대 입금한도는 10억입니다", "한도초과", JOptionPane.WARNING_MESSAGE);
						}
						else if(ischeck==-5) {
							JOptionPane.showMessageDialog(null, "ATM잔고 최대 한도는 초과입니다", "한도초과", JOptionPane.WARNING_MESSAGE);
						}
					}
					else{
						JOptionPane.showMessageDialog(null, "입력을 확인하세요", "입력 오류", JOptionPane.WARNING_MESSAGE);
					}
				}
				else if(sys.get_input_menu()==4)
				{
					if(!isempty) {
						int ischeck = MainFrame.getSystem().input_PW(Integer.parseInt(str));
						if(ischeck>=0) {
							DetailView_Frame detailF = new DetailView_Frame(ischeck); 
							detailF.setVisible(true);
							dispose();
						}
						else {
							JOptionPane.showMessageDialog(null, "비밀번호 확인하세요", "비밀번호 오류", JOptionPane.WARNING_MESSAGE);
						}
					}
					else{
						JOptionPane.showMessageDialog(null, "입력을 확인하세요", "입력 오류", JOptionPane.WARNING_MESSAGE);
					}
				}
				else if(sys.get_input_menu()==5)
				{
					if(!isempty) {
						Boolean ischeck = MainFrame.getSystem().input_MPW(Integer.parseInt(str));
						if(ischeck) {
							/*DetailView_Frame detailF = new DetailView_Frame(ischeck); 
							detailF.setVisible(true);
							dispose();*/
						}
						else {
							JOptionPane.showMessageDialog(null, "비밀번호 확인하세요", "비밀번호 오류", JOptionPane.WARNING_MESSAGE);
						}
					}
					else{
						JOptionPane.showMessageDialog(null, "입력을 확인하세요", "입력 오류", JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});
		button.setFont(new Font("굴림", Font.BOLD, 15));
		button.setBounds(220, 255, 97, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\uB3CC\uC544\uAC00\uAE30");
		button_1.setFont(new Font("굴림", Font.BOLD, 15));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainFrame Back = new MainFrame();
				Back.setVisible(true);
				dispose();
				
			}
		});
		button_1.setBounds(415, 328, 97, 23);
		contentPane.add(button_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(95, 189, 338, 34);
		contentPane.add(textField);
	}
}

class Jackpot_Frame extends JFrame {

	private JPanel contentPane;

	
	/**
	 * Create the frame.
	 * @param ischeck 
	 */
	public Jackpot_Frame(int ischeck) {
		System_Control sys = MainFrame.getSystem();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(122, 10, 279, 95);
		Image img = new ImageIcon(this.getClass().getResource("/logo.png")).getImage();
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		lblNewLabel.setIcon(new ImageIcon(img));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(136, 103, 252, 179);
		Image img2 = new ImageIcon(this.getClass().getResource("/jackpot.png")).getImage();
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon(img2));
		
		JButton button = new JButton("\uD655\uC778");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Result_Frame result = new Result_Frame(ischeck);
				result.setVisible(true);
				dispose();
			}
		});
		button.setBounds(224, 319, 97, 23);
		button.setFont(new Font("굴림", Font.BOLD, 15));
		contentPane.add(button);
		
		if(sys.get_isjackpot()==1) {
			JLabel lblJackpotAtm = new JLabel("\uC624\uB298\uC758 JACKPOT ATM \uB2F9\uCCA8\uC744 \uCD95\uD558\uD569\uB2C8\uB2E4. \uC0C1\uAE08 5\uB9CC\uC6D0\uC774 \uCD94\uAC00\uB85C \uCD9C\uAE08\uB429\uB2C8\uB2E4.");
			lblJackpotAtm.setBounds(71, 285, 426, 24);
			contentPane.add(lblJackpotAtm);
		}
		else if(sys.get_isjackpot()==2) {
			JLabel lblJackpotAtm = new JLabel("\uC624\uB298\uC758 JACKPOT ATM \uB2F9\uCCA8\uC744 \uCD95\uD558\uD569\uB2C8\uB2E4. \uC0C1\uAE08 5\uB9CC\uC6D0\uC774 \uCD94\uAC00\uB85C 입\uAE08\uB429\uB2C8\uB2E4.");
			lblJackpotAtm.setBounds(71, 285, 426, 24);
			contentPane.add(lblJackpotAtm);
			
			JOptionPane.showMessageDialog(null, "ATM지폐권 부족으로 계좌로 입금해드리겠습니다", "JackPot", JOptionPane.WARNING_MESSAGE);
		}
		
		
	}

}
