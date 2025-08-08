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
		
		while(x != 4) {
			VetPaciente vet = new VetPaciente();
			DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
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
		HistoricoMedico exemplo = new HistoricoMedico();
		Paciente pacExemplo = new Paciente("rodrigo", "00000000000", LocalDate.parse("24/04/1994", dateFormat)); // paciente instanciado para fim de testes
		vet.insere(pacExemplo);
		
		System.out.print("Informe o CPF do paciente para verificação de ficha antiga: ");
		String cpf = scan.nextLine();
		int vetPesquisa = vet.pesquisa(cpf);
		
		if(vetPesquisa == -1) {
			System.out.println("Paciente já possui cadastro.");
			System.out.println();
		}
		else {
			System.out.print("Você pode fornecer o histórico médico do(a) paciente? Digite S para SIM ou N para NÃO: ");
			Character opcao = scan.nextLine().toLowerCase().charAt(0);
			
			if(opcao != 's' && opcao != 'n') {
				while(opcao != 's' && opcao != 'n') {
					System.out.print("Entrada inválida, informe uma opção válida, digite S para SIM ou N para NÃO:");
					opcao = scan.nextLine().toLowerCase().charAt(0);
				}
			}
			
			if(opcao == 'n') {
				System.out.print("Nome do(a) paciente: ");
				String nome = scan.nextLine();
				
				System.out.print("Data de nascimento do(a) paciente no formato DIA/MÊS/ANO: ");
				LocalDate nascimento = LocalDate.parse(scan.nextLine(), dateFormat);
				
				vet.insere(new Paciente(nome, cpf, nascimento));
			}
			else {
				System.out.print("Nome do(a) paciente: ");
				String nome = scan.nextLine();
				
				System.out.print("Data de nascimento do(a) paciente no formato DIA/MÊS/ANO: ");
				LocalDate nascimento = LocalDate.parse(scan.nextLine(), dateFormat);
				
				System.out.println("Cópia do histórico médico do(a) paciente: ");
				// aqui a pessoa provavelmente teria de enviar por email ou entregar o histórico em papel mesmo,
				// por isso isntanciei o objeto "exemplo" lá em cima
				
				vet.insere(new Paciente(nome, cpf, nascimento, exemplo));
			}
		}
		
		return vet;
	}
	//---------------------------------------------------------------------------------------------------------------------------------------------------------------------
	private static void consultar(String cpf, VetPaciente vet) {
		Object aux = vet.pesquisa(cpf);
		
		if((int)aux == -1) {
			System.out.println("Paciente não cadastrado.");
		}
		else {
			System.out.println(((Paciente)aux).toString());
		}
	}
	//---------------------------------------------------------------------------------------------------------------------------------------------------------------------
	private static void imprimirCadastro(VetPaciente vet) {
		for(Paciente x : vet.getPacientes()) {
			System.out.println(String.format("Paciente: %s. CPF: %s", x.getNome(), x.getCpf()));
		}
	}
}