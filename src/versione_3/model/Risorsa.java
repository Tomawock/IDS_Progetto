package versione_3.model;

import java.io.Serializable;
import java.util.ArrayList;

import utilita.Costanti;

public abstract class  Risorsa implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5L;
	private int n_licenze;
	private int in_prestito;
	private int id;
	
	private ArrayList<String> dati;
	
	public void aggiungi_descrizione(ArrayList<String> dati) {
		this.dati=dati;
	}
	
	public void rimuovi_descrizione() {
		for(int i=0;i<this.dati.size();i++) {
			this.dati.set(i, Costanti.NO_DESCRIZIONE);
		}
	}
	/**
	 * 
	 * @param dati che devono essre ordinai in base alla tipologia di risorsa 
	 * @return 
	 */
	public boolean equals_by_descrizione(ArrayList<String> dati) {

		for(int  i=0;i<this.dati.size();i++ ) {
			if(!(dati.get(i).equals(this.dati.get(i)) ||  dati.get(i).equals(Costanti.NO_RICERCA))) {
				return false;
			}
		}
		return true;
	}
	
	public Risorsa(int id, int n_licenze) {
		this.id =id;
		this.n_licenze=n_licenze;
		this.dati=new ArrayList<>();
	}
	
	public ArrayList<String> get_dati(){
		return this.dati;
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
	public void add_prestito() {
		this.in_prestito++;
	}
	public void remove_prestito() {
		this.in_prestito--;	
	}
	public int get_disponibili() {
		return n_licenze-in_prestito;
	}
	
	
}
