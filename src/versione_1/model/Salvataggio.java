package versione_1.model;

import java.util.ArrayList;

public interface Salvataggio {
	void salva_utente(Utente u);
	Utente carica_utente();
	ArrayList<Utente> carica_tutti_utenti();

}
