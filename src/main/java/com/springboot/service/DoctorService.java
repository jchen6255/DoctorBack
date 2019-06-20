package com.springboot.service;

import java.util.List;

import com.springboot.model.Doctor;

public interface DoctorService {
	
	
	public List<Doctor> getDoctors();
	
	public Doctor getDoctor(String username);
	
	public void deleteDoctor(int id);
	
	public void insertDoctor(Doctor doctor);
	
	public void updateDoctor(Doctor doctor);
	
	public List<Doctor> searchDoctors(String location, String speciality);
	
	

}
