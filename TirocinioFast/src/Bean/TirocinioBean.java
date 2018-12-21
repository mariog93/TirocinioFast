package Bean;

public class TirocinioBean implements java.io.Serializable {

	private static final long serialVersionUID = 5L;
	
	/**Costruttore*/

	public TirocinioBean() {}

	/**Getter e Setter*/

	public int getStudente(){
		return studente;
	}

	public void setStudente(int studente) {
		this.studente = studente;
	}

	public int getAzienda(){
		return azienda;
	}

	public void setAzienda(int azienda){
		this.azienda = azienda;
	}

	public int getTutorAccademico(){
		return tutorAccademico;
	}

	public void setTutorAccademico(int tutorAccademico){
		this.tutorAccademico = tutorAccademico;
	}

	public String getAnnoAccademico(){
		return annoAccademico;
	}

	public void setAnnoAccademico(String annoAccademico){
		this.annoAccademico = annoAccademico;
	}

	public int getCFU (){
		return CFU;
	}

	public void setCFU(int CFU){
		this.CFU = CFU;
	}

	public boolean isHandicap(){
		return handicap;
	}

	public void setHandicap (boolean handicap){
		this.handicap = handicap;
	}

	public String getUrl(){
		return url;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public boolean isConvalidaAzienda(){
		return convalidaAzienda;
	}

	public void setConvalidaAzienda (boolean convalidaAzienda){
		this.convalidaAzienda = convalidaAzienda;
	}

	public boolean isConvalidaTutor(){
		return convalidaTutor;
	}

	public void setConvalidaTutor (boolean convalidaTutor){
		this.convalidaTutor = convalidaTutor;
	}

	public boolean isConvalidaStudente(){
		return convalidaStudente;
	}

	public void setConvalidaStudente (boolean convalidaStudente){
		this.convalidaStudente = convalidaStudente;
	}

	public boolean isConvalida(){
		return convalida;
	}

	public void setConvalida (boolean convalida){
		this.convalida = convalida;
	}

	public String getFacilitazion(){
		return facilitazioni;
	}

	public void setFacilitazioni(String facilitazioni){
		this.facilitazioni = facilitazioni;
	}

	public String getRegistroOre(){
		return registroOre;
	}

	public void setRegistroOre(String registroOre){
		this.registroOre = registroOre;
	}

	public String getStabilimento(){
		return stabilimento;
	}

	public void setStabilimento(String stabilimento){
		this.stabilimento = stabilimento;
	}

	/**toString*/
	
	@Override
	public String toString(){
		return "Tirocinio [Studente: " + this.getStudente() +
				"][Azienda: " + this.getAzienda() +
				"][Tutor accademico: " + this.getTutorAccademico() +
				"][Anno accademico: " + this.getAnnoAccademico() +
				"][CFU: " + this.getCFU() +
				"][Handicap: " + this.isHandicap() +
				"][Url: " + this.getUrl() +
				"][Convalida azienda: " + this.isConvalidaAzienda() +
				"][Convalida tutor: " + this.isConvalidaTutor() +
				"][Convalida studente: " + this.isConvalidaStudente() +
				"][Convalida: " + this.isConvalida() +
				"][Facilitazioni: " + this.getFacilitazion() +
				"][Registro ore: " + this.getRegistroOre() +
				"][Stabilimento: " + this.getStabilimento() + "]";
	}

	/**Variabili di istanza*/

	private int studente;
	private int azienda;
	private int tutorAccademico;
	private String annoAccademico;
	private int CFU;
	private boolean handicap;
	private String url;
	private boolean convalidaAzienda;
	private boolean convalidaTutor;
	private boolean convalidaStudente;
	private boolean convalida;
	private String facilitazioni;
	private String registroOre;
	private String accessoLocali;
	private String periodoTirocinio;
	private String obiettivoTirocinio;
	private String stabilimento;
	
}
