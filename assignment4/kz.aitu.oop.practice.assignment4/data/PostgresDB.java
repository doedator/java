package data;

import data.interfaces.IDB;

import java.sql.*;

public class PostgresDB implements IDB {
	@Override
	public Connection getConnection() throws SQLException, ClassNotFoundException{
		String jdbcURL = "jdbc:postgresql://localhost:5432/Company";
		String username = "postgres";
		String password = "123";
		try {
			Connection connection = DriverManager.getConnection(jdbcURL, username, password);
			return connection;
		} catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}
}
