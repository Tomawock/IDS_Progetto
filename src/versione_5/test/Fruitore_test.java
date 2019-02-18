package versione_5.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import versione_5.model.*;


class Fruitore_test {

	private Utente user;
	private Utente user_diverso;
	private Utente user_uguale;
	private Fruitore fruitore;
	
	/**
	 * inizzializzo oggetti per i test
	 */
	@BeforeEach
	public void setup() {
		user= new Utente("Nome",
				"Cognome",
				"mail",
				LocalDateTime.now(),
				"CodiceFiscale",
				"Username", 
				"password");
		user_diverso= new Utente("Nome",
				"Cognome",
				"mail",
				LocalDateTime.now(),
				"CodiceFiscale",
				"Username_diverso", 
				"password");
		user_uguale= new Utente("Nome",
				"Cognome",
				"mail",
				LocalDateTime.now(),
				"CodiceFiscale",
				"Username", 
				"password");
		
		fruitore =new Fruitore(user);
	}
	/**
	 * Test Coverange
	 */
	@Test
	public void get_giorni_scadenza_dovrebbe_ritornare_meno_uno_se_fruitore_non_rinnovabile() {
		fruitore.setRinnovabile(false);//vuol dire che non si è nel periodo in cui si puo rinnovare la scadenza
		assertEquals(-1, fruitore.get_giorni_scadenza(),"Fruitore non rinnvovabile, implica che non posso sapere i giorni alla scdenza");
	}
	
	@Test
	public void get_giorni_scadenza_dovrebbe_ritornare_uno_se_fruitore_rinnovabile() {
		fruitore.setRinnovabile(true);//vuol dire che non si è nel periodo in cui si puo rinnovare la scadenza
		fruitore.setData_fine_iscrizione(LocalDateTime.now().plusDays(1));
		assertEquals(1, fruitore.get_giorni_scadenza(),"Fruitore rinnvovabile, implica che posso sapere i giorni alla scdenza");
	}

}
