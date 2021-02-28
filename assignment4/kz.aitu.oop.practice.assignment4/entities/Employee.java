package entities;

public class Employee {
	private int id;
	private String name;
	private String surname;
	private boolean gender;
	private String position;
	private int salary;
	
	public Employee() {
		
	}
	
	public Employee(int id, String name, String surname, boolean gender, String position, int salary) {
		setId(id);
		setName(name);
		setSurname(surname);
		setGender(gender);
		setPosition(position);
		setSalary(salary);
	}

	public Employee(String name, String surname, boolean gender, String position, int salary) {
		setName(name);
		setSurname(surname);
		setGender(gender);
		setPosition(position);
		setSalary(salary);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}
	
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee{" +
				"id=" + getId() + 
				", name= '" + getName() + '\'' +
				", surname= '" + getSurname() + '\'' +
				", gender= " + (isGender() ? "Male" : "Female") +
				", position= '" + getPosition() + '\'' +
				", salary= " + getSalary() +
				'}';
	}
	
	
}
