package utilita;

import java.util.ArrayList;
import java.util.Arrays;

import versione_3.model.Categoria;
import versione_3.model.Database_file;
import versione_3.model.Libro;
import versione_3.model.Risorsa;

public class Emulazione_Server {
	
	public static void inizializza() {
		Categoria risorse=new Categoria("File_multimediali");
		Categoria libri=new Categoria("Libri");
		risorse.add_sottocategoria(libri);
		//cartella libri
		Categoria horror=new Categoria("Horror");
		Categoria fantasy=new Categoria("Fantasy");
		
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
		
		fantasy.add_risorsa(r1);
		fantasy.add_risorsa(r3);
		horror.add_risorsa(r2);
		horror.add_risorsa(r4);
		
		
		
		Database_file db= new Database_file();
		db.salva_categoria_root(risorse);
	}

}
