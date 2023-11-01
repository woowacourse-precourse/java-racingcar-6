package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarUtils {

	public static Car createCar(String name) {
		return new Car(name);
	}

	public static List<Car> createCars(String carNames) {
		List<Car> cars = new ArrayList<>();
		String[] names = carNames.split(",");
		for (String name : names) {
			cars.add(createCar(name));
		}
		return cars;
	}

	public static String getWinner(List<Car> cars) {
		StringBuilder stringBuilder = new StringBuilder();
		int maxPosition = getMaxPosition(cars);
		for (Car car : cars) {
			if (car.getPosition() == maxPosition) {
				stringBuilder.append(car.getName());
				stringBuilder.append(", ");
			}
		}
		return stringBuilder.substring(0, stringBuilder.length()-2);
	}

	private static int getMaxPosition(List<Car> cars) {
		int maxPosition = 0;
		for (Car car : cars) {
			if (car.getPosition() > maxPosition) {
				maxPosition = car.getPosition();
			}
		}
		return maxPosition;
	}
}
