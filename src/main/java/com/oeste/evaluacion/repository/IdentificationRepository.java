package com.oeste.evaluacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oeste.evaluacion.entity.Identification;

@Repository
public interface IdentificationRepository extends JpaRepository<Identification, Long> {
	

}
