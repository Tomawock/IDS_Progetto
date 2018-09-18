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
	public void salva_utente(Utente utente) {
		
		IO.CreaFile(PERCORSO_FILE_UTENTE);//apre e controlla che ci sia il file semai lo crea
		
		ArrayList<Utente> utenti=this.carica_tutti_utenti();
		if (utenti==null) {
			utenti=new ArrayList<Utente>();
		}
		//aggiungo il nuovo utente in coda all'array
		utenti.add(utente);
		
		
		ObjectOutputStream oos = null;
		FileOutputStream fout = null;
		try{
		    fout = new FileOutputStream(PERCORSO_FILE_UTENTE, true);
		    oos = new ObjectOutputStream(fout);
		    oos.writeObject(utenti);
		} catch (Exception ex) {
		    ex.printStackTrace();
		} finally {
		    if(oos != null){
		        try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		    } 
		}
	}

	@Override
	public Utente carica_utente() {
		// TODO 
		return null;
	}

	@Override
	public ArrayList<Utente> carica_tutti_utenti() {
		
		IO.CreaFile(PERCORSO_FILE_UTENTE);//apre e controlla che ci sia il file semai lo crea
		
		ArrayList<Utente> utenti= null;
		
		FileInputStream fin = null;
		ObjectInputStream ois = null;

		try {

			fin = new FileInputStream(PERCORSO_FILE_UTENTE);
			ois = new ObjectInputStream(fin);
			utenti= (ArrayList<Utente>) ois.readObject();

		}catch (EOFException ex) {
				//ex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}finally {

			if (fin != null) {
				try {
					fin.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}		
		return utenti;
	}

	public static void main(String[] args) {
		Database_file db=new Database_file();
		db.salva_utente(new Utente("test","test", "test", new GregorianCalendar(2012,1,1) , "test","test", "test"));
		db.salva_utente(new Utente("test2","test2", "test2", new GregorianCalendar(2012,1,1) , "test2","tes2t", "2test"));
		//IO.creaFile(PERCORSO_FILE_UTENTE);
		ArrayList<Utente>users =db.carica_tutti_utenti();
		for(Utente u:users) {
			System.out.println(u.toString());
		}
	}



}
