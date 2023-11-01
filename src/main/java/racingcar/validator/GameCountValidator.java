package racingcar.validator;

import static racingcar.utils.GameConstants.*;

public class GameCountValidator {
	public static void checkGameCount(String gameCount) {
		isLowerZero(gameCount);
		isNumber(gameCount);
		isEmpty(gameCount);
	}

	private static void isLowerZero(String gameCount) {
		int tempGameCount = Integer.parseInt(gameCount);
		if (tempGameCount <= 0)
			throw new IllegalArgumentException(GAME_COUNT_LOWER_ZERO_ERROR);
	}

	private static void isNumber(String gameCount) {
		for (int i = 0; i < gameCount.length(); i++) {
			char tempGameCount = gameCount.charAt(i);
			if (!Character.isDigit(tempGameCount)) {
				throw new IllegalArgumentException(GAME_COUNT_NOT_DIGIT_ERROR);
			}
		}
	}
	
	private static void isEmpty(String gameCount) {
		if (gameCount.isEmpty()) {
			throw new IllegalArgumentException(GAME_COUNT_EMPTY_ERROR);
		}
	}

}
