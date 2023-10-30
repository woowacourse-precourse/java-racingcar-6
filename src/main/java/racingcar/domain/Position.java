package racingcar.domain;

public class Position {
	private final int MOVE_SIZE = 1;
	private Integer position;

	public Position() {
		this.position = 0;
	}

	protected void move() {
		position+=MOVE_SIZE;
	}

	protected int getPosition() {
		return position;
	}
}
