package versione_1.view;

import java.util.ArrayList;

import utilita.IO;

public class View {
	
	public int log_in_scelta() {
		System.out.println("Sei nell'log in \n1)Accedere \n2)Registrazione \n3)Esci");
		String str=IO.inKeyBoard(true);
		return Integer.parseInt(str);
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
