package repositories;

import java.util.LinkedList;
import java.util.List;
import java.sql.*;

import entities.Employee;
import repositories.interfaces.*;
import data.interfaces.IDB;

public class EmployeeRepository implements IEmployeeRepository{

	public final IDB db;
	
	public EmployeeRepository(IDB db) {
		this.db = db;
	}
	
	@Override
	public List<Employee> getAllEmployees() {
		Connection con = null;
		try {
			con = db.getConnection();
			String sql = "SELECT id, name, surname, gender, position, salary FROM employees";
			Statement st = con.createStatement();
			
			ResultSet rs = st.executeQuery(sql);
			List<Employee> employees = new LinkedList<>();
			while(rs.next()) {
				Employee employee = new Employee(rs.getInt("id"),
						rs.getString("name"),
						rs.getString("surname"),
						rs.getBoolean("gender"),
						rs.getString("position"),
						rs.getInt("salary"));
				
				employees.add(employee);
			}
			return employees;
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			}
		}
		return null;
	}
	@Override
	public Employee getEmployee(int id) {
		Connection con = null;
		try {
			con = db.getConnection();
			String sql = "SELECT id, name, surname, gender, position, salary FROM employees WHERE id=?";
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setInt(1, id);
			
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				Employee employee =  new Employee(rs.getInt("id"),
						rs.getString("name"),
						rs.getString("surname"),
						rs.getBoolean("gender"),
						rs.getString("position"),
						rs.getInt("salary"));
				
				return employee;
			}	
		} catch(SQLException throwables) {
			throwables.printStackTrace();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch(SQLException throwables){
				throwables.printStackTrace();
			}
		}
		return null;
	}
	
}
