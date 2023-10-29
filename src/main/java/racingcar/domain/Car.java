package racingcar.domain;

public class Car {
	private final String name;
	private Position position;

	public Car(String name) {
		this.name = name;
		this.position = new Position();
	}
}
