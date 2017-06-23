import java.awt.CardLayout;

import java.awt.GradientPaint;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.sql.Connection;


class E extends JPanel
{
	final JPanel parent;
	JLabel name,DOB,phno,addr,emp_username,emp_password;
	JTextField n1,d1,ph1,a1,u1;
	JPasswordField ep1;
	JButton sub,back;
	E(final JPanel parent)
	{
		this.parent=parent;
		setLayout(new GridLayout(3,1));
		JPanel p1=new JPanel();
		p1.setLayout(new GridLayout(6,2));
		emp_username=new JLabel("username");
		p1.add(emp_username);
		u1=new JTextField();
		p1.add(u1);
		emp_password=new JLabel("password");
		p1.add(emp_password);
		ep1=new JPasswordField();
		p1.add(ep1);
		
		name=new JLabel("name");
		p1.add(name);
		n1=new JTextField();
		p1.add(n1);
		DOB=new JLabel("Date Of Birth");
		p1.add(DOB);
		d1=new JTextField();
		p1.add(d1);
		phno=new JLabel("phone no.");
		p1.add(phno);
		ph1=new JTextField();
		p1.add(ph1);
		addr=new JLabel("address");
		p1.add(addr);
		a1=new JTextField();
		p1.add(a1);
		add(p1);
		sub=new JButton("submit");
		add(sub);
		sub.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String username=u1.getText();
				char[] pass=ep1.getPassword();
				String password=new String(pass);
				String name1=n1.getText();
				String dob=d1.getText();
				String phone=ph1.getText();
				String address=a1.getText();
				if(!(username.equals("")&&password.equals("")&&name1.equals("")&&dob.equals("")&&phone.equals("")&&address.equals("")))
				{
				String query="insert into employee (emp_name,emp_dob,emp_phno,emp_address,emp_username,emp_password) values(?,?,?,?,?,?)";
				Connection con=App.getConnection();
				PreparedStatement pr;
				try {
					pr=con.prepareStatement(query);
					pr.setString(1, name1);
					pr.setString(2, dob);
					pr.setString(3, phone);
					pr.setString(4, address);
					pr.setString(5, username);
					pr.setString(6, password);
					pr.executeUpdate();
					JOptionPane.showMessageDialog(p1, "Employee has been added");
					u1.setText("");
					ep1.setText("");
					d1.setText("");
					a1.setText("");
					n1.setText("");
					ph1.setText("");


				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					System.out.println(e1);
				}
				// TODO Auto-generated method stub
				
			}
			else
				{
				System.out.println("Hey");
				JOptionPane.showMessageDialog(p1, "Please enter all details properly");
				}
					}
		});;
		back=new JButton("back");
		add(back);
		back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				CardLayout c1=(CardLayout)parent.getLayout();
				c1.show(parent,"new user");
			}
		});
		
	}
}
