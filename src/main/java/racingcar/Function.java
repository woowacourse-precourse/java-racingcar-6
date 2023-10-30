package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

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
	public static Map<String, Integer> run(int count, ArrayList<String> carName) {
//		map에 이름:횟수 저장후 출력메서드 따로 만들기
		Map<String, Integer> result= new LinkedHashMap<String, Integer>();
		for(String name:carName) {
			result.put(name,eachRun(count));
		}		
		return result;
	}
	public static int eachRun(int count) {
		int result= 0;
		for(int i= 0; i<count; i++) {
			if(check()) {
				result+=1;
			}
		}
		return result;
	}
	public static List<String> winners(Map<String, Integer> result) {
		Set<String> name= result.keySet();
		Object[] resultValue=  result.values().toArray();			
		int winValue= 0;
		for(int i= 0; i< resultValue.length; i++) {
			int temp= Integer.parseInt(resultValue[i].toString());
			if (winValue<temp) {
				winValue=temp;
			}
		}
		List<String> winners= new ArrayList<String>();
		for(String key: name) {
			if (result.get(key)==winValue) {
				winners.add(key);
			}
		}
		return winners;
	}

	public static void outputMove(Map<String, Integer> result) {
		Set<String> name= result.keySet();
		for(String key: name) {
			String printStr= key+" : " ;
			for(int i=0; i<result.get(key); i++) {
				printStr+="-";
			}
			System.out.println(printStr);
		}
		
	}
}
