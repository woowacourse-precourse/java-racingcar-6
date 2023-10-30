package racingcar;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Race {
	private List<Car> cars;

	public Race(List<String> carNamesList) {
		cars = new ArrayList<>();
		for (String name : carNamesList) {
			cars.add(new Car(name));
		}
	}

	public void run(int tries) {
		System.out.println("\n실행결과");
		for (int i = 0; i < tries; i++) {
			for (Car car : cars) {
				car.move();
			}
			RaceStatus();
		}
	}

	public void RaceStatus() {
		for (Car car : cars) {
			StringBuilder str = new StringBuilder(car.getName() + " : ");
			for (int k = 0; k < car.getPosition(); k++) {
				str.append("-");
			}
			System.out.println(str.toString());
		}
		System.out.println();
	}

	public void winnerPlayer() {
		int maxPosition = cars.stream().max(Comparator.comparing(Car::getPosition))
				.get().getPosition();
		List<String> winners = cars.stream().filter(car -> car.getPosition() == maxPosition)
				.map(car -> car.getName())
				.collect(Collectors.toList());
		System.out.println("최종 우승자 : " + String.join(", ", winners));
	}
}
