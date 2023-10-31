package Carset;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class CarFuctSet {
	 private int distance;
	 private static final String CAR_MARKER = "-";
	 
	 public CarFuctSet() {
		 this.distance = 0;
	 }
	
	 
	
	public int InputNumber() {
		System.out.println("시도할 회수는 몇회인가요?");
		String input = Console.readLine();
		int number = Integer.parseInt(input);
		
		return number;
		
	}
	
	
	public void MoveCondition() {
		int randomNumber = Randoms.pickNumberInRange(0,9);
		
		if(randomNumber >= 4) {
			distance ++;
		}
		
	}
	
	public int getDistance() {
		return distance;
	}
}
	

	    
	
	
	
	
	




