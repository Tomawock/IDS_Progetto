package versione_5.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import utilita.IO;
import versione_5.model.*;

class Query_test {

	public static final String ROOT= "ROOT";

	private Query query;
	private Database_file db;
	private Utente utente,utente_2;
	private Fruitore fruitore,fruitore_2;
	private Operatore operatore, operatore_2;
	private Prestito prestito,prestito_2;
	private Risorsa risorsa,risorsa_2,risorsa_tipo_diversa;
	private Categoria root;
	
	@BeforeEach
	public void setup() {		
		db=new Database_file();
		
		query = new Query(db);
		
		utente=new Utente("test", "test", "test",  LocalDateTime.of(2012,12,12,0,0) ,"test", "test", "test");
		utente_2=new Utente("test2", "test2", "test2",  LocalDateTime.of(2012,12,12,0,0) ,"test2", "test2", "test2");
		
		fruitore=new Fruitore(utente);
		fruitore_2=new Fruitore(utente_2);
		
		operatore=new Operatore(utente);
		operatore_2=new Operatore(utente_2);
		
		root = new Categoria(Database_file_test.ROOT);
		
		risorsa = new Film(1,1);
		risorsa_2 = new Film(2,1);
		risorsa_tipo_diversa = new Libro(1,1);
		
		prestito =new Prestito(risorsa, fruitore);
		prestito_2 =new Prestito(risorsa_2, fruitore_2);
	}
	
	@Test
	public void vero_se_count_numero_di_prestiti_per_anno_solare_ritorna_zero_se_non_sono_presenti_prestiti_nell_anno_solare_prescelto() {
		//elimino il file per esere sicuro di non avere altri utenti salvati sullo stesso file
		File file_eliminato= new File(Database_file.PERCORSO_FILE_PRESTITI);
		file_eliminato.delete();
		
		db.salva_prestito(prestito);
		
		IO.CreaFile(Database_file.PERCORSO_FILE_PRESTITI);
		
		assertEquals(0,query.count_numero_di_prestiti_per_anno_solare(LocalDateTime.of(2012,12,12,0,0)),"Il numero di prestiti nell'anno solare corrente è 0 poiche non vi sono salvataggi nell'anno selezionato");
	}
	
	@Test
	public void vero_se_count_numero_di_prestiti_per_anno_solare_ritorna_il_numero_di_prestiti_effettuati_nell_anno_solare_prescelto() {
		//elimino il file per esere sicuro di non avere altri utenti salvati sullo stesso file
		File file_eliminato= new File(Database_file.PERCORSO_FILE_PRESTITI);
		file_eliminato.delete();
		
		db.salva_prestito(prestito);
		
		IO.CreaFile(Database_file.PERCORSO_FILE_PRESTITI);
		
		assertEquals(1,query.count_numero_di_prestiti_per_anno_solare(LocalDateTime.now()),"Il numero di prestiti nell'anno solare corrente è 0 poiche non vi sono salvataggi nell'anno selezionato");
	}

}
