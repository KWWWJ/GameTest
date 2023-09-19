package whiteCatLucy.map;

import java.util.Random;
import java.util.Scanner;

public class BaseMap {
	Scanner scan = new Scanner(System.in);
	Random r = new Random();
	protected String keyIn1;
	protected String keyIn2;
	protected String keyIn3;
	protected String keyIn4;
	//맵입장조건을 4개까지 설정
	protected String key;
	//moveMap으로부터 key를 받아온다.
	private int result;
	//result를 moveMap에 전달한다.
	
	public void baseMap(String key ,int eventResult1, 
			int eventResult2, 
			String input1, 
			String input2, 
			String input3) {
		//순서대로 받아온 열쇠, 이벤트 번호 1, 2, 스크립트 1, 2번이다.
		if((key == keyIn1 || 
				key == keyIn2) || 
				(key == keyIn3 || 
				key == keyIn4)
				)
			//제한 조건은 최대 4개까지 설정할 수 있고, 이후에는 복합조건 만족까지 구현예정
			//성격 두개, 아이템 두개중 한개씩은 맞아야 들어갈 수 있다.
		{
			System.out.println(input1);
			int random = r.nextInt(5);
			if(random == 0 ||
					random == 1 ||
					random == 2) {
				setResult(eventResult1);
				//랜덤 결과에 따라 이벤트 번호 전달.
				//이 경우가 나올 확률이 더 높다.
			}
			else if(random == 3 ||
					random == 4) {
				setResult(eventResult2);
				//위와 동일
				
			}
		}
		else {
			System.out.println(input2);
			System.out.println(input3);
			setResult(100);
			//이외의 경우 result를 고정헤 반복실행의 오류를 막는다.
		}
	}
	public String getKey() {
		return key;
		//key정보를 받아온다.
	}
	public void setKey(String key) {
		this.key = key;
		//key정보를 수정한다.
	}
	public int getResult() {
		return result;
		//result정보를 받아온다.
	}
	public void setResult(int result) {
		this.result = result;
		//result정보를 수정한다.
	}
}
