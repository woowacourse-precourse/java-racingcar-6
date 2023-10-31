package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

	private static final int MAX_CAR_NAME_LENGTH = 5;

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

		return tryCount;
	}


}
