
public class Arma {
	
	private int id;
	private String nom;
	private int velocitat;
	private int força;
	
	public Arma(int id, String nom, int velocitat, int força) {
		this.id = id;
		this.nom = nom;
		this.velocitat = velocitat;
		this.força = força;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getVelocitat() {
		return velocitat;
	}

	public void setVelocitat(int velocitat) {
		this.velocitat = velocitat;
	}

	public int getForça() {
		return força;
	}

	public void setForça(int força) {
		this.força = força;
	}
	
}
