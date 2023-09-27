package whiteCatLucy.character;

import java.util.Random;

import whiteCatLucy.battle.Battle;

public class Monster extends Unit{
	Battle b = new Battle();
	Random r = new Random();
	int event = r.nextInt(100);
	
	public String pName;
	public int pHp;
	public int pDamage;
	public boolean pLife;
	public boolean skillUse;
	
	public Monster(String name, int healthPoint, int damage) {
		super(name, healthPoint, damage);
	}
	public void playerStatus(String pName, int pHp, int pDamage) {
		b.pName = pName;
		b.pHp = pHp;
		b.pDamage = pDamage;
	}
	public void jewelGolem() {
		if(event > 45) {
			Monster m = new Monster("보석골램", 150, 25);
			b.mDamage = m.attack();
			b.mHp = m.getHp();
			b.mName = m.getName();

			b.battle();
			
			pHp = 100 - b.pHp;
			//플레이어의 hp의 최댓값에서 전투 이후 남은 hp를 뺴고 남은 값을 받은 데미지로 넘겨준다.
		}
		else {
			System.out.println("[웬지 누군가가 지켜보는것만 같다...]");
		}
	}
	public void cloudFisher() {
			Monster m = new Monster("구름 낚는 자", 100, 15);
			
			b.mDamage = m.attack();
			b.mHp = m.getHp();
			b.mName = m.getName();

			b.battle();
			
			pHp =100 -  b.pHp;
	}
	public void shadowTree() {
		if(event > 45) {
			Monster m = new Monster("그림자 나무", 70, 15);
			
			b.mDamage = m.attack();
			b.mHp = m.getHp();
			b.mName = m.getName();

			b.battle();
			
			pHp =100 -  b.pHp;
			
		}
		else {
			System.out.println("[웬지 누군가가 지켜보는것만 같다...]");
		}
	}
	public void ilusionGost() {
		if(event > 45) {
		Monster m = new Monster("흔들리는 형체의 무언가", 1, 50);
		b.mDamage = m.attack();
		b.mHp = m.getHp();
		b.mName = m.getName();

		b.battle();
		
		pHp =100 -  b.pHp;
		}
		else {
			System.out.println("[웬지 누군가가 지켜보는것만 같다...]");
		}
	}
	public void violentCat() {

		Monster m = new Monster("난폭한 고양이", 20, 10);
		b.mDamage = m.attack();
		b.mHp = m.getHp();
		b.mName = m.getName();
		
		b.battle();
		
		pHp =100 -  b.pHp;
	
	}
	public void eyeWithAngelWings() {
		Monster m = new Monster("천사의 날개를 단 끔찍한 눈", 200, 30);
		b.mDamage = m.attack();
		b.mHp = m.getHp();
		b.mName = m.getName();
		
		b.battle();
		
		pHp =100 -  b.pHp;
		
	}
	

}
