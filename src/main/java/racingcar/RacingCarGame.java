package racingcar;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class RacingCarGame {
	void start() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		String userInput = Console.readLine();

		List<Car> cars = checkCar(userInput);

		System.out.println("시도할 회수는 몇회인가요?");
		String InputLoop = Console.readLine();

		int loop = checkLoop(InputLoop);

		for (int i = 0; i < loop; i++) {
			cars.stream().forEach(Car::moveForward);
			cars.stream().forEach(Car::showDistance);
		}
	}

	private int checkLoop(String InputLoop) {
		int loop;

		try {
			loop = Integer.parseInt(InputLoop);
		} catch (NumberFormatException ex) {
			throw new IllegalArgumentException();
		}

		return loop;
	}

	private List<Car> checkCar(String userInput) {
		List<Car> cars = new ArrayList<>();
		List<String> carNames = List.of(userInput.split(","));

		for (int i = 0; i < carNames.size(); i++) {
			if (carNames.get(i).length() > 6) {
				throw new IllegalArgumentException();
			}

			cars.add(new Car(carNames.get(i)));
		}

		return cars;
	}
}
