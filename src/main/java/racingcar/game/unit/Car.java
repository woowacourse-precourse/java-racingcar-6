package racingcar.game.unit;

import racingcar.game.message.ErrorMessage;

public class Car {

	private String name;
	private Engine engine;
	private int position;

	public static Car of(String name) {
		checkValidCarName(name);
		return new Car(
				name,
				0,
				Engine.newEngine());
	}

	private Car(String name, int position, Engine engine) {
		this.name = name;
		this.position = position;
		this.engine = engine;
	}

	private static void checkValidCarName(String carName) {
		if (carName.length() > 5) {
			throw new IllegalArgumentException(
					ErrorMessage.CAR_NAME_NOT_LONGER_THAN_5.getMessage());
		}
		if (carName.isBlank()) {
			throw new IllegalArgumentException(
					ErrorMessage.CAR_NAME_NOT_BLANK.getMessage());
		}
	}

	public void startEngine() {
		int power = engine.activate();
		if (power >= 4) {
			moveForward();
		}
	}

	private void moveForward() {
		position++;
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}
}