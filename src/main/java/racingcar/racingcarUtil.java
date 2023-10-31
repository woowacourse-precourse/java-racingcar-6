package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;



class CarName {
	public static List<String> carNames = new ArrayList<>();
	public static List<String> inputCarName() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		String carName = Console.readLine();
		String[] result = carName.split("[,]",0);
		carNameCheck(result);
		carNames = Arrays.asList(result);
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

class TryTimes {
	public static int askTimes() {
		System.out.println("시도할 횟수는 몇 회인가요?");
		String inputTimes = Console.readLine();
		int tryTimes = Integer.parseInt(inputTimes);
		
		return tryTimes;
	}

}

class CarRacing {
	public int moveCount = 0;
	public String moveShow = "";
	
	public List<Integer> playRace(List<String> carNames, int tryTimes) {
		
		CarRacing[] car = new CarRacing[carNames.size()]; //입력된 자동차 갯수 만큼 객체 생성
		for (int j = 0; j < carNames.size(); j++) {
        	car[j] = new CarRacing();
		}
		
		for (int i = 0; i < tryTimes ; i++) {
			for (int j = 0; j < carNames.size(); j++) {
				car[j].carMove(carNames.get(j));
			}
			System.out.println("");
		}
		
		List<Integer> raceResult = new ArrayList<>();
		for (int j = 0; j < carNames.size(); j++) {
			raceResult.add(j, car[j].moveCount);
		}
		
		return raceResult;
	}
	
	public int carMove(String carNames) {
			String carName = carNames + " : ";
			int randomNumber = Randoms.pickNumberInRange(0,9);
			if(randomNumber >= 4) {
				moveCount++;
				moveShow += "-";	
			}
			System.out.println(carName + moveShow);
			return moveCount;
	}
}

class Winner extends CarName {
	public String compareCount(List<Integer> racingResult) {
		int winnerPoint = Collections.max(racingResult);
		
		List<Integer> winnerIndexNumber = new ArrayList<>();
		for (int i = 0; i < racingResult.size(); i++) {
			if (racingResult.get(i).equals(winnerPoint)) {
				winnerIndexNumber.add(i);
			}
		}
		return lastResult(winnerIndexNumber);
	}
	
	public static String lastResult(List<Integer> winnerIndexNumber) {
		List<String> winnerList = new ArrayList<>();
		for(int i = 0; i < winnerIndexNumber.size(); i++) {
			winnerList.add(carNames.get((winnerIndexNumber.get(i))));
		}
		
		String result = String.join(", ", winnerList);
		return result;
	}
}