package versione_1.view;

import java.util.ArrayList;

import utilita.IO;
import versione_1.model.Utente;

public class View {
	
	public void scrivi(String informazioni) {
		System.out.println(informazioni);
	}
	
	public int log_in_scelta() {
		System.out.println("Sei nell'log in \n1)Accedere \n2)Registrazione \n3)Esci");
		String str=IO.inKeyBoard(true);
		return Integer.parseInt(str);
	}

	public int log_fruitore_operatore (Utente utente){
		System.out.println("Ciao "+ utente.getUsername() +"\n1)Logga come Fruitore \n2)Logga come Operatore\n3)Diventa Fruitore\n4)Diventa Operatore");
		String str=IO.inKeyBoard(true);
		return Integer.parseInt(str);
	}
	
	public int operatore_view(Operatore operatore) {
		
		
	}
	
	public String log() {
		System.out.println("Inserire username");
		String user=IO.inKeyBoard(true);
		System.out.println("Inserire password");
		String password=IO.inKeyBoard(true);
		return user+ IO.SEPARATORE_STRINGHE +password;
		
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
		dati.add(IO.inKeyBoard(true));
		System.out.println("Inserire Data di nascita mese 1-12\n");
		dati.add(IO.inKeyBoard(true));
		System.out.println("Inserire Data di nascita anno\n");
		dati.add(IO.inKeyBoard(true));
		System.out.println("Inserire CF\n");
		dati.add(IO.inKeyBoard(true));
		System.out.println("Inserire Username\n");
		dati.add(IO.inKeyBoard(true));
		System.out.println("Inserire Password\n");
		dati.add(IO.inKeyBoard(true));
		
		return dati;
	}

	
}
