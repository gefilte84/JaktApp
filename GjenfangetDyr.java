
public class GjenfangetDyr {
	public String id;
	private String date;
	private String sted;
	private double lengde;
	private double vekt;
	private String pels;
	private String orer;
	

	public GjenfangetDyr(String id, String date, String sted, double lengde, double vekt, String pels, String orer) {
		this.id = id;
		this.date = date;
		this.sted = sted;
		this.lengde = lengde;
		this.vekt = vekt;
		this.pels = pels;
		this.orer = orer;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getSted() {
		return sted;
	}


	public void setSted(String sted) {
		this.sted = sted;
	}


	public String getPels() {
		return pels;
	}


	public void setPels(String pels) {
		this.pels = pels;
	}


	public String getOrer() {
		return orer;
	}


	public void setOrer(String orer) {
		this.orer = orer;
	}


	public double getLengde() {
		return lengde;
	}


	public void setLengde(double lengde) {
		this.lengde = lengde;
	}


	public double getVekt() {
		return vekt;
	}


	public void setVekt(double vekt) {
		this.vekt = vekt;
	}


	@Override
	public String toString() {
		String visningstekst = "";
		
		if (id.contains("H")) {
			visningstekst = ", Pels=" + getPels();
			
		}else {
			visningstekst = ", Ører=" + getOrer();
		}
		return "GjenfangetDyr [id=" + id + ", date=" + date + ", sted=" + sted + ", lengde=" + lengde + ", vekt=" + vekt
				+  visningstekst + "]";
	}

	
}
