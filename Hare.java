

public class Hare {
	public String id;	
	private String kjonnH;
	private double lengdeH;
	private double vektH;
	private String typeH;
	private String pelsH;
	private String dato;
	private String sted;
	
	public Hare(String id, String kjonnH, double lengdeH, double vektH, 
			String typeH, String pelsH, String dato ,String sted) {
		this.id = id;
		this.kjonnH = kjonnH;
		this.lengdeH = lengdeH;
		this.vektH = vektH;
		this.typeH = typeH;
		this.pelsH = pelsH;
		this.dato = dato;
		this.sted = sted;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getKjonnH() {
		return kjonnH;
	}
	public void setKjonnH(String kjonnH) {
		this.kjonnH = kjonnH;
	}
	public double getLengdeH() {
		return lengdeH;
	}
	public void setLengdeH(double lengdeH) {
		this.lengdeH = lengdeH;
	}
	public double getVektH() {
		return vektH;
	}
	public void setVektH(double vektH) {
		this.vektH = vektH;
	}
	public String getTypeH() {
		return typeH;
	}
	public void setTypeH(String typeH) {
		this.typeH = typeH;
	}
	public String getPelsH() {
		return pelsH;
	}
	public void setPelsH(String pelsH) {
		this.pelsH = pelsH;
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
		return "Hare: id: " + id + ", Kjønn: " + kjonnH + ", Lengde: " 
	+ lengdeH + ", Vekt: " + vektH + ", Type: " + typeH
	+ ", Pelsfarge: " + pelsH + "\n";
	}
	public String toFile() {
		return id + "," + kjonnH + "," + lengdeH + "," 
	+ vektH + "," + typeH + "," + pelsH + "," + dato + "," + sted;
	}
	
}
