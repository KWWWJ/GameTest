package whiteCatLucy.character;

import java.util.Scanner;

public class Skill {
	Scanner skillScan = new Scanner(System.in);
	private String name;
	private String script;
	private int attack;
	private int heal;
	private int defence;
	private int plusAttack;
	
	
	
	public Skill(
			String name, 
			String script, 
			int attack,
			int heal,
			int defence,
			int plusAttack) {
		this.name = name;
		this.script = script;
		this.attack = attack;
		this.heal = heal;
		this.defence = defence;
		this.plusAttack = plusAttack;
	}
	
	public String skillInfo() {
		return name+"\n"+script;
	}
	public int attack() {
		return attack;
	}
	public int heal() {
		return heal;
	}
	public int defence() {
		return defence;
	}
	public int plusAttack() {
		return plusAttack;
	}
}
