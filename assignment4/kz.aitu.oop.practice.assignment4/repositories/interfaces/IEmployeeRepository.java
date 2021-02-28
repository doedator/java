package repositories.interfaces;

import java.util.List;

import entities.*;

public interface IEmployeeRepository {
	List<Employee> getAllEmployees();
	Employee getEmployee(int id);
}

