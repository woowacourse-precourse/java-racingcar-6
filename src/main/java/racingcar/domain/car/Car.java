package racingcar.domain.car;


public class Car {

	private Position position;
	private final CarName carName;

	public Car(Position position, CarName carName) {
		this.position = position;
		this.carName = carName;
	}

	public void move(MoveStrategy moveStrategy) {
		this.position = new Position(position.getPosition() + moveStrategy.move());
	}

	public Position getPosition() {
		return position;
	}

	public CarName getCarName() {
		return carName;
	}
}
