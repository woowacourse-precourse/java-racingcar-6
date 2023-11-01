package racingcar.provider;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;

public class RacingInputProvider {

	private static final int MAX_CAR_NAME_LENGTH = 5;

	public RacingInputProvider() {
	}

	public List<Car> getRacingCars() {
		String carNames = getInputCarNames();

		return Arrays.stream(carNames.split(","))
			.map(Car::new)
			.filter(car -> {
				if (car.getName().length() > MAX_CAR_NAME_LENGTH)
					throw new IllegalArgumentException("자동차 이름은 5글자가 최대입니다.");
				return true;
			})
			.collect(Collectors.toList());
	}

	private String getInputCarNames() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		String carNames = Console.readLine();

		return carNames;
	}

	public int getInputTryCount() {
		int tryCount;

		System.out.println("시도할 회수는 몇회인가요?");
		try {
			tryCount = Integer.parseInt(Console.readLine());
			if (tryCount <= 0) {
				throw new IllegalArgumentException("시도 횟수는 0 이상 정수만 가능합니다.");
			}
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("시도 횟수는 0 이상 정수만 가능합니다.");
		}
		System.out.println();

		return tryCount;
	}

}
