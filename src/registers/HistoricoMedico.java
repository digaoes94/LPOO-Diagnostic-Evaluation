package registers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HistoricoMedico {
	private DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private EntradaMedica[] entradas = new EntradaMedica[1000];
	private int quant;
	
	public HistoricoMedico() {}
	
	public HistoricoMedico(EntradaMedica[] entradas) {
		this.entradas = entradas;
	}

	public String insere(String nomeMedico, LocalDate dataEntrada, String descricao) {
		if(quant == 1000) {
			return "Histórico completo, favor iniciar novo histórico.";
		}
		else {
			entradas[quant] = new EntradaMedica(nomeMedico, dataEntrada, descricao);
			quant++;
			return "Histórico atualizado.";
		}
	}
	
	@Override
	public String toString() {
		String aux = "";
		
		for(EntradaMedica x : entradas) {
			aux += String.format("Data de ocorrido: %s. Médico: %s. Descrição: %s.\n", x.dataEntrada.format(dateFormat), x.nomeMedico, x.descricao);
		}
		
		return aux;
	}
	
	
	
	//-------------------------------------------------------------------------------------------------------
	class EntradaMedica {
		private String nomeMedico;
		private LocalDate dataEntrada;
		private String descricao;
		
		public EntradaMedica() {}
		
		public EntradaMedica(String nomeMedico, LocalDate dataEntrada, String descricao) {
			this.nomeMedico = nomeMedico;
			this.dataEntrada = dataEntrada;
			this.descricao = descricao;
		}
	}
	//-------------------------------------------------------------------------------------------------------
}
