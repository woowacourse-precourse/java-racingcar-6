package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCar {
	private List<Car> racingCarList;

	public RacingCar(InputCarName inputCarName) {
		this.racingCarList = createCarList(inputCarName);
	}

	private List<Car> createCarList(InputCarName inputCarName) {
		return inputCarName.getCarNameList().stream()
			.map(carName -> new Car(carName))
			.collect(Collectors.toList());
	}
}
