package executeQuery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ex1 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try {
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "root");
				Statement st = con.createStatement();
				// st.executeUpdate("create table employee.student(id int , name varchar(20))");
				st.execute("insert into employee.student values (1 , 'mayur')");
				st.execute("insert into employee.student values (2 , 'sonu')");
				System.out.println("table created");
				ResultSet rs = st.executeQuery("select * from employee.student");
				while (rs.next()) {
					System.out.print(rs.getInt(1));
					System.out.print(rs.getString(2));
					System.out.println();
				}
				System.out.println("data fetched succesfully");
				con.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

	}

}
