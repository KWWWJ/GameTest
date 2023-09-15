package whiteCatLucy.map;

import java.util.Random;
import whiteCatLucy.event.IncidentEvent;
import whiteCatLucy.option.MoveMap;

public class InsideDarkForest {
	public String key;
	public int result;
	
	public void setKey() {
		MoveMap mm = new MoveMap();
		mm.setKey();
		key = mm.key;
	}
	
	public void darkForest() {
		if(key == "활발한" ||
				key == "의심많은")
		{
			System.out.println("[루시는 검은나뭇잎을 입에 물고 공터를 배회합니다.]");
			Random r = new Random();
			if(r.nextInt(2) == 0) {
				result = 2;
			}
			else if(r.nextInt(2) == 1) {
				result = 3;
			}
		}
		else {
			System.out.println("[루시의 호기심은 잠잠한 상태입니다...]");
		}
	}
}
