package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import camp.nextstep.edu.missionutils.Console;
public class Function {
	
	public  boolean check() {
		int number= Randoms.pickNumberInRange(0,9);
		boolean result= false;
		
		if(number>=4) {
			result= true;
		}
		return result;
	}
	
	protected ArrayList<String> inputCarName() {
		System.out.println("경주할 자동차의 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
		String[] inputValue= Console.readLine().split(",");
		checkString(inputValue);
		
		ArrayList<String> carName= new ArrayList<String>(Arrays.asList(inputValue));
		
		return carName;
	}
	protected int inputNumber() {
		System.out.println("시도할 회수는 몇회인가요?");
		String inputValue= Console.readLine();
		checkNumber(inputValue);
		
		int number= Integer.parseInt(inputValue);
		
		return number;
	}
	
	protected Map<String, Integer> run(int count, ArrayList<String> carName) {
		Map<String, Integer> result= new LinkedHashMap<String, Integer>();
		for(String name:carName) {
			result.put(name,eachRun(count));
		}		
		return result;
	}
	protected int eachRun(int count) {
		int result= 0;
		for(int i= 0; i<count; i++) {
			if(check()) {
				result+=1;
			}
		}
		return result;
	}
	
	protected List<String> winners(Map<String, Integer> result) {
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

	protected void outputMove(Map<String, Integer> result) {
		System.out.println("실행 결과");
		Set<String> name= result.keySet();
		for(String key: name) {
			String printStr= key+" : " ;
			for(int i=0; i<result.get(key); i++) {
				printStr+="-";
			}
			System.out.println(printStr);
		}
		
	}	
	protected void outputWinners(List<String> winners) {
		System.out.println("최종 우승자 : "+ String.join(", ", winners));
	}
	
	private void checkString(String[] inputValue) {
		for(int i= 0; i<inputValue.length; i++) {
			if(inputValue[i].length()>5 || inputValue[i].getClass() != String.class) {
				throw new IllegalArgumentException();
			}
		}
	}
	private void checkNumber(String inputValue) {
		String RECEX="[0-9]+";
		if(!inputValue.matches(RECEX)) {
			throw new IllegalArgumentException();
		}
		
	}
}
