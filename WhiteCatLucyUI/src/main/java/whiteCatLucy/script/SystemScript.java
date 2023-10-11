package whiteCatLucy.script;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import whiteCatLucy.battle.Battle;
import whiteCatLucy.character.Monster;
import whiteCatLucy.option.Select;

public class SystemScript{
	private int count;
	private int click;
	private int check = 0;
	private String box;
	Select s = new Select();
	Scanner scan = new Scanner(System.in);
	
	public List<String> script = new ArrayList<>();
	
	
	public void intro() {
		//main에서 해당 스크립트 출력
		
		script.add("[하얀 고양이 루시는 그리운 목소리에 천천히 눈꺼풀을 들어 올렸습니다.]");
		script.add("[그녀는 주변을 감싼 따듯한 온기에 온몸이 노곤해져 금방이라도 폭신한 소파에 몸을 뉘이고 싶었지만, 코끝을 스치는 참치의 향에\r\n홀린 듯이 부얶으로 앞발이 내딪여졌습니다.]");
//		script.add("[1.부얶으로 향한다.] / [2.자제심을 발휘한다.]");
		
//		while(check == 0) {
//			for (int i = 0; i < script.size(); i++) {
//				click = scan.nextInt();
//				if(click == 1 && count < 3) {
//					box = script.get(count);
//					count++;
//					System.out.println(box);
//				}
//			}
//
//			boolean select = s.select();
//	
//			if(select == true) {
//				script.add("[루시는 참을 수 없는 유혹에 살짝 열려있는 부얶문을 밀고 들어가 홀연히 놓여있는 참치캔을 개눈 감추듯 먹어치워버렸습니다.]");
//				script.add("[노곤한 몸에 기분 좋은 포만감까지 더해지니 스륵 눈이 감기는 것은 한순간이였습니다.]");
//				script.add("[루시의 포만감이 1이/가 되었습니다.]");
//				//게임에 본격적으로 들어가게되면 초기화 상태로 시작한다.
//				check = 1;
//			}
//			else {
//				script.add("[루시는 초묘적인 인내심으로 그 유혹을 견뎌내었습니다.]");
//				script.add("[비록 입에서는 침이 고이는 것 같지만 똑똑한 고양이 루시는 한 번 정한 결정을 돌이키는 법이 없었습니다.]"	);
//				script.add("[잠시후, 루시는 입가에 묻은 연한 갈색의 무언가를 털어내고 폭신한 소파에 몸을 뉘였습니다.]");
//				script.add("[루시의 포만감이 1이/가 되었습니다.]");
//				check = 1;
//			}
//			
//			if(check == 1) {
//				script.add("[플레이어는 각각의 선택지마다 그에 걸맞는 아이템이나 스텟을 휙득할 수 있습니다.]");
//				script.add("[그렇게 얻은 아이템이나 스텟은 갈 수 없던 맵에 입장하거나, 선택지가 나타나게 하는게 가능합니다.]");
//				script.add("[이런식으로 상승한 능력치는 특정한 선택지를 개방하거나 맵에 이동할 수 있도록 만들어줍니다.]");
//				script.add("[게임이 시작되면 능력치는 초기화된 상태에서 시작됩니다.]");
//			}
//			for (int i = count; i < script.size(); i++) {
//				click = scan.nextInt();
//				if(click == 1) {
//					box = script.get(count);
//					count++;
//					System.out.println(box);
//				}
//			}
//		
//		}
//		count = 0;
//		check = 0;
	}
	public void tutoral2() {
		List<String> script = new ArrayList<>();
		script.add("[다음은 플레이어의 행동에 관한 튜토리얼입니다.]");
		script.add("[한 번 선택지를 고르고 나면 다음 행동을 결정할 수 있는 '메뉴'로 들어가게 됩니다.]");
		script.add("[플레이어는 맵 이동, 배낭열기, 휴식하기의 행동을 선택할 수 있습니다.]\n");
		script.add("[특히나 휴식하기의 경우 이벤트 이외에 플레이어의 성향을 변경할 수 있는 유일한 행동입니다.]");
		for (int i = 0; i < script.size(); i++) {
			click = scan.nextInt();
			if(click == 1) {
				box = script.get(count);
				count++;
				System.out.println(box);
			}
		}
		count = 0;
	}
	public void tutoral3() {
		List<String> script = new ArrayList<>();
		script.add("[이동한 맵에서는 여러가지 이벤트들이 일어나게됩니다.]");
		script.add("[이벤트에서 선택한 선택지에 따라 다음 나올 이벤트의 내용이 달라질 수 있습니다.]");
		for (int i = 0; i < script.size(); i++) {
			click = scan.nextInt();
			if(click == 1) {
				box = script.get(count);
				count++;
				System.out.println(box);
			}
		}
		count = 0;
	
	}
	public void tutoral4() {
		List<String> script = new ArrayList<>();
		script.add("[이벤트가 일어나면 일정 확률로 전투가 일어나게 됩니다.]");
		script.add("[전투로 휙득하는 아이템은 일반적인 아이템과 같은 효과를 발휘합니다.]");
		script.add("[전투에서 플레이어는 일반적인 공격, 아이템 사용, 스킬 사용의 행동을 선택할 수 있습니다.]");
		script.add("[스킬은 랜덤한 3개의 선택지중 1개를 골라 사용하는 방식이며, 같은 선택지가 등장할 수 있습니다.]");
		script.add("[플레이어와 몬스터는 둘 중 하나의 Hp가 0이하로 떨어질때까지 번갈아가며 각자의 행동을 실행합니다. ]");
		script.add("[모의 전투를 통해 흐름을 파악해봅시다.]");
		for (int i = 0; i < script.size(); i++) {
			click = scan.nextInt();
			if(click == 1) {
				box = script.get(count);
				count++;
				System.out.println(box);
			}
		}
		count = 0;
		
		Battle b = new Battle();
		Monster m = new Monster("허수아비", 10, 1);
		
		b.mDamage = m.attack();
		b.mHp = m.getHp();
		b.mName = m.getName();
		b.pDamage = 10;
		b.pHp = 100;
		b.pName = "루시";
		
		b.select = false;
		b.battle();
		
	}
}
