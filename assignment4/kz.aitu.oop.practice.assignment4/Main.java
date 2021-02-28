
import repositories.interfaces.*;
import data.interfaces.*;
import data.*;
import repositories.*;
import controllers.*;

public class Main {
	
	public static void main(String[] args) {
		IDB db = new PostgresDB();
		
		IManagerRepository mrepo = new ManagerRepository(db);
		ManagerController mcontroller = new ManagerController(mrepo);
		
		IEmployeeRepository erepo = new EmployeeRepository(db);
		EmployeeController controller = new EmployeeController(erepo);
		
		IProjectRepository prepo = new ProjectRepository(db, erepo);
		ProjectController pcontroller = new ProjectController(prepo);
		
		ITransfer transfer = new Transfer(erepo);
		
		MyApplication app = new MyApplication(controller, mcontroller, pcontroller, transfer);
		app.start();
	}
}
