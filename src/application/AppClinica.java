package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import entities.Paciente;
import registers.HistoricoMedico;
import registers.VetPaciente;

public class AppClinica {
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		int x = 0;
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		VetPaciente vet = new VetPaciente();
		Paciente pacExemplo = new Paciente("rodrigo", "00000000000", LocalDate.parse("24/04/1994", dateFormat)); // paciente instanciado para fim de testes
		vet.insere(pacExemplo);
		
		while(x != 4) {
			x = basicMenu(scan);
			
			switch(x) {
			case 1:
				vet = cadastrar(vet, dateFormat);
				break;
			case 2:
				System.out.print("Informar CPF para consulta: ");
				String cpf = scan.nextLine();
				consultar(cpf, vet);
				break;
			case 3:
				imprimirCadastro(vet);
				break;
			case 4:
				System.out.println("Obrigado por usar nossos serviços! Encerrando AppClinica.");
				x = 4;
				break;
			default: 
				while(x < 1 || x > 4) {
					System.out.print("Entrada inválida, informe uma opção válida: ");
					x = basicMenu(scan);
				}
				break;
			}
		}
	}

	//---------------------------------------------------------------------------------------------------------------------------------------------------------------------
	private static int basicMenu(Scanner scan) {
		int opcao;
		System.out.println("Bem-vindo(a) ao AppClinica! Selecione uma ação:");
		System.out.println("1. Cadastrar");
		System.out.println("2. Consultar");
		System.out.println("3. Imprimir cadastros");
		System.out.println("4. Fechar AppClinica");
		System.out.println();
		opcao = scan.nextInt();
		scan.nextLine();
		return opcao;
	}
	//---------------------------------------------------------------------------------------------------------------------------------------------------------------------
	private static VetPaciente cadastrar(VetPaciente vet, DateTimeFormatter dateFormat) {
		int aux;
		System.out.print("Informe nome do(a) paciente: ");
		String nome = scan.nextLine();
		
		System.out.print("Informe CPF do(a) paciente: ");
		String cpf = scan.nextLine();
		
		System.out.print("Informe data de nascimento do(a) paciente no formato DD/MM/AAAA: ");
		LocalDate nascimento = LocalDate.parse(scan.nextLine(), dateFormat);
		
		System.out.print("Pode fornecer o histórico médico do(a) paciente? Digite S para SIM ou N para NÃO: ");
		char opcao = scan.nextLine().toLowerCase().charAt(0);
		System.out.println();
		
		if(opcao == 's') {
			HistoricoMedico exemplo = new HistoricoMedico();
			Paciente pac = new Paciente(nome, cpf, nascimento, exemplo);
			aux = vet.insere(pac);
		}
		else {
			Paciente pac = new Paciente(nome, cpf, nascimento);
			aux = vet.insere(pac);
		}
		
		if(aux == -1) {
			System.out.println("Lista de pacientes cheia, impossível adicionar o(a) paciente.");
		}
		else if(aux == -2) {
			System.out.println("O(A) paciente já constava na lista.");
		}
		else if(aux == 0) {
			System.out.println("O(A) paciente adicionado com sucesso.");
		}
		else {
			System.out.println("Erro inesperado, favor contatar o TI.");
		}
		System.out.println();
		
		return vet;
	}
	//---------------------------------------------------------------------------------------------------------------------------------------------------------------------
	private static void consultar(String cpf, VetPaciente vet) {
		int aux = vet.pesquisa(cpf);
		
		if(aux == -1) {
			System.out.println("Paciente não cadastrado.");
		}
		else {
			System.out.println(vet.getPaciente(aux).toString());
		}
	}
	//---------------------------------------------------------------------------------------------------------------------------------------------------------------------
	private static void imprimirCadastro(VetPaciente vet) {
		for(int a = 0; a < vet.getQuant(); a++) {
			System.out.println(String.format("Paciente: %s. CPF: %s.", vet.getPaciente(a).getNome(), vet.getPaciente(a).getCpf()));
		}
		System.out.println();
	}
}