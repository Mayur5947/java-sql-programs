package service;

import java.sql.SQLException;
import java.util.Scanner;

import module.Bike;
import module.Customer;
import repository.BikeRepository;

public class BikeService {
	Scanner scanner = new Scanner(System.in);
	BikeRepository bikeRepository = new BikeRepository();

	public void addBikeForNewCustomer(int customer_id, Customer customer) throws SQLException {
		Bike bike = new Bike();
		System.out.println("Enter Bike Id");
		int bike_id = scanner.nextInt();
		System.out.println("Enter Make of bike");
		String make = scanner.next();
		System.out.println("Enter Model of bike");
		String model = scanner.next();
		System.out.println("Enter Color of bike");
		String color = scanner.next();
		System.out.println("Enter NumberPlate of bike");
		String NumberPlate = scanner.next();
		System.out.println("Enter year of bike");
		String year = scanner.next();

		bike.setBike_id(bike_id);
		bike.setMake(make);
		bike.setModel(model);
		bike.setColor(color);
		bike.setNumberPlate(NumberPlate);
		bike.setYear(year);

		bikeRepository.addBikeOfNewCustomer(customer_id, bike);
		System.err.println("************************Bike Details Added your Request is creating********************");
		RequestService requestService = new RequestService();
		requestService.addRequest(bike_id);

	}

	public void addBikeOfExistingCustomer() throws SQLException {

		Bike bike = new Bike();
		System.out.println("Enter existing Customer id");
		int customer_id = scanner.nextInt();
		System.out.println("Enter Bike Id");
		int bike_id = scanner.nextInt();
		System.out.println("Enter Make of bike");
		String make = scanner.next();
		System.out.println("Enter Model of bike");
		String model = scanner.next();
		System.out.println("Enter Color of bike");
		String color = scanner.next();
		System.out.println("Enter NumberPlate of bike");
		String NumberPlate = scanner.next();
		System.out.println("Enter year of bike");
		String year = scanner.next();

		bike.setBike_id(bike_id);
		bike.setMake(make);
		bike.setModel(model);
		bike.setColor(color);
		bike.setNumberPlate(NumberPlate);
		bike.setYear(year);

		bikeRepository.addBikeOfNewCustomer(customer_id, bike);
		System.err.println("                            Bike Added");
	}

	public void getBike() throws SQLException {
		System.out.println(" Enter Bike_id");
		int bike_id = scanner.nextInt();
		bikeRepository.getBike(bike_id);
	}

	public void getAllBikes() throws SQLException {
		bikeRepository.getAllBikes();
	}

	public void updateBikeDetails() throws SQLException {
		Bike bike =  new Bike();
		System.out.println("Enter Bike id whose data u want to update");
		int bike_id = scanner.nextInt();
		System.out.println("Enter new Make of bike");
		String make = scanner.next();
		System.out.println("Enter new Model of bike");
		String model = scanner.next();
		System.out.println("Enter new Color of bike");
		String color = scanner.next();
		System.out.println("Enter new NumberPlate of bike");
		String NumberPlate = scanner.next();
		System.out.println("Enter  new year of bike");
		String year = scanner.next();
		
		bike.setBike_id(bike_id);
		bike.setMake(make);
		bike.setModel(model);
		bike.setColor(color);
		bike.setNumberPlate(NumberPlate);
		bike.setYear(year);
		
		bikeRepository.updateBike(bike);

	}

}
