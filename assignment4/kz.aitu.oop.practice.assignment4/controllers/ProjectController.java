package controllers;

import repositories.interfaces.IProjectRepository;

import java.util.List;

import entities.Employee;

public class ProjectController {
	private final IProjectRepository repo;
	
	public ProjectController(IProjectRepository repo) {
		this.repo = repo;
	}
	
	public String createCrew(int cost) {
		List<Employee> team = repo.createCrew(cost);
		return team.toString();
	}
}
