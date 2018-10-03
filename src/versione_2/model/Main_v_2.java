package versione_2.model;

import versione_2.controller.Controller;

public class Main_v_2 {

	public static void main(String[] args) {
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
		Risorsa r3=new Libro(3,4);
		Risorsa r4=new Libro(4,4);
		
		
		fantasy.add_risorsa(r1);
		fantasy.add_risorsa(r2);
		
		
		Database_file db= new Database_file();
		db.salva_categoria_root(risorse);
		
		
		Controller c= new Controller();
		c.log_in();
		
	}

}