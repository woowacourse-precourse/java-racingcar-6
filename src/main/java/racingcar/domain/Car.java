package racingcar.domain;

import racingcar.constant.Rule;

public class Car {
	private final String name;
	private Position position;

	public Car(String name) {
		CarValidator.validateEachLength(name);
		this.name = name;
		this.position = new Position();
	}

	public void race() {
		if (isMovable(getRandomNumber())) {
			this.position.move();
		}
	}

	public void move() {
		this.position.move();
	}

	public int getPosition() {
		return position.getPosition();
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
}
