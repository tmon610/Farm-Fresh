import java.awt.CardLayout;
import java.awt.Container;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;

class App extends JFrame
{
	static Connection con;
	App()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}
		String url="jdbc:mysql://localhost:3306/retailstore";
		String username="root";
		String password="";
		try {
			con=DriverManager.getConnection(url,username,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}
		System.out.println(con);
		Container c=getContentPane();
		JPanel parent=new JPanel();
		c.add(parent);
		CardLayout c1=new CardLayout();
		parent.setLayout(c1);
		L p1=new L(parent);
		parent.add("login",p1);
		o p2=new o(parent);
		parent.add("new user",p2);
		E p3=new E(parent);
		parent.add("employee",p3);
		Su p4=new Su(parent);
		parent.add("supplier",p4);
		C p5=new C(parent);
		parent.add("customer",p5);
		c1.show(parent,"login");
		List p6=new List(parent);
		parent.add("done_with_buying",p6);
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static Connection getConnection()
	{
		return con;
	}
}

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new App();
	}

}
