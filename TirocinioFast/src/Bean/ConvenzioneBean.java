package Bean;

public class ConvenzioneBean implements java.io.Serializable {
	
	private static final long serialVersionUID = 6L;
	
	/**Costruttore*/
	
	public ConvenzioneBean() {}	
	
	/**Getter e Setter*/
	
	public int getAzienda() {
		return azienda;
	}

	public void setAzienda(int azienda) {
		this.azienda = azienda;
	}

	public int getTutorAccademico() {
		return tutorAccademico;
	}

	public void setTutorAccademico(int tutorAccademico) {
		this.tutorAccademico = tutorAccademico;
	}

	public int getImpiegato() {
		return impiegato;
	}

	public void setImpiegato(int impiegato) {
		this.impiegato = impiegato;
	}

	public String getLuogoNascitaCeo() {
		return luogoNascitaCeo;
	}

	public void setLuogoNascitaCeo(String luogoNascitaCeo) {
		this.luogoNascitaCeo = luogoNascitaCeo;
	}

	public String getDataNascitaCeo() {
		return dataNascitaCeo;
	}

	public void setDataNascitaCeo(String dataNascitaCeo) {
		this.dataNascitaCeo = dataNascitaCeo;
	}

	public int getNumeroDipendenti() {
		return numeroDipendenti;
	}

	public void setNumeroDipendenti(int numeroDipendenti) {
		this.numeroDipendenti = numeroDipendenti;
	}

	public String getReferente() {
		return referente;
	}

	public void setReferente(String referente) {
		this.referente = referente;
	}

	public String getTelefonoReferente() {
		return telefonoReferente;
	}

	public void setTelefonoReferente(String telefonoReferente) {
		this.telefonoReferente = telefonoReferente;
	}

	public String getEmailReferente() {
		return emailReferente;
	}

	public void setEmailReferente(String emailReferente) {
		this.emailReferente = emailReferente;
	}
	
	public String getAttivita() {
		return attivita;
	}

	public void setAttivita(String attivita) {
		this.attivita = attivita;
	}

	public boolean isConvalida() {
		return convalida;
	}

	public void setConvalida(boolean convalida) {
		this.convalida = convalida;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	/**toString*/
	
	@Override
	public String toString() {
		return "ConvenzioneBean [Azienda: " + this.getAzienda() + 
				"][TutorAccademico: " + this.getTutorAccademico() +
				"][Impiegato: " + this.getImpiegato() + 
				"][Luogo nascita CEO: " + this.getLuogoNascitaCeo() +
				"][Data nascita CEO: " + this.getDataNascitaCeo() +
				"][Numero dipendenti: " + this.getNumeroDipendenti() +
				"][Referente: " + this.getReferente() +
				"][Telefono referente: " + this.getTelefonoReferente() +
				"][E-mail referente: " + this.getEmailReferente() +
				"][Attivita: " + this.getAttivita() + 
				"][Convalida: " + this.isConvalida() + 
				"][Url: " + this.getUrl() + "]";
	}
	
	/**Variabili di istanza*/
	
	private int azienda;
	private int tutorAccademico;
	private int impiegato;
	private String luogoNascitaCeo;
	private String dataNascitaCeo;
	private int numeroDipendenti;
	private String referente;
	private String telefonoReferente;
	private String emailReferente;
	private String attivita;
	private boolean convalida;
	private String url;
	
}
