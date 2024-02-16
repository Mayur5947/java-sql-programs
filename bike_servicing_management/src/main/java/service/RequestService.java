package service;

import java.sql.SQLException;
import java.util.Scanner;

import module.Request;
import repository.RequestRepository;

public class RequestService {

	Scanner scanner = new Scanner(System.in);
	RequestRepository repository = new RequestRepository();

	public void addRequest(int bike_id) throws SQLException {
		System.out.println("                     Enter Request id");
		int request_id = scanner.nextInt();
		System.out.println("                     Enter Status of Request id  (in-process/on waiting / completed)");
		String status = scanner.next();
		System.out.println("                     Enter Description (things to do in servicing in short)");
		String description = scanner.next();

		Request request = new Request();
		request.setRequest_id(request_id);
		request.setStatus(status);
		request.setDescription(description);

		repository.addRequest(bike_id, request);
		System.err.println("**********************Request is Created ...Fill the technician Details*****************");
		TechnicianService technicianService = new TechnicianService();
		System.out.println();
		System.err.println(
				"                  These are the technicians are available in station please enter id whose u want to give this assisgnment");
		technicianService.getAllTechnicians();
		int technician_id = scanner.nextInt();
		int part_id = 0;
		System.err.println("                             Enter part id which is loaded");
		part_id = scanner.nextInt();
		System.err.println("                        Assignment is creating");
		AssignmentService assignmentService = new AssignmentService();
		assignmentService.createAssignment(request_id, technician_id, part_id);

	}

	public void getRequest() throws SQLException {
		System.out.println("enter request id whose data u want to fetch");
		int request_id = scanner.nextInt();
		repository.getRequest(request_id);
	}

	public void getAllRequests() throws SQLException {
		repository.getAllRequests();
	}

	public void updateRequest() throws SQLException {
		System.out.println("                     Enter Request id whose u want to update status");
		int request_id = scanner.nextInt();
		System.out.println("                     Update  Status of Request id  (in-process/on waiting / completed)");
		String status = scanner.next();
		System.out.println("                     Enter Description (things to do in servicing in short)");
		String description = scanner.next();

		Request request = new Request();
		request.setRequest_id(request_id);
		request.setStatus(status);
		request.setDescription(description);
		
		repository.updateRequest(request);
	}

}
