package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

public class RacingGame {
	CarNameValidator carNameValidator = new CarNameValidator();

	public RacingGame() {
		String[] cars = inputcarName();
		int tryCount = inputTryCount();
	}

	private String[] inputcarName() {
		String carNames = Console.readLine();
		String[] carArray = carNames.split(",");

		carNameValidator.validateCarName(carArray);

		return carArray;
	}

	private int inputTryCount() {
		String tryCount = Console.readLine();

		if (!Pattern.matches("^[0-9]+$", tryCount)) {
			throw new IllegalArgumentException("숫자만 입력하실 수 있습니다.");
		}

		return Integer.parseInt(tryCount);
	}
}
