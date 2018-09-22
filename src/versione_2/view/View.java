package versione_2.view;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import utilita.Costanti;
import utilita.IO;
import versione_2.model.*;

public class View {
	
	public void scrivi(String informazioni) {
		System.out.println(informazioni);
	}
	
	public int log_in_scelta() {
		System.out.println(Costanti.GRECA);
		System.out.println("              MENU' PRINCIPALE         ");
		System.out.println(Costanti.GRECA);
		System.out.println("1)Accedere \n2)Registrazione \n3)Esci");
		System.out.println(Costanti.GRECA3);
		return IO.insert_int(1, 3);
	}

	public int log_fruitore_operatore (Utente utente){
		System.out.println(Costanti.GRECA);
		System.out.println("              MENU' ACCESSO BENVENUTO "+utente.getUsername()+"                   ");
		System.out.println(Costanti.GRECA);
		System.out.println("1)Logga come Fruitore \n2)Logga come Operatore\n3)Diventa Fruitore\n4)Diventa Operatore\n5)Esci");
		System.out.println(Costanti.GRECA3);
		return IO.insert_int(1, 5);
	}
	
	public int operatore_view(Operatore operatore) {
		System.out.println(Costanti.GRECA);
		System.out.println("              MENU' OPERATORE         ");
		System.out.println(Costanti.GRECA);
		System.out.println("Cosa vuoi fare?\n1)Stampare i fruitore presenti nel database\n2)Torna indietro\n3)Aggiungi descrizione\n4)Rimuovi Descrizione\n5)visualizza risorse");
		System.out.println(Costanti.GRECA3);
		return IO.insert_int(1, 5);
	}
	
	public int fruitore_view(Fruitore fruitore) {
		System.out.println(Costanti.GRECA);
		System.out.println("              MENU' FRUITORE         ");
		System.out.println(Costanti.GRECA);
		System.out.println("Cosa vuoi fare?\n1)Torna indietro\n2)Rinnova Iscrizione");
		System.out.println(Costanti.GRECA3);
		return IO.insert_int(1, 2);
	}
	
	public String log() {
		System.out.println(Costanti.GRECA2);
		System.out.println(" **** Inserire Username **** ");
		System.out.println(Costanti.GRECA2);
		String user=IO.inKeyBoard(true);
		System.out.println(Costanti.GRECA2);
		System.out.println(" **** Inserire Password **** ");
		System.out.println(Costanti.GRECA2);
		String password=IO.inKeyBoard(true);
		return user+ IO.SEPARATORE_STRINGHE +password;
	}

	
	public void stampa_fruitori(ArrayList<Fruitore> fruitori){
		for(Fruitore f : fruitori) {
			this.scrivi(f.toString());
		}	
	}
	
	public int ricerca_risorsa_id() {
		System.out.println(Costanti.GRECA2);
		System.out.println(" **** Inserire ID della Risorsa **** ");
		return IO.insert_int(0,9999999);
	}
	
	public ArrayList<String> nuova_descrizione_libro(){
		ArrayList<String> dati= new ArrayList<>();
		System.out.println(Costanti.GRECA2);
		System.out.println(" **** Inserire Titolo **** ");
		System.out.println(Costanti.GRECA2);
		dati.add(IO.inKeyBoard(true));
		System.out.println(Costanti.GRECA2);
		System.out.println(" **** Inserire Autore **** ");
		System.out.println(Costanti.GRECA2);
		dati.add(IO.inKeyBoard(true));
		System.out.println(Costanti.GRECA2);
		System.out.println(" **** Inserire Numero di Pagine **** ");
		dati.add(""+IO.insert_int(0,9999999));
		dati.add(IO.inKeyBoard(true));
		System.out.println(Costanti.GRECA2);
		System.out.println(" **** Inserire Anno di pubblicazione **** ");
		System.out.println(Costanti.GRECA2);
		dati.add(""+IO.insert_int(0, LocalDate.now().getYear()));
		System.out.println(Costanti.GRECA2);
		System.out.println(" **** Inserire Casa Editrice **** ");
		System.out.println(Costanti.GRECA2);
		dati.add(IO.inKeyBoard(true));
		System.out.println(Costanti.GRECA2);
		System.out.println(" **** Inserire Lingua **** ");
		System.out.println(Costanti.GRECA2);
		dati.add(IO.inKeyBoard(true));
		System.out.println(Costanti.GRECA2);
		System.out.println(" **** Inserire Genere **** ");
		System.out.println(Costanti.GRECA2);
		dati.add(IO.inKeyBoard(true));
		return dati;
	}
	
	public ArrayList<String> nuova_registrazione() {
		ArrayList<String> dati= new ArrayList<>();
		System.out.println(Costanti.GRECA2);
		System.out.println(" **** Inserire Nome **** ");
		System.out.println(Costanti.GRECA2);
		dati.add(IO.inKeyBoard(true));
		System.out.println(Costanti.GRECA2);
		System.out.println(" **** Inserire Cognome **** ");
		System.out.println(Costanti.GRECA2);
		dati.add(IO.inKeyBoard(true));
		System.out.println(Costanti.GRECA2);
		System.out.println(" **** Inserire Mail **** ");
		System.out.println(Costanti.GRECA2);
		dati.add(IO.inKeyBoard(true));
		System.out.println(Costanti.GRECA2);
		System.out.println(" **** Inserire Data di Nascita (compresa fra 1 e 31) **** ");
		System.out.println(Costanti.GRECA2);
		dati.add(""+IO.insert_int(1, 31));
		System.out.println(Costanti.GRECA2);
		System.out.println(" **** Inserire Mese di Nascita (compreso fra 1 e 12) **** ");
		System.out.println(Costanti.GRECA2);
		dati.add(""+IO.insert_int(1, 12));
		System.out.println(Costanti.GRECA2);
		System.out.println(" **** Inserire Anno di Nascita (compreso fra 1930 e "+LocalDate.now().getYear()+") **** ");
		System.out.println(Costanti.GRECA2);
		dati.add(""+IO.insert_int(1930, LocalDate.now().getYear()));
		System.out.println(Costanti.GRECA2);
		System.out.println(" **** Inserire Username **** ");
		System.out.println(Costanti.GRECA2);
		dati.add(IO.inKeyBoard(true));
		System.out.println(Costanti.GRECA2);
		System.out.println(" **** Inserire Password **** ");
		System.out.println(Costanti.GRECA2);
		dati.add(IO.inKeyBoard(true));
		return dati;
	}

	public ArrayList<String> nuova_descrizione_film() {
		ArrayList<String> dati= new ArrayList<>();
		System.out.println("non ci occupiamo di questa categoria");
		return null;
	}
}
