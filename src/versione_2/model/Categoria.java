package versione_2.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Categoria implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4L;

	private String nome;
		
	ArrayList<Risorsa> risorse;
	ArrayList<Categoria> sottocategorie; 
	
	
	
	public Categoria(String nome) {
		this.nome = nome;
	}
	
	public void add_risorsa(Risorsa risorsa) {
		if(risorse==null) {
			this.risorse=new ArrayList<Risorsa>();
			this.risorse.add(risorsa);
		}else
			this.risorse.add(risorsa);
	}
	
	public void add_sottocategoria(Categoria categoria) {
		if(sottocategorie==null) {
			this.sottocategorie=new ArrayList<Categoria>();
			this.sottocategorie.add(categoria);
		}else
			this.sottocategorie.add(categoria);
	}
	
	/**
	 * La funzione è ricorsiva se ci sono due categorie uguali mi ritorna la prima occorrenza
	 * 
	 * 
	 * 
	 * si puo migliorare
	 * 
	 * 
	 * 
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
	
	
	
	
	public Risorsa get_risorsa_by_id(Categoria base,int id) {
		if (base.getSottocategorie()==null) {
			for (Risorsa r: base.getRisorse()) {
				if(r.get_id()==id) return r;
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
	
	
	@Override
	public boolean equals(Object obj) {
		Categoria c=(Categoria)obj;
		if(c.getNome()==this.nome) {
			return true;
		}
		return false;
	}

	public void carica_tutte_risorse(Categoria root,ArrayList<Risorsa> risultato) {
		if (root.getRisorse()!=null && risultato!=null) {
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

	//Serve come visualizza risorse
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

	public static void main(String[] args) {
		Categoria risorse=new Categoria("Risorse");
		risorse.add_sottocategoria(new Categoria("Libri"));
		risorse.add_sottocategoria(new Categoria("Film"));
		//cartella libri
		risorse.getSottocategorie().get(0).add_sottocategoria(new Categoria("Horror"));
		risorse.getSottocategorie().get(0).add_sottocategoria(new Categoria("Fantasy"));
		//
		risorse.getSottocategorie().get(1).add_sottocategoria(new Categoria("Documentari"));
		risorse.getSottocategorie().get(1).add_sottocategoria(new Categoria("Animati"));
		
		System.out.println(risorse.get_sottocategoria_by_name(risorse.getSottocategorie().get(0),"Fantasy").toString());
		
		//Risorsa in horror
		risorse.getSottocategorie().get(0).getSottocategorie().get(1).add_risorsa(new Film(1));
		risorse.getSottocategorie().get(0).getSottocategorie().get(0).add_risorsa(new Libro(2));
		System.out.println(risorse.get_risorsa_by_id(risorse, 1) instanceof Libro);
		
	}
}
