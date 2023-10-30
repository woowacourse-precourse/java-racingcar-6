package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCar {
	private List<Car> racingCarList;

	public RacingCar(InputCarName inputCarName) {
		CarValidator.validateLength(inputCarName.getCarNameList());
		this.racingCarList = createCarList(inputCarName);
	}

	public List<Car> getRacingCar() {
		return racingCarList;
	}

	private List<Car> createCarList(InputCarName inputCarName) {
		return inputCarName.getCarNameList().stream()
			.map(carName -> new Car(carName))
			.collect(Collectors.toList());
	}
}
