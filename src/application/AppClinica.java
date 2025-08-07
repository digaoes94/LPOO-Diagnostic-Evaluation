package application;

import java.util.Scanner;

public class AppClinica {
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		int x = 0;
		
		while(x != 4) {
			x = basicMenu(scan);
			
			switch(x) {
			case 1:
				
				break;
			case 2:

				break;
			case 3:

				break;
			case 4:
				System.out.println("Obrigado por usar nossos serviços! Encerrando AppClinica.");
				x = 4;
				break;
			default: 
				System.out.println("Entrada inválida, informe uma opção válida.");
				x = basicMenu(scan);
				break;
			}
		}
		
		
	}

	private static int basicMenu(Scanner scan) {
		System.out.println("Bem-vindo(a) ao AppClinica! Selecione uma ação:");
		System.out.println("1. Cadastrar");
		System.out.println("2. Consultar");
		System.out.println("3. Imprimir cadastros");
		System.out.println("4. Fechar AppClinica");
		System.out.println();
		return scan.nextInt();
	}

}
