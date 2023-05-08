
public class Personatge {
	
	private int id;
	private String nom;
	private int health;
	private int força;
	private int velocitat;
	private int agilitat;
	private int defensa;
	private String url;
	private String arma;
	
	public Personatge(int id, String nom, int health, int força, int velocitat, int agilitat, int defensa, String url, String arma) {
		this.id = id;
		this.nom = nom;
		this.health = health;
		this.força = força;
		this.velocitat = velocitat;
		this.agilitat = agilitat;
		this.defensa = defensa;
		this.url = url;
		this.arma = arma;
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

	public int gethealth() {
		return health;
	}

	public void sethealth(int health) {
		this.health = health;
	}

	public int getForça() {
		return força;
	}

	public void setForça(int força) {
		this.força = força;
	}

	public int getVelocitat() {
		return velocitat;
	}

	public void setVelocitat(int velocitat) {
		this.velocitat = velocitat;
	}

	public int getAgilitat() {
		return agilitat;
	}

	public void setAgilitat(int agilitat) {
		this.agilitat = agilitat;
	}

	public int getDefensa() {
		return defensa;
	}

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getArma() {
		return arma;
	}

	public void setArma(String arma) {
		this.arma = arma;
	}
	
}
