package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class TryTimes {
	public static int askTimes() {
		System.out.println("시도할 횟수는 몇 회인가요?");
		String inputTimes = Console.readLine();
		int tryTimes = Integer.parseInt(inputTimes);
		
		return tryTimes;
	}

}

class CarName {
	
	public static List<String> inputCarName() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		String carName = Console.readLine();
		String[] result = carName.split("[,]",0);
		carNameCheck(result);
		List<String> carNames = Arrays.asList(result);
		System.out.println(carNames);
		return carNames;
	}
	
	public static void carNameCheck(String[] str) {
		for (int i = 0; i < str.length; i++) {
			if(str[i].length() > 5) {
				throw new IllegalArgumentException();
			}
		}
	}
	
}

class CarRacing {
	public int resultCount = 0;
	public String result = "";
	
	public int carMove(String carNames) {
			String carName = carNames + " : ";
			int randomNumber = Randoms.pickNumberInRange(0,9);
//			System.out.println(randomNumber);
			if(randomNumber >= 4) {
				resultCount++;
				result += "-";	
			}
			System.out.println(carName + result);
			
//			System.out.println(resultCount);
			return resultCount;
		
	}
}

class Winner {
	public static void compareCount() { 
		List<Integer> resultCount = Arrays.asList(990,2000,2000,4000,9999,9999);
		int winnerPoint = Collections.max(resultCount);
		System.out.println(winnerPoint);
		
		List<Integer> winnerIndex = new ArrayList<Integer>();
		for (int i = 0; i < resultCount.size(); i++) {
			if (resultCount.get(i).equals(winnerPoint)) {
				System.out.println("우승자 인덱스 넘버" + i);
				winnerIndex.add(i);
				System.out.println(winnerIndex);
			}
		}		
	}
	
//	public void winnerPrint(String winners) {
//		List<String> winners = Arrays.asList(str);
//		String result = String.join(",", winners);
//		System.out.println("최종 우승자 : " + result);
//	}
}