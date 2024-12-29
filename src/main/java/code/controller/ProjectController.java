package code.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import code.service.ProjectService;
import code.types.Project;

@RestController
@RequestMapping(path = "/v1")
public class ProjectController 
{
	@Autowired
	ProjectService projectService;
	
	//Get Mappings
	
	@GetMapping("/helloWorld")
	public String helloWorld()
	{
		return "Hello World!!";
	}
	
	@GetMapping("/getProjects")
	public ResponseEntity<?> findAllProjects()
	{
		List<Project> projects = projectService.findAllProjects();
		
		return ResponseEntity.ok(projects); 
	}
	
	//POST Mappings
	
	@PostMapping("/saveProject")
	public ResponseEntity<? extends Project> saveProject(@RequestBody Project newProject)
	{
		Project savedProject = projectService.saveProject(newProject);
		return ResponseEntity.ok(savedProject);
	}	
}
