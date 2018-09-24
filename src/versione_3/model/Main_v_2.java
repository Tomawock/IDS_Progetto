package versione_3.model;

import java.util.ArrayList;
import java.util.Arrays;

import versione_3.controller.Controller;

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
		
		Risorsa r1=new Libro(1);
		Risorsa r2=new Libro(2);
		Risorsa r3=new Libro(3);
		Risorsa r4=new Libro(4);
		
		r1.set_n_licenze(1);
		r2.set_n_licenze(5);
		r3.set_n_licenze(5);
		r4.set_n_licenze(5);
		
		fantasy.add_risorsa(r1);
		fantasy.add_risorsa(r2);
		horror.add_risorsa(r3);
		horror.add_risorsa(r4);
		
		
		Database_file db= new Database_file();
		db.salva_categoria_root(risorse);
		
		
		Controller c= new Controller();
		c.log_in();
		
	}

}