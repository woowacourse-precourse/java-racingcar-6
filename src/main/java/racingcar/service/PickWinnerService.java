package racingcar.service;

import java.util.List;
import java.util.StringJoiner;

import racingcar.domain.Car;
import racingcar.domain.Cars;

public class PickWinnerService {

	public String printWinner(Cars cars) {
		StringJoiner strJoiner = new StringJoiner(", ");

		for (Car car : pickWinner(cars)) {
			strJoiner.add(car.getCarName());
		}

		return strJoiner.toString();
	}

	private List<Car> pickWinner(Cars cars) {
		int maxCarLocation = getMaxCarLocation(cars);

		return cars.getCars().stream()
						.filter(car -> car.getCarLocation() == maxCarLocation)
						.toList();
	}

	private int getMaxCarLocation(Cars cars) {
		return cars.getCars().stream()
						.mapToInt(Car::getCarLocation)
						.max()
						.getAsInt();
	}
}
