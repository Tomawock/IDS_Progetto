package versione_5.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Categoria implements Serializable{
	
	/**
	 * Numero seriale per la serializzazione dei dati su File
	 */
	private static final long serialVersionUID = 4L;

	private String nome;
		
	ArrayList<Risorsa> risorse;				//aka dati
	ArrayList<Categoria> sottocategorie; 	//aka figli
	
	
	
	public Categoria(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Viene agginta una risorsa in questa categoria
	 * @param risorsa nel caso sia null, viene creato anche l'array lists che la contiene
	 */
	public void add_risorsa(Risorsa risorsa) {
		if(risorse==null) {
			this.risorse=new ArrayList<Risorsa>();
			this.risorse.add(risorsa);
		}else
			this.risorse.add(risorsa);
	}
	
	/**
	 * Viene agginta una sottocategoria in questa categoria(sottocategria= sottocartella sul server)
	 * @param categoria nel caso sia null, viene creato anche l'array lists che la contiene
	 */
	public void add_sottocategoria(Categoria categoria) {
		if(sottocategorie==null) {
			this.sottocategorie=new ArrayList<Categoria>();
			this.sottocategorie.add(categoria);
		}else
			this.sottocategorie.add(categoria);
	}
	
	/**
	 * La funzione è ricorsiva se ci sono due categorie uguali mi ritorna la prima occorrenza
	 * si puo migliorare

	 * @param nome nome della sottocategoria
	 * @return null nel caso non ci siano sottocategorie o non sia stata trovata, 
	 * 			altrimenti riorna la categoria con il nome preso come input 
	 */
	public Categoria get_sottocategoria_by_name(Categoria base,String nome) {
		if (base.getNome().equals(nome)) {
			return base;
		}else {
			if(base.getSottocategorie()!=null) {
				for(Categoria c:base.getSottocategorie()) {
					Categoria risultato=c.get_sottocategoria_by_name(c, nome);
						if( risultato!=null)
							return risultato;
				}
			}
		}
		return null;
	}
	
	/**
	 * Cerca la risorsa in base al suo ID
	 * 
	 * @param base 	Categoria dalla quale incomincia la ricerca della risorsa
	 * @param id 	id della risorsa da cercare
	 * @return null nel caso in cui non sia stata trovata la Risorsa corrispondente all'ID preso in ingresso
	 */
	public Risorsa get_risorsa_by_id(Categoria base,int id) {
		if (base.getSottocategorie()==null) {
			if(base.getRisorse()!=null) {
				for (Risorsa r: base.getRisorse()) {
					if(r.get_id()==id) return r;
				}
			}
		}else {
			for(Categoria c:base.getSottocategorie()){
				Risorsa risultato=c.get_risorsa_by_id(c, id);
				if( risultato!=null)
					return risultato;
					
			}
		}
		return null;
	}
	
	/**
	 * Due categorie sono uguali quando hanno lo stesso Nome
	 */
	@Override
	public boolean equals(Object obj) {
		Categoria c=(Categoria)obj;
		if(c.getNome()==this.nome) {
			return true;
		}
		return false;
	}
	
	/**
	 * Data una certa categoria riempie risultato con  tutte le risorse presenti nella categoria e nelle sue sotto
	 * categorie in modo RICORSIVO
	 * 
	 * @param root		Categoria dalla quale incomincia la ricerca delle risorse
	 * @param risultato	Parametro che contiene tutte le risorse della categoria root e sottocategorie di essa
	 */
	public void carica_tutte_risorse(Categoria root,ArrayList<Risorsa> risultato) {
		if (root.getRisorse()!=null && risultato!=null) {//perche risultato != null a che serve ??
			risultato.addAll(root.getRisorse());
		}else {
			if(root.getSottocategorie()!=null) {
				for(Categoria c: root.getSottocategorie() ){
					c.carica_tutte_risorse(c, risultato);
				}
			}
		}
	}

	@Override
	public String toString() {
		return "Categoria " + nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Risorsa> getRisorse() {
		return risorse;
	}

	public void setRisorse(ArrayList<Risorsa> risorse) {
		this.risorse = risorse;
	}

	public ArrayList<Categoria> getSottocategorie() {
		return sottocategorie;
	}

	public void setSottocategorie(ArrayList<Categoria> sottocategorie) {
		this.sottocategorie = sottocategorie;
	}
}
