import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.print.DocFlavor.STRING;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


class C extends JPanel
{
	final JPanel parent;
	JLabel pro,quan;
	JTextField q1;
	JComboBox<String> p1;
	int s=0;
	JButton add_to_list,back,done_with_buying;
	C(final JPanel parent)
	{
		this.parent=parent;
		setLayout(new GridLayout(4,1));
		JPanel a=new JPanel();
		a.setLayout(new GridLayout(2,2));
		pro=new JLabel("products");
		a.add(pro);
		p1=new JComboBox();
		p1.addItem("Milk");
		p1.addItem("Chocolate");
		p1.addItem("Cheese");
		p1.addItem("Milano Biscuit");
		p1.addItem("Soap");
		p1.addItem("Toothpaste");
		p1.addItem("Nutella");
		p1.addItem("Oil");
		p1.addItem("Spices");
		p1.addItem("Bread");
		a.add(p1);
		quan=new JLabel("quantity");
		a.add(quan);
		q1=new JTextField();
		a.add(q1);
		JPanel b=new JPanel();
		add_to_list=new JButton("add to list");
		b.add(add_to_list);
		add_to_list.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String prname=p1.getSelectedItem().toString();
				String quantity=q1.getText();
				String query1="select pro_price from product where pro_name=?";
				PreparedStatement pr;
				Connection con=App.getConnection();
				try {
					pr=con.prepareStatement(query1);
					pr.setString(1,prname);
					ResultSet rs=pr.executeQuery();
					if(rs.next())
					{
						int i=Integer.parseInt(rs.getString(1));
						int q=Integer.parseInt(quantity);
						s=i*q;
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String s1=new Integer(s).toString();
				String query2="insert into bill(pro_name,quantity,price) values(?,?,?)";
				PreparedStatement ps;
				try {
					ps=con.prepareStatement(query2);
					ps.setString(1,prname);
					ps.setString(2,quantity);
					ps.setString(3,s1);
					ps.executeUpdate();
					q1.setText("");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		JPanel c=new JPanel();
		done_with_buying=new JButton("Done With Buying");
		c.add(done_with_buying);
		done_with_buying.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				CardLayout c1=(CardLayout)parent.getLayout();
				c1.show(parent,"done_with_buying");
			}
		});
		JPanel d=new JPanel();
		back=new JButton("back");
		d.add(back);
		add(a);
		add(b);
		add(c);
		add(d);
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