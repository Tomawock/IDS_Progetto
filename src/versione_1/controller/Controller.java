package versione_1.controller;

import java.util.ArrayList;

import utilita.IO;
import versione_1.model.*;
import versione_1.view.*;

public class Controller {

	private View view;
	
	public Controller() {
		view=new View();
	}
		
	public void log_in(){
		int valore=view.log_in_scelta();
		if (valore== 1) {
			String test=view.log();
			String test_u=test.split(IO.SEPARATORE_STRINGHE)[0];
			String test_p=test.split(IO.SEPARATORE_STRINGHE)[1];
			// prendi dati da archivio e controlla se ci sono
			
			System.out.println(test_u);
			System.out.println(test_p);
			//Funge
		}
		else if(valore == 2) {
			ArrayList<String> test_dati=view.nuova_registrazione();
			Utente user= new Utente(test_dati);
			//salvataggio su file
			new Database_file().salva_utente(user);
			//salvataggio su dbms
			System.out.println(user.toString());
		}
		else if (valore ==3) {
			//TODO
		}else
			System.out.println("Errore");
		
	}
	
	public void log_fruitore_operatore(Utente utente){
		int valore=view.log_in_scelta();
		if (valore== 1) {
			if(utente.getEtà()>=18) {
				System.out.println(utente.getUsername()+" sei diventato fruitore");
				new Database_file().salva_fruitore(new Fruitore(utente));
			}
			else System.out.println("Non puoi diventare fruitore in quanto non sei maggiorenne");
		}
		else if(valore == 2) {
			System.out.println(utente.getUsername()+" sei diventato operatore");
			new Database_file().salva_operatore(new Operatore(utente));		
		}else
			System.out.println("Errore");
	}
}
