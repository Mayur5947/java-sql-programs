package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import module.Request;
import service.ConnectionService;

public class RequestRepository {

	ConnectionService connectionService = new ConnectionService();

	public void addRequest(int bike_id, Request request) throws SQLException {
		Connection connection = connectionService.getConnection();
		PreparedStatement statement = connection.prepareStatement("Insert Into service_request Values (?,?,?,?)");
		statement.setInt(1, request.getRequest_id());
		statement.setInt(2, bike_id);
		statement.setString(3, request.getStatus());
		statement.setString(4, request.getDescription());
		statement.executeUpdate();
		connection.close();
	}

	public void getRequest(int request_id) throws SQLException {
		Connection connection = connectionService.getConnection();
		PreparedStatement statement = connection.prepareStatement("select * from service_request where request_id = ?");
		statement.setInt(1, request_id);
		ResultSet resultSet = statement.executeQuery();
		while (resultSet.next()) {
			System.out.println("--------------->Request_id    : " + resultSet.getInt(1));
			System.out.println("                Bilke_id      : " + resultSet.getInt(2));
			System.out.println("                status        : " + resultSet.getString(3));
			System.out.println("                description   : " + resultSet.getString(4));
		}
		connection.close();
	}

	public void getAllRequests() throws SQLException {
		Connection connection = connectionService.getConnection();
		PreparedStatement statement = connection.prepareStatement("select * from service_request");
		ResultSet resultSet = statement.executeQuery();
		while (resultSet.next()) {
			System.out.println("--------------->Request_id    : " + resultSet.getInt(1));
			System.out.println("                Bilke_id      : " + resultSet.getInt(2));
			System.out.println("                status        : " + resultSet.getString(3));
			System.out.println("                description   : " + resultSet.getString(4));
		}
		connection.close();
	}

	public void updateRequest(Request request) throws SQLException {
		Connection connection = connectionService.getConnection();
		PreparedStatement statement = connection.prepareStatement("Update  service_request set status = ? , description = ? where request_id = ?");
		statement.setString(1, request.getStatus());
		statement.setString(2, request.getDescription());
		statement.setInt(3, request.getRequest_id());
		statement.executeUpdate();
		connection.close();
	}

}
