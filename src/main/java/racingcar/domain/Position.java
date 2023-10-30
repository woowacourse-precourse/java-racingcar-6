package racingcar.domain;

import racingcar.constant.Rule;

public class Position {
	private Integer position;

	public Position() {
		this.position = 0;
	}

	protected void move() {
		position += Rule.MOVE_SIZE;
	}

	protected int getPosition() {
		return position;
	}
}
