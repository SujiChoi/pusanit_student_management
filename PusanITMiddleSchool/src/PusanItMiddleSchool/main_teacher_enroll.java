package PusanItMiddleSchool;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.Font;

public class main_teacher_enroll extends JFrame {

	private JPanel contentPane;
	private JTextField textField_Name;
	private JPasswordField passwordField;
	private JPasswordField passwordField_Check;
	private JTextField textField_ID;
	private JLabel lblNewLabel_4;
	private JTextField textField_PhoneNum;
	private JButton btnSignup;
	private JTextField textField_Birthday;
	private JButton btnPasswordCheck;
	private JButton btnidCheck;
	private JLabel lbTnumber;
	private JLabel lbTnumber_1;
	private JComboBox comboBox;
	private JPanel panel_1;
	private JLabel Student_Register;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main_teacher_enroll frame = new main_teacher_enroll();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public main_teacher_enroll() {
		setTitle("\uD68C\uC6D0\uAC00\uC785");
		//setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // â ���� �� ȸ������ â�� ������ �ʱ�ȭ���� ����
		setSize(450,500);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setLocation(0, 0);
		panel.setSize(434,461);
		contentPane.add(panel);
		panel.setLayout(null);
		
		// �̸�
		JLabel lbName = new JLabel("\uC774\uB984");
		lbName.setHorizontalAlignment(SwingConstants.LEFT);
		lbName.setFont(new Font("���� ���", Font.PLAIN, 14));
		lbName.setBounds(27, 88, 88, 27);
		panel.add(lbName);
		
		textField_Name = new JTextField();
		textField_Name.setBounds(161, 92, 116, 21);
		panel.add(textField_Name);
		textField_Name.setColumns(10);
		
		// ����
		JLabel lbGender = new JLabel("\uC131\uBCC4");
		lbGender.setHorizontalAlignment(SwingConstants.LEFT);
		lbGender.setFont(new Font("���� ���", Font.PLAIN, 14));
		lbGender.setBounds(27, 125, 88, 27);
		panel.add(lbGender);
		
		String [] combo = {"����", "����"};
		comboBox = new JComboBox(combo);
		comboBox.setFont(new Font("���� ���", Font.PLAIN, 12));
		comboBox.setBounds(161, 129, 115, 21);
		panel.add(comboBox);
		
		// ���̵�
		JLabel lbID = new JLabel("\uC544\uC774\uB514");
		lbID.setHorizontalAlignment(SwingConstants.LEFT);
		lbID.setFont(new Font("���� ���", Font.PLAIN, 14));
		lbID.setBounds(27, 166, 88, 27);
		panel.add(lbID);
		
		textField_ID = new JTextField();
		textField_ID.setBounds(161, 170, 116, 21);
		panel.add(textField_ID);
		textField_ID.setColumns(10);
		
		// ��й�ȣ
		JLabel lbPassword = new JLabel("\uBE44\uBC00\uBC88\uD638");
		lbPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lbPassword.setFont(new Font("���� ���", Font.PLAIN, 14));
		lbPassword.setBounds(27, 201, 88, 27);
		panel.add(lbPassword);
		
		JLabel lbPasswordCheck = new JLabel("\uBE44\uBC00\uBC88\uD638 \uD655\uC778");
		lbPasswordCheck.setHorizontalAlignment(SwingConstants.LEFT);
		lbPasswordCheck.setFont(new Font("���� ���", Font.PLAIN, 14));
		lbPasswordCheck.setBounds(27, 238, 105, 27);
		panel.add(lbPasswordCheck);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(161, 204, 116, 24);
		panel.add(passwordField);
		
		passwordField_Check = new JPasswordField();
		passwordField_Check.setBounds(161, 241, 116, 24);
		panel.add(passwordField_Check);
		
		// �������
		JLabel lbBirthday = new JLabel("\uC0DD\uB144\uC6D4\uC77C");
		lbBirthday.setHorizontalAlignment(SwingConstants.LEFT);
		lbBirthday.setFont(new Font("���� ���", Font.PLAIN, 14));
		lbBirthday.setBounds(27, 275, 88, 27);
		panel.add(lbBirthday);
		
		textField_Birthday = new JTextField();
		textField_Birthday.setColumns(10);
		textField_Birthday.setBounds(161, 279, 116, 21);
		panel.add(textField_Birthday);
		
		// ����ó
		JLabel lbPhoneNum = new JLabel("\uC5F0\uB77D\uCC98");
		lbPhoneNum.setHorizontalAlignment(SwingConstants.LEFT);
		lbPhoneNum.setFont(new Font("���� ���", Font.PLAIN, 14));
		lbPhoneNum.setBounds(27, 312, 88, 27);
		panel.add(lbPhoneNum);
		
		textField_PhoneNum = new JTextField();
		textField_PhoneNum.setBounds(161, 315, 116, 24);
		panel.add(textField_PhoneNum);
		textField_PhoneNum.setColumns(10);
		
		// ȸ������ ��ư
		btnSignup = new JButton("\uD68C\uC6D0\uAC00\uC785");
		btnSignup.setFont(new Font("���� ���", Font.PLAIN, 12));
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String Nametxt = textField_Name.getText();
				String Gendertxt = comboBox.getSelectedItem().toString();
				String IDtxt = textField_ID.getText();
				String PWtxt = passwordField.getText();
				String Bdaytxt = textField_Birthday.getText();
				String Pnumtxt = textField_PhoneNum.getText();
				
				if (Nametxt.trim().isEmpty() || IDtxt.trim().isEmpty()
						|| PWtxt.trim().isEmpty() || Bdaytxt.trim().isEmpty()
						|| Pnumtxt.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "�Է¶� ��ĭ ����");}
				else {
				System.out.println(Nametxt+Gendertxt+IDtxt+PWtxt+Bdaytxt+Pnumtxt);
				
				SQLPusanItMiddleSchool.Input_Teacher(Nametxt,Gendertxt,IDtxt,PWtxt,Bdaytxt,Pnumtxt);
				
				JOptionPane.showMessageDialog(null, "���� �Ǿ����ϴ�.");
				
				dispose();
				}
			}
		});
		
		// ��й�ȣ ��ġ ��ư
		btnPasswordCheck = new JButton("\uBE44\uBC00\uBC88\uD638 \uD655\uC778");
		btnPasswordCheck.setFont(new Font("���� ���", Font.PLAIN, 12));
		btnPasswordCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(passwordField.getText().equals(passwordField_Check.getText()))
					JOptionPane.showMessageDialog(null, "�н����� ��ġ");
				else
					JOptionPane.showMessageDialog(null, "�н����� ����ġ");
			}
		});
		btnPasswordCheck.setBounds(289, 241, 133, 23);
		panel.add(btnPasswordCheck);
		//��Ϲ�ư
		btnSignup.setBounds(154, 379, 100, 35);
		panel.add(btnSignup);
		
		// ���̵� ��ġ ��ư
		btnidCheck = new JButton("\uBE44\uBC00\uBC88\uD638 \uD655\uC778");
		btnidCheck.setFont(new Font("���� ���", Font.PLAIN, 12));
		btnidCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tid = SQLPusanItMiddleSchool.OutputTID(textField_ID.getText());
				System.out.println(tid);
				if(textField_ID.getText().equals(tid))
					JOptionPane.showMessageDialog(null, "���̵� �ߺ� �˴ϴ�.");
				else
					JOptionPane.showMessageDialog(null, "���̵� ��� �����մϴ�.");
			}
		});
		btnidCheck.setBounds(289, 169, 133, 23);
		btnidCheck.setText("���̵� �ߺ� Ȯ��");
		panel.add(btnidCheck);
		
		panel_1 = new JPanel();
		panel_1.setForeground(Color.WHITE);
		panel_1.setBackground(new Color(30, 144, 255));
		panel_1.setBounds(0, 0, 435, 50);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		Student_Register = new JLabel("\uD68C \uC6D0 \uAC00 \uC785");
		Student_Register.setHorizontalAlignment(SwingConstants.CENTER);
		Student_Register.setForeground(Color.WHITE);
		Student_Register.setFont(new Font("���� ���", Font.BOLD, 22));
		Student_Register.setBounds(0, 0, 435, 51);
		panel_1.add(Student_Register);

		
		
		
		
		
		
	}
}
