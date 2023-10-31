package racingcar.util;

import java.util.List;

import racingcar.domain.Car;

public class RacingCarUtilForTest {
	public static List<Car> getRacingCar(List<Car> carList, List<Integer> randomNumberList) {
		for (int i = 0; i < carList.size(); i++) {
			int randomNumber = randomNumberList.get(i);
			Car car = carList.get(i);

			if (isMovable(randomNumber)) {
				car.move();
			}
		}

		return carList;
	}

	public static boolean isMovable(int number) {
		return number >=4;
	}
}
