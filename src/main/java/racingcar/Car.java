package racingcar;

public class Car {

	private int position;
	private final MoveSate moveState;

	public Car(MoveSate moveState) {
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
