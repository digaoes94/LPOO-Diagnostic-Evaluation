package collections;

import java.util.ArrayList;

import entities.Patient;

public class ArrayPatients {
	private ArrayList<Patient> patients;
	private int quant;
	
	public ArrayPatients() {
		this.patients = new ArrayList<Patient>();
		this.quant = patients.size();
	}

	public int getQuant() {
		return quant;
	}
	
	public Patient getPatient(int index) {
		if(index > patients.size()) {
			return null;
		}
		else {
			return patients.get(index);
		}
	}

	public int searchPatient(String cpf) {
		int index = 0;
		
		for(Patient a : patients) {
			if(a.getCpf() == cpf) {
				break;
			}
			index++;
		}
		
		return index;
	}
	
	
}