package versione_1.model;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Utente {
	
	private String nome;
	private String cognome;
	private String mail;
	private GregorianCalendar data_di_nascita;
	private String c_f;
	private String username;
	private String password;
	
	public Utente (ArrayList<String> dati) {
		this.nome = dati.get(0);
		this.cognome = dati.get(1);
		this.mail = dati.get(2);
		this.data_di_nascita = new GregorianCalendar(Integer.parseInt(dati.get(5)),Integer.parseInt(dati.get(4))-1,Integer.parseInt(dati.get(3)));
		this.c_f = dati.get(6);
		this.username = dati.get(7);
		this.password = dati.get(8);
		
	}
	
	public Utente(String nome, String cognome, String mail, GregorianCalendar data_di_nascita, String c_f,
			String username, String password) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.mail = mail;
		this.data_di_nascita = data_di_nascita;
		this.c_f = c_f;
		this.username = username;
		this.password = password;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public void setData_di_nascita(GregorianCalendar data_di_nascita) {
		this.data_di_nascita = data_di_nascita;
	}
	
	public void setC_f(String c_f) {
		this.c_f = c_f;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Utente [nome=" + nome + ", cognome=" + cognome + ", mail=" + mail + ", data_di_nascita="
				+ data_di_nascita.toString() + ", c_f=" + c_f + ", username=" + username + ", password=" + password + "]";
	}
	
	

}
