package versione_3.model;

import utilita.Emulazione_Server;
import versione_3.controller.Controller;

public class Main_v_3 {

	public static void main(String[] args) {
		Emulazione_Server.inizializza();
		Controller c= new Controller();
		c.log_in();	
	}
}