package versione_5.model;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import utilita.IO;

public class Archivio implements Salvataggio{

	//VERSIONE DI ARCHIVIO DEI DATI
	public static final String PERCORSO_FILE_UTENTE_ARCHIVIO="src/Archivio/db_archivio_utenti";
	public static final String PERCORSO_FILE_FRUITORE_ARCHIVIO="src/Archivio/db_archivio_fruitori";
	public static final String PERCORSO_FILE_OPERATORE_ARCHIVIO="src/Archivio/db_archivio_operatore";
	public static final String PERCORSO_FILE_CATEGORIE_ARCHIVIO="src/Archivio/db_archivio_categorie";
	public static final String PERCORSO_FILE_PRESTITI_ARCHIVIO="src/Archivio/db_archivio_prestiti";
	
	@Override
	public void salva_utente(Utente utente) {
		IO.CreaFile(Archivio.PERCORSO_FILE_UTENTE_ARCHIVIO);
		ArrayList<Utente> utenti =this.carica_tutti_utenti();
		if (utenti==null) {
			utenti=new ArrayList<Utente>();
		}
		utenti.add(utente); 
        try{    
            //Saving of object in a file 
            FileOutputStream file = new FileOutputStream(Archivio.PERCORSO_FILE_UTENTE_ARCHIVIO); 
            ObjectOutputStream out = new ObjectOutputStream(file); 
            // Method for serialization of object 
            out.writeObject(utenti); 
             //chiudi 
            out.close(); 
            file.close();    
        }catch(IOException ex) { 
            System.err.println("IOException is caught"); 
        } 		
	}
	
	@Override
	public void salva_fruitore(Fruitore fruitore) {
		IO.CreaFile(Archivio.PERCORSO_FILE_FRUITORE_ARCHIVIO);
		ArrayList<Fruitore> fruitori =this.carica_tutti_fruitori();
		if (fruitori==null) {
			fruitori=new ArrayList<Fruitore>();
		}
		fruitori.add(fruitore); 
        try{    
            //Saving of object in a file 
            FileOutputStream file = new FileOutputStream(Archivio.PERCORSO_FILE_FRUITORE_ARCHIVIO); 
            ObjectOutputStream out = new ObjectOutputStream(file); 
            // Method for serialization of object 
            out.writeObject(fruitori); 
             //chiudi 
            out.close(); 
            file.close();    
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
              
//		            System.out.println("operatore serializzato"); 
  
        }catch(IOException ex) { 
            System.err.println("IOException is caught1"); 
        }
	}
	@Override
	public void reset_utenti(ArrayList<Utente> utenti) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void reset_fruitori(ArrayList<Fruitore> fruitori) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void reset_operatori(ArrayList<Operatore> operatori) {
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
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<Fruitore> carica_tutti_fruitori() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<Operatore> carica_tutti_operatori() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void elimina_utente(Utente utente) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void elimina_fruitore(Fruitore fruitore) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void elimina_operatore(Operatore operatore) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void aggiorna_validita_fruitori() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean is_presente(Utente utente) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Categoria carica_root_categorie() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void salva_categoria_root(Categoria root) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public ArrayList<Prestito> get_prestiti_per_fruitore_risorsa(Fruitore fruitore, Risorsa res) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void salva_prestito(Prestito prestito) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void reset_prestiti(ArrayList<Prestito> prestiti) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public ArrayList<Prestito> carica_tutti_prestiti() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<Prestito> get_tutti_prestiti_per_fruitore(Fruitore fruitore) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void aggiorna_validita_prestiti() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void aggiorna_descrizione_prestiti() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void aggiorna_prestito(Prestito p) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public ArrayList<Risorsa> ricerca_per_descrizione(Risorsa risorsa) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int get_n_copie_disponibili_by_id(int id) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
