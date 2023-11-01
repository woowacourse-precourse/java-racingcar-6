package racingcar.service;

import java.util.List;
import racingcar.controller.RacingCarController;
import racingcar.domain.RacingStatus;
import racingcar.view.RacingCarView;

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
