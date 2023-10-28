package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class RacingGame {
	public RacingGame() {
		start();
	}

	private void start() {
		String carNames = Console.readLine();
		String[] carArray = carNames.split(",");
	}
}
