package ankit;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class changepackage extends JPanel {
	private JTextField ava;
	private JTextField name;
	private JTextField nava;

	/**
	 * Create the panel.
	 */
	Connection con;
	Statement st = null;
	ResultSet rs;
	public changepackage() {
		setLayout(null);
		name = new JTextField();
		name.setBounds(283, 62, 86, 20);
		add(name);
		name.setColumns(10);
		
		nava = new JTextField();
		nava.setBounds(366, 149, 86, 20);
		add(nava);
		nava.setColumns(10);
		
		ava = new JTextField();
		ava.setBounds(126, 149, 86, 20);
		add(ava);
		ava.setColumns(10);
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
			st=con.createStatement();
			System.out.println("Connected");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		JLabel lblEnterPackageTo = new JLabel("ADD PACKAGE");
		lblEnterPackageTo.setBounds(64, 103, 115, 45);
		add(lblEnterPackageTo);
		JButton btnNewButton = new JButton("ADD PACKAGE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String str = name.getText();
					String n = ava.getText();
					System.out.println("insert into packag values('"+ str +"'," + n + ")");
					st.executeUpdate("insert into packag values('"+ str +"'," + n + ")");
					
					JOptionPane.showMessageDialog(null, "DATABASE UPDATED");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(64, 192, 134, 23);
		add(btnNewButton);
		
		JButton btnRemovePackage = new JButton("REMOVE PACKAGE");
		btnRemovePackage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String str = name.getText();
					String n = ava.getText();
					String na = nava.getText();
					st.executeUpdate("delete from packag where PID = '" + str + "'");
					JOptionPane.showMessageDialog(null, "DATABASE UPDATED");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnRemovePackage.setBounds(482, 192, 145, 23);
		add(btnRemovePackage);
		
		JLabel lblEnterAvailability = new JLabel("AVAILABILITY");
		lblEnterAvailability.setBounds(10, 152, 106, 14);
		add(lblEnterAvailability);
		
		
		
		JLabel lblRemovePackage = new JLabel("REMOVE PACKAGE");
		lblRemovePackage.setBounds(497, 118, 130, 14);
		add(lblRemovePackage);
		
		JLabel lblNewLabel = new JLabel("CHANGE AVAILABILITY");
		lblNewLabel.setBounds(265, 118, 175, 14);
		add(lblNewLabel);
		
		JLabel lblPackageName_1 = new JLabel("PACKAGE NAME");
		lblPackageName_1.setBounds(187, 65, 86, 14);
		add(lblPackageName_1);
		
		
		
		JLabel lblNewAvailability = new JLabel("NEW AVAILABILITY");
		lblNewAvailability.setBounds(222, 152, 134, 14);
		add(lblNewAvailability);
		
		
		
		JButton btnChangeAvailability = new JButton("CHANGE AVAILABILITY");
		btnChangeAvailability.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String str = name.getText();
					String n = ava.getText();
					String na = nava.getText();
					st.executeUpdate("update packag set availability = " + na + "where PID = '" + str+ "'");
					JOptionPane.showMessageDialog(null, "DATABASE UPDATED");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnChangeAvailability.setBounds(239, 192, 233, 23);
		add(btnChangeAvailability);
		
		JLabel lblNewLabel_1 = new JLabel("ADD OR REMOVE PACKAGE");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(177, 11, 315, 43);
		add(lblNewLabel_1);
	}
}