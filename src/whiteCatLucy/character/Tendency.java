package whiteCatLucy.character;

public class Tendency {
	//맵에 집입할 수 있는 조건이 되는 성격을 지정할 수 있는 클래스다.
	private String tendency;
	//열쇠 이외의 역할은 현재 존재하지 않는다. 그러므로 이외의 값을 부여하지 ㅇ낳았다.
	
	public Tendency(String tendency) {
		this.tendency = tendency;
		//성격을 지정한다.
	}
	
	public String getKey() {
		return tendency;
		//지정된 성격을 불러온다.
	}
}
