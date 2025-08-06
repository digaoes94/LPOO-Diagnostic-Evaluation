package collections;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;

public class MedicalHistoric {
	private ArrayList<HistoricEntry> records;
	
	
	class HistoricEntry() {
		private String doctorName, description;
		private LocalDateTime entryDate;
		
		public HistoricEntry(String doctorName, String description) {
			this.doctorName = doctorName;
			this.description = description;
			this.entryDate = LocalDateTime.now(ZoneId.systemDefault());
		}
	}
}