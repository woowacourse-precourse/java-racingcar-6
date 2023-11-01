package racingcar;

import java.util.ArrayList;
import java.util.List;

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
		List<Car> racingCarList = new ArrayList<>();

		String carNames = getInputCarNames();

		for (String carName : carNames.split(",")) {
			racingCarList.add(new Car(carName));
		}

		return racingCarList;
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
			System.out.println(car.getName() + " : " + carProgress(stringBuffer, car.getPosition()));
		}
		System.out.println();
	}

	private String carProgress(StringBuffer stringBuffer, int position) {
		for (int i = 0; i < position; i++) {
			stringBuffer.append("-");
		}

		String carProgress = stringBuffer.toString();
		stringBuffer.delete(0, stringBuffer.length());

		return carProgress;
	}

	private List<Car> getWinners(List<Car> cars) {
		List<Car> winners = new ArrayList<>();

		int maxPosition = 0;
		for (Car car : cars) {
			if (car.getPosition() > maxPosition) {
				maxPosition = car.getPosition();
				winners.clear();
				winners.add(car);
			} else if (car.getPosition() == maxPosition) {
				winners.add(car);
			}
		}

		return winners;
	}

	private void printWinners(List<Car> winners) {
		List<String> winnerNameList = new ArrayList<>();

		for (Car winner : winners) {
			winnerNameList.add(winner.getName());
		}

		String winnerNames = String.join(",", winnerNameList);
		System.out.println("최종 우승자 : " + winnerNames);
	}

}
