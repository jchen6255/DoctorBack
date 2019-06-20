package com.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springboot.model.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer>{

	public Doctor findByUsername(String username);
	
	//@Query(value ="SELECT * FROM Doctor where address = ?1 and speciality = ?2",nativeQuery = true)
	public List<Doctor> findByAddressAndSpeciality(String address, String speciality);
	
	
}
