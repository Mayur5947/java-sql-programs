package service;

import java.sql.SQLException;
import java.util.Scanner;

import module.Assignment;
import repository.AssignmentRepository;

public class AssignmentService {

	AssignmentRepository assignmentRepository = new AssignmentRepository();
	Scanner scanner = new Scanner(System.in);

	public void createAssignment(int request_id, int technician_id,int part_id) throws SQLException {
		System.out.println("                     Enter Assignment Id");
		int assignment_id = scanner.nextInt();
		System.out.println("                     Enter Status of Asignment (created / in-process / done)");
		String status = scanner.next();
		System.out.println("                     Enter asignment date (ex.01-sep-2001)");
		String date = scanner.next();

		Assignment assignment = new Assignment();
		assignment.setAssignment_id(assignment_id);
		assignment.setStatus(status);
		assignment.setDate(date);

		assignmentRepository.createAssignment(request_id, technician_id, assignment,part_id);
		HistoryService historyService = new HistoryService();
		historyService.createHistory(request_id, technician_id,part_id);
	}

	public void getAssignment() throws SQLException {
		System.out.println("    Enter assignment id whose u want to fetch data");
		int assignment_id = scanner.nextInt();
		assignmentRepository.getAssignment(assignment_id);
	}
	
	public void getAllAssignment() throws SQLException {
		assignmentRepository.getAllAssignment();
	}

	public void updateAssignment() throws SQLException {
		System.out.println("                     Enter Assignment Id whose u want to update data");
		int assignment_id = scanner.nextInt();
		System.out.println("                     Update Status of Asignment (created / in-process / done)");
		String status = scanner.next();
		System.out.println("                     Update asignment date (ex.01-sep-2001)");
		String date = scanner.next();

		Assignment assignment = new Assignment();
		assignment.setAssignment_id(assignment_id);
		assignment.setStatus(status);
		assignment.setDate(date);
		
		assignmentRepository.updateAssignment(assignment);
	}

}
