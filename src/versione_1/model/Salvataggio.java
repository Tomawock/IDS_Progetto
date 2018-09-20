package versione_1.model;

import java.util.ArrayList;

public interface Salvataggio {
	
	void salva_utente(Utente utente);
	void salva_fruitore(Fruitore fruitore);
	void salva_operatore(Operatore operatore);
	
	void reset_utenti(ArrayList<Utente> utenti);
	void reset_fruitori(ArrayList<Fruitore> fruitori);
	void reset_operatori(ArrayList<Operatore> operatori);
	
	Utente carica_utente(String username, String psw);
	Fruitore carica_fruitore(String username, String psw);
	Operatore carica_operatore(String username, String psw);
	
	ArrayList<Utente> carica_tutti_utenti();
	ArrayList<Fruitore> carica_tutti_fruitori();
	ArrayList<Operatore> carica_tutti_operatori();

	void elimina_utente(Utente utente);
	void elimina_fruitore(Fruitore fruitore);
	void elimina_operatore(Operatore operatore);
	
	void aggiorna_validita_fruitori();
}
