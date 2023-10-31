package racingcar.domain.car;

public class Car {

	private final Position position;
	private final CarName carName;

	public Car(Position position, CarName carName) {
		this.position = position;
		this.carName = carName;
	}

	public Car move(MoveStrategy moveStrategy) {
		return new Car(this.position.add(moveStrategy.move()), this.carName);
	}

	public Position getPosition() {
		return position;
	}

	public CarName getCarName() {
		return carName;
	}
}
