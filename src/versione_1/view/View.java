package versione_1.view;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import utilita.Costanti;
import utilita.IO;
import versione_1.model.Fruitore;
import versione_1.model.Operatore;
import versione_1.model.Utente;

public class View {
	
	public void scrivi(String informazioni) {
		System.out.println(informazioni);
	}
	
	public int log_in_scelta() {
		System.out.println(Costanti.GRECA);
		System.out.println("              MENU' PRINCIPALE         ");
		System.out.println(Costanti.GRECA);
		System.out.println("\n1)Accedere \n2)Registrazione \n3)Esci");
		return IO.insertInt(1, 3);
	}

	public int log_fruitore_operatore (Utente utente){
		System.out.println(Costanti.GRECA);
		System.out.println("              MENU' ACCESSO BENVENUTO "+utente.getUsername()+"                   ");
		System.out.println(Costanti.GRECA);
		System.out.println("\n1)Logga come Fruitore \n2)Logga come Operatore\n3)Diventa Fruitore\n4)Diventa Operatore\n5)Esci");
		return IO.insertInt(1, 5);
	}
	
	public int operatore_view(Operatore operatore) {
		System.out.println(Costanti.GRECA);
		System.out.println("              MENU' OPERATORE         ");
		System.out.println(Costanti.GRECA);
		System.out.println("\nCosa vuoi fare?\n1)Stampare i fruitore presenti nel database\n2)Torna indietro");
		return IO.insertInt(1, 2);
	}
	
	public int fruitore_view(Fruitore fruitore) {
		System.out.println(Costanti.GRECA);
		System.out.println("              MENU' FRUITORE         ");
		System.out.println(Costanti.GRECA);
		System.out.println("\nCosa vuoi fare?\n1)Torna indietro");
		return IO.insertInt(1, 1);
	}
	
	public String log() {
		System.out.println("Inserire username");
		String user=IO.inKeyBoard(true);
		System.out.println("Inserire password");
		String password=IO.inKeyBoard(true);
		return user+ IO.SEPARATORE_STRINGHE +password;
	}

	
	public void stampa_fruitori(ArrayList<Fruitore> fruitori){
		for(Fruitore f : fruitori) {
			this.scrivi(f.toString());
		}	
	}
	
	
	
	public ArrayList<String> nuova_registrazione() {
		ArrayList<String> dati= new ArrayList<>();
		System.out.println("Inserire Nome\n");
		dati.add(IO.inKeyBoard(true));
		System.out.println("Inserire Cognome\n");
		dati.add(IO.inKeyBoard(true));
		System.out.println("Inserire mail\n");
		dati.add(IO.inKeyBoard(true));
		System.out.println("Inserire Data di nascita giorno 1-31\n");
		dati.add(""+IO.insertInt(1, 31));
		System.out.println("Inserire Data di nascita mese 1-12\n");
		dati.add(""+IO.insertInt(1, 12));
		System.out.println("Inserire Data di nascita anno\n");
		dati.add(""+IO.insertInt(1930, LocalDate.now().getYear()));
		System.out.println("Inserire Username\n");
		dati.add(IO.inKeyBoard(true));
		System.out.println("Inserire Password\n");
		dati.add(IO.inKeyBoard(true));
		return dati;
	}

	
}
