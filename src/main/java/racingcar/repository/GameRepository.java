package racingcar.repository;

import java.util.List;

import racingcar.domain.Car;
import racingcar.dto.GameDto;

public class GameRepository {
	private List<Car> cars;
	private Long maxForwardPosition = 0L;

	public void saveGame(GameDto gameDto) {
		cars = gameDto.cars();
		maxForwardPosition = gameDto.roundCount();
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
