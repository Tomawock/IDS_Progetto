package versione_1.model;

import java.util.ArrayList;

public interface Salvataggio {
	void salva_utente(Utente u);
	void salva_fruitore(Fruitore f);
	void salva_operatore(Operatore o);
	Utente carica_utente();
	Fruitore carica_fruitore(String username, String psw);
	Operatore carica_operatore(String username, String psw);
	
	ArrayList<Utente> carica_tutti_utenti();

}
