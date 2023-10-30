package racingcar.domain.car;


import racingcar.domain.generator.NumberGenerator;

public class Car {

	private Position position;
	private final CarName carName;

	public Car(Position position, CarName carName) {
		this.position = position;
		this.carName = carName;
	}

	public void move(MoveStrategy moveStrategy, NumberGenerator numberGenerator) {
		if (moveStrategy.canMove(numberGenerator)) {
			this.position = new Position(position.getPosition() + 1);
		}
	}

	public Position getPosition() {
		return position;
	}

	public CarName getCarName() {
		return carName;
	}
}
