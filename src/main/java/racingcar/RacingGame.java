package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class RacingGame {
	CarNameValidator carNameValidator = new CarNameValidator();
	public RacingGame() {
		start();
	}

	private void start() {
		String carNames = Console.readLine();
		String[] carArray = carNames.split(",");

		carNameValidator.validateCarName(carArray);

	}
}
