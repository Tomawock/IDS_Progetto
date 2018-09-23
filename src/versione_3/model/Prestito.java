package versione_3.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import utilita.Costanti;

public class Prestito implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6L;
	
	private Risorsa risorsa;
	private Fruitore fruitore;
	
	private LocalDateTime data_inizio_prestito;
	private LocalDateTime data_fine_prestito;
	private LocalDateTime data_proroga_prestito;
	
	private LocalDateTime data_inizio_proroga;
	
	private boolean mai_progato;

	public Prestito(Risorsa risorsa, Fruitore fruitore) {
		this.risorsa = risorsa;
		this.fruitore = fruitore;
		this.data_inizio_prestito=LocalDateTime.now();
		this.data_fine_prestito=this.data_inizio_prestito.plusDays(Costanti.DURATA_PRESTITO);
		this.data_proroga_prestito=this.data_fine_prestito.minusDays(Costanti.RICHIESTA_PROROGA);
		this.mai_progato=true;
	}

	public Risorsa getRisorsa() {
		return risorsa;
	}

	public Fruitore getFruitore() {
		return fruitore;
	}

	public LocalDateTime getData_inizio_prestito() {
		return data_inizio_prestito;
	}

	public LocalDateTime getData_fine_prestito() {
		return data_fine_prestito;
	}

	public LocalDateTime getData_proroga_prestito() {
		return data_proroga_prestito;
	}

	public boolean isMai_progato() {
		return mai_progato;
	}
	
	public boolean is_rinnovabile() {
		if(LocalDateTime.now().isAfter(data_proroga_prestito) && this.mai_progato) {
			return true;
		}
		return false;
	}
	
	public void rinnova() {
		this.mai_progato=false;
		this.data_inizio_proroga=LocalDateTime.now();
		this.data_fine_prestito=this.data_inizio_proroga.plusDays(Costanti.DURATA_PROROGA);
	}
}
