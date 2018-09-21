package versione_2.model;

import java.util.ArrayList;

public class Categoria {
	
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
	 * @param nome nome della sottocategoria
	 * @return null nel caso non ci siano sottocategorie o non sia stata trovata, 
	 * 			altrimenti riorna la categoria con il nome preso come input 
	 */
	public Categoria get_sottocategoria_by_name(String nome) {
		if (sottocategorie==null) {
			return null;//caso nel quale non ci sono sottocategorie
		}
		for(Categoria c:sottocategorie) {
			if(c.equals(new Categoria(nome))) {
				return c;
			}
			if(c.getSottocategorie().contains(new Categoria(nome))) {//posso usare il contains in quanto ho definito che 2 oggetti sono uguali se hanno los tesso nome
				//System.out.println("SEI NELLA CATEGORIA "+c.getNome());
				return c.getSottocategorie().get(c.getSottocategorie().indexOf(new Categoria(nome)));
			}
		}
		return new Categoria("Errore nella ricorsione");
	}
	
	@Override
	public boolean equals(Object obj) {
		Categoria c=(Categoria)obj;
		if(c.getNome()==this.nome) {
			return true;
		}
		return false;
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
		
		risorse.getSottocategorie().get(0).add_sottocategoria(new Categoria("Horror"));
		risorse.getSottocategorie().get(0).add_sottocategoria(new Categoria("Fantasy"));
		
		risorse.getSottocategorie().get(1).add_sottocategoria(new Categoria("Documentari"));
		risorse.getSottocategorie().get(1).add_sottocategoria(new Categoria("Animati"));
		
		System.out.println(risorse.getSottocategorie().get(0).get_sottocategoria_by_name("Fantasy").toString());
		
	}
}
