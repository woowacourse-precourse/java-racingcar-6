package racingcar.domain;

import racingcar.constant.Rule;

public class Car {
	private final String name;
	private Integer position;

	public Car(String name) {
		CarValidator.validateEachLength(name);
		this.name = name;
		this.position = 0;
	}

	public void race() {
		if (isMovable(getRandomNumber())) {
			move();
		}
	}

	public void move() {
		position += Rule.MOVE_SIZE;
	}

	public int getPosition() {
		return position;
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
