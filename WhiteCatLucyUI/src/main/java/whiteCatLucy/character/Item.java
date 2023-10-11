package whiteCatLucy.character;

public class Item {
	//플레이어가 휙득할 아이템을 만드는 클래스다.
	private String name;
	private int power;
	//아이템은 현재로서 맵에 집인할 수 있는 조건을 만족하는 열쇠로서의 역할만을 부여했기 때문에
	//당장으로서는 아이템의 이름만 설정하ㅗ록 되어있다.
	
	public Item(String name, int power) {
		this.name = name;
		this.power = power;
		//이름과 성능을 지정해준다.
	}
	public String getItem() {
		return name;
		//지정된 이름을 보내준다.
	}
	public int getPower() {
		return power;
		//지정된 성능을 보내준다.
	}
}
