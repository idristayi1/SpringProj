package com.qa.dogSpring.service;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.qa.dogSpring.domain.Main;

import com.qa.dogSpring.repo.MainRepo;

@Service
public class MainService implements ServiceMethods<Main> {
	
	//NOT making a new 
	private MainRepo repo;
	
	//Above is different to this - we are trying to instantiate an object below (impossible with an object)
//	MainRepo repos = new MainRepo();
	
	//Constructor
	public MainService(MainRepo repo) {
		
		this.repo =repo;
	}

	@Override
	public Main create(Main main) {
	
		return this.repo.save(main);
	}

	@Override
	public List<Main> getAll() {
	
		return this.repo.findAll();
	}

	@Override
	public Main getById(long id) {
		Optional<Main> optionalMain = this.repo.findById(id);
		if(optionalMain.isPresent()) {
			return optionalMain.get();
		}
		return null;
	}

	@Override
	public Main update(long id, Main main) {
		Optional<Main> existingMain = this.repo.findById(id);
		if(existingMain.isPresent()) {
			
			Main existing = existingMain.get();
			existing.setAge(main.getAge());
			existing.setFirstName(main.getFirstName());
			existing.setLastName(main.getLastName());
			
			return this.repo.saveAndFlush(existing);
		}
		return null;
	} 

	@Override
	public boolean delete(long id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
		
}
	
	

}
