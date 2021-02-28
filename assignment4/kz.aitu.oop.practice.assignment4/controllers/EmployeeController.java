package controllers;

import java.util.List;

import entities.*;
import repositories.interfaces.*;

public class EmployeeController {
	private final IEmployeeRepository repo;
		
	public EmployeeController(IEmployeeRepository repo){
		this.repo = repo;
	}
	
	public String getAllEmployees() {
		List<Employee> employees = repo.getAllEmployees();
		
		return employees.toString();
	}
	
	public String getEmployeeText(int id) {
		Employee employee = repo.getEmployee(id);
		
		return (employee == null ? "Employee was not found!" : employee.toString());
	}
	public Employee getEmployee(int id) {
		Employee employee = repo.getEmployee(id);
		
		return employee;
	}
}
