package repositories;

import entities.Employee;
import entities.Manager;
import repositories.interfaces.*;

public class Transfer implements ITransfer {
	
	public final IEmployeeRepository repo;
	
	public Transfer(IEmployeeRepository repo){
		this.repo = repo; 
	}

	@Override
	public Manager transferData(Employee employee) {
		if (employee.getPosition().contains("manager")) {
		Manager manager = new Manager(employee.getId(),
				employee.getName(),
				employee.getSurname(),
				employee.isGender(),
				employee.getPosition(),
				employee.getSalary());
		return manager;
		} else {
			System.out.println("Entered Id does not belong to the manager");
			return null;
		}
	}
	
}
