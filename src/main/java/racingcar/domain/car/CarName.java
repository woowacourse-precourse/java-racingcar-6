package racingcar.domain.car;

import java.util.Objects;

public class CarName{

	private static final int MIN_LENGTH = 1;
	private static final int MAX_LENGTH = 5;
	private final String name;

	public CarName(String name) {
		validate(name);
		this.name = name.trim();
	}

	public String getName() {
		return name;
	}

	private void validate(String name) {
		if (name.length() < MIN_LENGTH || name.length() > MAX_LENGTH) {
			throw new IllegalArgumentException("자동차 이름 길이가 유효하지 않습니다.");
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass()!= o.getClass()) {
			return false;
		}
		CarName carName = (CarName) o;
		return Objects.equals(name, carName.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
}
