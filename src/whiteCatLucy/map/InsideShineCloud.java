package whiteCatLucy.map;

public class InsideShineCloud extends BaseMap{
	
	public void shineCloud() {
		//빛나는 구름 맵, 기본맵을 상속받아 맵을 생성했다.
		keyIn1 = "의심많은";
		keyIn2 = "의심많은";
		keyIn3 = "의심많은";
		keyIn4 = "활발한";
		//조건은 최대 4개까지 설정가능하다.
		baseMap(key, 7, 7, "[루시는 구름에서 떨어질까 걱정이 됩니다.]", 
				"[루시는 소파같이 폭신한 구름 위에서 뒹굴었습니다.]", 
				"[필요조건 : 의심많은, 활발한]");
		//입장조건, 이벤트 번호, 스크립트1번, 2번
	
	}
}
