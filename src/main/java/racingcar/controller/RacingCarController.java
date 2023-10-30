package racingcar.controller;

import racingcar.dto.request.CarNameReq;
import racingcar.dto.request.TryNumberReq;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class RacingCarController {

	CarNameReq carNameReq = new CarNameReq();
	TryNumberReq tryNumberReq = new TryNumberReq();

	public void saveCarName() {
		String carName = readLine();
	}

	private void getCarName(String carName) {
		carNameReq.setCarName(carName);
	}

	private void getTryNumber(int tryNumber) {
		tryNumberReq.setTryNumber(tryNumber);
	}
}
