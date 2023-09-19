package whiteCatLucy.map;

public class InsideJewelCave extends BaseMap{
	
	public void jewelCave() {
		//보석동굴 맵, 기본맵을 상속받아 맵을 생성했다.
		keyIn1 = "의심많은";
		keyIn2 = "의심많은";
		keyIn3 = "호기심많은";
		keyIn4 = "호기심많은";
		//조건은 최대 4개까지 설정가능하다.
		baseMap(key, 5, 6, "[루시는 신비한 보석으로 아름답게 반짝이는 수정을 툭툭 쳐보고있습니다.]", 
				"[루시는 지금 보석에 그다지 흥미가 없습니다.]", 
				"[필요조건 : 의심많은, 호기심많은]");
		//입장조건, 이벤트 번호, 스크립트1번, 2번
	}
	
}
