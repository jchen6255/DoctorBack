package com.springboot.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;


@Entity
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int appointmentId;
	
	@NotNull
	private LocalDate date;
	@NotNull
	private String time;
	
	@NotNull
	private int doctorid;
	
	public String getDoctorName() {
		return doctorName;
	}



	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}



	public String getPatientName() {
		return patientName;
	}



	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}



	private int patientid;

	@NotNull
	private String doctorName;
	
	private String patientName;
	
	public Appointment(){};
	


	public Appointment(LocalDate date, String time, int doctorid) {
		this.date = date;
		this.time = time;
		this.doctorid = doctorid;
	}



	public int getAppointmentId() {
		return appointmentId;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}



	public int getDoctorid() {
		return doctorid;
	}



	public void setDoctorid(int doctorid) {
		this.doctorid = doctorid;
	}



	public int getPatientid() {
		return patientid;
	}



	public void setPatientid(int patientid) {
		this.patientid = patientid;
	}
	
	
	
	
}
