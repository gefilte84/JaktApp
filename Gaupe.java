

public class Gaupe {
	public String id;	
	private String kjonnG;
	private double lengdeG;
	private double vektG;
	private double orer;
	private String dato;
	private String sted;
	
	public Gaupe(String id, String kjonnG, double lengdeG, double vektG, 
			double orer, String dato ,String sted) {
		this.id = id;
		this.kjonnG = kjonnG;
		this.lengdeG = lengdeG;
		this.vektG = vektG;
		this.orer = orer;
		this.dato = dato;
		this.sted = sted;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getKjonnG() {
		return kjonnG;
	}

	public void setKjonnG(String kjonnG) {
		this.kjonnG = kjonnG;
	}

	public double getLengdeG() {
		return lengdeG;
	}

	public void setLengdeG(double lengdeG) {
		this.lengdeG = lengdeG;
	}

	public double getVektG() {
		return vektG;
	}

	public void setVektG(double vektG) {
		this.vektG = vektG;
	}

	public double getOrer() {
		return orer;
	}

	public void setOrer(double orer) {
		this.orer = orer;
	}

	public String getDato() {
		return dato;
	}

	public void setDato(String dato) {
		this.dato = dato;
	}

	public String getSted() {
		return sted;
	}

	public void setSted(String sted) {
		this.sted = sted;
	}


	@Override
	public String toString() {
		return "Gaupe [id=" + id + ", kjonnG=" + kjonnG + ", lengdeG=" + lengdeG + ", vektG=" + vektG + ", orer="
				+ orer + ", dato=" + dato + ", sted=" + sted + "]";
	}
	public String toFile() {
		return id + "," + kjonnG + "," + lengdeG + "," 
	+ vektG + "," + orer + "," + dato + "," + sted;
	}
	
	
}