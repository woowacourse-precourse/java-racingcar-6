package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.util.RandomUtil;
import racingcar.validators.InvalidInputValidators;

public class Race {

	private final List<Car> cars = new ArrayList<>();
	private final InvalidInputValidators invalidInputValidators = new InvalidInputValidators();

	public Race(String[] carNames) {
		for (String name : carNames) {
			invalidInputValidators.validateCarName(name);
			cars.add(new Car(name));
		}
	}

	public void run() {
		for (Car car : cars) {
			int randomNumber = RandomUtil.getRandomNumber();
			car.move(randomNumber);
		}
	}

	public int getMaxRecord() {
		int max = 0;
		for (Car car : cars) {
			max = Math.max(car.getPosition(), max);
		}

		return max;
	}

	public List<Car> getCars() {
		return cars;
	}
}