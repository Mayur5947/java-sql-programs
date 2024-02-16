package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import module.Parts;
import service.ConnectionService;

public class PartsRepository {

	ConnectionService connectionService = new ConnectionService();

	public void addPart(Parts parts) throws SQLException {
		Connection connection = connectionService.getConnection();
		PreparedStatement statement = connection.prepareStatement("Insert Into part_inventory values (?,?,?,?)");
		statement.setInt(1, parts.getPart_id());
		statement.setString(2, parts.getPart_name());
		statement.setInt(3, parts.getQty());
		statement.setInt(4, parts.getPrice());
		statement.executeUpdate();
		connection.close();
	}

	public void getPart(int part_id) throws SQLException {
		Connection connection = connectionService.getConnection();
		PreparedStatement statement =  connection.prepareStatement("select * from part_inventory where part_id = ?");
		statement.setInt(1, part_id);
		ResultSet resultSet=statement.executeQuery();
		while(resultSet.next()) {
			System.out.println("----------------->part id             : "+resultSet.getInt(1));
			System.out.println("                  part name           : "+resultSet.getString(2));
			System.out.println("                  part qty available  : "+resultSet.getInt(3));
			System.out.println("                  part price          : "+resultSet.getInt(4));
		}
		connection.close();
	}

	public void getAllParts() throws SQLException {
		Connection connection = connectionService.getConnection();
		PreparedStatement statement =  connection.prepareStatement("select * from part_inventory ");
		ResultSet resultSet=statement.executeQuery();
		while(resultSet.next()) {
			System.out.println("----------------->part id             : "+resultSet.getInt(1));
			System.out.println("                  part name           : "+resultSet.getString(2));
			System.out.println("                  part qty available  : "+resultSet.getInt(3));
			System.out.println("                  part price          : "+resultSet.getInt(4));
		}
		connection.close();
	}

	public void updatePart(Parts parts) throws SQLException {
		Connection connection = connectionService.getConnection();
		PreparedStatement statement = connection.prepareStatement("Update part_inventory set part_name = ? , available_quantity  = ? , price = ? where part_id = ?");
		statement.setString(1, parts.getPart_name());
		statement.setInt(2, parts.getQty());
		statement.setInt(3, parts.getPrice());
		statement.setInt(4, parts.getPart_id());
		statement.executeUpdate();
		connection.close();
	}

}
