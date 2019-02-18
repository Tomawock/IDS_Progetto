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
	
	@Test
	public void controllo_validia_dovrebbe_settare_valido_e_rinnovabile_true_se_data_fine_iscrizione_successiva_ad_oggi_e_se_data_rinnovo_iscrizione_precedente_ad_oggi() {
		fruitore.setData_fine_iscrizione(LocalDateTime.now().plusDays(1));
		fruitore.setData_rinnovo_iscrizione(LocalDateTime.now().minusDays(1));
		assertTrue(fruitore.is_valido(),"Fruitore con validita a true");
		assertTrue(fruitore.is_rinnovabile(),"Fruitore con rinnovabilia a true");
	}
	
	@Test
	public void controllo_validia_dovrebbe_settare_valido_true_se_data_fine_iscrizione_successiva_ad_oggi_e_settarerinnovabile_false_se_data_rinnovo_iscrizione_successiva_ad_oggi() {
		fruitore.setData_fine_iscrizione(LocalDateTime.now().plusDays(1));
		fruitore.setData_rinnovo_iscrizione(LocalDateTime.now().plusDays(1));
		assertTrue(fruitore.is_valido(),"Fruitore con validita a true");
		assertFalse(fruitore.is_rinnovabile(),"Fruitore con rinnovabilia a false");	
	}
	
	@Test
	public void controllo_validia_dovrebbe_settare_valido_e_rinnovabile_false_se_data_fine_iscrizione_precedente_ad_oggi() {
		fruitore.setData_fine_iscrizione(LocalDateTime.now().minusDays(1));
		assertFalse(fruitore.is_valido(),"Fruitore con validita a false");
		assertFalse(fruitore.is_rinnovabile(),"Fruitore con rinnovabilia a false");	
	}

	

}
