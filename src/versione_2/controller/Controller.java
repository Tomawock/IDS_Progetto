package versione_2.controller;

import java.util.ArrayList;

import utilita.IO;
import versione_2.model.*;
import versione_2.view.*;

public class Controller {

	private View view;
	private Salvataggio db;
	
	public Controller() {
		view=new View();
		db=new Database_file();
	}
		
	public void log_in(){
		int valore=view.log_in_scelta();
		db.aggiorna_validita_fruitori();//elimina eventuali fruitori non validi
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
			if(!db.is_presente(user)) {
				//salvataggio su file sempre fare in due passaggi cosi quando si cambia il codice per il db si sperca meno tempo
				db.salva_utente(user);
				//Messaggio coinferma iscrizione
				this.view.scrivi("Ti sei iscritto correttamente "+user.getUsername());
			}else {
				this.view.scrivi("Username già utilizzato Inserirne un'altro");
			}
			//una volta completata l'iscrizione torna al log in
			this.log_in();
		}
		else if (valore ==3) {
			return;
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
				if(!fruitore.is_valido()) {
					this.view.scrivi("La registrazione come fruitore e' scaduta");
					db.elimina_fruitore(fruitore);//elimina il fruitore
					this.user_loggato(utente);
				}
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
				view.scrivi("Sei gia registrato come fruitore");
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
				view.scrivi("Sei gia registrato come operatore");
				this.user_loggato(utente);
			}
			else {
				this.view.scrivi(utente.getUsername()+" sei diventato operatore");
				//new Database_file().salva_operatore(new Operatore(utente));		
				db.salva_operatore(new Operatore(utente));
				this.user_loggato(utente);
			}
		}
		else if(valore==5) {
			this.log_in();
		}
		else {
			this.view.scrivi("Errore");
			this.user_loggato(utente);
		}
	}

	private void operatore_loggato(Operatore operatore) {
		int scelta = view.operatore_view(operatore);
		if (scelta==1) {
			this.view.stampa_fruitori(operatore.visualizza_fruitori());
			this.operatore_loggato(operatore);
		}
		else if (scelta==2){
			this.user_loggato(operatore.getUtente());
		}
		else {
			this.user_loggato(operatore.getUtente());
		}		
	}

	private void fruitore_loggato(Fruitore fruitore) {
		if(fruitore.is_rinnovabile()) {
			this.view.scrivi("Scadenza rinnovo vicina ti mancano " + fruitore.get_giorni_scadenza() + " giorni alla scadenza");
		}
		int scelta=view.fruitore_view(fruitore);
		if(scelta ==1) {
			this.user_loggato(fruitore.getUtente());
		}
		else if(scelta ==2) {
			if(fruitore.is_rinnovabile()) {
				db.elimina_fruitore(fruitore);
				fruitore.rinnova_iscrizione();//rinnova oggetto ma non il db
				db.salva_fruitore(fruitore);
			}
			else { 
				view.scrivi("Non puoi ancora rinnovare l'iscrizione");
			}
			this.fruitore_loggato(fruitore);
		}
		else {
			this.user_loggato(fruitore.getUtente());
		}
	}
}
