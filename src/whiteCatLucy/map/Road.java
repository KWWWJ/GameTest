package whiteCatLucy.map;

public class Road extends BaseMap{
	
	public void road() {
		//길 맵, 기본맵을 상속받아 맵을 생성했다.
		keyIn1 = "의심많은";
		keyIn2 = "의심많은";
		keyIn3 = "호기심많은";
		keyIn4 = "호기심많은";
		//조건은 최대 4개까지 설정가능하다.
		baseMap(key, 8, 9, "[차가운 길바닥을 거닐며 갈색 나뭇잎이 휘날리는 것을 가만히 지켜봅니다.]", 
				"[그다지 나가고싶은 기분이 아닙니다.]", 
				"[필요조건 : 의심많은, 호기심많은]");
		//입장조건, 이벤트 번호, 스크립트1번, 2번
	}
	
}
