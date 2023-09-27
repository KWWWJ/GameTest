package whiteCatLucy.option;

import java.util.Scanner;
import whiteCatLucy.map.*;

public class MoveMap {
	//플레이어가 활동할 맵을 선택하는 클래스
	Scanner scanMap = new Scanner(System.in);
	//맵을 선택하는 스캐너
	Select s = new Select();
	//플레이어에게 선택을 진행할지, 혹은 돌아갈지를 선택하게하는 클래스
	Alley alley = new Alley();
	InsideDarkForest forest = new InsideDarkForest();
	InsideHome home = new InsideHome();
	InsideJewelCave cave = new InsideJewelCave();
	InsideShineCloud cloud = new InsideShineCloud();
	Road road = new Road();
	//6개의 맵 클래스를 새로 생성한다.
	public int result;
	//맵에서 받아온 result값을 대입해 main에 끌고간다.
	public boolean event;
	//이벤트를 진행할지에 대한 여부
	
	public void mapKey(String key) {
		
		alley.setKey(key);
		forest.setKey(key);
		home.setKey(key);
		cave.setKey(key);
		cloud.setKey(key);
		road.setKey(key);
//		System.out.println("mm 여기 키는 "+alley.getKey()); //key이동 실험
		//가지고 있는 성격을 key로 변경해 모든 맵에 설정한다.
	}
	
	public void beforMove() {
		System.out.println("[이동하시겠습니까?]\n"
				+"[1.예] \r[2.아니요]");
		if(s.select() == true) {
			//민약 플레이어가 맵으로 이동하는 것을 선택했다면 아래 코드를 실행한다.
			System.out.println("[이동할 맵을 선택해주세요.]");
			System.out.println("[1.골목길]\r"
					+"[2.어두운 숲]\r"
					+"[3.집]\r"
					+"[4.보석동굴]\r"
					+"[5.빛나는 구름]\r"
					+"[6.길]");
			String mapSelect = "7";
			mapSelect = scanMap.nextLine();
			//이동할 맵을 플레이어가 선택한다.
			switch(mapSelect) {
			case "1":
				alley.alley();
				result = alley.getResult();
				//해당 맵에서 일어날 수 있는 이벤트의 값만을 담은 result를 가져와 대입한다.
				//아래 모두 동일.
				break;
			case "2":	
				forest.darkForest();
				result = forest.getResult();
				break;
			case "3":
				home.home();
				result = home.getResult();
				break;
			case "4":
				cave.jewelCave();
				result = cave.getResult();
				break;
			case "5":
				cloud.shineCloud();
				result = cloud.getResult();
				break;
			case "6":
				road.road();
				result = road.getResult();
				break;
			default:
				break;
			}
		}
		else {
			result = 100;
		}
	}
}
