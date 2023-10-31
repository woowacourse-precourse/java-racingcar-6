package racingcar.domain.racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.enums.NumberTypeGameRule;
import racingcar.domain.enums.ValidationMsg;

import java.util.Optional;

import static racingcar.domain.enums.NumberTypeGameRule.MIN_RAMDOM;

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

	public Integer getCarPosition() {
		return carPosition;
	}

	public void movingForward() {
		if (Randoms.pickNumberInRange(
				NumberTypeGameRule.MIN_RAMDOM.getValue(), NumberTypeGameRule.MAX_RAMDOM.getValue())
				>= NumberTypeGameRule.MOVING_FORWARD.getValue()
		) {
			this.movingForwardRacingCar();
		}
	}

	private void movingForwardRacingCar() {
		this.carPosition++;
	}
}
