package Bean;

public class AziendaBean implements java.io.Serializable {

	private static final long serialVersionUID = 2L;
	
	/**Costruttore*/

	public AziendaBean() {}

	/**Getter e Setter*/
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getPartitaIva() {
		return partitaIva;
	}

	public void setPartitaIva(String partitaIva) {
		this.partitaIva = partitaIva;
	}

	public String getCeo() {
		return ceo;
	}

	public void setCeo(String ceo) {
		this.ceo = ceo;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
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
		return "Azienda [Nome: " + this.getNome() +
				"][Partita Iva: " + this.getPartitaIva() +
				"][CEO: " + this.getCeo() +
				"][Sede: " + this.getIndirizzo() +
				"][E-mail: " + this.getEmail() +
				"][Telefono: " + this.getTelefono() +
				"][Username: " + this.getUsername() +
				"][Password: " + this.getPassword() +
				"][Risposta: " + this.getDomanda() + "]";
	}

	/**Variabili di istanza*/

	private String nome;
	private String partitaIva;
	private String ceo;
	private String indirizzo;
	private String email;
	private String telefono;
	private String username;
	private String password;
	private String domanda;

}
