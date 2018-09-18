package versione_1.model;

import java.io.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import utilita.IO;

public class Database_file implements Salvataggio{
	
	public static final String PERCORSO_FILE_UTENTE="src/Local_database/db_utenti";

	@Override
	public void salva_utente(Utente utente) {
		//crea il file nel percorso se non e presente
		IO.CreaFile(PERCORSO_FILE_UTENTE);
		//carica il db e poi aggiungo il singolo utente in coda ad esso e lo salvo
		ArrayList<Utente> utenti =this.carica_tutti_utenti();
		if (utenti==null) {
			utenti=new ArrayList<Utente>();
		}
		utenti.add(utente);
		// Serialization  
        try{    
            //Saving of object in a file 
            FileOutputStream file = new FileOutputStream(Database_file.PERCORSO_FILE_UTENTE); 
            ObjectOutputStream out = new ObjectOutputStream(file); 
              
            // Method for serialization of object 
            out.writeObject(utenti); 
              
            out.close(); 
            file.close(); 
              
            System.out.println("utente serializzato"); 
  
        }catch(IOException ex) { 
            System.out.println("IOException is caught"); 
        } 
	}

	@Override
	public void salva_fruitore(Fruitore fruitore) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void salva_operatore(Operatore operatore) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Utente carica_utente(String username, String psw) {
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
		//crea il file nel percorso se non e presente
		IO.CreaFile(PERCORSO_FILE_UTENTE);
		//creo arraylist per gli utenti 
		ArrayList<Utente> utenti =new ArrayList<Utente>();
		// Deserialization 
        try {    
            // Reading the object from a file 
            FileInputStream file = new FileInputStream(Database_file.PERCORSO_FILE_UTENTE); 
            ObjectInputStream in = new ObjectInputStream(file); 
              
            // Method for deserialization of object 
            utenti = (ArrayList<Utente>)in.readObject(); 
              
            in.close(); 
            file.close(); 
              
            System.out.println("Utenti deserializzati"); 
        }catch(EOFException ex) {
       	 System.out.println("EOFExceptionis caught"); 
        }catch(IOException ex) {
        	System.out.println("IOException is caught"); 
        }catch(ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException is caught"); 
        } 	
		return utenti;
	}
	
	public static void main (String[] args) {
		Database_file db=new Database_file();
		db.salva_utente(new Utente("test", "test", "test",  new GregorianCalendar(2012,10,10) ,"test", "test", "test"));
		db.salva_utente(new Utente("test2", "test2", "test2",  new GregorianCalendar(2012,10,10) ,"test2", "test2", "test2"));
		ArrayList<Utente> utenti=db.carica_tutti_utenti();
		for(Utente u:utenti) {
			System.out.println(u.toString());
		}
	}

}
