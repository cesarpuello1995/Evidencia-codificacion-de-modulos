package com.oeste.evaluacion.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oeste.evaluacion.entity.Identification;
import com.oeste.evaluacion.repository.IdentificationRepository;

@Service
public class IdentificationServiceImpl implements IdentificationService {

	@Autowired
	private IdentificationRepository identificationRepository;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Identification> findAll() {
		return identificationRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Identification> findAll(Pageable pageable) {
		return identificationRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Identification> findById(Long id) {
		return identificationRepository.findById(id);
	}

	@Override
	@Transactional
	public Identification save(Identification identification) {
		return identificationRepository.save(identification);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		identificationRepository.deleteById(id);
	}

}
