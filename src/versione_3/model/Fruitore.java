package versione_3.model;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import utilita.Costanti;
import java.io.Serializable;

public class Fruitore implements Serializable{

	/**
	 * Numero seriale per la serializzazione dei dati su File
	 */
	private static final long serialVersionUID = 2L;

	private Utente utente;
	
	private LocalDateTime data_iscrizione;
	private LocalDateTime data_fine_iscrizione;
	private LocalDateTime data_rinnovo_iscrizione;
	
	private boolean valido;
	private boolean rinnovabile;
	
	
	/**
	 * Viene creato un nuovo fruitore con tutti i dati dell'utente
	 * vengono inoltre settate le date di iscrizione, fine iscrizione e di rinnovo,
	 * vengono impostate le variabili di validità e rinnovabilità in base alla data di iscrizione
	 * 
	 * @param utente	Utente che diventa Fruitore
	 */
	public Fruitore(Utente utente) {
		this.rinnovabile=false;
		this.valido=false;
		this.utente=utente;
				
		this.rinnova_iscrizione();	
		
	}
	
	/**
	 * Restituisce i giorni che mancano alla scadenza dell'iscrizione
	 * 
	 * @return 	il numero di giorni mancanti alla data di scadenza o 
	 * 			-1 nel caso in cui il fruitore non possa ancora rinnovare la sua iscizione
	 */
	public int get_giorni_scadenza() {
		if(!this.rinnovabile) {
			return -1;//caso in cui non sei nel periodo di rinnovabilità
		}else {
			return (int)LocalDateTime.now().until(data_fine_iscrizione, ChronoUnit.DAYS);
		}
	}
	
	/**
	 * Funzione che controlla la validità e la rinnovabilità di un fruitore
	 * e aggiorna le variabili di controllo di validità e rinnovabilità
	 */
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
	
	/**
	 * Controlla che il fruitore sia valido e ne restituisce il valore
	 * 	
	 * @return true se è valido false altrimenti
	 */
	public boolean is_valido() {
		this.controllo_validia();
		return valido;
	}

	/**
	 * Controlla che il fruitore sia rinnovabile e ne restituisce il valore
	 * 	
	 * @return true se è rinnovabile false altrimenti
	 */
	public boolean is_rinnovabile() {
		this.controllo_validia();
		return rinnovabile;
	}

	/**
	 * Due fruitori sono ugali quando hanno lo stesso username 
	 * il quale è legato all'utente con cui sono stati creati
	 */
	@Override
	public boolean equals(Object obj) {
		Fruitore f=(Fruitore) obj;
		if(this.getUtente().getUsername().equals(f.getUtente().getUsername()))
		{
			return true;
		}else
			return false;
	}
	/**
	 * Funzione che aggiorna la data di iscrizione,di fine iscrizione e di rinnovo 
	 * 		la data di iscrizione è quella odierna 
	 * 		la data di fine iscrizione è quella odierna piu una costante definita a priori
	 * 		la data di rinnovo è quella di fine iscrizione meno una costante definita a priori
	 * 
	 * NON EFFETTA CONTROLLI SUL FATTO CHE UN FRUITORE SIA RINNOVABILE
	 * 
	 */
	public void rinnova_iscrizione() {
		
		this.data_iscrizione = LocalDateTime.now();
		this.data_fine_iscrizione = this.data_iscrizione.plusYears(Costanti.SCADENZA_TERMINE_FRUITORE);
		
		this.data_rinnovo_iscrizione = 	data_fine_iscrizione.minusDays(Costanti.GIORNI_RINNOVO_ISCRIZIONE);
		
		this.controllo_validia();
	}
	
	
}
