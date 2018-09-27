package versione_4.model;

import java.io.Serializable;

public class Operatore implements Serializable{

	/**
	 * Numero seriale per la serializzazione dei dati su File
	 */
	private static final long serialVersionUID = 3L;
	
	private Utente utente;
	
	public Operatore(Utente utente) {
		this.utente=utente;
		
	}
	
	public Utente getUtente() {
		return utente;
	}

	@Override
	public String toString() {
		return "Operatore " + this.utente.getUsername();
	}
	/**
	 * Due operatori sono ugali quando il loro utente associato ha lo stesso username
	 */
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
