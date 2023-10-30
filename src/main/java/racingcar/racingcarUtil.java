package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
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
	
	public void carMove(String carNames) {
			String carName = carNames + " : ";
			int randomNumber = Randoms.pickNumberInRange(0,9);
//			System.out.println(randomNumber);
			if(randomNumber >= 4) {
				resultCount++;
				result += "-";	
			}
			System.out.println(carName + result);
//			System.out.println(resultCount);
		
	}
}

class Winner {
	public void compareCount(List<String> list) { //객체들의 resultCount를 비교하여 가장 큰 값을 반환
		List<String> resultCount = list;
		String winner = Collections.max(list);
		winnerPrint(winner);
	}
	
	public void winnerPrint(String str) {
		List<String> winners = Arrays.asList(str);
		String result = String.join(",", winners);
		System.out.println("최종 우승자 : " + result);
	}
}