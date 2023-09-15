package whiteCatLucy.map;

import java.util.Random;
import whiteCatLucy.event.IncidentEvent;
import whiteCatLucy.option.MoveMap;

public class Road{
	public String key;
	public int result;
	
	public void setKey() {
		MoveMap mm = new MoveMap();
		mm.setKey();
		key = mm.key;
	}
	
	public void road() {
		if((key == "의심많은" ||
				key == "호기심많은")
				)
		{
			System.out.println("[차가운 길바닥을 거닐며 갈색 나뭇잎이 휘날리는 것을 가만히 지켜봅니다.]");
			Random r = new Random();
			if(r.nextInt(2) == 0) {
				result = 8;
			}
			else if(r.nextInt(2) == 1) {
				result = 9;
			}
		}
		else {
			System.out.println("[그다지 나가고싶은 기분이 아닙니다.]");
		}
	}
}
