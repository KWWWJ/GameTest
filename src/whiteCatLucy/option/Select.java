package whiteCatLucy.option;

import java.util.Scanner;

public class Select {
	Scanner scan = new Scanner(System.in);
	public boolean select() {
		int input = scan.nextInt();
		if(input == 1) {
			return true;
		}
		return false;
	}
}
