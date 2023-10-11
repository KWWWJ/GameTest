package whiteCatLucy.character;

public class Unit {
	private String name;
	private int healthPoint;
	private int damage;
	
	public Unit(String name, int healthPoint, int damage) {
		this.name = name;
		this.healthPoint = healthPoint;
		this.damage = damage;
	}
	
	public String getName() {
		return name;
	}
	public int getHp() {
		return healthPoint;
	}
	public int hpUp(int hpUp) {
		return healthPoint+=hpUp;
	}
	public boolean alive() {
		return healthPoint>0;
	}
	public int attack() {
		return damage;
	}
	public void takeDamage(int damage) {
		healthPoint-=damage;
	}
	public void getItem(int power) {
		damage+=power;
	}
	
}
