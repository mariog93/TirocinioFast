package Bean;

import java.io.Serializable;

public class StudenteBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**Costruttore*/
	
	public StudenteBean() {}

	/**Getter e Setter*/

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getLuogoNascita() {
		return luogoNascita;
	}

	public void setLuogoNascita(String luogoNascita) {
		this.luogoNascita = luogoNascita;
	}

	public String getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(String dataNascita) {
		this.dataNascita = dataNascita;
	}
	
	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDomanda() {
		return domanda;
	}

	public void setDomanda(String domanda) {
		this.domanda = domanda;
	}
	
	/**toString*/
	
	@Override
	public String toString(){
		return "Studente [Nome: " + this.getNome() + 
			   "][Cognome: " + this.getCognome() +			   
			   "][Luogo Nascita: " + this.getLuogoNascita() +
			   "][Data Nascita: " + this.getDataNascita() +
			   "][Indirizzo: " + this.getIndirizzo() +
			   "][Città: " + this.getCitta() +
			   "][Codice Fiscale: " + this.getCodiceFiscale() +
			   "][Matricola: " + this.getMatricola() +
			   "][E-mail: " + this.getEmail() +
			   "][Telefono: " + this.getTelefono() +
			   "][Username: " + this.getUsername() +
			   "][Password: " + this.getPassword() +
			   "][Risposta: " + this.getDomanda() + "]";
	}

	/**Variabili di istanza*/
	
	private String nome;
	private String cognome;
	private String luogoNascita;
	private String dataNascita;
	private String indirizzo;
	private String citta;
	private String codiceFiscale;
	private String matricola;
	private String email;
	private String telefono;
	private String username;
	private String password;
	private String domanda;
}
