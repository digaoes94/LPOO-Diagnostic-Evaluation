package registers;

import entities.Paciente;

public class VetPaciente {
	private Paciente[] pacientes;
	private int quant;
	
	public VetPaciente() {
		this.pacientes = new Paciente[100];
		this.quant = 0;
	}

	public Paciente getPaciente(int a) {
		return pacientes[a];
	}
	
	public int getQuant() {
		return this.quant;
	}
	
	public Paciente[] getPacientes() {
		return pacientes;
	}

	public int insere(Paciente pac) {
		if(quant == 100) {
			return -1;
		}
		else if(pesquisa(pac.getCpf()) != -1) {
			return -2;
		}
		else {
			pacientes[quant] = pac;
			quant++;
			return 0;
		}
	}
	
	public int pesquisa(String cpf) {
		for(int a = 0; a < quant; a++) {
			if(pacientes[a].getCpf().equals(cpf)) {
				return a;
			}
		}
		
		return -1;
	}
}