package versione_3.model;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import utilita.Costanti;
import java.io.Serializable;

public class Fruitore implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;

	private Utente utente;
	
	private LocalDateTime data_iscrizione;
	private LocalDateTime data_fine_iscrizione;
	private LocalDateTime data_rinnovo_iscrizione;
	
	private boolean valido;
	private boolean rinnovabile;
	
	
	
	//viene creato un nuovo fruitore con tutti i dati dell'utente in piu' :
	//la data d'iscrizione = data attuale
	//data fine iscrizione e' tra 5 anni, (considerando anche l'ora e i minuti)
	//data rinnovo iscrizione e' = data fine iscrizione - 10 giorni prima della scadenza (costante)
	public Fruitore(Utente utente) {
		this.rinnovabile=false;
		this.valido=false;
		this.utente=utente;
				
		this.rinnova_iscrizione();	
		
	}
	
	public int get_giorni_scadenza() {
		if(!this.rinnovabile) {
			return -1;//caso in cui non sei nel periodo di rinnovabilità
		}else {
			return (int)LocalDateTime.now().until(data_fine_iscrizione, ChronoUnit.DAYS);
		}
	}
	
	public void controllo_validia() {
		if (this.data_fine_iscrizione.isAfter(LocalDateTime.now())) {
			this.valido=true;
			if (this.data_rinnovo_iscrizione.isBefore(LocalDateTime.now())) {
				this.rinnovabile=true;
			}else {
				this.rinnovabile=false;
			}
		}else {
			this.valido=false;
			this.rinnovabile=false;
		}
		//System.out.println("RINNOVABILE_CICLO::"+this.rinnovabile);
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
		return ("Fruitore = " +utente.toString() + 
				", Data Iscrizione: "  + data_iscrizione.getDayOfMonth()+"/"+data_iscrizione.getMonth().getValue() +"/"+ data_iscrizione.getYear()+ 
				", Data di Fine Iscrizione: "+ data_fine_iscrizione.getDayOfMonth()+"/"+data_fine_iscrizione.getMonth().getValue()+"/"+data_fine_iscrizione.getYear()+
				", Data di Rinnovo Iscrizione: " + data_rinnovo_iscrizione.getDayOfMonth()+"/"+data_rinnovo_iscrizione.getMonth().getValue()+"/"+data_rinnovo_iscrizione.getYear());
	}
		
	public boolean is_valido() {
		this.controllo_validia();
		return valido;
	}

	public boolean is_rinnovabile() {
		this.controllo_validia();
		return rinnovabile;
	}

	
	@Override
	public boolean equals(Object obj) {
		Fruitore f=(Fruitore) obj;
		if(this.getUtente().getUsername().equals(f.getUtente().getUsername()))
		{
			return true;
		}else
			return false;
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

	public void rinnova_iscrizione() {
		
		this.data_iscrizione = LocalDateTime.now();
		this.data_fine_iscrizione = LocalDateTime.of(data_iscrizione.getYear()+Costanti.SCADENZA_TERMINE_FRUITORE,
				data_iscrizione.getMonth(),
				data_iscrizione.getDayOfMonth(), 
				data_iscrizione.getHour(), 
				data_iscrizione.getMinute()); 	
		
		this.data_rinnovo_iscrizione = 	data_fine_iscrizione.minusDays(Costanti.GIORNI_RINNOVO_ISCRIZIONE);
		
		this.controllo_validia();
	}
	
	
}
