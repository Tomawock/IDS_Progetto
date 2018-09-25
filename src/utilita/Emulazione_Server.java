package utilita;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

import versione_3.model.*;

public class Emulazione_Server {
	
	public static void inizializza() {
		
		
		
		Categoria risorse=new Categoria("File_multimediali");
		Categoria libri=new Categoria("Libri");
		risorse.add_sottocategoria(libri);
		//cartella libri
		Categoria horror=new Categoria("Horror");
		Categoria fantasy=new Categoria("Fantasy");
		
		Utente u=new Utente("test", "test", "test",  LocalDateTime.of(1999,12,12,0,0) ,"test", "test", "test");
		Utente u2=new Utente("test2", "test2", "test2",  LocalDateTime.of(1999,12,12,0,0) ,"test2", "test2", "test2");
		
		Fruitore f=new Fruitore(u);
		Fruitore f2=new Fruitore(u2);
		
		Operatore o=new Operatore(u);
		Operatore o2=new Operatore(u2);
		
		
		libri.add_sottocategoria(horror);
		libri.add_sottocategoria(fantasy);
		
		Risorsa r1=new Libro(1,1);
		Risorsa r2=new Libro(2,3);
		Risorsa r3=new Libro(3,3);
		Risorsa r4=new Libro(4,0);
		
		r1.aggiungi_descrizione(new ArrayList<>(Arrays.asList("Alla ricerca di Nemo",
								"Denis Barbas",
								"2",
								"1950",
								"Doina",
								"Protoghese",
								"Horror")));
		
		r2.aggiungi_descrizione(new ArrayList<>(Arrays.asList("Il diario di zen",
				"Zen",
				"1000",
				"1999",
				"Zanichelli",
				"Arabo",
				"Fantasy")));
		
		r3.aggiungi_descrizione(new ArrayList<>(Arrays.asList("Temo",
				"Denis Barbas",
				"123",
				"1900",
				"Satana",
				"japponese",
				"Fantasy")));
		
		fantasy.add_risorsa(r1);
		fantasy.add_risorsa(r3);
		horror.add_risorsa(r2);
		horror.add_risorsa(r4);
		
		Prestito p=new Prestito(r1, f);
		Prestito p2=new Prestito(r2, f);
		
		p.setData_fine_prestito(LocalDateTime.now());
		
		Database_file db= new Database_file();
		db.reset_utenti(new ArrayList<>(Arrays.asList(u,u2)));
		db.reset_fruitori(new ArrayList<>(Arrays.asList(f,f2)));
		db.reset_operatori(new ArrayList<>(Arrays.asList(o,o2)));
		db.reset_prestiti(new ArrayList<>(Arrays.asList(p,p2)));
		db.salva_categoria_root(risorse);
	}

}
