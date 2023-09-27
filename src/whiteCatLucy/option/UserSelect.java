package whiteCatLucy.option;

import java.util.Scanner;

public class UserSelect {
	Scanner scan = new Scanner(System.in);
	MoveMap mm = new MoveMap();
	Rest r = new Rest();
	public String key;
	//main에서 key에 집어넣은 값을 토대로 맵에 진입할 수 있는지를 따진다.
	public int result;
	//이벤트에 진입했을때 맵에서 받은 값을 전달받는다.
	public String itemName;
	//아이템 변수를 생성
	public boolean event;
	//이벤트가 실행되는지에 대한 여부
	public String tendencyKey;
	public boolean bagOpen = false;
	
	public void userSelect() {
		System.out.println();
		System.out.println();
		System.out.println("[원하시는 행동을 선택해 주세요.]\n"
				+"[1.맵 이동]\r"
				+"[2.휴식하기]\r"
				+"[3.배낭열기]\r\n\n");
		String mySelect = null;
		mySelect = scan.next();
		//행동선택, 위에서 적용한 스캐너가 중복 적용되지 않게하기 위해 String타입으로 변환했다. 
		switch(mySelect) {
		case "1":
			mm.mapKey(key);
			//main에서 정한 key를 set하여 MoveMap을 통해 선택된 맵에 전달한다.
			mm.beforMove();
			//맵을 선택한다.
			result = mm.result;
			//맵에서 result값을 불러와 저장한다.
			event = true;
			//이벤트가 확정적으로 발생한다.
			System.out.println();
			//공백을 집어넣어 여유를 만든다.
			break;
		case "2":
			r.rest();
			//해당 클래스를 실행해 성격을 변화시킨다.
			tendencyKey = r.tendencyKey;
			key = tendencyKey;
			//설정된 성격을 열쇠로 이어준다.
			event = false;
			//다른 이벤트가 일어나는 것을 막는다.(임시)
			System.out.println();
			break;
		case "3":
			bagOpen = true;
			System.out.println("[루시는 배낭을 열었다.]");
		default:
			//다른것을 누르면 작동하지 않게한다.
			break;
		}
	}
}
