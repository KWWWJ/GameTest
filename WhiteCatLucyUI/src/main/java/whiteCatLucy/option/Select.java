package whiteCatLucy.option;

import java.util.Scanner;

public class Select {
	Scanner scan = new Scanner(System.in);
	public boolean select() {
		//대게 플레이어의 이동과 관련된 참거짓을 따진다.
		String input = scan.next();
		if(input.equals("1")) {
			return true;
		}
		return false;
	}
	public boolean select2() {
		//앞에서 한번 select가 실행되고나서 재실행했을떄 이전 결과를 반영하는 현상이 있어 
		//추가로 만들어 방지했다.
		String input = scan.next();
		if(input.equals("1")) {
			return true;
		}
		return false;
	}
	
}
