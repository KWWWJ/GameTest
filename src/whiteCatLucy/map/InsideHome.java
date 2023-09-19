package whiteCatLucy.map;

public class InsideHome extends BaseMap{

public void home() {
	//집 맵, 기본맵을 상속받아 맵을 생성했다.
		keyIn1 = "활발한";
		keyIn2 = "나태한";
		keyIn3 = "의심많은";
		keyIn4 = "안정된";
		//조건은 최대 4개까지 설정가능하다.
		baseMap(key, 4, 4, "[루시는 그림자진 골목길에 들어섰습니다.]", 
				"[성향에 맞지않아 루시의 발걸음이 떨어지지 않습니다.]", 
				"[필요조건 : 활발한, 나태한, 의심많은, 안정된]");
		//입장조건, 이벤트 번호, 스크립트1번, 2번
	}
}
