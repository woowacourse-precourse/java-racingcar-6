package racingcar.model;

import racingcar.util.Constant;

public class RacingCar {
	private final String name;
	private int position = 0;

	public RacingCar(String name) {
		this.name = name;
	}

	public void moveForward() {
		if (RandomMoveGenerator.isMovable()) {
			position++;
		}
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}
}
