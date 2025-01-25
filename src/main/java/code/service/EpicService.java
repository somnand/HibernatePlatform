package code.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import code.repository.EpicRepository;
import code.types.Epic;

@Service
public class EpicService 
{
	@Autowired
	private EpicRepository epicRepository;
	
	public List<Epic> findAllEpics()
	{
		return epicRepository.findAll();
	}
}
