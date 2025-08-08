package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import registers.HistoricoMedico;

public class Paciente {
	private String nome, cpf;
	private LocalDate nascimento;
	private DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private HistoricoMedico historico;
	
	public Paciente() {}
	
	// constructor for people without medical historic, such as newborn babies
	public Paciente(String nome, String cpf, LocalDate nascimento) {
		this.nome = nome;
		this.cpf = cpf;
		this.nascimento = nascimento;
	}

	public Paciente(String nome, String cpf, LocalDate nascimento, HistoricoMedico historico) {
		this.nome = nome;
		this.cpf = cpf;
		this.nascimento = nascimento;
		this.historico = historico;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public HistoricoMedico getHistorico() {
		return historico;
	}
	public void setHistorico(HistoricoMedico historico) {
		this.historico = historico;
	}

	public String getCpf() {
		return cpf;
	}

	public LocalDate getNascimento() {
		return nascimento;
	}

	@Override
	public String toString() {
		String message = "";
		message += String.format("Nome do(a) paciente: %s. CPF: %s. Nascimento: %s.\n", nome, cpf, nascimento.format(dateFormat));
		message += this.historico.toString();
		return message;
	}
}