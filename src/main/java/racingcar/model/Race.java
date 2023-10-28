package racingcar.model;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constant.GameConfig;

public class Race {

	private final List<Car> cars;

	public Race(List<Car> cars) {
		this.cars = cars;
	}

	private void moveAllCarsForward(List<Car> cars) {
		int randomValue = 0;

		for (Car car : cars) {
			randomValue = Randoms.pickNumberInRange(GameConfig.RANDOM_MINIMUM_RANGE, GameConfig.RANDOM_MAXIMUM_RANGE);

			if (randomValue >= GameConfig.MINIMUM_NUMBER_FOR_FORWARD) {
				car.forward();
			}
		}
	}
}
