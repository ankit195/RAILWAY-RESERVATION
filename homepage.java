package ankit;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JLabel;
import javax.swing.JCheckBox;

public class homepage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	Connection con;
	Statement st = null;
	ResultSet rs;
	signup su = new signup();
	changepackage cp = new changepackage();
	bookpackage bp = new bookpackage();
	String str1 = new String();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					homepage frame = new homepage();
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
	public homepage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		su.setBounds(0,0,1220,650);
		getContentPane().add(su,BorderLayout.CENTER);
		su.setLayout(null);
		su.setVisible(false);
		
		cp.setBounds(0,0,1220,650);
		getContentPane().add(cp,BorderLayout.CENTER);
		cp.setLayout(null);
		cp.setVisible(false);
		
		bp.setBounds(0,0,1220,650);
		getContentPane().add(bp,BorderLayout.CENTER);
		bp.setLayout(null);
		bp.setVisible(false);
		
		textField = new JTextField();
		textField.setBounds(188, 70, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(213, 125, 61, 20);
		contentPane.add(passwordField);
		
		JLabel lblTourAndTravel = new JLabel("TOUR AND TRAVEL");
		lblTourAndTravel.setBounds(165, 23, 131, 14);
		contentPane.add(lblTourAndTravel);
		
		JLabel lblNewLabel = new JLabel("USERNAME");
		lblNewLabel.setBounds(86, 73, 92, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("PASSWORD");
		lblNewLabel_1.setBounds(98, 128, 80, 14);
		contentPane.add(lblNewLabel_1);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("ARE U THE ADMIN");
		chckbxNewCheckBox.setBounds(32, 34, 185, 23);
		contentPane.add(chckbxNewCheckBox);
		
		JButton btnSignUp = new JButton("SIGN UP");
		btnSignUp.setBounds(316, 34, 89, 23);
		contentPane.add(btnSignUp);
		
		JButton btnNewButton = new JButton("LOG IN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				Class.forName("oracle.jdbc.driver.OracleDriver"); 
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
				st=con.createStatement();
				con.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
				System.out.println("Connected");
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
				 str1 = textField.getText();
				String str2 = new String(passwordField.getPassword());
				if(chckbxNewCheckBox.isSelected() == false){
				String str3 = "select * from userid where username = '"+str1+"' and password = '" + str2 + "'";
				try {
					System.out.println(str3);
					rs = st.executeQuery(str3);
					if(rs.next())
					{
						bp.setVisible(true);
						chckbxNewCheckBox.setVisible(false);
						btnSignUp.setVisible(false);
						btnNewButton.setVisible(false);
					}
					else
						JOptionPane.showMessageDialog(null, "INVALID CREDENTIALS");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				else
				{
					String str3 = "select * from admin1 where username = '"+str1+"' and password = '" + str2 + "'";
					try {
	//					System.out.println(str3);
						rs = st.executeQuery(str3);
						if(rs.next())
						{
							cp.setVisible(true);
							chckbxNewCheckBox.setVisible(false);
							btnSignUp.setVisible(false);
							btnNewButton.setVisible(false);
						}
						else
							JOptionPane.showMessageDialog(null, "INVALID CREDENTIALS");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		btnNewButton.setBounds(155, 164, 89, 23);
		contentPane.add(btnNewButton);
	}
}
