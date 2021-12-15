package com.qa.dogSpring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.dogSpring.domain.Main;
import com.qa.dogSpring.service.MainService;

@RestController
@RequestMapping("/main")

public class MainController {
	
	private MainService service;
	
	private MainController(MainService service) {
		this.service = service;
		
	}
	
	//Create
	@PostMapping("/create")
	public ResponseEntity<Main> createMain(@RequestBody Main main) {
		return new ResponseEntity<Main>(this.service.create(main), HttpStatus.CREATED);
	}
	
	//Read All
	@GetMapping("/readAll")
	public ResponseEntity<List<Main>> readAllMain() {
		return new ResponseEntity<List<Main>>(this.service.getAll(), HttpStatus.OK);
	}
	
	
	//Read By Id
	@GetMapping("/readById/{id}")
	public ResponseEntity<Main>getById(@PathVariable long id) {
//		Optional<Main> optionalMain = this.service.readById(id);
//		if(optionalMain.isPresent()) {
			return new ResponseEntity<Main>(this.service.getById(id), HttpStatus.OK);
		}
//	}	return nullHttpStatus.NOT_FOUND
	
	
	//Update
	@PutMapping("/update/{id}")
	public ResponseEntity<Main> updateMain(@PathVariable long id, @RequestBody Main main) {
//		Optional<Main> optionalMain = this.service.readById(id);
//		if(optionalMain.isPresent()) {
			return new ResponseEntity<Main>(this.service.update(id, main), HttpStatus.ACCEPTED);
		}
//		return HttpStatus.NOT_FOUND	
//	}
	
	//Delete
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> deleteMain(@PathVariable long id) {
		return (this.service.delete(id)) ? new ResponseEntity<Boolean>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}

}
