package versione_5.model;

import java.time.LocalDateTime;
import java.util.Map;

public class Query {

	/**
	 * Classe che si occupa della gestione delle interrogazioni al database
	 */
	Salvataggio db;
	
	
	
	public Query(Salvataggio db) {
		this.db = db;
	}

	/**
	 * Conta il numero di prestiti per anno solare preso in ingresso
	 * 
	 * @param anno solare in cui contare i prestiti
	 * @return	il numero di prestiti effettuati in un anno solare 
	 */
	 public int count_numero_di_prestiti_per_anno_solare(LocalDateTime anno) {
		 db.carica_tutti_prestiti();//sono tutti i prestiti ?
		return 0;
		 
	 }
	 
	 /**
	  * Conta il numero di proroghe effettuate in un anno solare preso in ingresso
	  * 
	  * @param anno solare in cui contare le proroghe
	  * @return	il numero di proroghe effettaute in un anno solare
	  */
	 public int count_numero_di_proroghe_per_anno_solare(LocalDateTime anno) {
		return 0;
		 
	 }
	 
	 /**
	  * Seleziona la risorsa che è stata prestata piu volte in un anno solare passato in ingresso,
	  * 
	  * @param anno solare dentro cui cercare
	  * @return	la risorsa con il massimo numero di prestiti associati o null altrimenti,
	  * 		nel caso di parità di massimo ne viene restituito uno solo
	  *			//TODO una o piu??
	  */
	 public Risorsa select_risorsa_con_max_numero_prestiti(LocalDateTime anno) {
		return null;
		 
	 }
	 
	 /**
	  * Seleziona per ogni fruitore che ha dei prestiti il quantitativo di prestiti effettuati in un anno solare passato in ingresso
	  * 
	  * @param anno solare dentro il cui cercare
	  * @return un'associazione fra un Fruitore e il numero di prestiti ad esso relativo
	  */
	 public Map<Fruitore, Integer> select_count_numero_di_prestiti_perogni_fruitore(LocalDateTime anno) {
		return null;
		 
	 }
}
