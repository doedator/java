package repositories;

import java.sql.*;

import data.interfaces.IDB;
import repositories.interfaces.*;

public class ManagerRepository implements IManagerRepository{
	
	public final IDB db;
	
	public ManagerRepository(IDB db) {
		this.db = db;
	}

	@Override
	public boolean fireEmployee(int id) {
		Connection con = null;
		try {
			con = db.getConnection();
			String sql = "DELETE FROM employees WHERE id=?";
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setInt(1, id);
			
			st.execute();
			return true;
		} catch(SQLException throwables) {
			throwables.printStackTrace();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} finally{
			try {
				con.close();
			} catch(SQLException throwables) {
				throwables.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public boolean giveRaise(int id, int salary) {
		Connection con = null;
		try {
			con = db.getConnection();
			String sql = "UPDATE employees SET salary=? WHERE id=?;";
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setInt(1, salary);
			st.setInt(2, id);
			
			st.execute();
			
			return true;
		} catch(SQLException throwables) {
			throwables.printStackTrace();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch(SQLException throwables) {
				throwables.printStackTrace();
			}
		}
		return false;
	}
	
	
}
