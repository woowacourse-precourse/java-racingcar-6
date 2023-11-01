package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class CarName {
	public static List<String> carNames = new ArrayList<>();

	public static List<String> inputCarName(String carName) {
		String[] result = carName.split("[,]");
		carNameCheck(result);
		carNames = Arrays.asList(result);
		return carNames;
	}

	public static void carNameCheck(String[] str) {
		for (int i = 0; i < str.length; i++) {
			if (str[i].length() > 5) {
				throw new IllegalArgumentException();
			}
		}
	}
}

class TryTimes {
	public static int checkTryTimes(String inputTimes) {
		int tryTimes = 0;
		try {
			tryTimes = Integer.parseInt(inputTimes);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException();
		}
		return tryTimes;
	}
}

class CarRacing {
	public int moveCount = 0;
	public String moveShow = "";

	public static List<Integer> playRace(List<String> carNames, int tryTimes) {

		CarRacing[] carObject = new CarRacing[carNames.size()]; // 입력된 자동차 갯수 만큼 객체 생성
		for (int j = 0; j < carNames.size(); j++) {
			carObject[j] = new CarRacing();
		}

		for (int i = 0; i < tryTimes; i++) {
			for (int j = 0; j < carNames.size(); j++) {
				carObject[j].carMove(carNames.get(j));
			}
			System.out.println("");
		}

		List<Integer> raceResult = new ArrayList<>();
		for (int j = 0; j < carNames.size(); j++) {
			raceResult.add(j, carObject[j].moveCount);
		}
		return raceResult;
	}

	public int carMove(String carNames) {
		String carName = carNames + " : ";
		int randomNumber = Randoms.pickNumberInRange(0, 9);
		if (randomNumber >= 4) {
			moveCount++;
			moveShow += "-";
		}
		System.out.println(carName + moveShow);
		return moveCount;
	}
}

class Winner extends CarName {
	public static String compareCount(List<Integer> raceResult) {
		int winnerPoint = Collections.max(raceResult);

		List<Integer> winnerIndexNumber = new ArrayList<>();
		for (int i = 0; i < raceResult.size(); i++) {
			if (raceResult.get(i).equals(winnerPoint)) {
				winnerIndexNumber.add(i);
			}
		}
		return lastResult(winnerIndexNumber);
	}

	public static String lastResult(List<Integer> winnerIndexNumber) {
		List<String> winnerList = new ArrayList<>();
		for (int i = 0; i < winnerIndexNumber.size(); i++) {
			winnerList.add(carNames.get((winnerIndexNumber.get(i))));
		}

		String result = String.join(", ", winnerList);
		return result;
	}
}