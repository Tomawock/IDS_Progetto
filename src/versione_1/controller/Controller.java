package versione_1.controller;

import java.util.ArrayList;

import utilita.IO;
import versione_1.model.*;
import versione_1.view.*;

public class Controller {

	private View view;
	private Salvataggio db;
	
	public Controller() {
		view=new View();
		db=new Database_file();
	}
		
	public void log_in(){
		int valore=view.log_in_scelta();
		if (valore== 1) {
			String test=view.log();
			String test_u=test.split(IO.SEPARATORE_STRINGHE)[0];
			String test_p=test.split(IO.SEPARATORE_STRINGHE)[1];
			// prendi dati da archivio e controlla se ci sono
			
			//Funge
		}
		else if(valore == 2) {
			ArrayList<String> test_dati=view.nuova_registrazione();
			Utente user= new Utente(test_dati);
			//salvataggio su file sempre fare in due passaggi cosi quando si cambia il codice per il db si sperca meno tempo
			
			db.salva_utente(user);
			//Messaggio coinferma iscrizione
			this.view.scrivi("Ti sei iscritto correttamente "+user.getUsername());
			//una volta completata l'iscrizione torna al log in
			this.log_in();
		}
		else if (valore ==3) {
			//TODO
		}else
			this.view.scrivi("Errore");
	}
	
	public void log_fruitore_operatore() {
		
	}
	
	public void log_new_fruitore_operatore(Utente utente){
		int valore=view.log_in_scelta();
		if (valore== 1) {
			if(utente.getEta()>=18) {
				this.view.scrivi(utente.getUsername()+" sei diventato fruitore");
				//new Database_file().salva_fruitore(new Fruitore(utente));
				Salvataggio db=new Database_file();
				db.salva_fruitore(new Fruitore(utente));
			}
			else this.view.scrivi("Non puoi diventare fruitore in quanto non sei maggiorenne");
		}
		else if(valore == 2) {
			this.view.scrivi(utente.getUsername()+" sei diventato operatore");
			//new Database_file().salva_operatore(new Operatore(utente));		
			Salvataggio db=new Database_file();
			db.salva_operatore(new Operatore(utente));
		}else
			this.view.scrivi("Errore");
	}
}
