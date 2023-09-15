package whiteCatLucy.option;

import java.util.Scanner;
import whiteCatLucy.map.*;

public class MoveMap {
	Select s = new Select();
	Alley alley = new Alley();
	InsideDarkForest forest = new InsideDarkForest();
	InsideHome home = new InsideHome();
	InsideJewelCave cave = new InsideJewelCave();
	InsideShineCloud cloud = new InsideShineCloud();
	Road road = new Road();
	public int result;
	public String key;
	public boolean event;
	
	
	Scanner scan = new Scanner(System.in);
	public int mapSelect;
	
	public void setKey() {
		UserSelect us = new UserSelect();
		us.setKey();
		key = us.key;
	}
	
	public int beforMove() {
		System.out.println("[이동하시겠습니까?]\n"
				+"[1.예] \r[2.아니요]");
		if(s.select() == true) {
			event = true; 
			System.out.println("[1.골목길]\r"
					+"[2.어두운 숲]\r"
					+"[3.집]\r"
					+"[4.보석동굴]\r"
					+"[5.빛나는 구름]\r"
					+"[6.길]");
			mapSelect = scan.nextInt();
			switch(mapSelect) {
			case 1:
				alley.alley();
				result = alley.result;
				
				break;
			case 2:	
				forest.darkForest();
				result = forest.result;
				
				break;
			case 3:
				home.home();
				result = home.result;
				
				break;
			case 4:
				cave.jewelCave();
				result = cave.result;
				
				break;
			case 5:
				cloud.shineCloud();
				result = cloud.result;
				
				break;
			case 6:
				road.road();
				result = road.result;
				
				break;
			default:
				break;
			}
		}
		else {
			event = false; 
		}
		return 0;		
	}
}
