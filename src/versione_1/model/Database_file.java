package versione_1.model;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import utilita.IO;

public class Database_file implements Salvataggio{
	
	public static final String PERCORSO_FILE_UTENTE="src/Local_database/db_utenti";

	@Override
	public void salva_utente(Utente u) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void salva_fruitore(Fruitore f) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void salva_operatore(Operatore o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Utente carica_utente() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Fruitore carica_fruitore(String username, String psw) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Operatore carica_operatore(String username, String psw) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Utente> carica_tutti_utenti() {
		// TODO Auto-generated method stub
		return null;
	}
}
