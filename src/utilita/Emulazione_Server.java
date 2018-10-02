package utilita;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

import versione_4.model.*;

public class Emulazione_Server {
	
	public static void inizializza() {
		
		
		
		Categoria risorse=new Categoria("File_multimediali");
		
		Categoria libri=new Categoria("Libri");
		Categoria film=new Categoria("Film");
		
		risorse.add_sottocategoria(libri);
		risorse.add_sottocategoria(film);
		//cartella libri
		Categoria horror=new Categoria("Horror");
		Categoria fantasy=new Categoria("Fantasy");
		
		Categoria horror_f=new Categoria("Horror");
		Categoria fantasy_f=new Categoria("Fantasy");
		
		Utente u=new Utente("test", "test", "test",  LocalDateTime.of(1999,12,12,0,0) ,"test", "test", "test");
		Utente u2=new Utente("test2", "test2", "test2",  LocalDateTime.of(1999,12,12,0,0) ,"test2", "test2", "test2");
		
		Fruitore f=new Fruitore(u);
		Fruitore f2=new Fruitore(u2);
		
		Operatore o=new Operatore(u);
		Operatore o2=new Operatore(u2);
		
		
		libri.add_sottocategoria(horror);
		libri.add_sottocategoria(fantasy);
		
		film.add_sottocategoria(horror_f);
		film.add_sottocategoria(fantasy_f);
		
		Risorsa r1=new Libro(1,1);
		Risorsa r2=new Libro(2,3);
		Risorsa r3=new Libro(3,3);
		Risorsa r4=new Libro(4,0);
		
		Risorsa r5=new Film(5,1);
		Risorsa r6=new Film(6,3);
		Risorsa r7=new Film(7,23);
		Risorsa r8=new Film(8,0);
		
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
		
		r5.aggiungi_descrizione(new ArrayList<>(Arrays.asList("Film 1",
								"Regista 1",
								"1",
								"1901",
								"Genere 1"
								)));
		
		r6.aggiungi_descrizione(new ArrayList<>(Arrays.asList("Film 2",
				"Regista 2",
				"2",
				"1902",
				"Genere 2"
				)));
		
		libri.get_sottocategoria_by_name(libri, "Horror").add_risorsa(r1);
		libri.get_sottocategoria_by_name(libri, "Horror").add_risorsa(r2);
		libri.get_sottocategoria_by_name(libri, "Fantasy").add_risorsa(r3);
		libri.get_sottocategoria_by_name(libri, "Fantasy").add_risorsa(r4);
		
		film.get_sottocategoria_by_name(film, "Horror").add_risorsa(r5);
		film.get_sottocategoria_by_name(film, "Horror").add_risorsa(r6);
		film.get_sottocategoria_by_name(film, "Fantasy").add_risorsa(r7);
		film.get_sottocategoria_by_name(film, "Fantasy").add_risorsa(r8);
//		fantasy.add_risorsa(r1);
//		fantasy.add_risorsa(r3);
//		horror.add_risorsa(r2);
//		horror.add_risorsa(r4);
		
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
