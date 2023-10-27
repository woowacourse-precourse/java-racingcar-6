package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.util.RandomUtil;

public class Race {

	private final List<Car> cars = new ArrayList<>();

	public Race(String[] carNames) {
		for (String name : carNames) {
			cars.add(new Car(name));
		}
	}

	public void run() {
		for (Car car : cars) {
			int randomNumber = RandomUtil.getRandomNumber();
			car.move(randomNumber);
		}
	}

	public List<Car> getCars() {
		return cars;
	}
}