
public class Warrior {
	
	private int id;
	private String name;
	private int health;
	private int strenght;
	private int speed;
	private int agility;
	private int defense;
	private String url;
	private Weapon weapon;
	private int points;


	public Warrior(int id, String name, int health, int strenght, int speed, int agility, int defense, String url, Weapon weapon, int points) {
		this.id = id;
		this.name = name;
		this.health = health;
		this.strenght = strenght;
		this.speed = speed;
		this.agility = agility;
		this.defense = defense;
		this.url = url;
		this.weapon = weapon;
		this.points = points;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Warrior" + id +
				": id=" + id +
				", name='" + name + '\'' +
				", health=" + health +
				", strenght=" + strenght +
				", speed=" + speed +
				", agility=" + agility +
				", defense=" + defense +
				", url='" + url + '\'' +
				", weapon=" + weapon +
				", points=" + points +
				'}';
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int gethealth() {
		return health;
	}

	public void sethealth(int health) {
		this.health = health;
	}

	public int getStrenght() {
		return strenght;
	}

	public void setStrenght(int strenght) {
		this.strenght = strenght;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getAgility() {
		return agility;
	}

	public void setAgility(int agility) {
		this.agility = agility;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
	
}
