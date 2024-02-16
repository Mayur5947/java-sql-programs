package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import module.Technician;
import service.ConnectionService;

public class TechnicianRepository {

	ConnectionService connectionService = new ConnectionService();

	public void getAllTechnicians() throws SQLException {
		Connection connection = connectionService.getConnection();
		PreparedStatement statement = connection.prepareStatement("Select * From service_technician");
		ResultSet resultSet = statement.executeQuery();
		while (resultSet.next()) {
			System.out.println("---------------------->technician id             : " + resultSet.getInt(1));
			System.out.println("                       technician specialization : " + resultSet.getString(2));
			System.out.println("                       technician first name     : " + resultSet.getString(3));
			System.out.println("                       technician last name      : " + resultSet.getString(4));
  		}
		connection.close();
	}

	public void addTechnician(Technician technician) throws SQLException {
		Connection connection = connectionService.getConnection();
		PreparedStatement statement =  connection.prepareStatement("insert into service_technician values (?,?,?,?)");
		statement.setInt(1, technician.getTechnician_id());
		statement.setString(2, technician.getFirst_name());
		statement.setString(3, technician.getLast_name());
		statement.setString(4, technician.getSpecialization());
		statement.executeUpdate();
		connection.close();
	}

	public void updateTechnician(Technician technician) throws SQLException {
		Connection connection = connectionService.getConnection();
		PreparedStatement statement =  connection.prepareStatement("update service_technician set specialization = ? where technician_id = ?");
		statement.setString(1, technician.getSpecialization());
		statement.setInt(2, technician.getTechnician_id());
		statement.executeUpdate();
		connection.close();
	}
	

	public void getTechnician(int technician_id) throws SQLException {
		Connection connection = connectionService.getConnection();
		PreparedStatement statement = connection.prepareStatement("Select * From service_technician where technician_id = ?");
		statement.setInt(1, technician_id);
		ResultSet resultSet = statement.executeQuery();
		while (resultSet.next()) {
			System.out.println("---------------------->technician id              : " + resultSet.getInt(1));
			System.out.println("                       technician specialization  : " + resultSet.getString(2));
			System.out.println("                       technician first name      : " + resultSet.getString(3));
			System.out.println("                       technician last name       : " +  resultSet.getString(4));
		}
		connection.close();
	}

}
