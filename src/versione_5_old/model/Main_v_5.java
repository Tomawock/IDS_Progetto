package versione_5_old.model;

import utilita.Emulazione_Server;
import versione_5.controller.Controller;

public class Main_v_5 {
	public static void main(String[] args) {
		Emulazione_Server.inizializza();//emeula il server il quale cointiene dei dati preimpostati
		Controller c= new Controller();//crea il controller del sw e inizia il programma
		c.log_in();	
	}
}