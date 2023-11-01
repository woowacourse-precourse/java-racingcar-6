package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.CarName;
import racingcar.domain.CarRacing;
import racingcar.domain.TryTimes;
import racingcar.domain.Winner;
import racingcar.model.RacingcarModel;

public class RacingcarView {
	public static void start() {
		makeCarNames();
		askTryTimes();
		startRace();
		showResult();
	}

	public static void makeCarNames() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		String carName = Console.readLine();
		CarName.inputCarName(carName);
	}

	public static void askTryTimes() {
		System.out.println("시도할 횟수는 몇 회인가요?");
		String inputTimes = Console.readLine();
		RacingcarModel.tryTimes = TryTimes.checkTryTimes(inputTimes);
	}

	public static void startRace() {
		System.out.println("실행 결과");
		RacingcarModel.raceResult = CarRacing.playRace(RacingcarModel.carNames, RacingcarModel.tryTimes);
	}

	public static void showResult() {
		String result = Winner.compareCount(RacingcarModel.raceResult);
		System.out.println("최종 우승자 : " + result);
	}
}
