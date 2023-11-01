package racingcar;

import java.util.ArrayList;
import java.util.List;

public class GameHelper {

	public static void raceGame(ArrayList<Car> cars) {

		for (int i = 0; i < cars.size(); i++) {
			Car car = cars.get(i);
			car.move();
		}
	}

	public static void printResult(ArrayList<Car> cars) {

		for (int i = 0; i < cars.size(); i++) {
			printCarPositions(cars);

		}
		System.out.println();
	}

	public static void printWinners(ArrayList<Car> cars) {

		List<String> winners = findWinners(cars);
		String winnersString = String.join(", ", winners);

		System.out.print("최종 우승자 : " + winnersString);

	}

	private static List<String> findWinners(ArrayList<Car> cars) {

		int maxPosition = 0;
		List<String> winners = new ArrayList<>();

		for (int i = 0; i < cars.size(); i++) {
			Car car = cars.get(i);

			if (car.getPosition() > maxPosition) {
				maxPosition = car.getPosition();
			}
		}

		for (int i = 0; i < cars.size(); i++) {
			Car car = cars.get(i);

			if (car.getPosition() == maxPosition) {
				winners.add(car.getName());
			}
		}
		return winners;

	}

	private static void printCarPositions(ArrayList<Car> cars) {

		for (int i = 0; i < cars.size(); i++) {
			Car car = cars.get(i);
			int position = car.getPosition();

			System.out.print(car.getName() + " : ");

			for (int j = 0; j < position; j++) {
				System.out.print("-");
			}

			System.out.println();
		}
	}

}
