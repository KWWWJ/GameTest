package whiteCatLucy;

import java.util.Scanner;

import whiteCatLucy.battle.Battle;
import whiteCatLucy.character.Lucy;
import whiteCatLucy.character.Monster;
import whiteCatLucy.character.STATE;
import whiteCatLucy.event.IncidentEvent;
import whiteCatLucy.option.UserSelect;
import whiteCatLucy.script.MelyScript;
import whiteCatLucy.script.SystemScript;

public class Main {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		//튜토리얼을 진행하기 위한 스캐너 - 튜토리얼 클래스로 만드는게 더 깔끔할 것 같다.
		Lucy lucy = new Lucy("루시", 100, 5);
		//플레이어 캐릭터인 Lucy를 새로 생성하는 클래스. 가방, 스테이터스의 뼈대를 새롭게 만든다.
		SystemScript script = new SystemScript();
		//튜토리얼의 시스템 스크립트로 게임내 화자가 구분될 수 있게 만들어두었다.
		MelyScript mely = new MelyScript();
		//튜토리얼의 Lucy의 주인으로 설정된 인물의 대사다.
		IncidentEvent ie = new IncidentEvent();
		//어떠한 맵에 들어가게 되었을 때, 그에 맞는 이벤트를 실행할 수 있는 클래스다.
		UserSelect us = new UserSelect();
		//맵에 들어가거나 휴식하는 행동을 결정할 수 있는 클래스를 새로 만든다.
		Battle b = new Battle();
		//전투 시스탬을 호출하는 클래스
		Monster m = new Monster("몹", 0, 0);
		//몬스터를 호출하는 클래스
		Battle battle = new Battle();
		//서로 새롭게 생성하거나 부르지 못하는 클래스를 최종적으로 main클래스에서 생성했다. 
		
		//튜토리얼 스크립트
		mely.startScript();
		//mely클래스 내에 위치한 메서드 스크립트를 실행한다.
		System.out.println("[튜토리얼을 시작하겠습니다. 아무 키나 입력하여 다음으로 넘어가주세요.]");
		//다음 스크립트가 주르륵 떠 눈을 어지럽게 하지 않게하기 위해 텀을 주는 스캐너다.
		script.intro();
		//시스템 스크립트 중 튜토리얼을 담당하는 메서드를 불러온다.
		script.tutoral2();
		script.tutoral3();
		script.tutoral4();
		
		String next1 = scan.next();
		//텀을 주는 스케너다.

		//게임이 어떤 식으로 흘러가는지를 파악하게 하기 위해 간략하게 만들어둔 튜토리얼이다. 이후 새로운 매커니즘이 업데이트 될떄마다 해당 란에서 추가로 설명될 예정이다.  
		
		//게임 시작
		while(true) {
			//게임이 종료조건을 만족하기 전까지는 계속해서 진행 가능하도록 반복문을 사용했다.
			ie.state = 0;
			//능력치 상승 및 성격 초기화
			us.userSelect();
			if(us.tendencyKey != null) {
				lucy.addTendency(us.tendencyKey);
				//휴식으로 인한 성격변화는 독립적이라 새로 만들어야 한다.
				ie.tendencyKey = null;
				us.tendencyKey = null;
				us.event = false;
				//이벤트가 자동실행되지 않도록 방지
			}
		
			if(us.bagOpen == true) {
				//가방을 여는 조건을 boolean으로 설정한다.
				if(lucy.bag.size() == 0) {
					System.out.println("[가방에는 먼지만 굴러다니고 있습니다.]");
					//없으면 출력
				}
				System.out.println(lucy.getBag());
				System.out.println();
				us.bagOpen = false;
				//다시 초기화해서 자동으로 작동하지 않도록 설정.
				us.event = false;
				//이벤트가 자동실행되지 않도록 방지
			}
			//유저가 맵을 이동하거나 휴식하는 것을 선택할 수 있다.
			//이를 통해 플레이어는 현재 자신의 상태를 바꿔 특정한 맵에 진입할 수 있는 조건을 만족할 수 있게된다.
			
			if(us.event == true) {
				//만약 플래이어가 맵으로 이동하는것을 선택했다면, true가 만족되어 아래 코드를 실행한다.
				ie.setResult(us.result);
				//각기 다른 맵에서 변경된 result의 값을 저장한다.
				ie.itemCheck();
				//reusult값 받아서 그에 맞는 열쇠구멍 생성
				for(int i=0; i<lucy.bag.size(); i++) {
					if(lucy.bag.get(i).getItem() == ie.itemCheck) {
						ie.check = true;
						System.out.println("[루시는 배낭을 뒤적여 웬지 모르게 신경쓰이는 물건을 꺼냈습니다.]");
						System.out.println("\n");
						//조건을 true로 변경해 만족상태로 진입
					}
				}
				
				ie.name = "루시";
				ie.hp = lucy.getHp();
				ie.damage = lucy.attack();
				//스텟정보 넘겨주기
				
				ie.incidentEvent();
				//저장된 값을 적용해 해당하는 이벤트를 실행한다.
				lucy.takeDamage(ie.returnHp);
				//전투로 입은 데미지 환산하기
				ie.returnHp = 0;
				//while에 반복적으로 깍이지 않게 하기 위해 초기화
				ie.check = false;
				//다시 조건을 초기화하여 다음 조건에 대비한다.
				if(ie.tendencyKey == null) {
					//받은 성격이 null이면 아무것도 하지 않는다.
					//이것으로 한 번 사용된 성격이 이후로도 유지될 수 있도록 조정
					System.out.println();
				}
				else {
					lucy.addTendency(ie.tendencyKey);
					//이벤트를 통해 변경된 tendencyKey를 main에서 저장한다.
					//성격이 null이 아니면 추가한다.
					us.key = ie.tendencyKey;
					//현재 플레이어의 tendencyKey값을 대입해 특정한 맵에 진입가능한 조건을 전달한다.
					if(lucy.tendency.get(0).getKey() == ie.tendencyKey) {
						
					}
					else {
						System.out.println("[루시의 상태가 "+ie.tendencyKey+"으로 변경되었습니다.]");
						//현제 상태 출력
						//이후 이벤트를 실행하지 않아도 출력되는 것을 방지
					}
	
				}
				ie.result = 100;
				//값을 초기화하여 중복발생을 막는다.
			}
			System.out.println();
			//글을 읽을 공간이 답답한 느낌을 줄 수 있기 때문에 공백을 넣어 공간을 구분한다.
			
			for (int i=0; i<lucy.bag.size(); i++) {
				if(lucy.bag.get(i).getItem() == ie.item) {
					ie.item = null;
				}
			}
			//아이템이 중복이라면 null로 바꾼다.
			
			if(ie.item == null) {
				//만약 플레이어가 이벤트를 통해 아이템을 휙득하지 않았다면 공백을 출력한다.
				System.out.println();
			}
			else {
				//만약 플레이어가 아이템을 휙득했다면 아래 코드를 실행한다.
				lucy.addItem(ie.item, ie.itemPower);
				lucy.getItem(ie.itemPower);
				//해당 아이템값을 아이템 ArrayList에 저장한다.
				System.out.println("[휙득한 아이템]");
				System.out.println("["+lucy.bag.get(lucy.bag.size()-1).getItem()+"]");
				System.out.println();
				//휙득한 모든 아이템을 출력하여 보여준다.
				ie.item = null;
				//초기화 하여 해당하는 이벤트를 수행하지 않고 아이템이 다시 휙득되는 현상을 방지하기 위해 null로 설정한다.
			}
			
			STATE statusChange = ie.statusUp();
			//플레이어가 이벤트를 통해 스테이터스가 상승한 것을 main클래스에서 반영한다.
			switch(statusChange) {
			case CAUTION:
				lucy.cautionUp(ie.cU);
				//플레이어의 주의력을 상승시킨다. set의 값을 가진다.
				System.out.println("[루시의 주의력이 "+lucy.getCaution()+"이/가 되었습니다.]");
				System.out.println();
				//오른 값이 적용된 현재 수치를 보여준다.
				break;
				//다음 코드가 실행되는 것을 방지한다.
			case FULLNESS:
				lucy.fullnessUp(ie.fU);
				//플레이어의 포만감을 상승시킨다. set의 값을 가진다.
				System.out.println("[루시의 포만감이 "+lucy.getFullness()+"이/가 되었습니다.]");
				System.out.println();
				//오른 값이 적용된 현재 수치를 보여준다.
				break;
				//다음 코드가 실행되는 것을 방지한다.
			case INTELLECT:
				lucy.intellectUp(ie.iU);
				//플레이어의 지능을 상승시킨다. set의 값을 가진다.
				System.out.println("[루시의 지능이 "+lucy.getIntellect()+"이/가 되었습니다.]");
				System.out.println();
				//오른 값이 적용된 현재 수치를 보여준다.
				break;
				//다음 코드가 실행되는 것을 방지한다.
			default:
				//만약 스테이터스 상승이 이루어지지 않았다면 아무것도 출력하지 않는다.
				break;
				//switch를 빠져나온다.
			}
			System.out.println("\n[현재 루시의 상태]");
			System.out.println("[상태 : "+lucy.getTendency()+"]");
			System.out.println("[HP : "+lucy.getHp()+"]");
			System.out.println("[Atk : "+lucy.attack()+"]");
			System.out.println("[주의력 : "+lucy.getCaution()+"]");
			ie.caution = lucy.getCaution();
			System.out.println("[포만감 : "+lucy.getFullness()+"]");
			ie.caution = lucy.getFullness();
			System.out.println("[지능 : "+lucy.getIntellect()+"]");
			ie.caution = lucy.getIntellect();
			//플레이어의 상태를 표시하고 조건에 들어갈 능력치를 반영한다.
			
		}
	}
	
}






// 게임의 흐름.
// while문으로 게임 시작 > 유저가 맵을 이동할지, 휴식할지를 선택

// 1-1. 맵 이동을 선택하면 맵 이동을 정말로 실행할건지 그 여부를 선택(event가 true가 된다.) > 이동한 맵에서 어떤 이벤트를 실행할지
// 그 번호를 가져온다. > 가져온 번호를 이벤트 맵 클래스의 result변수에 집어넣는다.
// 이벤트 메서드가 호출되면서 적용된 result에 맞는 이벤트를 출력한다.(만약 중복발생하면 100으로 고정해 공란을 출력한다.)

//// 문제 1. 적용한 성격이 맵의 입장조건과 대조되지 않아 입장 불가능한 상황이 발생한다.
//// 해결 : 입장 조건 자체에서 &&의 범위가 비정상적인 것을 ||로 조정하고 스캐너가 자동으로 int를 기억하고 넘어가는 것을 
//// nextLine으로 변경했다.

//// 문제 2. 성격 변화 이후 맵에 입장시 result가 무조건 0으로 고정되어 해당 이벤트만 출력한다.
//// 해겷 : result에 get, set을 걸어 확실하게 대입하도록 바꾸었다.

// 1-2.휴식을 선택하면 상태가 변경되고 현제 스테이터스를 출력한 뒤 다시 맵이동과 휴식의 선택지로 돌아온다. 

// 2. 이후 성격이 변경되었다면 그 성격을 tendencyKey 변수에 집어넣고 적용시키고, 아이템을 휙득했다면 아이템을 리스트에 추가한다.

// 3. 이벤트나 휴식을 통해 변경된 성격은 맵의 입장조건으로 대입되고, 변경된 능력치가 출력되면 다시 맵이동과 휴식선택으로 돌아온다.

////////////////////////////////
// 이후 추가 계획
// 1. 배틀형식의 이벤트를 만들어 각 이벤트에 덧붙이기.
// 2. 엔딩 및 스크립트의 추가
// 3. 아이템에 추가적인 값(데미지, 효과 등등)을 추가