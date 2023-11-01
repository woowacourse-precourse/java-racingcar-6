package racingcar.service;

import racingcar.domain.RacingStatus;

public class RacingCarService {

	public RacingStatus updateCarStatus(RacingStatus racingStatus) {
		racingStatus.updateCarStatus();
		return racingStatus;
	}

	public RacingStatus saveRacingCarStatus(String carNames, String tryNumber) {
		RacingStatus racingStatus = new RacingStatus(carNames, tryNumber);
		return racingStatus;
	}

}
