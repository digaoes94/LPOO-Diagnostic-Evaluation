package entities;

import java.time.LocalDateTime;

import collections.MedicalHistoric;

public class Patient {
	private String name, cpf;
	private LocalDateTime birthday;
	private MedicalHistoric historic;
	
	public Patient() {}
	
	// constructor who doesn't receives medical historic for cases such, as example, a newborn being tended for the first time
	public Patient(String name, String cpf, LocalDateTime birthday) {
		this.name = name;
		this.cpf = cpf;
		this.birthday = birthday;
		this.historic = new MedicalHistoric();
	}
	
	// constructor for someone who already has a medical historic so the medic may update it
	public Patient(String name, String cpf, LocalDateTime birthday, MedicalHistoric historic) {
		this.name = name;
		this.cpf = cpf;
		this.birthday = birthday;
		this.historic = historic;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public LocalDateTime getBirthday() {
		return birthday;
	}

	public MedicalHistoric getHistoric() {
		return historic;
	}
	public void setHistoric(MedicalHistoric historic) {
		this.historic = historic;
	}
	
	
}