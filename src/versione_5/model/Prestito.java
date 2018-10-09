package versione_5.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import utilita.Costanti;

public class Prestito implements Serializable {
	
	/**
	 * Numero seriale per la serializzazione dei dati su File
	 */
	private static final long serialVersionUID = 6L;
	
	private Risorsa risorsa;
	private Fruitore fruitore;
	
	private LocalDateTime data_inizio_prestito;
	private LocalDateTime data_fine_prestito;
	private LocalDateTime data_proroga_prestito; 	//data in cui è possibile prorogare il prestito
	
	private LocalDateTime data_inizio_proroga;		//data nella quale è iniziata la proroga
	
	private boolean mai_prorogato;

	/**
	 * Creo un nuovo prestito che lega una Risorsa e un Fruitore presi in ingresso
	 * setto la data di inizio del prestito, di fine e la data dalla quale è possibile rinnovarlo
	 * 
	 * @param risorsa	Risorsa da associare al prestito
	 * @param fruitore	Fruitore da associare con il prestito
	 */
	public Prestito(Risorsa risorsa, Fruitore fruitore) {
		this.risorsa = risorsa;
		this.fruitore = fruitore;
		this.data_inizio_prestito=LocalDateTime.now();
		this.data_fine_prestito=this.data_inizio_prestito.plusDays(Costanti.DURATA_PRESTITO);
		this.data_proroga_prestito=this.data_fine_prestito.minusDays(Costanti.RICHIESTA_PROROGA);
		this.mai_prorogato=true;
	}
	
	
	public Risorsa getRisorsa() {
		return risorsa;
	}


	public void setRisorsa(Risorsa risorsa) {
		this.risorsa = risorsa;
	}


	public Fruitore getFruitore() {
		return fruitore;
	}


	public void setFruitore(Fruitore fruitore) {
		this.fruitore = fruitore;
	}


	public LocalDateTime getData_inizio_prestito() {
		return data_inizio_prestito;
	}


	public void setData_inizio_prestito(LocalDateTime data_inizio_prestito) {
		this.data_inizio_prestito = data_inizio_prestito;
	}


	public LocalDateTime getData_fine_prestito() {
		return data_fine_prestito;
	}


	public void setData_fine_prestito(LocalDateTime data_fine_prestito) {
		this.data_fine_prestito = data_fine_prestito;
	}


	public LocalDateTime getData_proroga_prestito() {
		return data_proroga_prestito;
	}


	public void setData_proroga_prestito(LocalDateTime data_proroga_prestito) {
		this.data_proroga_prestito = data_proroga_prestito;
	}


	public LocalDateTime getData_inizio_proroga() {
		return data_inizio_proroga;
	}


	public void setData_inizio_proroga(LocalDateTime data_inizio_proroga) {
		this.data_inizio_proroga = data_inizio_proroga;
	}


	public boolean isMai_prorogato() {
		return mai_prorogato;
	}


	public void setMai_prorogato(boolean mai_progato) {
		this.mai_prorogato = mai_progato;
	}

	/**
	 * Due Prestiti sono uguali quando hanno la stessa data di inizio del prestito 
	 * NB la data è espressa anche in minuti e centesimi di secondo ed è percio univoca
	 */
	@Override
	public boolean equals(Object obj) {
		Prestito prestito=(Prestito)obj;
		if(this.data_inizio_prestito.equals(prestito.getData_inizio_prestito())
				&& this.fruitore.equals(prestito.getFruitore())
				&& this.risorsa.equals(prestito.getRisorsa())) {
			return true;
		}
		return false;
	}

	/**
	 * Nel caso in cui la data dalla quale è possibile prorogare il prestito
	 * sia passata e il prestito non sia mai stato rinnovato aggiorna la data di scdenza del prestito e 
	 * setta la data di inizio della proroga
	 * 
	 * @return 	true se è stato rinnovato(Le condizioni devo essere vere) false altrimenti
	 */
	public boolean rinnova() {
		if(this.data_proroga_prestito.isBefore(LocalDateTime.now()) && this.mai_prorogato) {
			this.mai_prorogato=false;
			this.data_inizio_proroga=LocalDateTime.now();
			this.data_fine_prestito=this.data_inizio_proroga.plusDays(Costanti.DURATA_PROROGA);
			return true;
		}
		return false;
	}
	
	/**
	 * Preso un prestito in ingresso resetta i dati di quello ch einvoca la 
	 * funzione con i dati del prestitp passato in ingresso
	 * 
	 * @param prestito	Prestito dal quale copiare i dati
	 */
	public void reset_dati(Prestito prestito) {
		this.data_fine_prestito=prestito.getData_fine_prestito();
		this.data_inizio_prestito=prestito.getData_inizio_prestito();
		this.data_inizio_proroga=prestito.getData_inizio_proroga();
		this.data_proroga_prestito=prestito.getData_proroga_prestito();
		this.fruitore=prestito.getFruitore();
		this.mai_prorogato=prestito.isMai_prorogato();
		this.risorsa=prestito.getRisorsa();
	}
	
	/**
	 * Controlla che un prestito non sia terminato
	 * 
	 * @return	true se la data di fine prestito è superiore a quella attuale false altrimenti
	 */
	public boolean is_terminato() {
		if(this.data_fine_prestito.isBefore(LocalDateTime.now())) {
			return true;
		}
		return false;
	}


	@Override
	public String toString() {
		return "Username: "+this.fruitore.getUtente().getUsername()+"\nRisorsa: "+this.risorsa.toString()+"\nData di inizio: "+this.data_inizio_prestito.toString()+"\nE' Rinnovabile? "+String.valueOf(mai_prorogato)+ "\n" ;
	}
	
	
}

