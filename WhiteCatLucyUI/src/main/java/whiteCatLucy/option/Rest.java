package whiteCatLucy.option;

public class Rest {
	//이후에 여러 이벤트를 랜덤하게 발생하도록 추가할 예정기에 따로 클래스로서 뺴놨다.
	public String tendencyKey;
	public void rest() {
		tendencyKey = "나태한";
		//성격을 변경한다.
		System.out.println("[루시는 온몸에서 힘이 쭉 빠져나가는 것을 느꼈습니다.]\r[루시의 상태가 "+tendencyKey+"으로 변경되었습니다.]");
		//변경된 성격을 알린다.
	}
}
