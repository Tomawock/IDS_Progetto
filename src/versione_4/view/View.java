package versione_4.view;

import java.time.LocalDate;
import java.util.ArrayList;

import utilita.Costanti;
import utilita.IO;
import versione_4.model.*;

public class View {
	
	public void scrivi(String informazioni) {
		System.out.println(informazioni);
	}
	
	public int log_in_scelta() {
		System.out.println(Costanti.GRECA);
		System.out.println("              MENU' PRINCIPALE         ");
		System.out.println(Costanti.GRECA);
		System.out.println("1)Accedere\n"
				+ "2)Registrazione\n"
				+ "3)Esci");
		System.out.println(Costanti.GRECA3);
		return IO.insert_int(1, 3);
	}

	public int log_fruitore_operatore (Utente utente){
		System.out.println(Costanti.GRECA);
		System.out.println("              MENU' ACCESSO BENVENUTO "+utente.getUsername()+"                   ");
		System.out.println(Costanti.GRECA);
		System.out.println("1)Logga come Fruitore\n"
				+ "2)Logga come Operatore\n"
				+ "3)Diventa Fruitore\n"
				+ "4)Diventa Operatore\n"
				+ "5)Esci");
		System.out.println(Costanti.GRECA3);
		return IO.insert_int(1, 5);
	}
	
	public int operatore_view(Operatore operatore) {
		System.out.println(Costanti.GRECA);
		System.out.println("              MENU' OPERATORE         ");
		System.out.println(Costanti.GRECA);
		System.out.println("Cosa vuoi fare?\n"
				+ "1)Stampare i fruitore presenti nel database\n"
				+ "2)Aggiungi descrizione\n"
				+ "3)Rimuovi Descrizione\n"
				+ "4)visualizza risorse\n"
				+ "5)Ricerca o Visualizza disponibilità Risorsa\n"
				+ "6)Torna indietro");
		System.out.println(Costanti.GRECA3);
		return IO.insert_int(1, 6);
	}
	
	public int fruitore_view(Fruitore fruitore) {
		System.out.println(Costanti.GRECA);
		System.out.println("              MENU' FRUITORE         ");
		System.out.println(Costanti.GRECA);
		System.out.println("Cosa vuoi fare?\n"
				+ "1)Rinnova Iscrizione\n"
				+ "2)Effettua Prestito\n"
				+ "3)Visualizza tutti i prestiti\n"
				+ "4)Prolunga prestito\n"
				+ "5)Ricerca o Visualizza disponibilità Risorsa\n"
				+ "6)Torna indietro\n");
		System.out.println(Costanti.GRECA3);
		return IO.insert_int(1, 6);
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
		System.out.println(Costanti.GRECA2);
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
		dati.add(""+IO.insert_int(0,99999999));
		System.out.println(Costanti.GRECA2);
		System.out.println(" **** Inserire Anno di pubblicazione **** ");
		System.out.println(Costanti.GRECA2);
		dati.add(""+IO.insert_int(0,9999999));
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
	
	public ArrayList<String> nuova_descrizione_film(){
		ArrayList<String> dati= new ArrayList<>();
		System.out.println(Costanti.GRECA2);
		System.out.println(" **** Inserire Titolo **** ");
		System.out.println(Costanti.GRECA2);
		dati.add(IO.inKeyBoard(true));
		System.out.println(Costanti.GRECA2);
		System.out.println(" **** Inserire Regista **** ");
		System.out.println(Costanti.GRECA2);
		dati.add(IO.inKeyBoard(true));
		System.out.println(Costanti.GRECA2);
		System.out.println(" **** Inserire Durata in minuti **** ");
		dati.add(""+IO.insert_int(0,99999999));
		System.out.println(Costanti.GRECA2);
		System.out.println(" **** Inserire Anno di pubblicazione **** ");
		System.out.println(Costanti.GRECA2);
		dati.add(""+IO.insert_int(0,9999999));
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

	
	public int ricerca_o_disponibilita() {
		System.out.println(Costanti.GRECA);
		System.out.println("Cosa vuoi fare?\n"
				+ "1)Ricerca per descrizione\n"
				+ "2)Visualizza qunatità disponibili");
		System.out.println(Costanti.GRECA);
		return IO.insert_int(1, 2);	
	}

	public int get_sottocategorie_principali() {
		System.out.println(Costanti.GRECA2);
		System.out.println("1)Libri\n2)Film");
		System.out.println(Costanti.GRECA2);
		return IO.insert_int(1,2);
	}

	public void stampa_risorse(ArrayList<Risorsa> risorse) {
		if(risorse.isEmpty()) {
			this.scrivi("Risorse non Trovate secondo la descrizione fornita");
		}else {
			for(Risorsa r:risorse) {
				this.scrivi(r.toString());
			}
		}
	}
}
