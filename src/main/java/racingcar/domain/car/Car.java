package racingcar.domain.car;

public class Car {

	private int position;
	private final CarName carName;
	private final MoveState moveState;

	public Car(CarName carName, MoveState moveState) {
		this.position = 0;
		this.carName = carName;
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
