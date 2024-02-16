package service;

import java.sql.SQLException;
import java.util.Scanner;

import module.Customer;
import repository.CustomerRepository;

public class CustomerService {

	CustomerRepository customerRepository = new CustomerRepository();
	Scanner scanner = new Scanner(System.in);

	public void addCustomer() throws SQLException {
		Customer customer = new Customer();
		System.out.println("Enter Cutomer id");
		int customer_id = scanner.nextInt();
		System.out.println("Enter First Name ");
		String first_name = scanner.next();
		System.out.println("Enter Last Name ");
		String last_name = scanner.next();
		System.out.println("Enter Email ");
		String email = scanner.next();
		System.out.println("Enter Address ");
		String address = scanner.next();
		System.out.println("Enter Phone ");
		int phone = scanner.nextInt();

		customer.setCustomer_id(customer_id);
		customer.setFirst_name(first_name);
		customer.setLast_name(last_name);
		customer.setAddress(address);
		customer.setEmail(email);
		customer.setPhone(phone);

		customerRepository.addCutomer(customer);
		System.err.println("********Customer Added  Now Please Add Bike Details******");
		BikeService bikeService = new BikeService();
		bikeService.addBikeForNewCustomer(customer_id, customer);
	}

	public void getCustomer() throws SQLException {
		System.out.println("                  Enter customer Id");
		int customer_id = scanner.nextInt();

		customerRepository.getCustomer(customer_id);
	}

	public void getAllCustomers() throws SQLException {
		customerRepository.getAllCustomers();
	}

	public void updateCustomer() throws SQLException {
		System.out.println("            Enter cutomer id whose u want to update data");
		int customer_id = scanner.nextInt();
		Customer customer =  new Customer();
		
		System.out.println("            Enter new email");
		String email = scanner.next();
		System.out.println("            Enter new address");
		String address = scanner.next();
		System.out.println("             Enter new phone");
		int phone = scanner.nextInt();
		
		customer.setCustomer_id(customer_id);
		customer.setPhone(phone);
		customer.setAddress(address);
		customer.setEmail(email);
		customerRepository.updateCustomer(customer);
	}
}
