package PusanItMiddleSchool;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class attend extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					attend frame = new attend();
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
	public attend() {

		String[] sabsent = new String[5];

		setTitle("�⼮����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1200, 700);
		setLocationRelativeTo(null); // ȭ�� �߾�
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton inputbutton = new JButton("\uD559\uC0DD\uB4F1\uB85D");
		inputbutton.setFont(new Font("���� ���", Font.PLAIN, 14));
		inputbutton.setBackground(Color.LIGHT_GRAY);
		inputbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new attend_enroll().setVisible(true);
			}
		});
		inputbutton.setBounds(1075, 603, 97, 23);
		inputbutton.setText("�⼮���");
		contentPane.add(inputbutton);

		JButton StudentTable = new JButton("\uD559\uC0DD\uAD00\uB9AC");
		StudentTable.setFont(new Font("���� ���", Font.PLAIN, 14));
		StudentTable.setBackground(Color.WHITE);
		StudentTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new student().setVisible(true);
			}
		});
		StudentTable.setBounds(12, 25, 129, 34);
		contentPane.add(StudentTable);

		JButton RecodeTable = new JButton("\uC131\uC801\uAD00\uB9AC");
		RecodeTable.setFont(new Font("���� ���", Font.PLAIN, 14));
		RecodeTable.setBackground(Color.WHITE);
		RecodeTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new recode().setVisible(true);
			}
		});
		RecodeTable.setBounds(153, 25, 129, 34);
		contentPane.add(RecodeTable);

		JButton button_1 = new JButton("\uCD9C\uC11D\uAD00\uB9AC");
		button_1.setFont(new Font("���� ���", Font.PLAIN, 14));
		button_1.setBackground(Color.ORANGE);
		button_1.setBounds(294, 25, 129, 34);
		contentPane.add(button_1);

		JButton btnNewButton_2 = new JButton("\uC0C8\uB85C\uACE0\uCE68");
		btnNewButton_2.setFont(new Font("���� ���", Font.PLAIN, 14));
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setBounds(1066, 25, 106, 34);
		contentPane.add(btnNewButton_2);

		JLabel lblNewLabel = new JLabel("ã��");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("���� ���", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(644, 23, 70, 34);
		contentPane.add(lblNewLabel);

		String[][] data = SQLPusanItMiddleSchool.getSAbsent(); // DB ������ ����
		String[] headers = { "�й�", "�̸�", "�й�", "��¥", "�⼮����" };

		DefaultTableModel model = new DefaultTableModel(data, headers);

		JTable table = new JTable(model);
		table.setFont(new Font("���� ���", Font.PLAIN, 18));
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row = table.rowAtPoint(e.getPoint());
				int col = table.columnAtPoint(e.getPoint());
				String[] headers = { "S_INDEX" , "A_DATE", "A_RESULT"};
				String sindex = new String((String) table.getModel().getValueAt(row, 0));				
				if(row >= 0 && col >= 0) {
					if(col==0||col==1||col==2) {
					}else if(col==3) {
						new attend_modify(row+1,headers[1]).setVisible(true);}
					else {
						new attend_modify(row+1,headers[2]).setVisible(true);}
				}
			}
		});
		table.setRowHeight(30); // ���̺� ����
		JScrollPane scrollPane = new JScrollPane(table);

		scrollPane.setLocation(38, 128);
		scrollPane.setSize(615, 449);

		contentPane.add(scrollPane);

		JTextField textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent arg0) {
				String val = textField.getText();
				TableRowSorter<TableModel> trs = new TableRowSorter<TableModel>(table.getModel());
				table.setRowSorter(trs);
				trs.setRowFilter(RowFilter.regexFilter(val));
			}
		});

		textField.setBounds(726, 26, 294, 34);
		contentPane.add(textField);
		textField.setColumns(10);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(30, 144, 255)), "���õ� �л� ����", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(750, 128, 359, 449);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1_2 = new JLabel("\uD559\uBC88");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("����", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(57, 45, 95, 59);
		panel.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1 = new JLabel("\uC774\uB984");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(57, 105, 95, 59);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_1_2_2 = new JLabel("\uD559\uBC18");
		lblNewLabel_1_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_2.setFont(new Font("����", Font.PLAIN, 14));
		lblNewLabel_1_2_2.setBounds(57, 165, 95, 59);
		panel.add(lblNewLabel_1_2_2);

		JLabel lblNewLabel_1_2_1 = new JLabel("\uC0DD\uB144\uC6D4\uC77C");
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1.setFont(new Font("����", Font.PLAIN, 14));
		lblNewLabel_1_2_1.setBounds(57, 225, 95, 59);
		panel.add(lblNewLabel_1_2_1);

		JLabel lblNewLabel_1_2_1_1 = new JLabel("��� ����");
		lblNewLabel_1_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1_1.setFont(new Font("����", Font.PLAIN, 14));
		lblNewLabel_1_2_1_1.setBounds(57, 345, 95, 59);
		panel.add(lblNewLabel_1_2_1_1);

		JLabel lblNewLabel_1_2_3 = new JLabel("�޴��� ��ȣ");
		lblNewLabel_1_2_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_3.setFont(new Font("����", Font.PLAIN, 14));
		lblNewLabel_1_2_3.setBounds(57, 285, 95, 59);
		panel.add(lblNewLabel_1_2_3);

		JLabel S_INDEX = new JLabel();
		S_INDEX.setHorizontalAlignment(SwingConstants.CENTER);
		S_INDEX.setFont(new Font("����", Font.PLAIN, 14));
		S_INDEX.setBounds(209, 45, 95, 59);
		panel.add(S_INDEX);

		JLabel S_NAME = new JLabel();
		S_NAME.setHorizontalAlignment(SwingConstants.CENTER);
		S_NAME.setFont(new Font("����", Font.PLAIN, 14));
		S_NAME.setBounds(209, 105, 95, 59);
		panel.add(S_NAME);

		JLabel S_CLASS = new JLabel();
		S_CLASS.setHorizontalAlignment(SwingConstants.CENTER);
		S_CLASS.setFont(new Font("����", Font.PLAIN, 14));
		S_CLASS.setBounds(209, 225, 95, 59);
		panel.add(S_CLASS);

		JLabel S_BIRTH = new JLabel();
		S_BIRTH.setHorizontalAlignment(SwingConstants.CENTER);
		S_BIRTH.setFont(new Font("����", Font.PLAIN, 14));
		S_BIRTH.setBounds(209, 345, 95, 59);
		panel.add(S_BIRTH);

		JLabel S_PHONE = new JLabel();
		S_PHONE.setHorizontalAlignment(SwingConstants.CENTER);
		S_PHONE.setFont(new Font("����", Font.PLAIN, 14));
		S_PHONE.setBounds(209, 165, 95, 59);
		panel.add(S_PHONE);

		JLabel S_NOTE = new JLabel();
		S_NOTE.setHorizontalAlignment(SwingConstants.CENTER);
		S_NOTE.setFont(new Font("����", Font.PLAIN, 14));
		S_NOTE.setBounds(209, 285, 95, 59);
		panel.add(S_NOTE);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(30, 144, 255));
		panel_1.setBounds(0, 0, 1184, 81);
		contentPane.add(panel_1);

		JLabel lblNewLabel_2 = new JLabel("");
		URL imageURL = getClass().getResource("main1.png");
		lblNewLabel_2.setIcon(new ImageIcon(imageURL));
		lblNewLabel_2.setBounds(4, 581, 278, 70);
		contentPane.add(lblNewLabel_2);

		table.addMouseListener(new MouseAdapter() { // Ŭ���� ��ĭ�� ������ ������ �����
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row = table.getSelectedRow(); // ���õ� �� ���� ��Ʈ�� ��ȯ
				int col = table.getSelectedColumn(); // ���õ� �� ���� ��Ʈ�� ��ȯ
				sabsent[0] = new String((String) table.getModel().getValueAt(row, 0)); // �й�
				sabsent[1] = new String((String) table.getModel().getValueAt(row, 1)); // �̸�

				String[] absentlist = SQLPusanItMiddleSchool.OutputSAbsent(sabsent[0], sabsent[1]);
				// �й��̸����� �˻��ϰ� �ʿ��� �л����� ����Ʈ�� ������

				S_INDEX.setText(absentlist[0]);
				S_NAME.setText(absentlist[1]);
				S_CLASS.setText(absentlist[2]);
				S_BIRTH.setText(absentlist[3]);
				S_PHONE.setText(absentlist[4]);
				S_NOTE.setText(absentlist[5]);

				// ���� �����ϱ�
			}
		});
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String[][] data = SQLPusanItMiddleSchool.getSAbsent(); // DB ������ ����
				model.setRowCount(0); // ���̺� ������ ��� ����
				// String[][] data = Customer.getCustomers();
				for (int i = 0; i < data.length; i++) {
					model.addRow(data[i]);
				}
			}
		});
	}
}
