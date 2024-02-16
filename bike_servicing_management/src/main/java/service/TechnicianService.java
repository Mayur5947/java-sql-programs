package service;

import java.sql.SQLException;
import java.util.Scanner;

import module.Technician;
import repository.TechnicianRepository;

public class TechnicianService {

	TechnicianRepository repository = new TechnicianRepository();
	Scanner scanner = new Scanner(System.in);

	public void getAllTechnicians() throws SQLException {
		repository.getAllTechnicians();
	}

	public void addTechnician() throws SQLException {
		System.out.println("      Enter technician id");
		int technician_id = scanner.nextInt();
		System.out.println("      Enter First Name ");
		String first_name = scanner.next();
		System.out.println("      Enter Last Name ");
		String last_name = scanner.next();
		System.out.println("     Enter specialization ");
		String specialization  = scanner.next();
		
		Technician technician  = new Technician();
		technician.setTechnician_id(technician_id);
		technician.setFirst_name(first_name);
		technician.setLast_name(last_name);
		technician.setSpecialization(specialization);
		
		repository.addTechnician(technician);
	}

	public void updateTechnician() throws SQLException {
		System.out.println("      Enter technician id");
		int technician_id = scanner.nextInt();
		System.out.println("     Update specialization ");
		String specialization  = scanner.next();
		
		Technician technician  = new Technician();
		technician.setTechnician_id(technician_id);
		technician.setSpecialization(specialization);
		
		repository.updateTechnician(technician);
	}

	public void getTechnician() throws SQLException {
		System.out.println("enter technician id whose data u want to fetch");
		int technician_id = scanner.nextInt();
		repository.getTechnician(technician_id);
	}

}
