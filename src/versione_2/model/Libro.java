package versione_2.model;

import java.util.ArrayList;

public class Libro  implements Risorsa{
	
	private int n_licenze;
	private String id_libro;
	//private id_inivoco= id_libro+n_licenza
	

	private String titolo; 
	private String autore;
	private String numero_di_pagine; 
	private String anno_di_pubblicazione; 
	private String casa_editrice;
	private String lingua;
	private String genere;

	@Override
	public void aggiungi_descrizione(ArrayList<String> dati) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rimuovi_descrizione() {
		// TODO Auto-generated method stub
		
	}

}
