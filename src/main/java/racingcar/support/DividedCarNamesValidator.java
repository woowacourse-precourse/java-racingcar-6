package racingcar.support;

import java.util.HashSet;
import java.util.List;

public class DividedCarNamesValidator {
	private static final int MIN_NAME_LENGTH = 1;
	private static final int MAX_NAME_LENGTH = 5;
	private static final int MIN_DIVIDED_COUNT = 1;

	private DividedCarNamesValidator() {
		throw new IllegalStateException();
	}

	public static void validate(String[] carsName) {
		validateCount(carsName);
		validateLength(carsName);
		validateDuplicated(carsName);
	}

	private static void validateCount(String[] carsName) {
		if (carsName.length <= MIN_DIVIDED_COUNT) {
			throw new IllegalArgumentException("자동차 이름은 2개 이상 입력해야합니다");
		}
	}
	private static void validateLength(String[] carsName) {
		for (String carName : carsName) {
			if (carName.length() > MAX_NAME_LENGTH || carName.trim().length() < MIN_NAME_LENGTH) {
				throw new IllegalArgumentException("자동차 이름은 1 ~ 5 글자로 입력해야합니다");
			}
		}
	}
	private static void validateDuplicated(String[] carsName) {
		HashSet<String> cars = new HashSet<>(List.of(carsName));

		if (cars.size() != carsName.length) {
			throw new IllegalArgumentException("자동차 이름이 중복되었습니다.");
		}
	}
}
