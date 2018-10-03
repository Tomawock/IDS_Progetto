package versione_5.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
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
		 ArrayList<Prestito> prestiti_archiviati=db.carica_tutti_prestiti();//sono tutti i prestiti ? perchè questi sarebbero quelli "locali e non dell'archivio COME DIO CANE LA FAMO STA COSA"
		 int res=0;
		 for(Prestito p:prestiti_archiviati) {
			 if(p.getData_inizio_prestito().getYear()==anno.getYear()) {
				 res++;
			 }
		 }
		 
		return res;
		 
	 }
	 
	 /**
	  * Conta il numero di proroghe effettuate in un anno solare preso in ingresso
	  * 
	  * @param anno solare in cui contare le proroghe
	  * @return	il numero di proroghe effettaute in un anno solare
	  */
	 public int count_numero_di_proroghe_per_anno_solare(LocalDateTime anno) {
		 ArrayList<Prestito> prestiti_archiviati=db.carica_tutti_prestiti();//sono tutti i prestiti ? perchè questi sarebbero quelli "locali e non dell'archivio COME DIO CANE LA FAMO STA COSA"
		 int res=0;
		 for(Prestito p:prestiti_archiviati) {
			 if(p.getData_inizio_proroga()!=null) {
				 if(p.getData_inizio_proroga().getYear()==anno.getYear()) {
					 res++;
				 }
				 
			 }
		 }
		 
		return res; 
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
		ArrayList<Prestito> prestiti_archiviati=db.carica_tutti_prestiti();
		HashMap<Risorsa, Integer> risultato= new HashMap<Risorsa, Integer>();
		 for(Prestito p:prestiti_archiviati) {//prende tutti i prestiti
			Risorsa risorsa=p.getRisorsa();//seleziona unarisrsa
			Integer num_ripetizioni_risorsa=0;//valore del conteggio delle ripetizioni della risorsa
			if(!risultato.containsKey(risorsa)) {//se non contiene la chiave allora è una nuova risorsa altrimenti calcolo gia fatto
				risultato.put(risorsa, num_ripetizioni_risorsa);
				for(Prestito p1:prestiti_archiviati){
					if(p1.getRisorsa().equals(risorsa)) {
						num_ripetizioni_risorsa++;
					}
				}
				risultato.put(risorsa, num_ripetizioni_risorsa);//aggiorna l'hash map con il valore delle ripetizioni corretto
			}
		 }
		 //ricerco il massimo nelle coppie risorsa ripetiziine
		 
		return risultato;
		 
	 }
	 
	 /**
	  * Seleziona per ogni fruitore che ha dei prestiti il quantitativo di prestiti effettuati in un anno solare passato in ingresso
	  * 
	  * @param anno solare dentro il cui cercare
	  * @return un'associazione fra un Fruitore e il numero di prestiti ad esso relativo
	  */
	 public HashMap<Fruitore, Integer> select_count_numero_di_prestiti_perogni_fruitore(LocalDateTime anno) {
		return null;
		 
	 }
}
