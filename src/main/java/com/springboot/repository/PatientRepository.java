package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer>{
	
	public Patient findByUsername(String username);

}
