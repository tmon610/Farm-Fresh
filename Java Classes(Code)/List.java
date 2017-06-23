import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class List extends JPanel
{
	 final JPanel parent;
	 JButton bill;
	  JTextArea b1;
	  int sum=0;
	List(final JPanel parent)
	{
		this.parent=parent;
		setLayout(new GridLayout(2,1));
		JPanel p=new JPanel();
		bill=new JButton("bill");
		p.add(bill);
		add(p);
		JPanel p1=new JPanel();
		p1.setLayout(new GridLayout(1,1));
		b1=new JTextArea();
		b1.setText("");
		bill.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int i=0,j=0;
				String n1[] =new String[10];
				String n2="Product\tQuantity\tPrice\n";
				String query1="select * from bill";
				PreparedStatement ps;
				Connection con=App.getConnection();
				try {
					ps=con.prepareStatement(query1);
					ResultSet rs=ps.executeQuery();
					while(rs.next())
					{
						System.out.println(rs.getString(1));
						n1[i]=rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3);
						i++;
					}
					while(j<i)
					{
						n2=n2+n1[j++]+"\n";
					}
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				String n3="";
				String query2="select sum(price) from bill";
				PreparedStatement pr1;
				try {
					pr1=con.prepareStatement(query2);
					ResultSet rs=pr1.executeQuery();
					while(rs.next())
					{
						n3=rs.getString(1);
					}
					n3="Bill:"+n3;
				
					n2=n2+"\n"+"\t"+n3;
					b1.setText(n2);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				String query3="truncate table bill";
				PreparedStatement pr2;
				try {
					pr2=con.prepareStatement(query3);
					pr2.executeUpdate();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		p1.add(b1);
		add(p1);
	}
}