package versione_2.model;

import java.util.ArrayList;

public abstract class  Risorsa {

	private int n_licenze;
	private int in_prestito;
	private int id;
	
	abstract void aggiungi_descrizione(ArrayList<String> dati);
	abstract void rimuovi_descrizione();
	
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
	public String toString() {
		return "Numero Identificativo: "+id+", Numero di Copie: " + n_licenze + ", Numero Attualmente Disponibili" + (n_licenze-in_prestito);
	}
	
	
}
