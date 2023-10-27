package racingcar;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class CarManger {
	private final List<Car> cars = new ArrayList<>();

	public void managedCar(String[] carNames) {
		if(carNames.length > 5) {
			throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
		}
		for (String carName : carNames) {
			Car car = new Car(carName);
			cars.add(car);
		}
	}

	public void moveCar() {
		for (Car car : cars) {
			int i = Randoms.pickNumberInRange(0, 9);
			if(i >= 4) {
				car.foward();
			}
			System.out.println(car.getName() + " : " + car.getHistory());
		}
	}

	public List<String> findWinner() {
		List<String> winnerName = new ArrayList<>();
		int maxMovingDistance = maxPositon();
		for (Car car : cars) {
			if(maxMovingDistance == car.getPosition()) {
				winnerName.add(car.getName());
			}
		}
		return winnerName;
	}

	public int maxPositon() {
		int maxMovingDistance = 0;
		for (Car car : cars) {
			maxMovingDistance = Math.max(maxMovingDistance, car.getPosition());
		}
		return maxMovingDistance;
	}
}
