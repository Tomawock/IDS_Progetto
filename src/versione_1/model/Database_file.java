package versione_1.model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Database_file implements Salvataggio{
	
	public final String PERCORSO_FILE_UTENTE="/Local_database/db_utenti.txt";

	@Override
	public void salva_utente(Utente utente) {
		
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
		
		ArrayList<Utente> utenti =new ArrayList<Utente>();
		ObjectInputStream objectinputstream = null;
		try {
		    FileInputStream streamIn = new FileInputStream(PERCORSO_FILE_UTENTE);
		    objectinputstream = new ObjectInputStream(streamIn);
		    ArrayList<Utente> readCase = (ArrayList) objectinputstream.readObject();
		    utenti.addAll(0, readCase);
		    //stampa per controllo
		    for(Utente u:utenti){
		    	System.out.println(u.toString());
		    }
		    System.out.println("End of file");
		} catch (Exception e) {
		    e.printStackTrace();
		} finally {
		    if(objectinputstream != null){
		        try {
					objectinputstream .close();
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
		
	}

}
