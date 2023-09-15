package whiteCatLucy;

import whiteCatLucy.character.Lucy;
import whiteCatLucy.character.STATE;
import whiteCatLucy.event.IncidentEvent;
import whiteCatLucy.map.Alley;
import whiteCatLucy.map.InsideDarkForest;
import whiteCatLucy.map.InsideHome;
import whiteCatLucy.map.InsideJewelCave;
import whiteCatLucy.map.InsideShineCloud;
import whiteCatLucy.map.Road;
import whiteCatLucy.option.MoveMap;
import whiteCatLucy.option.Rest;
import whiteCatLucy.option.UserSelect;
import whiteCatLucy.script.MelyScript;
import whiteCatLucy.script.SystemScript;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Lucy lucy = new Lucy(0,0,0);
		SystemScript script = new SystemScript();
		MelyScript mely = new MelyScript();
		IncidentEvent ie = new IncidentEvent();
		UserSelect us = new UserSelect();
		
		//튜토리얼 스크립트
		mely.startScript();
		System.out.println("[튜토리얼을 시작하겠습니다. 아무 키나 입력하여 다음으로 넘어가주세요.]");
		String next = scan.next();
		script.tutoral();
		System.out.println("[다음은 플레이어의 행동에 관한 튜토리얼입니다.]\r[플레이어는 맵 이동, 배낭열기, 휴식하기의 행동을 선택할 수 있습니다.]\n\n");
		String next1 = scan.next();

		
		//bag, tendency실험
		//lucy.addItem("가방"); //good.
		//lucy.addTendency("활발한"); //good.
		//
		
		//게임 시작
		while(true) {
			us.item = lucy.getBag();
			us.userSelect();
			if(us.event == true) {
				ie.result = us.result;
				ie.incidentEvent();
			}
			System.out.println();
			lucy.addTendency(ie.tendencyKey);
			us.key = ie.tendencyKey;
			STATE statusChange = ie.statusUp();
			switch(statusChange) {
			case CAUTION:
				lucy.cautionUp(ie.cU);
				System.out.println("[루시의 주의력이 "+lucy.getCaution()+"이/가 되었다.]");
				break;
			case FULLNESS:
				lucy.fullnessUp(ie.fU);
				System.out.println("[루시의 포만감이 "+lucy.getFullness()+"이/가 되었다.]");
				break;
			case INTELLECT:
				lucy.intellectUp(ie.iU);
				System.out.println("[루시의 지능이 "+lucy.getIntellect()+"이/가 되었다.]");
				break;
			default:
				break;
			}
			System.out.println("[현재 루시의 상태]");
			System.out.println("[상태 : "+lucy.getTendency()+"]");
			System.out.println("[주의력 : "+lucy.getCaution()+"]");
			System.out.println("[포만감 : "+lucy.getFullness()+"]");
			System.out.println("[지능 : "+lucy.getIntellect()+"]");
			
		}
	}
	
}
