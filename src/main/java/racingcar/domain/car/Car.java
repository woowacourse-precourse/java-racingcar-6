package racingcar.domain.car;

public class Car {

	private int position;
	private final MoveState moveState;

	public Car(MoveState moveState) {
		this.position = 0;
		this.moveState = moveState;
	}

	public void move() {
		if (moveState.canMove()) {
			position++;
		}
	}

	public int getPosition() {
		return position;
	}
}
