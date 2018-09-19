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
			String utente=view.log();
			String utente_user=utente.split(IO.SEPARATORE_STRINGHE)[0];
			String utente_psw=utente.split(IO.SEPARATORE_STRINGHE)[1];
			if(db.carica_utente(utente_user, utente_psw)==null) {
				view.scrivi("Utente o passw errati");
				this.log_in();
			}
			else {
				view.scrivi("Hai effettuato correttamente l'accesso");
				this.user_loggato(db.carica_utente(utente_user, utente_psw));
			}
		}
		else if(valore == 2) {
			ArrayList<String> nuovo_utente=view.nuova_registrazione();
			Utente user= new Utente(nuovo_utente);
			//salvataggio su file sempre fare in due passaggi cosi quando si cambia il codice per il db si sperca meno tempo
			db.salva_utente(user);
			//Messaggio coinferma iscrizione
			this.view.scrivi("Ti sei iscritto correttamente "+user.getUsername());
			//una volta completata l'iscrizione torna al log in
			this.log_in();
		}
		else if (valore ==3) {
			//TODO
		}else {
			this.view.scrivi("Errore");
			this.log_in();
		}
	}

	
	
	public void user_loggato(Utente utente){
		int valore=view.log_fruitore_operatore(utente);
		if (valore== 1) {
			Fruitore fruitore=db.carica_fruitore(utente.getUsername(), utente.getPassword());
			if(fruitore==null) {
				view.scrivi("Non sei registrato come fruitore");
				this.user_loggato(utente);
			}
			else {
				this.fruitore_loggato(fruitore);
			}
		}
		else if(valore == 2) {
			Operatore operatore=db.carica_operatore(utente.getUsername(), utente.getPassword());
			if(operatore==null) {
				view.scrivi("Non sei registrato come operatore");
				this.user_loggato(utente);
			}
			else {
				this.operatore_loggato(operatore);
			}
		}
		else if(valore==3) {
			if(db.carica_fruitore(utente.getUsername(), utente.getPassword())!=null) {
				view.scrivi("Sei gi� registrato come fruitore");
				this.user_loggato(utente);
			}
			else if(utente.getEta()>=18) {
				this.view.scrivi(utente.getUsername()+" sei diventato fruitore");
				//new Database_file().salva_fruitore(new Fruitore(utente));
				db.salva_fruitore(new Fruitore(utente));
				this.user_loggato(utente);
			}
			else {
				view.scrivi("Non puoi diventare fruitore in quanto non sei maggiorenne");
				this.user_loggato(utente);
			}
		}
		else if(valore==4) {
			if(db.carica_operatore(utente.getUsername(), utente.getPassword())!=null) {
				view.scrivi("Sei gi� registrato come operatore");
				this.user_loggato(utente);
			}
			else {
				this.view.scrivi(utente.getUsername()+" sei diventato operatore");
				//new Database_file().salva_operatore(new Operatore(utente));		
				db.salva_operatore(new Operatore(utente));
				this.user_loggato(utente);
			}
		}
		else {
			this.view.scrivi("Errore");
			this.user_loggato(utente);
		}
	}

	private void operatore_loggato(Operatore operatore) {
		// TODO Auto-generated method stub
		
	}

	private void fruitore_loggato(Fruitore carica_fruitore) {
		view.scrivi("FEWHQYW/(EY/(FEYW/(FEYNF/(WEY/(=WEYF/(EYFE/(");
		
	}
}
