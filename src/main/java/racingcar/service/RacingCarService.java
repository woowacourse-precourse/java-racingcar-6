package racingcar.service;

import java.util.List;
import racingcar.domain.RacingStatus;

public class RacingCarService {

	public void startRacingCarGame(String carNames, String tryNumber) {
		RacingStatus racingStatus = new RacingStatus(carNames, tryNumber);
		for (int i = 0; i < racingStatus.getTryNumber(); i++) {
			racingStatus.updateCarStatus();
		}
		List<String> maxValueFromCarStatus = racingStatus.findMaxValueFromCarStatus();
	}

}
