import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class o extends JPanel
{
	final JPanel parent;
	JButton emp,cust,sup,back;
	o(final JPanel parent)
	{
		this.parent=parent;
		setLayout(new GridLayout(4,1));
		emp= new JButton("employee");
		add(emp);
		emp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				CardLayout c1=(CardLayout)parent.getLayout();
				c1.show(parent,"employee");
			}
		});
		cust=new JButton("customer");
		add(cust);
		cust.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				CardLayout c1=(CardLayout)parent.getLayout();
				c1.show(parent,"customer");
			}
		});
		
		sup=new JButton("supplier");
		add(sup);
		sup.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				CardLayout c1=(CardLayout)parent.getLayout();
				c1.show(parent,"supplier");
			}
		});
		back=new JButton("back");
		add(back);
		back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				CardLayout c1=(CardLayout)parent.getLayout();
				c1.show(parent,"login");
			}
		});
	}
}

