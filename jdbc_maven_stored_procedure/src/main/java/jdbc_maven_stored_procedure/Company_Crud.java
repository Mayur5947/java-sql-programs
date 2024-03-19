package jdbc_maven_stored_procedure;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class Company_Crud {

	public Connection getConnection() throws IOException, SQLException {

		FileInputStream fileInputStream = new FileInputStream("companydbconfig.properties");
		Properties properties = new Properties();
		properties.load(fileInputStream);

		Connection connection = DriverManager.getConnection(properties.getProperty("url"),
				properties.getProperty("user"), properties.getProperty("password"));
		return connection;
	}

	public void insertCompany(company company) throws IOException, SQLException {
		Connection connection = getConnection();
		CallableStatement callableStatement = connection.prepareCall("call companydb.company_insert(?,?,?,?,?)");
		callableStatement.setInt(1, company.getId());
		callableStatement.setString(2, company.getName());
		callableStatement.setString(3, company.getGst());
		callableStatement.setString(4, company.getAddress());
		callableStatement.setLong(5, company.getPhone());
		int a = callableStatement.executeUpdate();
		if (a != 0) {
			System.out.println("inserted");
		} else {
			System.out.println("failed to insert");
		}
		connection.close();
	}

	public void deleteCompany(company company) throws IOException, SQLException {
		Connection connection = getConnection();
		CallableStatement callableStatement = connection.prepareCall("call companydb.company_delete(?)");
		callableStatement.setInt(1, company.getId());

		int a = callableStatement.executeUpdate();
		if (a != 0) {
			System.out.println("deleted");
		} else {
			System.out.println("failed to deleted");
		}
		connection.close();
	}

	public void updateCompany(company company) throws IOException, SQLException {
		Connection connection = getConnection();
		CallableStatement callableStatement = connection.prepareCall("call companydb.company_update(?,?,?,?,?)");
		callableStatement.setInt(1, company.getId());
		callableStatement.setString(2, company.getName());
		callableStatement.setString(3, company.getGst());
		callableStatement.setString(4, company.getAddress());
		callableStatement.setLong(5, company.getPhone());

		int a = callableStatement.executeUpdate();
		if (a != 0) {
			System.out.println("updated");
		} else {
			System.out.println("failed to update");
		}
		connection.close();
	}

	public void fetchCompanyById(company company) throws SQLException, IOException {

		Connection connection = getConnection();
		CallableStatement callableStatement = connection.prepareCall("call companydb.company_fetchById(?)");
		callableStatement.setInt(1, company.getId());

		ResultSet resultSet = callableStatement.executeQuery();
		while (resultSet.next()) {
			System.out.println(resultSet.getInt(1));
			System.out.println(resultSet.getString(2));
			System.out.println(resultSet.getString(3));
			System.out.println(resultSet.getString(4));
			System.out.println(resultSet.getLong(5));

		}
		connection.close();
	}
}
