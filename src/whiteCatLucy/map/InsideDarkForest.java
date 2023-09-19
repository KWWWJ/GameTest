package whiteCatLucy.map;

public class InsideDarkForest extends BaseMap{
	
public void darkForest() {
	//검은 숲 맵, 기본맵을 상속받아 맵을 생성했다.
	
		keyIn1 = "활발한";
		keyIn2 = "활발한";
		keyIn3 = "의심많은";
		keyIn4 = "의심많은";
		//조건은 최대 4개까지 설정가능하다.
		baseMap(key, 2, 3, "[루시는 검은나뭇잎을 입에 물고 공터를 배회합니다.]", 
				"[루시의 호기심은 잠잠한 상태입니다...]", 
				"[필요조건 : 활발한, 의심많은]");
		//입장조건, 이벤트 번호, 스크립트1번, 2번
	}
}
