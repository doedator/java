package controllers;

import repositories.interfaces.IManagerRepository;

public class ManagerController {
	private final IManagerRepository repo;
	
	public ManagerController(IManagerRepository repo) {
		this.repo = repo;
	}
	public String fireEmployee(int id) {
		boolean fired = repo.fireEmployee(id);
		
		return (fired ? "Employee was fired." : "Something went wrong while firing the employee");
	}
	public String giveRaise(int id, int salary) {
		boolean raised = repo.giveRaise(id, salary);
		
		return (raised? "Salary was changed" : "Salary changing went wrong");
	}
}
