package code.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import code.service.ProjectService;
import types.Project;

@RestController
@RequestMapping(path = "/v1")
public class ProjectController 
{
	@Autowired
	ProjectService projectService;
	
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
	
	@PostMapping("/saveProduct")
	public void saveProduct()
	{
		
		
	}
	
	
}
