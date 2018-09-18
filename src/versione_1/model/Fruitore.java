package versione_1.model;

import java.io.Serializable;
import java.util.GregorianCalendar;

public class Fruitore implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;

	private Utente utente;
	
	private GregorianCalendar data_iscrizione;
	private GregorianCalendar data_fine_iscrizione;
	private GregorianCalendar data_rinnovo_iscrizione;
	
	
	
	
	public Fruitore(Utente utente) {
		this.utente=utente;
	}
	

	public Utente getUtente() {
		return utente;
	}

	public GregorianCalendar getData_iscrizione() {
		return data_iscrizione;
	}

	public void setData_iscrizione(GregorianCalendar data_iscrizione) {
		this.data_iscrizione = data_iscrizione;
	}

	public GregorianCalendar getData_fine_iscrizione() {
		return data_fine_iscrizione;
	}

	public void setData_fine_iscrizione(GregorianCalendar data_fine_iscrizione) {
		this.data_fine_iscrizione = data_fine_iscrizione;
	}

	public GregorianCalendar getData_rinnovo_iscrizione() {
		return data_rinnovo_iscrizione;
	}

	public void setData_rinnovo_iscrizione(GregorianCalendar data_rinnovo_iscrizione) {
		this.data_rinnovo_iscrizione = data_rinnovo_iscrizione;
	}

	@Override
	public String toString() {
		return "Fruitore [utente=" + utente.toString() + ", data_iscrizione=" + data_iscrizione + ", data_fine_iscrizione="
				+ data_fine_iscrizione + ", data_rinnovo_iscrizione=" + data_rinnovo_iscrizione + "]";
	}
	
	
	
}
