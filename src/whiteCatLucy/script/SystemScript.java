package whiteCatLucy.script;

import whiteCatLucy.option.Select;

public class SystemScript{
	Select s = new Select();
	String tendency;
	int fullness;
	int intellect;
	int caution;
	public void tutoral() {
		System.out.println("[하얀 고양이 루시는 그리운 목소리에 천천히 눈꺼풀을 들어 올렸습니다.]\n\n"
				+ "[그녀는 주변을 감싼 따듯한 온기에 온몸이 노곤해져 금방이라도 폭신한 소파에 몸을 뉘이고 싶었지만, 코끝을 스치는 참치의 향에\r\n"
				+ "홀린 듯이 부얶으로 앞발이 내딪여졌습니다.]\n\n"
				+ "[1.부얶으로 향한다.] / [2.자제심을 발휘한다.]\n\n"
				+ "[플레이어는 각각의 선택지마다 그에 걸맞는 아이템이나 스텟을 휙득할 수 있습니다.]\n"
				+ "[그렇게 얻은 아이템이나 스텟은 갈 수 없던 맵에 입장하거나, 선택지가 나타나게 하는게 가능합니다.]");
		if(s.select() == true) {
			System.out.println("[루시는 참을 수 없는 유혹에 살짝 열려있는 부얶문을 밀고 들어가 홀연히 놓여있는 참치캔을 개눈 감추듯 먹어치워버렸습니다.]\r\n\n"
					+ "[노곤한 몸에 기분 좋은 포만감까지 더해지니 스륵 눈이 감기는 것은 한순간이였습니다.]");
			fullness += 1;
			System.out.println("[루시의 포만감이 "+fullness+"이/가 되었습니다.]");
		}
		else {
			System.out.println("[루시는 초묘적인 인내심으로 그 유혹을 견뎌내었습니다.]\n[비록 입에서는 침이 고이는 것 같지만 똑똑한 고양이 루시는"
					+ " 한 번 정한 결정을 돌이키는 법이 없었습니다.]\n[잠시후, 루시는 입가에 묻은 연한 갈색의 무언가를 털어내고 폭신한 소파에 몸을 뉘였습니다.]");
			fullness += 1;
			System.out.println("[루시의 포만감이 "+fullness+"이/가 되었습니다.]\n\n");
		}
	}
	public void tutoral2() {
		System.out.println("[한 번 선택지를 고르고 나면 다음 행동을 결정할 수 있는 '메뉴'로 들어가게 됩니다.]\n\n");
	}
	public void tutoral3() {
		System.out.println("[이동한 맵에서는 여러가지 이벤트들이 일어나게됩니다.]\r[이벤트에서 선택한 선택지에 따라 다음 나올 이벤트의 내용이 달라질 수 있습니다.]");
		
	}
}
