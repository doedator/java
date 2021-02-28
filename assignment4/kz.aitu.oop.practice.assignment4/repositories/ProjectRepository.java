package repositories;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import data.interfaces.IDB;
import entities.Employee;
import repositories.interfaces.IEmployeeRepository;
import repositories.interfaces.IProjectRepository;

public class ProjectRepository implements IProjectRepository{
	
	public final IDB db;
	public final IEmployeeRepository employee;
	
	public ProjectRepository(IDB db, IEmployeeRepository employee) {
		this.db = db;
		this.employee = employee;
	}
	
	@Override
	public List<Employee> createCrew(int cost) {
		List<Employee> temp = employee.getAllEmployees();
		List<Employee> result = new LinkedList<>();
		int sum = cost;
		temp.sort(Comparator.comparing(Employee::getSalary));
		for(Employee emp : temp) {
			if (sum - emp.getSalary() > 0) {
				sum -= emp.getSalary();
				
				result.add(emp);
			}else {
				break;
			}
		}
		return result;
	}
	
	
}
