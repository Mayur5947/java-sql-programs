package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import module.Bike;
import module.Customer;
import service.ConnectionService;

public class BikeRepository {

	ConnectionService connectionService = new ConnectionService();

	public void addBikeOfNewCustomer(int customer_id, Bike bike) throws SQLException {
		Connection connection = connectionService.getConnection();
		PreparedStatement statement = connection.prepareStatement("Insert Into Bike Values (?,?,?,?,?,?,?)");
		statement.setInt(1, bike.getBike_id());
		statement.setInt(2, customer_id);
		statement.setString(3, bike.getMake());
		statement.setString(4, bike.getModel());
		statement.setString(5, bike.getColor());
		statement.setString(6, bike.getNumberPlate());
		statement.setString(7, bike.getYear());
		statement.executeUpdate();
		connection.close();
	}

	public void getBike(int bike_id) throws SQLException {
		Connection connection = connectionService.getConnection();
		PreparedStatement statement = connection.prepareStatement("Select * From Bike where bike_id = ?");
		statement.setInt(1, bike_id);
		ResultSet resultSet = statement.executeQuery();
		while (resultSet.next()) {
			System.out.println("--------------->Bike id                :" + resultSet.getInt(1));
			System.out.println("                Customer id            :" + resultSet.getInt(2));
			System.out.println("                bike make              :" + resultSet.getString(3));
			System.out.println("                bike model             :" + resultSet.getString(4));
			System.out.println("                bike color             :" + resultSet.getString(5));
			System.out.println("                bike number plate      :" + resultSet.getString(6));
			System.out.println("                bike year              :" + resultSet.getString(7));
		}
		connection.close();
	}

	public void getAllBikes() throws SQLException {
		Connection connection = connectionService.getConnection();
		PreparedStatement statement = connection.prepareStatement("Select * From Bike ");
		ResultSet resultSet = statement.executeQuery();
		while (resultSet.next()) {
			System.out.println("--------------->Bike id                :" + resultSet.getInt(1));
			System.out.println("                Customer id            :" + resultSet.getInt(2));
			System.out.println("                bike make              :" + resultSet.getString(3));
			System.out.println("                bike model             :" + resultSet.getString(4));
			System.out.println("                bike color             :" + resultSet.getString(5));
			System.out.println("                bike number plate      :" + resultSet.getString(6));
			System.out.println("                bike year              :" + resultSet.getString(7));
		}
		connection.close();
	}

	public void updateBike(Bike bike) throws SQLException {
		Connection connection = connectionService.getConnection();
		PreparedStatement statement = connection.prepareStatement("update bike set make = ? , model = ? ,color = ?,license_plate = ? , year = ? where bike_id = ? ");
		statement.setInt(6, bike.getBike_id());
		statement.setString(1, bike.getMake());
		statement.setString(2, bike.getModel());
		statement.setString(3, bike.getColor());
		statement.setString(4, bike.getNumberPlate());
		statement.setString(5, bike.getYear());
		statement.executeUpdate();
		connection.close();
	}

}
