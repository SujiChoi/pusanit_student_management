package PusanItMiddleSchool;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
import javax.swing.*;
import java.awt.event.*;
import java.net.URL;


public class recode extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					recode frame = new recode();
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
	public recode() {
		
		setTitle("��������");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1200, 700);
		setLocationRelativeTo(null); //ȭ�� �߾�
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		String[][] data = SQLPusanItMiddleSchool.getRecode();	//DB ������ ����
		String[] headers = { "�й�", "�̸�","����", "����", "����", "����","��ȸ","��������" }; 
		
		DefaultTableModel model = new DefaultTableModel(data, headers);
		
		JTable table = new JTable(model);
		table.setFont(new Font("���� ���", Font.PLAIN, 18));
		table.setRowHeight(30); // ���̺� ����
		JScrollPane scrollPane = new JScrollPane(table);
		
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row = table.rowAtPoint(e.getPoint());
				int col = table.columnAtPoint(e.getPoint());
				String[] headers = { "S_INDEX","S_NAME","S_KOREAN","S_MATH","S_ENGLISH","S_SCIENCE","S_SOCIETY","S_RNOTE"};
				//String sindex = new String((String) table.getModel().getValueAt(row, 0));
				if(row >= 0 && col >= 0) {
					//JOptionPane.showMessageDialog(null, row+","+col);
					if(col== 0|| col==1) {
						JOptionPane.showMessageDialog(null,"�л� ������ ���� �Ұ��մϴ�.");
					}else {
					new recode_modify(row+1,headers[col]).setVisible(true);}
				}
			}
		});
		
		scrollPane.setLocation(5,128);
		scrollPane.setSize(1167, 449);
		
		contentPane.add(scrollPane);
		
		JButton inputbutton = new JButton("\uD559\uC0DD\uB4F1\uB85D");
		inputbutton.setBackground(Color.LIGHT_GRAY);
		inputbutton.setFont(new Font("���� ���", Font.PLAIN, 14));
		inputbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new recode_enroll().setVisible(true);
			}
		});
		inputbutton.setBounds(1075, 603, 97, 23);
		inputbutton.setText("�������");
		contentPane.add(inputbutton);
		
		JButton StudentTable = new JButton("\uD559\uC0DD\uAD00\uB9AC");
		StudentTable.setBackground(Color.WHITE);
		StudentTable.setForeground(Color.BLACK);
		StudentTable.setFont(new Font("���� ���", Font.PLAIN, 14));
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
		RecodeTable.setBackground(Color.ORANGE);
		RecodeTable.setBounds(153, 25, 129, 34);
		contentPane.add(RecodeTable);
		
		JButton SabsentTable = new JButton("\uCD9C\uC11D\uAD00\uB9AC");
		SabsentTable.setBackground(Color.WHITE);
		SabsentTable.setForeground(Color.BLACK);
		SabsentTable.setFont(new Font("���� ���", Font.PLAIN, 14));
		SabsentTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new attend().setVisible(true);
			}
		});
		SabsentTable.setBounds(294, 25, 129, 34);
		contentPane.add(SabsentTable);
		
		textField = new JTextField();
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
		
		JButton btnNewButton_2 = new JButton("\uC0C8\uB85C\uACE0\uCE68");
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setForeground(Color.BLACK);
		btnNewButton_2.setFont(new Font("���� ���", Font.PLAIN, 14));
		btnNewButton_2.setBounds(1066, 25, 106, 34);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("ã��");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("���� ���", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(644, 23, 70, 34);
		contentPane.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(30, 144, 255));
		panel_1.setBounds(0, 0, 1184, 81);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		URL imageURL = getClass().getResource("main1.png");
		lblNewLabel_2.setIcon(new ImageIcon(imageURL));
		lblNewLabel_2.setBounds(4, 581, 278, 70);
		contentPane.add(lblNewLabel_2);
		
		//���̺� �׸���
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				String[][] data = SQLPusanItMiddleSchool.getRecode();	//DB ������ ����				
				model.setRowCount(0); //���̺� ������ ��� ����
				for (int i = 0; i < data.length; i++) {
					model.addRow(data[i]);
				}
			}
		});
	}
}
