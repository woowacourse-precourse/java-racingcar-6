package racingcar.domain.car;

import java.util.List;

public class CarStorage {

	private static final int MIN_CAR_POSITION = 0;
	private final List<Car> cars;

	public CarStorage(List<Car> cars) {
		this.cars = cars;
	}

	public List<Car> getTopCars() {
		return cars.stream()
				.filter(car -> car.getPosition().equals(getMaxPosition()))
				.toList();
	}

	private Position getMaxPosition() {
		return cars.stream()
				.map(Car::getPosition)
				.max(Position::compareTo)
				.orElse(new Position(MIN_CAR_POSITION));
	}
}
