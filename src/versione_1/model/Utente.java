package versione_1.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Utente implements Serializable,Comparable{
	
	/**
	 * serve per la serializzazione degli oggetti 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String cognome;
	private String mail;
	private LocalDateTime data_di_nascita;
	private String c_f;
	private String username;
	private String password;
	
	public Utente (ArrayList<String> dati) {
		this.nome = dati.get(0);
		this.cognome = dati.get(1);
		this.mail = dati.get(2);
		
		//data di nascita in formato (ANNO, MESE, GIORNO, ORA, MINUTI) NB: gli ultimi due "0,0" sono per ora e minuti
		this.data_di_nascita = LocalDateTime.of(Integer.parseInt(dati.get(5)), Integer.parseInt(dati.get(4)), Integer.parseInt(dati.get(3)), 0 , 0);
		
		this.c_f = dati.get(6);
		this.username = dati.get(7);
		this.password = dati.get(8);
		
	}
	
	public Utente(String nome, String cognome, String mail, LocalDateTime data_di_nascita, String c_f,
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
	
	public void setData_di_nascita(LocalDateTime data_di_nascita) {
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
	
	public String getPassword() {
		return this.password;
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public String getMail() {
		return mail;
	}

	public LocalDateTime getData_di_nascita() {
		return data_di_nascita;
	}

	public String getC_f() {
		return c_f;
	}

	//DA VERIFICARE
	public int getEta() {
		return (LocalDate.now().getYear() - this.data_di_nascita.getYear());
	}
	

	
	public String getUsername() {
		return username;
	}

	@Override
	public String toString() {
		return "Utente [nome=" + nome + ", cognome=" + cognome + ", mail=" + mail + ", data_di_nascita="
				+ data_di_nascita.toString() + ", c_f=" + c_f + ", username=" + username + ", password=" + password + "]";
	}

	@Override
	public int compareTo(Object o) {
		Utente u=(Utente) o;
		if (this.c_f.equals(u.getC_f()))
			return 0;
		else
			return 1;
	}
	
	

}
