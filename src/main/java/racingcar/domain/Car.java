package racingcar.domain;

import racingcar.constant.Rule;

public class Car {
	private final String name;
	private Position position;

	public Car(String name) {
		this.name = name;
		this.position = new Position();
	}

	public void race(Car car) {
		if (isMovable(getRandomNumber())) {
			car.position.move();
		}
	}

	private int getRandomNumber() {
		return RandomNumberFactory.createRandomNumber();
	}

	private boolean isMovable (int number) {
		return number >= Rule.MOVE_STANDARD;
	}

	public String getName() {
		return name;
	}

	public int getCurrentPosition() {
		return position.getPosition();
	}
}
