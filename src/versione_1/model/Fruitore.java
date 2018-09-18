package versione_1.model;


import java.time.LocalDateTime;

import utilita.Costanti;
import versione_1.controller.Controller;

public class Fruitore {

	private Utente utente;
	
	private LocalDateTime data_iscrizione;
	private LocalDateTime data_fine_iscrizione;
	private LocalDateTime data_rinnovo_iscrizione;
	
	
	
	//viene creato un nuovo fruitore con tutti i dati dell'utente in piu' :
	//la data d'iscrizione = data attuale
	//data fine iscrizione e' tra 5 anni, (considerando anche l'ora e i minuti)
	//data rinnovo iscrizione e' = data fine iscrizione - 10 giorni prima della scadenza (costante)
	public Fruitore(Utente utente) {
		this.utente=utente;
		this.data_iscrizione = LocalDateTime.now();
		this.data_fine_iscrizione = LocalDateTime.of(data_iscrizione.getYear() + Costanti.SCADENZA_TERMINE_FRUITORE, data_iscrizione.getMonth(),
				data_iscrizione.getDayOfMonth(), data_iscrizione.getHour(), data_iscrizione.getMinute()); 	
		this.data_rinnovo_iscrizione = this.data_fine_iscrizione.minusDays(Costanti.GIORNI_RINNOVO_ISCRIZIONE);	
	}
	

	public Utente getUtente() {
		return utente;
	}

	public LocalDateTime getData_iscrizione() {
		return data_iscrizione;
	}

	public void setData_iscrizione(LocalDateTime data_iscrizione) {
		this.data_iscrizione = data_iscrizione;
	}

	public LocalDateTime getData_fine_iscrizione() {
		return data_fine_iscrizione;
	}

	public void setData_fine_iscrizione(LocalDateTime data_fine_iscrizione) {
		this.data_fine_iscrizione = data_fine_iscrizione;
	}

	public LocalDateTime getData_rinnovo_iscrizione() {
		return data_rinnovo_iscrizione;
	}

	public void setData_rinnovo_iscrizione(LocalDateTime data_rinnovo_iscrizione) {
		this.data_rinnovo_iscrizione = data_rinnovo_iscrizione;
	}

	@Override
	public String toString() {
		return "Fruitore [utente=" + utente.toString() + ", data_iscrizione=" + data_iscrizione + ", data_fine_iscrizione="
				+ data_fine_iscrizione + ", data_rinnovo_iscrizione=" + data_rinnovo_iscrizione + "]";
	}
	
	
	public static void main(String[] args) {
		String nome = "NomeTest";
		String cognome = "COgnomeTest";
		String mail = "MAILTEST";
		LocalDateTime data_di_nascita = LocalDateTime.now();
		String c_f = "CODICEFISCALETEST";
		String username = "USERNAMETEST";
		String password = "PASSWORDTEST";
		
		Utente u = new Utente(nome,cognome,mail,data_di_nascita,c_f,username,password);
		Fruitore f = new Fruitore(u);
		System.out.print(f.toString());	
		
	}
	
	
}
