package racingcar.model;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
	private final List<RacingCar> cars;

	public Cars(List<RacingCar> cars) {
		this.cars = cars;
	}

	public void moveForward() {
		cars.forEach(RacingCar::moveForward);
	}

	public List<RacingCar> getCars() {
		return Collections.unmodifiableList(cars);
	}

	private RacingCar getFirstPlaceCar(List<RacingCar> cars) {
		return cars.stream()
				.max(Comparator.comparingInt(RacingCar::getPosition))
				.get();
	}

	public List<RacingCar> getFirstPlaceCars() {
		RacingCar firstPlaceCar = getFirstPlaceCar(cars);
		return cars.stream()
				.filter(car -> car.getPosition() == firstPlaceCar.getPosition())
				.collect(Collectors.toList());
	}
}
