package racingcar;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class CarManger {
	private final List<Car> cars = new ArrayList<>();

	public void managedCar(String[] carNames) {
		for (String carName : carNames) {
			if(carName.length() >= 5) {
				throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
			}
			Car car = new Car(carName);
			cars.add(car);
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
}
