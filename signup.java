package ankit;

import java.awt.Rectangle;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JPasswordField;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class signup extends JPanel {
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textField_1;
	Connection con;
	Statement st = null;
	ResultSet rs;
	//homepage home1 = new homepage();
	/**
	 * Create the panel.
	 */
	
	public signup() {
		
		
		setLayout(null);
		setOpaque(true);
		JLabel lblEnterYourDetails = new JLabel("Enter your details");
		lblEnterYourDetails.setBounds(178, 34, 120, 14);
		add(lblEnterYourDetails);
		
		textField = new JTextField();
		textField.setBounds(247, 75, 86, 20);
		add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(247, 117, 51, 20);
		add(passwordField);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(154, 78, 67, 14);
		add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(154, 120, 46, 14);
		add(lblPassword);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(154, 165, 46, 14);
		add(lblName);
		
		textField_1 = new JTextField();
		textField_1.setBounds(247, 162, 86, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnSgnUp = new JButton("SIGN UP");
		btnSgnUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					
					Class.forName("oracle.jdbc.driver.OracleDriver");
					con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
					st=con.createStatement();
					con.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
					System.out.println("Connected");
				String str = textField.getText();
				String str1 = String.valueOf(passwordField.getPassword());
				String str2 = textField_1.getText();
				String stri = "insert into userid values('"+str+"','"+str1+"','"+str2+"')";
				System.out.println(stri);
				st.executeUpdate(stri);
				//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				//setBounds(new Rectangle(0, 0, 1220, 650));
				//getContentPane().setLayout(null);
				//setBounds(100, 100, 450, 300);
	   //			home1.setVisible(true);
			}
				catch(Exception e)
				{
					System.out.println(e);
				}
			}
		});
		btnSgnUp.setBounds(195, 212, 89, 23);
		add(btnSgnUp);
	}
}