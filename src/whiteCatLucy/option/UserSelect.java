package whiteCatLucy.option;

import java.util.Scanner;

public class UserSelect {
	Scanner scan = new Scanner(System.in);
	MoveMap mm = new MoveMap();
	Rest r = new Rest();
	public String key;
	public int result;
	public String item = null;
	public boolean event;
	
	public void userSelect() {
		System.out.println();
		System.out.println();
		System.out.println("[원하시는 행동을 선택해 주세요.]\n"
				+"[1.맵 이동]\r"
				+"[2.휴식하기]\r"
				+"[3.배낭열기]\n\n");
		int mySelect = scan.nextInt();
		
		switch(mySelect) {
		case 1:
			mm.mapKey(key);
			mm.beforMove();
			result = mm.result;
			event = true;
			event = mm.event;
			System.out.println();
			break;
		case 2:
			r.rest();
			event = false;
			event = mm.event;
			System.out.println();
			break;
		case 3:
			if(item == null) {
				System.out.println("[아직 아무것도 얻지 못했다.]");
			}
			else {
				System.out.println(item);
			}
			event = false;
			event = mm.event;
		default:
			break;
		}
	}
}
