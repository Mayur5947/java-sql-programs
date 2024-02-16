package service;

import java.sql.SQLException;
import java.util.Scanner;

import module.Parts;
import repository.PartsRepository;

public class PartsService {

	Scanner scanner =  new Scanner(System.in);
	PartsRepository partsRepository =  new PartsRepository();
	
	public void addPart() throws SQLException {
		System.out.println("     Enter part id ");
		int part_id = scanner.nextInt();
		System.out.println("     Enter part name ");
		String part_name = scanner.next();
		System.out.println("     Enter parts available quantity ");
		int part_qty = scanner.nextInt();
		System.out.println("     Enter part price ");
		int part_price = scanner.nextInt();
		
		Parts parts =  new Parts();
		parts.setPart_id(part_id);
		parts.setPart_name(part_name);
		parts.setPrice(part_price);
		parts.setQty(part_qty);
		
		partsRepository.addPart(parts);
		
	}

	public void getPart() throws SQLException {
		System.out.println("enter part id ");
		int part_id = scanner.nextInt();
		partsRepository.getPart(part_id);
	}

	public void getAllPArts() throws SQLException {
		partsRepository.getAllParts();
	}

	public void updatePart() throws SQLException {
		System.out.println("     Enter part id  whose u want to update");
		int part_id = scanner.nextInt();
		System.out.println("     update part name ");
		String part_name = scanner.next();
		System.out.println("     update parts available quantity ");
		int part_qty = scanner.nextInt();
		System.out.println("     update part price ");
		int part_price = scanner.nextInt();
		
		Parts parts =  new Parts();
		parts.setPart_id(part_id);
		parts.setPart_name(part_name);
		parts.setPrice(part_price);
		parts.setQty(part_qty);
		
		partsRepository.updatePart(parts);
		
	}

}
