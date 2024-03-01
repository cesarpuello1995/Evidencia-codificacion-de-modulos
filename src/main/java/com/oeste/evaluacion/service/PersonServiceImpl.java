package com.oeste.evaluacion.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oeste.evaluacion.entity.Person;
import com.oeste.evaluacion.repository.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepository personRepository;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Person> findAll() {
		return personRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Person> findAll(Pageable pageable) {
		return personRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Person> findById(Long id) {
		return personRepository.findById(id);
	}

	@Override
	@Transactional
	public Person save(Person person) {
		return personRepository.save(person);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		personRepository.deleteById(id);
	}

}
