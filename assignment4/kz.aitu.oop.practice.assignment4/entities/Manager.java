package entities;

public class Manager extends Employee{
	
	public Manager() {
		super();
		setPosition("manager");
	}

	public Manager(int id, String name, String surname, boolean gender, String position, int salary) {
		setPosition("manager");
	}
	public Manager(String name, String surname, boolean gender, String position, int salary) {
		setPosition("manager");
	}
}
