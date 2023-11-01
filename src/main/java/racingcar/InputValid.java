package racingcar;

import java.util.HashSet;
import java.util.Set;

public class InputValid {

	public static void names(String[] carNames) {

		Set<String> uniqueCarNames = new HashSet<>();

		for (int i = 0; i < carNames.length; i++) {

			String names = carNames[i];

			if (names.isEmpty()) {
				throw new IllegalArgumentException("이름을 입력해야해요.");
			}
			if (names.length() > 5) {
				throw new IllegalArgumentException("이름의 길이는 5자를 넘을 수 없어요.");
			}
			if (!uniqueCarNames.add(names)) {
				throw new IllegalArgumentException("중복된 이름은 입력할 수 없어요.");
			}
			if (names.startsWith(" ")) {
				throw new IllegalArgumentException("이름은 공백부터 시작할 수 없어요.");
			}

			uniqueCarNames.add(names);

		}
	}

	public static void count(int count) {

		if (count < 1) {
			throw new IllegalArgumentException("시행 횟수는 1이상이어야 해요.");
		}
	}

}
