package versione_1.model;

import java.util.ArrayList;

public interface Salvataggio {
	void salva_utente(Utente utente);
	void salva_fruitore(Fruitore fruitore);
	void salva_operatore(Operatore operatore);
	
	Utente carica_utente(String username, String psw);
	Fruitore carica_fruitore(String username, String psw);
	Operatore carica_operatore(String username, String psw);
	
	ArrayList<Utente> carica_tutti_utenti();
	ArrayList<Fruitore> carica_tutti_fruitori();
	ArrayList<Operatore> carica_tutti_operatori();

}
