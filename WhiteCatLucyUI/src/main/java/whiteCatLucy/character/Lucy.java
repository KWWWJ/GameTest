package whiteCatLucy.character;

import java.util.ArrayList;

public class Lucy extends Unit{
	public Lucy(String name, int healthPoint, int damage) {
		super(name, healthPoint, damage);
	}
	//플레이어 캐릭터를 설정하는 클래스다.
	private int caution;
	private int fullness;
	private int intellect;
	//플레이어의 스테이터스, 각각 주의력, 포만감, 지능으로 되어있다.
	
	public ArrayList<Item> bag = new ArrayList<>();
	//플레이어가 휙득하는 아이템 값이 담길 리스트.
	public ArrayList<Tendency> tendency = new ArrayList<>();
	//플레이어의 성격이 담길 리스트.
	public ArrayList<Skill> skill = new ArrayList<>();
	//플레이어가 해금할 스킬이 들어가는 곳
	
	public int getCaution() {
		return caution;
	}
	public int getFullness() {
		return fullness;
	}
	public int getIntellect() {
		return intellect;
	}
	//각 스테이터스 정보를 불러온다.
	public void cautionUp(int cautionUp) {
		caution+=cautionUp;
	}
	public void fullnessUp(int fullnessUp) {
		fullness+=fullnessUp;
		
	}
	public void intellectUp(int intellectUp) {
		intellect+=intellectUp;
	}
	//각 스테이터스 정보를 변경한다.
	
	public void addItem(String item, int power) {
		Item itemName = new Item(item, power);
		//이후 아이템에 추가적인 값을 부여하게되면 모든 값을 Item클래스의 타입으로 저장한다.
		if(item != null) {
			//만약 아이템이 null이면 넣지 않음
			bag.add(itemName);
		}
		//가방 리스트에 아이템을 추가한다.
	}
	//아이템을 휙득하는 메커니즘 메서드.
	
	public void addTendency(String lucyTen) {
		Tendency myKey = new Tendency(lucyTen);
		for(int i=0; i<1; i++) {
			//성격은 하나만 존재해야하므로, 설격 리스트를 불러온다.
			if(tendency.isEmpty()) {
				//만약 성격이 존재하지 않으면 바로 추가한다.
				tendency.add(myKey);
			}
			
			else {
				tendency.set(i, myKey);
				//성격이 존재하면 기존의 성격을 수정한다.
			}
		}
	}
	
	public String getBag() { 
		StringBuilder sb = new StringBuilder();
		//아이템을 String형태로 출력하기 위한 빌더
		int count = 0;
			for(Item item : bag) {
				//아이템 리스트를 불러온다.
				sb.append("["+ ++count+".");
				sb.append(item.getItem()+"]\n");
				//아이템을 [1.아이템]의 형태로 출력한다.
			}
		return sb.toString();
	}
	public String getTendency() { 
		StringBuilder sb = new StringBuilder();
			for(Tendency item : tendency) {
				sb.append(item.getKey());
			}
		return sb.toString();
	}
	public String getSkill() { 
		StringBuilder sb = new StringBuilder();
			for(Skill item : skill) {
				sb.append(item.skillInfo());
			}
		return sb.toString();
	}
	//동일하다.
	
}
