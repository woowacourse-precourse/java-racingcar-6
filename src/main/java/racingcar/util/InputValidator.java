package racingcar.util;

public class InputValidator {
	public void isValidName(String userInput) {
		if (userInput == null || userInput.isEmpty()) {
			throw new IllegalArgumentException("자동차 이름이 입력되지 않음.");
		}
		if (userInput.contains(" ")) {
			throw new IllegalArgumentException("자동차 이름에 공백이 포함됨.");
		}
		if (userInput.length() > Constant.NAME_LENGTH_LIMIT) {
			throw new IllegalArgumentException("자동차 이름이 " + Constant.NAME_LENGTH_LIMIT + "자를 초과함.");
		}
	}

	public void isValidTryNumber(String userInput) {
		if (userInput == null || userInput.isEmpty()) {
			throw new IllegalArgumentException("시도 횟수가 입력되지 않음.");
		}
		if (Integer.parseInt(userInput) < 1) {
			throw new IllegalArgumentException("시도 횟수가 1보다 작음.");
		}
	}
}
