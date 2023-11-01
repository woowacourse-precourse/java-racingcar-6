package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import camp.nextstep.edu.missionutils.Console;

public class RacingCarGame {
	static final String DELIMITER = ",";
	int numberOfAttempts;
	int numberOfCars;
	List<Car> cars;

	public List<Car> getCarsFromInputString() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		String inputString = Console.readLine();

		if (inputString.isEmpty()) {
			throw new IllegalArgumentException("자동차 이름을 입력하여 주십시오.");
		}

		int numberOfDelimiter = (int)inputString.chars().filter(c -> c == DELIMITER.charAt(0)).count();
		List<String> carNames = Arrays.asList(inputString.split(DELIMITER));
		if (numberOfDelimiter + 1 != carNames.size()) {
			throw new IllegalArgumentException("자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능합니다.");
		}

		List<Car> cars = new ArrayList<>();
		Set<String> carNameSet = new HashSet<>(carNames.size());
		for (String carName : carNames) {
			if (carName.length() > 5) {
				throw new IllegalArgumentException("자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능합니다.");
			}
			if (carNameSet.contains(carName)) {
				throw new IllegalArgumentException("자동차 이름이 중복되었습니다.");
			}
			carNameSet.add(carName);
			cars.add(new Car(carName));
		}

		return cars;
	}
}
