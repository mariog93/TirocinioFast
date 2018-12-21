package Bean;

public class QuestionarioAziendaBean implements java.io.Serializable {

	private static final long serialVersionUID = 8L;
	
	/**Costruttore*/

	public QuestionarioAziendaBean() {}

	/**Getter e Setter*/

	public int getStudente() {
		return studente;
	}

	public void setStudente(int studente) {
		this.studente = studente;
	}

	public int getTutorAccademico() {
		return tutorAccademico;
	}

	public void setTutorAccademico(int tutorAccademico) {
		this.tutorAccademico = tutorAccademico;
	}

	public int getAzienda() {
		return azienda;
	}

	public void setAzienda(int azienda) {
		this.azienda = azienda;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPosizioneRicoperta() {
		return posizioneRicoperta;
	}

	public void setPosizioneRicoperta(String posizioneRicoperta) {
		this.posizioneRicoperta = posizioneRicoperta;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**toString*/

	@Override
	public String toString(){
		return "Questionario azienda [Studente: " + this.getStudente() +
				"][Tutor accademico: " + this.getTutorAccademico() +
				"][Azienda: " + this.getAzienda() +
				"][Periodo: " + this.getPeriodo() +
				"][Titolo: " + this.getTitolo() +
				"][Url: " + this.getUrl() +
				"][Posizione ricoperta: " + this.getPosizioneRicoperta() + "]";
	}

	/**Variabili di istanza*/

	private int studente;
	private int tutorAccademico;
	private int azienda;
	private String periodo;
	private String titolo;
	private String url;
	private String posizioneRicoperta;

}
