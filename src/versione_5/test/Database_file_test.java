package versione_5.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import utilita.IO;
import versione_5.model.*;

class Database_file_test {

	Database_file db;
	Utente utente,utente_2;
	Fruitore fruitore,fruitore_2;
	Operatore operatore, operatore_2;
	
	@BeforeEach
	public void setup() {

		db=new Database_file();
		
		utente=new Utente("test", "test", "test",  LocalDateTime.of(2012,12,12,0,0) ,"test", "test", "test");
		utente_2=new Utente("test2", "test2", "test2",  LocalDateTime.of(2012,12,12,0,0) ,"test2", "test2", "test2");
		
		fruitore=new Fruitore(utente);
		fruitore_2=new Fruitore(utente_2);
		
		operatore=new Operatore(utente);
		operatore_2=new Operatore(utente_2);
	}
	
	/**
	 * Test Per cammini di base
	 */	
	@Test 
	public void vero_se_salva_utente_salva_senza_utenti_gia_presenti(){
		//elimino il file per esere sicuro di non avere altri utenti salvati sullo stesso file
		File file_eliminato= new File(Database_file.PERCORSO_FILE_UTENTE);
		file_eliminato.delete();
		
		IO.CreaFile(Database_file.PERCORSO_FILE_UTENTE);
		db.salva_utente(utente);	
		
		ArrayList<Utente> utenti=new ArrayList<>();
		try {    
            // Reading the object from a file 
            FileInputStream file = new FileInputStream(Database_file.PERCORSO_FILE_UTENTE); 
            ObjectInputStream in = new ObjectInputStream(file); 
              
            utenti = (ArrayList<Utente>)in.readObject(); 
              
            in.close(); 
            file.close(); 
              
        }catch(Exception ex) {
        	System.out.println(ex.getMessage());
        }
		assertEquals(utente,utenti.get(0),"Salvataggio di un utente come oggetto sul file,senza altri utenti precedentemente salvati");
	}
	
	@Test 
	public void vero_se_salva_utente_salva_con_utenti_presenti(){
		//elimino il file per esere sicuro di non avere altri utenti salvati sullo stesso file
		File file_eliminato= new File(Database_file.PERCORSO_FILE_UTENTE);
		file_eliminato.delete();
		
		IO.CreaFile(Database_file.PERCORSO_FILE_UTENTE);
		db.salva_utente(utente);
		db.salva_utente(utente_2);
		
		ArrayList<Utente> utenti=new ArrayList<>();
		try {    
            // Reading the object from a file 
            FileInputStream file = new FileInputStream(Database_file.PERCORSO_FILE_UTENTE); 
            ObjectInputStream in = new ObjectInputStream(file); 
              
            utenti = (ArrayList<Utente>)in.readObject(); 
              
            in.close(); 
            file.close(); 
              
        }catch(Exception ex) {
        	System.out.println(ex.getMessage());
        }
		assertEquals(utente_2,utenti.get(utenti.size()-1),"Salvataggio di un utente come oggetto sul file,con utenti precedentemente salvati");
	}
	
	@Test 
	public void vero_se_salva_fruitore_salva_senza_fruitori_gia_presenti(){
		//elimino il file per esere sicuro di non avere altri utenti salvati sullo stesso file
		File file_eliminato= new File(Database_file.PERCORSO_FILE_FRUITORE);
		file_eliminato.delete();
		
		IO.CreaFile(Database_file.PERCORSO_FILE_FRUITORE);
		db.salva_fruitore(fruitore);	
		
		ArrayList<Fruitore> fruitori=new ArrayList<>();
		try {    
            // Reading the object from a file 
            FileInputStream file = new FileInputStream(Database_file.PERCORSO_FILE_FRUITORE); 
            ObjectInputStream in = new ObjectInputStream(file); 
              
            fruitori = (ArrayList<Fruitore>)in.readObject(); 
              
            in.close(); 
            file.close(); 
              
        }catch(Exception ex) {
        	System.out.println(ex.getMessage());
        }
		assertEquals(fruitore,fruitori.get(0),"Salvataggio di un fruitore come oggetto sul file,senza altri fruitori precedentemente salvati");
	}
	
	@Test 
	public void vero_se_salva_fruitore_salva_con_fruitori_presenti(){
		//elimino il file per esere sicuro di non avere altri utenti salvati sullo stesso file
		File file_eliminato= new File(Database_file.PERCORSO_FILE_FRUITORE);
		file_eliminato.delete();
		
		IO.CreaFile(Database_file.PERCORSO_FILE_FRUITORE);
		db.salva_fruitore(fruitore);
		db.salva_fruitore(fruitore_2);
		
		ArrayList<Fruitore> fruitori=new ArrayList<>();
		try {    
            // Reading the object from a file 
            FileInputStream file = new FileInputStream(Database_file.PERCORSO_FILE_FRUITORE); 
            ObjectInputStream in = new ObjectInputStream(file); 
              
            fruitori = (ArrayList<Fruitore>)in.readObject(); 
              
            in.close(); 
            file.close(); 
              
        }catch(Exception ex) {
        	System.out.println(ex.getMessage());
        }
		assertEquals(fruitore_2,fruitori.get(fruitori.size()-1),"Salvataggio di un fruitore come oggetto sul file,con fruitori precedentemente salvati");
	}

	@Test
	public void vero_se_salva_operatore_salva_senza_operatori_gia_presenti(){
		//elimino il file per esere sicuro di non avere altri utenti salvati sullo stesso file
		File file_eliminato= new File(Database_file.PERCORSO_FILE_OPERATORE);
		file_eliminato.delete();
		
		IO.CreaFile(Database_file.PERCORSO_FILE_OPERATORE);
		db.salva_operatore(operatore);	
		
		ArrayList<Operatore> operatori=new ArrayList<>();
		try {    
            // Reading the object from a file 
            FileInputStream file = new FileInputStream(Database_file.PERCORSO_FILE_OPERATORE); 
            ObjectInputStream in = new ObjectInputStream(file); 
              
            operatori = (ArrayList<Operatore>)in.readObject(); 
              
            in.close(); 
            file.close(); 
              
        }catch(Exception ex) {
        	System.out.println(ex.getMessage());
        }
		assertEquals(operatore,operatori.get(0),"Salvataggio di un operatore come oggetto sul file,senza altri operatori precedentemente salvati");
	}
	
	@Test 
	public void vero_se_salva_operatore_salva_con_operatori_presenti(){
		//elimino il file per esere sicuro di non avere altri utenti salvati sullo stesso file
		File file_eliminato= new File(Database_file.PERCORSO_FILE_OPERATORE);
		file_eliminato.delete();
		
		IO.CreaFile(Database_file.PERCORSO_FILE_OPERATORE);
		db.salva_operatore(operatore);
		db.salva_operatore(operatore_2);
		
		ArrayList<Operatore> operatori=new ArrayList<>();
		try {    
            // Reading the object from a file 
            FileInputStream file = new FileInputStream(Database_file.PERCORSO_FILE_OPERATORE); 
            ObjectInputStream in = new ObjectInputStream(file); 
              
            operatori = (ArrayList<Operatore>)in.readObject(); 
              
            in.close(); 
            file.close(); 
              
        }catch(Exception ex) {
        	System.out.println(ex.getMessage());
        }
		assertEquals(operatore_2,operatori.get(operatori.size()-1),"Salvataggio di un operatore come oggetto sul file,con operatori precedentemente salvati");
	}
	
	@Test
	public void vero_se_carica_tutti_utenti_ha_esito_popsitivo() {
		//elimino il file per esere sicuro di non avere altri utenti salvati sullo stesso file
		File file_eliminato= new File(Database_file.PERCORSO_FILE_UTENTE);
		file_eliminato.delete();
		
		IO.CreaFile(Database_file.PERCORSO_FILE_UTENTE);
		db.salva_utente(utente);
		db.salva_utente(utente_2);
		
		ArrayList<Utente> utenti= new ArrayList<>();
		utenti.add(utente);
		utenti.add(utente_2);
		
		assertEquals(utenti, db.carica_tutti_utenti(),"Caricamento di tutti gli utenti presenti sul file");
	}

	@Test
	public void vero_se_carica_tutti_fruitori_ha_esito_popsitivo() {
		//elimino il file per esere sicuro di non avere altri utenti salvati sullo stesso file
		File file_eliminato= new File(Database_file.PERCORSO_FILE_FRUITORE);
		file_eliminato.delete();
		
		IO.CreaFile(Database_file.PERCORSO_FILE_FRUITORE);
		db.salva_fruitore(fruitore);
		db.salva_fruitore(fruitore_2);
		
		ArrayList<Fruitore> fruitori= new ArrayList<>();
		fruitori.add(fruitore);
		fruitori.add(fruitore_2);
		
		assertEquals(fruitori, db.carica_tutti_fruitori(),"Caricamento di tutti i fruitori presenti sul file");
	}
	
	@Test
	public void vero_se_carica_tutti_operatori_ha_esito_popsitivo() {
		//elimino il file per esere sicuro di non avere altri utenti salvati sullo stesso file
		File file_eliminato= new File(Database_file.PERCORSO_FILE_OPERATORE);
		file_eliminato.delete();
		
		IO.CreaFile(Database_file.PERCORSO_FILE_OPERATORE);
		db.salva_operatore(operatore);
		db.salva_operatore(operatore_2);
		
		ArrayList<Operatore> operatori= new ArrayList<>();
		operatori.add(operatore);
		operatori.add(operatore_2);
		
		assertEquals(operatori, db.carica_tutti_operatori(),"Caricamento di tutti gli operatori presenti sul file");
	}
	
	@Test
	public void vero_se_carica_utente_non_trova_utente_poiche_file_non_ha_utenti_salvati() {
		//elimino il file per esere sicuro di non avere altri utenti salvati sullo stesso file
		File file_eliminato= new File(Database_file.PERCORSO_FILE_UTENTE);
		file_eliminato.delete();
		
		IO.CreaFile(Database_file.PERCORSO_FILE_UTENTE);
		
		assertEquals(null,db.carica_utente(utente.getUsername(), utente.getPassword()),"Caricamento nullo in quanto non vi sono utenti nel file");
	}
	
	@Test
	public void vero_se_carica_utente_trova_utente_nel_file_con_utenti_gia_presenti_username_e_password_corrispondono() {
		//elimino il file per esere sicuro di non avere altri utenti salvati sullo stesso file
		File file_eliminato= new File(Database_file.PERCORSO_FILE_UTENTE);
		file_eliminato.delete();
		
		IO.CreaFile(Database_file.PERCORSO_FILE_UTENTE);
		db.salva_utente(utente);
		
		assertEquals(utente,db.carica_utente(utente.getUsername(), utente.getPassword()),"Caricamento dell'utente corrispondete a username e password combacianti con uno presente nel file");
	}
	
	@Test
	public void vero_se_carica_utente_non_trova_utente_nel_file_con_utenti_gia_presenti_non_corrisponde_ne_username_ne_password() {
		//elimino il file per esere sicuro di non avere altri utenti salvati sullo stesso file
		File file_eliminato= new File(Database_file.PERCORSO_FILE_UTENTE);
		file_eliminato.delete();
		
		IO.CreaFile(Database_file.PERCORSO_FILE_UTENTE);
		db.salva_utente(utente);
		
		assertEquals(null,db.carica_utente(utente_2.getUsername(), utente_2.getPassword()),"Caricamento nullo in qunto non è stato trovato l'utente corrispondete a username e password combaciante nel file");
	}

	@Test
	public void vero_se_carica_utente_non_trova_utente_nel_file_con_utenti_gia_presenti_solo_username_corrisponde() {
		//elimino il file per esere sicuro di non avere altri utenti salvati sullo stesso file
		File file_eliminato= new File(Database_file.PERCORSO_FILE_UTENTE);
		file_eliminato.delete();
		
		IO.CreaFile(Database_file.PERCORSO_FILE_UTENTE);
		db.salva_utente(utente);
		
		assertEquals(null,db.carica_utente(utente.getUsername(), utente_2.getPassword()),"Caricamento dell'utente nullo in quanto combacia sul file solo con l'username");
	}
	
	@Test
	public void vero_se_carica_utente_non_trova_utente_nel_file_con_utenti_gia_presenti_solo_password_corrisponde() {
		//elimino il file per esere sicuro di non avere altri utenti salvati sullo stesso file
		File file_eliminato= new File(Database_file.PERCORSO_FILE_UTENTE);
		file_eliminato.delete();
		
		IO.CreaFile(Database_file.PERCORSO_FILE_UTENTE);
		db.salva_utente(utente);
		
		assertEquals(null,db.carica_utente(utente_2.getUsername(), utente.getPassword()),"Caricamento dell'utente nullo in quanto combacia sul file solo con la password");
	}

	@Test
	public void vero_se_carica_fruitore_non_trova_fruitore_poiche_file_non_ha_fruitori_salvati() {
		//elimino il file per esere sicuro di non avere altri utenti salvati sullo stesso file
		File file_eliminato= new File(Database_file.PERCORSO_FILE_FRUITORE);
		file_eliminato.delete();
		
		IO.CreaFile(Database_file.PERCORSO_FILE_FRUITORE);
		
		assertEquals(null,db.carica_fruitore(fruitore.getUtente().getUsername(), fruitore.getUtente().getPassword()),"Caricamento nullo in quanto non vi sono fruitori nel file");
	}
	
	@Test
	public void vero_se_carica_fruitore_trova_fruitore_nel_file_con_fruitori_gia_presenti_username_e_password_corrispondono() {
		//elimino il file per esere sicuro di non avere altri utenti salvati sullo stesso file
		File file_eliminato= new File(Database_file.PERCORSO_FILE_FRUITORE);
		file_eliminato.delete();
		
		IO.CreaFile(Database_file.PERCORSO_FILE_FRUITORE);
		db.salva_fruitore(fruitore);
		
		assertEquals(fruitore,db.carica_fruitore(fruitore.getUtente().getUsername(), fruitore.getUtente().getPassword()),"Caricamento del fruitore corrispondete a username e password combacianti con uno presente nel file");
	}
	
	@Test
	public void vero_se_carica_fruitore_non_trova_fruitore_nel_file_con_fruitori_gia_presenti_non_corrisponde_ne_username_ne_password() {
		//elimino il file per esere sicuro di non avere altri utenti salvati sullo stesso file
		File file_eliminato= new File(Database_file.PERCORSO_FILE_FRUITORE);
		file_eliminato.delete();
		
		IO.CreaFile(Database_file.PERCORSO_FILE_FRUITORE);
		db.salva_fruitore(fruitore);
		
		assertEquals(null,db.carica_fruitore(fruitore_2.getUtente().getUsername(), fruitore_2.getUtente().getPassword()),"Caricamento nullo in qunto non è stato trovato il fruitore corrispondete a username e password combaciante nel file");
	}
	
	@Test
	public void vero_se_carica_fruitore_non_trova_fruitore_nel_file_con_fruitorI_gia_presenti_solo_username_corrisponde() {
		//elimino il file per esere sicuro di non avere altri utenti salvati sullo stesso file
		File file_eliminato= new File(Database_file.PERCORSO_FILE_FRUITORE);
		file_eliminato.delete();
		
		IO.CreaFile(Database_file.PERCORSO_FILE_FRUITORE);
		db.salva_fruitore(fruitore);
		
		assertEquals(null,db.carica_fruitore(fruitore.getUtente().getUsername(), fruitore_2.getUtente().getPassword()),"Caricamento dell fruitore nullo in quanto combacia sul file solo con l'username");
	}
	
	@Test
	public void vero_se_carica_fruitore_non_trova_fruitore_nel_file_con_fruitori_gia_presenti_solo_password_corrisponde() {
		//elimino il file per esere sicuro di non avere altri utenti salvati sullo stesso file
		File file_eliminato= new File(Database_file.PERCORSO_FILE_FRUITORE);
		file_eliminato.delete();
		
		IO.CreaFile(Database_file.PERCORSO_FILE_FRUITORE);
		db.salva_utente(utente);
		
		assertEquals(null,db.carica_fruitore(fruitore_2.getUtente().getUsername(), fruitore.getUtente().getPassword()),"Caricamento del fruitore nullo in quanto combacia sul file solo con la password");
	}
	
	public void vero_se_carica_operatore_non_trova_operatore_poiche_file_non_ha_operatori_salvati() {
		//elimino il file per esere sicuro di non avere altri utenti salvati sullo stesso file
		File file_eliminato= new File(Database_file.PERCORSO_FILE_OPERATORE);
		file_eliminato.delete();
		
		IO.CreaFile(Database_file.PERCORSO_FILE_OPERATORE);
		
		assertEquals(null,db.carica_operatore(operatore.getUtente().getUsername(), operatore.getUtente().getPassword()),"Caricamento nullo in quanto non vi sono operatori nel file");
	}
	
	@Test
	public void vero_se_carica_operatore_trova_operatore_nel_file_con_operatori_gia_presenti_username_e_password_corrispondono() {
		//elimino il file per esere sicuro di non avere altri utenti salvati sullo stesso file
		File file_eliminato= new File(Database_file.PERCORSO_FILE_OPERATORE);
		file_eliminato.delete();
		
		IO.CreaFile(Database_file.PERCORSO_FILE_OPERATORE);
		db.salva_operatore(operatore);
		
		assertEquals(operatore,db.carica_operatore(operatore.getUtente().getUsername(), operatore.getUtente().getPassword()),"Caricamento dell'operatore corrispondete a username e password combacianti con uno presente nel file");
	}
	
	@Test
	public void vero_se_carica_operatore_non_trova_operatore_nel_file_con_operatori_gia_presenti_non_corrisponde_ne_username_ne_password() {
		//elimino il file per esere sicuro di non avere altri utenti salvati sullo stesso file
		File file_eliminato= new File(Database_file.PERCORSO_FILE_OPERATORE);
		file_eliminato.delete();
		
		IO.CreaFile(Database_file.PERCORSO_FILE_OPERATORE);
		db.salva_operatore(operatore);
		
		assertEquals(null,db.carica_operatore(operatore_2.getUtente().getUsername(), operatore_2.getUtente().getPassword()),"Caricamento nullo in qunto non è stato trovato l'operatore corrispondete a username e password combaciante nel file");
	}
	
	@Test
	public void vero_se_carica_operatore_non_trova_operatore_nel_file_con_operatori_gia_presenti_solo_username_corrisponde() {
		//elimino il file per esere sicuro di non avere altri utenti salvati sullo stesso file
		File file_eliminato= new File(Database_file.PERCORSO_FILE_OPERATORE);
		file_eliminato.delete();
		
		IO.CreaFile(Database_file.PERCORSO_FILE_OPERATORE);
		db.salva_operatore(operatore);
		
		assertEquals(null,db.carica_operatore(operatore.getUtente().getUsername(), operatore_2.getUtente().getPassword()),"Caricamento dell'operatore nullo in quanto combacia sul file solo con l'username");
	}
	
	@Test
	public void vero_se_carica_operatore_non_trova_operatore_nel_file_con_operatori_gia_presenti_solo_password_corrisponde() {
		//elimino il file per esere sicuro di non avere altri utenti salvati sullo stesso file
		File file_eliminato= new File(Database_file.PERCORSO_FILE_OPERATORE);
		file_eliminato.delete();
		
		IO.CreaFile(Database_file.PERCORSO_FILE_OPERATORE);
		db.salva_operatore(operatore);
		
		assertEquals(null,db.carica_operatore(operatore_2.getUtente().getUsername(), operatore.getUtente().getPassword()),"Caricamento dell'operatore nullo in quanto combacia sul file solo con la password");
	}
	
	@Test 
	public void vero_se_reset_utenti_resetta_il_file_con_un_novo_set_di_utenti() {
		File file_eliminato= new File(Database_file.PERCORSO_FILE_UTENTE);
		file_eliminato.delete();
		
		IO.CreaFile(Database_file.PERCORSO_FILE_UTENTE);
		db.salva_utente(utente);
		db.salva_utente(utente_2);
		
		ArrayList<Utente> resettato= new ArrayList<>();
		resettato.add(utente);
		
		db.reset_utenti(resettato);
		
		assertEquals(resettato, db.carica_tutti_utenti(),"Il file è stato resettato con gli utenti desiderati");
	}
	
	@Test 
	public void vero_se_reset_fruitori_resetta_il_file_con_un_novo_set_di_fruitori() {
		File file_eliminato= new File(Database_file.PERCORSO_FILE_FRUITORE);
		file_eliminato.delete();
		
		IO.CreaFile(Database_file.PERCORSO_FILE_FRUITORE);
		db.salva_fruitore(fruitore);
		db.salva_fruitore(fruitore_2);
		
		ArrayList<Fruitore> resettato= new ArrayList<>();
		resettato.add(fruitore);
		
		db.reset_fruitori(resettato);
		
		assertEquals(resettato, db.carica_tutti_fruitori(),"Il file è stato resettato con i fruitori desiderati");
	}
	
	@Test 
	public void vero_se_reset_operatori_resetta_il_file_con_un_novo_set_di_operatori() {
		File file_eliminato= new File(Database_file.PERCORSO_FILE_OPERATORE);
		file_eliminato.delete();
		
		IO.CreaFile(Database_file.PERCORSO_FILE_OPERATORE);
		db.salva_operatore(operatore);
		db.salva_operatore(operatore_2);
		
		ArrayList<Operatore> resettato= new ArrayList<>();
		resettato.add(operatore);
		
		db.reset_operatori(resettato);
		
		assertEquals(resettato, db.carica_tutti_operatori(),"Il file è stato resettato con gli operatori desiderati");
	}

	@Test
	public void vero_se_elimina_utente_non_modifica_il_file_se_non_trova_utente_da_eliminare() {
		File file_eliminato= new File(Database_file.PERCORSO_FILE_UTENTE);
		file_eliminato.delete();
		
		IO.CreaFile(Database_file.PERCORSO_FILE_UTENTE);
		
		db.salva_utente(utente);
		ArrayList<Utente> prima= new ArrayList<>();
		prima =db.carica_tutti_utenti();
		
		db.elimina_utente(utente_2);
		ArrayList<Utente> dopo= new ArrayList<>();
		dopo=db.carica_tutti_utenti();
		
		assertEquals(prima,dopo,"Il File non è stato modificato in qunato l'utente da elimanre non era presente");
	}
	
	@Test
	public void vero_se_elimina_utente_elimina_utente_selezionato() {
		File file_eliminato= new File(Database_file.PERCORSO_FILE_UTENTE);
		file_eliminato.delete();
		
		IO.CreaFile(Database_file.PERCORSO_FILE_UTENTE);
		
		db.salva_utente(utente);
		
		db.elimina_utente(utente);
		ArrayList<Utente> dopo= new ArrayList<>();
		dopo=db.carica_tutti_utenti();
		
		assertTrue(dopo.isEmpty(),"Il File è stato modificato eliminado l'utente selezionato");
	}
	
	@Test
	public void vero_se_elimina_fruitore_non_modifica_il_file_se_non_trova_fruitore_da_eliminare() {
		File file_eliminato= new File(Database_file.PERCORSO_FILE_FRUITORE);
		file_eliminato.delete();
		
		IO.CreaFile(Database_file.PERCORSO_FILE_FRUITORE);
		
		db.salva_utente(utente);
		ArrayList<Fruitore> prima= new ArrayList<>();
		prima =db.carica_tutti_fruitori();
		
		db.elimina_fruitore(fruitore_2);
		ArrayList<Fruitore> dopo= new ArrayList<>();
		dopo=db.carica_tutti_fruitori();
		
		assertEquals(prima,dopo,"Il File non è stato modificato in qunato il fruitore da elimanre non era presente");
	}
	
	@Test
	public void vero_se_elimina_fruitore_elimina_fruitore_selezionato() {
		File file_eliminato= new File(Database_file.PERCORSO_FILE_FRUITORE);
		file_eliminato.delete();
		
		IO.CreaFile(Database_file.PERCORSO_FILE_FRUITORE);
		
		db.salva_fruitore(fruitore);
		
		db.elimina_fruitore(fruitore);
		ArrayList<Fruitore> dopo= new ArrayList<>();
		dopo=db.carica_tutti_fruitori();
		
		assertTrue(dopo.isEmpty(),"Il File è stato modificato eliminado il fruitore selezionato");
	}
	
	@Test
	public void vero_se_elimina_operatore_non_modifica_il_file_se_non_trova_fruitore_da_eliminare() {
		File file_eliminato= new File(Database_file.PERCORSO_FILE_OPERATORE);
		file_eliminato.delete();
		
		IO.CreaFile(Database_file.PERCORSO_FILE_OPERATORE);
		
		db.salva_operatore(operatore);
		ArrayList<Operatore> prima= new ArrayList<>();
		prima =db.carica_tutti_operatori();
		
		db.elimina_operatore(operatore_2);
		ArrayList<Operatore> dopo= new ArrayList<>();
		dopo=db.carica_tutti_operatori();
		
		assertEquals(prima,dopo,"Il File non è stato modificato in qunato l'operatore da elimanre non era presente");
	}
	
	@Test
	public void vero_se_elimina_operatore_elimina_operatore_selezionato() {
		File file_eliminato= new File(Database_file.PERCORSO_FILE_OPERATORE);
		file_eliminato.delete();
		
		IO.CreaFile(Database_file.PERCORSO_FILE_OPERATORE);
		
		db.salva_operatore(operatore);
		
		db.elimina_operatore(operatore);
		ArrayList<Operatore> dopo= new ArrayList<>();
		dopo=db.carica_tutti_operatori();
		
		assertTrue(dopo.isEmpty(),"Il File è stato modificato eliminado l'operatore selezionato");
	}
	
	@Test
	public void vero_se_aggiorna_validita_fruitori_non_elimina_fruitori_non_piu_validi_poiche_non_vi_sono_fruitori_sul_file() {
		File file_eliminato= new File(Database_file.PERCORSO_FILE_FRUITORE);
		file_eliminato.delete();
		
		IO.CreaFile(Database_file.PERCORSO_FILE_FRUITORE);
		
		db.aggiorna_validita_fruitori();
		
		assertTrue(db.carica_tutti_fruitori().isEmpty(),"Aggiornare la valida dei fruitori non modifica il file in qunato non vi erano fruitori gia presenti sul file");
	}
	
	@Test
	public void vero_se_aggiorna_validita_fruitori_non_elimina_fruitori_non_piu_validi_poiche_sono_tutti_validi() {
		File file_eliminato= new File(Database_file.PERCORSO_FILE_FRUITORE);
		file_eliminato.delete();
		
		IO.CreaFile(Database_file.PERCORSO_FILE_FRUITORE);
		
		fruitore.setData_fine_iscrizione(LocalDateTime.now().plusDays(1));
			
		db.salva_fruitore(fruitore);
		ArrayList<Fruitore> prima= new ArrayList<>();
		prima.add(fruitore);
		
		db.aggiorna_validita_fruitori();
		
		assertEquals(prima,db.carica_tutti_fruitori(),"Aggiornare la valida dei fruitori non modifica il file in qunato i fruitoti presenti erano tutti validi");
	}
	
	@Test
	public void vero_se_aggiorna_validita_fruitori_elimina_fruitori_non_piu_validi() {
		File file_eliminato= new File(Database_file.PERCORSO_FILE_FRUITORE);
		file_eliminato.delete();
		
		IO.CreaFile(Database_file.PERCORSO_FILE_FRUITORE);
		
		fruitore.setData_fine_iscrizione(LocalDateTime.now().minusDays(1));//se si mette solo il setvalidita il codice lo ripristina al valore corretto secondo la logica, quindi bisogna avere un oggetto effetivamnete scaduto 
		
		db.salva_fruitore(fruitore);
		ArrayList<Fruitore> prima= new ArrayList<>();
		prima.add(fruitore);
		
		db.aggiorna_validita_fruitori();
		
		assertTrue(db.carica_tutti_fruitori().isEmpty(),"Aggiornare la valida dei fruitori modifica il file eliminando i fruitori non piu validi");
	}

	@Test
	public void vero_se_is_presente_trova_utente() {
		File file_eliminato= new File(Database_file.PERCORSO_FILE_UTENTE);
		file_eliminato.delete();
		
		IO.CreaFile(Database_file.PERCORSO_FILE_UTENTE);
		
		db.salva_utente(utente);
		
		assertTrue(db.is_presente(utente));
	}

	@Test
	public void vero_se_is_presente_non_trova_utente() {
		File file_eliminato= new File(Database_file.PERCORSO_FILE_UTENTE);
		file_eliminato.delete();
		
		IO.CreaFile(Database_file.PERCORSO_FILE_UTENTE);
		
		db.salva_utente(utente);
		
		assertFalse(db.is_presente(utente_2));
	}

}
