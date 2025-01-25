package code.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import code.service.EpicService;
import code.types.Epic;

@RestController
@RequestMapping(path = "/v2")
public class EpicController 
{
	@Autowired
	private EpicService epicService;
	
	@GetMapping(value = "/getEpics")
	public ResponseEntity<?> getAllEpicData()
	{
		List<Epic> epics = epicService.findAllEpics();
		return ResponseEntity.ok(epics);		
	}
}
