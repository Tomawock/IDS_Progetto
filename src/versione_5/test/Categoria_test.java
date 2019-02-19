package versione_5.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import versione_5.model.*;

class Categoria_test {
	
	Risorsa ris,ris2;
	Categoria categoria,sotto_categoria;
	ArrayList<Risorsa> risorse;
	ArrayList<Categoria> sotto_categorie;
	
	/**
	 * inizzializzo oggetti per i test
	 */
	@BeforeEach
	public void setup() {
		//per i test di code coverange uso Film come classe concreta
		ris=new Film(1,1);
		ris2=new Film(2,1);
		
		categoria= new Categoria("Test");
		sotto_categoria= new Categoria("Test_sottocategoria");
		
		risorse=new ArrayList<>();
		sotto_categorie = new ArrayList<>();
	}
	
	/**
	 * Test di copertura del codice delle funzioni principali
	 */
	@Test
	public void vero_se_add_risorsa_aggiunge_una_risorsa_arraylist_era_null() {
		categoria.setRisorse(null);
		categoria.add_risorsa(ris);
		assertFalse(categoria.getRisorse().isEmpty(),"Aggiunta una risorsa alla Categoria, il vettore di base era nullo");
	}
	
	@Test
	public void vero_se_add_risorsa_aggiunge_una_risorsa_arraylist_non_era_null() {
		categoria.setRisorse(risorse);
		categoria.add_risorsa(ris);
		assertFalse(categoria.getRisorse().isEmpty(),"Aggiunta una risorsa alla Categoria, il vettore di base non era nullo");
	}
	
	@Test
	public void vero_se_add_sottocategoria_aggiunge_una_categoria__arraylist_era_null() {
		categoria.setSottocategorie(null);
		categoria.add_sottocategoria(sotto_categoria);
		assertFalse(categoria.getSottocategorie().isEmpty(),"Aggiunge una sottocategoria, il vettore di base era nullo");
	}
	
	@Test
	public void vero_se_add_sottocategoria_aggiunge_una_categoria__arraylist_non_era_null() {
		categoria.setSottocategorie(sotto_categorie);
		categoria.add_sottocategoria(sotto_categoria);
		assertFalse(categoria.getSottocategorie().isEmpty(),"Aggiunge una sottocategoria, il vettore di base non era nullo");
	}
	
}
