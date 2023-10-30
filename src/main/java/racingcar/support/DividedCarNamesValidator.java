package racingcar.support;

public class DividedCarNamesValidator {

	private static final int MIN_DIVIDED_COUNT = 1;

	private DividedCarNamesValidator() {
		throw new IllegalStateException();
	}

	public static void validate(String[] carsName) {
		validateCount(carsName);
	}

	private static void validateCount(String[] carsName) {
		if (carsName.length <= MIN_DIVIDED_COUNT) {
			throw new IllegalArgumentException("자동차 이름은 2개 이상 입력해야합니다");
		}
	}
}
