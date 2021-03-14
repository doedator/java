package com.javacource.se.lesson5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PostgresDB {

    private static PostgresDB instance;
    private Connection connection;
    private String url = "jdbc:postgresql://localhost:5432/supply management";
    private String username = "postgres";
    private String password = "123";

    private PostgresDB() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException ex) {
            System.out.println("Database Connection Creation Failed : " + ex.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static PostgresDB getInstance() throws SQLException {
        if (instance == null) {
            instance = new PostgresDB();
        } else if (instance.getConnection().isClosed()) {
            instance = new PostgresDB();
        }

        return instance;
    }
    
    public int getUserId(String login) {
		Connection con = null;
		try {
			con = instance.getConnection();
			String sql = "SELECT id FROM users WHERE login =?";
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, login);
			
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				int id = rs.getInt("id");
				
				return id;
			}
		} catch(SQLException throwables) {
			throwables.printStackTrace();
		} finally {
			try {
				con.close();
			} catch(SQLException throwables){
				throwables.printStackTrace();
			}
		}
		return 0;
	}
}

class Application{
	public static void main(String[] args) throws SQLException {
        PostgresDB foo = PostgresDB.getInstance();
        System.out.println(foo.getUserId("Bob"));
        
        PostgresDB bar = PostgresDB.getInstance();
        System.out.println(bar.getUserId("Bob"));
        // The variable `bar` will contain the same object as
        // the variable `foo`.
	}
}
