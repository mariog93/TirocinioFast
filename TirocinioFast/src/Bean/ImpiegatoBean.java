package Bean;

public class ImpiegatoBean implements java.io.Serializable {

	private static final long serialVersionUID = 4L;
	
	/**Costruttore*/

	public ImpiegatoBean() {}

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

	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
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
		return "Impiegato [Nome: " + this.getNome() +
				"][Cognome: " + this.getCognome() +
				"][Matricola: " + this.getMatricola() +
				"][Username: " + this.getUsername() +
				"][Password: " + this.getPassword() +
				"][Risposta: " + this.getDomanda() + "]";
	}

	/**Variabili di istanza*/

	private String nome;
	private String cognome;
	private String matricola;
	private String username;
	private String password;
	private String domanda;

}
