package versione_2.model;

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
	/**
	 * Legge dal database locale tutti i fruitori 
	 * @return insieme di tutti i Fruitori nel DB
	 */
	public ArrayList<Fruitore> visualizza_fruitori(){
		//nel caso in cui si cambi il salvataggio cambiare il costruttore con quello desiterato dall'interfaccia
		Salvataggio db= new Database_file();
		return db.carica_tutti_fruitori();
	}

	@Override
	public String toString() {
		return "Operatore + " + this.utente.getUsername();
	}
	
	@Override
	public boolean equals(Object obj) {
		Operatore o=(Operatore) obj;
		if(this.getUtente().getUsername().equals(o.getUtente().getUsername()))
		{
			return true;
		}else
			return false;
	}
	
}
