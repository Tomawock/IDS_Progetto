package versione_5.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import versione_5.model.*;

class Operatore_test {
	/**
	 * Test Per cammini di base
	 */
	@Test
	public void true_if_two_operatori_are_the_same() {
		Utente u_pass= new Utente("test", 
									"test_c", 
									"mail",
									LocalDateTime.now(),
									"12",
									"Username",
									"123");
			
		Utente u_pass2= new Utente("test", 
									"test_c", 
									"mail",
									LocalDateTime.now(),
									"12",
									"Username",
									"123");
		
		Operatore o_pass=new Operatore(u_pass);
		Operatore o_pass2=new Operatore(u_pass2);
		
		assertTrue(o_pass.equals(o_pass2),"I due operatori con lo stesso username sono uguai");
		

	}
	
	@Test
	public void true_if_two_operatori_are_not_the_same() {
		Utente u_pass= new Utente("test", 
									"test_c", 
									"mail",
									LocalDateTime.now(),
									"12",
									"Username",
									"123");
			
		Utente u_fail= new Utente("test", 
									"test_c", 
									"mail",
									LocalDateTime.now(),
									"12",
									"Username_diverso",
									"123");
		
		Operatore o_pass=new Operatore(u_pass);
		Operatore o_fail=new Operatore(u_fail);
		
		assertFalse(o_pass.equals(o_fail),"Operatori con diverso username sono diversi");
	}
	
	/**
	 * Test boundary value analysis
	 */
	@Test
	public void execute_equals_on_null_constuctor_should_throw_NullPointerException() {
		Operatore op = new Operatore(null);
		assertThrows(NullPointerException.class,
	            ()->{
	            op.equals(op);
            	});
	}
}
