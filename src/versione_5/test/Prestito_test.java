package versione_5.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Locale;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import utilita.Costanti;
import versione_5.model.*;

class Prestito_test {
	
	private Risorsa risorsa,risorsa_diversa;
	private Utente user,user_diverso;
	private Fruitore fruitore,fruitore_diverso;	
	private Prestito prestito,prestito_diverso;
	
	/**
	 * inizzializzo oggetti per i test
	 */
	@BeforeEach
	public void setup() {
		
		risorsa= new Film(1,1);
		user=new Utente("nome","cognome","mail",LocalDateTime.now(),"cf","user","psw");
		fruitore = new Fruitore(user);
		
		risorsa_diversa= new Film(2,1);
		user_diverso=new Utente("nome","cognome","mail",LocalDateTime.now(),"cf","user_diverso","psw");
		fruitore_diverso = new Fruitore(user_diverso);
		
		prestito= new Prestito(risorsa, fruitore);
		prestito_diverso= new Prestito(risorsa_diversa, fruitore_diverso);
	}
	
	/**
	 * Test di copertura del codice delle funzioni principali
	 */
	@Test
	public void vero_se_e_solo_se_un_prestito_uguale_a_se_stesso() {
		assertTrue(prestito.equals(prestito),"Prestito uguale sse uguale a se stesso");
	}
	
	@Test
	public void vero_se_un_prestito_diverso_da_un_altro_prestito() {
		assertFalse(prestito.equals(prestito_diverso),"Prestito diverso in ogni campo");
	}
	
	@Test
	public void vero_se_data_di_proroga_passata_e_mai_stato_prorogato() {
		LocalDateTime ieri = LocalDateTime.now().minusDays(1);
		prestito.setData_proroga_prestito(ieri);
		prestito.setMai_prorogato(true);
		assertTrue(prestito.rinnova(),"Il prestito è stato rinnovato");
		assertFalse(prestito.isMai_prorogato(),"Il prestito viene settato come mai prorogato");
		assertEquals(LocalDateTime.now().getDayOfYear(), prestito.getData_inizio_proroga().getDayOfYear(),"Il prestito prorogato viene settato con la data di inizio proroga corretta");
		assertEquals(LocalDateTime.now().plusDays(Costanti.DURATA_PROROGA).getDayOfYear(),prestito.getData_fine_prestito().getDayOfYear(),"Il prestito prorogato viene settato con la data di fine prestito corretta");
	}

	@Test
	public void vero_se_data_di_proroga_non_passata() {
		LocalDateTime domani = LocalDateTime.now().plusDays(1);
		prestito.setData_proroga_prestito(domani);
		prestito.setMai_prorogato(true);
		assertFalse(prestito.rinnova(),"Il prestito non è stato rinnovato");
	}
	
	@Test
	public void vero_se_prestito_gia_prorogato() {
		LocalDateTime ieri = LocalDateTime.now().minusDays(1);
		prestito.setData_proroga_prestito(ieri);
		prestito.setMai_prorogato(false);
		assertFalse(prestito.rinnova(),"Il prestito non è stato rinnovato");
	}
	
	@Test
	public void vero_i_dati_dei_prestito_vengono_resettati() {
		prestito.reset_dati(prestito_diverso);
		assertEquals(prestito_diverso.getData_fine_prestito(), prestito.getData_fine_prestito(),"La data fine prestito dei prestiti coindice");
		assertEquals(prestito_diverso.getData_inizio_prestito(), prestito.getData_inizio_prestito(),"La data inizio prestito dei prestiti coincide");
		assertEquals(prestito_diverso.getData_inizio_proroga(), prestito.getData_inizio_proroga(),"La data inizio proroga prestito dei prestiti coincide");
		assertEquals(prestito_diverso.getData_proroga_prestito(), prestito.getData_proroga_prestito(),"La data proroga prestito dei prestiti coincide");
		assertEquals(prestito_diverso.getFruitore(), prestito.getFruitore(),"Il fruitore del prestito dei prestiti coincide");
		assertEquals(prestito_diverso.isMai_prorogato(), prestito.isMai_prorogato(),"La possibilità di essere prorogato del prestito dei prestiti coincide");
		assertEquals(prestito_diverso.getRisorsa(), prestito.getRisorsa(),"La risorsa del prestito dei prestiti coincide");
	}
	
	@Test
	public void vero_se_il_prestito_termina() {
		LocalDateTime ieri = LocalDateTime.now().minusDays(1);
		prestito.setData_fine_prestito(ieri);
		assertTrue(prestito.is_terminato(), "Il prestito e stato terminato");		
	}
		
	@Test
	public void vero_se_il_prestito_non_termina() {
		LocalDateTime domani = LocalDateTime.now().plusDays(1);
		prestito.setData_fine_prestito(domani);
		assertFalse(prestito.is_terminato(), "Il prestito non e stato terminato");		
	}
	
}
