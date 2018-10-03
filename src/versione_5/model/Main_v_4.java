package versione_5.model;

import utilita.Emulazione_Server;
import versione_4.controller.Controller;

public class Main_v_4 {
	public static void main(String[] args) {
		Emulazione_Server.inizializza();//emeula il server il quale cointiene dei dati preimpostati
		Controller c= new Controller();//crea il controller del sw e inizia il programma
		c.log_in();	
	}
}