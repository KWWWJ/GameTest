package whiteCatLucy.map;

import java.util.Random;
import whiteCatLucy.event.IncidentEvent;
import whiteCatLucy.option.MoveMap;

public class Alley{
	private String key;
	public int result;
	
	public void alley() {
		if(key == "활발한" ||
				key == "나태한" ||
				key == "의심많은" ||
				key == null)
		{
			System.out.println("[루시는 그림자진 골목길에 들어섰습니다.]\n");
			Random r = new Random();
			if(r.nextInt(2) == 0) {
				result = 0;
			}
			else if(r.nextInt(2) == 1) {
				result = 1;
			}
		}
		else {
			System.out.println("[성향에 맞지않아 루시의 발걸음이 떨어지지 않습니다.]\n");
		}
	}
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
}
