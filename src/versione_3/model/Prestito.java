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
	private LocalDateTime data_proroga_prestito; //data in cui è possibile prorogare il prestito
	
	private LocalDateTime data_inizio_proroga;
	
	private boolean mai_prorogato;


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

	public boolean rinnova() {
		if(this.data_proroga_prestito.isBefore(LocalDateTime.now()) && this.mai_prorogato) {
			this.mai_prorogato=false;
			this.data_inizio_proroga=LocalDateTime.now();
			this.data_fine_prestito=this.data_inizio_proroga.plusDays(Costanti.DURATA_PROROGA);
			return true;
		}
		return false;
	}

	public void reset_dati(Prestito prestito) {
		this.data_fine_prestito=prestito.getData_fine_prestito();
		this.data_inizio_prestito=prestito.getData_inizio_prestito();
		this.data_inizio_proroga=prestito.getData_inizio_proroga();
		this.data_proroga_prestito=prestito.getData_proroga_prestito();
		this.fruitore=prestito.getFruitore();
		this.mai_prorogato=prestito.isMai_prorogato();
		this.risorsa=prestito.getRisorsa();
	}
	
	public boolean is_terminato() {
		if(this.data_fine_prestito.isBefore(LocalDateTime.now())) {
			return true;
		}
		return false;
	}
}
