package code.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import code.repository.ProjectRepository;
import code.types.Project;

@Service
public class ProjectService 
{	
	@Autowired
	private ProjectRepository projectRepository;
	
	public List<Project> findAllProjects()
	{
		List<Project> projects = projectRepository.findAll();		
//		Project dummyProject = new Project();
//		dummyProject.setInvestmentId("1234");
//		dummyProject.setWorkEffortId("ABCD");
//		
//		List<Project> projects = new ArrayList<>();
//		projects.add(dummyProject);
		
		return projects;
	}
	
	//POST service methods
	
	public Project saveProject(Project newProject)
	{
		Project savedProject = projectRepository.save(newProject);
		return savedProject;
	}
}
