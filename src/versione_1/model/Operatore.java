package versione_1.model;

import java.util.ArrayList;

public class Operatore {

	private Utente utente;
	
	public Operatore(Utente utente) {
		this.utente=utente;
		
	}
	
	public Utente getUtente() {
		return utente;
	}
	
	public ArrayList<Fruitore> visualizza_fruitori(){
		return new ArrayList<>();
	}
}
