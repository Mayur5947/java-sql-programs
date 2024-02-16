package service;

import java.sql.SQLException;
import java.util.Scanner;

import module.History;
import repository.HistoryRepository;

public class HistoryService {

	Scanner scanner = new Scanner(System.in);
	HistoryRepository historyRepository = new HistoryRepository();

	public void createHistory(int request_id, int technician_id,int part_id) throws SQLException {
		System.out.println("                              Enter History Id");
		int history_id = scanner.nextInt();
		System.out.println("                              Enter service Date (service completion date)");
		String service_date = scanner.next();
		System.out.println("                              Enter Comments");
		String comments = scanner.next();

		History history = new History();
		history.setHistory_id(history_id);
		history.setService_date(service_date);
		history.setComments(comments);

		historyRepository.createHistory(request_id, technician_id, history,part_id);
		System.err.println("                      ******************* !!! Thank You !!! Visit again !!! *****************");

	}

	public void getHistory() throws SQLException {
		System.out.println(" enter history id which u want to fetch");
		int history_id = scanner.nextInt();
		historyRepository.getHistory(history_id);
	}

	public void getAllHistory() throws SQLException {
		historyRepository.getAllHistory();
	}

}
