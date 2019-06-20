package com.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.model.Doctor;
import com.springboot.repository.DoctorRepository;

@Service
public class DoctorServiceImpl implements DoctorService{

	
	@Autowired
	DoctorRepository repo;
	
	
	@Override
	public List<Doctor> getDoctors() {
		
		return repo.findAll();
	}

	@Override
	public void deleteDoctor(int id) {
		repo.deleteById(id);
	}

	@Override
	public void insertDoctor(Doctor doctor) {
		repo.save(doctor);
		
	}

	@Override
	@Transactional()
	public void updateDoctor(Doctor doctor) {
		repo.save(doctor);
	}

	@Override
	public Doctor getDoctor(String username) {
		return repo.findByUsername(username);
	}

	@Override
	public List<Doctor> searchDoctors(String location, String speciality) {
		return repo.findByAddressAndSpeciality(location, speciality);
	}
	
	
	
}
