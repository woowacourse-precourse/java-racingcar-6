package racingcar.repository;

import java.util.List;

import racingcar.domain.Car;

public class GameRepository {
	private List<Car> cars;
	private Long maxForwardPosition = 0L;

	public void saveGame(List<Car> cars) {
		this.cars = cars;
	}

	public void moveForward(List<Car> forwardCars) {
		for (Car car : forwardCars) {
			car.moveForward();
			maxForwardPosition = Math.max(maxForwardPosition, car.getForwardCount());
			cars.set(cars.indexOf(car), car);
		}
	}

	public List<Car> findAll() {
		return cars;
	}

	public Long getMaxForwardPosition() {
		return maxForwardPosition;
	}
}
