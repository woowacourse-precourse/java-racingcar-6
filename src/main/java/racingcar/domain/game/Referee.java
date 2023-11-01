package racingcar.domain.game;

import java.util.List;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarName;
import racingcar.domain.car.Cars;

public class Referee {

	private final Cars cars;


	public Referee(Cars cars) {
		this.cars = cars;
	}

	public List<CarName> pickWinners() {
		return cars.getTopCars().stream()
				.map(Car::getCarName)
				.toList();
	}
}
