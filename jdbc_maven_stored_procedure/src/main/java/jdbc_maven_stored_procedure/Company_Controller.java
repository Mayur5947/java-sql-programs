package jdbc_maven_stored_procedure;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Company_Controller {
	public static void main(String[] args) throws IOException, SQLException {
		company company = new company();
		Company_Crud crud = new Company_Crud();
		Scanner scanner = new Scanner(System.in);

		for (;;) {
			System.out.println("1 insert 2 delete  3 update 4 fetch by ID  5 stop");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1: {
				System.out.println("enter id ");
				int id = scanner.nextInt();

				System.out.println("enter name of company ");
				String name = scanner.next();

				System.out.println("enter gst ");
				String gst = scanner.next();

				System.out.println("enter phone  number");
				long phone = scanner.nextLong();

				System.out.println("enter address");
				String address = scanner.next();

				company.setId(id);
				company.setName(name);
				company.setAddress(address);
				company.setGst(gst);
				company.setPhone(phone);

				crud.insertCompany(company);
			}
				break;
			case 2: {
				System.out.println("enter id ");
				int id = scanner.nextInt();

				company.setId(id);
				crud.deleteCompany(company);
				break;

			}
			case 3: {
				System.out.println("enter id ");
				int id = scanner.nextInt();

				System.out.println("------------enter new data");

				System.out.println("enter name of company ");
				String name = scanner.next();

				System.out.println("enter gst ");
				String gst = scanner.next();

				System.out.println("enter phone  number");
				long phone = scanner.nextLong();

				System.out.println("enter address");
				String address = scanner.next();

				company.setId(id);
				company.setName(name);
				company.setAddress(address);
				company.setGst(gst);
				company.setPhone(phone);

				crud.updateCompany(company);
				break;

			}
			case 4: {
				System.out.println("enter id ");
				int id = scanner.nextInt();

				company.setId(id);
				crud.fetchCompanyById(company);
				break;
			}
			case 5: {
				return;
			}
			}
		}
	}

}
