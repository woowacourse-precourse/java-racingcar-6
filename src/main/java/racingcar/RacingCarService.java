package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class RacingCarService {

	public void playRacing() {
		System.out.println("경주할 자동차 이름을 입력하세요. " +
				"(이름은 쉼표(,) 기준으로 구분)");
		String carNames = Console.readLine();
		System.out.println(carNames);
		RegistCarInfo registCarInfo = new RegistCarInfo();
		List<String> racingCarNames = registCarInfo.registCarName(carNames);
		System.out.println("시도할 회수는 몇회인가요?");
		Integer tryCount = registCarInfo.registTryCount(Console.readLine());

		System.out.println("실행 결과");
		RacingResult racingResult = new RacingResult();
		racingResult.racingGame(racingCarNames, tryCount);
	}
}
