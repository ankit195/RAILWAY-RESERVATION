package ankit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.AbstractListModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class bookpackage extends JPanel {

	/**
	 * Create the panel.
	 */
	Connection con;
	Statement st = null;
	ResultSet rs;
	private JTextField textField;
//	private JTable table;
	
	public bookpackage() {
		setLayout(null);
		DefaultListModel model = new DefaultListModel();
		String str = "select * from packag";
		try {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
			st=con.createStatement();
			rs = st.executeQuery(str);
		while(rs.next())
		{
			String pid = rs.getString("PID");
			model.addElement(pid);
		}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JList list = new JList(model);
		
		list.setBounds(106, 23, 247, 159);
		add(list);
		textField = new JTextField();
		textField.setBounds(185, 190, 86, 20);
		add(textField);
		textField.setColumns(10);
		JButton btnSelectAPackage = new JButton("Select a package and press book");
		btnSelectAPackage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String str1 = list.getSelectedValue().toString();
				
				try{
				//	homepage frame = new homepage();
					String str = textField.getText();
					//System.out.println(str);
					//JOptionPane.showMessageDialog(null, str);
					System.out.println("insert into booking values ('" + str1 + "','" + str + "')");
					st.executeUpdate("insert into booking values ('" + str1 +"','" + str + "')" );
					
					String s = "Update packag set availability = availability - 1 where PID = '"+ str1 + "'";
					st.executeQuery(s);
					JOptionPane.showMessageDialog(null, "BOOKED");
				}
				 catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnSelectAPackage.setBounds(106, 252, 273, 23);
		add(btnSelectAPackage);
		
		JLabel label = new JLabel("");
		label.setBounds(38, 253, 46, -63);
		add(label);
		
		JLabel lblUsername = new JLabel("USERNAME");
		lblUsername.setBounds(116, 193, 73, 14);
		add(lblUsername);
	}
}