package versione_5_old.model;

import java.io.Serializable;
import java.util.ArrayList;

import utilita.Costanti;

public abstract class  Risorsa implements Serializable{

	/**
	 * Numero seriale per la serializzazione dei dati su File
	 */
	private static final long serialVersionUID = 5L;
	private int n_licenze;
	private int in_prestito;
	private int id;
	
	private ArrayList<String> descrizione;
	
	/**
	 * Modifica la descrizione della risorsa con i dati passati in ingresso
	 * 
	 * @param descrizione	attributi della descrizione della risorsa
	 */
	public void aggiungi_descrizione(ArrayList<String> descrizione) {
		this.descrizione=descrizione;
	}
	
	/**
	 * Modifica la descrizione della risorsa in cui ogni parametro è settato con NO_DESCRIZIONE
	 */
	public void rimuovi_descrizione() {
		for(int i=0;i<this.descrizione.size();i++) {
			this.descrizione.set(i, Costanti.NO_DESCRIZIONE);
		}
	}
	
	/**
	 * Confronta una risorsa con una descrizione.Controlla che la descrizione passata in ingresso 
	 * sia ugale a quella della risorsa per ogni suo attributo salvo il parametro di NO_RICERCA
	 * 
	 * @param 		descrizione che devono essre ordinai in base alla tipologia di risorsa 
	 * @return 		true se la descrizione passata in ingresso è uguale a quella della risorsa
	 * 				false altrimenti
	 */
	public boolean equals_by_descrizione(ArrayList<String> descrizione) {
		for(int  i=0;i<this.descrizione.size();i++ ) {
			if(!(descrizione.get(i).equals(this.descrizione.get(i)) ||  descrizione.get(i).equals(Costanti.NO_RICERCA))) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Crea una risporsa in modo univoco
	 * 
	 * @param id		id della risorsa che sarà univoco
	 * @param n_licenze	numero di copie totali presenti
	 */
	public Risorsa(int id, int n_licenze) {
		this.id =id;
		this.n_licenze=n_licenze;
		this.descrizione=new ArrayList<>();
	}
	
	public ArrayList<String> get_dati(){
		return this.descrizione;
	}
	
	public int get_n_licenze() {
		return n_licenze;
	}
	
	public void set_n_licenze(int n_licenze) {
		this.n_licenze = n_licenze;
	}

	public int get_in_prestito() {
		return in_prestito;
	}
	
	public void set_in_prestito(int in_prestito) {
		this.in_prestito = in_prestito;
	}
	
	public int get_id() {
		return id;
	}
	
	public void set_id(int id) {
		this.id = id;
	}
	
	@Override
	public boolean equals(Object obj) {
		Risorsa r=(Risorsa)obj;
		if(this.id==r.get_id()) {
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "Numero Identificativo: "+id+", Numero di Copie: " + n_licenze + ", Numero Attualmente Disponibili: " + (n_licenze-in_prestito);
	}
	
	/**
	 * Aggiunge un prestito dalla risorsa ovvero modifica il numero di copie in Prestito
	 */
	public void add_prestito() {
		this.in_prestito++;
	}
	
	/**
	 * Rimuove un prestito dalla risorsa ovvero modifica il numero di copie in Prestito
	 */
	public void remove_prestito() {
		this.in_prestito--;	
	}
	
	/**
	 * Restituisce il numero di copie disponibili
	 * 
	 * @return	il valore di copie disponibili ovvero il Totale meno quelle in prestito
	 */
	public int get_disponibili() {
		return n_licenze-in_prestito;
	}
}
