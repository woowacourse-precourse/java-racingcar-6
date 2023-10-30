package Carset;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class CarFuctSet {

	
	public int InputNumber() {
		System.out.println("시도할 회수는 몇회인가요?");
		String input = Console.readLine();
		int number = Integer.parseInt(input);
		
		return number;
		
	}
	
	
	
	public static boolean MoveCondition() {
		int randomNumber = Randoms.pickNumberInRange(0,9);
		
		if(randomNumber >=4) {
			return true;
		}
		return false;
		
	}
	
	public String ReturnAdvance() {
		MoveCondition();
		if(MoveCondition() ==true) return "-";
		return " ";
	}
	
	public void MoveAdvance(List<String> Carmove) {
		for(int i =0; i < Carmove.size(); i++) {
			
			System.out.println(Carmove.get(i) + ":" + ReturnAdvance() );
			
		}
		
	}
	
	
	
	
}



