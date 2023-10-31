package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Winners {

	private final List<Car> winners;
	private final int maxPosition;

	public Winners(List<Car> cars) {
		validateCars(cars);
		this.maxPosition = getMaxPosition(cars);
		this.winners = getWinners(cars, maxPosition);
	}

	public int getMaxPosition() {
		return maxPosition;
	}

	public List<String> getWinners() {
		List<String> winnerNames = new ArrayList<>();
		for (Car car : winners) {
			winnerNames.add(car.getName());
		}
		return winnerNames;
	}

	private int getMaxPosition(List<Car> cars) {
		int maxPosition = 0;
		for (Car car : cars) {
			maxPosition = Math.max(maxPosition, car.getPosition());
		}
		return maxPosition;
	}

	private List<Car> getWinners(List<Car> cars, int maxPosition) {
		List<Car> winners = new ArrayList<>();
		for (Car car : cars) {
			if (car.getPosition() == maxPosition) {
				winners.add(car);
			}
		}
		return winners;
	}

	private void validateCars(List<Car> cars) {
		if (cars.isEmpty()) {
			throw new IllegalArgumentException();
		}
	}
}
