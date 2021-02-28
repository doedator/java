package repositories.interfaces;

public interface IManagerRepository {
	boolean fireEmployee(int id);
	boolean giveRaise(int id, int salary);
}
