package versione_1.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Operatore implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3L;
	private Utente utente;
	
	public Operatore(Utente utente) {
		this.utente=utente;
		
	}
	
	public Utente getUtente() {
		return utente;
	}
	
	public ArrayList<Fruitore> visualizza_fruitori(){
		//TODO
		return new ArrayList<>();
	}
}
