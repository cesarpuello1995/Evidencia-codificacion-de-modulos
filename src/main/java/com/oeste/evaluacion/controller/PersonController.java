package com.oeste.evaluacion.controller;

import java.util.Optional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oeste.evaluacion.entity.Person;
import com.oeste.evaluacion.service.PersonService;

@RestController
@RequestMapping("/api/people")
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	// Create a new person
	@PostMapping
	public ResponseEntity<?> create (@RequestBody Person person) {
		if (person.getName() != null && person.getAge() != null) {
			Person newPerson;
			if (person.getGender() == null) {
				newPerson = new Person(person.getName(), person.getAge());	
			} else {
				newPerson = new Person(person.getName(), person.getAge(), person.getGender());
			}
			
			return ResponseEntity.status(HttpStatus.CREATED).body(personService.save(newPerson));
		}
		
		return ResponseEntity.badRequest().build();
	}
	
	//Read a person
	@GetMapping("/{id}")
	public ResponseEntity<?> read (@PathVariable(value = "id") Long personId){
		Optional<Person> oPerson = personService.findById(personId);
		
		if (!oPerson.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(oPerson);
	}
	
	// Update a person
	@PutMapping("/{id}")
	public ResponseEntity<?> update (@RequestBody Person personDetails, @PathVariable(value="id") Long personId){
		Optional<Person> oPerson = personService.findById(personId);
		
		if (!oPerson.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		oPerson.get().setName(personDetails.getName() == null ? oPerson.get().getName() : personDetails.getName());
		oPerson.get().setAge(personDetails.getAge() == null ? oPerson.get().getAge() : personDetails.getAge());
		oPerson.get().setGender(personDetails.getGender() == null ? oPerson.get().getGender() : personDetails.getGender());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(personService.save(oPerson.get()));
	}
	
	// Logical delete a person
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteLogical (@PathVariable(value = "id") Long personId) {
		Optional<Person> oPerson = personService.findById(personId);
		if (!oPerson.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		oPerson.get().setEnabled(false);
		personService.save(oPerson.get());
		return ResponseEntity.ok().build();
	}
	
	// Read people
	@GetMapping
	public List<Person> readAll () {
		return StreamSupport
				.stream(personService.findAll().spliterator(), false)
				.collect(Collectors.toList());
	}
	
}
