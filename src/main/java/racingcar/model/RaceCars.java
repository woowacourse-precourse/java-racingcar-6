package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class RaceCars {
	private final List<Car> raceCars;

	public RaceCars(List<Car> raceCars) {
		this.raceCars = raceCars;
	}

	public void movingCars() {
		for (Car car : raceCars) {
			car.moveCar();
		}
	}

	public List<Car> getRacingCars() {
		return raceCars;
	}

	public Integer getMaxDistance() {
		int maxDistance = Integer.MIN_VALUE;
		for (Car car : raceCars) {
			maxDistance = Math.max(maxDistance, car.getPosition());
		}
		return maxDistance;
	}

	public List<String> getWinnerNames(Integer maxDistance) {
		List<String> WinnerCarNames = new ArrayList<>();
		for (Car car : raceCars) {
			if (car.isWinner(maxDistance)) {
				WinnerCarNames.add(car.getName());
			}
		}
		return WinnerCarNames;
	}
}
