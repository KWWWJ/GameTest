package whiteCatLucy.map;

import java.util.Random;
import whiteCatLucy.event.IncidentEvent;
import whiteCatLucy.option.MoveMap;


public class InsideShineCloud{
	public String key;
	public int result;
	
	public void setKey() {
		MoveMap mm = new MoveMap();
		mm.setKey();
		key = mm.key;
	}
	
	public void shineCloud() {
		if(key == "의심많은")
		{
			System.out.println("[루시는 구름에서 떨어질까 걱정이 됩니다.]");
			Random r = new Random();
			if(r.nextInt(2) == 0) {
				result = 7;
			}
			else if(r.nextInt(2) == 1) {
				result = 7;
			}
		}
		else {
			System.out.println("[루시는 소파같이 폭신한 구름 위에서 뒹굴었습니다.]");
		}
	}
}
