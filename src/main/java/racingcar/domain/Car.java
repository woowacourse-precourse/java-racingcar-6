package racingcar.domain;

import java.util.Objects;

public class Car {
	private final String name;
	private Long forwardCount;

	public Car(String name) {
		this.name = name;
		this.forwardCount = 0L;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Car car = (Car)o;

		return Objects.equals(name, car.name);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(name);
	}

	public String getName() {
		return name;
	}

	public Long getForwardCount() {
		return forwardCount;
	}

	public void moveForward() {
		forwardCount++;
	}
}
