package whiteCatLucy.battle;

import whiteCatLucy.character.Skill;

public class SkillList {
	public int damage;
	public int pDamage;
	public int heal;
	public int defence;
	public int plusAttack;
	public String descript;
	
	public void smash() {
		descript = "[일반공격의 두배의 데미지를 가한다. \n쿨타임 : 5턴]";
		damage = pDamage * 2;
		Skill s = new Skill("[강타]", descript, damage, heal, defence, plusAttack);
		System.out.println("[루시는 온힘을 다해 강력한 일격을 가했습니다!]");
	}
	public void lightMovements() {
		descript = "[몸을 가볍게 만들어 다음턴까지 데미지를 줄여받고 공격력을 각각 7씩 올린다. \n쿨타임 : 4턴]";
		plusAttack = 7;
		defence = 7;
		Skill s = new Skill("[가벼운 몸놀림]", descript, damage, heal, defence, plusAttack);
		System.out.println("[루시는 전투태세를 취했습니다.]");
	}
	public void anUnknownEnergy() {
		descript = "[알 수 없는 기운이 몸을 감싸 다음 공격의 위력을 15만큼 올린다. \n쿨타임 : 4턴]";
		plusAttack = 15;
		Skill s = new Skill("[알 수 없는 기운]", descript, damage, heal, defence, plusAttack);
		System.out.println("[뭐든지 할 수 있을것만 같은 강대한 힘이 느껴집니다!]");
	}
	public void warmLight() {
		descript = "[따스한 빛으로 체력을 30회복한다. \n쿨타임 : 5턴]";
		heal = 30;
		Skill s = new Skill("[따스한 빛]", descript, damage, heal, defence, plusAttack);
		System.out.println("[따스한 빛이 상처로 스며듭니다.]");
	}
	public void invisibleArmor() {
		descript = "[전투 종료까지 데미지를 10만큼 줄여받는다. \n쿨타임 : 5턴]";
		defence = 10;
		Skill s = new Skill("[무형갑]", descript, damage, heal, defence, plusAttack);
		System.out.println("[단단한 기운이 몸을 감싸는 것이 느껴집니다.]");
	}
	public void evasion() {
		descript = "[1턴간 모든 공격으로부터 벗어난다. \n쿨타임 : 7턴]";
		defence = 9999;
		Skill s = new Skill("[회피]", descript, damage, heal, defence, plusAttack);
		System.out.println("[아무런 데미지도 받지 않습니다.]");
	}

}
