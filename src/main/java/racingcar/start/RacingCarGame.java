package racingcar.start;

import racingcar.controller.RacingCarController;
import racingcar.view.RacingCarView;

public class RacingCarGame {

	RacingCarController racingCarController = new RacingCarController();
	public void run() {
		racingCarController.startGame();
	}

}
