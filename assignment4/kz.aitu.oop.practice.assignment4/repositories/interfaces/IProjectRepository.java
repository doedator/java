package repositories.interfaces;

import entities.Employee;

import java.util.List;

public interface IProjectRepository {
	List<Employee> createCrew(int cost);
}
