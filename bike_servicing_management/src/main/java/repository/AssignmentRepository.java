package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import module.Assignment;
import service.ConnectionService;

public class AssignmentRepository {

	ConnectionService connectionService = new ConnectionService();

	public void createAssignment(int request_id, int technician_id, Assignment assignment, int part_id)
			throws SQLException {
		Connection connection = connectionService.getConnection();
		PreparedStatement statement = connection
				.prepareStatement("Insert Into service_assignment values (?,?,?,?,?,?)");
		statement.setInt(1, assignment.getAssignment_id());
		statement.setInt(2, request_id);
		statement.setInt(3, technician_id);
		statement.setInt(4, part_id);
		statement.setString(5, assignment.getStatus());
		statement.setString(6, assignment.getDate());
		statement.executeUpdate();
		connection.close();

	}

	public void getAssignment(int assignment_id) throws SQLException {
		Connection connection = connectionService.getConnection();
		PreparedStatement statement = connection
				.prepareStatement("Select * From service_assignment where assignment_id = ?");
		statement.setInt(1, assignment_id);
		ResultSet resultSet = statement.executeQuery();
		while(resultSet.next()) {
			System.out.println("---------------------->Assignment id     : "+resultSet.getInt(1));
			System.out.println("                       Request id        : "+resultSet.getInt(2));
			System.out.println("                       Technician id     : "+resultSet.getInt(3));
			System.out.println("                       Part id           : "+resultSet.getInt(4));
			System.out.println("                       Assignment status : "+resultSet.getString(5));
			System.out.println("                       Assignment date   : "+resultSet.getString(6));
		}
		connection.close();
	}
	
	public void getAllAssignment() throws SQLException {
		Connection connection = connectionService.getConnection();
		PreparedStatement statement = connection
				.prepareStatement("Select * From service_assignment");
		ResultSet resultSet = statement.executeQuery();
		while(resultSet.next()) {
			System.out.println("---------------------->Assignment id     : "+resultSet.getInt(1));
			System.out.println("                       Request id        : "+resultSet.getInt(2));
			System.out.println("                       Technician id     : "+resultSet.getInt(3));
			System.out.println("                       Part id           : "+resultSet.getInt(4));
			System.out.println("                       Assignment status : "+resultSet.getString(5));
			System.out.println("                       Assignment date   : "+resultSet.getString(6));
		}
		connection.close();
	}

	public void updateAssignment(Assignment assignment) throws SQLException {
		Connection connection = connectionService.getConnection();
		PreparedStatement statement = connection
				.prepareStatement("update service_assignment set status = ? , assignment_date = ? where assignment_id = ?");
		statement.setString(1, assignment.getStatus());
		statement.setString(2, assignment.getDate());
		statement.setInt(3, assignment.getAssignment_id());
		statement.executeUpdate();
		connection.close();

	}

}
