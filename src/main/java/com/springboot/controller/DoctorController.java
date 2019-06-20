package com.springboot.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.Appointment;
import com.springboot.model.Doctor;
import com.springboot.model.Leave;
import com.springboot.service.AppointmentService;
import com.springboot.service.DoctorService;
import com.springboot.service.LeaveService;

@RestController
@CrossOrigin("http://localhost:4200")
public class DoctorController {
	
	
	
	@Autowired
	DoctorService service;
	@Autowired
	AppointmentService appointmentService;
	@Autowired
	LeaveService leaveService;
		
	@PostMapping("/doctor/login")
	public Doctor doctorLogin(@RequestBody Doctor d) {

		
		Doctor doc = service.getDoctor(d.getUsername());
		if(doc == null) {
			System.err.println("username not found");
		} else if (!doc.getPassword().equals(d.getPassword())){
			System.err.println("password does not match");
		} else {
			return doc;
		}
		return null;
	}
	
	@PutMapping("/doctor/update")
	public void update(@RequestBody Doctor d) {
		System.out.println("enter java");
		System.out.println(d.getUsername());
		System.out.println(d.getLastName());
		service.updateDoctor(d);
		
	}
	
	@PostMapping("/doctor/createAppointment")
	public void createAppointment(@RequestBody Appointment appointment) {
		System.err.println("appointment");
		System.err.println(appointment.getDoctorName());
		appointmentService.insertAppointment(appointment);
	}
	
	@PostMapping("/doctor/getAppointment")
	public List<Appointment> getAppointment(@RequestBody Doctor d){
		
		return appointmentService.getAppointmentByDoctor(d.getId());
	}
	
	@PostMapping("/doctor/applyLeave")
	public void applyLeave(@RequestBody Leave leave) {
		
		if(leave.getEndDate().isAfter(leave.getLeaveDate()) && leave.getLeaveDate().isAfter(LocalDate.now())) {
			leave.setStatus("Pending");
			leaveService.insertLeave(leave);
		} else {
			System.err.println("Check your Dates Info");
		}
		
	}
	

	
	
	
}
