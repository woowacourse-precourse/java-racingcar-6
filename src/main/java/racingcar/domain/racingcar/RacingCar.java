package racingcar.domain.racingcar;

import racingcar.domain.enums.ValidationMsg;

import java.util.Optional;

public class RacingCar {
	private String carName;
	private Integer carPosition;

	public RacingCar(String carName) {
		validateCarName(carName);
		this.carName = carName;
		this.carPosition = 0;
	}

	private void validateCarName(String carName) {
		if (Optional.ofNullable(carName).map(String::trim).orElse("").isEmpty()) {
			throw new IllegalArgumentException(ValidationMsg.EMPTY_TYPE.getValue());
		}
	}

	public String getCarName() {
		return carName;
	}
}
