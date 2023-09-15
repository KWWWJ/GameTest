package whiteCatLucy.map;

import java.util.Random;

import whiteCatLucy.option.MoveMap;

public class InsideJewelCave{
	private String key;
	public int result;
	
	public void jewelCave() {
		if((key == "활발한" ||
				key == "호기심많은" ||
				key == "의심많은")
				)
		{
			System.out.println("[루시는 신비한 보석으로 아름답게 반짝이는 수정을 툭툭 쳐보고있습니다.]");
			Random r = new Random();
			if(r.nextInt(2) == 0) {
				result = 5;
			}
			else if(r.nextInt(2) == 1) {
				result = 6;
			}
		}
		else {
			System.out.println("[루시는 지금 보석에 그다지 흥미가 없습니다.]");
		}
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
}
