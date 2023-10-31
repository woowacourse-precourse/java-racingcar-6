package racingcar.util;

import java.util.List;

import racingcar.domain.Car;

public class RacingCarUtilsForTest {
	public static List<Car> getRacingCar() {
		List<Car> carList = List.of(
			new Car("pobi"), new Car("woni"), new Car("jun")
		);

		List<Integer> randomNumberList = List.of(3, 4, 5);

		for (int i = 0; i < carList.size(); i++) {
			int randomNumber = randomNumberList.get(i);
			Car car = carList.get(i);

			if (isMovable(randomNumber)) {
				car.race(car);
			}
		}

		return carList;
	}

	public static boolean isMovable(int number) {
		return number >=4;
	}
}
