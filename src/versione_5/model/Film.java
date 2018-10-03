package versione_5.model;

import java.util.ArrayList;
import java.util.Arrays;

import utilita.Costanti;

public class Film extends Risorsa{

	/**
	 * Numero seriale per la serializzazione dei dati su File
	 */
	private static final long serialVersionUID = 10L;
	
	/**
	 * Crea una nuova risorsa di tipo Film con un id univoco e un numero di copie fissato
	 * 		Viene aggiunta la descrizione della risorsa con tutti i campi settati con NO_DESCRIZIONE
	 * 
	 * @param id			id univoco della risorsa
	 * @param n_licenze		numero di copie massimo diponibile
	 */
	public Film(int id, int n_licenze) {
		super(id, n_licenze);
		// TODO Auto-generated constructor stub
		super.aggiungi_descrizione(new ArrayList<>(Arrays.asList(Costanti.NO_DESCRIZIONE,Costanti.NO_DESCRIZIONE,Costanti.NO_DESCRIZIONE,Costanti.NO_DESCRIZIONE,Costanti.NO_DESCRIZIONE)));
	}

	@Override
	public String toString() {
		return " ***** Titolo Film: " + super.get_dati().get(0) + ", Regista: " + super.get_dati().get(1) + 
				", Durata in minuti: " + super.get_dati().get(2) + ", Anno di Pubblicazione: " + super.get_dati().get(3)+ 
				", Genere: " + super.get_dati().get(4)+", "+ super.toString()+"  ***** ";
	}


}
