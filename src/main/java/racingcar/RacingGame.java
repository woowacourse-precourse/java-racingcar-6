package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;

public class RacingGame {

	private static final int MAX_CAR_NAME_LENGTH = 5;

	public void start() {
		List<Car> racingCars = getRacingCars();
		int tryCount = getInputTryCount();

		System.out.println("실행 결과");
		for (int i = 0; i < tryCount; i++) {
			for (Car racingCar : racingCars) {
				racingCar.move();
			}
			printRacing(racingCars);
		}

		List<Car> winners = getWinners(racingCars);
		printWinners(winners);
	}

	private List<Car> getRacingCars() {
		String carNames = getInputCarNames();

		return Arrays.stream(carNames.split(","))
			.map(Car::new)
			.collect(Collectors.toList());
	}

	private String getInputCarNames() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		String carNames = Console.readLine();

		return carNames;
	}

	private int getInputTryCount() {
		System.out.println("시도할 회수는 몇회인가요?");
		int tryCount = Integer.parseInt(Console.readLine());
		System.out.println();

		return tryCount;
	}

	private void printRacing(List<Car> cars) {
		StringBuffer stringBuffer = new StringBuffer();

		for (Car car : cars) {
			System.out.println(car.getName() + " : " + carProgress(car.getPosition()));
		}
		System.out.println();
	}

	private String carProgress(int position) {
		return "-".repeat(position);
	}

	private List<Car> getWinners(List<Car> cars) {
		List<Car> winners = new ArrayList<>();

		int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0);

		for (Car car : cars) {
			if (car.getPosition() == maxPosition) {
				winners.add(car);
			}
		}

		return winners;
	}

	private void printWinners(List<Car> winners) {
		String winnerNames = winners.stream()
			.map(Car::getName)
			.collect(Collectors.joining(","));

		System.out.println("최종 우승자 : " + winnerNames);
	}

}
