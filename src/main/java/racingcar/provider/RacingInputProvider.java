package racingcar.provider;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;

public class RacingInputProvider {

	public RacingInputProvider() {
	}

	public List<Car> getRacingCars() {
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

	public int getInputTryCount() {
		System.out.println("시도할 회수는 몇회인가요?");
		int tryCount = Integer.parseInt(Console.readLine());
		System.out.println();

		return tryCount;
	}

}
