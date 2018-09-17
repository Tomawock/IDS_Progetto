package versione_1;

import java.util.GregorianCalendar;

public class Fruitore {

	private Utente utente;
	
	private GregorianCalendar data_iscrizione;
	private GregorianCalendar data_fine_iscrizione;
	private GregorianCalendar data_rinnovo_iscrizione;
	
	public Fruitore(Utente utente) {
		this.utente=utente;
		
	}
}
