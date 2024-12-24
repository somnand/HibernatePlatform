package code.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import types.Project;

@Service
public class ProjectService 
{
	public List<Project> findAllProjects()
	{
		Project dummyProject = new Project();
		dummyProject.setInvestmentId("1234");
		dummyProject.setWorkEffortId("ABCD");
		
		List<Project> projects = new ArrayList<>();
		projects.add(dummyProject);
		
		return projects;
	}	
}
