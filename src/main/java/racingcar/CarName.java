package racingcar;

import java.util.Objects;

public class CarName {

	String name;

	public CarName(String carName) {
		validate(carName);
		name = carName;
	}

	private static void validate(String carName) {
		checkBlank(carName);
	}

	private static void checkBlank(String carName) {
		if (carName.isBlank()) {
			throw new IllegalArgumentException("이름을 입력해주세요.");
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof CarName carName1)) {
			return false;
		}
		return Objects.equals(name, carName1.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
}
