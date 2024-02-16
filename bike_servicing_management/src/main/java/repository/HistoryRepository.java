package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import module.History;
import service.ConnectionService;

public class HistoryRepository {

	ConnectionService connectionService = new ConnectionService();

	public void createHistory(int request_id, int technician_id, History history,int part_id) throws SQLException {
		Connection connection = connectionService.getConnection();
		PreparedStatement statement = connection.prepareStatement("Insert Into service_history values (?,?,?,?,?,?)");
		statement.setInt(1, history.getHistory_id());
		statement.setInt(2, request_id);
		statement.setInt(3, technician_id);
		statement.setInt(4, part_id);
		statement.setString(5, history.getService_date());
		statement.setString(6, history.getComments());
		statement.executeUpdate();
		connection.close();
	}

	public void getHistory(int history_id) throws SQLException {
		Connection connection = connectionService.getConnection();
		PreparedStatement statement = connection.prepareStatement("select * from service_history where history_id = ?");
		statement.setInt(1, history_id);
		ResultSet resultSet = statement.executeQuery();
		while(resultSet.next()) {
			System.out.println("--------------------> History_id     : " +resultSet.getInt(1));
			System.out.println("                      request_id     : " +resultSet.getInt(2));
			System.out.println("                      technician_id  : " +resultSet.getInt(3));
			System.out.println("                      part_id        : " +resultSet.getInt(4));
			System.out.println("                      service date   : " +resultSet.getString(5));
			System.out.println("                      comments       : " +resultSet.getString(6));
		}
		connection.close();
	}
	
	public void getAllHistory() throws SQLException {
		Connection connection = connectionService.getConnection();
		PreparedStatement statement = connection.prepareStatement("select * from service_history");
		ResultSet resultSet = statement.executeQuery();
		while(resultSet.next()) {
			System.out.println("--------------------->History_id     : " +resultSet.getInt(1));
			System.out.println("                      request_id     : " +resultSet.getInt(2));
			System.out.println("                      technician_id  : " +resultSet.getInt(3));
			System.out.println("                      part_id        : " +resultSet.getInt(4));
			System.out.println("                      service date   : " +resultSet.getString(5));
			System.out.println("                      comments       : " +resultSet.getString(6));
		}
		connection.close();
	}

}
