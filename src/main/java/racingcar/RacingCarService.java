package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class RacingCarService {

	private RegistCarInfo registCarInfo;

	public String playRacing() {
		System.out.println("경주할 자동차 이름을 입력하세요. " +
				"(이름은 쉼표(,) 기준으로 구분)");
		registCarInfo.registCarName(Console.readLine());
		System.out.println("시도할 회수는 몇회인가요?");
		registCarInfo.registTryCount(Console.readLine());

		return null;
	}
}
