package racingcar.domain.game.round;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.car.strategy.MoveStrategy;

public class Round {
	private final Cars cars;

	public Round(Cars cars) {
		this.cars = cars;
	}

	public Cars play(MoveStrategy moveStrategy) {
		List<Car> movedCars = new ArrayList<>();

		for (Car progressCar : cars.getCars()) {
			movedCars.add(progressCar.move(moveStrategy));
		}

		return new Cars(movedCars);
	}
}
