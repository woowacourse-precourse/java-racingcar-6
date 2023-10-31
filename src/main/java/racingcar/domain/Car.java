package racingcar.domain;

public class Car {
	public final String name;

	public int distance = 0;

	public Car(String name) {
		this.name = name;
	}

	public Car(String name, int distance) {
		this.name = name;
		this.distance = distance;
	}
}