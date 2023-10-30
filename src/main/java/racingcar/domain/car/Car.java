package racingcar.domain.car;


public class Car {

	private Position position;
	private final CarName carName;
	private final MoveState moveState;

	public Car(Position position, CarName carName, MoveState moveState) {
		this.position = position;
		this.carName = carName;
		this.moveState = moveState;
	}

	public void move() {
		if (moveState.canMove()) {
			this.position = new Position(position.getPosition() + 1);
		}
	}

	public Position getPosition() {
		return position;
	}
}
