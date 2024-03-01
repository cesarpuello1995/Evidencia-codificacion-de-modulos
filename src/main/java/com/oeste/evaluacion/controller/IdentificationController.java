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

import com.oeste.evaluacion.entity.Identification;
import com.oeste.evaluacion.service.IdentificationService;

@RestController
@RequestMapping("/api/identifications")
public class IdentificationController {
	
	@Autowired
	private IdentificationService identificationService;
	
	// Create a new identification
	@PostMapping
	public ResponseEntity<?> create (@RequestBody Identification identification) {
		if (identification.getIdentificationName() != null && identification.getDescription() != null) {
			Identification newIdentification = new Identification(identification.getIdentificationName(), identification.getDescription());
			return ResponseEntity.status(HttpStatus.CREATED).body(identificationService.save(newIdentification));
		}
		
		return ResponseEntity.badRequest().build();
	}
	
	//Read a identification
	@GetMapping("/{id}")
	public ResponseEntity<?> read (@PathVariable(value = "id") Long identificationId){
		Optional<Identification> oIdentification = identificationService.findById(identificationId);
		
		if (!oIdentification.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(oIdentification);
	}
	
	// Update a identification
	@PutMapping("/{id}")
	public ResponseEntity<?> update (@RequestBody Identification identificationDetails, @PathVariable(value="id") Long identificationId){
		Optional<Identification> oIdentification = identificationService.findById(identificationId);
		
		if (!oIdentification.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		oIdentification.get().setIdentificationName(identificationDetails.getIdentificationName() == null ? oIdentification.get().getIdentificationName() : identificationDetails.getIdentificationName());
		oIdentification.get().setDescription(identificationDetails.getDescription() == null ? oIdentification.get().getDescription() : identificationDetails.getDescription());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(identificationService.save(oIdentification.get()));
	}
	
	// Logical delete a identification
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteLogical (@PathVariable(value = "id") Long identificationId) {
		Optional<Identification> oIdentification = identificationService.findById(identificationId);
		if (!oIdentification.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		oIdentification.get().setEnabled(false);
		identificationService.save(oIdentification.get());
		return ResponseEntity.ok().build();
	}
	
	// Read identifications
	@GetMapping
	public List<Identification> readAll () {
		return StreamSupport
				.stream(identificationService.findAll().spliterator(), false)
				.collect(Collectors.toList());
	}
	
}
