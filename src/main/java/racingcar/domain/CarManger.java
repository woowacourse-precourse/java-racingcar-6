package racingcar.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;

public class CarManger {
	private final List<Car> cars = new ArrayList<>();

	public void createCars(String[] carNames) {
		for (String carName : carNames) {
			validName(carName);
			Car car = new Car(carName);
			cars.add(car);
		}
	}

	private void validName(String carName) {
		if(carName.length() >= 5) {
			throw new IllegalArgumentException();
		}
	}


	public void moveCars() {
		cars.stream()
			.filter(car -> Randoms.pickNumberInRange(0, 9) >= 4)
			.forEach(Car::move);
	}

	public List<String> findWinner() {
		List<String> winnerName = new ArrayList<>();
		int maxMovingDistance = maxPositon();
		cars.stream()
			.filter(car -> maxMovingDistance == car.getPosition())
			.forEach(car -> winnerName.add(car.getName()));
		return winnerName;
	}

	private int maxPositon() {

		return cars.stream()
			.mapToInt(Car::getPosition)
			.max()
			.orElse(0);
	}

	public Map<String, StringBuilder> getPositionHistory() {
		Map<String, StringBuilder> moveLog = new HashMap<>();
		cars.forEach(car -> moveLog.put(car.getName(), car.getHistory()));
		return moveLog;
	}
}
