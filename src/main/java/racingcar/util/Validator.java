package racingcar.util;

import java.util.ArrayList;

import racingcar.car.Car;

public class Validator {
	public static void carNameLength(String carName) {
		if (carName.length() > 5 || carName.length() < 1) {
			throw new IllegalArgumentException("자동차 이름은 한 글자 이상, 다섯 글자 이하로 입력되어야 합니다.");
		}
	}

	public static void onlyWhiteSpace(String carName) {
		if (carName.replaceAll(" ", "").length() == 0) {
			throw new IllegalArgumentException();
		}
	}

	public static void inputStartsWithComma(String input) {
		if (input.startsWith(",")) {
			throw new IllegalArgumentException("자동차는 ','로 구분되어야 하며 빈 문자열이어선 안됩니다.");

		}
	}

	public static void inputEndsWithComma(String input) {
		if (input.endsWith(",")) {
			throw new IllegalArgumentException("자동차는 ','로 구분되어야 하며 빈 문자열이어선 안됩니다.");
		}
	}

	public static void parsableToNumber(String input) {
		try {
			Integer.parseInt(input);
		} catch (Exception e) {
			throw new IllegalArgumentException("올바른 숫자를 입력해주세요");
		}
	}

	public static void numberIsOverZero(Integer num) {
		if (num < 1) {
			throw new IllegalArgumentException("시도 횟수는 1이상이어야 합니다.");
		}
	}

	public static void distinctNameOnly(ArrayList<Car> cars) {
		if (cars.size() != cars.stream().distinct().count()) {
			throw new IllegalArgumentException("자동차 이름이 중복되어선 안됩니다.");
		}
	}
}
