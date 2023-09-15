package whiteCatLucy.character;

import java.util.ArrayList;

public class Lucy {
	protected String item;
	protected String lucyTen;
	private int caution;
	private int fullness;
	private int intellect;
	
	ArrayList<Item> bag = new ArrayList<>();
	ArrayList<Tendency> tendency = new ArrayList<>();
	
	public Lucy(int caution, int fullness, int intellect) {
		this.caution = caution;
		this.fullness = fullness;
		this.intellect = intellect;
	}
	
	public int getCaution() {
		return caution;
	}
	public int getFullness() {
		return fullness;
	}
	public int getIntellect() {
		return intellect;
	}
	public void cautionUp(int cautionUp) {
		caution+=cautionUp;
	}
	public void fullnessUp(int fullnessUp) {
		fullness+=fullnessUp;
		
	}
	public void intellectUp(int intellectUp) {
		intellect+=intellectUp;
	}
	
	public void addItem(String item) {
		Item itemName = new Item(item);
		bag.add(itemName);
	}
	
	public void addTendency(String lucyTen) {
		Tendency myKey = new Tendency(lucyTen);
		for(int i=0; i<1; i++) {
			if(tendency.isEmpty()) {
		
				tendency.add(myKey);
			}
			else {
				tendency.set(i, myKey);
			}
		}
	}
	public String getBag() { 
		StringBuilder sb = new StringBuilder();
		int count = 0;
			for(Item item : bag) {
				sb.append("\n["+ ++count+".");
				sb.append(item.getItem()+"]");
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
	
}
