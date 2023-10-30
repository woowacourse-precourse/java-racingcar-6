package racingcar.domain;

public class Car {
	private final String name;
	private Position position;

	public Car(String name) {
		this.name = name;
		this.position = new Position();
	}
	public String getName() {
		return name;
	}

	public void move() {
		position.move();
	}

	public int getCurrentPosition() {
		return position.getPosition();
	}
}
