package whiteCatLucy.map;

import java.util.Random;
import whiteCatLucy.event.IncidentEvent;
import whiteCatLucy.option.MoveMap;


public class InsideHome{
	private String key;
	public int result;
	
	public void home() {
		if(key == "활발한" || 
			key == "나태한" ||
			key == "의심많은" ||
			key == "호기심많은" ||
			key == "안정된"|| 
			key == null)
		{
			System.out.println("[루시는 집에 들어오며 익숙한 온기를 느꼈습니다.]");
			Random r = new Random();
			if(r.nextInt(2) == 0) {
				result = 4;
			}
			else if(r.nextInt(2) == 1) {
				result = 4;
			}
		}
		else {
			System.out.println("[루시는 지금 집에도 들어가고 싶지 않습니다.]");
		}
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
}
