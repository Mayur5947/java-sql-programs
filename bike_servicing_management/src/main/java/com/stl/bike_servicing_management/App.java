package com.stl.bike_servicing_management;

import java.awt.Choice;
import java.sql.SQLException;
import java.util.Scanner;

import service.AssignmentService;
import service.BikeService;
import service.CustomerService;
import service.HistoryService;
import service.PartsService;
import service.RequestService;
import service.TechnicianService;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		BikeService bikeService = new BikeService();
		AssignmentService assignmentService = new AssignmentService();
		HistoryService historyService = new HistoryService();
		PartsService partsService = new PartsService();
		TechnicianService technicianService = new TechnicianService();
		RequestService requestService = new RequestService();

		boolean control = true;
		while (control) {
			System.err.println("        1 . Go to App  2.stop");
			int c = scanner.nextInt();
			if (c == 2) {
				control = false;
			}
			System.err.println("                  ***********Welocome to Bike Service Station*********");
			System.out.println();
			System.err.println("Customer Related");
			System.out.println("        1 Register New Customer And Bike");
			System.out.println("        2 View Customer ");
			System.out.println("        3 View All Customers ");
			System.out.println("        4 Update Customer Details ");
			System.out.println("-------------------------------------------------------");
			System.err.println("Bike Related");
			System.out.println("        5  Register New Bike For  Existing Cutomer ");
			System.out.println("        6  View Bike Details ");
			System.out.println("        7  View All Bikes Details ");
			System.out.println("        8  Update Bike Details");
			System.out.println("--------------------------------------------------------");
			System.err.println("Parts Related");
			System.out.println("        9 Add Part Into Inventory ");
			System.out.println("        10 View Specific Part ");
			System.out.println("        11 View  All Parts ");
			System.out.println("        12 Update Part Details ");
			System.out.println("--------------------------------------------------------");
			System.err.println("Assignment Data Related");
			System.out.println("        13 View Assignment ");
			System.out.println("        14 View All Assignments ");
			System.out.println("        15 Update Assignment Details");
			System.out.println("----------------------------------------------------------");
			System.err.println("Service Request Data Related");
			System.out.println("        16 View Request  Details With Id");
			System.out.println("        17 View All Requests  Details ");
			System.out.println("        18 Update Status of Request ");
			System.out.println("----------------------------------------------------------");
			System.err.println("Service Technician Data Related");
			System.out.println("        19 Add New Technician");
			System.out.println("        20 Update Existing Technician Details");
			System.out.println("        21 View Technician Details");
			System.out.println("        22 View All Technician In Service Station");
			System.out.println("----------------------------------------------------------");
			System.err.println("Service History Data Related");
			System.out.println("        23 View History Of Service");
			System.out.println("        24 View Total History");
			System.out.println("----------------------------------------------------------");

			System.out.println();
			System.out.println("Enter Choice");
			int choice = scanner.nextInt();
			CustomerService customerService = new CustomerService();
			switch (choice) {
			case 1: {
				customerService.addCustomer();
				break;
			}
			case 2: {
				customerService.getCustomer();
				break;
			}
			case 3: {
				customerService.getAllCustomers();
				break;
			}
			case 4: {
				customerService.updateCustomer();
				break;
			}
			case 5: {
				bikeService.addBikeOfExistingCustomer();
				break;
			}
			case 6: {
				bikeService.getBike();
				break;
			}
			case 7: {
				bikeService.getAllBikes();
				break;
			}
			case 8: {
				bikeService.updateBikeDetails();
				break;
			}
			case 9: {
				partsService.addPart();
				break;
			}
			case 10: {
				partsService.getPart();
				break;
			}
			case 11: {
				partsService.getAllPArts();
				break;
			}
			case 12: {
				partsService.updatePart();
				break;
			}
			case 13: {
				assignmentService.getAssignment();
				break;
			}
			case 14: {
				assignmentService.getAllAssignment();
				break;
			}
			case 15: {
				assignmentService.updateAssignment();
				break;
			}
			case 16: {
				requestService.getRequest();
				break;
			}
			case 17: {
				requestService.getAllRequests();
				break;
			}
			case 18: {
				requestService.updateRequest();
				break;
			}
			case 19: {
				technicianService.addTechnician();
				break;
			}
			case 20: {
				technicianService.updateTechnician();
				break;
			}
			case 21: {
				technicianService.getTechnician();
			}
			case 22: {
				technicianService.getAllTechnicians();
			}
			case 23: {
				historyService.getHistory();
				break;
			}
			case 24: {
				historyService.getAllHistory();
				break;
			}
			default:
				break;
			}
		}
	}
}
