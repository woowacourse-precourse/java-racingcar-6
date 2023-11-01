package racingcar.start;

import racingcar.controller.RacingCarController;

public class RacingCarGame {

	RacingCarController racingCarController = new RacingCarController();
	public void run() {
		racingCarController.startGame();
	}

}
