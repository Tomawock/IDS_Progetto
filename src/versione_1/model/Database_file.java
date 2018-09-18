package versione_1.model;

import java.io.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import utilita.IO;

public class Database_file implements Salvataggio{
	
	public static final String PERCORSO_FILE_UTENTE="src/Local_database/db_utenti";
	public static final String PERCORSO_FILE_FRUITORE="src/Local_database/db_fruitori";
	public static final String PERCORSO_FILE_OPERATORE="src/Local_database/db_operatore";

	@Override
	public void salva_utente(Utente utente) {
		//crea il file nel percorso se non e presente
		IO.CreaFile(Database_file.PERCORSO_FILE_UTENTE);
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
            System.err.println("IOException is caught"); 
        } 
	}

	@Override
	public void salva_fruitore(Fruitore fruitore) {
		//crea il file nel percorso se non e presente
		IO.CreaFile(Database_file.PERCORSO_FILE_FRUITORE);
		//carica il db e poi aggiungo il singolo utente in coda ad esso e lo salvo
		ArrayList<Fruitore> fruitori =this.carica_tutti_fruitori();
		if (fruitori==null) {
			fruitori=new ArrayList<Fruitore>();
		}
		fruitori.add(fruitore);
		// Serialization  
        try{    
            //Saving of object in a file 
            FileOutputStream file = new FileOutputStream(Database_file.PERCORSO_FILE_FRUITORE); 
            ObjectOutputStream out = new ObjectOutputStream(file); 
              
            // Method for serialization of object 
            out.writeObject(fruitori); 
              
            out.close(); 
            file.close(); 
              
            System.out.println("fruitore serializzato"); 
  
        }catch(IOException ex) { 
            System.err.println("IOException is caught"); 
        } 	
	}

	@Override
	public void salva_operatore(Operatore operatore) {
		//crea il file nel percorso se non e presente
		IO.CreaFile(Database_file.PERCORSO_FILE_OPERATORE);
		//carica il db e poi aggiungo il singolo utente in coda ad esso e lo salvo
		ArrayList<Operatore> operatori =this.carica_tutti_operatori();
		if (operatori==null) {
			operatori=new ArrayList<Operatore>();
		}
		operatori.add(operatore);
		// Serialization  
        try{    
            //Saving of object in a file 
            FileOutputStream file = new FileOutputStream(Database_file.PERCORSO_FILE_OPERATORE); 
            ObjectOutputStream out = new ObjectOutputStream(file); 
              
            // Method for serialization of object 
            out.writeObject(operatori); 
              
            out.close(); 
            file.close(); 
              
            System.out.println("operatore serializzato"); 
  
        }catch(IOException ex) { 
            System.err.println("IOException is caught1"); 
        }
	}

	/**
	 * @return utente corrispondente o null in caso in cui non npè presente 
	 */
	@Override
	public Utente carica_utente(String username, String psw) {
		ArrayList<Utente> utenti= new ArrayList<Utente>();
		utenti=this.carica_tutti_utenti();
		if (utenti==null) {
			return null;
		}
		else{
			for(Utente u:utenti) {
				if (u.getUsername().equals(username)&& u.getPassword().equals(psw))
					return u;
			}
			return null;
		}
	}

	@Override
	public Fruitore carica_fruitore(String username, String psw) {
		ArrayList<Fruitore> fruitori= new ArrayList<Fruitore>();
		fruitori=this.carica_tutti_fruitori();
		if (fruitori==null) {
			return null;
		}
		else{
			for(Fruitore f:fruitori) {
				Utente u=f.getUtente();
				if (u.getUsername().equals(username)&& u.getPassword().equals(psw))
					return f;
			}
			return null;
		}
	}

	@Override
	public Operatore carica_operatore(String username, String psw) {
		ArrayList<Operatore> operatori= new ArrayList<Operatore>();
		operatori=this.carica_tutti_operatori();
		if (operatori==null) {
			return null;
		}
		else{
			for(Operatore o:operatori) {
				Utente u=o.getUtente();
				if (u.getUsername().equals(username)&& u.getPassword().equals(psw))
					return o;
			}
			return null;
		}
	}

	@Override
	public ArrayList<Utente> carica_tutti_utenti() {
		//crea il file nel percorso se non e presente
		IO.CreaFile(Database_file.PERCORSO_FILE_UTENTE);
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
       	 	//System.out.println("EOFExceptionis caught"); // si verifica sempre qunado creo il file la prima volta ma non è fondamentale 
        }catch(IOException ex) {
        	System.err.println("IOException is caught"); 
        }catch(ClassNotFoundException ex) {
            System.err.println("ClassNotFoundException is caught"); 
        } 	
		return utenti;
	}

	@Override
	public ArrayList<Fruitore> carica_tutti_fruitori() {
		//crea il file nel percorso se non e presente
		IO.CreaFile(Database_file.PERCORSO_FILE_FRUITORE);
		//creo arraylist per gli utenti 
		ArrayList<Fruitore> fruitori =new ArrayList<Fruitore>();
		// Deserialization 
        try {    
            // Reading the object from a file 
            FileInputStream file = new FileInputStream(Database_file.PERCORSO_FILE_FRUITORE); 
            ObjectInputStream in = new ObjectInputStream(file); 
              
            // Method for deserialization of object 
            fruitori = (ArrayList<Fruitore>)in.readObject(); 
              
            in.close(); 
            file.close(); 
              
            System.out.println("fruitori deserializzati"); 
        }catch(EOFException ex) {
       	 	//System.out.println("EOFExceptionis caught"); // si verifica sempre qunado creo il file la prima volta ma non è fondamentale 
        }catch(IOException ex) {
        	System.err.println("IOException is caught"); 
        }catch(ClassNotFoundException ex) {
            System.err.println("ClassNotFoundException is caught"); 
        } 	
		return fruitori;
	}

	@Override
	public ArrayList<Operatore> carica_tutti_operatori() {
		//crea il file nel percorso se non e presente
		IO.CreaFile(Database_file.PERCORSO_FILE_OPERATORE);
		//creo arraylist per gli utenti 
		ArrayList<Operatore> operatori =new ArrayList<Operatore>();
		// Deserialization 
        try {    
            // Reading the object from a file 
            FileInputStream file = new FileInputStream(Database_file.PERCORSO_FILE_OPERATORE); 
            ObjectInputStream in = new ObjectInputStream(file); 
              
            // Method for deserialization of object 
            operatori = (ArrayList<Operatore>)in.readObject(); 
              
            in.close(); 
            file.close(); 
              
            System.out.println("operatori deserializzati"); 
        }catch(EOFException ex) {
       	 	//System.out.println("EOFExceptionis caught"); // si verifica sempre qunado creo il file la prima volta ma non è fondamentale 
        }catch(IOException ex) {
        	System.err.println("IOException is caught"); 
        }catch(ClassNotFoundException ex) {
            System.err.println("ClassNotFoundException is caught"); 
        } 	
		return operatori;
	}
	
	public static void main (String[] args) {
		Database_file db=new Database_file();
		Utente u=new Utente("test", "test", "test",  new GregorianCalendar(2012,10,10) ,"test", "test", "test");
		Utente u2=new Utente("test2", "test2", "test2",  new GregorianCalendar(2012,10,10) ,"test2", "test2", "test2");
		db.salva_utente(u);
		db.salva_utente(u2);
		
		db.salva_fruitore(new Fruitore(u));
		db.salva_fruitore(new Fruitore(u2));
		
		db.salva_operatore(new Operatore(u));
		db.salva_operatore(new Operatore(u2));
		
		System.out.println("**************UTENTI********************");
		ArrayList<Utente> utenti=db.carica_tutti_utenti();
		for(Utente ut:utenti) {
			System.out.println(ut.toString());
		}
		
		System.out.println("**************FRUITORI********************");
		ArrayList<Fruitore> fruitori=db.carica_tutti_fruitori();
		for(Fruitore f:fruitori) {
			System.out.println(f.toString());
		}
		
		System.out.println("**************OPERATORI********************");
		ArrayList<Operatore> operatrori=db.carica_tutti_operatori();
		for(Operatore o:operatrori) {
			System.out.println(o.toString());
		}
		
		System.out.println("SELECT UTENTE TRUE");
		System.out.println(db.carica_utente("test", "test").toString());
		System.out.println("SELECT UTENTE FALSE");
		String result=(db.carica_utente("test3", "test3")==null)?"Utente O Password Errati":"OK";
		System.out.println(result);
		
		System.out.println("SELECT FRUITORE TRUE");
		System.out.println(db.carica_fruitore("test", "test").toString());
		System.out.println("SELECT FRUITORE FALSE");
		String result1=(db.carica_fruitore("test3", "test3")==null)?"Utente O Password Errati":"OK";
		System.out.println(result1);
		
		System.out.println("SELECT OPERATORE TRUE");
		System.out.println(db.carica_operatore("test", "test").toString());
		System.out.println("SELECT OPERATORE FALSE");
		String result2=(db.carica_operatore("test3", "test3")==null)?"Utente O Password Errati":"OK";
		System.out.println(result2);
	}

}
