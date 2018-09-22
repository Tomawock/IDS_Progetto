package versione_2.model;

import java.util.ArrayList;

import utilita.Costanti;

public class Libro  extends Risorsa{	

	private String titolo; 
	private String autore;
	private String numero_di_pagine; 
	private String anno_di_pubblicazione; 
	private String casa_editrice;
	private String lingua;
	private String genere;
	
	
	@Override
	public void aggiungi_descrizione(ArrayList<String> dati) {
		this.titolo=dati.get(0);
		this.autore=dati.get(1);
		this.numero_di_pagine=dati.get(2);
		this.anno_di_pubblicazione=dati.get(3);
		this.casa_editrice=dati.get(4);
		this.lingua=dati.get(5);
		this.genere=dati.get(6);		
	}
	
	@Override
	public void rimuovi_descrizione() {
		this.titolo=Costanti.NO_DESCRIZIONE;
		this.autore=Costanti.NO_DESCRIZIONE;
		this.numero_di_pagine=Costanti.NO_DESCRIZIONE;
		this.anno_di_pubblicazione=Costanti.NO_DESCRIZIONE;
		this.casa_editrice=Costanti.NO_DESCRIZIONE;
		this.lingua=Costanti.NO_DESCRIZIONE;
		this.genere=Costanti.NO_DESCRIZIONE;		
	}
	
	@Override
	public String toString() {
		return " ***** Titolo Libro: " + titolo + ", Autore: " + autore + ", Numero di Pagine: " + numero_di_pagine
				+ ", Anno di Pubblicazione: " + anno_di_pubblicazione + ", Casa Editrice: " + casa_editrice + ", Lingua: "
				+ lingua + ", Genere: " + genere +", "+ super.toString()+"  ***** ";
	}

}
