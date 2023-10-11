package whiteCatLucy.battle;

import java.util.Random;
import java.util.Scanner;

import whiteCatLucy.character.Skill;

public class Battle {
	Scanner scan = new Scanner(System.in);
	Random r = new Random();
	SkillList sl = new SkillList();
	public String pName;
	public String mName;
	public int pDamage;
	public int mDamage;
	public int pHp;
	public int mHp;
	boolean pLife;
	boolean mLife;
	public int skillUse;
	public boolean select;
	boolean skillAttack = false;
	boolean SpecialArmorUse = false;
	int turnS = 0;
	int turnL = 0;
	int turnU = 0;
	int armor = 0;
	int SpecialArmor = 0;
	int count = 0;
	int skillCount = 0;
	int counvert = 0;
	
	public void battleLog() {
		int damage = 0;
		if((armor - mDamage)<0) {
			damage = ((armor - mDamage)*-1);
		}
		int bDamage = 0;
		if((armor - mDamage)<0) {
			bDamage = (((armor-3) - mDamage)*-1);
		}
		int criticalDamage = 0;
		if((armor - mDamage)<0) {
			criticalDamage = (((armor/2) - (mDamage * 2))*-1);
		}
		int bDriticalDamage = 0;
		if((armor - mDamage)<0) {
			bDriticalDamage = (((armor/2) - (mDamage * 2))*-1);
		}
		if(r.nextInt(100) > 89 && skillAttack==true) {
			System.out.println("[치명적인 피해!]");
			System.out.println("[루시는 "+mName+"에게 "+(pDamage * 2)+"만큼의 피해를 입혔습니다!]\n");
			mHp -= pDamage * 2;
		}
		else if(r.nextInt(100) <= 89 && skillAttack==true){
			System.out.println("[루시는 "+mName+"에게 "+pDamage+"만큼의 피해를 입혔습니다.]\n");
			mHp -= pDamage;
		}
		System.out.println("["+mName+"의 HP : "+mHp+"]\n");
		if(mHp <= 0) {
			System.out.println("["+mName+"을/를 물리쳤습니다!]");
			System.out.println("[전투의 고양감이 사그라듭니다.]");
			mLife = false;
		}
		if(mHp == mHp/2) {
			System.out.println("["+mName+"이/가 날뛰기 시작합니다!]");
			int event = r.nextInt(100);
			if(event >= 30) {
				pase2();
			}
			else {
				if(r.nextInt(100) > 89 && mHp > 0) {
					System.out.println("[치명적인 피해!]");
					System.out.println("["+bDriticalDamage+"만큼의 피해를 입었습니다!]\n");
						pHp -= bDriticalDamage;
				}
				else if(mHp > 0){
					System.out.println("["+mName+"의 공격! "+bDamage+"만큼의 피해를 입었습니다.]\n");
						pHp -= bDamage;
				}
			}
			
		}
		else {
			if(r.nextInt(100) > 89 && mHp > 0) {
				System.out.println("[치명적인 피해!]");
				System.out.println("["+criticalDamage+"만큼의 피해를 입었습니다!]\n");
					pHp -= criticalDamage;
			}
			else if(mHp > 0){
				if(mDamage>armor) {
					System.out.println("["+mName+"의 공격! "+damage+"만큼의 피해를 입었습니다.]\n");
					pHp -= damage;
				}
				else {
					System.out.println("["+mName+"이/가 공격했지만 루시는 재빠르게 움직여 피해를 입지 않았습니다.]\n");
				}
			}
		}
		System.out.println("["+pName+"의 HP : "+pHp+"]\n");
		if(pHp <= 0) {
			System.out.println("["+mName+"으로부터 필사적으로 도망쳤습니다...]");
			pLife = false;
		}
		
	}
	
	public void pase2() {
		int event = r.nextInt(100);
		if(mHp < 50 && mName.equals("보석골램")) {
			System.out.println("[거대한 암석 덩어리가 떨어져나가고 자줏빛의 보석이 시선을 사로잡듯 발광합니다!]");
			if(event>49) {
				System.out.println("[불길하게 빛나는 보석에서 강대한 힘이 쏟아져 나왔습니다..!]");
				pHp -= mDamage;
			}
			else {
				System.out.println("[폭주한 보석은 이윽고 불안정함을 견디지 못해 터져나갔습니다!]");
				mHp -= 100;
			}
		}
		
		if(mHp < 30 && mName.equals("구름 낚는 자")) {
			System.out.println("[구름 낚는 자가 구름속에 들여둔 낚싯대를 끌어올립니다.]");
			if(event>70) {
				System.out.println("[휘둘러진 낙싯대의 끝에서 날카로운 기운이 느껴집니다!]");
				pHp -= mDamage;
				pHp -= mDamage;
				pHp -= mDamage;
				pHp -= mDamage;
				System.out.println("[날카로운 고통에 몸서리처집니다!]");
			}
			else if(event <= 29 && event >= 0){
				System.out.println("[낚싯대 끝에서 붉은 과실이 걸려 나왔습니다.]");
				mHp += 20;
				System.out.println("[구름 낚는자가 체력을 회복했습니다.]");
			}
			else if(event <= 70 && event >= 30) {
				System.out.println("[구름 낚는자가 낚싯대를 강하게 휘두릅니다!]");
				pHp -= mDamage;
				pHp -= mDamage;
			}
			
		}
		
		if(mHp < 30 && mName.equals("그림자 나무")) {
			System.out.println("[바닥이 그림자로 뒤덮입니다.]");
			if(event>70) {
				System.out.println("[그림자가 발목을 타고 올라와 묶습니다!]");
				pHp -= mDamage;
				System.out.println("[발목이 찌그러지는 고통에 몸서리처집니다!]");
			}
			else if(event <= 29 && event >= 0){
				System.out.println("[그림자가 터져나갑니다.]");
				pHp -= mDamage;
				pHp -= mDamage;
				mHp -= 10;
				System.out.println("[강대한 폭발에 그림자 나무가 피해를 입었습니다.]");
			}
			else if(event <= 70 && event >= 30) {
				System.out.println("[그림자 나무가 여력을 쏟아 마지막 일격을 가합니다!]");
				pHp -= mDamage;
				pHp -= mDamage;
				pHp -= mDamage;
				mHp -= 20;
			}
		}
		
		if(mHp == 0) {
			System.out.println("[흔들리던 형체가 고치처럼 단단한 무언가에 감싸입니다.]");
			if(event>=90) {
				System.out.println("[떨어져나간 형체가 다시 들러붙습니다.]");
				mHp += 20;
				System.out.println("[발목이 찌그러지는 고통에 몸서리처집니다!]");
			}
			else if(event <= 29 && event >= 0){
				System.out.println("[형체가 사그라듭니다.]");
			}
			else if(event <= 89 && event >= 30) {
				System.out.println("[형체가 흔들리더니 기괴한 괴물을 변해 달려듭니다!]");
				pHp -= mDamage;
				
			}
		}
		
		if(mHp < 10) {
			System.out.println("[난폭한 고양이가 털을 바짝 세웁니다.]");
			if(event>70) {
				System.out.println("[기습적인 할퀴기!]");
				pHp -= mDamage;
			}
			else if(event <= 70 && event >= 30) {
				System.out.println("[이성을 윓고 날뛰는 난폭한 고양이가 마구잡이로 공격합니다!]");
				pHp -= mDamage;
				pHp -= mDamage;
				pHp -= mDamage;
			}
		}
		
		if(mHp < 100) {
			System.out.println("[흉측한 눈동자가 거대한 6쌍의 날개를 활짝 펴고 날아올랐습니다!]");
			if(event>70) {
				System.out.println("[거대한 눈동자가 힘을 충전합니다.]");
				count++;
			}
			else if(event <= 29 && event >= 0){
				System.out.println("[하늘에서 내리는 새빨간 빛이 눈동자를 회복시킵니다...]");
				mHp += 30;
				System.out.println("[강대한 폭발에 그림자 나무가 피해를 입었습니다.]");
			}
			else if(event <= 70 && event >= 30) {
				System.out.println("[눈동자가 충전한 힘을 방사합니다!]");
				if(count != 0) {
					for(int i=0; i<count; i++) {
						pHp -= mDamage;
						pHp -= mDamage;
					}
				}
				else {
					System.out.println("[아직 충분히 모으지 않아 기술을 실패했습니다.]");
					mHp -= 20;
				}
			}
		}
	}
	private void randomSkill(int skillNumber) {
		switch(skillNumber) {
		case 0:
			skillCount++;
			System.out.println(skillCount+"[강타]");
			break;
		case 1:
			skillCount++;
			System.out.println(skillCount+"[가벼운 몸놀림]");
			break;
		case 2:
			skillCount++;
			System.out.println(skillCount+"[알 수 없는 기운]");
			break;
		case 3:
			skillCount++;
			System.out.println(skillCount+"[따스한 빛]");
			break;
		case 4:
			skillCount++;
			System.out.println(skillCount+"[무형갑]");
			break;
		case 5:
			skillCount++;
			System.out.println(skillCount+"[강타]");
			break;
		default :
			break;
		}
	}
	private void convertSkill(int skillNumber) {
		if(skillNumber == 0) {counvert = 1;}
		if(skillNumber == 1) {counvert = 2;}
		if(skillNumber == 2) {counvert = 3;}
		if(skillNumber == 3) {counvert = 4;}
		if(skillNumber == 4) {counvert = 5;}
		if(skillNumber == 5) {counvert = 6;}
	}
	public void battle() {
		System.out.println("[루시는 주변을 배회하던 "+mName+"와/과 마주했습니다!]");
		while(pHp > 0 && mHp > 0) {
			
			if(select == false) {
				System.out.println("\n");
				System.out.println("[루시의 hp : "+pHp+"]");
				System.out.println("["+mName+"의 hp : "+mHp+"]");
				System.out.println("\n");
				System.out.println("[행동]\n");
				System.out.println("[1.공격한다]\n"
						+"[2.아이템을 사용한다.]\n"
						+"[3.스킬을 사용한다.]");
			}
			else if(select == true) {
				
			}
			String input = scan.next();
			
			switch(input) {
			
			case "1":
				skillAttack = true;
				battleLog();
			break;	
			case "2":
				System.out.println("구현중");
				break;
			case "3":
				String skillUse = null;
				//초기화해서 자동으로 넘어가버리는 경우를 제한한다.
				
				Random firstSkill = new Random();
				Random secondSkill = new Random();
				Random thridSkill = new Random();
				
				int fs = firstSkill.nextInt(6);
				int ss = secondSkill.nextInt(6);
				int ts = thridSkill.nextInt(6);
				// 스킬 사용시 6개중 3개만 선택지에 등장. 그중 하나를 선택하는 것으로 스킬을 사용한다.
				// 중복 허용
				
				// 뽑힌 스킬 출력
				randomSkill(fs);
				randomSkill(ss);
				randomSkill(ts);
				
				System.out.println("\n[사용할 스킬을 선택해주세요.]");
				
				int skillSelect = scan.nextInt();
				
				// 변환용 변수
				
				// 플레이어의 선택과 입력값을 일치시킨다.
				switch(skillSelect) {
				case 1:
					convertSkill(fs);
					break;
				case 2:
					convertSkill(ss);
					break;
				case 3:
					convertSkill(ts);
					break;
				}
				
				
				switch(counvert) {
				case 1:
					System.out.println("[일반공격의 두배의 데미지를 가한다. 대신 반동으로 10hp가 깍인다.]");
					System.out.println("[스킬을 사용하시겠습니까? Y / N]");
					skillUse = scan.next();
					if(skillUse.equals("y")) {
						Skill s = new Skill("[강타]","[일반공격의 두배의 데미지를 가한다. \n쿨타임 : 5턴]", pDamage*2, 0, 0, 0);
						pDamage = s.attack();
						pHp -= 10;
						System.out.println("[루시는 온힘을 다해 강력한 일격을 가했습니다!]");
						System.out.println("[반동으로 루시의 hp가 10 하락했습니다.]");
						skillAttack = true;
						battleLog();
					}
					else {
						break;
					}
					break;
				case 2:
					System.out.println("[몸을 가볍게 만들어 이번턴의 데미지를 줄여받고 공격력을 각각 7씩 올린다.]");
					System.out.println("[스킬을 사용하시겠습니까? Y / N]");
					skillUse = scan.next();
					if(skillUse.equals("y")) {
						Skill s = new Skill("[가벼운 몸놀림]", "[몸을 가볍게 만들어 다음턴까지 데미지를 줄여받고 공격력을 각각 7씩 올린다.] \n[쿨타임 : 4턴]", 0, 0, 7, 7);
						pDamage += s.plusAttack();
						mDamage -= s.defence();
						System.out.println("[루시는 전투태세를 취했습니다.]");
						skillAttack = false;
						battleLog();
					}
					else {
						break;
					}
					break;
				case 3:
					System.out.println("[알 수 없는 기운이 몸을 감싸 다음 공격의 위력을 15만큼 올린다. 대신 그 반동으로 공격에 취약해져 데미지를 10만큼 더 받는다.]");
					System.out.println("[스킬을 사용하시겠습니까? Y / N]");
					skillUse = scan.next();
					if(skillUse.equals("y")) {
						Skill s = new Skill("[알 수 없는 기운]","[알 수 없는 기운이 몸을 감싸 다음 공격의 위력을 15만큼 올린다. 대신 그 반동으로 공격에 취약해진다. \n쿨타임 : 4턴]", 0, 0, 0, 15);
						pDamage += s.plusAttack();
						mDamage += 10;
						System.out.println("[뭐든지 할 수 있을것만 같은 강대한 힘이 느껴집니다!]");
						skillAttack = false;
						battleLog();
					}
					else {
						break;
					}
					break;
				case 4:
					System.out.println("[따스한 빛으로 체력을 30만큼 회복한다.]");
					System.out.println("[스킬을 사용하시겠습니까? Y / N]");
					skillUse = scan.next();
					if(skillUse.equals("y")) {
						Skill s = new Skill("[강타]","[따스한 빛으로 체력을 30회복한다. \n쿨타임 : 5턴]", 0, 30, 0, 0);
						pHp += s.heal();
						if(pHp>100) pHp=100;
						System.out.println("[따스한 빛이 상처로 스며듭니다.]");
						skillAttack = false;
						battleLog();
					}
					else {
						break;
					}
					break;
				case 5:
					System.out.println("[전투 종료까지 데미지를 10만큼 줄여받는다.] \n[이 스킬은 전투당 1회만 사용할 수 있습니다.]");
					if(SpecialArmorUse = false) {
						System.out.println("[스킬을 사용하시겠습니까? Y / N]");
						skillUse = scan.next();
						if(skillUse.equals("y")) {
							Skill s = new Skill("[무형갑]","[전투 종료까지 데미지를 10만큼 줄여받는다. \n쿨타임 : 5턴]", 0, 0, 10, 0);
							System.out.println("[단단한 기운이 몸을 감싸는 것이 느껴집니다.]");
							armor += 10;
							skillAttack = false;
							battleLog();
						}
					}
					else if(SpecialArmorUse = true) System.out.println("[이미 무형갑을 사용하였습니다.]");
					else {
						break;
					}
					break;
				case 6:
					System.out.println("[모든 공격으로부터 벗어난다.]");
					System.out.println("[스킬을 사용하시겠습니까? Y / N]");
					skillUse = scan.next();
					if(skillUse.equals("y")) {
						Skill s = new Skill("[회피]","[모든 공격으로부터 벗어난다]", 0, 0, 99999, 0);
						SpecialArmor += s.defence();
						System.out.println("[루시는 유연하게 적의 공격을 회피했습니다.]");
						skillAttack = false;
						battleLog();
						SpecialArmor = 0;
					}
					else {
						break;
					}
					break;
				default:
					break;
				}
				// 실제 스킬을 사용한 효과가 적용된다.
				
				break;
			default:
				break;
				
			}
		}
	}
}
