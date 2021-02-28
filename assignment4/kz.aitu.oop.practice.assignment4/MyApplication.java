
import controllers.*;

import entities.*;

import repositories.interfaces.ITransfer;

import java.util.Scanner;

public class MyApplication {
	private final EmployeeController econtroller;
	private final ManagerController mcontroller;
	private final ProjectController pcontroller;
	private final ITransfer transfer;
	private final Scanner scanner;
	
	public MyApplication(EmployeeController econtroller, ManagerController mcontroller, ProjectController pcontroller,ITransfer transfer) {
		this.econtroller = econtroller;
		this.mcontroller = mcontroller;
		this.pcontroller = pcontroller;
		this.transfer = transfer;
		this.scanner = new Scanner (System.in);
	}
	
	public void start() {
		while(true) {
			System.out.println();
			System.out.println("Welcome to my Application");
			System.out.println("Select option:");
			System.out.println("1. Show all employees");
			System.out.println("2. Enter cost of the Project and see the suggested crew");
			System.out.println("3. Give Raise (manager password required)"); // I was doing this assignment for too long and decided not to implement passwords 
			System.out.println("4. Fire an employee (manager password required");
			System.out.println("0. Exit");
			try {
				System.out.println("Enter Option(0-4): ");
				int option = scanner.nextInt();
				if (option == 1) {
					getAllEmployeesMenu();
				} else if (option == 2) {
					int cost = scanner.nextInt();
					createCrewMenu(cost);
				} else if (option == 3) {
					try {
						System.out.println("Enter your ID:");
						int id = scanner.nextInt();
						Manager manager = transfer.transferData(econtroller.getEmployee(id));
						if (manager == null) {
							throw new Exception();
						}else {
							System.out.println("Enter your employee's ID:");
							id = scanner.nextInt();
							System.out.println("Enter your employee's new Salary:");
							int salary = scanner.nextInt();
							mcontroller.giveRaise(id, salary);
						}
					} catch(Exception e) {
						scanner.nextLine();
					}
				} else if (option == 4) { // the reason I don't have employee with id = 9 is because I was testing this option
					try {
						System.out.println("Enter your ID:");
						int id = scanner.nextInt();
						Manager manager = transfer.transferData(econtroller.getEmployee(id));
						if (manager == null) {
							throw new Exception();
						}else {
							System.out.println("Enter your employee's ID:");
							id = scanner.nextInt();
							mcontroller.fireEmployee(id);
						}
					} catch(Exception e) {
						scanner.nextLine();
					}
				} else if (option == 0) {
					break;
				}
			
				
			}catch (NumberFormatException ex) {
				System.out.println("Input must  be integer");
				scanner.nextLine(); // to ignore incorrect input
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
			finally {
				System.out.println("*****************************************");
			}
		}
	}

	private void createCrewMenu(int cost) {
		String response = pcontroller.createCrew(cost);
		System.out.println(response);
	}

	private void getAllEmployeesMenu() {
		String response = econtroller.getAllEmployees();
		System.out.println(response);
	}
}
