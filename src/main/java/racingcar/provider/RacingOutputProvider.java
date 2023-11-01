package racingcar.provider;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.domain.Car;

public class RacingOutputProvider {

	public RacingOutputProvider() {
	}

	public void printRacingStart() {
		System.out.println("실행 결과");
	}

	public void printRacing(List<Car> cars) {
		for (Car car : cars) {
			System.out.println(car.getName() + " : " + carProgress(car.getPosition()));
		}
		System.out.println();
	}

	public void printWinners(List<Car> winners) {
		String winnerNames = winners.stream()
			.map(Car::getName)
			.collect(Collectors.joining(","));

		System.out.println("최종 우승자 : " + winnerNames);
	}

	private String carProgress(int position) {
		return "-".repeat(position);
	}

}
