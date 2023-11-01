package racingcar;

import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class Application {
	static List<String> carNames;
	static int tryTimes;
	static List<Integer> raceResult;

	public static void main(String[] args) {
		makeCarNames();
		askTryTimes();
		startRace();
		showResult();
	}

	public static void makeCarNames() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		String carName = Console.readLine();
		carNames = CarName.inputCarName(carName);
	}

	public static void askTryTimes() {
		System.out.println("시도할 횟수는 몇 회인가요?");
		String inputTimes = Console.readLine();
		tryTimes = TryTimes.checkTryTimes(inputTimes);
	}

	public static void startRace() {
		System.out.println("실행 결과");
		raceResult = CarRacing.playRace(carNames, tryTimes);
	}

	public static void showResult() {
		String result = Winner.compareCount(raceResult);
		System.out.println("최종 우승자 : " + result);
	}
}
