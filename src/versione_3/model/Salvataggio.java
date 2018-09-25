package versione_3.model;

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
	
	boolean is_presente(Utente utente);
	
	Categoria carica_root_categorie();
	void salva_categoria_root(Categoria root);
	
	ArrayList<Prestito> get_prestiti_per_fruitore_risorsa(Fruitore fruitore,Risorsa res);
	void salva_prestito(Prestito prestito);
	void reset_prestiti(ArrayList<Prestito> prestiti);
	ArrayList<Prestito> carica_tutti_prestiti();
	ArrayList<Prestito> get_tutti_prestiti_per_fruitore(Fruitore fruitore);
	
	void controllo_validita_prestiti();
	
	void aggiorna_descrizione_prestiti();
	
	void aggiorna_prestito(Prestito p);
	
	ArrayList<Risorsa> ricerca_per_descrizione(ArrayList<String> parametri);
	int get_n_copie_disponibili_by_id(int id);
	
}
