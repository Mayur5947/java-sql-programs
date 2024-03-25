package preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class fetchingValues 
{
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306","root","root");
			PreparedStatement ps = con.prepareStatement("insert into employee.student (id , name ) values (? , ?)");
			Scanner sc = new Scanner(System.in);
			for(;;)
			{
				System.out.println("1 add 2 stop");
				int choice = sc.nextInt();
				switch(choice)
				{
				case 1 :
				{
					System.out.println("enter id");
					int id = sc.nextInt();
					System.out.println("enter name ");
					String name = sc.next();
					ps.setInt(1, id);
					ps.setString(2, name);
					ps.execute();
					System.out.println("value inserted succesfully");
					break;
				}
				case 2 : return;
				}
			}
			
			
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		} catch (SQLException e) {
						e.printStackTrace();
		}
	}

}
