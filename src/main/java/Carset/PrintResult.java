package Carset;

import java.util.ArrayList;
import java.util.List;

public class PrintResult {
	private List<Car> cars;

	public PrintResult(List<String> carNames) {
		this.cars = new ArrayList<>();
		for (String carName : carNames) {
			cars.add(new Car(carName));
		}
	}

	public void Start() {
		System.out.println("실행 결과");
	}

	public void printStatus() {

		int number = CarFuctSet.inputNumber();

		Start();

		for (int i = 0; i < number; i++) {

			for (Car car : cars) {
				car.MoveCondition();
				printCarStatus(car);
			}
			System.out.println();
		}

		List<String> winners = determineWinners();
		printWinners(winners);

	}

	private void printCarStatus(Car car) {
		System.out.print(car.getName() + " : ");
		for (int i = 0; i < car.getDistance(); i++) {
			System.out.print("-");
		}
		System.out.println();
	}

	private List<String> determineWinners() {
		int maxDistance = 0;
		List<String> winners = new ArrayList<>();

		for (Car car : cars) {
			int distance = car.getDistance();

			if (distance > maxDistance) {
				maxDistance = distance;
				winners.clear();
				winners.add(car.getName());
			} else if (distance == maxDistance) {
				winners.add(car.getName());
			}
		}
		return winners;
	}

	private void printWinners(List<String> winners) {
		System.out.println("\n최종 우승자 : " + String.join(",", winners));
	}

}
