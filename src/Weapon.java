
public class Weapon {
	
	private int id;
	private String name;
	private int speed;
	private int strenght;
	private String url;
	private int points;
	
	public Weapon(int id, String name, int speed, int strenght, String url, int points) {
		this.id = id;
		this.name = name;
		this.speed = speed;
		this.strenght = strenght;
		this.url = url;
		this.points = points;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Weapon" + id +
				": id=" + id +
				", name='" + name + '\'' +
				", speed=" + speed +
				", strenght=" + strenght +
				", url='" + url + '\'' +
				", points=" + points +
				'}';
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getStrenght() {
		return strenght;
	}

	public void setStrenght(int strenght) {
		this.strenght = strenght;
	}
	
}
