package com.oeste.evaluacion.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.oeste.evaluacion.entity.Identification;

public interface IdentificationService {
	public Iterable<Identification> findAll();
	
	public Page<Identification> findAll(Pageable pageable);
	
	public Optional<Identification> findById(Long id);
	
	public Identification save(Identification identification);
	
	public void deleteById(Long id);
}
