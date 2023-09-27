package whiteCatLucy.event;

import java.util.Scanner;
import whiteCatLucy.character.Monster;
import whiteCatLucy.character.STATE;
import whiteCatLucy.map.Ending;
import whiteCatLucy.option.Select;


public class IncidentEvent {
	//실행되는 이벤트를 모아둔 클래스다.
	
	Scanner scan = new Scanner(System.in);
	//이벤트 상에서 나타나는 선택지를 고르기 위한 스캐너
	Select s = new Select();
	//true와 false를 플레이어가 정하게 하는 클래스
	Monster m = new Monster("몹", 0, 0);
	public String tendencyKey;
	//이벤트에 따라 성격을 변화시키고 main에 반영한다. 
	public String item;
	//동일하다.
	public String itemCheck;
	//아이템 입장 조건 확인을 위한 변수
	public int result = 0;
	//main에서 정해진 result값을 불러와 적용한다.
	public int cU;
	public int fU;
	public int iU;
	//스테이터스를 임의로 정하고 main에서 적용한다.
	public int caution;
	public int fullness;
	public int intellect;
	//main에서 적용한 능력치를 토대로 조건 확인
	public boolean check = false;
	public int state;
	//enum을 실행한다.
	public int itemPower = 2;
	//임의로 아이템의 공격력을 지정했다.
	public String name;
	public int hp;
	public int damage;
	//플레이어의 스텟정보 메인에서 받아오기
	public int returnHp;
	//다시 플레이어에게 적용할 hp
	public STATE statusUp() {
		//플레이어에게 어떤 현상이 일어났는가를 알림과 동시에 main의 enum을 실행해 능력치를 반영한다.
		switch(state) {
		//능력치 변화를 알린다.
		case 1:
			System.out.println("[루시의 감이 조금 더 날카로워집니다.]");
			return STATE.CAUTION;
		case 2:
			System.out.println("[루시는 쏟아지는 포근함을 느낍니다.]");
			return STATE.FULLNESS;
		case 3:
			System.out.println("[루시는 조금 더 똑똑해졌습니다.]");
			return STATE.INTELLECT;
		default:
			System.out.println("[루시는 그루밍하고 있습니다.]");
			return STATE.RETURN;
		}
	}
	
	
	public String getendencyKey() {
		return tendencyKey;
		//main에서 어떤 성격이 되었는가를 표시한다.
	}
	public void setendencyKey(String tendencyKey) {
		this.tendencyKey = tendencyKey;
		//변동된 성격을 저장한다.
	}
	public void setItem(String item) {
		this.item = item;
	}
	public void itemCheck() {
		switch(result) {
		case 0:
			itemCheck = "스페이드 에이스";
			break;
		case 3:
			itemCheck = "검은 깃털";
			break;
		case 5:
			itemCheck = "오색보석";
			itemCheck = "찬란한 칠색보석";
			break;
		case 6:
			itemCheck = "영롱하게 빛나는 둥근 수정";
			break;
		case 7:
			itemCheck = "스페이드 에이스";
			break;	
		case 9:
			itemCheck = "파란 스카프";
			break;
		default:
			break;
		}
	}
	
	
	public void incidentEvent() {
	//각 맵당 2개씩 (집, 구름은 1개씩)
		m.playerStatus(name, hp, damage);
		m.pHp = 0;
		
	
		if(result == 0) {
			//result값에 따라 이벤트를 실행한다.
			System.out.println("[루시는 평소와 달리 적막함이 감도는 골목을 주시했습니다.]\n"
					+ "[널부러진 쓰레기들과 다색의 털들이 이곳에서 무언가 일이 일어났다는 것을 알려주는 듯 했죠.]\n"
					+ "[루시는 털이 곤두서는 불안함을 느끼며 어떻게 할지 고민했습니다.]\n"
					+ "[해금 아이템 : 스페이드 에이스]\n"
					+ "[1.돌아간다.]\r[2.조사한다.]\r");
			
			if(check == true) {
				//만약 설정된 성격이 조건을 만족한다면 실행한다.
				System.out.println("[조건을 만족하여 특수 선택지가 생성되었습니다.]\n");
				System.out.print("[3.나아간다.]\n");
			}
			int input1 = 0;
			//실행전에 input의 값을 초기화해준다.
			input1 = scan.nextInt();
			//플레이어의 선택을 입력한다.
			switch(input1) {
				case 1:
					System.out.println("[루시는 다칠지도 모른다는 생각에 그만 돌아가기로 했습니다.]\n"
							+"[주의력이 증가했습니다.]");
					state = 1;
					//주의력이 상승했음을 저장한다.
					cU=1;
					//상승한 주의력을 저장한다.
					//모든 능력치는 동일한 과정을 밟는다. 
					break;
					//switch를 빠져나간다.
				case 2:
					System.out.println("[루시는 조금 더 흔적을 살피다가 검은 깃털을 발견했습니다.]\n"
							+"[지능이 증가했습니다.]");
					item = "검은 깃털";
					state = 3;
					iU=1;
					break;
				case 3:
					if(check == true) {
						System.out.println("[루시는 용감하게 어둡고 습한 골목길을 지나 검은 나무들이 즐비한 숲을 발견했습니다.]\n"
								+"[루시는 호기심에 숲을 오래도록 쳐다보았습니다..]");
						m.shadowTree();
						returnHp = m.pHp;
						state = 0;
						item = "검은 나뭇잎";
						//아이템을 변수에 저장하고 main에서 실제로 리스트에 집어넣는다.
						tendencyKey = "호기심많은";
						//성격을 변수에 저장하고 main에서 실제로 적용한다.
					}
					break;
				default :
					//이외의 다른 숫자를 입력하면 실행하지 않도록 벗어난다.
					break;
			}
		 }
		
		//이하 모든 이벤트는 같은 형식.
		
		 if(result == 1) {
			 System.out.println("[루시는 골목길에서 어슬렁거리는 여러 동물들과 마주쳤습니다.]\n"
						+ "[그렇게 자주 외출하는 편은 아니여서 여러모로 달갑지만은 않았지만 동족의 모습을 확인 할 때면 왜인지 든든한 느낌을 받았습니다.]\n"
						+ "[루시는 그들에게 천천히 다가갔습니다.]\n"
						+ "[1.야옹]\r[2.그루밍한다.]\r");
				if(tendencyKey == "활발한")
				{
					System.out.println("[조건을 만족하여 특수 선택지가 생성되었습니다.]\n");
					System.out.print("[3.목석처럼 굳는다.]\n");
				}
				int input2 = 0; 
				input2 = scan.nextInt();
				switch(input2) {
					case 1:
						System.out.println("[루시는 같이 울어주는 동족에게 큰 안심을 느꼈습니다.]\n"
								+"[루시는 조금 더 활발해졌습니다.]");
						item = "알 수 없는 털";
						state = 0;
						tendencyKey = "활발한";
						break;
					case 2:
						System.out.println("[루시는 관심을 보이는 동족이 자신을 따라하는 것을 알 수 있었습니다.]\n"
								+"[지능이 증가했습니다.]");
						item = "무언가의 깨진 조각";
						state = 3;
						iU=+1;
						break;
					case 3:
						if(tendencyKey == "활발한") {
							System.out.println("[루시는 이 세상 모든 것들이 어쩌면 진짜가 아닐지도 모른다고 생각합니다.]\n");
							m.violentCat();
							returnHp = m.pHp;
							item = "스페이드 에이스";
							state = 3;
							iU=+3;
						}
							break;
					default :
						break;
				}
			}
	
			if(result == 2) {
			System.out.println("[루시는 검은 숲에서 기묘한 불길함을 느꼈습니다.]\n"
					+ "[선뜻 발이 앞으로 나아가지 못했지만 곧 무럭무럭 자라난 호기심으로 숲에 들어선 그녀는]\n"
					+ "[귓가를 울려오는 까마귀 울음소리와 기이한 숨소리에 바짝 털을 세웠습니다.]\n"
					+ "[위험해보이기는 했지만 지금 물러선다면 다시 돌아오기 위해서는 상당한 용기가 필요할 것 같습니다.]\n"
					+ "[1.돌아간다.]\r[2.나아간다.]\r");
			int input3 =0;
			input3 = scan.nextInt();
				switch(input3) {
					case 1:
						System.out.println("[루시는 위험한 모험에 발을 들이고 싶지는 않았습니다.]\n"
								+"[당분간 검은 숲에 돌아오기까지는 용기가 필요할 것 같습니다.]");
						state = 0;
						tendencyKey = "안정된";
						
						break;
					case 2:
						System.out.println("[루시는 용기있게 앞발을 내딫였습니다. 축축한 공기, 요동치는 검은 그림자, 불길한 소리가 귓가를 맵돕니다]\r"
								+ "[이곳에는 무언가 비밀이 숨어있을 것만 같습니다..]\n"
								+ "[주의력이 하락했습니다.]\n");
						m.shadowTree();
						returnHp = m.pHp;
						state = 1;
						cU=2;
						item = "그림자 조각";
						break;
				default :
					break;
				}
			}
			
			if(result == 3) {
				System.out.println("[어둡고 습한 숲, 루시는 어딘가 낮설지만은 않은 기시감을 느꼈습니다.]\n"
						+ "[언제든 이런 곳에 왔었다면 기억할 법도 한데 전혀 떠오르지 않아 답답함을 느끼면서도 루시는 숲을 배회했습니다.]\n"
						+ "[작은 울음소리조차 크게 번져 걷는 것조차 조심했습니다.]\n"
						+ "[해금 아이템 : 검은 깃털]\n"
						+ "[1.돌아간다.]\r");
				
				if(check == true)
				{
					System.out.println("[조건을 만족하여 특수 선택지가 생성되었습니다.]\n");
					System.out.print("[2.숲 안쪽을 응시한다.]\n");
				}
				int input4 = 0;
				input4 = scan.nextInt();
				switch(input4) {
				case 1:
					System.out.println("[루시는 기묘한 나뭇입을 입에 물고는 골목으로 돌아왔습니다.]\n"
							+"[지능이 증가했습니다.]");
					state = 3;
					iU=3;
					break;
				case 2:
					if(check == true) {
						System.out.println("[어째서 기시감이 느껴질까 의심한 루시는 존재감이 느껴지는 숲 안쪽을 조용히 응시했습니다.]\n"
								+"[정체를 알 수 없는 괴물과 타오르는 것 같은 그림자, 깨진 유리처럼 금이간 허공이 의심을 더욱 짙게 만듭니다.]");
						m.ilusionGost();
						returnHp = m.pHp;
						item = "예리한 장식물";
						state = 3;
						iU=3;
					}
					break;
				default :
					break;
				}
			}
			if(result == 4) {
				System.out.println("[루시는 따뜻하고 안락한 집에 돌아왔습니다.]\n"
						+ "[마음 쓸것도 없이 편안한 공기가 그녀의 긴장을 풀어주는 것 같습니다.]\n"
						+ "[1.쉰다.]\r[2.조사한다.]\r");
				if(tendencyKey == "의심많은" && (caution >= 30))
					//받아온 능력치를 토대로 비교해 조건을 만족하면 실행
				{
					System.out.println("[조건을 만족하여 특수 선택지가 생성되었습니다.]\n");
					System.out.print("[3.뒤를 돌아본다.]\n");
				}
				int input5 = 0;
				input5 = scan.nextInt();
				switch(input5) {
					case 1:
						System.out.println("[루시는 충분히 먹고 쉬며 지친 몸을 회복했습니다.]\n"
								+"[포만감이 증가했습니다.]");
						state = 2;
						item = "파란 스카프";
						fU=1;
						break;
					case 2:
						System.out.println("[굴러다니는 털뭉치, 바람에 흔들리는 달력과 커튼, 촉신한 소파. 항상 봐왔던 익숙한 것들이 상태를 안정시킵니다..]\n"
								+"[안정되었습니다..]");
						state = 0;
						item = "해진 털뭉치";
						tendencyKey = "안정된";
						break;
					case 3:
						if(tendencyKey == "의심많은" && (caution >= 30)) {
							System.out.println("[휙, 하고 뒤를 돌아보자 그 곳에는 정체를 알 수 없는 그림자가 지척에 서서 가만히 그녀를 내려다보고 있었습니다.]\n"
									+"[루시는 재빠르게 집으로 들어와 문을 닫고 침대 밑으로 숨었습니다.]");
							state = 1;
							cU=20;
						}
						break;
					default :
						break;
				}
			}
			if(result == 5) {
				System.out.println("[저마다의 색으로 빛나는 보석들이 곳곳에 박혀 눈길을 끕니다.]\n"
						+ "[루시는 잠시 멈춰서선 아름다운 루비를 발로 굴려봅니다.]\n"
						+ "[해금 아이템 : 오색보석]\n"
						+ "[해금 아이템 : 찬란한 칠색보석]\n"
						+ "[1.보석으로 논다.]\r[2.조사한다.]\r");
				if(tendencyKey == "의심많은" && (intellect >= 25))
				{
					System.out.println("[조건을 만족하여 특수 선택지가 생성되었습니다.]\n");
					System.out.print("[3.도망친다.]\n");
				}
				if(check == true)
				{
					System.out.println("[조건을 만족하여 특수 선택지가 생성되었습니다.]\n");
					System.out.print("[4.깊숙한 곳으로 들어간다.]\n");
				}
				int input6 = 0;
				input6 = scan.nextInt();
				switch(input6) {
				case 1:
					System.out.println("[루시는 신기한 보석에 정신이 홀렸습니다.]\n"
							+"[주의력이 감소했습니다.]");
					state = 1;
					item = "오색보석";
					cU=7;
					break;
				case 2:
					System.out.println("[형형색색의 보석들은 누군가의 마음을 훔칠 준비가 되어있습니다.]");
					state = 0;
					item = "찬란한 칠색보석";
					tendencyKey = "호기심많은";
					break;
				case 3:
					if(tendencyKey == "의심많은" && (intellect >= 25)) {
					System.out.println("[소름끼치는 느낌에 곧바로 도망치는 루시의 뒤로 곳곳에 보석이 박힌 거대한 손이 그녀를 잡기 위해 튀어나왔습니다.]\n"
								+"[루시는 재빠르게 도망쳤습니다.]");
					state = 1;
					cU=10;
					break;
					}
				case 4:
					if(check == true) {
					System.out.println("[동굴의 끝에는 빛을 잃은 보석들이 아무렇게나 방치되어있었습니다.]\n"
								+"[루시는 찬란하게 빛나는 칠색의 보석을 빛을 잃은 보석에 가져다 대었습니다.]");
					m.jewelGolem();
					returnHp = m.pHp;
					state = 1;
					item = "영롱하게 빛나는 둥근 수정";
					cU=10;
					break;
					}	
				default :
					break;
				}
			}
			if(result == 6) {
				System.out.println("[눈을 사로잡는 보석들이 발밑에 채일정도로 굴러다니는 동굴의 모습에 루시는 신기함을 느낍니다.]\n"
						+ "[루시는 비록 아름답기는 하지만 먹을 수도, 가지고 돌아갈 수도 없는 보석에 관심이 옅어집니다.]\n"
						+ "[해금 아이템 : 영롱하게 빛나는 둥근 수정]\n"
						+ "[1.보석을 조사한다.]\r[2.동굴의 안쪽으로 향한다.]\r");
				
				if(check == true)
				{
					System.out.println("[조건을 만족하여 특수 선택지가 생성되었습니다.]\n");
					System.out.print("[3.보석을 삼켜본다.]\n");
				}
				int input7 = 0;
				input7 = scan.nextInt();
				switch(input7) {
				case 1:
					System.out.println("[어떻게 빛이 나는지는 알 수 없지만 일반적인 보석과 크게 다르지는 않습니다.]\n"
							+"[지능이 증가했습니다.]");
					state = 3;
					iU=3;
					break;
				case 2:
					System.out.println("[동굴의 가장 안쪽에는 수많은 보석들이 뭉처진 거대한 덩어리가 홀연히 놓여있었습니다.]\n"
							+ "[루시는 어딘가 위험해보이는 느낌에 동굴을 벗어났습니다.]");
					state = 3;
					iU=7;
					break;
				case 3:
					if(check == true) {
						System.out.println("[무심코 삼켜버린 보석탓인지 몸이 따뜻해지고 힘이 넘치는 듯한 느낌이 듭니다.]");
						state = 2;
						fU=10;
					}
						break;
				default :
					break;
				}
			}
		
			if(result == 7) {
				System.out.println("[구름은, 굉장히 포근하고 따듯했습니다. 저도 모르게 눈물이 고일정도로 익숙하고 고대하던 것이였죠.]\n"
						+ "[그녀는 언제나 구름같이 여유롭고 포근한 존재였습니다.]\n"
						+ "[나의 생은 온전히 그녀의 온기로 가득했고, 더 없을 정도로 행복한 사람이였음을 쉽게 알 수 있었습니다.]\n"
						+ "["+"\"여기에 있나요 루...시?\""+"]\n"
						+ "[1.대답한다.]\r[2.대답하지 않는다.]\r");
				int input8 = 0;
				input8 = scan.nextInt();
				switch(input8) {
					case 1:
						System.out.println("[루시는 서늘한 느낌이 목덜미를 스치는 것을 느꼈습니다.]\n");
						m.cloudFisher();
						returnHp = m.pHp;
						break;
					case 2:
						System.out.println("[이윽고 목소리는 기괴한 괴물의 그것으로 변해 끔찍한 소음을 자아냅니다.]");
						tendencyKey = "두려움";
						m.cloudFisher();
						returnHp = m.pHp;
						break;
					default :
						break;
				}
			}
			if(result == 8) {
				System.out.println("[도로 위를 달리는 차와 변하지 않는 신호등을 기다리는 사람들.]\n"
						+ "[루시는 위화감을 느꼈지만 그게 무엇인지 좀처럼 알 수 없었습니다.]\n"
						+ "[해금 아이템 : 파란 스카프]\n"
						+ "[1.가만히 서서 관찰한다.]\r[2.돌아간다.]\r");
				if(tendencyKey == "호기심많은" && check == true)
				{
					System.out.println("[조건을 만족하여 특수 선택지가 생성되었습니다.]\n");
					System.out.print("[3.휭단보도를 건너본다.]\n");
				}
				int input9 = 0;
				input9 = scan.nextInt();
				switch(input9) {
				case 1:
					System.out.println("[그것은 마치 같은 영상을 연속재생하는 것 만큼이나 의미없는 일이였습니다.]\n"
							+"[지능이 감소했습니다.]");
					state = 3;
					iU=5;
					break;
				case 2:
					System.out.println("[아무것도 변할게 없다고 생각한 루시는 빨리 집에 돌아가 밥을 챙겨먹었습니다.]\n"
							+ "[포만감이 상승합니다.]");
					state = 2;
					fU=7;
					break;
				case 3:
						if(tendencyKey == "호기심많은" && check == true) {
						System.out.println("[이상하리만큼 아무런일도 일어나지 않을거란 생각에 루시는 천천히 휭단보도 위를 걸어가기 시작했습니다.]\n"
								+ "[그리고 그 생각이 맞았다는 듯, 사람들은 못박힌듯 미동도 없었고 자동차는 그저 홀로그램처럼 지나갔습니다.]");
						m.eyeWithAngelWings();
						returnHp = m.pHp;
						state = 1;
						cU=20;
						System.out.println("[특수조건을 만족했습니다.]");
						Ending end = new Ending();
						end.ending();
					}
					break;
				default :
					break;
				}
			}
			if(result == 100) {
				//만약 이벤트가 발동하지 않는 선택을 한다면 공백을 출력한다.
				System.out.println("[싸늘한 공기만이 뺨을 스칩니다.]");
			}
	}
	public void setResult(int result) {
		this.result = result;
	}
}