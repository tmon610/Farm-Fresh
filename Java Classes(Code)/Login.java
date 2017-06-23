import java.awt.CardLayout;
import java.awt.Container;
import java.awt.GradientPaint;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class L extends JPanel
{
	final JPanel parent; 
	JLabel username,password,post;
	JTextField u1;
	JTextArea t2;
	JPasswordField p1;
	JButton get_details,new_user;
	JComboBox<String> po;
	L(final JPanel parent)
	{
		this.parent=parent;
		setLayout(new GridLayout(2,1));
		JPanel P1=new JPanel();
		GridLayout g=new GridLayout(4,2);
		P1.setLayout(g);
		username=new JLabel("username");
		P1.add(username);
		u1=new JTextField();
		P1.add(u1);
		password=new JLabel("password");
		P1.add(password);
		p1=new JPasswordField();
		P1.add(p1);
		post=new JLabel("post");
		P1.add(post);
		po=new JComboBox<String>();
		po.addItem("employee");
		po.addItem("supplier");
		P1.add(po);
		get_details=new JButton("get details");
		P1.add(get_details);
		t2=new JTextArea();
		JPanel P2=new JPanel(new GridLayout(1,1));
		P2.add(t2);
		add(P1);
		add(P2);
		get_details.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String username=u1.getText();
				char[] pass=p1.getPassword();
				String password=new String(pass);
				String post1=po.getSelectedItem().toString();
				if((username.equalsIgnoreCase("")&&password.equalsIgnoreCase("")))
				{
					JOptionPane.showMessageDialog(P1, "Please enter all details properly");
				}
				else
				{
				if(post1.equalsIgnoreCase("employee"))
				{
					int x=1;
					String query="select * from employee where emp_username=?";
					PreparedStatement ps;
					Connection con=App.getConnection();
					try {
						ps=con.prepareStatement(query);
						ps.setString(1, username);
						ResultSet rs=ps.executeQuery();
						while(rs.next())
						{
							x=0;
							t2.setText("Emp Name:"+rs.getString(2)+"\n"+"Emp DOB:"+rs.getString(3)+"\n"+"Emp Phno:"+rs.getString(4)+"\n"+"Emp address:"+rs.getString(5));
						}
						if(x==1)
						{
							JOptionPane.showMessageDialog(P1, "Employee does not exist");
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if(post1.equalsIgnoreCase("supplier"))
				{
					int x=1;
					String query="select * from supplier where sup_username=?";
					PreparedStatement ps;
					Connection con=App.getConnection();
					try {
						ps=con.prepareStatement(query);
						ps.setString(1, username);
						ResultSet rs=ps.executeQuery();
						while(rs.next())
						{
							x=0;
							t2.setText("Supplier Name:"+rs.getString(2)+"\n"+"Supplier Phno:"+rs.getString(3)+"\n"+"Supplier address:"+rs.getString(4));
						}
						if(x==1)
						{
							JOptionPane.showMessageDialog(P1, "Supplier does not exist");

						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				}
			}
		});
		new_user=new JButton("new user");
		P1.add(new_user);
		new_user.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				CardLayout c1=(CardLayout)parent.getLayout();
				c1.show(parent,"new user");
			}
		});
	}
}

