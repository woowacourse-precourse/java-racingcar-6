package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;

import camp.nextstep.edu.missionutils.Console;
public class Function {
	
	public static String check() {
		int number= Randoms.pickNumberInRange(0,9);
		String result= "";
		
		if(number>=4) {
			result= "-";
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
	public static void run(int count, ArrayList<String> carName) {
		for(String name:carName) {
			String result= name+" : ";
			for(int i=0; i< count; i++) {
				result+= check();
			}
			System.out.println(result);
		}
	}
}
