package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;

import camp.nextstep.edu.missionutils.Console;
public class Function {
	
	public static boolean check() {
		int number= Randoms.pickNumberInRange(0,9);
		boolean result= false;
		
		if(number>=4) {
			result= true;
		}
		return result;
	}
	
	public static ArrayList<String> inputCarName() {
		String[] inputValue= Console.readLine().split(",");
		ArrayList<String> carName= new ArrayList<String>(Arrays.asList(inputValue));
		
		return carName;
	}
	public static int inputNumber() {
		int number= Integer.parseInt(Console.readLine());
		
		return number;
	}
}
