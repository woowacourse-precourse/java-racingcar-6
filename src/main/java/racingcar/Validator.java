package racingcar;

public class Validator {

	public static void validateCarCount(String input) {
		final String ERROR_MESSAGE = "[ERROR] 자동차의 이름을 쉼표(,)로 구분해 2개 이상 입력해 주세요. 예) pobi,woni";
		final String DELIMITER = ",";
		final int MIN_DELIMITER_COUNT = 1;

		int delimiterCount = input.length() - (input.replace(DELIMITER, "")).length();
		if (delimiterCount < MIN_DELIMITER_COUNT) {
			throw new IllegalArgumentException(ERROR_MESSAGE);
		}
	}
}
