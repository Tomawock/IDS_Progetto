package versione_2.model;

import java.util.ArrayList;

public class Categoria {
	String nome;
		
	ArrayList<Risorsa> risorse;
	ArrayList<Categoria> sottocaotegorie; 
	
	public ArrayList<Risorsa> vislualizza_risorse(){
		return risorse;
		
	}
}
